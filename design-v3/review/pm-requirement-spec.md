# 空间应用需求规格 · BubbleReflexLab v3

> revision: 3 · role: `product_strategist` · stages: intent + quality contract + CR-01 wording repair · sources: original prompt P0 + UXR2 · frozen product facts, not layout/visual approval

## 1. Intent decision

一款 PICO Spatial SDK Stage 中文空间反应小游戏：用户在一局固定三分钟内，只用“拍普通、抓金色、别碰灰色”三条规则完成近身但舒适的前方反应训练。产品目标是清晰、温和和可恢复，不是竞技高速、全身闪躲或健身强度。

## 2. Background and Problem

- **Target users**：希望获得短时空间反应乐趣的中文用户；可能站立或坐姿；不假定具备节奏游戏经验。
- **Use scenarios**：室内个人使用；开始前有安全与互动区校准；一局结束即给出可理解成绩。
- **Posture**：站姿和坐姿均须可选；所有必需动作限制为自然伸手范围。
- **Frequency / duration**：单局 180 秒，共六个 30 秒段：segment 0 是慢速教程，segments 1–5 分别对应五个固定难度 recipe。使用频率未知。
- **Spatial necessity, preliminary**：泡泡从前方远端缓慢进入固定互动区，方向、距离、到达时机和手部动作共同构成核心反馈；普通平面屏无法等价验证用户前方安全扇区与三维到达关系。

## 3. Key Moment

- **Screen-cannot-achieve moment**：金色泡泡从前方可预期路径漂入手边，用户在固定互动区内自然合拢手指完成“抓住”，同时旁侧灰泡在未接触中安全通过；成功来自三维距离判断而非按钮记忆。
- **Immersion spectrum**：启动、规则、结算在 Shared Space 的 Planar WindowContainer；教程和游戏进入 Full Space Stage。具体容器架构由 Stage 9 决定。
- **Entry path**：默认先呈现可管理的启动窗口，由用户明确开始并确认互动区后进入 Stage，不自动沉浸。

## 4. Frozen intent fields

| field | decision |
|---|---|
| domain / sub-domain | casual spatial reaction game / three-category inhibition-and-action task |
| risk level | medium: moving 3D targets and hand movement require comfort, boundary and recovery controls |
| default space | Shared Space; explicit transition into Full Space Stage |
| audience language | Simplified Chinese |
| core rule | ordinary=拍破; gold=抓住; gray=不触碰直到通过互动区 |
| game duration | 180s fixed; six 30s segments total: segment 0 tutorial + segments 1–5 fixed recipes |
| tutorial | first 30s very slow; each type appears exactly once with short cue |
| progression | five fixed difficulty tiers after tutorial; increase count/combination without high-speed pressure |
| theme/audio | soft colorful theme and music layer switch every 30s; never accelerates tension |
| spawn safety | only forward fan-shaped safe region; never rear, near overhead, or below floor |
| movement demand | no large dodge, crouch, turn-around, or locomotion requirement |
| interaction | hand slap/grab/no-touch; controller button/grip fallback |
| game states | start, short tutorial, game, pause, result; exact state model deferred |
| scoring | accuracy, category statistics, bronze/silver/gold badge, local high score |
| resilience | transient hand loss, out-of-bounds recycling, interaction-zone calibration, full freeze on pause |
| collaboration | none |
| AI | none |
| required data | session clock, bubble lifecycle/type, input confidence/source, judgment events, score/category ledger, high score |
| sensors / permissions | head pose and hand/controller input expected; exact SDK support/permission is an implementation validation item, not assumed official fact |

## 5. Core tasks and decisions

| ID | user/system task | decision output | failure consequence |
|---|---|---|---|
| T01 | understand three rules | correct action vocabulary | category confusion |
| T02 | choose posture and calibrate | comfortable interaction zone accepted | unreachable targets/fatigue |
| T03 | generate bubbles safely | spawn is inside forward fan and valid height/range | surprise or unsafe reach |
| T04 | track bubble toward zone | active target and time-to-zone known | missed or premature action |
| T05 | slap ordinary | ordinary success/failure | category error |
| T06 | grab gold | gold success/failure | category error |
| T07 | allow gray to pass untouched | gray avoided when it clears zone | false demand for dodging |
| T08 | escalate five tiers | valid tier recipe selected | pressure spike/crowding |
| T09 | switch theme/music | atomic 30s layer change | distraction or timing drift |
| T10 | handle hand/controller input | one source armed; transient loss grace or pause | double judgment/unfair miss |
| T11 | pause/resume/recalibrate | all bubble and clock state frozen/restored | hidden motion or time loss |
| T12 | recycle terminal/invalid actors | pool ownership returned exactly once | leaks/ghost interactions |
| T13 | settle the run | accuracy/categories/badge/score derived | misleading result |
| T14 | save local best | write success/failure visible | false best-score claim |
| T15 | navigate back/exit | stable safe destination | trapped or accidental loss |

## 6. Assumptions

