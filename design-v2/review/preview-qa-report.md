# Preview / QA 报告 · BubbleReflexLab

> revision: 5 · generation stages: preview_build + CR-09 provenance rebuild (behavior unchanged from CR-08) · sources: Interaction6 + Visual4 + Critique12 · preview5 · scope: `web_design_validation_only`

## 2.1 Input Readiness

| fact | exact evidence | assertion | verdict |
|---|---|---|---|
| active critique provenance | Critique12, carrying Stage12 pass invocation `49b2b7a2-b8d7-4a1f-9cae-620cd2202c7d` and Stage14 rerun-3 evidence | Preview5 header cites Critique12 exactly; 7 components pass; A8/B12/C6 | pass |
| states/transitions | Interaction6 §10 | S0–S7; TR01–TR16 with triggers/actions/confirm | pass |
| 8-section structures | Visual4 §5–§6 | C1–C7 all 8 blocks | pass |
| elements | Visual4 C1–C7 renderSpec | 35 stable ids | pass |
| bindings | Visual4 C1–C7 dataBindings | 28 explicit source/target/fallback/type rows | pass |
| variants/states | Visual4 C1–C7 | 31 variants + 38 states + 7 precedence combinations | pass |
| responsive/motion | Interaction6 §9/§13; Visual4 §4 | Large/Compact/Constrained + Reduce Motion | pass |
| grammar | Visual4 §3 | tokens/type/semantics/materials conflict-free | pass |

## 2.2 Preview Coverage Manifest（declared before preview generation）

### 2.2.1 States / transitions (8 + 16)

| type/id | source | trigger | target/visible result | confirm | included |
|---|---|---|---|---|---|
| S0 ReadyHome | I6§10 | launch/Stage close | rules+start | N/A | yes |
| S1 ArcCalibration | I6§10 | TR01 | Ribbon calibration | yes entry | yes |
| S2 GuidedThree | I6§10 | TR02 | single tutorial actor | yes calibration | yes |
| S3 GentleRun | I6§10 | TR04/TR08 | multi-actor run | no | yes |
| S4 FrozenPause | I6§10 | TR05 | frozen pause actions | no | yes |
| S5 ExitConfirm | I6§10 | TR10 | blocking Dialog | yes | yes |
| S6 RunResult | I6§10 | TR13 | accuracy/category/badge | no | yes |
| S7 InputUnavailable | I6§10 | TR06 | frozen safe-exit | no | yes |
| TR01 | I6§10 | confirmStageEntry | S0→S1 | yes | yes |
| TR02 | I6§10 | calibration.accepted | S1→S2 | yes | yes |
| TR03 | I6§10 | cancelCalibration | S1→S0 | yes | yes |
| TR04 | I6§10 | clock.reaches30 | S2→S3 | no | yes |
| TR05 | I6§10 | user.pause | S2/S3→S4 | no | yes |
| TR06 | I6§10 | tracking.graceExpired | S2/S3→S7 | no | yes |
| TR07 | I6§10 | input.verifiedAndRearmed | S7→S3 | no | yes |
| TR08 | I6§10 | user.resume | S4→S3 | no | yes |
| TR09 | I6§10 | user.recalibrate | S4→S1 | yes | yes |
| TR10 | I6§10 | user.requestExit | S4→S5 | yes | yes |
| TR11 | I6§10 | cancelExit/back | S5→S4 | no | yes |
| TR12 | I6§10 | confirmExit | S5→S0 | yes | yes |
| TR13 | I6§10 | clock.reaches180 | S3→S6 | no | yes |
| TR14 | I6§10 | replay | S6→S1 | yes | yes |
| TR15 | I6§10 | returnHome | S6→S0 | no | yes |
| TR16 | I6§10 | retrySave | S6→S6 | no | yes |

### 2.2.2 renderSpec elements (35; one row per element)

| item | source | label/bind | conditional rule |
|---|---|---|---|
| C1.`c1-normal` | V4§5 C1 | 普通泡泡·拍 / staticRules.normal | S0/catalog |
| C1.`c1-gold` | V4§5 C1 | 金色泡泡·抓 / staticRules.gold | S0/catalog |
| C1.`c1-gray` | V4§5 C1 | 灰色泡泡·别碰 / staticRules.gray | S0/catalog |
| C1.`c1-stand` | V4§5 C1 | 站姿 / postureChoice | S0/catalog |
| C1.`c1-seated` | V4§5 C1 | 坐姿 / postureChoice | S0/catalog |
| C2.`c2-primary` | V4§5 C2 | 开始三分钟 / actionSet.primary | label by state |
| C2.`c2-secondary` | V4§5 C2 | 返回 / actionSet.secondary | S6/catalog |
| C2.`c2-status` | V4§5 C2 | 暂无最高分 / saveState | S0/catalog |
| C3.`c3-arc` | V4§5 C3 | 安全生成区 / SafeArc | S1–S3 |
| C3.`c3-ribbon` | V4§5 C3 | 互动区 / Ribbon | S1–S3 |
| C3.`c3-status` | V4§5 C3 | 舒适确认 / validity | S1 |
| C3.`c3-retry` | V4§5 C3 | 重新校准 / retry | S1 |
| C3.`c3-accept` | V4§5 C3 | 继续 / accept | S1 |
| C4.`c4-shell` | V4§5 C4 | 泡泡 / kind | S2/S3 |
| C4.`c4-symbol` | V4§5 C4 | 拍抓别碰 / kind | S2/S3 |
| C4.`c4-cue` | V4§5 C4 | 动作词 / kind | S2/S3/catalog |
| C4.`c4-feedback` | V4§5 C4 | 判定反馈 / Judgment | terminal/catalog |
| C5.`c5-time` | V4§5 C5 | 02:30 / remaining | S2/S3 |
| C5.`c5-cue` | V4§5 C5 | 当前动作 / cue | S2/S3 |
| C5.`c5-segment` | V4§5 C5 | 段落 / segment | S2/S3 |
| C5.`c5-input` | V4§5 C5 | 输入已暂停 / arbiter | active hidden/catalog |
| C6.`c6-title` | V4§5 C6 | 已暂停 / reason | S4/S5/S7 |
| C6.`c6-resume` | V4§5 C6 | 继续 / resume | S4/S7 |
| C6.`c6-calibrate` | V4§5 C6 | 重新校准 / recalibrate | S4/S7 |
| C6.`c6-exit` | V4§5 C6 | 退出本局 / exit | S4/S7 |
| C6.`c6-cancel` | V4§5 C6 | 取消 / cancel | S5/catalog |
| C6.`c6-confirm` | V4§5 C6 | 退出且不保存 / confirm | S5/catalog |
| C7.`c7-accuracy` | V4§5 C7 | 准确率 / accuracy | S6 |
| C7.`c7-badge` | V4§5 C7 | 徽章 / badge | S6 |
| C7.`c7-normal` | V4§5 C7 | 拍破统计 / normal | S6 |
| C7.`c7-gold` | V4§5 C7 | 抓住统计 / gold | S6 |
| C7.`c7-gray` | V4§5 C7 | 未碰统计 / gray | S6 |
| C7.`c7-score` | V4§5 C7 | 本局分 / score | S6 |
| C7.`c7-best` | V4§5 C7 | 最高分 / best | S6 |
| C7.`c7-save` | V4§5 C7 | 保存状态 / saveState | S6 |

### 2.2.3 dataBindings (28; one row per binding)

| component/source | target | normal | fallback/error | type |
|---|---|---|---|---|
| C1 `staticRules.*` | rule labels/symbols | Chinese+shape | built-in copy | display |
| C1 `postureChoice` | posture selected | standing | empty disables | semantic |
| C2 `actionSet.*` | buttons | start/replay | hide inapplicable | display |
| C2 `canStart` | primary.enabled | true | false+reason | semantic |
| C2 `saveState` | status | saved | unknown/error | semantic |
| C3 `SafeArc.*` | arc geometry | valid | hide+block | display |
| C3 `InteractionRibbon.*` | ribbon geometry | valid | hide+block | display |
| C3 `calibrationValidity` | status/accept | valid | invalid/error | semantic |
| C3 `postureChoice` | geometry | standing | unknown→block | semantic |
| C4 `BubbleSeed.kind` | shell/symbol/cue | normal | unknown→pool | semantic |
| C4 `BubbleSeed.pose` | transform | valid front | outside→pool | display |
| C4 `InputArbiter.armed` | collider | true | false | semantic |
| C4 `Judgment.outcome` | feedback/lifecycle | hit | passage fallback | semantic |
| C5 `SegmentClock.remaining` | time | 150 | --:-- paused | display |
| C5 `SegmentClock.segment` | segment | T2 | unknown/no speed | display |
| C5 `ThemeLayer.themeId` | theme | lake | morning cyan | semantic |
| C5 `ThemeLayer.audioLayerId` | caption/audio | bell | soft layer | display |
| C5 `currentCue` | cue | grab | hide | semantic |
| C5 `InputArbiter.state` | input badge | active | unknown→freeze | semantic |
| C6 `FrozenSnapshot.valid` | resume.enabled | true | false+reason | semantic |
| C6 `InputArbiter.state` | title/reason | active | unavailable | semantic |
| C6 `exitIntent` | confirm variant | closed | closed | semantic |
| C7 `RunLedger.accuracy` | accuracy | 92 | incomplete | display |
| C7 `RunLedger.badge` | badge | gold | 完成 | semantic |
| C7 `RunLedger.normal/gold/gray` | category stats | 8/9,5/6,7/7 | —/— | display |
| C7 `RunLedger.score` | score | 2140 | — | display |
| C7 `bestScore` | best | 2280 | 暂无最高分 | display |
| C7 `saveState` | save | saved | unknown/error | semantic |

### 2.2.4 Variants / component states / precedence (31 + 38 + 7)

