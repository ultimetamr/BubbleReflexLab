# Visual System Spec · BubbleReflexLab

> Roles: visual_designer → spatial_design_system_designer | Active revision: 4 | Sources: selected H1 in interaction rev9, PM rev4, UXR rev2, approved V1 | CR-03b reconciliation repair

## 0. Reasoning Guidance

视觉从“温室门、肥皂膜、柔和彩层、风险可读”推导。竞品视觉只作避免高速霓虹通道和信息拥挤的反证，不复用构图/色板/组件。

## 1. Direct Description of Outputs

当前 rev3 交付 V1 视觉参考、tokens、窗口与严格组件系统；CR-03 修复结构而不改变视觉方向。

## 2. Spatial Visual Direction Candidates

| Direction | Spatial thesis | First view | Container/depth | Hierarchy/affordance | Spatial value | Dashboard risk | Preview instruction |
|---|---|---|---|---|---|---|---|
| V1 雾光温室门（selected） | 固定半透明轮廓 gate 像温室拱门，泡泡从远处柔和色雾漂入 | 中央 gate、远处少量泡泡、左上轻时间叶片、右上暂停 | Stage 实体：远泡 z≈−1.7m→gate≈−0.7m；HUD matte 小片，结果平面居中 | 泡泡是唯一主焦点；形/纹/标签提示动作 | 深度路径清楚且不似高速隧道 | low，无多卡片仪表盘 | 柔和暗背景；中央椭圆 gate；三泡形态明显；留白多 |
| V2 纸灯游廊 | 每颗泡像纸灯，沿两侧弧线汇入中央 | 两侧串灯轨迹，中央空白 | 轨迹在左右形成对称回廊 | 来向清楚但轨迹装饰较多 | 方向强，可能诱导扫视 | medium，装饰抢焦点 | 素纸材质、线性路径、低粒子 |
| V3 微缩实验桌 | 小体积盒内有刻度 gate 和样本槽 | 桌面盒+顶部状态条 | Shared Volumetric；近距 | 结构理性、操作精细 | 深度有限、手遮挡 | high，易变“仪表板盒子” | 低饱和实验台、清晰网格、无霓虹 |

**Structured design-effect review (visual approval evidence)**

| Criterion | V1 | V2 | V3 | Decision |
|---|---:|---:|---:|---|
| 三类瞬时可分 | 5 | 4 | 4 | V1 提供最大孤立留白 |
| 单主焦点 | 5 | 3 | 3 | V2 轨迹、V3 刻度竞争 |
| 舒适/低压力 | 5 | 3 | 4 | V1 无通道速度感 |
| H1 gate 语义 | 5 | 4 | 3 | V1 拱门即判定边界 |
| 与 C1/C3 霓虹差异 | 5 | 4 | 5 | V1 用温润肥皂膜而非霓虹 |
| Implementation clarity | 4 | 3 | 4 | V1 清晰但需克制透明排序 |

- **Approved visual reference**：V1「雾光温室门」，structured review verdict=`pass_provisional`，approvalId=`VE-20260813-01`。此处是设计效果审批，不是用户/设备审美验证。
- **Rejected V2**：轨迹装饰增加扫视和速度暗示。
- **Rejected V3**：容器化削弱 Stage 必要性并提升 dashboard 风险。
- **Frozen direction constraints**：中央 gate、单泡主焦点、柔和色段、低粒子、非霓虹隧道、灰泡不使用警报红、不靠颜色单通道。

## 3. Design Tokens

### 3.1 Typography hierarchy

| role | family | size/line/weight |
|---|---|---|
| display | sans | 48sp/56sp/700 |
| title | sans | 28sp/36sp/650 |
| metric | mono | 32sp/38sp/700 |
| body | sans | 18sp/26sp/500 (CJK Medium) |
| caption | sans | 14sp/20sp/500 |

### 3.2 colorSemantics

| key | color | shape | label | desc | aliases[] |
|---|---|---|---|---|---|
| normal | #6FE7E0 | circle | 普通·拍破 | clear round bubble | normal,普通,hit |
| gold | #FFD76A | diamond | 金色·抓住 | crown-ring bubble | gold,金色,grab |
| gray | #9BA3AE | dashed | 灰色·别碰 | porous matte bubble | gray,灰色,untouched |
| correct | #82E6A1 | circle | 正确 | successful terminal | correct,成功 |
| wrong | #FF8F8F | triangle | 需留意 | wrong valid action, never flashing | wrong,错误 |
| paused | #C9C2F2 | square | 已暂停 | all simulation frozen | paused,暂停 |
| tracking | #F4C977 | diamond | 输入恢复中 | hand grace or controller | grace,tracking_lost |

### 3.3 Materials

| name | desc | treatment | glassStyle | opacity |
|---|---|---|---|---:|
| windowFocus | W-START system glass shell only | glass | Thick | .92 |
| hudBacking | Stage HUD readable backing | opaque | none | .88 |
| stageBubble | translucent physical surface; no glass claim | matte | none | .72 |
| pauseFocus | Stage modal solid backing | opaque | none | .94 |

### 3.4 Scale

- spacing: `xs=4, s=8, m=16, l=24, xl=32, xxl=48dp`
- radius: `s=12, m=20, l=32dp`
- iconSize: `s=20, m=28, l=40dp`
- hitTarget: `56dp minimum`; stroke: `1/2/4dp`.
- tokens: `brandPrimary=#83D9D2`, `accentGold=#FFD76A`, `surface=#14242ADD`, `ink=#F7FBFA`, `muted=#B8C8C7`, `dangerSoft=#FF8F8F`, `focus=#FFFFFF`.

## 4. Environment Adaptation Spec

- Bright passthrough: W-START shell uses system Thick glass. Text regions are distinct child panels using opaque #14242A at .78; no single component stacks glass and custom color. Web blur is approximation only.
- Full Space Stage: bubbles/gate use matte/custom shader; never rely on Window glass. HUD uses opaque backing and 4dp silhouette.
- Dark environment: emissive intensity capped; no bloom-based legibility, no full-screen tint flash.
- Vibrant: W-START title/body may use system Vibrant light tier on monochrome glass; propagation stops before any gradient/illustration. Fallback is `ink` on opaque backing. No TabBar.
- Text scaling: 100/125/150%; at 150% reflow, never shrink targets.

## 5. Component Definition Spec

### 5.0 Window structure

**W-START shell**：Planar 1280×720×640dp; min 720×560; max 1560×900; inset 32; attachments none.

```
┌──────────────────────────────────────────┐
│ Header: BubbleReflexLab / best           │
│ ┌───────────────┐ gap24 ┌─────────────┐ │
│ │ Calibration   │       │ Rules Trio   │ │
│ │ ┌╌Halo╌─────┐ │       │ ┌╌3 rows╌─┐ │ │
│ │ └───────────┘ │       │ └─────────┘ │ │
│ └───────────────┘       └─────────────┘ │
│ Actions: [校准互动区] [进入练习]          │
└──────────────────────────────────────────┘
```
Grid 72/1fr/72 rows, 56/44 columns; regions→CalibrationHalo, RulesTrio, InlineActions. Compact/Constrained stack and scroll.

**HUD-PANEL shell**：Planar gameplay 920×228×640dp; min 640×180; max/result 1120×700; inset 24; content 872×180 default; AlertDialog only on destructive end.

