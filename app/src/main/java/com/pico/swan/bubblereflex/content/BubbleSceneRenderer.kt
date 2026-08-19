package com.pico.swan.bubblereflex.content

import com.pico.spatial.core.container.SpatialViewContent
import com.pico.spatial.core.ecs.*
import com.pico.spatial.core.ecs.resource.*
import com.pico.spatial.core.math.Color4
import com.pico.spatial.core.math.Vector3
import com.pico.swan.bubblereflex.domain.*

internal fun shouldShowTutorialBubbles(phase: GamePhase): Boolean =
    phase == GamePhase.TUTORIAL

class BubbleSceneRenderer {
    private val root = Entity().apply { setName("BubbleReflexRoot") }
    private val live = linkedMapOf<Int, BubbleVisual>()
    private val pool = mutableMapOf<BubbleKind, ArrayDeque<BubbleVisual>>()
    private val popBursts = PopBurstPool(BubbleGame.MAX_SCORE_FEEDBACK)
    private var appliedTheme = -1
    private val tutorial = BubbleKind.entries.mapIndexed { index, kind ->
        BubbleVisual.create(kind, "Tutorial_${kind.name}").apply {
            entity.components[TransformComponent::class.java]?.apply {
                setPosition(Vector3((index - 1) * 0.28f, 1.42f, -1.58f))
                setScaleVector(scale)
            }
        }
    }
    private var attached = false

    fun sync(content: SpatialViewContent, snapshot: GameSnapshot) {
        ensureAttached(content)
        if (appliedTheme != snapshot.themeIndex) {
            appliedTheme = snapshot.themeIndex
            (live.values + pool.values.flatten() + tutorial).distinct().forEach { it.applyTheme(appliedTheme) }
        }
        val showTutorial = shouldShowTutorialBubbles(snapshot.phase)
        tutorial.forEach { visual ->
            visual.entity.enabled = showTutorial
            visual.entity.components[TransformComponent::class.java]?.setScaleVector(if (showTutorial) visual.scale else Vector3.ZERO)
        }
        val ids = snapshot.bubbles.mapTo(mutableSetOf()) { it.id }
        live.keys.filterNot(ids::contains).toList().forEach { id ->
            live.remove(id)?.let { it.entity.enabled = false; pool.getOrPut(it.kind, ::ArrayDeque).addLast(it) }
        }
        snapshot.bubbles.forEach { bubble ->
            val visual = live[bubble.id] ?: pool[bubble.kind]?.removeFirstOrNull() ?: BubbleVisual.create(bubble.kind, "Pooled_${bubble.id}").also {
                content.addEntity(it.entity); root.addChild(it.entity)
            }
            live[bubble.id] = visual
            visual.applyTheme(appliedTheme)
            visual.entity.enabled = true
            visual.entity.components[TransformComponent::class.java]?.apply {
                setPosition(Vector3(bubble.position.x, bubble.position.y, bubble.position.z))
                setScaleVector(visual.scale)
            }
        }
        popBursts.sync(snapshot.scoreFeedback)
    }

    fun worldToScene(position: Vector3): Vec3? = if (attached) root.convertPositionFrom(position, null).let { Vec3(it.x, it.y, it.z) } else null

    fun worldRayToScene(origin: Vector3, direction: Vector3): Pair<Vec3, Vec3>? {
        if (!attached) return null
        val start = root.convertPositionFrom(origin, null)
        val end = root.convertPositionFrom(origin + direction, null)
        return Vec3(start.x, start.y, start.z) to Vec3(end.x-start.x, end.y-start.y, end.z-start.z)
    }

    fun destroy() {
        (live.values + pool.values.flatten() + tutorial).distinct().forEach(BubbleVisual::destroy)
        popBursts.destroy()
        root.destroy()
    }

    private fun ensureAttached(content: SpatialViewContent) {
        if (attached) return
        content.addEntity(root)
        tutorial.forEach { content.addEntity(it.entity); root.addChild(it.entity) }
        popBursts.attach(content, root)
        attached = true
    }
}

