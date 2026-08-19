# 视觉系统规格 · BubbleReflexLab v3

> revision: 2 · roles: `spatial_visual_designer` + `spatial_design_system_designer` · Stages8+11 · sources: interaction5 + pm3 + uxr2 + critique6 · approved reference V1 preserved

## 1. Visual intent and evidence boundary

The selected concept is `静水花窗 / Stillwater Aperture`: a calm, calibrated forward aperture converges actors into one hand-height interaction band. The visual task is to make safety extent, action verb, depth arrival and stillness legible without lanes, walls, neon spectacle, dashboard stacks or speed pressure. Competitive visuals in UXR2 §3A are observation-only: incoming readability and redundant silhouettes are absorbed as needs; track geometry, rails, pose walls, show lighting, composition, palettes and component forms are not reused. `templateReuse=false`.

Semantic adjectives: `calm`, `breathing`, `precise`, `kind`, `truthful`. Physical metaphor: light seen through a water-polished aperture, not a portal, tunnel, track or target range. Information density stays sparse: one present-tense verb near the active actor; all system detail remains secondary.

## 2. Spatial visual direction candidates

| Direction | Spatial thesis | First-view composition | Container relationships | Depth plan | Information hierarchy | Interaction cues | Spatial value | Dashboard risk | Preview/render instruction |
|---|---|---|---|---|---|---|---|---|---|
| V1 · 水光刻窗 | A thin, incomplete luminous contour reveals only the legal forward fan; actors appear as isolated forms within it and converge on a soft horizontal hand band. | Shared Planar start shows three large verb seals around one Start control; after explicit entry, Full-Space first view is one open center, a low-opacity aperture contour at medium depth, and a short hand-height band—no panels surrounding the user. | One Planar setup/result window precedes and follows the Stage. In Stage, only an inline calm status line and pause affordance accompany world actors; neither becomes an attachment. | Far source contour 2.2–3.2 m relative design range → sparse approach volume → calibrated band 0.45–0.8 m; background remains static and non-directional. | 1 actor silhouette+verb; 2 interaction band; 3 remaining time/segment; 4 input/source status; atmosphere last. | Ordinary has faceted ring + `拍`; gold has claspable double-loop + `抓`; gray has matte dashed halo + `别碰`. Band softly brightens only when an eligible actor enters. | Shows legal direction, distance-to-band and no-touch passage in the same field while preserving open space. | Low: no grid of metrics, no persistent card wall, no score during action. | Render a quiet forward aperture made of separated short strokes; one actor dominates; keep at least 55% central negative space; no vanishing-point rails or tunnel walls. |
| V2 · 浮签浅庭 | Three paper-like semantic tags float at different shallow depths, and each arriving actor temporarily aligns with the matching tag before reaching a small shared pad. | First Stage view contains three labeled tags above a centered interaction pad, with actors emerging behind their related tag. | Setup window visually echoes the tags; Stage repeats them as spatial signposts; result returns to a three-column summary. | Three shallow shelves at 1.4/1.8/2.2 m, then a common 0.6 m pad. | Category tags dominate before the actor; current actor second; time third. | Tag tilts toward the actor; pad changes outline by expected action. | Depth shelves aid teaching, but category-to-depth risks becoming a hidden lane code. | Medium-high: tags become persistent cards; result trends toward three-column dashboard. | Render three asymmetric suspended labels with paper texture and one central pad; never draw rails between them. |
| V3 · 雾珠潮汐 | A soft field of mist reveals depth only around the active actor; the interaction band appears as a brief local ripple instead of a persistent boundary. | Stage opens almost empty; a single distant glint condenses into the tutorial actor, and each arrival leaves a fading ripple at hand height. | Shared Planar setup uses a full-bleed fog illustration; Stage removes all persistent UI except time text and pause. | Depth is conveyed by scale, occlusion haze and local ripple; no visible source boundary. | Actor first by a wide margin; verb cue second; system state nearly absent. | Local mist clears around reachable actor; successful stillness produces a quiet expanding ring. | Strong calmness and depth atmosphere, but weak proof of legal spawn extent and calibration. | Low dashboard risk, high ambiguity risk on bright/complex environments. | Render sparse volumetric haze and one high-contrast actor; do not show a fixed frame; test both dark and passthrough-like backgrounds. |

These directions differ in organization and information topology: V1 exposes one calibrated safety aperture, V2 organizes categories through three persistent shallow-depth signposts, and V3 hides structure in an actor-local atmospheric field. They are not palette variants.

## 3. Structured design-effect review

Scores are comparative 1–5 judgments, not device evidence and not the quality-gate rubric.

| criterion | V1 水光刻窗 | V2 浮签浅庭 | V3 雾珠潮汐 | evidence / decision |
|---|---:|---:|---:|---|
| three-rule one-glance distinction | 5 | 5 | 4 | V1/V2 retain verb+shape; V3 haze may lower contrast |
| forward-only safety visibility | 5 | 3 | 2 | V1 alone makes the calibrated legal extent visible without rails |
| depth and hand-band timing | 5 | 4 | 4 | all show depth; V2 adds categorical depth coding; V1 keeps one band |
| no-touch as stillness | 5 | 4 | 5 | V1/V3 preserve open passage; V2 pad suggests every actor needs action |
| comfort / low-pressure character | 5 | 4 | 5 | V1/V3 remain sparse; V2 persistent tags add scanning |
| environment readability | 4 | 5 | 2 | V3 depends heavily on controllable contrast; V1 needs a bounded backing strategy |
| dashboard / competitor-cliché avoidance | 5 | 3 | 5 | V2 risks card/column repetition; none reuse tracks or walls |
| implementation clarity | 5 | 4 | 2 | V1 has explicit boundaries and stable layers; V3 relies on subtle volumetrics |
| total /40 | 39 | 32 | 29 | V1 selected |

Design-effect verdict: `pass` for V1 as the approved visual reference. It best exposes the safety contract, one interaction band and calm negative space while keeping category semantics independent of color. Approval is structured design-effect review only; aesthetic and physical comfort remain `not_device_validated`.

## 4. Approved visual reference: V1 · 水光刻窗

- **Composition invariant**: one forward aperture, one horizontal hand band, one dominant actor decision; no encircling content or vanishing-point corridor.
- **Depth invariant**: source contour is visually distant, actor approaches slowly, band is fixed to calibration; no face-near spawn or overhead cue.
- **Semantic invariant**: ordinary=`faceted ring + 拍`, gold=`double-loop clasp + 抓`, gray=`matte dashed halo + 别碰`; theme switches may recolor ambience but never these shapes or verbs.
- **Hierarchy invariant**: active decision > safety band > time/segment > input state > decoration. During pause, freeze seal and recovery choices replace game emphasis.
- **Motion invariant**: separated contour strokes breathe at a long cycle; actors drift without acceleration; boundary theme changes crossfade only. Reduce Motion removes breathing and nonessential trails while preserving position and verdict cues.
- **Container invariant**: Shared Planar UI is stable and readable; Full-Space Stage contains spatial play only. No Toolbar, TabBar, Subwindow or decorative attachment is implied.
- **Preview instruction**: approximate the Stage in a perspective-safe flat Web canvas with explicit source contour, band, actor depth/scale and semantic shapes; label all Web-only approximations. Never claim device FOV, comfort, tracking or runtime parity.

## 5. Rejected visual directions

- **V2 浮签浅庭 rejected**: three persistent signposts turn semantics into spatial lanes, increase scanning and pull the result toward a three-column dashboard. It conflicts with one-band stillness even though its labels are readable.
- **V3 雾珠潮汐 rejected**: atmosphere is calm but hides the legal spawn envelope and depends on uncontrolled-background contrast. Subtle haze would be fragile in preview and Shared/MR conditions.

## 6. Stage8 completeness

Three materially distinct spatial visual directions cover first view, container relationships, depth, hierarchy, cues, spatial value, dashboard risk and render instructions. UXR2 competitor visuals are used only to identify readability needs and clichés to avoid. V1 is selected through a documented structured design-effect review; later tokens, components and data contracts must follow V1 and may not invent a new direction.

Stage8 checkpoint only: final document completeness is evaluated in §15 after Stage11.

## 7. Implementable visual language

### 7.1 Tokens

| token | value | semantics / use |
|---|---|---|
| `brandPrimary` | `#9BE7DE` | calm water-light identity; non-semantic ambient accent |
| `accent` | `#F5C76B` | focused primary action; never category-only meaning |
| `surface` | `#102A33` | stable dark backing |
| `surfaceRaised` | `#173A44` | focused Planar panel |
| `textPrimary` | `#F6FAF8` | primary text |
| `textSecondary` | `#BBD0CE` | supporting copy |
| `focusStroke` | `#FFFFFF` | focus outline with shape/scale |
| `danger` | `#FF8F82` | destructive action with square icon + copy |
| `ambient0..5` | `#8FD8D1/#F1D2A2/#A9DFC7/#C9BDEB/#F0B3A7/#92A8D1` | six 30s ambient layers only; not category semantics |
| `scrim` | `#061217CC` | pause/confirmation focus |