```
┌──────────────────────────────────────────┐
│ ┌╌Time/Tier╌┐ ┌╌Prompt/Status╌┐ ┌╌Pause╌┐│
│ result reflow: Badge | Accuracy | 3 rows │
└──────────────────────────────────────────┘
```
Gameplay 3 columns 22/56/22; results two columns then one-column constrained. Regions→GameHUD, ResultConstellation, PauseVeil/Dialog.

### Component: CalibrationHalo

| Field | Content |
|---|---|
| derivedFromTasks | T1 |
| derivedFromData | calibration.status, headPose, floorEstimate |
| Purpose | accept/retry calibrated envelope |
| layoutRole / Priority / runtimeRole | primary_hero / primary / calibrationPreview |

**anatomy.layout** `┌ status ┐ / ├ dashed fan preview ┤ / └ retry + accept ┘`; Grid 3 rows 40/1fr/64.

| sizing tier | W×H | notes |
|---|---|---|
| Regular | 640×500dp | W-START default left region |
| Compact | 656×300dp | stacked |
| Constrained | 656×260dp | preview simplified |

| metric | value | source |
|---|---|---|
| background/radius/padding/gap | glass Thick /32/24/16dp | material+scale |
| stroke/icon/text/hit | 2dp focus/28dp/title+body/56dp | tokens |

| renderSpec id | label/type | bind | semantic |
|---|---|---|---|
| cal-status | “互动区可用”/text+shape | calibration.status | correct/error |
| cal-fan | safe fan diagram/vector | calibration.envelope | display |
| cal-retry | “重新校准”/button | action.recalibrate | control |
| cal-enter | “进入练习”/button | action.enter | control |

| dataBinding | target | fallback | mode |
|---|---|---|---|
| calibration.status | cal-status | “还不能校准” + retry | semantic |
| calibration.envelope | cal-fan | bounded static outline + “待检测” | display-only |

Variants: sitting/standing/unknown. States: default; focused stroke4; pressed 100ms; disabled enter+“先校准”; loading spinner; empty “未校准”; error retry; overflow internal text wrap. Precedence disabled>loading>focused. stacking z: actions>status>preview.

### Component: BubbleActor

| Field | Content |
|---|---|
| derivedFromTasks | T3–T6/T10 |
| derivedFromData | bubble.kind/position/terminal/poolId |
| Purpose | convey class and receive exact action |
| layoutRole / Priority / runtimeRole | primary_hero / primary / spatialTarget |

**anatomy.layout** world sphere; core mesh + class silhouette + texture + optional tutorial label; geometry centered at instance pose.

| tier | diameter | notes |
|---|---:|---|
| Regular | 0.18m | approach |
| Compact | 0.16m | density tier 5 |
| Constrained | 0.20m | tutorial/low vision |

| metric | value | source |
|---|---|---|
| background/radius/padding/gap | matte stageBubble / spherical / n/a / label 0.04m | V1 |
| stroke/icon/text/hit | silhouette 0.008m / glyph 0.05m / caption / collider 0.20m | candidate |

| renderSpec id | label/type | bind | semantic |
|---|---|---|---|
| bubble-mesh | bubble/3D mesh | bubble.kind | normal/gold/gray |
| bubble-glyph | circle/crown-ring/porous-dash | bubble.kind | color-independent |
| bubble-label | 教程短句/text | tutorial.prompt | display |
| bubble-feedback | pop/fold/pass glyph | bubble.terminal | correct/wrong |

| binding | target | fallback | mode |
|---|---|---|---|
| bubble.kind | mesh+glyph | gray dashed “未知·别碰” safe fallback | semantic |
| bubble.terminal | feedback | no feedback until terminal | semantic |
| tutorial.prompt | label | hidden outside tutorial | display-only |

Variants: normal smooth circle; gold diamond/crown ring; gray dashed porous matte. States: pooled hidden; approaching; gate-active outline; focused ≤1.03; pressed/contact; grabbed gold folds inward; terminal; disabled while paused; trackingGrace no collider; error recycle; overflow out-of-bounds recycle. Precedence paused/terminal>grace>interaction. stacking: feedback>glyph>mesh>trail.

### Component: InteractionGate

| Field | Content |
|---|---|
| derivedFromTasks | T3–T6 |
| derivedFromData | gate.pose/calibration/paused |
| Purpose | fixed judgment boundary without obstacle semantics |
| layoutRole / Priority / runtimeRole | critical_primary / primary / spatialBoundary |

**anatomy.layout** world ellipse rim + center air volume + lower calibration notch; no solid wall.

| tier | W×H×D | notes |
|---|---|---|
| Regular | .84×.72×.22m | candidate default |
| Compact | .72×.62×.20m | seated validation only |
| Constrained | .64×.56×.18m | below requires recalibration |

| metric | value | source |
|---|---|---|
| background/radius/padding/gap | none / ellipse / n/a / n/a | Stage |
| stroke/icon/text/hit | rim .012m / notch .04m / caption / no direct hit | candidate |

| renderSpec id | label/type | bind | semantic |
|---|---|---|---|
| gate-rim | 互动区/ellipse | gate.pose | boundary |
| gate-progress | pass segment | bubble.timeToGate | display |
| gate-status | 已冻结/待校准 text+shape | gate.state | paused/error |

| binding | target | fallback | mode |
|---|---|---|---|
| gate.pose | rim | hide + require calibration | display-only |
| gate.state | status | “待校准” | semantic |

Variants: tutorial/game/calibration. States: default faint; focused none; pressed n/a; disabled uncalibrated; loading; empty hidden; error red-soft triangle+text; overflow forbidden; paused square+text. Precedence error>paused>default. stacking status>rim>progress.

### Component: GameHUD

| Field | Content |
|---|---|
| derivedFromTasks | T3–T8 |
| derivedFromData | clock/tier/theme/input/tutorial |
| Purpose | time, short prompt, input continuity, pause |
| layoutRole / Priority / runtimeRole | supporting / primary / statusControl |

**anatomy.layout** `time+tier | prompt/status | pause`; Grid 1×3 22/56/22.

| tier | W×H | notes |
|---|---|---|
| Regular | 920×180dp | HUD default |
| Compact | 720×180dp | shorter labels |
| Constrained | 640×240dp | 2 rows |

| metric | value | source |
|---|---|---|
| background/radius/padding/gap | opaque hudBacking /32/24/16 | tokens |
| stroke/icon/text/hit | 1dp/28/title+metric+body/56 | scale |

| renderSpec id | label/type | bind | semantic |
|---|---|---|---|
| hud-time | 02:30/metric | clock.remaining | display |
| hud-tier | 第1档/label | tier.index | display |
| hud-prompt | 拍破普通泡泡/text | tutorial.prompt | display |
| hud-input | 手势恢复中/badge | input.state | tracking |
| hud-pause | 暂停/button | action.pause | control |

| binding | target | fallback | mode |
|---|---|---|---|
| clock.remaining | time | “--:--” + paused-safe | display-only |
| tier.index | tier | “教学” | display-only |
| tutorial.prompt | prompt | “看形状，选动作” | display-only |
| input.state | badge | “使用手柄继续” | semantic |