| ID | assumption | confidence | impact if false | validation plan | owner stage |
|---|---|---|---|---|---|
| A01 | intended hardware supports required Spatial SDK Stage and input stack | medium | project cannot implement intended container/input | downstream environment doctor + official SDK compatibility check | downstream, after acceptance |
| A02 | hand slap and grab can be distinguished robustly enough for play | low | core fairness fails | prototype thresholds, emulator/device test, controller fallback | downstream implementation/device |
| A03 | controller button for slap and grip for grab is understandable | medium | fallback confusion | controller usability test and visible input-source cue | Stage 11 + downstream |
| A04 | local high-score persistence needs no account permission | medium | saving architecture changes | verify platform storage policy during implementation | downstream |
| A05 | users can comfortably reach a chest-to-shoulder interaction band | medium | calibration defaults unsuitable | seated/standing reach study on device | downstream device validation |
| A06 | five post-tutorial tiers can vary density without increasing speed materially | high | difficulty feels flat or stressful | define recipes, then short-run playtest | Stage 6/11 + downstream |
| A07 | 30-second theme/music boundaries can be perceived without distraction | medium | boundaries become noisy | design-effect review and audio test | Stage 8/11 + downstream |
| A08 | no personal or network data is required | high | privacy/permission scope expands | product confirmation before implementation | PM / downstream |

## 7. Risks and non-negotiable boundaries

- Never spawn behind the head, near overhead, below the floor, or outside the calibrated forward fan.
- Gray success is “untouched until it clears the interaction zone”; body displacement is never required.
- Pause and input-loss safety state freezes actor transforms, timers, spawning and judgments together.
- Input source changes must not produce two judgments for one bubble.
- First 30 seconds contains one ordinary, one gold and one gray appearance with short Chinese cues.
- Speed remains gentle across all tiers; difficulty comes from count, spacing and combinations.
- Results do not invent score, badge, category totals or saved-best success when data is incomplete.

## 8. Quality Contract

### 8.1 Required outcomes

| ID | acceptance-testable outcome |
|---|---|
| O01 | A first-time Chinese user can state the three rules after the short tutorial without consulting a menu. |
| O02 | Every visible spawn originates within the currently accepted forward fan and never rear, face-near overhead or below-floor. |
| O03 | Ordinary slap, gold grab and gray untouched-passage each produce exactly one explainable terminal judgment. |
| O04 | Tutorial segment contains exactly one eligible appearance of each type, no overlap, and a short action cue. |
| O05 | Five fixed later recipes increase mixture/count/spacing complexity while keeping gentle motion; no recipe requires dodge/crouch/turn/locomotion. |
| O06 | At every 30s boundary, visual and audio layers change coherently without changing judgment timing or creating a speed spike. |
| O07 | Manual pause, recalibration and sustained input loss freeze clock, spawn, actor transforms and judgment as one invariant. |
| O08 | Controller fallback uses explicit single-source arbitration and exposes the active input source; no double judgment. |
| O09 | Result truthfully presents accuracy, three category totals, badge, run score, best score and persistence status. |
| O10 | User can start, learn, play, pause, recover, finish, replay, back out and safely exit without a dead end. |

### 8.2 Success / efficiency criteria

- Total play clock is exactly 180s excluding frozen pause time; six segment boundaries occur at 0/30/60/90/120/150s.
- Tutorial proof: exactly three eligible actors, ordered or spaced so only one decision is active, with one success opportunity for each rule.
- Spawn invariant acceptance: 0 invalid visible spawns in deterministic generation tests; invalid seeds recycle before visibility.
- Judgment invariant: every actor has 0 or 1 terminal verdict; no duplicate scoring across input-source changes or pool reuse.
- Pause invariant: after pause snapshot, clock/actor/spawn/judgment values remain unchanged until explicit resume/recalibration outcome.
- All primary controls are at least 56×56dp in Planar UI; body text no smaller than 12dp. These are design acceptance constraints, with physical readability still device-validated.
- Short test run must exercise ordinary/gold/gray, pause/resume, transient input loss, out-of-bounds return and result settlement; screenshots required downstream for tutorial and active play.
- User decision-time target is not invented: usability study records time-to-correct-action; failure is any repeated category confusion or pressure-driven unsafe reach.

### 8.3 Risks and must-not-fail

P0: invalid spawn direction/height/range; gray requiring body avoidance; actor motion during pause; double judgment; false saved/best claim; unusable stable exit. P1: color-only distinction, tutorial overlap, theme/audio boundary causing a motion/speed spike, input loss counted as miss, pool collider surviving return. All high-consequence exits that discard a run require consequence-specific confirmation with cancel as safe default.

### 8.4 Default visible primary windows

One primary Planar WindowContainer is preferred in Shared Space for entry and non-immersive information. Stage becomes the sole immersive primary host during play. No second primary window, toolbar, tab bar, wall of scores or auxiliary attachment is authorized by default; Stage 9 must independently compare InlineControl and None before any attachment.

### 8.5 Domain-specialized component orientation

Components must encode domain invariants rather than generic cards: safe-field calibration, arrival actor lifecycle, single-source input lease, segment recipe/layer boundary, atomic freeze seal, exactly-once verdict, category tally and truthful best-save status. Every core component later receives the complete eight-segment structure and coverage reconciliation.

