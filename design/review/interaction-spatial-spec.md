# Interaction / Spatial Design Spec · BubbleReflexLab

> Roles: task_decision_designer → interaction_xr_designer → spatial_design_system_designer | Active revision: 9 | Sources: PM rev4, UXR rev2, interaction rev8, visual rev4 | CR-03b reconciliation repair

## 0. Reasoning Guidance

所有空间化都必须改善三类判断；不以浮窗数量制造空间感。舒适优先级：生成安全 > 输入连续性 > 判定完整性 > 计分/装饰。数值为设计候选，设备事实另验。

## 1. Direct Description of Outputs

当前 rev8 完成任务、概念、容器、状态、布局、交互与动效；CR-03 仅修复设计系统一致性，不改变概念。

## 2. Design Principles

| Principle | Basis | Landing point | Conflict precedence |
|---|---|---|---|
| 前方可预期 | R5/R6/G-S2 | 所有生成先通过 SafeFan envelope | 高于数量与随机性 |
| 三类一眼懂 | R4/PICO-COLOR-001 | 形状+纹理+颜色+短标签 | 高于主题统一性 |
| 不动也是正确动作 | R10/R11 | 灰泡不触碰直到通过 gate 即成功 | 高于“每个对象都要挥手” |
| 柔和递进 | R8/R9 | 数量/组合递增，速度仅小幅且封顶 | 高于刺激性 |
| 输入失联不惩罚 | R14/R17 | grace/disarmed/rearm + controller equivalent | 高于连击连续性 |

## 3. Task / Decision Model

| Task | Actor/context | Input evidence | Decision output | Error consequence | Frequency | Dependencies |
|---|---|---|---|---|---|---|
| T1 校准舒适区 | 玩家/开始前坐或站 | 头位、朝向、地面估计、G-S2 候选值 | 接受/重校准/退出 | 对象不可达或靠脸 | 每局至少一次 | PM R19 |
| T2 明确进入 Stage | 玩家/Shared Space | 三规则摘要、校准状态、稳定退出说明 | 进入 Full Space 或留在开始页 | 意外沉浸/空间状态非法 | 每局一次 | T1, E-P3 |
| T3 学会普通泡 | 玩家/0–10s | 圆泡+“拍破普通泡泡” | 做拍击 | 教学未通过但不扣正式分 | 一次 | T2 |
| T4 学会金泡 | 玩家/10–20s | 冠环金泡+“握住金色泡泡” | 做抓取 | 同上 | 一次 | T3 |
| T5 学会灰泡 | 玩家/20–30s | 多孔灰泡+“灰色不要碰” | 保持不触碰直到通过 | 同上，不要求躲 | 一次 | T4 |
| T6 逐泡分类 | 玩家/30–180s | kind、动作候选、gate 进入/通过、input valid/grace、paused、terminal flag | 依次应用 `paused→ignore`、`terminal→ignore`、`input invalid/grace→hold`、`gray+touched→wrong`、`gray+passed untouched→correct`、`normal+hit→correct`、`gold+grab→correct`、其他有效不匹配→wrong；每泡只写一个 JudgementEvent | 错类/漏判/重复终局 | 每泡 | T5, tier |
| T7 暂停或退出 | 玩家/任意游戏时刻 | 时间、泡泡快照、退出风险 | 暂停/恢复/确认结束 | 暂停运动或误退出 | 0..n | T2 |
| T8 恢复输入 | 系统+玩家/手势瞬失 | lastValidAt、手/柄可用性 | grace→rearm 或 controller 接管 | 误判、重复判定 | 0..n | T6 |
| T9 结算理解 | 玩家/180s或确认结束 | total/correct、三类 TP/attempt、best、storage state | 再玩/返回 Shared Space/重试保存 | 不知弱项/丢失最高分 | 每局一次 | T6/T7 |
| T10 资源回收 | 系统/对象终局或越界 | poolId、terminal、bounds、paused | release once / retain frozen | 泄漏、重复分数、暂停破坏 | 每泡 | T6/T7 |

