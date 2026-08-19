# 视觉系统规范 · BubbleReflexLab

> revision: 4 · active stages: visual_direction + design_system + CR-04 + CR-05 · roles: `visual_designer`, `spatial_design_system_designer` · source revisions: Interaction6 + Visual3 + UXR2 + PM4 + DS2-01..03

## 1. 视觉任务

把“前庭弧带实验室”转化为一眼可辨、无高速压迫、中央单焦点的空间第一印象。方向在定义组件和布局前生成；未读取任何案例、模板或无效旧设计包，`templateReuse=false`。

## 2. 空间视觉方向候选

| Direction | Spatial Thesis | First-View Composition | Container Relationships | Depth Plan | Information Hierarchy | Interaction Cues | Spatial Value | Dashboard Risk |
|---|---|---|---|---|---|---|---|---|
| D1 柔光前庭弧带 | 环境像安静的光学实验室，唯一强焦点是胸前半透明弧带；泡泡从远处薄雾中显现 | 首眼先见中央动作词，其下是弧带轮廓；三类泡泡以独特轮廓/材质/符号进入；时间仅为上方细弧 | Shared 启动窗像“实验卡”；进入 Stage 后窗收起，暂停才出现不透明近场层；结算回窗 | 环境 z0；SafeArc 微光 z1；目标 z2→Ribbon z3；动作提示 z4，越近越重要 | 当前动作 > 当前泡泡 > Ribbon > 时间/段落 > 连击；统计不驻留游戏态 | 普通以手掌裂纹朝向掌面；金色有可抓把手；灰色禁触横杠始终正对视线 | 直接表达深度接近、可达范围与不触碰路径 | Low：无卡片网格、无多指标常驻 |
| D2 水面标本盘 | 把互动区做成前方水平“水面”，泡泡像标本从水下上浮，类别说明固定在两侧 | 第一眼是宽水面盘与左右规则牌；目标从下远方向上漂 | Stage 内主水面+两侧说明板；暂停叠加中心板 | 水面作为深度基准，泡泡穿透平面时判定 | 规则牌与目标并列，时间藏在水面边缘 | 拍击溅水、抓取拉出、灰泡沉回 | 深度/穿越强，但引入垂直运动隐喻 | Medium：两侧规则牌会形成常驻仪表板，也接近地面生成错觉 |
| D3 纸灯笼剧场 | 三类目标像纸灯笼角色，六段色幕像舞台换景 | 第一眼是浅弧舞台、幕布层与三角色提示；互动区靠舞台口 | Full Stage 持续舞台框；暂停像落幕；结算在舞台中央 | 多层布景、角色从后台向前 | 角色叙事优先，动作提示次之 | 拍破纸灯、抓住吊环、灰灯停手 | 方向和时间换幕明显 | High：舞台框/装饰可能压缩视野，角色隐喻削弱材质直觉 |

### 2.1 Structured Design-effect Review

| Criterion | D1 | D2 | D3 | 决策 |
|---|---|---|---|---|
| 三类一眼辨识且非仅颜色 | pass：圆泡/金环把手/哑光六角横杠 | pass，但水花会模糊灰泡“别碰” | risk：角色装饰可能遮蔽动作语法 | D1 |
| 中央舒适区与禁止地面/头顶误读 | pass：胸前竖向弧带 | block-risk：水面容易被读作地面下上浮 | pass，但舞台边缘促使扫视 | D1 |
| 温和主题换色不等于压力升级 | pass：环境薄雾与细弧渐变 | pass | risk：换幕像关卡高潮 | D1 |
| 单一主焦点 / 非 Dashboard | pass | risk：左右规则牌常驻 | risk：框景与角色信息竞争 | D1 |
| 与竞品视觉差异 | 避开霓虹轨道/大型墙/全身舞台 | 仍像平面轨道表面 | 容易靠近节奏舞台范式 | D1 |

- **Approved visual reference**：`D1 柔光前庭弧带`，由本阶段 structured design-effect review 批准，approval id `VFX-20260813-D1`。
- 选择理由：唯一同时保持中央单焦点、前方体积可读、灰泡无需闪躲、主题柔和变化且不产生仪表板或舞台压力的方向。
- Rejected 1：D2 水面标本盘——垂直上浮容易造成地面下出现的语义误读；常驻侧牌分散注意。
- Rejected 2：D3 纸灯笼剧场——装饰框景与换幕提高戏剧压力，且角色造型可能掩盖拍/抓/不碰的物理语法。

### 2.2 Preview / render instruction