Variants: tutorial/game/reduceMotion/controller. States: default; focused pause stroke4; pressed; disabled while modal; loading clock; empty prompt hidden; error input fallback; overflow ellipsis+tooltip; paused square label. precedence modal>paused>error>focused. stacking dialog>input>pause>prompt.

### Component: PauseVeil

| Field | Content |
|---|---|
| derivedFromTasks | T7 |
| derivedFromData | pause.snapshot/clock/actions |
| Purpose | prove freeze and offer resume/end |
| layoutRole / Priority / runtimeRole | critical_primary / primary / modalControl |

**anatomy.layout** title / freeze proof / resume,recalibrate,end; Grid 3 rows.

| tier | W×H | notes |
|---|---|---|
| Regular | 640×420dp | Stage center |
| Compact | 560×420dp | wrap actions |
| Constrained | 480×520dp | vertical actions |

| metric | value | source |
|---|---|---|
| background/radius/padding/gap | opaque pauseFocus /32/32/16 | tokens |
| stroke/icon/text/hit | 2dp/40/display+body/56 | scale |

| renderSpec id | label/type | bind | semantic |
|---|---|---|---|
| pause-title | 已暂停/text+square | pause.active | paused |
| pause-proof | 泡泡与计时已冻结/text | pause.snapshot | display |
| pause-resume | 继续/button | action.resume | control |
| pause-recalibrate | 重新校准/button | action.recalibrate | control |
| pause-end | 结束本局/button | action.end | high-risk |

| binding | target | fallback | mode |
|---|---|---|---|
| pause.active | title | if false hide component | semantic |
| pause.snapshot | proof | “正在确认冻结…”; keep actions disabled | display-only |

Variants: normal/confirm-dialog. States: default; focused; pressed; disabled until snapshot; loading; empty impossible→error; error “无法冻结，返回开始”; overflow scroll; confirmation dialog. precedence error>dialog>disabled>focused. stacking dialog>actions>proof.

### Component: ResultConstellation

| Field | Content |
|---|---|
| derivedFromTasks | T9 |
| derivedFromData | stats/byKind/badge/best/storage |
| Purpose | explain accuracy/category outcomes and next action |
| layoutRole / Priority / runtimeRole | primary_hero / primary / resultSummary |

**anatomy.layout** badge+accuracy / three category rows / best+save / replay+return; Grid 4 rows, result Large 2 columns.

| tier | W×H | notes |
|---|---|---|
| Regular/Large | 1120×700dp | result expanded HUD |
| Compact | 920×640dp | single column |
| Constrained | 640×560dp | internal scroll |

| metric | value | source |
|---|---|---|
| background/radius/padding/gap | opaque hudBacking /32/32/16 | tokens |
| stroke/icon/text/hit | 1dp/40/display+metric+body/56 | scale |

| renderSpec id | label/type | bind | semantic |
|---|---|---|---|
| result-badge | 铜/银/金/medallion+label | result.badge | semantic shape |
| result-accuracy | 准确率 86%/metric | stats.accuracy | display |
| result-normal | 普通 8/10/row | stats.normal | normal |
| result-gold | 金色 4/5/row | stats.gold | gold |
| result-gray | 灰色 6/6/row | stats.gray | gray |
| result-best | 最高分 1240/text | best.score | display |
| result-save | 最高分已保存/status | storage.state | semantic |
| result-replay | 再玩一局/button | action.replay | control |
| result-return | 返回/button | action.return | control |

| binding | target | fallback | mode |
|---|---|---|---|
| result.badge | badge | 铜牌 + “未达到完整统计” | semantic |
| stats.* | accuracy/rows | “本类暂无泡泡” | display-only |
| best.score | best | “暂无最高分” | display-only |
| storage.state | save | “本局已保留，最高分未更新” + retry | semantic |

Variants: bronze/silver/gold/partial/saveError. States: default; focused actions; pressed; disabled during save; loading; empty; error retry; overflow internal scroll; partial explicit label. precedence saveError>partial>badge. stacking actions>save>metrics>badge.

### 5.1 Component structure completeness checklist

| Component | base | layout | sizing | metrics | renderSpec | bindings | variants | states+stack | Verdict |
|---|---|---|---|---|---|---|---|---|---|
| CalibrationHalo | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| BubbleActor | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| InteractionGate | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| GameHUD | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| PauseVeil | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| ResultConstellation | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| EndRunDialog | yes | yes | yes | yes | yes | yes | yes | yes | pass |

### 5.2 Coverage reconciliation

**Table A · Data entity → binding**

| Entity/variable | Timeliness | Component binding | Presentation | Disposition |
|---|---|---|---|---|
| SessionClock | frame | GameHUD.clock.remaining | mm:ss | bound |
| DifficultyTier/ThemeLayer | 30s | GameHUD.tier.index; CSS/scene theme token | human label/theme | bound |
| BubbleInstance kind/pose/terminal | frame/event | BubbleActor | shape+color+motion | bound |
| InputSample/lastValidAt | frame | GameHUD.input.state; BubbleActor grace | label+diamond | bound |
| JudgementEvent | event | BubbleActor.feedback; result stats | semantic+count | bound |
| SessionStats | event | ResultConstellation stats.* | accuracy/rows | bound |
| BestScore/storage | result/write | ResultConstellation | score+freshness | bound |
| Calibration/gate pose | calibration/frame | CalibrationHalo; InteractionGate | envelope/state | bound |
| Pool counters | event | intentionally not presented; diagnostic-only, no player decision | none | intentional |

**Table B · Task output → interaction**

| Task/output | mode | Component+element+behavior | Disposition |
|---|---|---|---|
| T1 accept/retry | actionable | CalibrationHalo cal-retry/cal-enter | bound |
| T2 enter/stay | actionable | cal-enter/system back | bound |
| T3 hit | actionable | BubbleActor normal collider | bound |
| T4 grab | actionable | BubbleActor gold grab state | bound |
| T5 untouched | actionable by restraint | InteractionGate pass + BubbleActor terminal | bound |
| T6 terminal decision | actionable | BubbleActor + ledger precedence | bound |
| T7 pause/resume/end | actionable | GameHUD pause + PauseVeil | bound |
| T8 source recovery | actionable/system | GameHUD input + controller | bound |
| T9 replay/return/retry | actionable | Result elements | bound |
| T10 release | system | BubbleActor terminal/out-of-bounds | bound |

**Table C · Primary substates**

| Component→subpart | Runtime substates | Primitive | Binding |
|---|---|---|---|
| CalibrationHalo→preview/actions | loading/empty/error/disabled/focused | fan/status/buttons | calibration.* |
| BubbleActor→mesh/collider/feedback | pooled/approach/gate/grace/paused/terminal/error | mesh/glyph/collider/feedback | bubble.* + input.state |
| InteractionGate→rim/status | calibrated/uncalibrated/paused/error | ellipse/text+shape | gate.* |
| GameHUD→clock/prompt/input/pause | tutorial/game/loading/error/paused/overflow | text/badge/button | clock/tier/input |
| PauseVeil→proof/actions/dialog | loading/disabled/error/confirm | text/buttons/dialog | pause.* |
| Result→badge/stats/storage/actions | loading/empty/partial/error/overflow/save | medallion/rows/status/buttons | result/stats/storage |

### 5.3 CR-03 Authoritative Component Blocks

> 本节替代此前 §5 中压缩表达的组件块；评审只以本节为八段结构事实。所有尺寸均适配所属 host 的 content area；无通配 binding。