| component | variants (individual) | states (individual) | precedence combination | trigger / observable result |
|---|---|---|---|---|
| C1 | ready;replay;Constrained | default;focused;selected;disabled;overflow | selected+focused;disabled+focused | inspector control→rule grid/selection/ring/scroll |
| C2 | start;result;saveError;exitConfirm | default;focused;pressed;disabled;error | error+focused;disabled+focused | control→labels/button affordance/error |
| C3 | standing;seated;recalibration | loading;valid;invalid;focused;error | error+focused;invalid+focused | control→arc/status/actions |
| C4 | normal;gold;gray;tutorial;reduceMotion | pooled;drifting;graceFrozen;judgedSuccess;judgedError;outOfBounds | terminal+graceFrozen | control→shape/symbol/motion/hidden |
| C5 | tutorial;run;paused;reduceMotion | active;boundary;paused;partial;error | error+paused | control→time/theme/input label |
| C6 | manualPause;trackingPause;inputUnavailable;exitConfirm | visible;focused;disabled;confirm;error | confirm+focused;error+confirm | control→buttons/Dialog/default cancel |
| C7 | complete;noBadge;bronze;silver;gold;newBest;saveError;partial | loading;complete;newBest;empty;partial;error;overflow | partial+error;newBest+complete | control→metrics/badge/save/fallback/reflow |

Authoritative one-item-per-row denominator (the summary above is non-authoritative):

| item | kind | source | trigger | observable |
|---|---|---|---|---|
| C1.ready | variant | V4 C1 | select ready | start rule set |
| C1.replay | variant | V4 C1 | select replay | posture prefilled |
| C1.Constrained | variant | V4 C1 | select Constrained | single column |
| C1.default | state | V4 C1 | select default | semantic strokes |
| C1.focused | state | V4 C1 | select focused | white ring |
| C1.selected | state | V4 C1 | select selected | check+selected copy |
| C1.disabled | state | V4 C1 | select disabled | .55+reason |
| C1.overflow | state | V4 C1 | select overflow | scroll |
| C1.precedence | precedence | V4 C1 | select state combos | disabled wins; selected+focus preserved |
| C2.start | variant | V4 C2 | select start | start CTA |
| C2.result | variant | V4 C2 | select result | replay/home |
| C2.saveError | variant | V4 C2 | select saveError | retry/home |
| C2.exitConfirm | variant | V4 C2 | select exitConfirm | cancel/exit |
| C2.default | state | V4 C2 | select default | brand fill |
| C2.focused | state | V4 C2 | select focused | ring |
| C2.pressed | state | V4 C2 | select pressed | pressed feedback |
| C2.disabled | state | V4 C2 | select disabled | lock+reason |
| C2.error | state | V4 C2 | select error | triangle+retry |
| C2.precedence | precedence | V4 C2 | select combos | disabled wins; error keeps ring |
| C3.standing | variant | V4 C3 | select standing | standing geometry |
| C3.seated | variant | V4 C3 | select seated | seated geometry |
| C3.recalibration | variant | V4 C3 | select recalibration | frozen-run copy |
| C3.loading | state | V4 C3 | select loading | dashed/locating |
| C3.valid | state | V4 C3 | select valid | positive+continue |
| C3.invalid | state | V4 C3 | select invalid | caution+reason |
| C3.focused | state | V4 C3 | select focused | ring |
| C3.error | state | V4 C3 | select error | opaque safe exit |
| C3.precedence | precedence | V4 C3 | select combos | error>invalid>loading>focus |
| C4.normal | variant | V4 C4 | select normal | circle+crack |
| C4.gold | variant | V4 C4 | select gold | ring+handle |
| C4.gray | variant | V4 C4 | select gray | hex+bar |
| C4.tutorial | variant | V4 C4 | select tutorial | larger+coach |
| C4.reduceMotion | variant | V4 C4 | select reduceMotion | no bob |
| C4.pooled | state | V4 C4 | select pooled | hidden |
| C4.drifting | state | V4 C4 | select drifting | visible drift |
| C4.graceFrozen | state | V4 C4 | select graceFrozen | dashed halo/frozen |
| C4.judgedSuccess | state | V4 C4 | select judgedSuccess | positive feedback |
| C4.judgedError | state | V4 C4 | select judgedError | caution copy |
| C4.outOfBounds | state | V4 C4 | select outOfBounds | hidden/pool |
| C4.precedence | precedence | V4 C4 | select combos | terminal wins |
| C5.tutorial | variant | V4 C5 | select tutorial | step 1/3 |
| C5.run | variant | V4 C5 | select run | segment label |
| C5.paused | variant | V4 C5 | select paused | frozen time |
| C5.reduceMotion | variant | V4 C5 | select reduceMotion | static theme |
| C5.active | state | V4 C5 | select active | time/cue |
| C5.boundary | state | V4 C5 | select boundary | theme switch |
| C5.pausedState | state | V4 C5 | select paused | pause label |
| C5.partial | state | V4 C5 | select partial | time-only/caution |
| C5.error | state | V4 C5 | select error | timing error |
| C5.precedence | precedence | V4 C5 | select combos | error>paused>partial |
| C6.manualPause | variant | V4 C6 | select manualPause | three actions |
| C6.trackingPause | variant | V4 C6 | select trackingPause | tracking reason |
| C6.inputUnavailable | variant | V4 C6 | select inputUnavailable | safe exit |
| C6.exitConfirm | variant | V4 C6 | select exitConfirm | confirm/cancel |
| C6.visible | state | V4 C6 | select visible | opaque panel |
| C6.focused | state | V4 C6 | select focused | ring |
| C6.disabled | state | V4 C6 | select disabled | no resume/reason |
| C6.confirm | state | V4 C6 | select confirm | cancel default |
| C6.error | state | V4 C6 | select error | safe exit only |
| C6.precedence | precedence | V4 C6 | select combos | error>confirm>disabled |
| C7.complete | variant | V4 C7 | select complete | full metrics |
| C7.noBadge | variant | V4 C7 | select noBadge | 完成 label |
| C7.bronze | variant | V4 C7 | select bronze | 铜徽章 |
| C7.silver | variant | V4 C7 | select silver | 银徽章 |
| C7.gold | variant | V4 C7 | select gold | 金徽章 |
| C7.newBest | variant | V4 C7 | select newBest | 新纪录 |
| C7.saveError | variant | V4 C7 | select saveError | retained+retry |
| C7.partial | variant | V4 C7 | select partial | no eligibility |
| C7.loading | state | V4 C7 | select loading | skeleton |
| C7.completeState | state | V4 C7 | select complete | metrics |
| C7.newBestState | state | V4 C7 | select newBest | diamond+copy |
| C7.empty | state | V4 C7 | select empty | 暂无最高分 |
| C7.partialState | state | V4 C7 | select partial | incomplete/no badge |
| C7.error | state | V4 C7 | select error | save retry copy |
| C7.overflow | state | V4 C7 | select overflow | single column scroll |
| C7.precedence | precedence | V4 C7 | select combos | partial>error>newBest |

### 2.2.5 Responsive / Reduce Motion (4)

| scenario | source | tier/content | trigger | expected |
|---|---|---|---|---|
| Large | I6§9/V4§4 | max1440×840 | tier selector | 3-column, no target shrink |
| Compact | I6§9/V4§4 | default1120×720 | tier selector | normal grid |
| Constrained | I6§9/V4§4 | min720×620 | tier selector | single-column+scroll/fixed CTA |
| Reduce Motion | I6§13 | N/A | checkbox | animation durations reduced/no bob |

Generation denominator: states8; transitions16; elements35; bindings28; variants31; component states38; precedence7; responsive4. Manifest gaps=0. All later rows are generation-side observations with explicit actual and verdict; Stage 14 independently rebuilds the evidence rather than inheriting those verdicts.

## 2.3 Generation declarative checks

| check | source | selector/mechanism | trigger | expected | generation actual in preview5 | verdict |
|---|---|---|---|---|---|---|
| Manifest complete | §2.2 | report denominator | compare V4/I6 | exact 8/16/35/28/31/38/7/4 | exact counts; gaps0 | pass |
| state machine | I6§10 | `states`,`transitions`,`renderScene`, `[data-current-state]` | choose S0–S7 | distinct scene/task | all eight state scenes render distinct task/focus | pass |
| transitions | TR01–16 | `#transitionSelect`, `#runTransition` | execute each from valid source and once from wrong source | target visible; invalid origin rejected | target changes; wrong source message remains visible | pass |
| element DOM | Visual4 C1–C7 | `[data-preview-id="<id>"]` | render owning state or inspect catalog | stable selector and conditional evidence | 35 selectors exist; conditional items are visible in catalog/owning Dialog | pass |
| data modes | Visual4 28 bindings | `[data-binding-case]`, `#dataMode` | switch normal→fallback→error | item-specific value plus target mutation | 28 active values mutate; safety-critical scene targets also mutate | pass |
| component behaviors | Visual4 variants/states/precedence | `#scene [data-component-root]`, `#componentDemo`, `#applyComponent` | choose each exact item and apply | actual owning component structure/state/winner mutation plus clone | owner scene is rendered first; its real component root mutates, then the same root is cloned to the demo | pass |
| high risk | TR01/02/03/09/10/12/14 | `#riskDialog`, `#dialogCancel`, `#systemBack` | run risk transition; cancel, Escape/back, confirm | modal blocks with specific consequence and cancel default focus | TR-specific copy; cancel focused; Escape/back cancels first | pass |
| responsive/motion | I6§9/13 | `[data-responsive]`,`[data-reduce-motion]`, `.motion-sample`, assertions | select every tier; toggle Reduce Motion | exact area/reflow/56dp/fixed CTA; observable bob stops with semantics preserved | nested S1 CTA also sticky; `.motion-sample` has gentleBob baseline and `.reduced` stops it without changing bubble label/shape/judgment | pass |

## 3 Generation mapping authority

The earlier locator-only duplicate tables remain removed. CR-08's five authoritative implementation mapping tables are §8.1–§8.5; every item row carries source fact, stable selector, real trigger, expected, generation actual, and generation verdict.


## 4. Requirements traceability

R01–R03→S2/S3/C4；R04–R06→S1–S3/C3/C4；R07–R10→S2/S3/C5；R11→C4 lifecycle；R12–R13→C4/C5/C6；R14→S4/S7/C6；R15→S0–S7/TR01–16；R16–R17→S6/C7/C2；R18–R19→C1/C4/semantic shapes/56px controls；R20–R21→S4/S5/TR09–12；R22→S2/S3 renderable states。Coverage 22/22；Web validates logic/visual distinction only.