Web 设计验证应模拟面向用户的固定透视空间：柔灰蓝环境、中央半透明 Ribbon、远端泡泡缓慢放大接近；三类目标必须以轮廓+表面+符号区分。不要使用霓虹隧道、排行榜、侧栏、网格卡片或粒子爆屏。教程截图显示单泡+短动作词，进行截图显示至多3个清晰分离泡泡与柔和段主题；速度只能通过缓慢位移暗示。

## 3. Visual System Facts

### 3.1 Tokens / typography / scale

| token | value | use |
|---|---|---|
| brandPrimary | `#75D9E6` | 普通泡/品牌 |
| accentGold | `#F4C95D` | 金泡 |
| avoidGray | `#8C96A3` | 灰泡 |
| surface | `#17232D` | 主背板 |
| surfaceRaised | `#22333E` | 近层 |
| textPrimary/textSecondary | `#F5FAFC` / `#C3D0D7` | 文字 |
| positive/caution/danger/focus | `#75D9A6` / `#F5B86A` / `#FF8A83` / `#FFFFFF` | 状态 |

| role | family | size | line | weight |
|---|---|---:|---:|---:|
| display | sans | 48sp | 58sp | 700 |
| title | sans | 28sp | 36sp | 600 |
| metric | mono | 36sp | 44sp | 700 |
| body | sans | 18sp | 26sp | 500 |
| caption | sans | 14sp | 20sp | 500 |

| scale | tiers |
|---|---|
| spacing | xs4 / s8 / m16 / l24 / xl32dp |
| radius | s12 / m20 / l32dp |
| iconSize | s20 / m28 / l40dp |

### 3.2 colorSemantics

| key | color | shape | label | desc | aliases[] |
|---|---|---|---|---|---|
| normal | `#75D9E6` | circle | 普通泡泡 · 拍 | 圆泡+裂纹 | `normal,普通,hit,拍` |
| gold | `#F4C95D` | diamond | 金色泡泡 · 抓 | 金环+把手 | `gold,金色,grab,抓` |
| avoid | `#8C96A3` | dashed | 灰色泡泡 · 别碰 | 六角+横杠 | `gray,avoid,灰色,untouched,touched` |
| positive | `#75D9A6` | circle | 成功 | 正向终局 | `success,saved,hit,grab,untouched` |
| caution | `#F5B86A` | triangle | 需要注意 | 输入/校准提示 | `warning,partial,tracking_lost` |
| destructive | `#FF8A83` | triangle | 退出且不保存 | 高风险 | `danger,confirm_exit,error` |

### 3.3 Materials / environment

| name | desc | treatment | glassStyle | opacity |
|---|---|---|---|---:|
| consoleGlass | Shared主窗 | glass | Thick | .94 |
| resultCard | 结果卡 | glass | Regular | .90 |
| stageBacking | Stage HUD/暂停 | matte | none | .96 |
| bubbleShell | 目标PBR | opaque | none | .88 |

正文18sp且硬底12dp，操作≥56dp，文本对背板≥4.5:1。LabConsole 调用系统玻璃；Web blur仅近似。Stage 不可依赖窗口玻璃，文字用 `#17232DF5` 实色背板。Vibrant仅用于单色时间弧/动作词，level=`light`；图像/渐变必须终止传播并用实色背板。主题色面积≤20%视野，无高饱和大块。

## 4. Window structure · LabConsole

| field | value |
|---|---|
| form | Planar，depth=640dp fixed |
| default/min/max | 1120×720 / 720×620 / 1440×840dp |
| contentInset | xl32；TitleBar96 |
| attachments | no docked；InlineControl actions；Dialog only for risky exit |

```text
┌─────────────────────────────────────┐
│ Title 96                            │
│ ┌╌ RuleStrip / ResultSummary ╌────┐ │
│ └╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌┘ │
│            gap l24                  │
│ ┌╌ PrimaryActionBar ╌─────────────┐ │
│ └╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌╌┘ │
└─────────────────────────────────────┘
```

Grid 1 column。ReadyHome=C1+C2；RunResult=C7+C2。Large/Compact内部最多3列；Constrained单列滚动、CTA固定，不整体缩放。

## 5. Core Components · complete 8-section blocks

### C1 RuleStrip

| Field | Content |
|---|---|
| derivedFromTasks | T01,T03 |
| derivedFromData | staticRules;postureChoice |
| Purpose | 三规则与姿态决策 |
| layoutRole | primary_explore |
| Priority | primary |
| runtimeRole | ruleDecisionList |

**Anatomy · Layout**
```text
┌────────┬────────┬──────────┐
│╌圆+拍╌ │╌环+抓╌ │╌六角+别碰╌│
├────────┴────────┴──────────┤
│╌站姿56╌  ╌坐姿56╌          │
└────────────────────────────┘
```
Grid=3 rule columns+posture row，gap m16；Constrained=1 column。