**Task graph**：`T1→T2→T3→T4→T5→T6→T9`；`T7` 可从 T3–T6 分叉并恢复或结束；`T8` 包围 T3–T6；`T10` 与每个泡泡生命周期并行。C1–C3 的功能基线覆盖了反馈/教程/结算，故保留；刻意省略多人、武器、曲库、躲障碍和大幅身体动作。

## 4. Spatial Value Justification

| Task | Spatial axes | Best credible 2D implementation | Capability lost in 2D | Verdict |
|---|---|---|---|
| T1 | direction/distance/position/body | 屏幕填身高/距离 | 不能验证真实前方可达包络 | Stage beneficial |
| T2 | space-state/time | 2D “开始”按钮 | 无关键能力损失；只是进入空间体验的许可 | Planar sufficient |
| T3 | depth/motion/body | 点击圆泡 | 不会练习空间拍击时机与手可达区 | Stage essential |
| T4 | depth/motion/body | 长按金泡 | 不会练习空间合拢/保持 | Stage essential |
| T5 | depth/time/body | 等待屏幕对象越线 | “保持手不碰”的身体语义弱 | Stage beneficial |
| T6 | direction/distance/depth/motion/body/time | 2D 三类点击/长按/不点 | 丢失迎面深度、双手可达和空间 gate | Stage essential |
| T7 | time/simulation | 暂停覆盖层 | 无损失 | Planar sufficient within Stage |
| T8 | body/time | 输入状态提示与备用按键 | 无法验证真实追踪连续性 | Stage beneficial; device-only proof |
| T9 | none | 2D 统计页 | 无损失 | Planar sufficient |
| T10 | simulation/time | 普通对象池/状态机 | 无用户可见损失 | no user-facing spatial value |

**Differentiated opportunity**：相较 C1/C3 以高速/大动作强化空间，本项目用受控方向、可达距离和“不动”强化舒适空间；C2 的离屏提示仅来自 Fruit Ninja VR 前代系列旁证，本项目从生成层消灭离屏危险。协作价值为 none。

## 5. Design Hypotheses

| Hypothesis | Information model | Container strategy | Spatial approach | Path/navigation | Primary interaction | Risk/cost |
|---|---|---|---|---|---|---|
| H1 前方温室门（selected） | 单一互动 gate 是判定中心，泡泡沿短弧漂入；HUD 只给时间/阶段 | Shared start → explicit Full Space Stage Mixed → stable exit | 安全扇形+固定 gate；三类共享一条可预测终点逻辑 | 开始→校准→三例→五档→结算；暂停为原位冻结 | 直接拍/握/不碰，手柄等价 | 需可靠碰撞、追踪仲裁、池；中等成本 |
| H2 三条前方花径 | 三条窄前方深度轨道并列，但每类仍按泡泡本身执行拍/抓/不碰；轨道只组织流量不编码答案 | Full Space Stage Progressive，中央主径+两侧次径 | 同一固定 gate 的三条可预测来路，全部在安全扇形 | 开始→三例→按轨道批次→结算 | 原动作不变；注意在三径间切换 | 无违规动作但横向注意成本更高、密集时遮挡 |
| H3 近桌温室 | 三类仍拍/抓/不碰，泡泡从桌后短距漂入桌前 gate | Shared Space Volumetric，明确不使用 Stage | 小尺度深度模拟，单个短路径 | 窗中校准→三例→五档→结算 | 原动作不变，灰泡自然通过桌前 gate | 更易实现，但近距遮挡/精细误触，空间价值较弱 |

三者在信息组织、容器、空间程度、路径、主要交互和成本上均不同，不是换色变体。

## 6. Concept Selection Matrix

**Non-compensable eligibility gates**（任一失败即不参与评分）：精确三动作与灰泡未触碰语义；每泡唯一终局；全部生成满足 G-S2 SafeFan；坐/站无需大幅移动；稳定退出；追踪失联不惩罚；控制器等价。H1/H2/H3 在纸面设计上均 `eligible_provisional`，真机 reach/comfort 尚未验证，不能据分数声称舒适通过。