## 5. Sample modes

Normal, fallback and error values are listed item-by-item in §3.3; all user-visible samples are Chinese labels, not machine enums. `#dataMode` is the common trigger and bound nodes carry `[data-binding]`.

## 6–7 Boundary

Logical tolerance=`exact_id_relationship_match`; token tolerance=`declared_group_reference_presence`; exclusions=`screenshot_visual_diff, css_pixel_to_pico_physical_size, device_color_delta, web_pico_parity`.

`deviceValidation.status=not_performed`: physical distance/readability, occlusion, fatigue, hand/controller precision, runtime performance/safety, spatial audio and actual 180s timing remain downstream device work. Web logical coverage is pending independent Stage14 review.

## 8 CR-09 active generation mappings (CR-08 behavior unchanged; independent QA still required)

- `preview5` renders the owning scene, mutates its real `[data-component-root="C1"…"C7"]` for every selected variant/state/precedence rule, then clones that same root into `#componentDemo`; the demo is evidence, not the behavioral owner.
- S0 begins with `canStart=false`; the native posture buttons set selected state and only then enable the native primary button, whose click opens TR01.
- Every binding lab row exposes `data-owning-selector` and a native “在所属组件验证” button; activation renders the owner state and adds item-specific `data-binding-evidence` plus visible semantic value on the concrete target.
- `#bindingLab` contains 28 distinct `[data-binding-case]` rows, each simultaneously declaring normal/fallback/error, with `#dataMode` selecting an item-specific active result. The current scene also hides/blocks geometry, disables controls, returns invalid actors, freezes input, and preserves ledger/save semantics as applicable.
- `#systemBack`, Escape and `popstate` implement S1 confirmation, S2/S3 pause, S4 resume, S5 cancel, S6 home; open Dialog is cancelled first.
- Risk Dialog uses TR-specific consequences, cancel receives default focus, and Escape/system-back cancels.
- `#tierAssertion` states exact 1440×840 / 1120×720 / 720×620 structural expectations; nested S1 calibration actions are included in Constrained sticky CTA rules. `.motion-sample` supplies a gentle-bob baseline and `#reduceMotion` stops that motion while semantic feedback persists.
- Semantic consumption is visible through `.semantic-chip` color + circle/diamond/dashed/triangle + Chinese label, including calibration, input, badge, save and errors.

### 8.1 Per-item state / transition evidence

| item | source fact | stable selector | real trigger | expected | generation actual in preview5 | generation verdict |
|---|---|---|---|---|---|---|
| S0 | Interaction6 §10 S0 | `#stateSelect, [data-state=S0]` | stateSelect=S0 | rules/start | `[data-state=S0]` renders C1/C2 | pass |
| S1 | Interaction6 §10 S1 | `#stateSelect, [data-state=S1]` | stateSelect=S1 | calibration | C3 geometry/actions | pass |
| S2 | Interaction6 §10 S2 | `#stateSelect, [data-state=S2]` | stateSelect=S2 | tutorial | single normal actor+cue | pass |
| S3 | Interaction6 §10 S3 | `#stateSelect, [data-state=S3]` | stateSelect=S3 | game | normal/gold/gray visibly distinct | pass |
| S4 | Interaction6 §10 S4 | `#stateSelect, [data-state=S4]` | stateSelect=S4 | pause | frozen pause panel | pass |
| S5 | Interaction6 §10 S5 | `#stateSelect, [data-state=S5], #riskDialog[data-transition=TR12], #dialogCancel` | select S5 and activate #renderState | same blocking Dialog used by TR12; cancel is default focus; Escape/back returns safely | loss consequence copy visible and `#dialogCancel` receives focus | pass |
| S6 | Interaction6 §10 S6 | `#stateSelect, [data-state=S6]` | stateSelect=S6 | result | accuracy/categories/badge/save | pass |
| S7 | Interaction6 §10 S7 | `#stateSelect, [data-state=S7]` | stateSelect=S7 | unavailable | frozen safe-exit panel | pass |
| TR01 | Interaction6 §10 TR01 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | transitionSelect TR01 | Dialog→S1/cancel | specific Full Space copy; cancel focused | pass |
| TR02 | Interaction6 §10 TR02 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR02 | Dialog→S2 | tutorial consequence copy | pass |
| TR03 | Interaction6 §10 TR03 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR03/Escape S1 | Dialog→S0 | close-stage copy | pass |
| TR04 | Interaction6 §10 TR04 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR04 | S2→S3 | direct render S3 | pass |
| TR05 | Interaction6 §10 TR05 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR05/Escape S2/S3 | →S4 | pause/freeze visible | pass |
| TR06 | Interaction6 §10 TR06 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR06 | →S7 | input unavailable visible | pass |
| TR07 | Interaction6 §10 TR07 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR07 | S7→S3 | game returns | pass |
| TR08 | Interaction6 §10 TR08 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR08/Escape S4 | S4→S3 | resumes game | pass |
| TR09 | Interaction6 §10 TR09 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR09 | Dialog→S1 | frozen recalibration copy | pass |
| TR10 | Interaction6 §10 TR10 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR10 | Dialog→S5 | prepare-exit copy | pass |
| TR11 | Interaction6 §10 TR11 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR11/Escape S5 | →S4 | cancel returns pause | pass |
| TR12 | Interaction6 §10 TR12 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR12 | Dialog→S0 | loss consequence copy | pass |
| TR13 | Interaction6 §10 TR13 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR13 | S3→S6 | result visible | pass |
| TR14 | Interaction6 §10 TR14 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR14 | Dialog→S1 | replay consequence | pass |
| TR15 | Interaction6 §10 TR15 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR15/Escape S6 | →S0 | home visible | pass |
| TR16 | Interaction6 §10 TR16 | `#transitionSelect, #runTransition, #riskDialog, #systemBack` | TR16 | S6→S6 | save state rerender | pass |

### 8.2 Per-item render element evidence

For each row trigger=render owning state or inspect catalog; expected=stable visible or conditional-hide result; actual=exact selector exists in scene/catalog; all source anchors are Visual4 component block.