**Anatomy · Sizing**
| tier | size | window fit |
|---|---|---|
| Regular/default | 1056×304dp | default content area |
| Compact/max | 1376×304dp | max content area |
| Constrained/min | 656×420dp | single-column scroll |

**Anatomy · Internal Metrics**
| metric | value | source |
|---|---|---|
| background | none | consoleGlass |
| radius | m20 | scale |
| padding | l24 | scale |
| gap | m16 | scale |
| stroke | 2dp semantic | §3.2 |
| icon | l40 | scale |
| primary text | title28/36 | typography |
| secondary | body18/26 | typography |
| hitTarget | 56×56dp | floor |

**Render Elements `renderSpec.elements[]`**
| id | label | type | bind | role |
|---|---|---|---|---|
| c1-normal | 普通泡泡 · 拍 | ruleTile | staticRules.normal | normal |
| c1-gold | 金色泡泡 · 抓 | ruleTile | staticRules.gold | gold |
| c1-gray | 灰色泡泡 · 别碰 | ruleTile | staticRules.gray | avoid |
| c1-stand | 站姿 | button | postureChoice | choice |
| c1-seated | 坐姿 | button | postureChoice | choice |

**Data Bindings `dataBindings[]`**
| source | target | fallback | type |
|---|---|---|---|
| staticRules.* | rule labels/symbols | built-in Chinese+shape | display-only |
| postureChoice | posture selected | empty→start disabled | semantic |

**Variants**: ready；replay(prefilled posture)；Constrained(single column)。

**States**
| state | trigger | visual | size | motion | accessibility |
|---|---|---|---|---|---|
| default | ready | semantic strokes | none | none | labels+shapes |
| focused | gaze | focus 2dp |1.03x|120ms|spoken label |
| selected | activate posture | check+4dp |none|160ms|“已选” |
| disabled | unavailable | .55 |none|none|reason |
| overflow | min tier | scroll |none|none|linear focus |
Precedence: disabled>focused；selected+focused keeps check+outer focus。

### C2 PrimaryActionBar

| Field | Content |
|---|---|
| derivedFromTasks | T01,T09,T10 |
| derivedFromData | actionSet;canStart;saveState |
| Purpose | 唯一主动作+最多一次动作 |
| layoutRole | critical_primary |
| Priority | primary |
| runtimeRole | actionControl |

**Anatomy · Layout**
```text
┌────────────────────────────┐
│╌secondary56╌ ╌primary64╌   │
└────────────────────────────┘
```
Grid=end-aligned 2 columns；Constrained stacked full-width。

**Anatomy · Sizing**
| tier | size | window fit |
|---|---|---|
| Regular/default |1056×96dp|default|
| Compact/max |1376×96dp|max|
| Constrained/min |656×136dp|stacked|

**Anatomy · Internal Metrics**
| metric | value | source |
|---|---|---|
| background | none | parent |
| radius | l32 | scale |
| padding | m16 | scale |
| gap | m16 | scale |
| stroke | 2dp focus/semantic | tokens |
| icon | m28 | scale |
| primary text | body18/26/600 | typography |
| secondary | caption14/20 | typography |
| hitTarget | min56×56; primary64h | floor |

**Render Elements `renderSpec.elements[]`**
| id | label | type | bind | role |
|---|---|---|---|---|
| c2-primary | 开始三分钟 | button | actionSet.primary | primary |
| c2-secondary | 返回 | button | actionSet.secondary | safe exit |
| c2-status | 暂无最高分 | text | saveState.label | status |

**Data Bindings `dataBindings[]`**
| source | target | fallback | type |
|---|---|---|---|
| actionSet.* | buttons | hide inapplicable | display-only |
| canStart | primary.enabled | false+reason | semantic |
| saveState | status | 保存状态未知 | semantic |

**Variants**: start；result(replay/home)；saveError(retry/home)；exitConfirm(cancel/exit)。

**States**
| state | trigger | visual | size | motion | accessibility |
|---|---|---|---|---|---|
| default | actionable | brand fill |none|none|label |
| focused | gaze | focus2dp |1.03x|120ms|spoken |
| pressed | pinch | darker |.98x|90ms|haptic |
| disabled | false | .55+lock |none|none|reason |
| error | save failure | triangle+retry |none|180ms|copy |
Precedence: disabled>pressed/focused；error+focused keeps triangle+ring。

### C3 CalibrationGuide