### 7.2 Typography

| role | family | size | line | weight |
|---|---|---:|---:|---:|
| display | sans | 48sp | 56sp | 700 |
| title | sans | 32sp | 40sp | 650 |
| metric | mono | 40sp | 48sp | 700 |
| body | sans | 18sp | 28sp | 500 |
| action | sans | 18sp | 24sp | 650 |
| caption | sans | 14sp | 20sp | 500 |

### 7.3 `colorSemantics` dual channel

| semantic key | color | shape | visible label | description | aliases[] |
|---|---|---|---|---|---|
| `ordinary` | `#77D6E7` | circle | `普通泡泡·拍` | faceted circular ring + verb | `ordinary,normal,普通,拍` |
| `gold` | `#F5C451` | diamond | `金色泡泡·抓` | paired diamond loops + verb | `gold,金色,抓` |
| `gray` | `#A9B0B5` | dashed | `灰色泡泡·别碰` | matte dashed halo + verb | `gray,grey,灰色,别碰,避开` |
| `success` | `#77D6A0` | circle | `成功` | completed valid judgment | `success,correct,成功,已完成` |
| `attention` | `#F3A66A` | triangle | `请留意` | recoverable condition | `warning,attention,请留意,需调整` |
| `blocked` | `#FF8F82` | square | `不可继续` | unsafe/invalid prerequisite | `blocked,error,invalid,不可继续,失败` |
| `frozen` | `#8FB6E8` | dashed | `已暂停` | valid atomic FreezeSeal | `frozen,paused,已暂停,冻结` |
| `partial` | `#C6A8E8` | triangle | `统计不完整` | incomplete/conflicting settlement | `partial,conflicting,统计不完整,冲突` |
| `unknown` | `#D7DEDC` | diamond | `暂无数据` | absent/unreadable value | `unknown,null,暂无数据,未知` |

### 7.4 Materials and scale

| material | description | treatment | glassStyle | opacity |
|---|---|---|---|---:|
| `deskShell` | Shared-space primary reading shell | glass | Thickest | 0.94 |
| `localFocus` | focused in-window short workflow | glass | Thick | 0.90 |
| `actionMatte` | high-contrast control fill | matte | none | 1.00 |
| `stageBacking` | small solid backing behind Stage text/status; glass prohibited in Stage | opaque | none | 0.86 |
| `actorSurface` | opaque semantic actor material | opaque | none | 1.00 |

| scale | tier → value | use |
|---|---|---|
| spacing | `xxs 4 / xs 8 / s 12 / m 16 / l 24 / xl 32 / xxl 48dp` | inset/gap |
| radius | `s 12 / m 20 / l 32dp` | control/card/window; window fixed 32dp |
| iconSize | `s 20 / m 28 / l 40dp` | status/action/hero symbol |
| stroke | `hair 1 / normal 2 / focus 3dp` | contour/focus |
| hitTarget | `min 56 / comfortable 64 / hero 72dp` | all actions |

### 7.5 Environment adaptation

- Planar body text is ≥18sp (above 12dp floor), uses `deskShell Thickest`; key actions use `actionMatte`, never glass+custom color together.
- In Stage Mixed/passthrough, C6/C7 text uses `stageBacking #102A33` at 0.86; Stage never relies on glass. Actor shapes and verbs preserve semantics on bright/dark backgrounds.
- Vibrant applies only to monochrome Planar title/icon layers at `light` tier and terminates at any gradient/actor illustration. If disabled or background is an image/gradient, use `surfaceRaised` solid backing. C4/C5 never rely on Vibrant.
- Large high-saturation blocks are prohibited. Ambient themes affect thin contour strokes and sparse particles only.
- Text contrast target is WCAG-style preview guidance ≥4.5:1 for body and ≥3:1 for large type; device readability remains unvalidated.

## 8. Window structure · WC-StillwaterDesk

| field | content |
|---|---|
| form | Planar; depth fixed 640dp |
| logical size | default `1200×800dp`; min `760×640`; max `1480×920` from Interaction5 §10 |
| content area | default `1136×656dp` after 96dp TitleBar and `24/32/24/32dp` inset |
| attachment | no Docked attachment; state-local InlineControl and C3 Dialog only; C7 is Stage-owned, not a Window attachment |

```text
┌────────────────────────────────────────────────────┐ 1200×800
│ system TitleBar 96dp                               │
├────────────────────────────────────────────────────┤
│ inset 32dp                                         │
│ ┌────────────────────────────────────────────────┐ │
│ │ Focus region 1136×80                           │ │
│ │ ┊ C1/C2/C8 title or status ┊                   │ │
│ └────────────────────────────────────────────────┘ │
│                 gap l=24dp                         │
│ ┌──────────────────────┬─────────────────────────┐ │
│ │ Main 640×456         │ gap l │ Support 472×456 │ │
│ │ ┊C1/C2/C8 primary┊   │       │ ┊C2/C8 detail┊  │ │
│ └──────────────────────┴─────────────────────────┘ │
│                 gap m=16dp                         │
│ ┌────────────────────────────────────────────────┐ │
│ │ Action 1136×88 ┊ owning component actions ┊    │ │
│ └────────────────────────────────────────────────┘ │
│ ┌╌╌ C3 modal 660×416 or C7 exit-confirm ╌╌┐        │
└────────────────────────────────────────────────────┘
```

Grid: 3 rows (`80/456/88dp`) with gaps `24/16dp`; main row is `640/24/472dp`. State ownership: N0/N1=C1, N2=C2, N3=C3 over C2, N9=C8; C7 exit-confirm remains part of C7 while Stage is frozen. Large follows diagram; Compact stacks main/support; Constrained uses one scroll column and fixed-bottom action. No orphan window region and no global scale transform.

## 9. Core components · complete eight-block structures

### C1 · RuleSealDeck

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q01,Q15 |
| Source data derivedFromData | `lesson.step`, `lesson.acknowledgedKinds`, `BestMark.readState/value` |
| Purpose | teach and recall all three verbs, then start safely |
| Layout role layoutRole | `primary_hero` |
| Priority | primary |
| Runtime role runtimeRole | `ruleLearningController` |

**Anatomy · Layout (anatomy.layout)**

```text
┌──────────────────────────────────────┐
│ ┊title/step┊      ┊best-status┊       │ row 80
├────────────┬────────────┬────────────┤
│ ┊拍 seal┊  │ ┊抓 seal┊  │ ┊别碰 seal┊ │ hero row; gap m
├──────────────────────────────────────┤
│ ┊cue/error┊               ┊primary┊   │ action row
└──────────────────────────────────────┘
```

Grid: 3 rows × 12 columns; seals each span 4 columns, center aligned; Constrained changes to one active 12-column seal, step dots, then action.

**Anatomy · Sizing (sizing)**