| item | source fact | stable selector | real trigger | expected | generation actual in preview5 | generation verdict |
|---|---|---|---|---|---|---|
| c1-normal | Visual4 C1 renderSpec.elements[]/c1-normal | `[data-preview-id=c1-normal]` | render S0, then inspect `[data-preview-id=c1-normal]` | stable element follows its visible/conditional contract | visible circle+label | pass |
| c1-gold | Visual4 C1 renderSpec.elements[]/c1-gold | `[data-preview-id=c1-gold]` | render S0, then inspect `[data-preview-id=c1-gold]` | stable element follows its visible/conditional contract | visible diamond+label | pass |
| c1-gray | Visual4 C1 renderSpec.elements[]/c1-gray | `[data-preview-id=c1-gray]` | render S0, then inspect `[data-preview-id=c1-gray]` | stable element follows its visible/conditional contract | visible hex/bar+label | pass |
| c1-stand | Visual4 C1 renderSpec.elements[]/c1-stand | `[data-preview-id=c1-stand]` | render S0, then inspect `[data-preview-id=c1-stand]` | stable element follows its visible/conditional contract | visible control | pass |
| c1-seated | Visual4 C1 renderSpec.elements[]/c1-seated | `[data-preview-id=c1-seated]` | render S0, then inspect `[data-preview-id=c1-seated]` | stable element follows its visible/conditional contract | visible control | pass |
| c2-primary | Visual4 C2 renderSpec.elements[]/c2-primary | `[data-preview-id=c2-primary]` | render S0/S6, then inspect `[data-preview-id=c2-primary]` | stable element follows its visible/conditional contract | state label/disable mutation | pass |
| c2-secondary | Visual4 C2 renderSpec.elements[]/c2-secondary | `[data-preview-id=c2-secondary]` | render S6/catalog, then inspect `[data-preview-id=c2-secondary]` | stable element follows its visible/conditional contract | visible/conditional | pass |
| c2-status | Visual4 C2 renderSpec.elements[]/c2-status | `[data-preview-id=c2-status]` | render S0, then inspect `[data-preview-id=c2-status]` | stable element follows its visible/conditional contract | best/save fallback | pass |
| c3-arc | Visual4 C3 renderSpec.elements[]/c3-arc | `[data-preview-id=c3-arc]` | render S1–S3, then inspect `[data-preview-id=c3-arc]` | stable element follows its visible/conditional contract | visible; fallback hides | pass |
| c3-ribbon | Visual4 C3 renderSpec.elements[]/c3-ribbon | `[data-preview-id=c3-ribbon]` | render S1–S3, then inspect `[data-preview-id=c3-ribbon]` | stable element follows its visible/conditional contract | visible; fallback hides | pass |
| c3-status | Visual4 C3 renderSpec.elements[]/c3-status | `[data-preview-id=c3-status]` | render S1, then inspect `[data-preview-id=c3-status]` | stable element follows its visible/conditional contract | semantic chip on fallback/error | pass |
| c3-retry | Visual4 C3 renderSpec.elements[]/c3-retry | `[data-preview-id=c3-retry]` | render S1, then inspect `[data-preview-id=c3-retry]` | stable element follows its visible/conditional contract | visible control | pass |
| c3-accept | Visual4 C3 renderSpec.elements[]/c3-accept | `[data-preview-id=c3-accept]` | render S1, then inspect `[data-preview-id=c3-accept]` | stable element follows its visible/conditional contract | fallback disabled | pass |
| c4-shell | Visual4 C4 renderSpec.elements[]/c4-shell | `[data-preview-id=c4-shell]` | render S2/S3, then inspect `[data-preview-id=c4-shell]` | stable element follows its visible/conditional contract | visible; invalid hides/returns | pass |
| c4-symbol | Visual4 C4 renderSpec.elements[]/c4-symbol | `[data-preview-id=c4-symbol]` | render S2/S3, then inspect `[data-preview-id=c4-symbol]` | stable element follows its visible/conditional contract | visible non-color symbol | pass |
| c4-cue | Visual4 C4 renderSpec.elements[]/c4-cue | `[data-preview-id=c4-cue]` | render S2/S3/catalog, then inspect `[data-preview-id=c4-cue]` | stable element follows its visible/conditional contract | visible/conditional | pass |
| c4-feedback | Visual4 C4 renderSpec.elements[]/c4-feedback | `[data-preview-id=c4-feedback]` | render terminal/catalog, then inspect `[data-preview-id=c4-feedback]` | stable element follows its visible/conditional contract | judgement/return copy | pass |
| c5-time | Visual4 C5 renderSpec.elements[]/c5-time | `[data-preview-id=c5-time]` | render S2/S3, then inspect `[data-preview-id=c5-time]` | stable element follows its visible/conditional contract | normal/frozen/error | pass |
| c5-cue | Visual4 C5 renderSpec.elements[]/c5-cue | `[data-preview-id=c5-cue]` | render S2/S3, then inspect `[data-preview-id=c5-cue]` | stable element follows its visible/conditional contract | visible/hidden no actor | pass |
| c5-segment | Visual4 C5 renderSpec.elements[]/c5-segment | `[data-preview-id=c5-segment]` | render S2/S3, then inspect `[data-preview-id=c5-segment]` | stable element follows its visible/conditional contract | segment/theme copy | pass |
| c5-input | Visual4 C5 renderSpec.elements[]/c5-input | `[data-preview-id=c5-input]` | render conditional, then inspect `[data-preview-id=c5-input]` | stable element follows its visible/conditional contract | hidden active; semantic on failure | pass |
| c6-title | Visual4 C6 renderSpec.elements[]/c6-title | `[data-preview-id=c6-title]` | render S4/S5/S7, then inspect `[data-preview-id=c6-title]` | stable element follows its visible/conditional contract | reason visible | pass |
| c6-resume | Visual4 C6 renderSpec.elements[]/c6-resume | `[data-preview-id=c6-resume]` | render S4/S7, then inspect `[data-preview-id=c6-resume]` | stable element follows its visible/conditional contract | fallback disabled | pass |
| c6-calibrate | Visual4 C6 renderSpec.elements[]/c6-calibrate | `[data-preview-id=c6-calibrate]` | render S4/S7, then inspect `[data-preview-id=c6-calibrate]` | stable element follows its visible/conditional contract | visible control | pass |
| c6-exit | Visual4 C6 renderSpec.elements[]/c6-exit | `[data-preview-id=c6-exit]` | render S4/S7, then inspect `[data-preview-id=c6-exit]` | stable element follows its visible/conditional contract | destructive label | pass |
| c6-cancel | Visual4 C6 renderSpec.elements[]/c6-cancel | `[data-preview-id=c6-cancel]` | render S5/catalog/Dialog, then inspect `[data-preview-id=c6-cancel]` | stable element follows its visible/conditional contract | cancel path | pass |
| c6-confirm | Visual4 C6 renderSpec.elements[]/c6-confirm | `[data-preview-id=c6-confirm]` | render S5/catalog/Dialog, then inspect `[data-preview-id=c6-confirm]` | stable element follows its visible/conditional contract | destructive confirm | pass |
| c7-accuracy | Visual4 C7 renderSpec.elements[]/c7-accuracy | `[data-preview-id=c7-accuracy]` | render S6, then inspect `[data-preview-id=c7-accuracy]` | stable element follows its visible/conditional contract | normal/incomplete | pass |
| c7-badge | Visual4 C7 renderSpec.elements[]/c7-badge | `[data-preview-id=c7-badge]` | render S6, then inspect `[data-preview-id=c7-badge]` | stable element follows its visible/conditional contract | diamond/triangle+label | pass |
| c7-normal | Visual4 C7 renderSpec.elements[]/c7-normal | `[data-preview-id=c7-normal]` | render S6, then inspect `[data-preview-id=c7-normal]` | stable element follows its visible/conditional contract | exact category | pass |
| c7-gold | Visual4 C7 renderSpec.elements[]/c7-gold | `[data-preview-id=c7-gold]` | render S6, then inspect `[data-preview-id=c7-gold]` | stable element follows its visible/conditional contract | exact category | pass |
| c7-gray | Visual4 C7 renderSpec.elements[]/c7-gray | `[data-preview-id=c7-gray]` | render S6, then inspect `[data-preview-id=c7-gray]` | stable element follows its visible/conditional contract | exact category | pass |
| c7-score | Visual4 C7 renderSpec.elements[]/c7-score | `[data-preview-id=c7-score]` | render S6, then inspect `[data-preview-id=c7-score]` | stable element follows its visible/conditional contract | normal/— | pass |
| c7-best | Visual4 C7 renderSpec.elements[]/c7-best | `[data-preview-id=c7-best]` | render S6, then inspect `[data-preview-id=c7-best]` | stable element follows its visible/conditional contract | best/暂无 | pass |
| c7-save | Visual4 C7 renderSpec.elements[]/c7-save | `[data-preview-id=c7-save]` | render S6, then inspect `[data-preview-id=c7-save]` | stable element follows its visible/conditional contract | semantic saved/error | pass |

### 8.3 Per-binding evidence