| Field | Content |
|---|---|
| derivedFromTasks | T02 |
| derivedFromData | SafeArc;InteractionRibbon;calibrationValidity;postureChoice |
| Purpose | 确认前方弧带可达 |
| layoutRole | primary_hero |
| Priority | primary |
| runtimeRole | spatialCalibration |

**Anatomy · Layout**
```text
 ╌SafeArc outline 1.6–2.4m╌
          ↓
 ┌╌Ribbon .75–1.05m╌┐
 │╌validity label╌  │
 └──────────────────┘
  ╌retry56╌ ╌accept56╌
```
World anchor=head-forward；yaw±32°,pitch±18°,Ribbon y0.85–1.45m；labels face user。

Component-local geometry: anchor=`calibratedHeadForwardFloorAware`; SafeArc origin `(0m,0m,0m at calibrated head)` with radial range `1.60–2.40m`; Ribbon center `(x=0m,y=calibratedReachY,z=-0.90m)`, `calibratedReachY` clamped to floor-relative `0.85–1.45m`, depth `0.30m`, horizontal yaw span `64°`; orientation=`faceCalibratedHead`, roll=0°. Status label center is `(0m,+0.12m,-0.86m)`, apparent size `0.30–0.44m × 0.08–0.12m`; retry/accept control plane center `(0m,-0.16m,-0.82m)`, two controls each apparent `0.16–0.24m × 0.07–0.10m`, gap `0.04m`, with angular hit target validated as ≥56dp equivalent.

**Anatomy · Sizing**
| tier | size | fit |
|---|---|---|
| Regular/standing | project meter ranges | Stage comfort |
| Compact/seated | same depth,y recalibrated but ≥0.85m | Stage comfort |
| Constrained | N/A; invalid blocks | never shrink safety bounds |

**Anatomy · Internal Metrics**
| metric | value | source |
|---|---|---|
| background | customColor `#17232DF5` labels | Stage |
| radius | m20 | scale |
| padding | m16 | scale |
| gap | l24 | scale |
| stroke | Ribbon8mm/label2dp | geometry |
| icon | l40 equivalent | scale |
| primary text | title28/36 | typography |
| secondary | body18/26 | typography |
| hitTarget | 56×56dp | floor |

**Render Elements `renderSpec.elements[]`**
| id | label | type | bind | role |
|---|---|---|---|---|
| c3-arc | 前方安全生成区 | outline | SafeArc | boundary |
| c3-ribbon | 互动区 | ribbon | InteractionRibbon | target |
| c3-status | 请确认伸手舒适 | label | calibrationValidity | status |
| c3-retry | 重新校准 | button | calibration.retry | action |
| c3-accept | 位置舒适，继续 | button | calibration.accept | primary |

**Data Bindings `dataBindings[]`**
| source | target | fallback | type |
|---|---|---|---|
| SafeArc.* | arc.geometry | hide+block | display-only |
| InteractionRibbon.* | ribbon.geometry | hide+block | display-only |
| calibrationValidity | status/accept | 不可用，请重试 | semantic |
| postureChoice | geometry | unknown→block | semantic |

**Variants**: standing；seated；recalibration(frozen run)。

**States**
| state | trigger | visual | size | motion | accessibility |
|---|---|---|---|---|---|
| loading | pose pending | dashed |none|≤1Hz/Reduce static|正在定位 |
| valid | constraints pass | circle+positive |none|180ms|位置舒适 |
| invalid | fail | triangle+caution |none|none|specific reason |
| focused | gaze control | ring |1.03x|120ms|spoken |
| error | capability fail | opaque panel |none|fade|safe exit |
Precedence: error>invalid>loading>focused。

### C4 BubbleActor

| Field | Content |
|---|---|
| derivedFromTasks | T03,T04,T05,T06,T11 |
| derivedFromData | BubbleSeed;Judgment;InputArbiter;SegmentClock |
| Purpose | 三类互斥动作与单终局判定 |
| layoutRole | primary_hero |
| Priority | primary |
| runtimeRole | spatialTarget |

**Anatomy · Layout**
```text
normal: (circle)─╌palm crack╌
gold:   ◇ring◇─╌grab handle╌
gray:   ⬡matte⬡─╌no-touch bar╌
origin=center; face→user; cue y+0.18m
```
World geometry；diameter0.16–0.24m；yaw spacing≥12°；path SafeArc→Ribbon。

Component-local geometry: world anchor=`SafeArcLeasePose`; each lease resolves local spherical coordinates `(yaw=-32°..+32°, pitch=-18°..+18°, radius=1.60..2.40m)` relative to `calibratedHeadForward`, then converts to world `(x,y,z)` only after forward-dot/floor/near-head constraints pass. Orientation=`symbolFaceCalibratedHead`, roll=0°; velocity points from lease pose toward the assigned Ribbon slot `(slotX,slotY,z≈-0.90m)` without passing behind the user. Shell diameter range `0.16–0.24m`; symbol plane offset `0.01m` toward user; cue local offset `(0m,+0.18m,+0.02m toward user)`; collider padding `0.02m`; actor-to-actor angular separation `≥12°`.