#### Component: CalibrationHalo

| Field | Content |
|---|---|
| derivedFromTasks | T1,T2 |
| derivedFromData | calibration.status; calibration.headPose; calibration.floorEstimate; calibration.envelope |
| Purpose | 预览并接受/重试安全互动区 |
| layoutRole | primary_hero |
| Priority | primary |
| runtimeRole | calibrationPreview |

**Anatomy · Layout**

```
┌ status ───────────────┐
│ ┌╌ fan preview ╌────┐ │
│ └───────────────────┘ │
├ retry ─────── enter ──┤
└───────────────────────┘
```

Grid: 3 rows `40dp/1fr/64dp`; 2 action columns; owner `W-START`; anchor=center of left region.

**Sizing**

| Tier | Host outer/content | Component | Fit/reflow |
|---|---|---|---|
| Regular | 1280×720 / 1216×656dp | 640×500 | pass, left 56% region |
| Compact | 920×640 / 856×576dp | 856×320 | pass, stacked full width |
| Constrained | 720×560 / 656×496dp | 656×300 | pass, preview height 156dp |

**Metrics**

| Metric | Value | Source |
|---|---|---|
| background | customColor `#14242AC7` | distinct child panel, no glass stack |
| radius | 32dp | scale.l |
| padding | 24dp | scale.l |
| internal gap | 16dp | scale.m |
| stroke | 2dp `#FFFFFF` | focus token |
| iconSize | 28dp | scale.m |
| primary text | title 28/36/650 | typography.title |
| secondary text | body 18/26/500 | typography.body |
| hitTarget | 56×56dp | platform/project minimum |

**renderSpec.elements[]**

| id | label | type | bind | role |
|---|---|---|---|---|
| cal-status | 互动区可用 | text+shape | calibration.status | semantic status |
| cal-fan | 安全扇形 | vector | calibration.envelope | preview |
| cal-retry | 重新校准 | button | action.recalibrate | action |
| cal-enter | 进入练习 | button | action.enterStage | action |

**dataBindings[]**

| Source path | Target/property | fallback | type |
|---|---|---|---|
| calibration.status | cal-status.text/semantic | 还不能校准 + triangle | semantic |
| calibration.headPose | cal-fan.origin | hide fan; disable enter | display-only |
| calibration.floorEstimate | cal-fan.floorLine | 未检测地面; use seated candidate only after confirmation | display-only |
| calibration.envelope | cal-fan.geometry | static candidate outline + 待检测 | display-only |

**Variants**

| Variant | Difference |
|---|---|
| sitting | lower gate preview; label 坐姿 |
| standing | standard gate preview; label 站姿 |
| unknown | entry disabled; asks choose/retry |

**States**

| State | Trigger | Visual | Size | Motion | Accessibility |
|---|---|---|---|---|---|
| default | valid sample | white 2dp | none | none | status text+shape |
| focused | gaze action | 4dp focus | ≤1.03 | 120ms | spoken label |
| pressed | pinch | darker action | .98 | 80ms | haptic/controller |
| disabled | invalid | enter .45 opacity | none | none | explains cause |
| loading | sampling | static dots | none | 600ms; RM static | 正在校准 |
| empty | no pose | fan hidden | none | none | 未检测到头部 |
| error | invalid floor | triangle+soft red | none | none | retry text |
| overflow | text 150% | internal wrap | height grows | none | no truncation |

Stacking precedence: `error > disabled > loading > focused > default`; actions > status > preview.

#### Component: BubbleActor

| Field | Content |
|---|---|
| derivedFromTasks | T3,T4,T5,T6,T10 |
| derivedFromData | bubble.kind; bubble.position; bubble.terminal; bubble.poolId; bubble.bounds; input.state; input.lastValidAt |
| Purpose | 呈现类别并接受唯一动作终局 |
| layoutRole | primary_hero |
| Priority | primary |
| runtimeRole | spatialTarget |

**Anatomy · Layout**

```
      [tutorial label]
   ┌── class glyph ──┐
   │   core mesh     │
   └─ collider/rim ──┘
        feedback
```

World geometry: head-relative spawn h±35°, v−20…+18°, r1.35–2.10m; travels to gate center at forward .70m/y−.20m; faces head; label 0.04m above.

**Sizing**

| Tier | Host/world envelope | Component | Fit/reflow |
|---|---|---|---|
| Regular | Stage SafeFan | Ø0.18m; collider Ø0.20m | pass; max 3 gate-near |
| Compact | tier5 density | Ø0.16m; collider Ø0.19m | pass; separation ≥0.12m |
| Constrained | tutorial/low vision | Ø0.20m; collider Ø0.22m | pass; active count reduced |

**Metrics**

| Metric | Value | Source |
|---|---|---|
| background | none (stage material on mesh) | no window glass |
| radius | spherical | asset geometry |
| padding | n/a | world entity |
| internal gap | label 0.04m | V1 |
| stroke | silhouette 0.008m | visibility candidate |
| iconSize | glyph 0.05m | world metric |
| primary text | caption 14/20/500 | tutorial label |
| secondary text | caption 14/20/500 | feedback |
| hitTarget | collider ≥Ø0.19m | device-tuned candidate |

**renderSpec.elements[]**

| id | label | type | bind | role |
|---|---|---|---|---|
| bubble-mesh | 泡泡 | 3D mesh | bubble.kind | class body |
| bubble-glyph | 圆/冠环/虚线孔 | 3D glyph | bubble.kind | redundant class |
| bubble-label | 教程提示 | text | tutorial.prompt | instruction |
| bubble-hit-zone | 拍击区 | collider | action.hit | interaction |
| bubble-grab-zone | 抓取区 | collider | action.grab | interaction |
| bubble-feedback | 正确/需留意 | glyph+text | bubble.terminal | receipt |

**dataBindings[]**

| Source path | Target/property | fallback | type |
|---|---|---|---|
| bubble.kind | mesh/glyph variant | gray dashed + 未知·别碰 | semantic |
| bubble.position | entity transform | release without score if invalid | display-only |
| bubble.terminal | feedback/state | none until immutable terminal | semantic |
| bubble.poolId | lifecycle identity | quarantine instance, no score | display-only |
| bubble.bounds | release test | release when outside | display-only |
| input.state | collider armed | disarm during grace | semantic |
| input.lastValidAt | rearm timer | remain disarmed | display-only |
| tutorial.prompt | label text | hidden outside tutorial | display-only |

**Variants**

| Variant | Difference |
|---|---|
| normal | cyan smooth circle; hit armed |
| gold | gold diamond+crown ring; grab armed |
| gray | gray dashed porous matte; no action requested |

**States**

| State | Trigger | Visual | Size | Motion | Accessibility |
|---|---|---|---|---|---|
| pooled | inactive | hidden | 0 | none | none |
| approaching | acquired | class visible | tier size | linear 4.8–7s | glyph+label |
| gate-active | enters gate | 2dp equivalent rim | ≤1.02 | none | audio cue optional |
| focused | gaze | rim bright | ≤1.03 | 120ms | no color-only |
| pressed | valid contact | contact dent | .97 | 80ms | haptic |
| grabbed | valid gold hold | fold inward | .95 | 240ms/RM100 | “抓住” |
| trackingGrace | input lost | dotted rim | none | none | 输入恢复中 |
| paused | pause | .55 opacity + square | none | frozen | 已暂停 |
| terminal | ledger write | receipt | +.08m max | 180–240/RM static | text+shape+sound |
| error | invalid transform/id | soft triangle | none | none | recycle, no penalty |
| overflow | bounds exit | hidden/released | none | none | no score unless gray valid pass |