private class BubbleVisual private constructor(
    val kind: BubbleKind,
    val entity: Entity,
    private val mesh: MeshResource,
    private val material: PhysicallyBasedMaterial,
    val scale: Vector3,
) {
    fun destroy() { entity.destroy(); mesh.close(); material.close() }

    fun applyTheme(theme: Int) {
        val palette = when (kind) {
            BubbleKind.ORDINARY -> listOf(
                Color4(0.00f,0.76f,1.00f,1f),
                Color4(0.06f,0.72f,1.00f,1f),
                Color4(0.00f,0.68f,1.00f,1f),
            )
            BubbleKind.GOLD -> listOf(
                Color4(1.00f,0.96f,0.00f,1f),
                Color4(1.00f,0.94f,0.00f,1f),
                Color4(0.98f,1.00f,0.00f,1f),
            )
            BubbleKind.GRAY -> listOf(
                Color4(0.04f,0.05f,0.07f,1f),
                Color4(0.08f,0.07f,0.04f,1f),
                Color4(0.03f,0.06f,0.09f,1f),
            )
        }
        val color = palette[theme.coerceIn(palette.indices)]
        material.setBaseColor(color)
        if (kind == BubbleKind.GOLD) {
            // A yellow emission floor keeps the single gold sphere saturated under
            // the emulator room's warm PBR lighting without adding an outer film.
            material.setEmissiveColor(Color4(0.42f, 0.40f, 0.00f, 1f))
        }
    }

    companion object {
        fun create(kind: BubbleKind, name: String): BubbleVisual {
            val sphere = sphereGeometry(20, 13)
            val positions = sphere.first
            val indices = sphere.second
            val normals = positions.toList()
            val mesh = MeshResource.createWithMeshModel(MeshModel(positions, indices, normals), BoundingBox(Vector3.ZERO, Vector3(1f,1f,1f)), "${name}_mesh")
            val material = PhysicallyBasedMaterial.create(
                if (kind == BubbleKind.GOLD) BlendingMode.OPAQUE else BlendingMode.FADE
            ).apply {
                setBaseColor(when (kind) {
                    BubbleKind.ORDINARY -> Color4(0.02f,0.62f,0.96f,1f)
                    BubbleKind.GOLD -> Color4(1f,0.96f,0.00f,1f)
                    BubbleKind.GRAY -> Color4(0.18f,0.24f,0.30f,1f)
                })
                setOpacity(if (kind == BubbleKind.GOLD) 1.00f else 0.80f)
                setMetallic(if (kind == BubbleKind.GOLD) 0.00f else 0.02f)
                setRoughness(if (kind == BubbleKind.GOLD) 0.20f else 0.22f)
                if (kind == BubbleKind.GOLD) setEmissiveColor(Color4(0.42f,0.40f,0.00f,1f))
                setDepthWrite(kind == BubbleKind.GOLD)
                setCullingMode(MaterialCullingMode.NONE)
            }
            val scale = when (kind) {
                BubbleKind.ORDINARY -> Vector3(0.13f,0.13f,0.13f)
                BubbleKind.GOLD -> Vector3(0.165f,0.165f,0.165f)
                BubbleKind.GRAY -> Vector3(0.145f,0.145f,0.145f)
            }
            val entity = Entity().apply {
                setName(name)
                components.set(ModelComponent(mesh, material))
            }
            return BubbleVisual(kind, entity, mesh, material, scale)
        }

        fun sphereGeometry(segments: Int, rings: Int): Pair<List<Vector3>, List<Int>> {
            val positions = ArrayList<Vector3>((segments + 1) * (rings + 1))
            val indices = ArrayList<Int>(segments * rings * 6)
            for (ring in 0..rings) {
                val latitude = Math.PI * ring / rings
                val y = kotlin.math.cos(latitude).toFloat()
                val radius = kotlin.math.sin(latitude).toFloat()
                for (segment in 0..segments) {
                    val longitude = Math.PI * 2.0 * segment / segments
                    positions += Vector3(
                        (kotlin.math.cos(longitude) * radius).toFloat(), y,
                        (kotlin.math.sin(longitude) * radius).toFloat(),
                    )
                }
            }
            for (ring in 0 until rings) for (segment in 0 until segments) {
                val a = ring * (segments + 1) + segment
                val b = a + segments + 1
                indices += listOf(a, b, a + 1, a + 1, b, b + 1)
            }
            return positions to indices
        }
    }
}