**Anatomy · Sizing**
| tier | size | fit |
|---|---|---|
| Regular |0.20m|T1–T5|
| Compact |0.16m|dense, max5|
| Constrained/tutorial |0.24m|single actor|

**Anatomy · Internal Metrics**
| metric | value | source |
|---|---|---|
| background | N/A; PBR bubbleShell | Stage entity |
| radius | N/A; type geometry | semantic |
| padding | collider +20mm | input |
| gap | cue180mm | geometry |
| stroke | symbol rim6mm | non-color |
| icon | symbol≥50mm apparent | readability |
| primary text | cue title28/36 equivalent | typography |
| secondary | caption14/20 | typography |
| hitTarget | apparent≥56dp equivalent | device validation |

**Render Elements `renderSpec.elements[]`**
| id | label | type | bind | role |
|---|---|---|---|---|
| c4-shell | 泡泡 | mesh | BubbleSeed.kind | shape/material |
| c4-symbol | 拍/抓/别碰 | meshSymbol | BubbleSeed.kind | redundant code |
| c4-cue | 拍 / 抓 / 别碰 | label | BubbleSeed.kind | human label |
| c4-feedback | 拍中了 | feedback | Judgment | result |

**Data Bindings `dataBindings[]`**
| source | target | fallback | type |
|---|---|---|---|
| BubbleSeed.kind | shell/symbol/cue | unknown→pool | semantic |
| BubbleSeed.pose | transform | invalid/outside→pool | display-only |
| InputArbiter.armed | collider.enabled | false | semantic |
| Judgment.outcome | feedback/lifecycle | passage rule resolves | semantic |

**Variants**: normal circle/crack/slap；gold ring/handle/grab；gray hex/bar/no-contact；tutorial larger；reduceMotion no bob。

**States**
| state | trigger | visual | size | motion | accessibility |
|---|---|---|---|---|---|
| pooled | available | hidden |0|none|N/A |
| drifting | leased | shell+symbol |variant|.22–.48m/s|cue text |
| graceFrozen | tracking≤300ms | .82+dashed halo |none|frozen|输入暂停 |
| judgedSuccess | hit/grab/untouched | positive+label |≤1.08x|220–280ms|audio+text |
| judgedError | miss/touched/wrong | caution+specific label |none|180ms|no flash |
| outOfBounds | invalid | hidden→pool |0|none|logged |
Precedence: out/judged terminal>graceFrozen>drifting；terminal immutable。

### C5 RunHUD

| Field | Content |
|---|---|
| derivedFromTasks | T03,T07,T12 |
| derivedFromData | SegmentClock;ThemeLayer;InputArbiter;currentCue |
| Purpose | 当前动作/时间/输入状态 |
| layoutRole | supporting_status |
| Priority | secondary |
| runtimeRole | runStatus |

**Anatomy · Layout**
```text
 ╌time arc 02:30╌
 ╌current cue 拍╌
 ╌input status optional╌
```
World-facing；cue clamps core FOV；no score ticker。

Component-local world geometry: anchor=`calibratedHeadForward`; local position `(x=0m,y=+0.28m,z=-0.92m)` relative to calibrated head, orientation=`billboardYawPitchToHead` with roll locked 0°; time arc spans horizontal `0.34m` / angular `≤22°`, cue chip below it by `0.07m`, status chip below cue by `0.06m`; whole HUD depth range `0.88–0.96m`, always nearer than Ribbon but outside hand collider volume.

**Anatomy · Sizing**
| tier | size | fit |
|---|---|---|
| Regular | angular≤22° | run |
| Compact | angular≤18° | dense |
| Constrained | angular≤26° | tutorial |

**Anatomy · Internal Metrics**
| metric | value | source |
|---|---|---|
| background | customColor `#17232DF5` chips | Stage |
| radius | s12 | scale |
| padding | s8/m16 | scale |
| gap | s8 | scale |
| stroke | 2dp semantic | tokens |
| icon | m28 | scale |
| primary text | title28/36 | typography |
| secondary | caption14/20 | typography |
| hitTarget | N/A read-only | no action |