评分 1–5；comfort/safety 是低置信设计估计，不是设备结论，且不能抵消 eligibility gate。

| Dimension | H1 | H2 | H3 | Basis |
|---|---:|---:|---:|---|
| Task efficiency | 5 | 4 | 4 | 三者均一对象一判断；H2 三径切换注意焦点，H3 近距遮挡 |
| Spatial value | 5 | 4 | 2 | H1 直接用方向/距离/身体；H3 接近 2D 盒子 |
| PICO comfort | 4 | 3 | 4 | provisional：H1 单 gate；H2 三径增加扫视；H3 近距遮挡 |
| Domain depth | 5 | 4 | 4 | 三者都表达 gate/untouched/pool；H1 单 gate 语义最直接 |
| Safety (5=low risk) | 4 | 3 | 4 | all eligible on paper; G-S2 device gap remains |
| Accessibility | 5 | 4 | 4 | 三者不要求移动且形色纹冗余；H2 扫视、H3 遮挡略弱 |
| Engineering feasibility | 4 | 3 | 5 | H1 中等碰撞/追踪；H3 最简单 |
| Distinctiveness | 5 | 4 | 3 | 三者共享“不动成功”；H1 以单 gate 温室节奏组织更聚焦 |
| Total /40 | **37** | 34 | 32 | only eligible concepts scored; not market-weighted |

- **Selected concept**：H1「前方温室门」。H1/H2/H3 均通过纸面资格门；H1 因单一焦点、最低扫视成本和最清晰 gate 语义得分最高，仍待真机舒适验证。
- **Rejected H2**：保留三动作和灰泡语义，但三径增加扫视与遮挡，违背单一互动焦点。
- **Rejected H3**：保留三动作和 gate，但近桌体积削弱迎面距离价值并增加手遮挡，Stage 不再必要。
- **positioning**：不是健身/高强度节奏游戏，而是“3 分钟舒适空间反应花园”。
- **rationale**：仅相对 C1–C3 这个相邻样本集，吸收直接动作和即时音乐反馈；避免 C1/C3 的高速/躲避；C2 的离屏提示证据只来自 Fruit Ninja VR 前代系列旁证，因此本项目机会仅表述为“从生成层避免视野外对象”。
- **evidenceRefs by judgment**：task efficiency→E-U1/E-D1；space→C1/C3 spatial columns；comfort→G-S2 gap（provisional）；off-screen differentiation→C2 predecessor evidence；positioning→E-M1 scoped sample + §3A differentiation opportunities。

## 7. Experience and Container Architecture

### 7.1 Experience layers

| Layer | Responsibility | Host | Entry / exit | Fallback |
|---|---|---|---|---|
| Prepare | Start, rules summary, calibration | Shared Space Planar `W-START` | app launch / explicit “进入练习” | stay windowed; recalibrate/close |
| Play | tutorial, five tiers, pause, results | Full Space `STAGE-GARDEN`, immersion=Mixed | explicit action after valid calibration / close Stage | controller fallback; exit returns Shared Space |
| Return | best score and replay | `W-START` after Stage closes | results “返回” | local data failure does not block exit |

Stage value is T3–T6 direction/distance/body interaction; it is not used for T9 statistics alone.

### 7.2 Container selection

| Container | Space | Form/tier | Responsibility | Default visibility | Stable exit |
|---|---|---|---|---|---|
| W-START | Shared Space | WindowContainer Planar, productivity/main | start, calibration preview, settings, best score | one primary window | system back closes app |
| STAGE-GARDEN | Full Space | Stage Mixed | spatial bubbles, gate, tutorial/game/pause/results | after explicit start only | results/confirm dialog closes Stage → Shared Space |
| HUD-PANEL | Full Space inside Stage | Planar WindowContainer, auxiliary/HUD | time/tier/pause/short prompts/result plane | one small helper plane | owned by Stage; disappears on close |

No Volumetric: core motion exceeds bounded box and needs Stage. No second primary window.