Stacking precedence: `terminal > paused > trackingGrace > pressed/grabbed > focused > approaching > pooled`; feedback > glyph > mesh > trail.

#### Component: InteractionGate

| Field | Content |
|---|---|
| derivedFromTasks | T3,T4,T5,T6 |
| derivedFromData | gate.pose; gate.calibrationStatus; pause.active; bubble.timeToGate |
| Purpose | 固定判定边界，不形成障碍 |
| layoutRole | critical_primary |
| Priority | primary |
| runtimeRole | spatialBoundary |

**Anatomy · Layout**

```
   ┌── ellipse rim ──┐
   │  open air gate  │
   └ notch/status ───┘
```

World geometry: head-relative center forward .70m, vertical −.20m; faces head; regular .84×.72×.22m; open center, no collision wall.

**Sizing**

| Tier | Host/world envelope | Component | Fit/reflow |
|---|---|---|---|
| Regular | calibrated Stage | .84×.72×.22m | pass candidate |
| Compact | seated candidate | .72×.62×.20m | pass after reach validation |
| Constrained | minimum | .64×.56×.18m | otherwise recalibrate |

**Metrics**

| Metric | Value | Source |
|---|---|---|
| background | none | open gate |
| radius | ellipse | world geometry |
| padding | n/a | world entity |
| internal gap | status 0.03m below rim | V1 |
| stroke | rim .012m | candidate |
| iconSize | notch .04m | world metric |
| primary text | body 18/26/500 | state label |
| secondary text | caption 14/20/500 | calibration |
| hitTarget | none | not directly interactive |

**renderSpec.elements[]**

| id | label | type | bind | role |
|---|---|---|---|---|
| gate-rim | 互动区 | ellipse mesh | gate.pose | boundary |
| gate-progress | 接近 | segment | bubble.timeToGate | approach cue |
| gate-status | 已冻结/待校准 | text+shape | gate.calibrationStatus | status |

**dataBindings[]**

| Source path | Target/property | fallback | type |
|---|---|---|---|
| gate.pose | rim transform | hide; require calibration | display-only |
| gate.calibrationStatus | status/rim | 待校准+triangle | semantic |
| pause.active | status/freeze | 已冻结+square | semantic |
| bubble.timeToGate | progress length | hide segment | display-only |

**Variants**

| Variant | Difference |
|---|---|
| tutorial | stronger rim + instruction label |
| game | faint rim, no persistent text |
| calibration | dashed candidate outline |

**States**

| State | Trigger | Visual | Size | Motion | Accessibility |
|---|---|---|---|---|---|
| default | calibrated | faint rim | regular | none | open-center semantics |
| focused | bubble near | rim +15% | none | 120ms/RM static | audio optional |
| pressed | n/a | unchanged | none | none | not interactive |
| disabled | uncalibrated | dashed triangle | none | none | 待校准 |
| loading | recalibrating | static dots | none | RM static | 正在校准 |
| empty | no pose | hidden | none | none | return calibration |
| error | invalid pose | soft red triangle | none | none | 重试 |
| overflow | cannot fit | hidden | none | none | recalibrate |
| paused | pause | square+已冻结 | none | frozen | explicit text |

Stacking precedence: `error > paused > disabled/loading > focused > default`; status > rim > progress.

#### Component: GameHUD

| Field | Content |
|---|---|
| derivedFromTasks | T3,T4,T5,T6,T7,T8 |
| derivedFromData | clock.remaining; tier.index; tier.label; theme.index; tutorial.prompt; input.state; input.lastValidAt |
| Purpose | 提供时间/档位/短提示/输入状态/暂停 |
| layoutRole | supporting |
| Priority | primary |
| runtimeRole | statusControl |

**Anatomy · Layout**

```
┌ time+tier ┬ prompt+input ┬ pause ┐
└───────────┴──────────────┴───────┘
```

Grid 1×3 `22/56/22`; Constrained 2 rows; owner `HUD-PANEL`.

**Sizing**

| Tier | Host outer/content | Component | Fit/reflow |
|---|---|---|---|
| Regular | 920×228 / 872×180dp | 872×180 | exact content fit |
| Compact | 720×228 / 672×180dp | 672×180 | shorter prompt |
| Constrained | 640×276 / 592×228dp | 592×228 | 2 rows; 150% wrap |

**Metrics**

| Metric | Value | Source |
|---|---|---|
| background | customColor `#14242AE0` | no glass |
| radius | 32dp | scale.l |
| padding | 24dp | scale.l |
| internal gap | 16dp | scale.m |
| stroke | 1dp muted | token |
| iconSize | 28dp | scale.m |
| primary text | metric 32/38/700 | time |
| secondary text | body 18/26/500 | labels |
| hitTarget | 56×56dp | pause |

**renderSpec.elements[]**

| id | label | type | bind | role |
|---|---|---|---|---|
| hud-time | 02:30 | metric | clock.remaining | time |
| hud-tier | 第1档 | text | tier.label | difficulty |
| hud-theme | 薄荷晨光 | text | theme.index | theme |
| hud-prompt | 拍破普通泡泡 | text | tutorial.prompt | instruction |
| hud-input | 输入恢复中 | badge | input.state | continuity |
| hud-pause | 暂停 | button | action.pause | action |

**dataBindings[]**

| Source path | Target/property | fallback | type |
|---|---|---|---|
| clock.remaining | hud-time.text | --:-- and freeze | display-only |
| tier.index | hud-tier.order | 0 | display-only |
| tier.label | hud-tier.text | 教学 | display-only |
| theme.index | hud-theme.text/token | 柔和主题; base tokens | display-only |
| tutorial.prompt | hud-prompt.text | 看形状，选动作 | display-only |
| input.state | hud-input.semantic | 使用手柄继续 | semantic |
| input.lastValidAt | hud-input.detail | hide numeric, keep recovery label | display-only |

**Variants**

| Variant | Difference |
|---|---|
| tutorial | persistent prompt |
| game | prompt only on feedback |
| controller | shows button/grip glyphs |
| reduceMotion | no animated progress |

**States**

| State | Trigger | Visual | Size | Motion | Accessibility |
|---|---|---|---|---|---|
| default | game | opaque strip | regular | none | text+icons |
| focused | gaze pause | stroke4 | pause≤1.03 | 120ms | spoken 暂停 |
| pressed | pinch/button | pause .98 | none | 80ms | haptic |
| disabled | D1 modal | pause .45 | none | none | 已打开确认 |
| loading | clock init | --:-- | none | static | 正在准备 |
| empty | no tutorial prompt | prompt hidden | none | none | no gap |
| error | input loss | diamond+text | wraps | none | controller instruction |
| overflow | 150% text | 2-row reflow | 592×228 | none | no ellipsis for status |
| paused | pause | square+已暂停 | none | frozen | explicit label |

Stacking precedence: `modal/disabled > paused > error > focused > default`; dialog > input > pause > prompt.

#### Component: PauseVeil