### 8.6 Real-time data trust

- Live/fresh: actor transform/lifecycle, input lease, band crossing, clock and freeze seal.
- Event-immutable: committed verdict.
- Segment-atomic: recipe/theme/audio layer identifiers.
- Settlement: tally/badge/score; incomplete or conflicting ledger prohibits award/save.
- Persistent: best mark plus explicit write success/failure. A failed write never erases the visible current-run result or claims success.

### 8.7 PICO/platform and spatial hard constraints

- Use official concepts Shared Space, Full Space, Planar/Volumetric WindowContainer and Stage; do not freeze downstream implementation enums here.
- Opening Stage enters Full Space and hides other apps’ windows per PICO official evidence E07/E08; entry is explicit and exit closes the immersive session safely.
- Current concrete SDK/API/input support is a downstream environment/version verification; no automatic fallback claim.
- Spatial value must be task-by-task justified against a 2D counterfactual before Stage survives concept review.
- Window sizing must follow the PICO methodology chain and include legal 320×180dp–2700×1800dp range, 640dp depth, default/min/max, FOV reasoning, 56dp target and 12dp body lower limits.
- No preview or emulator artifact may be described as device comfort, physical FOV, tracking, runtime or exact timing evidence.

### 8.8 Originality / differentiation contract

`templateReuse=false`. Required differentiation is anchored to UXR1 §3.2: a calm forward arrival field, no-touch-as-stillness, recipe-not-speed difficulty, soft layer boundaries and explicit recovery. Absorb only early target readability, predictable approach/music layering and shape redundancy. Avoid and do not copy lanes/tracks, rails/choreography, wall/pose obstacles, neon show language, competitor state sequences or component sets. Stage 15 must record an evidence-based similarity audit.

### 8.9 Design, readability and implementation acceptance

The six role documents must pass their minimum gates; 17 receipts must be real, ordered and complete; review invocations must be fresh/isolated with exact revisions. Stage 11 requires full eight-block components and reconciliation tables. Preview must declare denominators before generation and implement every state/transition/element/binding/variant/component state/precedence/responsive/RM item with source-selector-trigger-expected-actual-verdict rows. Delivery requires Stage 4/7/12/14/15/17 pass plus main-thread re-derivation and acceptance. Android/runtime/device work remains outside this package.

## 9. Requirements traceability

| ID | mandatory requirement | planned evidence node |
|---|---|---|
| R01 | project identity `BubbleReflexLab`, package `com.pico.swan.bubblereflex` | PM identity; downstream bridge only after acceptance | package/name inspection downstream |
| R02 | Stage-based three-minute Chinese spatial reaction game | O01/O10; container/timeline facts | state and 180s clock maps |
| R03 | three memorable rules and visually immediate distinction | O01/O03; semantic contract | tutorial comprehension + shape/label audit |
| R04 | forward fan-only safe spawning | O02; safe-field + seed contract | deterministic pose boundary cases |
| R05 | slow drift into fixed interaction zone | O03; actor motion/band | motion-path inspection + device test |
| R06 | prohibit rear/near-overhead/below-floor spawning | O02 | invalid seeds never visible |
| R07 | first 30s one-of-each slow tutorial with short cues | O04 | tutorial event ledger exact 3 |
| R08 | five fixed later difficulty tiers | O05 | six-recipe table exact and triggerable |
| R09 | 30s soft theme/music changes, no speed pressure | O06 | boundary assertions and speed invariant |
| R10 | gray success by untouched passage, no large dodge | O03/O05 | band-crossing judgment case |
| R11 | object pooling | O03; actor lifecycle | acquire/terminal/return exactly once |
| R12 | slap/grab/no-touch judgments | O03 | decision table and result ledger |
| R13 | controller button/grip fallback | O08 | single-source switch cases; device check |
| R14 | result accuracy/category/badges | O09 | complete/partial/conflict settlement cases |
| R15 | start/tutorial/game/pause/result | O10 | state/transition denominator |
| R16 | local high score | O09 | read/write/failure truth cases |
| R17 | transient hand-loss handling | O07/O08 | grace→recover/pause cases |
| R18 | out-of-bounds recycle | O03 | return reason and disabled collider |
| R19 | interaction-zone calibration | O02 | seated/standing accept/retry cases |
| R20 | pause freezes all bubbles | O07 | freeze snapshot invariant |
| R21 | run a short acceptance test | §8.2 acceptance plan | downstream runtime/device evidence only |
| R22 | capture tutorial and gameplay screenshots | §8.2 acceptance plan | downstream screenshot evidence only |

## 10. Minimum Completeness Gate

| check | evidence | verdict |
|---|---|---|
| background and intent | §2–§5: users/scenario/posture/duration/spatial need/frozen fields | pass |
| assumptions | §6: eight rows include confidence, impact, plan and owner | pass |
| nine-part quality contract | §8.1–§8.9, sourced to prompt/UXR1/platform evidence | pass |
| all mandatory requirements traced | §9 R01–R22 with node and validation method | pass |

`minimumCompletenessGate=pass` (PM self-check; Stage 4 independent review required).