/** Six fixed burst slots keep contact feedback allocation-free during play. */
private class PopBurstPool(slotCount: Int) {
    private val sphere = BubbleVisual.sphereGeometry(8, 6)
    private val mesh = MeshResource.createWithMeshModel(
        MeshModel(sphere.first, sphere.second, sphere.first.toList()),
        BoundingBox(Vector3.ZERO, Vector3(1f, 1f, 1f)),
        "BubblePopParticleMesh",
    )
    private val slots = List(slotCount) { PopBurstSlot.create(it, mesh) }

    fun attach(content: SpatialViewContent, root: Entity) {
        slots.flatMap { it.particles }.forEach { particle ->
            content.addEntity(particle)
            root.addChild(particle)
        }
    }

    fun sync(feedback: List<ScoreFeedback>) {
        val bySlot = feedback.filter { it.popped }.associateBy { it.slot }
        slots.forEach { slot -> slot.sync(bySlot[slot.slot]) }
    }

    fun destroy() {
        slots.forEach(PopBurstSlot::destroy)
        mesh.close()
    }
}

private class PopBurstSlot private constructor(
    val slot: Int,
    val particles: List<Entity>,
    private val material: PhysicallyBasedMaterial,
) {
    fun sync(feedback: ScoreFeedback?) {
        val visible = feedback != null && feedback.progress < 0.62f
        if (!visible) {
            particles.forEach { it.enabled = false }
            return
        }
        feedback ?: return
        val color = when (feedback.kind) {
            BubbleKind.ORDINARY -> Color4(0.06f, 0.78f, 1.00f, 1f)
            BubbleKind.GOLD -> Color4(1.00f, 0.92f, 0.02f, 1f)
            BubbleKind.GRAY -> Color4(0.62f, 0.68f, 0.74f, 1f)
        }
        material.setBaseColor(color)
        material.setEmissiveColor(when (feedback.kind) {
            BubbleKind.ORDINARY -> Color4(0.04f, 0.24f, 0.34f, 1f)
            BubbleKind.GOLD -> Color4(0.42f, 0.30f, 0.00f, 1f)
            BubbleKind.GRAY -> Color4(0.07f, 0.08f, 0.10f, 1f)
        })
        val distance = 0.035f + 0.23f * feedback.progress
        val particleScale = (0.030f * (1f - feedback.progress / 0.62f)).coerceAtLeast(0.004f)
        particles.forEachIndexed { index, entity ->
            val direction = DIRECTIONS[index]
            entity.enabled = true
            entity.components[TransformComponent::class.java]?.apply {
                setPosition(
                    Vector3(
                        feedback.position.x + direction.x * distance,
                        feedback.position.y + direction.y * distance,
                        feedback.position.z + direction.z * distance,
                    ),
                )
                setScaleVector(Vector3(particleScale, particleScale, particleScale))
            }
        }
    }

    fun destroy() {
        particles.forEach(Entity::destroy)
        material.close()
    }

    companion object {
        private val DIRECTIONS = listOf(
            Vector3(-0.92f, 0.34f, 0.18f),
            Vector3(0.90f, 0.38f, 0.14f),
            Vector3(-0.25f, 0.96f, -0.12f),
            Vector3(0.18f, -0.82f, 0.36f),
            Vector3(0.12f, 0.20f, -0.97f),
        )

        fun create(slot: Int, mesh: MeshResource): PopBurstSlot {
            val material = PhysicallyBasedMaterial.create(BlendingMode.FADE).apply {
                setBaseColor(Color4(1f, 1f, 1f, 1f))
                setEmissiveColor(Color4(1f, 1f, 1f, 1f))
                setOpacity(0.92f)
                setRoughness(0.18f)
                setDepthWrite(false)
                setCullingMode(MaterialCullingMode.NONE)
            }
            val particles = DIRECTIONS.indices.map { index ->
                Entity().apply {
                    setName("Pop_${slot}_$index")
                    enabled = false
                    components.set(ModelComponent(mesh, material))
                }
            }
            return PopBurstSlot(slot, particles, material)
        }
    }
}