| Field | Content |
|---|---|
| derivedFromTasks | T7 |
| derivedFromData | pause.active; pause.snapshotPositions; pause.snapshotClock; action.resume; action.recalibrate; action.requestEnd |
| Purpose | 证明冻结并提供恢复/校准/结束 |
| layoutRole | critical_primary |
| Priority | primary |
| runtimeRole | modalControl |

**Anatomy · Layout**

```
┌ 已暂停 ───────────┐
│ freeze proof      │
├ 继续 / 重校准 / 结束 ┤
└───────────────────┘
```

Grid 3 rows `64/1fr/72`; owner HUD-PANEL result-capable envelope; centered at 0.9m.

**Sizing**

| Tier | Host outer/content | Component | Fit/reflow |
|---|---|---|---|
| Regular | 920×560 / 872×512dp | 640×420 | pass centered |
| Compact | 720×560 / 672×512dp | 560×420 | pass |
| Constrained | 640×568 / 592×520dp | 480×520 | pass; actions vertical |

**Metrics**

| Metric | Value | Source |
|---|---|---|
| background | customColor `#14242AF0` | no glass |
| radius | 32dp | scale.l |
| padding | 32dp | scale.xl |
| internal gap | 16dp | scale.m |
| stroke | 2dp focus | token |
| iconSize | 40dp | scale.l |
| primary text | display 48/56/700 | typography |
| secondary text | body 18/26/500 | typography |
| hitTarget | 56×56dp | minimum |

**renderSpec.elements[]**

| id | label | type | bind | role |
|---|---|---|---|---|
| pause-title | 已暂停 | text+square | pause.active | status |
| pause-proof-position | 泡泡已冻结 | text | pause.snapshotPositions | proof |
| pause-proof-clock | 计时已冻结 | text | pause.snapshotClock | proof |
| pause-resume | 继续 | button | action.resume | action |
| pause-recalibrate | 重新校准 | button | action.recalibrate | action |
| pause-end | 结束本局 | button | action.requestEnd | risky action |

**dataBindings[]**

| Source path | Target/property | fallback | type |
|---|---|---|---|
| pause.active | component visibility | hide if false | semantic |
| pause.snapshotPositions | position proof | 正在确认冻结; disable actions | display-only |
| pause.snapshotClock | clock proof | 正在确认冻结; disable actions | display-only |
| action.resume | resume enabled | disabled until proof | display-only |
| action.recalibrate | recalibrate enabled | disabled until proof | display-only |
| action.requestEnd | open EndRunDialog | disabled until proof | display-only |

**Variants**

| Variant | Difference |
|---|---|
| normal | horizontal actions |
| constrained | vertical actions |
| freezeError | only return-start recovery |

**States**

| State | Trigger | Visual | Size | Motion | Accessibility |
|---|---|---|---|---|---|
| default | snapshot valid | opaque focus | tier | none | explicit freeze proof |
| focused | gaze action | stroke4 | ≤1.03 | 120ms | spoken labels |
| pressed | pinch | .98 | none | 80ms | haptic |
| disabled | proof pending | actions .45 | none | none | explains wait |
| loading | snapshot capture | static dots | none | RM static | 正在暂停 |
| empty | missing snapshot | triangle | none | none | cannot resume |
| error | freeze mismatch | soft red+return | none | none | 安全返回 |
| overflow | text150 | vertical scroll/actions | constrained | none | no clipped actions |

Stacking precedence: `error > loading/disabled > focused > default`; EndRunDialog > actions > proof.

#### Component: ResultConstellation

| Field | Content |
|---|---|
| derivedFromTasks | T9 |
| derivedFromData | result.badge; stats.totalCorrect; stats.totalAttempt; stats.normalCorrect; stats.normalAttempt; stats.goldCorrect; stats.goldAttempt; stats.grayCorrect; stats.grayAttempt; best.score; storage.state |
| Purpose | 解释准确率、类别、徽章、最高分并承接下一步 |
| layoutRole | primary_hero |
| Priority | primary |
| runtimeRole | resultSummary |

**Anatomy · Layout**

```
┌ badge ─ accuracy ┐
│ normal / gold / gray rows │
│ best ─ storage/retry      │
├ replay ───── return ──────┤
└───────────────────────────┘
```

Grid 4 rows, Large first row 2 columns; owner HUD-PANEL max/result.

**Sizing**

| Tier | Host outer/content | Component | Fit/reflow |
|---|---|---|---|
| Large | 1120×700 / 1072×652dp | 1072×652 | exact content fit |
| Compact | 920×688 / 872×640dp | 872×640 | one column |
| Constrained | 640×608 / 592×560dp | 592×560 | internal scroll; actions sticky |

**Metrics**

| Metric | Value | Source |
|---|---|---|
| background | customColor `#14242AE0` | hudBacking |
| radius | 32dp | scale.l |
| padding | 32dp | scale.xl |
| internal gap | 16dp | scale.m |
| stroke | 1dp muted | token |
| iconSize | 40dp | scale.l |
| primary text | display/metric | typography |
| secondary text | body 18/26/500 | typography |
| hitTarget | 56×56dp | minimum |

**renderSpec.elements[]**

| id | label | type | bind | role |
|---|---|---|---|---|
| result-badge | 铜牌/银牌/金牌 | medallion+text | result.badge | semantic |
| result-accuracy | 准确率 86% | metric | stats.totalCorrect+stats.totalAttempt | metric |
| result-normal | 普通 8/10 | row | stats.normalCorrect+stats.normalAttempt | category |
| result-gold | 金色 4/5 | row | stats.goldCorrect+stats.goldAttempt | category |
| result-gray | 灰色 6/6 | row | stats.grayCorrect+stats.grayAttempt | category |
| result-best | 最高分 1240 | text | best.score | record |
| result-save | 最高分已保存 | status | storage.state | trust |
| result-save-retry | 重试保存 | button | action.retrySave | recovery |
| result-replay | 再玩一局 | button | action.replay | action |
| result-return | 返回 | button | action.returnShared | stable exit |

**dataBindings[]**

| Source path | Target/property | fallback | type |
|---|---|---|---|
| result.badge | result-badge | 铜牌+统计不完整 | semantic |
| stats.totalCorrect | accuracy numerator | 0 | display-only |
| stats.totalAttempt | accuracy denominator | 暂无判定 | display-only |
| stats.normalCorrect | normal numerator | 0 | display-only |
| stats.normalAttempt | normal denominator | 本类暂无泡泡 | display-only |
| stats.goldCorrect | gold numerator | 0 | display-only |
| stats.goldAttempt | gold denominator | 本类暂无泡泡 | display-only |
| stats.grayCorrect | gray numerator | 0 | display-only |
| stats.grayAttempt | gray denominator | 本类暂无泡泡 | display-only |
| best.score | result-best | 暂无最高分 | display-only |
| storage.state | result-save/retry visibility | 本局已保留，最高分未更新 | semantic |

**Variants**

| Variant | Difference |
|---|---|
| bronze | copper circle+label |
| silver | silver square+label |
| gold | gold diamond+label |
| partial | explicit 提前结束; badge provisional |
| saveError | retry visible |

**States**