| Tier | Width × Height | owning tier / fit |
|---|---|---|
| Regular | `1136×600dp` | Large default/max, within `1136×656` content |
| Compact | `896×560dp` | Compact content, seals wrap 2+1 |
| Constrained | `696×496dp` | min content, one seal page + fixed 64dp action; internal copy scrolls |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | none | inherits `deskShell`; no glass stacking |
| Corner radius | seal `radius.l 32dp`; action `radius.m 20dp` | scale |
| Padding | `24/24/24/24dp` | spacing.l |
| Internal gap | seal `16dp`; rows `24dp` | spacing.m/l |
| Stroke | default `2dp semantic`; focus `3dp #FFFFFF` | stroke.normal/focus |
| Icon | `40dp` semantic shape | iconSize.l |
| Primary text | title 32/40/650; action 18/24/650 | typography |
| Value / secondary | body 18/28/500; caption 14/20/500 | typography |
| Minimum hit target | seals `72×72dp`; actions `64×64dp` | ≥56dp |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c1-title` | `记住三条就够了` | text | `lesson.step` | heading / current step |
| `c1-ordinary` | `普通泡泡·拍` | semantic button/seal | `lesson.acknowledgedKinds.ordinary` | ordinary circle |
| `c1-gold` | `金色泡泡·抓` | semantic button/seal | `lesson.acknowledgedKinds.gold` | gold diamond |
| `c1-gray` | `灰色泡泡·别碰` | semantic button/seal | `lesson.acknowledgedKinds.gray` | gray dashed |
| `c1-best` | `最高分` | status text | `bestMark.readState/value` | truthful saved-state caption |
| `c1-cue` | `轮到你确认` | live text | `lesson.validationMessage` | guidance/error |
| `c1-primary` | `开始` / `下一条` | button | `lesson.primaryAction` | state-local action |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `lesson.step` | `c1-title` text + active seal | absent→show all three overview; invalid→`请重新开始短课` | display-only |
| `lesson.acknowledgedKinds.*` | seal selected shape/check | absent→unselected; conflict→clear selection + attention copy | semantic |
| `bestMark.readState` | `c1-best` label/shape | loading→`正在读取`; error→`最高分暂不可用`; never show 0 | semantic |
| `bestMark.value` | `c1-best` value | null/error→`暂无数据`; never affects lesson | display-only |
| `lesson.validationMessage` | `c1-cue` text | null→`看形状，也看动作字` | display-only |
| `lesson.primaryAction` | `c1-primary` label/enabled | missing→disabled `请先确认当前规则` | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `overview` | three seals equal; Start primary |
| `guided-step` | one hero seal, other two reduced; Next enabled after acknowledgement |
| `recall-complete` | all seals checked by shape+text; `去校准` primary |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| default | overview | deskShell, semantic strokes | none | none | all labels visible | base |
| focused | gaze/ray | 3dp white outline | scale 1.03 | 120ms ease-out | focus announced | over selected |
| selected | acknowledged | semantic fill 18% + check shape | none | 160ms fade | `已确认` text | below error |
| disabled | prerequisite missing | opacity .55, readable | none | none | reason in cue | suppress focus scale |
| loading | BestMark read | c1-best progress ring | none | 800ms nonessential; RM static dots | `正在读取` | affects best only |
| empty | no saved best | unknown diamond + `暂无数据` | none | none | explicit null | below lesson states |
| error | invalid lesson/read | attention/blocked shape + retry copy | none | 180ms fade | error text | highest |
| overflow | 130% text/min width | active seal page + internal scroll | no target shrink | none | step count `1/3` | layout over default |

State stacking: `error > disabled > focused > selected > default`; BestMark loading/empty is scoped to `c1-best` and never disables rule controls.

### C2 · ReachApertureCalibrator

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q02,Q10,Q12 |
| Source data derivedFromData | `SessionEnvelope.posture/calRev/envelope`, `InputLease.source/confidence/armed`, `pose.sampleState` |
| Purpose | create and confirm a reachable front-only envelope |
| Layout role layoutRole | `critical_primary` |
| Priority | primary |
| Runtime role runtimeRole | `calibrationController` |

**Anatomy · Layout (anatomy.layout)**

```text
┌──────────────────────────┬──────────────────┐
│ ┊aperture diagram┊       │ ┊posture choices┊│
│ ┊front/elev/band marks┊  │ ┊input status┊   │
│ ┊sample status┊          │ ┊retry/confirm┊  │
└──────────────────────────┴──────────────────┘
```

Grid: Large 1 row, 7:5 columns with 24dp gap; Compact/Constrained 2 rows, diagram first and controls second. Diagram orientation is user-front, never a top-down rear-inclusive map.

**Anatomy · Sizing (sizing)**

| Tier | Width × Height | owning tier / fit |
|---|---|---|
| Regular | `1136×536dp` | Large content; preview `640×456`, controls `472×456` |
| Compact | `896×560dp` | stacked preview `896×280` + controls |
| Constrained | `696×496dp` | stacked preview `696×220`; controls scroll; confirm fixed bottom |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | none | inherits deskShell |
| Corner radius | diagram `32dp`; controls `20dp` | radius.l/m |
| Padding | diagram `24dp`; controls `24dp` | spacing.l |
| Internal gap | `16dp`, action gap `12dp` | spacing.m/s |
| Stroke | safe contour `2dp`; focus `3dp`; invalid `2dp blocked` | semantic |
| Icon | posture/input `28dp`; band handle `40dp` | iconSize.m/l |
| Primary text | title 32/40; action 18/24 | typography |
| Value / secondary | body 18/28; caption 14/20 | typography |
| Minimum hit target | posture/retry/confirm `64×64dp` | ≥56dp |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c2-diagram` | `你的前方花窗` | SVG/spatial diagram | `sessionEnvelope.envelope` | safe direction/range |
| `c2-band` | `互动区` | diagram band | `sessionEnvelope.bandPose` | fixed reach result |
| `c2-posture` | `坐姿` / `站姿` | segmented buttons | `sessionEnvelope.posture` | actionable choice |
| `c2-input` | `手势` / `手柄` | status+choice | `inputLease.source/armed` | input ownership |
| `c2-sample` | `请自然伸手` | live status | `pose.sampleState` | sampling/validation |
| `c2-retry` | `重新测量` | button | `pose.retryAllowed` | recovery |
| `c2-confirm` | `确认互动区` | primary button | `sessionEnvelope.canAccept` | commits calRev |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `sessionEnvelope.posture` | `c2-posture` selected | null→no selection + Confirm disabled | semantic |
| `sessionEnvelope.envelope` | `c2-diagram` path/labels | absent→conservative dotted preview + `尚未测量`; invalid→blocked shape | semantic |
| `sessionEnvelope.bandPose` | `c2-band` geometry | absent→nominal ghost only; out-of-range→not committed | semantic |
| `sessionEnvelope.calRev` | confirm result caption | absent→`尚未保存`; conflict→force retry | display-only |
| `inputLease.source/armed` | `c2-input` label/enabled | none→`尚未连接`; permission error→controller/manual option | semantic |
| `pose.sampleState` | `c2-sample` label/shape | unavailable→`无法读取手势`; stale→stop sample, retain prior rev | semantic |
| `sessionEnvelope.canAccept` | `c2-confirm` enabled | missing/false→disabled with reason | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `seated` | lower nominal band illustration; same reach width guard |
| `standing` | chest-to-shoulder nominal band; same no-overhead guard |
| `controller-conservative` | no hand sample; reduced fixed band, explicit unverified label |
| `recalibration` | prior envelope shown dashed; new sample must be confirmed before replacing |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| default | posture not chosen | ghost contour .35 | none | none | instruction text | base |
| focused | gaze on choice/action | 3dp white | 1.03 on control only | 120ms | focus label | above selected |
| sampling | pose valid stream | contour draws progressively | none | 300ms samples; RM discrete steps | numeric-free progress text | below invalid |
| selected | posture/input chosen | semantic check+label | none | 160ms | selected announced | below focused |
| boundary-disabled | band violates envelope | blocked square, Confirm disabled | none | snap ≤100ms | reason names height/range | above focused |
| stale | pose timestamp stops | attention triangle, prior contour dashed | none | no animation | `手势暂时中断` | above sampling |
| error | permission/sample failure | blocked backing + retry/controller | none | 180ms fade | explicit alternatives | highest |
| overflow | text scale/min | diagram 220dp high, controls scroll | no target shrink | none | focus order diagram→controls→confirm | layout precedence |

State stacking: `error > boundary-disabled > stale > focused > selected > sampling > default`; prior calRev is never visually presented as newly accepted.

### C3 · StageConsentDialog

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q02,Q15 |
| Source data derivedFromData | `SessionEnvelope.calRev/posture`, `InputLease.source/armed`, `stage.openState` |
| Purpose | require explicit, informed entry into Full Space Stage |
| Layout role layoutRole | `critical_primary` |
| Priority | primary |
| Runtime role runtimeRole | `stageEntryConfirmation` |

**Anatomy · Layout (anatomy.layout)**

```text
┌────────────────────────────────┐
│ ┊shield icon┊ ┊进入花窗场？┊    │ row 72
│ ┊calibration/input summary┊     │ body 216
│ ┊error/status┊                   │ status 48
│ ┊取消┊              ┊进入花窗场┊│ actions 72
└────────────────────────────────┘
```

Grid: 4 rows × 2 columns; title/body/status span 2; Cancel left and Enter right. First focus is always Cancel; focus never starts on Enter.

**Anatomy · Sizing (sizing)**