## 8. Window Attachment Decision Matrix

| Need | Placement mode | selectedType | Host | Role/persistence/frequency | Rationale | Rejected alternatives incl. Inline/None | Validation |
|---|---|---|---|---|---|---|---|
| Start/calibration actions | In-window | InlineControl | W-START | current-step, persistent, low | control beside preview | Toolbar wrong semantics; Dialog unnecessary; None loses action | gaze/pinch/controller |
| Page navigation | none | None | W-START | no pages | one linear start task | InlineControl only for actions; TabBar adds empty views | verify one path |
| Pause command | In-window | InlineControl | HUD-PANEL | high frequency | local to game status | Toolbar would duplicate; None loses pause | hit target/device reach |
| Tutorial hints | In-window | InlineControl-like anchored prompt, not attachment | HUD-PANEL | first 30s temporary | Stage prompt placed next to gate, no external window host semantic | Coachmark lacks stable Stage UI anchor; None harms learning | tutorial readability |
| End-run/exit confirmation | In-window modal | AlertDialog | HUD-PANEL | temporary/high-risk | user must respond before destructive end | InlineControl alone risks accidental exit; None unsafe | back/confirm/cancel |
| Results | In-window | None (content replaces HUD body) | HUD-PANEL | end state | no auxiliary need | Subwindow/SpatialPopup/Toolbar/InlineControl attachment add no value | readability |

Selected attachments: only `AlertDialog` for high-risk end/exit. No TabBar/Toolbar/Subwindow/Augment/SpatialPopup/Coachmark.

## 9. Window Sizing Derivation

**W-START**：Planar; 2D preparation; productivity/main tier; official baseline 1280×720dp; legal 320×180–2700×1800dp; depth fixed 640dp. Default viewing distance ≈1.75m, Dynamic worldScale; posture sitting/standing, pre-session. Core content checked within 65°×40°, no secondary beyond 85°×55°. Hit ≥56dp, body ≥16sp (never <12dp), contentInset 32dp.

| Candidate | Size | FOV/content rationale | Decision |
|---|---:|---|---|
| constrained | 720×560dp | single-column, rules collapse to chips; min readable | min |
| baseline | 1280×720dp | two-column calibration/rules, central gaze | selected default |
| large | 1560×900dp | more room but risks environmental occlusion | max |

Aspect ratio flexible 1.29–1.78; resize via reflow, never global scale. Large two columns 56/44; Compact single column; Constrained internal vertical scroll. Title overhead 72dp (project layout, not attachment).

**HUD-PANEL**：Planar; auxiliary/HUD tier; baseline 1280×720 considered/rejected as excessive during play. Authoritative state sizes (inset 24dp): gameplay Regular 920×228/content872×180; gameplay Constrained 640×276/content592×228; pause Regular 920×560/content872×512; pause Constrained 640×568/content592×520; result Large 1120×700/content1072×652; result Compact 920×688/content872×640; result Constrained 640×608/content592×560. Legal min across states 640×180, max1120×700, depth640. Core ≤65°×40°. Flexible aspect/state reflow; device validation required.

## 10. State Graph / Transition Graph

| State | Primary task/decision | Focus/layout/components/data | Entry/exit/back | Exceptions |
|---|---|---|---|---|
| S0_START | decide calibrate/start | calibration hero; rules trio; best | launch → S1; back close | storage error banner |
| S1_CALIBRATE | accept/retry envelope | CalibrationHalo + status | initial success→S2; mid-run success→origin S4; back S0(initial) or S4(mid-run) | no floor/head pose→retry/exit |
| S2_TUTORIAL | execute three examples | BubbleActor+Gate+Prompt+HUD | explicit Stage; 30s→S3; back opens D1 | gesture loss holds step; no penalty |
| S3_GAME | classify bubbles | BubbleActor+Gate+HUD+receipt | 180s→S5; pause→S4; back D1 | loss grace; pool boundary recycle |
| S4_PAUSED | resume/end/recalibrate | PauseVeil; all clocks/poses frozen | resume S3/S2; end D1 | calibration shift→S1 preserving no score |
| D1_END_CONFIRM | confirm destructive end/exit | EndRunDialog | endRun confirm S5; exitStage confirm closes Stage; cancel prior | system back=cancel |
| S5_RESULTS | understand stats/badge/best | ResultConstellation | replay→S1; return closes Stage→S0 | save error retry; partial stats labeled |