| State | Trigger | Visual | Size | Motion | Accessibility |
|---|---|---|---|---|---|
| default | computed | all metrics | tier | none | labels+shapes |
| focused | gaze action | stroke4 | ≤1.03 | 120ms | spoken label |
| pressed | pinch | .98 | none | 80ms | haptic |
| disabled | saving | replay optional; retry disabled | none | none | 保存中 |
| loading | compute/read | skeleton text | none | RM static | 正在结算 |
| empty | zero attempts | 暂无判定 | none | none | no divide by zero |
| error | storage failure | triangle+retry | none | none | failure copy |
| overflow | 150%/small | scroll, sticky actions | constrained | none | no clipped stats |
| partial | early end | 提前结束 label | none | none | stats remain honest |

Stacking precedence: `error/saveError > partial > loading > focused > default`; actions > storage > metrics > badge.

#### Component: EndRunDialog

| Field | Content |
|---|---|
| derivedFromTasks | T7 |
| derivedFromData | dialog.open; dialog.originState; action.confirmEnd; action.cancelEnd |
| Purpose | 确认结束本局/退出 Stage 的破坏性操作 |
| layoutRole | critical_primary |
| Priority | primary |
| runtimeRole | confirmationDialog |

**Anatomy · Layout**

```
┌ 要结束本局吗？ ┐
│ 当前进度会结算 │
├ 继续游戏 / 结束 ┤
└─────────────────┘
```

Grid 3 rows; in-window AlertDialog owned by HUD-PANEL, centered, modal scrim over PauseVeil/GameHUD.

**Sizing**

| Tier | Host outer/content | Component | Fit/reflow |
|---|---|---|---|
| Regular | 920×560 / 872×512dp | 520×320 | pass |
| Compact | 720×560 / 672×512dp | 520×320 | pass |
| Constrained | 640×568 / 592×520dp | 480×380 | pass; actions vertical |

**Metrics**

| Metric | Value | Source |
|---|---|---|
| background | customColor `#14242AF5` | critical opaque |
| radius | 32dp | scale.l |
| padding | 32dp | scale.xl |
| internal gap | 16dp | scale.m |
| stroke | 2dp focus | token |
| iconSize | 28dp | scale.m |
| primary text | title 28/36/650 | typography |
| secondary text | body 18/26/500 | typography |
| hitTarget | 56×56dp | minimum |

**renderSpec.elements[]**

| id | label | type | bind | role |
|---|---|---|---|---|
| end-title | 要结束本局吗？ | text | dialog.open | warning |
| end-body | 当前进度会结算 | text | dialog.originState | consequence |
| end-cancel | 继续游戏 | button | action.cancelEnd | safe action |
| end-confirm | 结束本局 | button | action.confirmEnd | destructive action |

**dataBindings[]**

| Source path | Target/property | fallback | type |
|---|---|---|---|
| dialog.open | visibility | hidden | semantic |
| dialog.originState | end-body detail | 当前进度会结算 | display-only |
| action.cancelEnd | cancel enabled | system back performs cancel | display-only |
| action.confirmEnd | confirm enabled | disabled if ledger locked | display-only |

**Variants**

| Variant | Difference |
|---|---|
| endRun | ends to partial results |
| exitStage | closes Stage after result/when no run |

**States**

| State | Trigger | Visual | Size | Motion | Accessibility |
|---|---|---|---|---|---|
| default | open | opaque + scrim | tier | 120ms/RM instant | focus trapped |
| focused | gaze button | stroke4 | ≤1.03 | 120ms | spoken consequence |
| pressed | pinch | .98 | none | 80ms | haptic |
| disabled | ledger locked | confirm .45 | none | none | explains wait |
| loading | ending | static dots | none | RM static | 正在结算 |
| empty | n/a | default body | none | none | safe copy |
| error | end failure | triangle+return | none | none | retry/cancel |
| overflow | text150 | vertical actions | constrained | none | scroll body |

Stacking precedence: `error > loading/disabled > focused > default`; dialog > PauseVeil > GameHUD > Stage.

#### Supporting elements (not core components)

- `RulesTrio`: three static rule rows inside W-START, bound to fixed localized copy; intentionally supporting because it has no independent runtime state machine.
- `InlineActions`: W-START action region embeds `cal-retry/cal-enter` already owned by CalibrationHalo.
- `JudgmentReceipt`: `bubble-feedback` subcomponent of BubbleActor, not a separate component.
- `Best score on S0`: supporting text bound to `best.score`, fallback “暂无最高分”; same path/format contract as ResultConstellation.

### 5.4 CR-03 Coverage Reconciliation (authoritative)

**A · one entity/path per row**

| Path | Timeliness | Component.binding | Method | Disposition |
|---|---|---|---|---|
| calibration.status | calibration | CalibrationHalo | semantic | bound |
| calibration.headPose | frame during calibration | CalibrationHalo | preview origin | bound |
| calibration.floorEstimate | calibration | CalibrationHalo | floor line | bound |
| calibration.envelope | calibration | CalibrationHalo | vector | bound |
| clock.remaining | frame | GameHUD | mm:ss | bound |
| tier.index | 30s | GameHUD | order | bound |
| tier.label | 30s | GameHUD | Chinese label | bound |
| theme.index | 30s | GameHUD | label+tokens | bound |
| bubble.kind | acquire | BubbleActor | semantic | bound |
| bubble.position | frame | BubbleActor | transform | bound |
| bubble.terminal | event | BubbleActor | receipt | bound |
| bubble.poolId | lifecycle | BubbleActor | identity | bound |
| bubble.bounds | frame | BubbleActor | recycle | bound |
| input.state | frame | GameHUD+BubbleActor | continuity/disarm | bound |
| input.lastValidAt | frame | GameHUD+BubbleActor | rearm | bound |
| gate.pose | calibration | InteractionGate | transform | bound |
| gate.calibrationStatus | calibration | InteractionGate | semantic | bound |
| bubble.timeToGate | frame | InteractionGate | segment | bound |
| pause.active | event | PauseVeil+Gate | freeze/status | bound |
| pause.snapshotPositions | pause | PauseVeil | proof | bound |
| pause.snapshotClock | pause | PauseVeil | proof | bound |
| stats.totalCorrect | event/result | Result | numerator | bound |
| stats.totalAttempt | event/result | Result | denominator | bound |
| stats.normalCorrect | event/result | Result | row | bound |
| stats.normalAttempt | event/result | Result | row | bound |
| stats.goldCorrect | event/result | Result | row | bound |
| stats.goldAttempt | event/result | Result | row | bound |
| stats.grayCorrect | event/result | Result | row | bound |
| stats.grayAttempt | event/result | Result | row | bound |
| result.badge | result | Result | shape+label | bound |
| best.score | launch/result | Result+S0 supporting | score | bound |
| storage.state | write | Result | trust+retry | bound |
| tutorial.prompt | tutorial/frame | BubbleActor+GameHUD | localized text | bound |
| dialog.open | event | EndRunDialog | visibility | bound |
| dialog.originState | event | EndRunDialog | consequence copy | bound |
| pool.total/free | diagnostic | none | not presented | intentional: no player decision value |

**B · one actionable output per row**