| Tier | Width × Height | owning tier / fit |
|---|---|---|
| Regular | `660×416dp` | Large, centered within 1136×656 |
| Compact | `620×416dp` | Compact, within 896×576 |
| Constrained | `632×440dp` max | within 696×496; actions stack as Cancel then Enter |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | glass `localFocus/Thick` | no custom color combined |
| Corner radius | `32dp` | radius.l |
| Padding | `32dp` | spacing.xl |
| Internal gap | rows `16dp`; actions `16dp` | spacing.m |
| Stroke | `2dp #BBD0CE`; focus `3dp #FFFFFF` | token |
| Icon | `40dp` shield/forward aperture | iconSize.l |
| Primary text | title 32/40; action 18/24 | typography |
| Value / secondary | body 18/28; caption 14/20 | typography |
| Minimum hit target | both actions `64×64dp` | ≥56dp |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c3-title` | `进入花窗场？` | text | static | high-consequence heading |
| `c3-summary` | `互动区已确认` | summary list | `sessionEnvelope.*` | accepted prerequisite |
| `c3-input` | `当前输入` | status row | `inputLease.source/armed` | lease readiness |
| `c3-status` | `进入后将切换到全空间` | status text | `stage.openState` | consequence/error |
| `c3-cancel` | `取消` | button | static | safe default |
| `c3-enter` | `进入花窗场` | primary button | `stage.canOpen` | explicit Stage action |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `sessionEnvelope.calRev` | `c3-summary` revision-valid label | absent/conflict→`互动区未确认`, Enter disabled | semantic |
| `sessionEnvelope.posture` | summary visible copy | null→`姿态未选择` | display-only |
| `inputLease.source/armed` | `c3-input` label/shape | none→`输入尚未就绪`, Enter disabled | semantic |
| `stage.canOpen` | `c3-enter` enabled | missing/false→disabled + prerequisite copy | semantic |
| `stage.openState` | `c3-status` text/shape | error→`暂时无法进入，请重试`; loading→progress | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `ready` | valid calRev/input; Enter enabled |
| `prerequisite-blocked` | missing fact listed; Enter disabled |
| `open-retry` | prior open failed; Cancel + Retry Enter remain |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| default | dialog opens ready | Thick glass, Cancel focus | none | 240ms fade/rise 12dp; RM fade | consequence read first | base |
| focused | gaze/ray | 3dp white | button 1.03 | 120ms | focus announced | over default |
| pressed | pinch/button | actionMatte darkens | .98 | 90ms | haptic optional | over focused |
| disabled | prerequisites fail | Enter .55 + blocked square | none | none | reason adjacent | suppress Enter focus |
| loading | Stage open pending | Enter progress + locked actions | none | RM static `正在进入` | live-region text | over pressed |
| error | open failed | blocked square/status, Cancel active | none | 180ms fade | `返回校准` alternative | highest |
| overflow | text scale/min | actions vertical, body scroll max 160dp | height to 440 | none | Cancel first in DOM/focus | layout precedence |

State stacking: `error > loading > disabled > focused > pressed > default`; background C2 is inert and accessibility-hidden while C3 is open.

### C4 · ApertureField

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q02,Q03,Q04,Q07,Q11 |
| Source data derivedFromData | `SessionEnvelope.envelope/bandPose/calRev`, `ArrivalSeed.pose/eligibility`, `FreezeSeal.state` |
| Purpose | make the only legal source field and fixed interaction band visible |
| Layout role layoutRole | `primary_spatial_frame` |
| Priority | primary |
| Runtime role runtimeRole | `safeArrivalGeometry` |

**Anatomy · Layout (anatomy.layout, world-space)**

```text
user origin ●
  z=.45m ┌──────── interaction band W1.10×H.36×D.35 ────────┐ z=.80m
          ╲              actor convergence                 ╱
           ╲  separated aperture strokes / legal seeds   ╱
            ╲ az −40°..+40°, elev −10°..+22°            ╱
             └──────── radial 2.2..3.2m ────────────────┘
```

World definition: anchor=user origin at calRev; +Z accepted forward; band center nominal `(0,calY,0.62m)`, faces user, zero roll; source contour samples only legal boundary points. Current-head eligibility intersects before actor visibility.

**Anatomy · Sizing (sizing)**

| Tier | spatial extent | Stage fit |
|---|---|---|
| Regular | az `80°`, elev `32°`, radius `2.2–3.2m`, band `1.10×.36×.35m` | default accepted envelope |
| Compact | az `60°`, elev `26°`, radius `2.2–2.8m`, band `0.90×.34×.32m` | reduced seated/controller envelope; still front |
| Constrained | az `44°`, elev `22°`, radius `2.2–2.6m`, band `0.72×.32×.30m` | limited reach; if smaller, calibration blocks Stage rather than scale actors |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | none | Stage; glass prohibited |
| Corner radius | N/A—open world contour, no rectangular container | spatial reason |
| Padding | safety gap actor-to-contour `≥0.12m`; actor-to-band edge `≥0.08m` | world spacing |
| Internal gap | contour stroke separation `0.10–0.18m` | sparse aperture |
| Stroke | contour `0.008m`; band `0.010m`, eligible `0.014m` | world metric |
| Icon | N/A—semantic boundary uses contour+label, not icon | explicit |
| Primary text | band label angular height target `1.8°`, body role equivalent | Stage backing |
| Value / secondary | status angular height target `1.2°`, caption equivalent | device verify |
| Minimum hit target | C4 not directly interactive; Pause belongs to C6 | N/A reason |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c4-contour` | `安全出现区` | world polyline strokes | `sessionEnvelope.envelope` | legal source boundary |
| `c4-band` | `互动区` | world translucent volume/outline | `sessionEnvelope.bandPose` | fixed judgment region |
| `c4-forward` | `你的前方` | orientation tick/text | `sessionEnvelope.forwardAxis` | front-only cue |
| `c4-invalid` | `需要重新校准` | backed status label | `sessionEnvelope.validity` | block/freeze cue |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `sessionEnvelope.envelope` | contour vertices/visibility | absent/invalid→no seeds, show blocked status; never default to full sphere | semantic |
| `sessionEnvelope.bandPose` | band transform/dimensions | absent→band hidden + Stage blocked; stale→FreezeSeal | semantic |
| `sessionEnvelope.calRev` | geometry ownership label | mismatch→freeze and `需要重新校准` | semantic |
| `sessionEnvelope.forwardAxis` | front tick orientation | unavailable→stop seed admission; retain frozen last-known geometry | semantic |
| `arrivalSeed.eligibility/pose` | brief admitted-source glint | invalid→not rendered, returned to pool | semantic |
| `freezeSeal.state` | contour/band frozen styling | invalid seal→blocked square, no resume | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `tutorial` | contour opacity .78, band label persistent |
| `play` | contour .46, band label fades after 2s; geometry unchanged |
| `reduced-envelope` | Compact/Constrained spatial sizes with explicit `范围已收窄` |
| `reduce-motion` | no breathing; static contour and eligibility stroke |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| loading | Stage opens, geometry pending | backed `正在定位互动区`; no contour/seeds | none | static under RM | spoken status | below error |
| ready | valid calRev | contour semantic ambient, band visible | tier-derived | breath 4000ms; RM static | text labels | base |
| actor-eligible | C5 enters band | band stroke .014m + label | no pose change | 180ms | sound optional, label required | above ready |
| frozen | valid FreezeSeal | dashed blue contour, all transforms fixed | none | ≤100ms snap | `已暂停` | above eligible |
| stale | head/pose no intersection | attention triangle, no seeds | none | no motion | reason text | above frozen-ready |
| error | invalid/missing geometry | blocked square + solid backing | contour hidden | none | recalibrate action in C7 | highest |
| empty | no actor currently | contour/band only | none | breath/RM static | not an error | below frozen |
| overflow | actor would cross boundary | actor not admitted; no visual overflow | none | none | no surprise cue | lifecycle rule |

State stacking: `error > stale > frozen > actor-eligible > ready > empty/loading`; theme colors never override frozen/blocked semantic stroke.

### C5 · BubbleActor

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q03,Q04,Q05,Q06,Q07,Q13 |
| Source data derivedFromData | `ArrivalSeed`, `DriftActor`, `RuleVerdict` |
| Purpose | provide one-glance category, predictable approach and exactly-once terminal feedback |
| Layout role layoutRole | `primary_spatial_subject` |
| Priority | primary |
| Runtime role runtimeRole | `pooledJudgmentActor` |

**Anatomy · Layout (anatomy.layout, world-space)**

```text
        ┊verb badge faces head┊  offset y +0.13m
                 │ gap .03m
       ┌─────────┴─────────┐
       │ semantic shell     │ diameter .16..24m
       │ ┊core/highlight┊   │ anchor actor center
       └─────────┬─────────┘
                 │ trajectory tail ≤.10m (RM:none)
```

World definition: root at `DriftActor.transform`, local forward tangent to path, shell may rotate ≤8° while verb badge billboards to head; no actor exists outside C4 legal path. Collider/judgment volume shares root and is disabled before pool return.

**Anatomy · Sizing (sizing)**