| Transition | Trigger | Action | Confirmation |
|---|---|---|---|
| TR1 S0→S1 | “校准互动区” | sample head/floor and show envelope | no |
| TR2 S1→S2 | “进入练习” when valid | open Stage Mixed, spawn tutorial normal | explicit action itself |
| TR3 S2→S3 | tutorial clock 30s & three examples terminal | start tier1 without cut | no |
| TR4 S2/S3→S4 | pause button/controller menu | freeze session clock, physics, spawns, music timeline | no |
| TR5 S4→prior | resume | restore exact snapshot | no |
| TR6 S2/S3/S4→D1 | end/system back | present risk | yes |
| TR7 D1→S5 | confirm end | stop run, compute partial results | yes |
| TR8 S3→S5 | 180s | freeze, compute results | no |
| TR9 S5→S1 | replay | clear ledger, recalibrate | no |
| TR10 S5→S0 | return | close Stage → Shared Space, persist best | no |
| TR11 S5→S5 | retry save | atomic local write | no |
| TR12 S4→S1 | “重新校准” | discard active bubbles without score, retain elapsed/ledger snapshot, close/reopen calibration path | no |
| TR13 S1→S4 | recalibration valid with origin=S4 | rebuild gate, return paused with elapsed/ledger retained | no |
| TR14 S5→D1(exitStage) | exit command | show EndRunDialog exitStage variant | yes |
| TR15 D1(exitStage)→S0 | confirm | close Stage and return Shared Space | yes |

## 11. End-to-End User Flow

`Launch → calibrate → explicit Full Space → 0/10/20s three tutorial examples → tiers at 30/60/90/120/150s → results at 180s → replay or close Stage`. Every state has back: S0 close; S1 S0; gameplay opens D1; D1 cancels; results returns Shared Space.

## 12. Eye-Hand Input Interaction Spec

| Input | Mapping | Feedback/recovery |
|---|---|---|
| gaze+pinch | all Planar buttons focus then pinch; hover stroke4/micro-scale≤1.03 | 120ms, text/shape redundant |
| hand hit | palm/finger collision with normal in gate-active | pop + soft spatial chime; other kinds wrong terminal |
| hand grab | grip/pinch enclosure on gold, maintain candidate 180ms | gold folds inward + chime; thresholds device-tuned |
| untouched | gray crosses exit plane with `touched=false` | leaf/check glyph + pass sound; no movement required |
| controller | button A/trigger = hit targeted bubble; grip = grab; no input = untouched | same ledger and feedback; target restricted to gate-active nearest bubble |
| system back | start closes; gameplay opens D1; D1 cancels; result returns | stable exit always reachable |

Input continuity state machine: `VALID_HAND → LOST_GRACE(disarm hand judgments; world continues) → VALID_HAND_REARM(after continuous valid samples)`, or `CONTROLLER_ACTIVE`. No event from invalid samples; already terminal bubbles ignore all input. Paused precedes all. Recalibration from pause ends/invalidates current active objects without scoring and rebuilds gate. High-risk end/exit always D1; pause/replay/save retry no confirmation.

Accessibility contract: reduceMotion enabled; controllerFallback enabled; colorIndependentSemantics enabled; textScaling 100/125/150%; stableExit enabled; left/right hand equivalent; audio never sole feedback.

## 13. Motion Spec

### 13.1 Transition list