**Render Elements `renderSpec.elements[]`**
| id | label | type | bind | role |
|---|---|---|---|---|
| c5-time | 02:30 | progress+text | SegmentClock.remaining | display |
| c5-cue | 拍 | label+shape | currentCue | semantic |
| c5-segment | 湖水蓝 · 第2段 | caption | SegmentClock.segment | display |
| c5-input | 输入已暂停 | badge | InputArbiter.state | semantic |

**Data Bindings `dataBindings[]`**
| source | target | fallback | type |
|---|---|---|---|
| SegmentClock.remaining | time | `--:-- · 已暂停` | display-only |
| SegmentClock.segment | segment/theme | 段落未知且不变速 | display-only |
| ThemeLayer.themeId | segment color/fog token | `晨雾青`且不改变速度 | semantic |
| ThemeLayer.audioLayerId | segment caption/audio-layer indicator | `柔和音乐`；音频不可用仍继续计时 | display-only |
| currentCue | cue | no actor→hide | semantic |
| InputArbiter.state | input | unknown→freeze | semantic |

**Variants**: tutorial(step1/3)；run(segment)；paused；reduceMotion static theme。

**States**
| state | trigger | visual | size | motion | accessibility |
|---|---|---|---|---|---|
| active | running | normal |none|continuous arc|text time |
| boundary | 30s | theme crossfade |none|800ms/Reduce400|segment text |
| paused | S4/S7 | pause icon |none|none|已暂停 |
| partial | cue missing | time+caution |none|none|no false cue |
| error | clock conflict | triangle |none|none|safe pause |
Precedence: error>paused>partial>boundary>active。

### C6 PausePanel

| Field | Content |
|---|---|
| derivedFromTasks | T07,T08,T09 |
| derivedFromData | FrozenSnapshot;InputArbiter;exitIntent |
| Purpose | 冻结证明与恢复/退出 |
| layoutRole | critical_primary |
| Priority | primary |
| runtimeRole | pauseRecovery |

**Anatomy · Layout**
```text
┌────────────────────┐
│╌已暂停/reason╌     │
│╌继续56╌            │
│╌重新校准56╌        │
│╌退出本局56╌        │
└────────────────────┘
```
1-column centered；ExitConfirm replaces actions with cancel/exit。

Component-local world geometry: anchor=`frozenViewPose`; panel center `(x=0m,y=-0.10m,z=-0.85m)` relative to frozen head pose, orientation=`faceFrozenHead`, roll=0°; apparent metric range width `0.36–0.52m`, height `0.36–0.42m`, depth slab `0.02m`, interaction plane distance `0.85m`; z precedence=`nearest`, at least `0.10m` nearer than RunHUD and never intersects frozen BubbleActor colliders.

**Anatomy · Sizing**
| tier | size | fit |
|---|---|---|
| Regular |520×392dp apparent|core FOV|
| Compact |456×360dp|core FOV|
| Constrained |360×420dp|vertical no internal scroll|

**Anatomy · Internal Metrics**
| metric | value | source |
|---|---|---|
| background | customColor `#17232DF5` | Stage |
| radius | l32 | scale |
| padding | xl32 | scale |
| gap | m16 | scale |
| stroke | 2dp; danger exit | semantics |
| icon | m28 | scale |
| primary text | title28/36 | typography |
| secondary | body18/26 | typography |
| hitTarget | 56×56dp | floor |

**Render Elements `renderSpec.elements[]`**
| id | label | type | bind | role |
|---|---|---|---|---|
| c6-title | 已暂停 | heading | pauseReason | status |
| c6-resume | 继续 | button | pause.resume | primary |
| c6-calibrate | 重新校准 | button | pause.recalibrate | action |
| c6-exit | 退出本局 | button | pause.exit | destructive request |
| c6-cancel | 取消 | button | exitIntent.cancel | safe default |
| c6-confirm | 退出且不保存 | button | exitIntent.confirm | confirm |

**Data Bindings `dataBindings[]`**
| source | target | fallback | type |
|---|---|---|---|
| FrozenSnapshot.valid | resume.enabled | false+异常 | semantic |
| InputArbiter.state | title/reason | 输入不可用 | semantic |
| exitIntent | confirm variant | closed | semantic |

**Variants**: manualPause；trackingPause；inputUnavailable；exitConfirm Dialog。

**States**
| state | trigger | visual | size | motion | accessibility |
|---|---|---|---|---|---|
| visible | paused | opaque |Regular|180ms|focus title |
| focused | gaze | ring |1.03x|120ms|spoken |
| disabled | invalid snapshot | .55+reason |none|none|reason |
| confirm | exit request | triangle;cancel default |same|180ms|consequence |
| error | freeze fail | error+safe exit |same|none|no resume |
Precedence: error>confirm>disabled>focused；confirm focus defaults cancel。