| Tier | spatial size | Stage fit |
|---|---|---|
| Regular | shell diameter `.20m`, badge `.18×.07m`, collider `.22m` max | default field/band |
| Compact | shell `.18m`, badge `.17×.07m`, collider `.20m` | reduced envelope |
| Constrained | shell `.16m`, badge `.16×.07m`, collider `.18m`; max two actors | limited field; never smaller due legibility |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | opaque `actorSurface` | Stage, no glass |
| Corner radius | N/A—semantic shell geometry | type shapes define edge |
| Padding | badge text inset `.018m` | world metric |
| Internal gap | shell↔badge `.03m`; concurrent actor edge gap `≥.18m` | safety/readability |
| Stroke | shell `.008m`; focus/eligible `.012m` | world metric |
| Icon | embedded shape core `.06m` | redundant category |
| Primary text | verb angular height target `2.0°` | backed badge |
| Value / secondary | verdict angular height `1.4°` | caption equivalent |
| Minimum hit target | collider `.18–.22m`; exact physical usability device-tested | not a dp claim |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c5-shell` | category human label | 3D semantic mesh | `driftActor.kind` | circle/double-diamond/dashed halo |
| `c5-verb` | `拍` / `抓` / `别碰` | backed world text | `driftActor.kind` | action redundancy |
| `c5-proximity` | `即将到达` | contour arc | `driftActor.bandPhase` | timing, no countdown pressure |
| `c5-verdict` | `拍破` / `抓住` / `已避开` / `动作不符` | world text+shape | `ruleVerdict.result` | terminal truth |
| `c5-tail` | no label | short trajectory cue | `driftActor.velocity` | optional motion orientation |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `arrivalSeed.pose/eligibility` | acquire transform/visibility | invalid/missing→never visible, return pool with reason | semantic |
| `driftActor.kind` | shell mesh/color + verb | unknown→blocked square actor never eligible; recycle before interaction | semantic |
| `driftActor.lifecycle` | visibility/collider/opacity | conflict/terminal reused→collider off + quarantine return | semantic |
| `driftActor.transform` | root world transform | stale/out-of-bounds→no teleport; exactly-once return | semantic |
| `driftActor.bandPhase` | proximity arc + eligibility | missing→no judgment; continue only if valid transform | semantic |
| `driftActor.velocity` | optional tail direction | missing→tail hidden; shell/verb remain | display-only |
| `ruleVerdict.result` | verdict label/shape + terminal animation | absent→no success copy; conflict→`判定待核对`, no score | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `ordinary` | faceted circular ring, cyan, `拍`; slap contact expected |
| `gold` | paired diamond loops, amber, `抓`; hold progress appears inside core |
| `gray` | matte dashed halo, gray, `别碰`; no grab/slap affordance; clearance arc |
| `tutorial` | persistent verb + larger badge `.20×.08m` |
| `pooled-performance` | trail/core highlight removed; semantic shell+verb retained |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| pooled | not acquired | invisible, collider off | none | none | hidden | base offstage |
| approaching | valid acquire | shell 1.0, verb visible | tier size | constant path | label+shape | base visible |
| eligible | band entry | .012m outline, proximity arc | no root scale | 180ms | `可以拍/抓` except gray `保持不碰` | above approaching |
| hold-progress | gold valid grip overlap | loop closure 0–100%; no numeric percent | none | follows hold | tactile+text | above eligible |
| frozen | FreezeSeal | blue dashed outer ring, transform/collider state frozen | none | snap ≤100ms | `已暂停` | above eligible |
| terminal-success | one verdict | success shape + exact Chinese label | scale 1→.86 | 240ms/RM fade | label persistent 300ms | above frozen after resume only |
| terminal-error | wrong/invalid action | attention/blocked shape + `动作不符` | none | 240ms fade | no blame tone | above success |
| out-of-bounds | leaves valid volume | invisible, collider off, return reason logged | none | no teleport | no user-facing penalty if system-caused | lifecycle highest |

State stacking: `out-of-bounds/pooled > terminal-error > terminal-success > frozen > hold-progress > eligible > approaching`; exactly one terminal state can occur.

### C6 · RunPulse

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q08,Q09,Q10,Q11,Q14 |
| Source data derivedFromData | `SegmentRecipe`, `sessionClock`, `InputLease`, `FreezeSeal`, `RunTally.completeness` |
| Purpose | show calm time/segment/input/pause and settlement state without competing with actors |
| Layout role layoutRole | `supporting_status` |
| Priority | secondary |
| Runtime role runtimeRole | `runStatusAndPauseControl` |

**Anatomy · Layout (anatomy.layout, world-space)**

```text
head-forward upper center z≈1.25m
┌──────────────────────────────┐
│ ┊02:30┊ ┊第2段·薄荷┊ ┊手势┊ │ backed status strip
└──────────────────────────────┘
                         ┌────────┐ lower-right
                         │┊暂停┊  │ 64dp-equivalent target
                         └────────┘