| Motion | Trigger/purpose | Duration/range | Reduce Motion | Performance fallback |
|---|---|---|---|---|
| bubble drift | spawn→gate, convey depth | 4.8–7.0s candidate, 1.4m max, constant gentle easing | straight path/no trail | no trail, lower active count |
| normal pop | correct hit | 180ms, radius +8cm then fade | 80ms opacity+glyph | glyph only |
| gold fold | correct grab | 240ms, inward 6cm | 100ms scale .95 | glyph only |
| gray pass | untouched exit | 220ms, leaf glyph rise 4cm | static check 500ms | label only |
| wrong | mismatch | 160ms soft outline, no screen flash | static triangle+label | label only |
| theme blend | each 30s, mood change | 1800ms color/audio crossfade, no camera/speed jump | instant token swap + 400ms audio fade | instant colors, single audio stem |
| pause | pause | 120ms veil; object velocities set zero immediately | instant veil | opaque panel |
| result resize | enter S5 | 260ms HUD bounds/reflow | instant reflow | fixed max card |

### 13.2 Easing

- gentle=`cubic-bezier(.2,.7,.2,1)`; feedback=`cubic-bezier(.2,.9,.3,1)`; linear for world drift.

### 13.3 Comfort/safety

No virtual camera movement, head-locked world motion, continuous pulse or full-screen flash. Themes: 0 mint dawn, 1 peach mist, 2 lilac air, 3 aqua garden, 4 apricot dusk, 5 moon teal; music adds one quiet stem per segment but loudness normalized and tempo unchanged. Pause freezes spawn clock, session clock, paths, feedback timelines and music crossfade at the same frame.

## 14. Layout Skeleton and Placement Geometry

| Layout | Derivation | Primary focus | Regions / geometry | Density ceiling | Reflow | Rejected |
|---|---|---|---|---|---|---|
| L-START | T1/T2 sequential; calibration higher frequency than settings; Planar core FOV | CalibrationHalo | W-START: header 72dp; left preview 56%; right 3-rule stack 44%; bottom actions | 1 hero + 3 rule rows + 2 actions | Compact stacks preview→rules→actions; Constrained scrolls rules | dashboard cards rejected; multiwindow rejected |
| L-PLAY | T6 dominates; HUD only supporting; G-S2 spatial constraint | nearest unjudged BubbleActor inside approach lane | world origin=head calibration; spawn fan h±35/v−20..+18/r1.35..2.10m; gate center head-forward 0.70m, y−0.20m; gate 0.84w×0.72h×0.22d m; HUD upper-center | max active tutorial 1; tiers 2/3/4/5/6; max 3 simultaneously in gate corridor; JudgmentReceipt is BubbleActor.feedback, not separate component | no layout resize; Reduce Motion shortens trail/particles | lanes/tunnel and orbiting HUD rejected |
| L-PAUSE | freeze proof and resume | PauseVeil resume button | matte panel center at 0.9m; world objects dim/frozen behind | 3 actions max | Constrained vertical | floating tool ring rejected |
| L-RESULT | reading/comparison; T9 Planar-sufficient | badge + accuracy | HUD expands: header/badge; accuracy; 3 category rows; best/save; actions | 1 badge, 4 metrics, 2 actions | Large two columns; Compact/Constrained one column/scroll | 3D score fireworks rejected |

**World placement contract**：head-relative right-handed basis; forward is negative local Z at calibration adapter; downstream must map to actual SDK convention and assert `dot(normalized(spawn-head), headForward)>0`. No spawn below estimated floor, within 0.60m face sphere, or within 0.30m overhead near-zone. Layout coordinates are candidates pending device validation.

## 15. Minimum Completeness Gate

| Check | Evidence | Verdict |
|---|---|---|
| Principles | §2 | pass |
| Tasks with outputs/consequences | §3 T1–T10 | pass |
| ≥3 substantive hypotheses and selection | §4–§6 | pass |
| Container/attachment/sizing/state/exit | §7–§11 | pass |
| Layout derivation | §14 | pass |
| Interaction/recovery/accessibility | §12 | pass |
| Motion/reduce/performance | §13 | pass |

| Field | Value |
|---|---|
| minimumCompletenessGate | pass |

## 16. Delivery and Recipients

- Stage 5 output: task/decision model.