### C7 ResultSummary

| Field | Content |
|---|---|
| derivedFromTasks | T10 |
| derivedFromData | RunLedger;bestScore;saveState |
| Purpose | 准确率/分类/徽章/保存真实性 |
| layoutRole | primary_hero |
| Priority | primary |
| runtimeRole | resultSummary |

**Anatomy · Layout**
```text
┌──────────────────────────┐
│╌accuracy92%+badge╌       │
├────────┬────────┬────────┤
│╌拍8/9╌ │╌抓5/6╌ │╌不碰7/7╌│
├────────┴────────┴────────┤
│╌score/best/save╌         │
└──────────────────────────┘
```
Grid3 rows；category3 columns→Constrained1 column。

**Anatomy · Sizing**
| tier | size | fit |
|---|---|---|
| Regular/default |1056×440dp|default|
| Compact/max |1376×440dp|max|
| Constrained/min |656×520dp|single-column scroll;hero fixed|

**Anatomy · Internal Metrics**
| metric | value | source |
|---|---|---|
| background | glass Regular | resultCard |
| radius | l32 | scale |
| padding | xl32 | scale |
| gap | l24 | scale |
| stroke | 2dp semantic | colors |
| icon | l40 | scale |
| primary text | display48/58 | typography |
| secondary | body18/26;metric36/44 | typography |
| hitTarget | N/A; actions C2 | separation |

**Render Elements `renderSpec.elements[]`**
| id | label | type | bind | role |
|---|---|---|---|---|
| c7-accuracy | 准确率 92% | metric | RunLedger.accuracy | primary |
| c7-badge | 金徽章 | badge | RunLedger.badge | semantic |
| c7-normal | 拍破 8/9 | stat | RunLedger.normal | category |
| c7-gold | 抓住 5/6 | stat | RunLedger.gold | category |
| c7-gray | 未碰 7/7 | stat | RunLedger.gray | category |
| c7-score | 本局 2140 | metric | RunLedger.score | display |
| c7-best | 最高 2280 | metric | bestScore | display |
| c7-save | 已保存 | status | saveState | trust |

**Data Bindings `dataBindings[]`**
| source | target | fallback | type |
|---|---|---|---|
| RunLedger.accuracy | accuracy | `— 数据不完整` | display-only |
| RunLedger.badge | badge | 完成 | semantic |
| RunLedger.normal/gold/gray | stats | `—/—` | display-only |
| RunLedger.score | score | `—` | display-only |
| bestScore | best | 暂无最高分 | display-only |
| saveState | save | 保存状态未知+retry | semantic |

**Variants**: complete/noBadge/bronze/silver/gold；newBest；saveError；partial(no best eligibility)。

**States**
| state | trigger | visual | size | motion | accessibility |
|---|---|---|---|---|---|
| loading | finalize | skeleton |same|≤250ms|正在统计 |
| complete | valid | metrics |same|200ms fade|text |
| newBest | score>best | diamond+新纪录 |none|240ms/Reduce fade|text |
| empty | no best | 暂无最高分 |same|none|not zero |
| partial | incomplete | triangle |same|none|no badge/save |
| error | save fail | triangle+本局保留 |same|none|retry C2 |
| overflow | min | single-column scroll |same|none|focus order |
Precedence: partial>error overlay>newBest>complete；loading blocks actions。

## 6. Structural completeness and coverage

| Component | base | layout | sizing | metrics | renderSpec | bindings | variants | states+precedence | verdict |
|---|---|---|---|---|---|---|---|---|---|
| C1 | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C2 | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C3 | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C4 | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C5 | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C6 | yes | yes | yes | yes | yes | yes | yes | yes | pass |
| C7 | yes | yes | yes | yes | yes | yes | yes | yes | pass |

### A · Entity → binding
| entity | timeliness | binding | method | disposition |
|---|---|---|---|---|
| SafeArc | calibration/session | C3 `SafeArc.*`;C4 pose validator | outline+reject invalid sample | covered |
| InteractionRibbon | calibration/session | C3 `InteractionRibbon.*`;C4 judgment window | spatial outline | covered |
| BubbleSeed | per lease | C4 kind/pose | semantic actor | covered |
| InputArbiter | realtime | C4 armed;C5/C6 state | label+freeze | covered |
| Judgment | terminal | C4 feedback;C7 aggregate | human labels | covered |
| SegmentClock | realtime/frozen | C5 `SegmentClock.remaining/segment` | time+segment label | covered |
| ThemeLayer | 30s atomic | C5 `ThemeLayer.themeId/audioLayerId` | human theme/audio label, no speed semantics | covered |
| RunLedger | terminal | C7 metrics | exact counts | covered |
| bestScore/saveState | post-complete local | C2/C7 | honest fallback | covered |