```

World definition: status anchor az0°/elev+18°, angular ≤22°×8°; Pause anchor az+22°/elev−14°, both face user, zero roll. Status is never attached to a Window.

**Anatomy · Sizing (sizing)**

| Tier | angular / logical size | Stage fit |
|---|---|---|
| Regular | status `22°W×8°H`; Pause `7°×7°` | default field |
| Compact | status `20°×8°`; Pause `7°×7°` | reduced field |
| Constrained | status `18°×9°` stacked 2 rows; Pause `7°×7°` | maintains readable target; no smaller |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | opaque `stageBacking` .86 | Stage; no glass |
| Corner radius | logical `20dp` equivalent | radius.m visual |
| Padding | logical `12×16dp` | spacing.s/m |
| Internal gap | `16dp` equivalents | spacing.m |
| Stroke | default `1dp`; focus `3dp #FFFFFF` | token |
| Icon | `28dp` clock/input/pause | iconSize.m |
| Primary text | metric 40/48 for time; rendered to angular target | typography |
| Value / secondary | caption 14/20 for segment/input | typography |
| Minimum hit target | Pause logical `64×64dp`, angular target ≥7° | ≥56dp logical fallback |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c6-time` | `03:00` | metric text | `sessionClock.remaining` | active time only |
| `c6-segment` | `短课` / `第1–5段` | status text+shape | `segmentRecipe.index/themeLabel` | calm boundary orientation |
| `c6-input` | `手势` / `手柄` / `未就绪` | status badge | `inputLease.source/armed` | current owner |
| `c6-pause` | `暂停` | button | `run.canPause` | T05 trigger |
| `c6-settle` | `正在核对本局` | backed status | `runTally.completeness` | N8 primary status |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `sessionClock.remaining` | `c6-time` mm:ss | missing/stale→`时间已暂停` + FreezeSeal; never decrement locally | display-only |
| `segmentRecipe.index` | `c6-segment` human label | invalid→`段落待核对`, freeze boundary | semantic |
| `segmentRecipe.themeLabel` | segment secondary copy | null→omit label; ambient still uses last committed layer | display-only |
| `inputLease.source/armed` | `c6-input` label/shape | none/unarmed→`未就绪`, triggers recovery if playing | semantic |
| `run.canPause` | `c6-pause` enabled | false/missing→disabled with `已暂停` or `正在结算` | semantic |
| `runTally.completeness` | `c6-settle` label/shape | partial/conflict→`统计不完整`; no success badge | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `tutorial` | `短课 1/3` replaces recipe label |
| `recipe` | shows `第n段` + human theme label |
| `settling` | hides Pause/input, centers reconciliation status |
| `reduce-motion` | no status breath or slide; same copy/shape |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| default | active run | stageBacking, secondary opacity .86 | none | none | labels visible | base |
| focused | Pause gaze | 3dp white | Pause 1.03 | 120ms/RM stroke | focus announced | above default |
| pressed | Pause action | matte darken | .98 | 90ms | optional haptic | above focused |
| boundary | 30s commit | ambient stroke changes after atomic commit | none | 800ms crossfade/RM same | segment text changes | above default |
| input-none | lease revoked | attention triangle `未就绪` | none | snap | not color-only | above boundary |
| frozen | FreezeSeal | dashed blue, time constant, Pause→`已暂停` disabled | none | ≤100ms | explicit state | above input-none |
| settling | N8 | central `正在核对本局`; no Pause | status width 26° max | 240ms fade | live status | above frozen |
| error | clock/recipe conflict | blocked square + recovery | none | no loop | reason text | highest |

State stacking: `error > settling > frozen > input-none > boundary > focused > pressed > default`; ambient theme cannot override semantic states.

### C7 · FreezeRecoverySurface

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q10,Q11,Q12,Q15 |
| Source data derivedFromData | `FreezeSeal`, `InputLease`, `SessionEnvelope.calRev`, `run.discardState` |
| Purpose | prove atomic freeze and provide safe recovery, input switch, recalibration or confirmed exit |
| Layout role layoutRole | `critical_primary` |
| Priority | primary |
| Runtime role runtimeRole | `stageFreezeRecoveryController` |

**Anatomy · Layout (anatomy.layout, world-space focused sheet)**

```text
┌──────────────────────────────────┐ faces user az0/elev0/z1.05m
│ ┊已暂停 / reason shape┊           │
│ ┊clock actor spawn verdict checks┊│
│ ┊current input + calibration┊     │
│ ┊继续┊ ┊切换输入┊                 │
│ ┊重新校准┊ ┊结束本局┊             │
│ ┌╌ exit-confirm: copy / 取消 / 舍弃 ╌┐ (variant)
└──────────────────────────────────┘
```

World definition: Stage-owned central surface angular ≤46°W×34°H, nominal z=1.05m, zero roll, backed by `stageBacking`; frozen C4/C5 remain visible behind scrim at unchanged transforms. It is not a Window attachment. Nested confirmation remains inside C7 and traps focus.

**Anatomy · Sizing (sizing)**

| Tier | angular / logical size | Stage fit |
|---|---|---|
| Regular | `46°×34°`, logical `720×520dp` | default field; 2×2 actions |
| Compact | `42°×36°`, logical `640×544dp` | actions 2×2, tighter copy |
| Constrained | `38°×40°`, logical `560×600dp` | one-column actions; internal body scroll; never beyond central 50° |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | opaque `stageBacking #102A33` .94 | Stage; glass unavailable |
| Corner radius | logical `32dp` | radius.l |
| Padding | `32dp` equivalent | spacing.xl |
| Internal gap | rows `16dp`, actions `12dp` | spacing.m/s |
| Stroke | `2dp frozen`; focus `3dp white`; destructive `2dp danger+square` | semantic |
| Icon | reason `40dp`; actions `28dp` | iconSize.l/m |
| Primary text | title 32/40; action 18/24 | typography |
| Value / secondary | body 18/28; caption 14/20 | typography |
| Minimum hit target | all actions `64×64dp`; nested Cancel/Discard `64dp` | ≥56dp |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c7-title` | `已暂停` | heading+shape | `freezeSeal.reason/state` | frozen truth |
| `c7-proof` | `时间、泡泡和判定都已冻结` | invariant checklist | `freezeSeal.integrity` | atomic proof |
| `c7-input` | `当前输入` | status/choice | `inputLease.source/armed` | recovery prerequisite |
| `c7-resume` | `继续` | primary button | `freezeSeal.canResume` | T06 |
| `c7-switch` | `切换输入` | button | `inputLease.availableSources` | source choice while frozen |
| `c7-calibrate` | `重新校准` | button | `sessionEnvelope.calRev` | T07 |
| `c7-exit` | `结束本局` | destructive-outline button | `run.active` | T12 |
| `c7-confirm-copy` | `舍弃本局进度？` | dialog text | `run.discardState` | exit-confirm variant |
| `c7-cancel` | `取消` | button | static | safe default T13 |
| `c7-discard` | `舍弃本局` | destructive button | `run.discardState` | T14 |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `freezeSeal.reason/state` | `c7-title` label/shape | missing→`暂停原因未知`, resume disabled | semantic |
| `freezeSeal.integrity` | `c7-proof` four check rows | incomplete/conflict→failed row + `不可继续` | semantic |
| `freezeSeal.canResume` | `c7-resume` enabled | false/missing→disabled with first failed prerequisite | semantic |
| `inputLease.source/armed` | `c7-input` human label | none→`未就绪`; never echo enum | semantic |
| `inputLease.availableSources` | `c7-switch` choices/enabled | empty→disabled `没有可用输入` | semantic |
| `sessionEnvelope.calRev` | recalibrate context | stale/mismatch→`建议重新校准` attention | semantic |
| `run.active` | `c7-exit` visibility | false→hide exit; unknown→disabled | semantic |
| `run.discardState` | nested confirm/error | failure→stay paused, show `未能结束，请重试` | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `manual-pause` | valid seal; Resume primary |
| `input-loss` | input row primary; Resume disabled until lease armed |
| `pose-drift` | Recalibrate primary; geometry mismatch explained |
| `invalid-seal` | no Resume; only recalibrate/exit |
| `exit-confirm` | background recovery surface inert; nested Cancel-first confirmation replaces action-grid focus |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| loading | capturing seal ≤one frame | `正在安全暂停`; actions disabled | none | no spinner under RM | live status | below error |
| valid | all invariant checks | frozen dashed + success checks | none | 240ms surface fade | checklist announced | base |
| input-wait | lease none | input row attention; Resume disabled | none | no loop | alternatives enumerated | above valid |
| boundary-disabled | pose/calRev invalid | Recalibrate primary; blocked row | none | snap | reason text | above input-wait |
| focused | gaze action | 3dp white | 1.03 control | 120ms | focus label | below modal |
| exit-confirm | T12 | nested scrim/dialog; Cancel focused | logical dialog `480×300dp` | 180ms fade/RM same | focus trap, Escape=Cancel | above all non-error |
| error | seal/discard failure | blocked square + stable actions | none | none | specific retry path | highest |
| overflow | text scale/constrained | one-column actions, proof scroll | max 40°H | none | no clipped Cancel | layout precedence |

State stacking: `error > exit-confirm > boundary-disabled > input-wait > focused > valid > loading`; no state re-enables background actor colliders.

### C8 · ResultBloom

| Field | Content |
|---|---|
| Source task derivedFromTasks | Q14,Q15 |
| Source data derivedFromData | `RunTally`, `BestMark` |
| Purpose | explain accuracy/category outcomes, badge, score and truthful local-save result |
| Layout role layoutRole | `primary_metric` |
| Priority | primary |
| Runtime role runtimeRole | `settlementAndBestController` |

**Anatomy · Layout (anatomy.layout)**

```text
┌──────────────────────────┬──────────────────────┐
│ ┊accuracy metric┊         │ ┊ordinary row┊       │
│ ┊badge shape+label┊       │ ┊gold row┊           │
│ ┊score / best / save┊     │ ┊gray row┊           │
├──────────────────────────┴──────────────────────┤
│ ┊再来一局┊ ┊返回┊                    ┊重试保存┊ │
└─────────────────────────────────────────────────┘
```

Grid: Large 2 rows × 12 cols; summary spans 7, category ledger spans 5, actions span 12. Compact/Constrained stack summary→ledger→actions; action bar fixed-bottom in Constrained.

**Anatomy · Sizing (sizing)**

| Tier | Width × Height | owning tier / fit |
|---|---|---|
| Regular | `1136×600dp` | Large default/max within content |
| Compact | `896×576dp` | ledger below summary; internal content fits/scrolls |
| Constrained | `696×496dp` | one scroll column + fixed 88dp action bar |

**Anatomy · Internal Metrics (metrics)**

| Metric | Value | Source / note |
|---|---|---|
| background | none | inherits deskShell |
| Corner radius | metric/ledger `32dp`; actions `20dp` | radius.l/m |
| Padding | regions `24dp`; outer `0` | spacing.l |
| Internal gap | rows `16dp`; columns `24dp`; actions `12dp` | scale |
| Stroke | `2dp` semantic; focus `3dp white` | scale |
| Icon | badge `40dp`; category/save `28dp` | iconSize.l/m |
| Primary text | accuracy metric 48/56; title 32/40 | typography |
| Value / secondary | metric 40/48; body 18/28; caption 14/20 | typography |
| Minimum hit target | all actions `64×64dp` | ≥56dp |

**Render Elements renderSpec.elements[]**

| id | visible label | type | bind | state / semantic role |
|---|---|---|---|---|
| `c8-accuracy` | `准确率` | metric | `runTally.accuracy` | headline truth |
| `c8-badge` | `铜徽章` / `银徽章` / `金徽章` | shape+label | `runTally.badge` | award only when complete |
| `c8-score` | `本局得分` | metric | `runTally.score` | current run |
| `c8-ordinary` | `普通泡泡` | category row | `runTally.categories.ordinary` | correct/eligible |
| `c8-gold` | `金色泡泡` | category row | `runTally.categories.gold` | correct/eligible |
| `c8-gray` | `灰色泡泡` | category row | `runTally.categories.gray` | untouched/eligible |
| `c8-best` | `最高分` | metric/status | `bestMark.value/writeState` | persistence truth |
| `c8-replay` | `再来一局` | primary button | static | T16 |
| `c8-home` | `返回` | button | static | T17 |
| `c8-save-retry` | `重试保存` | button | `bestMark.writeState` | T18, conditional |

**Data Bindings dataBindings[]**

| source path | target property | fallback / error behavior | kind |
|---|---|---|---|
| `runTally.completeness` | whole result eligibility/status | partial/conflict→no badge/save, show `统计不完整` | semantic |
| `runTally.accuracy` | `c8-accuracy` percent | null/denominator0→`暂无数据`; clamp invalid→error | display-only |
| `runTally.badge` | `c8-badge` label/shape | null when complete→`本局未获得徽章`; partial→hidden + reason | semantic |
| `runTally.score` | `c8-score` integer | null→`暂无数据`; never synthesize | display-only |
| `runTally.categories.ordinary` | `c8-ordinary` `correct/eligible` | absent→`暂无数据`; mismatch→partial | display-only |
| `runTally.categories.gold` | `c8-gold` `correct/eligible` | absent→`暂无数据`; mismatch→partial | display-only |
| `runTally.categories.gray` | `c8-gray` `untouched/eligible` | absent→`暂无数据`; mismatch→partial | display-only |
| `bestMark.value` | `c8-best` value | null→`暂无数据`; current score remains visible | display-only |
| `bestMark.writeState` | `c8-best` label/shape + retry visibility | loading→`正在保存`; failed→`未保存，可重试`; success→`已保存` | semantic |

**Variants variants**

| variant | structural / behavioral difference |
|---|---|
| `complete-bronze/silver/gold` | badge label/shape changes; structure constant |
| `complete-no-badge` | badge region says `本局未获得徽章` |
| `partial` | completeness warning replaces badge; score shown only if trusted; save disabled |
| `save-failed` | retry button visible; current result never disappears |

**States states**

| state | trigger | visual params | size change | motion | accessibility | stacking precedence |
|---|---|---|---|---|---|---|
| loading | N8→N9 data handoff | skeleton rows with human `正在核对` | none | RM static | live status | below partial/error |
| complete | ledger reconciled | success shape; badge if any | none | 240ms fade, no burst | all values labeled | base |
| focused | gaze action | 3dp white | 1.03 control | 120ms | focus announced | above complete |
| empty | no eligible actors/abandoned | `没有可结算的数据` + Return | metric region simplified | none | not 0% | above loading |
| partial | mismatch/timeout | partial triangle, no award/save | badge region becomes warning | 180ms fade | reason and affected rows | above complete |
| save-loading | write pending | best row progress, actions usable except retry | none | RM text only | `正在保存` | scoped over complete |
| save-error | write failed | attention triangle + Retry | none | none | current result retained | above save-loading |
| overflow | text scale/min | stacked scroll + fixed actions | within 696×496 | none | logical reading order | layout precedence |

State stacking: `partial/error > empty > save-error > save-loading > focused > complete > loading`; save state never overwrites current-run metrics.

## 10. Component structure integrity checklist

| core component | base rows | anatomy.layout | sizing | metrics | renderSpec | dataBindings | variants | states + precedence | verdict |
|---|---|---|---|---|---|---|---|---|---|
| C1 RuleSealDeck | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C2 ReachApertureCalibrator | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C3 StageConsentDialog | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C4 ApertureField | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C5 BubbleActor | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C6 RunPulse | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C7 FreezeRecoverySurface | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C8 ResultBloom | yes | yes | yes | yes | yes | yes | yes | yes | pass |

## 11. Coverage reconciliation

### Table A · nine domain entities → component bindings

| entity / decision variable | timeliness | catching binding | presentation / semantics | gap handling |
|---|---|---|---|---|
| SessionEnvelope | session/on recalibration | C2 `sessionEnvelope.*`; C3 calRev; C4 envelope/band/forward | calibrated diagram, consent summary, world geometry; stale/invalid blocks | fully bound; no raw revision exposed |
| ArrivalSeed | per spawn | C4 `arrivalSeed.eligibility/pose`; C5 `arrivalSeed.pose/eligibility` | eligible seed glint then actor acquire; invalid never visible | fully bound; invalid path intentionally invisible for safety |
| DriftActor | frame/event | C5 lifecycle/transform/kind/phase/velocity | semantic actor, band phase, frozen/terminal/OOB states | fully bound |
| InputLease | frame/event | C2, C3, C6, C7 `inputLease.*` | human source label, armed/none shape, recovery controls | fully bound; confidence numeric intentionally hidden because no user decision value |
| RuleVerdict | immutable terminal event | C5 `ruleVerdict.result`; C8 category totals derived | exact terminal label then reconciled summary | fully bound; raw event ID intentionally hidden |
| SegmentRecipe | atomic 30s boundary | C6 index/theme label; C4 ambient boundary | `短课/第n段`, ambience token; recipe speed not exposed | fully bound; raw recipe enum translated |
| FreezeSeal | pause/loss event | C4 state; C5 frozen; C6 frozen; C7 reason/integrity/canResume | visible atomic proof and safe actions | fully bound |
| RunTally | terminal/settlement | C6 completeness; C8 completeness/accuracy/categories/badge/score | completeness precedes celebration; partial blocks award/save | fully bound |
| BestMark | settlement/persistent | C1 readState/value; C8 value/writeState | `正在读取/暂无数据/已保存/未保存` truth | fully bound; storage key intentionally hidden |

### Table B · fifteen task decision outputs → component interaction

| task · decision output | read-only / actionable | catching component + render element + behavior | gap handling |
|---|---|---|---|
| Q01 remembered triad | actionable | C1 `c1-ordinary/gold/gray` acknowledgement + `c1-primary` | all three required before calibration |
| Q02 accepted calibration revision | actionable | C2 posture/retry/confirm; C3 Cancel/Enter | invalid envelope disables entry |
| Q03 seed eligible/rejected | system-actionable | C4 contour eligibility + C5 acquire; rejected seed intentionally invisible/returned | deterministic downstream test required |
| Q04 act/wait/refrain | actionable embodied | C5 shell/verb/proximity; user chooses slap/hold/no-touch | one primary actor focus |
| Q05 ordinary verdict | actionable embodied | C5 `c5-shell/c5-verdict`, slap contact/controller action | exactly once |
| Q06 gold verdict | actionable embodied | C5 hold-progress/verdict, grab/controller grip | exactly once |
| Q07 gray avoided/error | system-actionable + user inhibition | C5 gray dashed/clearance/verdict; no action control | closes only after untouched clearance |
| Q08 segment/recipe active | system-actionable | C6 `c6-segment`; atomic boundary commit | no user selector by design |
| Q09 atmosphere layer active | system-actionable | C6 boundary state + C4 ambient token | semantics/geometry unchanged |
| Q10 input owner | actionable recovery | C2 input choice; C6 status; C7 switch source | one lease only |
| Q11 valid FreezeSeal | actionable pause/system barrier | C6 Pause; C7 invariant proof/Resume gate; C4/C5 frozen | invalid seal prevents Resume |
| Q12 resume/recalibrate/exit | actionable | C7 `resume/calibrate/exit` and nested confirmation | all recovery branches represented |
| Q13 exactly-once pool return | system-actionable | C5 pooled/OOB/terminal states and collider-off behavior | implementation/logical QA; not user control |
| Q14 complete/partial tally | read-only then system-actionable save eligibility | C6 settling; C8 all metrics and partial state | partial blocks badge/save |
| Q15 save/replay/home/close | actionable | C8 replay/home/retry; C7 cancel/discard; C3 Cancel | stable back and error recovery present |

### Table C · exhaustive primary-component substates

| primary component → subcomponent | runtime substates | rendering primitive | binding |
|---|---|---|---|
| C1 → title/step | overview, guided-step, recall-complete, invalid-step | `c1-title` text + active seal | `lesson.step` |
| C1 → three seals | default, focused, selected, disabled, overflow | three semantic buttons / single paged hero | `lesson.acknowledgedKinds.*` |
| C1 → BestMark | loading, empty, fresh, error | `c1-best` progress/unknown/value/attention | `bestMark.readState/value` |
| C1 → primary action | focused, pressed, boundary-disabled | `c1-primary` button + reason | `lesson.primaryAction` |
| C2 → aperture diagram | empty, sampling(buffering), fresh, stale, error, boundary-disabled | `c2-diagram/c2-band` paths + status | `sessionEnvelope.envelope/bandPose`; `pose.sampleState` |
| C2 → posture/input editor | unselected(editing), selected, unavailable, permission-error | `c2-posture/c2-input` controls | `sessionEnvelope.posture`; `inputLease.*` |
| C2 → confirm/retry | focused, pressed, disabled, error | `c2-confirm/c2-retry` | `canAccept/retryAllowed` |
| C3 → summary | ready, prerequisite-blocked, open-error | `c3-summary/c3-input/c3-status` | calRev/input/openState |
| C3 → actions | default(Cancel focus), focused, pressed, disabled, loading | `c3-cancel/c3-enter` | `stage.canOpen/openState` |
| C4 → contour | loading, ready, reduced, stale, error | `c4-contour/c4-forward/c4-invalid` | envelope/forwardAxis/validity |
| C4 → band | empty, actor-eligible, frozen, boundary-disabled | `c4-band` outline/label | bandPose/FreezeSeal |
| C5 → shell/verb | pooled, approaching, eligible, frozen, OOB | `c5-shell/c5-verb/c5-proximity` | kind/lifecycle/transform/phase |
| C5 → gold hold | idle, hold-progress, early-release, terminal | loop closure + verdict | phase + verdict |
| C5 → terminal | success, error, conflicting, returned | `c5-verdict` then collider-off | `ruleVerdict.result/lifecycle` |
| C6 → time/segment | active, boundary, frozen, settling, conflict | `c6-time/c6-segment/c6-settle` | clock/recipe/completeness |
| C6 → input/Pause | default, focused, pressed, input-none, disabled | `c6-input/c6-pause` | lease/canPause |
| C7 → proof | loading, valid, invalid, error | `c7-title/c7-proof` checks | FreezeSeal reason/integrity |
| C7 → recovery actions | focused, pressed, input-wait, boundary-disabled, overflow | resume/switch/calibrate/exit controls | canResume/availableSources/calRev |
| C7 → exit confirmation | closed, open(Cancel focus), discard-loading, discard-error | nested copy/Cancel/Discard | `run.discardState` |
| C8 → settlement metrics | loading, complete, empty, partial, conflicting | accuracy/badge/score/category rows | `runTally.*` |
| C8 → BestMark | loading, saved, unchanged, save-error | best status + retry | `bestMark.value/writeState` |
| C8 → actions | focused, pressed, retry-visible, boundary-disabled | replay/home/retry buttons | completeness/writeState |

No drag state is invented where editing is not spatial manipulation: C1/C3/C7/C8 use discrete controls; C2's sampling/editor substates fulfill its real editing behavior. `offline` is intentionally non-blocking because all run data is local; it never masquerades as a save success.

## 12. Material, depth and Vibrant adjudication

| layer | treatment | glassStyle | opacity | content | contrast handling |
|---|---|---|---:|---|---|
| WC shell | glass | Thickest | .94 | all Shared-space reading states | textPrimary; solid fallback if glass unavailable |
| focused modal C3 | glass | Thick | .90 | short consent | local scrim + 4.5:1 preview target |
| Planar primary actions | matte | none | 1.0 | high-frequency/critical actions | text + icon + focus stroke |
| Stage C6/C7 backing | opaque | none | .86/.94 | status and recovery text | solid backing independent of passthrough |
| Stage C4 contour | opaque emissive-like unlit design intent | none | .46–.78 | safety geometry | stroke + label; no glass |
| Stage C5 actors | opaque | none | 1.0 | semantic subjects | color + unique mesh + verb |

Depth semantics: Planar content base is z=0; focus controls z=4dp; C3 modal z=24dp within the fixed 640dp depth. Stage hierarchy is geometric: C7 at 1.05m is nearer than C6 at 1.25m, actors occupy 0.45–3.2m along their path, and C4 source contour is farthest. Nearer means more urgent; no importance is expressed only by saturation.

| element | environment | Vibrant tier | propagation / termination | fallback |
|---|---|---|---|---|
| WC title and monochrome icons | Shared/uncontrolled | light | contained to monochrome text/icon region | `surfaceRaised` solid backing |
| C1/C2 diagrams containing semantic colors | Shared/uncontrolled | none | Vibrant terminates before diagram | Thickest shell + semantic stroke |
| C3 modal text | Shared/uncontrolled | light | terminates at actionMatte buttons | Thick glass + scrim |
| C4/C5/C6/C7 | Stage Mixed/passthrough | none | Stage content does not use Window Vibrant | opaque Stage backing and opaque actor materials |

## 13. Data display and trust contract

### 13.1 Paths

- `displayOnlyPaths[]`: `lesson.validationMessage`, `bestMark.value`, `sessionEnvelope.calRev` (rendered only as `互动区已确认`), `sessionClock.remaining`, `segmentRecipe.themeLabel`, `driftActor.velocity` (visual tail only), `runTally.accuracy`, `runTally.score`, `runTally.categories.*`, `sessionEnvelope.posture`.
- `semanticEnumPaths[]`: `driftActor.kind→ordinary/gold/gray`, `ruleVerdict.result→success/attention/blocked`, `inputLease.source/armed→success/attention/blocked`, `sessionEnvelope.validity→success/attention/blocked`, `freezeSeal.state/integrity→frozen/blocked`, `runTally.completeness→success/partial`, `bestMark.readState/writeState→success/attention/unknown/blocked`, `stage.openState→success/attention/blocked`.

Machine enums never appear as visible text; mappings consume aliases from §7.3 and render the human label or the component-specific Chinese copy.

### 13.2 Data states and trust

| state | sources / timing | user-visible behavior | trust rule |
|---|---|---|---|
| loading | best read, Stage open, settlement, save | explicit `正在…`; dependent action disabled only | never display placeholder as real value |
| fresh | pose/actor/input current frame/event; immutable verdict; committed segment | normal component state | source owner and calRev must agree |
| aging | transient pose/input gap `<350ms` design threshold | `连接波动`; no new judgment, no miss | retain last geometry, never extrapolate a verdict |
| stale | gap `≥350ms` or calRev mismatch | FreezeSeal + recovery | stale never shown as live |
| offline | no network dependency | run continues; no offline banner | local storage failure is error, not `offline` |
| partial | settlement cannot reconcile all eligible actors | `统计不完整`; no badge/save | current trustworthy rows may remain visible |
| conflicting | duplicate ownership/verdict/category mismatch | blocked/partial state + diagnostic-safe copy | no winner guessed |
| permission_denied | hand/head capability unavailable | controller/conservative path or return | no automatic capability claim |
| error | Stage open, pool ownership, best write, parse failure | specific recovery; preserve prior trusted data | never replace prior best/current result with fabricated zero |

Trust policy: frame/event data is usable only under the current calRev and lease; RuleVerdict is immutable; SegmentRecipe/theme/audio commit atomically; FreezeSeal is all-or-invalid; RunTally must be complete for badge/save; BestMark success is visible only after write success.

### 13.3 Formatting rules

| rule | input path | output | fallback | states |
|---|---|---|---|---|
| active time | `sessionClock.remaining` | zero-padded `mm:ss`; frozen value constant | `时间已暂停` | fresh/aging/stale |
| accuracy | `runTally.correct/eligible` | nearest whole percent + `准确率`; denominator must be >0 | `暂无数据` | complete/partial/error |
| ordinary tally | `categories.ordinary` | `拍对 {correct}/{eligible}` | `暂无数据` | complete/partial |
| gold tally | `categories.gold` | `抓住 {correct}/{eligible}` | `暂无数据` | complete/partial |
| gray tally | `categories.gray` | `避开 {untouched}/{eligible}` | `暂无数据` | complete/partial |
| score / best | `score`, `bestMark.value` | non-negative integer with Chinese label | `暂无数据`; never `0` for null | fresh/error/empty |
| badge | `runTally.badge` | `铜徽章/银徽章/金徽章`; shape redundant | `本局未获得徽章`; partial hides award | complete/partial |
| input source | `inputLease.source/armed` | `手势/手柄/未就绪` | `输入状态未知` | fresh/aging/stale/error |
| segment | `segmentRecipe.index/themeLabel` | `短课` or `第n段 · {themeLabel}` | `段落待核对` | fresh/conflicting |
| save state | `bestMark.writeState` | `正在保存/已保存/未保存，可重试` | `保存状态未知` | loading/fresh/error |

## 14. Platform numbers and asset delivery

- Planar legal range `320×180…2700×1800dp`; this project `760×640…1480×920dp`; Planar depth fixed `640dp`; default distance about `1.75m`; Dynamic worldScale.
- Window radius `32dp`; component radii use 12/20/32dp; controls ≥56dp (project default 64dp); body 18sp and never below 12dp; primary FOV target ≤65°×40°, secondary ≤85°×55°.
- Web glass uses CSS blur only as an approximation and must be labeled; device material/FOV/tracking/comfort remain `not_performed`.

| asset | format / budget | scale / anchor | use / owner |
|---|---|---|---|
| ordinary shell | procedural/vector-derived mesh, ≤240 triangles, no texture | diameter `.16–.20m`, center origin | C5 ordinary |
| gold double-loop | procedural mesh, ≤320 triangles, no texture | diameter `.16–.20m`, center origin | C5 gold |
| gray dashed halo | procedural mesh, ≤192 triangles, no texture | diameter `.16–.20m`, center origin | C5 gray |
| semantic/status icons | tintable SVG, 28/40dp grids, 2dp stroke | center aligned | C1–C8; color+shape |
| ambient contour | procedural line geometry, active vertices ≤512 | user/calRev anchor | C4 |
| UI feedback sounds | WAV or OGG source, 48kHz, short ≤500ms, normalized | actor-local except UI confirmation head-locked | C1/C3/C5/C7/C8; never sole meaning |
| music layers `water_0..5` | seamless OGG, 48kHz stereo, loop ≥30s, matched loudness | non-directional ambient; 1200ms crossfade | C6/SegmentRecipe |

No environment panorama is required. LOD0/LOD1 may halve C5 mesh triangles beyond 2.4m; silhouette and verb remain. Exact file/container and runtime budgets are downstream engine/performance validation, not device evidence.

## 15. Visual minimum-completeness gate

| check | evidence | verdict |
|---|---|---|
| visual direction | §§1–6: 3 distinct directions, structured effect pass, two rejections, V1 frozen | pass |
| visual language | §7 exact tokens/type/semantics/materials/scale/environment | pass |
| window structure | §8 shell, ASCII/Grid, component ownership, spacing and all tiers | pass |
| component structure | §§9–10: 8/8 components each with independent base/layout/sizing/metrics/render/bindings/variants/states+precedence | pass |
| reconciliation | §11 A=9 entities, B=15 tasks, C exhaustive real substates, no unhandled gap | pass |
| semantics/trust/assets | §§12–14 depth/material/Vibrant, data states/format/fallback, platform numbers/assets | pass |

`minimumCompletenessGate=pass` for Visual2. `templateReuse=false`; preview and device validation have not yet been performed.