| source fact | stable selector | real trigger | expected | generation actual in preview5 | generation verdict |
|---|---|---|---|---|---|
| Visual4 C1 dataBindings[]/staticRules.* | `[data-binding-case="staticRules.*"][data-owning-selector]`, `owningTargets["staticRules.*"]`, `[data-binding-evidence^="staticRules.*:"]` | click `[data-test-binding="staticRules.*"]`; switch `#dataMode` normal→fallback→error; click again | Chinese/shapes→built-in/error | active value + C1 labels; owner state renders and concrete target receives `data-binding-evidence=staticRules.*:<mode>` plus visible item value | pass |
| Visual4 C2 dataBindings[]/postureChoice | `[data-binding-case="postureChoice"][data-owning-selector]`, `owningTargets["postureChoice"]`, `[data-binding-evidence^="postureChoice:"]`, `#scene [data-preview-id=c1-stand]` | click native stand/seated button; then use binding test across three modes | standing selection→selected visual; absence/conflict blocks start | S0 starts unselected; click sets `posture`, selected class/check, `canStart=true`; target also receives item/mode evidence | pass |
| Visual4 C2 dataBindings[]/actionSet.* | `[data-binding-case="actionSet.*"][data-owning-selector]`, `owningTargets["actionSet.*"]`, `[data-binding-evidence^="actionSet.*:"]`, `#scene [data-preview-id=c2-primary]` | choose posture then click native primary; separately test three modes | real start action→TR01 Dialog; fallback/error unavailable | click opens TR01 blocking Dialog only after selection; concrete target receives item/mode evidence | pass |
| Visual4 C2 dataBindings[]/canStart | `[data-binding-case="canStart"][data-owning-selector]`, `owningTargets["canStart"]`, `#scene [data-preview-id=c2-primary][aria-disabled]` | render S0 before/after posture selection; test fallback/error | default false with reason; selection true; fallback/error false | initial button disabled + “请先选择” reason; selection enables it; fallback/error disables it; item/mode evidence visible | pass |
| Visual4 C2 dataBindings[]/saveState(C2) | `[data-binding-case="saveState(C2)"][data-owning-selector]`, `owningTargets["saveState(C2)"]`, `[data-binding-evidence^="saveState(C2):"]` | click `[data-test-binding="saveState(C2)"]`; switch `#dataMode` normal→fallback→error; click again | saved→unknown/error | semantic chip/status copy; owner state renders and concrete target receives `data-binding-evidence=saveState(C2):<mode>` plus visible item value | pass |
| Visual4 C3 dataBindings[]/SafeArc.* | `[data-binding-case="SafeArc.*"][data-owning-selector]`, `owningTargets["SafeArc.*"]`, `[data-binding-evidence^="SafeArc.*:"]` | click `[data-test-binding="SafeArc.*"]`; switch `#dataMode` normal→fallback→error; click again | visible→hide/block | c3-arc hidden outside normal; owner state renders and concrete target receives `data-binding-evidence=SafeArc.*:<mode>` plus visible item value | pass |
| Visual4 C3 dataBindings[]/InteractionRibbon.* | `[data-binding-case="InteractionRibbon.*"][data-owning-selector]`, `owningTargets["InteractionRibbon.*"]`, `[data-binding-evidence^="InteractionRibbon.*:"]` | click `[data-test-binding="InteractionRibbon.*"]`; switch `#dataMode` normal→fallback→error; click again | visible→hide/block | c3-ribbon hidden outside normal; owner state renders and concrete target receives `data-binding-evidence=InteractionRibbon.*:<mode>` plus visible item value | pass |
| Visual4 C3 dataBindings[]/calibrationValidity | `[data-binding-case="calibrationValidity"][data-owning-selector]`, `owningTargets["calibrationValidity"]`, `[data-binding-evidence^="calibrationValidity:"]` | click `[data-test-binding="calibrationValidity"]`; switch `#dataMode` normal→fallback→error; click again | valid→retry/error | c3-status semantic + accept disabled; owner state renders and concrete target receives `data-binding-evidence=calibrationValidity:<mode>` plus visible item value | pass |
| Visual4 C3 dataBindings[]/postureChoice(C3) | `[data-binding-case="postureChoice(C3)"][data-owning-selector]`, `owningTargets["postureChoice(C3)"]`, `[data-binding-evidence^="postureChoice(C3):"]` | click `[data-test-binding="postureChoice(C3)"]`; switch `#dataMode` normal→fallback→error; click again | geometry→block | explicit active result; owner state renders and concrete target receives `data-binding-evidence=postureChoice(C3):<mode>` plus visible item value | pass |
| Visual4 C4 dataBindings[]/BubbleSeed.kind | `[data-binding-case="BubbleSeed.kind"][data-owning-selector]`, `owningTargets["BubbleSeed.kind"]`, `[data-binding-evidence^="BubbleSeed.kind:"]` | click `[data-test-binding="BubbleSeed.kind"]`; switch `#dataMode` normal→fallback→error; click again | kind→pool/error | c4-shell hidden + return feedback; owner state renders and concrete target receives `data-binding-evidence=BubbleSeed.kind:<mode>` plus visible item value | pass |
| Visual4 C4 dataBindings[]/BubbleSeed.pose | `[data-binding-case="BubbleSeed.pose"][data-owning-selector]`, `owningTargets["BubbleSeed.pose"]`, `[data-binding-evidence^="BubbleSeed.pose:"]` | click `[data-test-binding="BubbleSeed.pose"]`; switch `#dataMode` normal→fallback→error; click again | valid→out/pool | return feedback + hidden shell; owner state renders and concrete target receives `data-binding-evidence=BubbleSeed.pose:<mode>` plus visible item value | pass |
| Visual4 C4 dataBindings[]/InputArbiter.armed | `[data-binding-case="InputArbiter.armed"][data-owning-selector]`, `owningTargets["InputArbiter.armed"]`, `[data-binding-evidence^="InputArbiter.armed:"]` | click `[data-test-binding="InputArbiter.armed"]`; switch `#dataMode` normal→fallback→error; click again | armed→false/freeze | active result + input freeze; owner state renders and concrete target receives `data-binding-evidence=InputArbiter.armed:<mode>` plus visible item value | pass |
| Visual4 C4 dataBindings[]/Judgment.outcome | `[data-binding-case="Judgment.outcome"][data-owning-selector]`, `owningTargets["Judgment.outcome"]`, `[data-binding-evidence^="Judgment.outcome:"]` | click `[data-test-binding="Judgment.outcome"]`; switch `#dataMode` normal→fallback→error; click again | hit→passage/conflict | semantic feedback; owner state renders and concrete target receives `data-binding-evidence=Judgment.outcome:<mode>` plus visible item value | pass |
| Visual4 C5 dataBindings[]/SegmentClock.remaining | `[data-binding-case="SegmentClock.remaining"][data-owning-selector]`, `owningTargets["SegmentClock.remaining"]`, `[data-binding-evidence^="SegmentClock.remaining:"]` | click `[data-test-binding="SegmentClock.remaining"]`; switch `#dataMode` normal→fallback→error; click again | time→paused/error | item active value; owner state renders and concrete target receives `data-binding-evidence=SegmentClock.remaining:<mode>` plus visible item value | pass |
| Visual4 C5 dataBindings[]/SegmentClock.segment | `[data-binding-case="SegmentClock.segment"][data-owning-selector]`, `owningTargets["SegmentClock.segment"]`, `[data-binding-evidence^="SegmentClock.segment:"]` | click `[data-test-binding="SegmentClock.segment"]`; switch `#dataMode` normal→fallback→error; click again | T2→unknown/conflict | no-speed copy; owner state renders and concrete target receives `data-binding-evidence=SegmentClock.segment:<mode>` plus visible item value | pass |
| Visual4 C5 dataBindings[]/ThemeLayer.themeId | `[data-binding-case="ThemeLayer.themeId"][data-owning-selector]`, `owningTargets["ThemeLayer.themeId"]`, `[data-binding-evidence^="ThemeLayer.themeId:"]` | click `[data-test-binding="ThemeLayer.themeId"]`; switch `#dataMode` normal→fallback→error; click again | lake→morning/error | semantic chip + fallback CSS theme; owner state renders and concrete target receives `data-binding-evidence=ThemeLayer.themeId:<mode>` plus visible item value | pass |
| Visual4 C5 dataBindings[]/ThemeLayer.audioLayerId | `[data-binding-case="ThemeLayer.audioLayerId"][data-owning-selector]`, `owningTargets["ThemeLayer.audioLayerId"]`, `[data-binding-evidence^="ThemeLayer.audioLayerId:"]` | click `[data-test-binding="ThemeLayer.audioLayerId"]`; switch `#dataMode` normal→fallback→error; click again | bell→soft/unavailable | explicit continue-timing copy; owner state renders and concrete target receives `data-binding-evidence=ThemeLayer.audioLayerId:<mode>` plus visible item value | pass |
| Visual4 C5 dataBindings[]/currentCue | `[data-binding-case="currentCue"][data-owning-selector]`, `owningTargets["currentCue"]`, `[data-binding-evidence^="currentCue:"]` | click `[data-test-binding="currentCue"]`; switch `#dataMode` normal→fallback→error; click again | cue→hide/error | explicit active value; owner state renders and concrete target receives `data-binding-evidence=currentCue:<mode>` plus visible item value | pass |
| Visual4 C5 dataBindings[]/InputArbiter.state(C5) | `[data-binding-case="InputArbiter.state(C5)"][data-owning-selector]`, `owningTargets["InputArbiter.state(C5)"]`, `[data-binding-evidence^="InputArbiter.state(C5):"]` | click `[data-test-binding="InputArbiter.state(C5)"]`; switch `#dataMode` normal→fallback→error; click again | active→pause/unavailable | c5-input unhidden semantic chip; owner state renders and concrete target receives `data-binding-evidence=InputArbiter.state(C5):<mode>` plus visible item value | pass |
| Visual4 C6 dataBindings[]/FrozenSnapshot.valid | `[data-binding-case="FrozenSnapshot.valid"][data-owning-selector]`, `owningTargets["FrozenSnapshot.valid"]`, `[data-binding-evidence^="FrozenSnapshot.valid:"]` | click `[data-test-binding="FrozenSnapshot.valid"]`; switch `#dataMode` normal→fallback→error; click again | true→false/error | c6-resume disabled outside normal; owner state renders and concrete target receives `data-binding-evidence=FrozenSnapshot.valid:<mode>` plus visible item value | pass |
| Visual4 C6 dataBindings[]/InputArbiter.state(C6) | `[data-binding-case="InputArbiter.state(C6)"][data-owning-selector]`, `owningTargets["InputArbiter.state(C6)"]`, `[data-binding-evidence^="InputArbiter.state(C6):"]` | click `[data-test-binding="InputArbiter.state(C6)"]`; switch `#dataMode` normal→fallback→error; click again | manual→unavailable/conflict | item-specific semantic values; owner state renders and concrete target receives `data-binding-evidence=InputArbiter.state(C6):<mode>` plus visible item value | pass |
| Visual4 C6 dataBindings[]/exitIntent | `[data-binding-case="exitIntent"][data-owning-selector]`, `owningTargets["exitIntent"]`, `[data-binding-evidence^="exitIntent:"]` | click `[data-test-binding="exitIntent"]`; switch `#dataMode` normal→fallback→error; click again | closed→closed/error cancel | Dialog stable cancel; owner state renders and concrete target receives `data-binding-evidence=exitIntent:<mode>` plus visible item value | pass |
| Visual4 C7 dataBindings[]/RunLedger.accuracy | `[data-binding-case="RunLedger.accuracy"][data-owning-selector]`, `owningTargets["RunLedger.accuracy"]`, `[data-binding-evidence^="RunLedger.accuracy:"]` | click `[data-test-binding="RunLedger.accuracy"]`; switch `#dataMode` normal→fallback→error; click again | 92→incomplete/conflict | c7 accuracy fallback; owner state renders and concrete target receives `data-binding-evidence=RunLedger.accuracy:<mode>` plus visible item value | pass |
| Visual4 C7 dataBindings[]/RunLedger.badge | `[data-binding-case="RunLedger.badge"][data-owning-selector]`, `owningTargets["RunLedger.badge"]`, `[data-binding-evidence^="RunLedger.badge:"]` | click `[data-test-binding="RunLedger.badge"]`; switch `#dataMode` normal→fallback→error; click again | gold→complete/error | c7-badge shape+label; owner state renders and concrete target receives `data-binding-evidence=RunLedger.badge:<mode>` plus visible item value | pass |
| Visual4 C7 dataBindings[]/RunLedger.categories | `[data-binding-case="RunLedger.categories"][data-owning-selector]`, `owningTargets["RunLedger.categories"]`, `[data-binding-evidence^="RunLedger.categories:"]` | click `[data-test-binding="RunLedger.categories"]`; switch `#dataMode` normal→fallback→error; click again | counts→—/—/conflict | explicit active counts; scene value fallback; owner state renders and concrete target receives `data-binding-evidence=RunLedger.categories:<mode>` plus visible item value | pass |
| Visual4 C7 dataBindings[]/RunLedger.score | `[data-binding-case="RunLedger.score"][data-owning-selector]`, `owningTargets["RunLedger.score"]`, `[data-binding-evidence^="RunLedger.score:"]` | click `[data-test-binding="RunLedger.score"]`; switch `#dataMode` normal→fallback→error; click again | 2140→—/error | explicit active result; owner state renders and concrete target receives `data-binding-evidence=RunLedger.score:<mode>` plus visible item value | pass |
| Visual4 C7 dataBindings[]/bestScore | `[data-binding-case="bestScore"][data-owning-selector]`, `owningTargets["bestScore"]`, `[data-binding-evidence^="bestScore:"]` | click `[data-test-binding="bestScore"]`; switch `#dataMode` normal→fallback→error; click again | 2280→暂无/read error | c7-best human fallback; owner state renders and concrete target receives `data-binding-evidence=bestScore:<mode>` plus visible item value | pass |
| Visual4 C7 dataBindings[]/saveState(C7) | `[data-binding-case="saveState(C7)"][data-owning-selector]`, `owningTargets["saveState(C7)"]`, `[data-binding-evidence^="saveState(C7):"]` | click `[data-test-binding="saveState(C7)"]`; switch `#dataMode` normal→fallback→error; click again | saved→unknown/fail | c7-save semantic chip and retained copy; owner state renders and concrete target receives `data-binding-evidence=saveState(C7):<mode>` plus visible item value | pass |

### 8.4 Per-variant/state/precedence evidence

Common trigger: choose exact C/item in selectors then Apply. Common selector: `#componentDemo[data-component="C"][data-variant="v"][data-state="s"]`; precedence also requires `[data-precedence=applied]`. Each row below has an actual component-instance DOM mutation, not a catalog-only description.