| Task/output | Mode | Component/render element/behavior | Disposition |
|---|---|---|---|
| T1 retry | actionable | CalibrationHalo/cal-retry/pinch or button | bound |
| T1 accept | actionable | CalibrationHalo/cal-enter | bound |
| T1 exit | actionable | system back from S1 to S0 or origin S4 | bound |
| T2 enter | actionable | CalibrationHalo/cal-enter explicit Stage | bound |
| T2 stay/back | actionable | system back retains Shared Space start | bound |
| T3 hit | actionable | BubbleActor/bubble-hit-zone/contact | bound |
| T4 grab | actionable | BubbleActor/bubble-grab-zone/hold | bound |
| T5 untouched | restraint | Gate pass + BubbleActor terminal | bound |
| T6 one terminal | system decision | BubbleActor/bubble-feedback/ledger | bound |
| T7 pause | actionable | GameHUD/hud-pause | bound |
| T7 resume | actionable | PauseVeil/pause-resume | bound |
| T7 recalibrate | actionable | PauseVeil/pause-recalibrate → TR12 | bound |
| T7 end | actionable | PauseVeil/pause-end → EndRunDialog | bound |
| T7 confirm end | actionable | EndRunDialog/end-confirm → S5 | bound |
| T7 cancel end | actionable | EndRunDialog/end-cancel → origin | bound |
| T8 controller takeover | actionable/system | GameHUD/hud-input + controller mapping | bound |
| T8 grace→rearm | system | BubbleActor colliders rearm after continuous valid samples | bound |
| T9 retry save | actionable | Result/result-save-retry | bound |
| T9 replay | actionable | Result/result-replay | bound |
| T9 return | actionable | Result/result-return | bound |
| T10 release | system | BubbleActor/bubble.position+bounds+poolId | bound |
| T10 retain frozen | system | pause.active prevents lifecycle advance/release | bound |

**C · primary substate rows**

| Component→subpart | Substate | Primitive | Binding |
|---|---|---|---|
| Calibration→fan | loading/empty/error | cal-fan+cal-status | calibration.status/headPose/floorEstimate |
| Calibration→enter | disabled/focused/pressed | cal-enter | calibration.status/action.enterStage |
| Bubble→mesh | pooled/approaching/gate-active/paused | bubble-mesh | bubble.position/kind/input.state |
| Bubble→colliders | armed/grace/terminal | hit-zone+grab-zone | input.state/lastValidAt/terminal |
| Bubble→receipt | correct/wrong/pass/error | bubble-feedback | bubble.terminal |
| Gate→rim | calibrated/uncalibrated/paused/error | gate-rim+status | gate.pose/calibrationStatus/pause.active |
| HUD→clock | loading/fresh/paused | hud-time | clock.remaining |
| HUD→input | valid/grace/controller/error | hud-input | input.state/lastValidAt |
| HUD→pause | focused/pressed/disabled | hud-pause | action.pause/dialog.open |
| Pause→proof | loading/valid/error | proof-position+proof-clock | pause.snapshotPositions/snapshotClock |
| Pause→actions | disabled/focused/pressed/overflow | resume/recalibrate/end | action.* |
| Result→stats | loading/empty/fresh/partial/overflow | accuracy+three rows | explicit stats paths |
| Result→storage | loading/fresh/error | result-save+retry | storage.state |
| Result→actions | focused/pressed/disabled | replay/return | action.* |
| Dialog→body | default/overflow/error | title+body | dialog.open/originState |
| Dialog→actions | focused/pressed/disabled/loading | cancel+confirm | action.cancelEnd/confirmEnd |
| Calibration→root | default | status+fan | calibration.status/envelope |
| Calibration→text | overflow | wrapped status/actions | calibration.status |
| Bubble→focus | focused/pressed/grabbed | rim/mesh/grab zone | bubble.kind/input.state |
| Bubble→bounds | overflow | hidden+release | bubble.bounds/poolId |
| Gate→rim focus | focused/pressed | rim | bubble.timeToGate |
| Gate→availability | loading/empty/overflow | status/rim | gate.pose/calibrationStatus |
| HUD→prompt | empty/overflow | prompt/2-row layout | tutorial.prompt |
| Pause→proof empty | empty | proof text | pause.snapshotPositions/snapshotClock |
| Dialog→body empty | empty | safe default body | dialog.originState |

## 6. Material and depth semantics

- Depth: spawn bubbles far; gate mid; feedback near; HUD remains peripheral. “Near=important”; no color-only depth.
- Stage materials are matte/opaque; system glass only W-START. W-START critical text Thick + opaque backing. HUD/pause opaque because Stage/MR backgrounds are uncontrolled.
- Vibrant table: W-START monochrome title/body=light tier, terminate at gradient/illustration, fallback opaque; all Stage panels=none/opaque.

## 7. Data display and semantic contract

- displayOnlyPaths: `clock.remaining`, `tier.label`, `tutorial.prompt`, `stats.*`, `best.score`; always human-readable Chinese.
- semanticEnumPaths: `bubble.kind→normal/gold/gray`, `input.state→tracking`, `storage.state→correct/wrong`, `pause.active→paused` through labels/aliases in §3.2.
- data states: loading (calibration/save), fresh (session event), partial (early end), permission_denied (hand tracking→controller instruction), error (save/calibration). No network/offline state; app is local-only.
- trustPolicy: terminal events immutable; one per bubble; pause snapshot visible; partial results labeled; stale tracking disarms judgments; save failure never claims success.

| Rule | Input | Output | fallback | states |
|---|---|---|---|---|
| Time | seconds | mm:ss | --:-- and freeze | fresh/loading |
| Accuracy | correct/attempt | rounded integer % | “暂无判定” | fresh/partial |
| Category | correct/attempt | “8/10” | “暂无泡泡” | fresh/empty |
| Best | int | “最高分 1240” | “暂无最高分” | fresh/error |

## 8. PICO platform numeric spec

- Planar legal 320×180–2700×1800dp; depth 640dp.
- corner radius 32dp main; min font 12dp, project body 18sp; min target 56×56dp.
- core FOV 65°×40°; secondary 85°×55°; device verification required.

## 9. Asset Delivery

| Asset | Spec | Budget/use/owner |
|---|---|---|
| bubble_normal/gold/gray | glTF/engine-supported import; 3 LOD; ≤8k/4k/1.5k triangles each; 1024² textures max | BubbleActor; meter scale, centered origin |
| gate_rim | procedural/vector mesh ≤2k tris | InteractionGate |
| semantic icons | SVG 28/40dp grid, tintable | all UI |
| theme music layers 0–5 | OGG/AAC 48kHz loops, licensed; loop-aligned | ThemePulse; no tempo pressure |
| hit/grab/pass/wrong | mono/stereo short assets; spatial source at bubble except UI wrong | feedback |
| motion | parameterized timelines per interaction §13 | no baked camera motion |

Naming lowercase snake_case; textures avoid baked token colors; downstream verifies format/import, spatial audio position and performance.

## 10. Minimum Completeness Gate

| Check | Evidence | Verdict |
|---|---|---|
| Visual direction | §2 three distinct candidates + VE review | pass |
| Visual language | §3–4 precise tokens/materials | pass |
| Window structure | §5.0 ASCII/mapping/reflow | pass |
| Component structure | seven core components full eight segments in authoritative §5.3 | pass |
| Coverage reconciliation | §5.2 A/B/C no gaps | pass |
| Semantics/trust/assets | §6–9 | pass |

| Field | Value |
|---|---|
| minimumCompletenessGate | pass |

## 11. Delivery and Recipients

- Stage 8 output: approved visual reference V1.