### B · Task decision → interaction
| task/output | kind | consuming evidence | disposition |
|---|---|---|---|
| T01 start/posture | actionable | C1 posture+C2 primary | covered |
| T02 accept/retry/exit | actionable | C3 buttons+C2 secondary | covered |
| T03 classify | read-only mental | C4 shell/symbol/cue | covered |
| T04 hitNormal / miss | actionable spatial | C4 normal collider + hit terminal | covered |
| T05 grabGold / miss | actionable spatial | C4 gold handle + grab terminal | covered |
| T06 untouched / touched | actionable inhibition | C4 gray no-contact passage + touched terminal | covered |
| T07 fallback/pause | actionable | C5 status+C6 recovery | covered |
| T08 resume/recalibrate/exitRequested | actionable | C6 resume/calibrate/exit controls | covered |
| T09 cancelExit/confirmExit | actionable | C6 Dialog cancel/confirm | covered |
| T10 | actionable+read | C7+C2 | covered |
| T11 lease/active/judged/returned or reject | system decision | C4 lifecycle states/outOfBounds | covered |
| T12 apply segment config atomically | system decision | C5 boundary state + ThemeLayer bindings | covered |

### C · Primary substates
| component→part | substates | primitive | binding |
|---|---|---|---|
| C1→posture | empty/selected/focused/disabled/overflow | buttons/reason/scroll | postureChoice |
| C2→primary | default/focused/pressed/disabled/error | button/status | actionSet/saveState |
| C3→ribbon | loading/valid/invalid/error | outline/label/panel | validity |
| C4→actor | pooled/drifting/grace/success/error/out | mesh/halo/feedback | seed/arbiter/judgment |
| C6→actions | visible/focused/disabled/confirm/error | panel/buttons/Dialog | snapshot/input/exit |
| C7→metrics | loading/complete/newBest/empty/partial/error/overflow | skeleton/metrics/status/scroll | ledger/best/save |

## 7. Data trust / formatting

Display-only: rules, remaining time, segment label, accuracy/counts/score/best。Semantic enums: kind→normal/gold/avoid；outcome→positive/caution；validity/input/save/badge→human labels。Relevant states=loading/fresh/frozen/partial/conflicting/permission_denied/error；无网络依赖。未知不装作fresh；暂无最佳不用0；保存失败不改变本局；partial不授徽章/最高分。

| rule | input | output | fallback | state |
|---|---|---|---|---|
| remaining | seconds | `mm:ss` | `--:-- 已暂停` | fresh/frozen/error |
| accuracy | eligible/total | rounded `%` | `— 数据不完整` | fresh/partial |
| category | success,total | `动作 success/total` | `—/—` | fresh/partial |
| best | nullable | `最高 N` | `暂无最高分` | fresh/empty/error |
| save | enum | 已保存/保存失败可重试 | 保存状态未知 | fresh/error |

## 8. PICO numeric spec / assets

Window radius32dp；hit target≥56×56dp；body18sp且hard floor12dp；core FOV65°×40°，secondary≤85°×55°；Planar legal320×180～2700×1800dp、depth640dp。

| asset | format/budget | use |
|---|---|---|
| three bubble models | engine-compatible TBD; each≤8k tris,1k PBR; LOD≤4k/1.5k | C4, diameter.16–.24m, origin center |
| icons | tintable SVG 28/40 grid | C1/C2/C5/C6 |
| six fog themes | procedural or2k; no text | environment only |
| six music layers | OGG/WAV48k normalized, no peaks | SegmentClock |
| feedback audio | 48k ≤500ms | hit/grab/untouched/error |

Names lowercase `bubble_kind_state`；no baked semantic color；exact import/device readability downstream.

## 10. Minimum Completeness Gate（Stage 8 局部）

| Check | Evidence | Verdict |
|---|---|---|
| 3个方向在构图/容器/深度/层级/交互/风险上实质不同 | §2 | pass |
| 选择有结构化视觉效果审查 | §2.1 `VFX-20260813-D1` | pass |
| 至少两个拒绝方向与原因 | §2.1 | pass |
| 竞品只用于差异观察、未复用视觉 | §2 D1–D3 + UXR2 §3A | pass |
| structured visual language directly consumable | §3 | pass |
| window shell + ASCII + reflow | §4 | pass |
| 7 core components each own complete eight-section block | §5 C1–C7 | pass |
| structural checklist and reconciliation A/B/C | §6 | pass |
| data trust, numeric rules, assets | §7–§8 | pass |

`minimumCompletenessGate=pass`