| item | source fact | stable selector | real trigger | expected | generation actual in preview5 | generation verdict |
|---|---|---|---|---|---|---|
| C1.ready | Visual4 C1 variant/ready | `#scene [data-component-root="C1"][data-variant="ready"]`, `#componentDemo[data-component="C1"]` | choose C1 + variant ready; activate #applyComponent; inspect owning scene root, then its clone | start rule set | owning root mutates [data-variant="ready"] with real component children; `#componentDemo` contains its clone; C1 demo shows three-rule semantic copy | pass |
| C1.replay | Visual4 C1 variant/replay | `#scene [data-component-root="C1"][data-variant="replay"]`, `#componentDemo[data-component="C1"]` | choose C1 + variant replay; activate #applyComponent; inspect owning scene root, then its clone | retained posture | owning root mutates [data-variant="replay"] with real component children; `#componentDemo` contains its clone; visible replay variant id/copy | pass |
| C1.Constrained | Visual4 C1 variant/Constrained | `#scene [data-component-root="C1"][data-variant="Constrained"]`, `#componentDemo[data-component="C1"]` | choose C1 + variant Constrained; activate #applyComponent; inspect owning scene root, then its clone | single-column meaning | owning root mutates [data-variant="Constrained"] with real component children; `#componentDemo` contains its clone; visible Constrained variant + tier demo | pass |
| C1.default | Visual4 C1 state/default | `#scene [data-component-root="C1"][data-state="default"]`, `#componentDemo[data-component="C1"]` | choose C1 + state default; activate #applyComponent; inspect owning scene root, then its clone | semantic strokes | owning root mutates [data-state="default"] with real component children; `#componentDemo` contains its clone; C1 normal demo | pass |
| C1.focused | Visual4 C1 state/focused | `#scene [data-component-root="C1"][data-state="focused"]`, `#componentDemo[data-component="C1"]` | choose C1 + state focused; activate #applyComponent; inspect owning scene root, then its clone | white focus | owning root mutates [data-state="focused"] with real component children; `#componentDemo` contains its clone; focused CSS outline | pass |
| C1.selected | Visual4 C1 state/selected | `#scene [data-component-root="C1"][data-state="selected"]`, `#componentDemo[data-component="C1"]` | choose C1 + state selected; activate #applyComponent; inspect owning scene root, then its clone | check/selected | owning root mutates [data-state="selected"] with real component children; `#componentDemo` contains its clone; visible ✓ 已选择 | pass |
| C1.disabled | Visual4 C1 state/disabled | `#scene [data-component-root="C1"][data-state="disabled"]`, `#componentDemo[data-component="C1"]` | choose C1 + state disabled; activate #applyComponent; inspect owning scene root, then its clone | dim/reason | owning root mutates [data-state="disabled"] with real component children; `#componentDemo` contains its clone; disabled opacity+disabled button | pass |
| C1.overflow | Visual4 C1 state/overflow | `#scene [data-component-root="C1"][data-state="overflow"]`, `#componentDemo[data-component="C1"]` | choose C1 + state overflow; activate #applyComponent; inspect owning scene root, then its clone | scroll | owning root mutates [data-state="overflow"] with real component children; `#componentDemo` contains its clone; constrained demo scroll class | pass |
| C1.precedence | Visual4 C1 precedence/rule | `#scene [data-component-root="C1"][data-precedence="applied"][data-precedence-winner]`, `#componentDemo[data-component="C1"]` | choose C1 + precedence apply; activate #applyComponent; inspect owning scene root, then its clone | disabled wins/focus preserved | owning root mutates [data-precedence="applied"][data-precedence-winner] with real component children; `#componentDemo` contains its clone; precedence attribute+double outline+winning state | pass |
| C2.start | Visual4 C2 variant/start | `#scene [data-component-root="C2"][data-variant="start"]`, `#componentDemo[data-component="C2"]` | choose C2 + variant start; activate #applyComponent; inspect owning scene root, then its clone | start CTA | owning root mutates [data-variant="start"] with real component children; `#componentDemo` contains its clone; C2 start variant visible | pass |
| C2.result | Visual4 C2 variant/result | `#scene [data-component-root="C2"][data-variant="result"]`, `#componentDemo[data-component="C2"]` | choose C2 + variant result; activate #applyComponent; inspect owning scene root, then its clone | replay/home | owning root mutates [data-variant="result"] with real component children; `#componentDemo` contains its clone; result id+component action content | pass |
| C2.saveError | Visual4 C2 variant/saveError | `#scene [data-component-root="C2"][data-variant="saveError"]`, `#componentDemo[data-component="C2"]` | choose C2 + variant saveError; activate #applyComponent; inspect owning scene root, then its clone | retry/error | owning root mutates [data-variant="saveError"] with real component children; `#componentDemo` contains its clone; error semantic component | pass |
| C2.exitConfirm | Visual4 C2 variant/exitConfirm | `#scene [data-component-root="C2"][data-variant="exitConfirm"]`, `#componentDemo[data-component="C2"]` | choose C2 + variant exitConfirm; activate #applyComponent; inspect owning scene root, then its clone | cancel/exit | owning root mutates [data-variant="exitConfirm"] with real component children; `#componentDemo` contains its clone; exitConfirm id+danger semantics | pass |
| C2.default | Visual4 C2 state/default | `#scene [data-component-root="C2"][data-state="default"]`, `#componentDemo[data-component="C2"]` | choose C2 + state default; activate #applyComponent; inspect owning scene root, then its clone | brand action | owning root mutates [data-state="default"] with real component children; `#componentDemo` contains its clone; normal action demo | pass |
| C2.focused | Visual4 C2 state/focused | `#scene [data-component-root="C2"][data-state="focused"]`, `#componentDemo[data-component="C2"]` | choose C2 + state focused; activate #applyComponent; inspect owning scene root, then its clone | ring | owning root mutates [data-state="focused"] with real component children; `#componentDemo` contains its clone; focus outline | pass |
| C2.pressed | Visual4 C2 state/pressed | `#scene [data-component-root="C2"][data-state="pressed"]`, `#componentDemo[data-component="C2"]` | choose C2 + state pressed; activate #applyComponent; inspect owning scene root, then its clone | press scale | owning root mutates [data-state="pressed"] with real component children; `#componentDemo` contains its clone; transform .98 | pass |
| C2.disabled | Visual4 C2 state/disabled | `#scene [data-component-root="C2"][data-state="disabled"]`, `#componentDemo[data-component="C2"]` | choose C2 + state disabled; activate #applyComponent; inspect owning scene root, then its clone | lock/reason | owning root mutates [data-state="disabled"] with real component children; `#componentDemo` contains its clone; disabled button+opacity | pass |
| C2.error | Visual4 C2 state/error | `#scene [data-component-root="C2"][data-state="error"]`, `#componentDemo[data-component="C2"]` | choose C2 + state error; activate #applyComponent; inspect owning scene root, then its clone | triangle/retry | owning root mutates [data-state="error"] with real component children; `#componentDemo` contains its clone; error border+copy | pass |
| C2.precedence | Visual4 C2 precedence/rule | `#scene [data-component-root="C2"][data-precedence="applied"][data-precedence-winner]`, `#componentDemo[data-component="C2"]` | choose C2 + precedence apply; activate #applyComponent; inspect owning scene root, then its clone | disabled/error wins | owning root mutates [data-precedence="applied"][data-precedence-winner] with real component children; `#componentDemo` contains its clone; applied attribute+winner visual | pass |
| C3.standing | Visual4 C3 variant/standing | `#scene [data-component-root="C3"][data-variant="standing"]`, `#componentDemo[data-component="C3"]` | choose C3 + variant standing; activate #applyComponent; inspect owning scene root, then its clone | standing geometry | owning root mutates [data-variant="standing"] with real component children; `#componentDemo` contains its clone; standing variant visible | pass |
| C3.seated | Visual4 C3 variant/seated | `#scene [data-component-root="C3"][data-variant="seated"]`, `#componentDemo[data-component="C3"]` | choose C3 + variant seated; activate #applyComponent; inspect owning scene root, then its clone | seated geometry | owning root mutates [data-variant="seated"] with real component children; `#componentDemo` contains its clone; seated variant visible | pass |
| C3.recalibration | Visual4 C3 variant/recalibration | `#scene [data-component-root="C3"][data-variant="recalibration"]`, `#componentDemo[data-component="C3"]` | choose C3 + variant recalibration; activate #applyComponent; inspect owning scene root, then its clone | frozen-run copy | owning root mutates [data-variant="recalibration"] with real component children; `#componentDemo` contains its clone; recalibration variant visible | pass |
| C3.loading | Visual4 C3 state/loading | `#scene [data-component-root="C3"][data-state="loading"]`, `#componentDemo[data-component="C3"]` | choose C3 + state loading; activate #applyComponent; inspect owning scene root, then its clone | locating/dashed | owning root mutates [data-state="loading"] with real component children; `#componentDemo` contains its clone; dashed demo+正在定位 | pass |
| C3.valid | Visual4 C3 state/valid | `#scene [data-component-root="C3"][data-state="valid"]`, `#componentDemo[data-component="C3"]` | choose C3 + state valid; activate #applyComponent; inspect owning scene root, then its clone | positive/continue | owning root mutates [data-state="valid"] with real component children; `#componentDemo` contains its clone; position comfortable semantic | pass |
| C3.invalid | Visual4 C3 state/invalid | `#scene [data-component-root="C3"][data-state="invalid"]`, `#componentDemo[data-component="C3"]` | choose C3 + state invalid; activate #applyComponent; inspect owning scene root, then its clone | caution/retry | owning root mutates [data-state="invalid"] with real component children; `#componentDemo` contains its clone; invalid border+copy | pass |
| C3.focused | Visual4 C3 state/focused | `#scene [data-component-root="C3"][data-state="focused"]`, `#componentDemo[data-component="C3"]` | choose C3 + state focused; activate #applyComponent; inspect owning scene root, then its clone | ring | owning root mutates [data-state="focused"] with real component children; `#componentDemo` contains its clone; focus outline | pass |
| C3.error | Visual4 C3 state/error | `#scene [data-component-root="C3"][data-state="error"]`, `#componentDemo[data-component="C3"]` | choose C3 + state error; activate #applyComponent; inspect owning scene root, then its clone | opaque safe exit | owning root mutates [data-state="error"] with real component children; `#componentDemo` contains its clone; error border/recovery copy | pass |
| C3.precedence | Visual4 C3 precedence/rule | `#scene [data-component-root="C3"][data-precedence="applied"][data-precedence-winner]`, `#componentDemo[data-component="C3"]` | choose C3 + precedence apply; activate #applyComponent; inspect owning scene root, then its clone | error>invalid>loading | owning root mutates [data-precedence="applied"][data-precedence-winner] with real component children; `#componentDemo` contains its clone; applied+selected winner | pass |
| C4.normal | Visual4 C4 variant/normal | `#scene [data-component-root="C4"][data-variant="normal"]`, `#componentDemo[data-component="C4"]` | choose C4 + variant normal; activate #applyComponent; inspect owning scene root, then its clone | circle/crack | owning root mutates [data-variant="normal"] with real component children; `#componentDemo` contains its clone; circle semantic label | pass |
| C4.gold | Visual4 C4 variant/gold | `#scene [data-component-root="C4"][data-variant="gold"]`, `#componentDemo[data-component="C4"]` | choose C4 + variant gold; activate #applyComponent; inspect owning scene root, then its clone | ring/handle | owning root mutates [data-variant="gold"] with real component children; `#componentDemo` contains its clone; diamond gold semantic | pass |
| C4.gray | Visual4 C4 variant/gray | `#scene [data-component-root="C4"][data-variant="gray"]`, `#componentDemo[data-component="C4"]` | choose C4 + variant gray; activate #applyComponent; inspect owning scene root, then its clone | hex/bar | owning root mutates [data-variant="gray"] with real component children; `#componentDemo` contains its clone; gray no-touch semantic | pass |
| C4.tutorial | Visual4 C4 variant/tutorial | `#scene [data-component-root="C4"][data-variant="tutorial"]`, `#componentDemo[data-component="C4"]` | choose C4 + variant tutorial; activate #applyComponent; inspect owning scene root, then its clone | larger/coach | owning root mutates [data-variant="tutorial"] with real component children; `#componentDemo` contains its clone; tutorial variant visible | pass |
| C4.reduceMotion | Visual4 C4 variant/reduceMotion | `#scene [data-component-root="C4"][data-variant="reduceMotion"]`, `#componentDemo[data-component="C4"]` | choose C4 + variant reduceMotion; activate #applyComponent; inspect owning scene root, then its clone | no bob | owning root mutates [data-variant="reduceMotion"] with real component children; `#componentDemo` contains its clone; variant visible + RM assertion | pass |
| C4.pooled | Visual4 C4 state/pooled | `#scene [data-component-root="C4"][data-state="pooled"]`, `#componentDemo[data-component="C4"]` | choose C4 + state pooled; activate #applyComponent; inspect owning scene root, then its clone | hidden | owning root mutates [data-state="pooled"] with real component children; `#componentDemo` contains its clone; visibility hidden | pass |
| C4.drifting | Visual4 C4 state/drifting | `#scene [data-component-root="C4"][data-state="drifting"]`, `#componentDemo[data-component="C4"]` | choose C4 + state drifting; activate #applyComponent; inspect owning scene root, then its clone | visible drift | owning root mutates [data-state="drifting"] with real component children; `#componentDemo` contains its clone; drifting state label/component visible | pass |
| C4.graceFrozen | Visual4 C4 state/graceFrozen | `#scene [data-component-root="C4"][data-state="graceFrozen"]`, `#componentDemo[data-component="C4"]` | choose C4 + state graceFrozen; activate #applyComponent; inspect owning scene root, then its clone | dashed/frozen | owning root mutates [data-state="graceFrozen"] with real component children; `#componentDemo` contains its clone; dashed+desaturated+freeze copy | pass |
| C4.judgedSuccess | Visual4 C4 state/judgedSuccess | `#scene [data-component-root="C4"][data-state="judgedSuccess"]`, `#componentDemo[data-component="C4"]` | choose C4 + state judgedSuccess; activate #applyComponent; inspect owning scene root, then its clone | positive | owning root mutates [data-state="judgedSuccess"] with real component children; `#componentDemo` contains its clone; green border/glow+success | pass |
| C4.judgedError | Visual4 C4 state/judgedError | `#scene [data-component-root="C4"][data-state="judgedError"]`, `#componentDemo[data-component="C4"]` | choose C4 + state judgedError; activate #applyComponent; inspect owning scene root, then its clone | caution/no flash | owning root mutates [data-state="judgedError"] with real component children; `#componentDemo` contains its clone; error border+human copy | pass |
| C4.outOfBounds | Visual4 C4 state/outOfBounds | `#scene [data-component-root="C4"][data-state="outOfBounds"]`, `#componentDemo[data-component="C4"]` | choose C4 + state outOfBounds; activate #applyComponent; inspect owning scene root, then its clone | hidden/pool | owning root mutates [data-state="outOfBounds"] with real component children; `#componentDemo` contains its clone; visibility hidden | pass |
| C4.precedence | Visual4 C4 precedence/rule | `#scene [data-component-root="C4"][data-precedence="applied"][data-precedence-winner]`, `#componentDemo[data-component="C4"]` | choose C4 + precedence apply; activate #applyComponent; inspect owning scene root, then its clone | judgedError terminal wins over graceFrozen | owning root mutates [data-precedence="applied"][data-precedence-winner] with real component children; `#componentDemo` contains its clone; applied + judgedError winner + irreversible-terminal explanation | pass |
| C5.tutorial | Visual4 C5 variant/tutorial | `#scene [data-component-root="C5"][data-variant="tutorial"]`, `#componentDemo[data-component="C5"]` | choose C5 + variant tutorial; activate #applyComponent; inspect owning scene root, then its clone | step 1/3 | owning root mutates [data-variant="tutorial"] with real component children; `#componentDemo` contains its clone; tutorial variant visible | pass |
| C5.run | Visual4 C5 variant/run | `#scene [data-component-root="C5"][data-variant="run"]`, `#componentDemo[data-component="C5"]` | choose C5 + variant run; activate #applyComponent; inspect owning scene root, then its clone | time/cue/segment | owning root mutates [data-variant="run"] with real component children; `#componentDemo` contains its clone; run component copy | pass |
| C5.paused | Visual4 C5 variant/paused | `#scene [data-component-root="C5"][data-variant="paused"]`, `#componentDemo[data-component="C5"]` | choose C5 + variant paused; activate #applyComponent; inspect owning scene root, then its clone | frozen time | owning root mutates [data-variant="paused"] with real component children; `#componentDemo` contains its clone; paused variant/state copy | pass |
| C5.reduceMotion | Visual4 C5 variant/reduceMotion | `#scene [data-component-root="C5"][data-variant="reduceMotion"]`, `#componentDemo[data-component="C5"]` | choose C5 + variant reduceMotion; activate #applyComponent; inspect owning scene root, then its clone | static theme | owning root mutates [data-variant="reduceMotion"] with real component children; `#componentDemo` contains its clone; variant+RM semantic assertion | pass |
| C5.active | Visual4 C5 state/active | `#scene [data-component-root="C5"][data-state="active"]`, `#componentDemo[data-component="C5"]` | choose C5 + state active; activate #applyComponent; inspect owning scene root, then its clone | time/cue | owning root mutates [data-state="active"] with real component children; `#componentDemo` contains its clone; active component | pass |
| C5.boundary | Visual4 C5 state/boundary | `#scene [data-component-root="C5"][data-state="boundary"]`, `#componentDemo[data-component="C5"]` | choose C5 + state boundary; activate #applyComponent; inspect owning scene root, then its clone | theme no speed | owning root mutates [data-state="boundary"] with real component children; `#componentDemo` contains its clone; boundary copy | pass |
| C5.pausedState | Visual4 C5 state/pausedState | `#scene [data-component-root="C5"][data-state="paused"]`, `#componentDemo[data-component="C5"]` | choose C5 + state paused; activate #applyComponent; inspect owning scene root, then its clone | pause label | owning root mutates [data-state="paused"] with real component children; `#componentDemo` contains its clone; paused state visible | pass |
| C5.partial | Visual4 C5 state/partial | `#scene [data-component-root="C5"][data-state="partial"]`, `#componentDemo[data-component="C5"]` | choose C5 + state partial; activate #applyComponent; inspect owning scene root, then its clone | time-only/caution | owning root mutates [data-state="partial"] with real component children; `#componentDemo` contains its clone; partial warning | pass |
| C5.error | Visual4 C5 state/error | `#scene [data-component-root="C5"][data-state="error"]`, `#componentDemo[data-component="C5"]` | choose C5 + state error; activate #applyComponent; inspect owning scene root, then its clone | timing error | owning root mutates [data-state="error"] with real component children; `#componentDemo` contains its clone; error border/recovery copy | pass |
| C5.precedence | Visual4 C5 precedence/rule | `#scene [data-component-root="C5"][data-precedence="applied"][data-precedence-winner]`, `#componentDemo[data-component="C5"]` | choose C5 + precedence apply; activate #applyComponent; inspect owning scene root, then its clone | error>paused>partial | owning root mutates [data-precedence="applied"][data-precedence-winner] with real component children; `#componentDemo` contains its clone; applied+winner visible | pass |
| C6.manualPause | Visual4 C6 variant/manualPause | `#scene [data-component-root="C6"][data-variant="manualPause"]`, `#componentDemo[data-component="C6"]` | choose C6 + variant manualPause; activate #applyComponent; inspect owning scene root, then its clone | 3 actions | owning root mutates [data-variant="manualPause"] with real component children; `#componentDemo` contains its clone; pause component content | pass |
| C6.trackingPause | Visual4 C6 variant/trackingPause | `#scene [data-component-root="C6"][data-variant="trackingPause"]`, `#componentDemo[data-component="C6"]` | choose C6 + variant trackingPause; activate #applyComponent; inspect owning scene root, then its clone | tracking reason | owning root mutates [data-variant="trackingPause"] with real component children; `#componentDemo` contains its clone; variant id+reason | pass |
| C6.inputUnavailable | Visual4 C6 variant/inputUnavailable | `#scene [data-component-root="C6"][data-variant="inputUnavailable"]`, `#componentDemo[data-component="C6"]` | choose C6 + variant inputUnavailable; activate #applyComponent; inspect owning scene root, then its clone | safe exit | owning root mutates [data-variant="inputUnavailable"] with real component children; `#componentDemo` contains its clone; unavailable semantic | pass |
| C6.exitConfirm | Visual4 C6 variant/exitConfirm | `#scene [data-component-root="C6"][data-variant="exitConfirm"]`, `#componentDemo[data-component="C6"]` | choose C6 + variant exitConfirm; activate #applyComponent; inspect owning scene root, then its clone | cancel/exit | owning root mutates [data-variant="exitConfirm"] with real component children; `#componentDemo` contains its clone; component shows specific pair | pass |
| C6.visible | Visual4 C6 state/visible | `#scene [data-component-root="C6"][data-state="visible"]`, `#componentDemo[data-component="C6"]` | choose C6 + state visible; activate #applyComponent; inspect owning scene root, then its clone | opaque panel | owning root mutates [data-state="visible"] with real component children; `#componentDemo` contains its clone; normal demo panel | pass |
| C6.focused | Visual4 C6 state/focused | `#scene [data-component-root="C6"][data-state="focused"]`, `#componentDemo[data-component="C6"]` | choose C6 + state focused; activate #applyComponent; inspect owning scene root, then its clone | ring | owning root mutates [data-state="focused"] with real component children; `#componentDemo` contains its clone; focus outline | pass |
| C6.disabled | Visual4 C6 state/disabled | `#scene [data-component-root="C6"][data-state="disabled"]`, `#componentDemo[data-component="C6"]` | choose C6 + state disabled; activate #applyComponent; inspect owning scene root, then its clone | no resume/reason | owning root mutates [data-state="disabled"] with real component children; `#componentDemo` contains its clone; disabled action | pass |
| C6.confirm | Visual4 C6 state/confirm | `#scene [data-component-root="C6"][data-state="confirm"]`, `#componentDemo[data-component="C6"]` | choose C6 + state confirm; activate #applyComponent; inspect owning scene root, then its clone | cancel default | owning root mutates [data-state="confirm"] with real component children; `#componentDemo` contains its clone; confirm text+Dialog cancel focus | pass |
| C6.error | Visual4 C6 state/error | `#scene [data-component-root="C6"][data-state="error"]`, `#componentDemo[data-component="C6"]` | choose C6 + state error; activate #applyComponent; inspect owning scene root, then its clone | safe exit only | owning root mutates [data-state="error"] with real component children; `#componentDemo` contains its clone; error semantic/recovery | pass |
| C6.precedence | Visual4 C6 precedence/rule | `#scene [data-component-root="C6"][data-precedence="applied"][data-precedence-winner]`, `#componentDemo[data-component="C6"]` | choose C6 + precedence apply; activate #applyComponent; inspect owning scene root, then its clone | error>confirm>disabled | owning root mutates [data-precedence="applied"][data-precedence-winner] with real component children; `#componentDemo` contains its clone; applied+winner visible | pass |
| C7.complete | Visual4 C7 variant/complete | `#scene [data-component-root="C7"][data-variant="complete"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant complete; activate #applyComponent; inspect owning scene root, then its clone | full metrics | owning root mutates [data-variant="complete"] with real component children; `#componentDemo` contains its clone; result semantic copy | pass |
| C7.noBadge | Visual4 C7 variant/noBadge | `#scene [data-component-root="C7"][data-variant="noBadge"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant noBadge; activate #applyComponent; inspect owning scene root, then its clone | 完成 | owning root mutates [data-variant="noBadge"] with real component children; `#componentDemo` contains its clone; noBadge variant id+copy | pass |
| C7.bronze | Visual4 C7 variant/bronze | `#scene [data-component-root="C7"][data-variant="bronze"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant bronze; activate #applyComponent; inspect owning scene root, then its clone | 铜 | owning root mutates [data-variant="bronze"] with real component children; `#componentDemo` contains its clone; bronze variant visible | pass |
| C7.silver | Visual4 C7 variant/silver | `#scene [data-component-root="C7"][data-variant="silver"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant silver; activate #applyComponent; inspect owning scene root, then its clone | 银 | owning root mutates [data-variant="silver"] with real component children; `#componentDemo` contains its clone; silver variant visible | pass |
| C7.gold | Visual4 C7 variant/gold | `#scene [data-component-root="C7"][data-variant="gold"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant gold; activate #applyComponent; inspect owning scene root, then its clone | 金 | owning root mutates [data-variant="gold"] with real component children; `#componentDemo` contains its clone; gold diamond semantic | pass |
| C7.newBest | Visual4 C7 variant/newBest | `#scene [data-component-root="C7"][data-variant="newBest"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant newBest; activate #applyComponent; inspect owning scene root, then its clone | 新纪录 | owning root mutates [data-variant="newBest"] with real component children; `#componentDemo` contains its clone; green glow+diamond copy | pass |
| C7.saveError | Visual4 C7 variant/saveError | `#scene [data-component-root="C7"][data-variant="saveError"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant saveError; activate #applyComponent; inspect owning scene root, then its clone | retry/retained | owning root mutates [data-variant="saveError"] with real component children; `#componentDemo` contains its clone; save error human copy | pass |
| C7.partial | Visual4 C7 variant/partial | `#scene [data-component-root="C7"][data-variant="partial"]`, `#componentDemo[data-component="C7"]` | choose C7 + variant partial; activate #applyComponent; inspect owning scene root, then its clone | no eligibility | owning root mutates [data-variant="partial"] with real component children; `#componentDemo` contains its clone; incomplete semantic copy | pass |
| C7.loading | Visual4 C7 state/loading | `#scene [data-component-root="C7"][data-state="loading"]`, `#componentDemo[data-component="C7"]` | choose C7 + state loading; activate #applyComponent; inspect owning scene root, then its clone | skeleton/统计中 | owning root mutates [data-state="loading"] with real component children; `#componentDemo` contains its clone; dashed/loading copy | pass |
| C7.completeState | Visual4 C7 state/completeState | `#scene [data-component-root="C7"][data-state="complete"]`, `#componentDemo[data-component="C7"]` | choose C7 + state complete; activate #applyComponent; inspect owning scene root, then its clone | metrics | owning root mutates [data-state="complete"] with real component children; `#componentDemo` contains its clone; complete state visible | pass |
| C7.newBestState | Visual4 C7 state/newBestState | `#scene [data-component-root="C7"][data-state="newBest"]`, `#componentDemo[data-component="C7"]` | choose C7 + state newBest; activate #applyComponent; inspect owning scene root, then its clone | new record | owning root mutates [data-state="newBest"] with real component children; `#componentDemo` contains its clone; glow+copy | pass |
| C7.empty | Visual4 C7 state/empty | `#scene [data-component-root="C7"][data-state="empty"]`, `#componentDemo[data-component="C7"]` | choose C7 + state empty; activate #applyComponent; inspect owning scene root, then its clone | 暂无最高分 | owning root mutates [data-state="empty"] with real component children; `#componentDemo` contains its clone; empty human fallback | pass |
| C7.partialState | Visual4 C7 state/partialState | `#scene [data-component-root="C7"][data-state="partial"]`, `#componentDemo[data-component="C7"]` | choose C7 + state partial; activate #applyComponent; inspect owning scene root, then its clone | no badge/save | owning root mutates [data-state="partial"] with real component children; `#componentDemo` contains its clone; partial warning | pass |
| C7.error | Visual4 C7 state/error | `#scene [data-component-root="C7"][data-state="error"]`, `#componentDemo[data-component="C7"]` | choose C7 + state error; activate #applyComponent; inspect owning scene root, then its clone | save retry | owning root mutates [data-state="error"] with real component children; `#componentDemo` contains its clone; error border+retained copy | pass |
| C7.overflow | Visual4 C7 state/overflow | `#scene [data-component-root="C7"][data-state="overflow"]`, `#componentDemo[data-component="C7"]` | choose C7 + state overflow; activate #applyComponent; inspect owning scene root, then its clone | single-column scroll | owning root mutates [data-state="overflow"] with real component children; `#componentDemo` contains its clone; overflow scroll behavior | pass |
| C7.precedence | Visual4 C7 precedence/rule | `#scene [data-component-root="C7"][data-precedence="applied"][data-precedence-winner]`, `#componentDemo[data-component="C7"]` | choose C7 + precedence apply; activate #applyComponent; inspect owning scene root, then its clone | partial>error>newBest | owning root mutates [data-precedence="applied"][data-precedence-winner] with real component children; `#componentDemo` contains its clone; applied+winner visible | pass |

### 8.5 Responsive / motion evidence

| item | source fact | stable selector | real trigger | expected | generation actual in preview5 | generation verdict |
|---|---|---|---|---|---|---|
| Large | Interaction6 §9 responsive/Large | `#tier, [data-responsive], #tierAssertion` | select tier=large | 1440×840/3 columns/≥56 | CSS exact width/min-height + `#tierAssertion` | pass |
| Compact | Interaction6 §9 responsive/Compact | `#tier, [data-responsive], #tierAssertion` | select tier=compact | 1120×720/3 columns/≥56 | CSS exact width/min-height + assertion | pass |
| Constrained | Interaction6 §9 responsive/Constrained | `#tier, [data-responsive], #tierAssertion, .space-scene>[data-component-root=C3] .actions` | select tier=constrained; render S1 | 720×620/single/stack/fixed-bottom CTA/≥56 | structural CSS includes nested S1 calibration CTA with sticky bottom + exact assertion | pass |
| Reduce Motion | Interaction6 §13 Reduce Motion | `#reduceMotion, .bubble.motion-sample, [data-reduce-motion], #motionAssertion` | render S3; observe gentle bob; toggle checkbox | moving baseline stops; label/shape/judgment semantics remain | `gentleBob` moves margin 0→-12px; `.reduced .motion-sample` sets animation none/margin0 without replacing component content | pass |

Preview5 generation actual/verdict is explicitly populated for every row above. Stage14 rerun-4 remains independent: its reviewer must execute the selectors and triggers, rebuild the denominator from Interaction6/Visual4, and record a separate actual/verdict in the critique rather than copying this report.




