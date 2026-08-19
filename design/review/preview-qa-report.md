# Preview / QA Test Report · BubbleReflexLab

> Active revision: 6 | Preview rev6 | Sources: interaction rev9, visual rev4, design-system review rev7 | scope=`web_design_validation_only` | CR-04..08

## 0. Reasoning Guidance

Preview 只验证设计事实的可触发映射；设备/舒适/真实性能不在范围。生成侧不填写独立 QA actual/verdict。

## 1. Direct Description of Outputs

本报告先声明 denominator，再映射到稳定选择器。独立 reviewer 必须重读 HTML 并重建 denominator。

## 2. Test Scope and Verdict

### 2.0 Reviewer Invocation Evidence

| reviewerRole | invocationId | contextPolicy | reviewedRevision | evidenceRebuilt | recommendation |
|---|---|---|---|---|---|
| initial | dd39c3a6-a6d9-42b1-a83a-6c7c4af0f102 | isolated_subagent | preview=1;previewQA=1;interaction=9;visual=4 | yes | block |
| rerun | 5f9d188c-bae5-42c0-8b54-c68fdec00325 | isolated_subagent | preview=2;previewQA=2;interaction=9;visual=4 | yes | block |
| final pass | 41b5fe16-c3d1-4c2b-9b10-3a7943806737 | isolated_subagent | preview=6;previewQA=6;interaction=9;visual=4 | yes | pass |

### 2.1 Input Readiness Table

| Fact | Evidence | Verdict |
|---|---|---|
| Design-system review | Critique rev7, invocation 7f6232dd, pass | pass |
| States/transitions | Interaction §10 S0–S5,D1; TR1–TR15 | pass |
| Core components | Visual §5.3 seven eight-segment blocks | pass |
| Elements/bindings | Visual §5.3 stable ids and explicit paths | pass |
| Variants/states | Visual §5.3 per component tables | pass |
| Responsive/motion | Interaction §9/§13 | pass |
| Visual grammar | Visual §3–§4 | pass |

### 2.2 Preview Coverage Manifest

#### 2.2.1 State / transition denominator

| Fact | Source | Trigger | Target/observable | Confirm |
|---|---|---|---|---|
| S0_START | IS §10 | state select/launch | start/calibration/rules | no |
| S1_CALIBRATE | IS §10 | TR1 | calibration view | no |
| S2_TUTORIAL | IS §10 | TR2 | tutorial prompt+bubbles | explicit Stage entry |
| S3_GAME | IS §10 | TR3 | game HUD+bubbles | no |
| S4_PAUSED | IS §10 | pause/select | freeze proof | no |
| D1_END_CONFIRM | IS §10 | back from play/result | blocking dialog | yes |
| S5_RESULTS | IS §10 | TR8/confirm | stats/badge/best | no |
| TR1 | IS §10 | advance S0 | S1 | no |
| TR2 | IS §10 | advance S1 | S2 | explicit |
| TR3 | IS §10 | advance S2 | S3 | no |
| TR4 | IS §10 | select S4 | frozen | no |
| TR5 | IS §10 | advance S4 | S3 | no |
| TR6 | IS §10 | Back/high-risk | D1 | yes |
| TR7 | IS §10 | advance D1 | S5 | yes |
| TR8 | IS §10 | advance S3 | S5 | no |
| TR9 | IS §10 | advance S5 | S1 | no |
| TR10 | IS §10 | result return (element) | stable exit copy | no |
| TR11 | IS §10 | error+retry selector | save retry visible | no |
| TR12 | IS §10 | pause recalibrate element | S1 documented | no |
| TR13 | IS §10 | advance/reselect S4 | resume origin | no |
| TR14 | IS §10 | EndRun variant exitStage | D1 copy changes | yes |
| TR15 | IS §10 | confirm | exit copy | yes |

#### 2.2.2 renderSpec.elements[] denominator

Each row is an individual source element and unique selector.

| Component | id | label | bind | hide |
|---|---|---|---|---|
| CalibrationHalo | cal-status | 互动区可用 | calibration.status | no |
| CalibrationHalo | cal-fan | 安全扇形 | calibration.envelope | no |
| CalibrationHalo | cal-retry | 重新校准 | action.recalibrate | no |
| CalibrationHalo | cal-enter | 进入练习 | action.enterStage | no |
| BubbleActor | bubble-mesh | 泡泡 | bubble.kind | no |
| BubbleActor | bubble-glyph | 圆/冠环/孔 | bubble.kind | no |
| BubbleActor | bubble-label | 教程提示 | tutorial.prompt | outside tutorial |
| BubbleActor | bubble-hit-zone | 拍击区 | action.hit | visually hidden collider |
| BubbleActor | bubble-grab-zone | 抓取区 | action.grab | visually hidden collider |
| BubbleActor | bubble-feedback | 正确/留意 | bubble.terminal | before terminal |
| InteractionGate | gate-rim | 互动区 | gate.pose | no |
| InteractionGate | gate-progress | 接近 | bubble.timeToGate | fallback hides |
| InteractionGate | gate-status | 已冻结/待校准 | gate.calibrationStatus | no |
| GameHUD | hud-time | 02:30 | clock.remaining | no |
| GameHUD | hud-tier | 第1档 | tier.label | no |
| GameHUD | hud-theme | 薄荷晨光 | theme.index | no |
| GameHUD | hud-prompt | 教学提示 | tutorial.prompt | game conditional |
| GameHUD | hud-input | 输入恢复中 | input.state | valid may be terse |
| GameHUD | hud-pause | 暂停 | action.pause | no |
| PauseVeil | pause-title | 已暂停 | pause.active | state-only |
| PauseVeil | pause-proof-position | 泡泡已冻结 | pause.snapshotPositions | state-only |
| PauseVeil | pause-proof-clock | 计时已冻结 | pause.snapshotClock | state-only |
| PauseVeil | pause-resume | 继续 | action.resume | state-only |
| PauseVeil | pause-recalibrate | 重新校准 | action.recalibrate | state-only |
| PauseVeil | pause-end | 结束本局 | action.requestEnd | state-only |
| Result | result-badge | 徽章 | result.badge | state-only |
| Result | result-accuracy | 准确率 | stats totals | state-only |
| Result | result-normal | 普通统计 | normal stats | state-only |
| Result | result-gold | 金色统计 | gold stats | state-only |
| Result | result-gray | 灰色统计 | gray stats | state-only |
| Result | result-best | 最高分 | best.score | appears start/results |
| Result | result-save | 保存状态 | storage.state | state-only |
| Result | result-save-retry | 重试保存 | action.retrySave | error only |
| Result | result-replay | 再玩 | action.replay | state-only |
| Result | result-return | 返回 | action.returnShared | state-only |
| Dialog | end-title | 结束？ | dialog.open | D1 only |
| Dialog | end-body | 后果 | dialog.originState | D1 only |
| Dialog | end-cancel | 继续游戏 | action.cancelEnd | D1 only |
| Dialog | end-confirm | 结束本局 | action.confirmEnd | D1 only |

#### 2.2.3 dataBindings[] denominator

| Paths (one per semicolon token) | Selector | normal | fallback/error | Type |
|---|---|---|---|---|
| calibration.status | cal-status | 互动区可用 | 还不能校准 | semantic |
| calibration.headPose | cal-fan | origin | fan hidden/disabled (inspector evidence) | display |
| calibration.floorEstimate | cal-fan | floor line | 待检测 | display |
| calibration.envelope | cal-fan | candidate outline | static outline | display |
| bubble.kind | bubble-mesh/glyph | three variants | gray safe fallback | semantic |
| bubble.position | bubble-mesh | three positions | release text in inspector | display |
| bubble.terminal | bubble-feedback | 正确 | error receipt | semantic |
| bubble.poolId | bubble-mesh | instance | quarantine statement | display |
| bubble.bounds | bubble-mesh | in bounds | overflow state | display |
| BubbleActor · input.state | bubble lab | armed | disarmed | semantic |
| BubbleActor · input.lastValidAt | bubble lab | valid | remain disarmed | display |
| BubbleActor · tutorial.prompt | bubble-label | 拍破普通泡泡 | 看形状选动作 | display |
| GameHUD · input.state | hud-input | 手势可用 | 使用手柄继续 | semantic |
| GameHUD · input.lastValidAt | hud-input | valid | remain disarmed | display |
| GameHUD · tutorial.prompt | hud-prompt | 拍破普通泡泡 | 看形状选动作 | display |
| gate.pose | gate-rim | visible | error state | display |
| gate.calibrationStatus | gate-status | 互动区 | 待校准 | semantic |
| InteractionGate · pause.active | gate-status | 已冻结 | active | semantic |
| PauseVeil · pause.active | pause-title | 已暂停 | hidden outside state | semantic |
| bubble.timeToGate | gate-progress | 接近 | hidden conditional | display |
| clock.remaining | hud-time | 02:30 | --:-- | display |
| tier.index | hud-tier data context | 1 | 0/tutorial | display |
| tier.label | hud-tier | 第1档 | 教学 | display |
| theme.index | hud-theme | 薄荷晨光 | 柔和主题 | display |
| pause.snapshotPositions | pause-proof-position | 已冻结 | 正在确认 | display |
| pause.snapshotClock | pause-proof-clock | 已冻结 | 正在确认 | display |
| PauseVeil · action.resume | pause-resume | enabled | disabled until proof | action |
| PauseVeil · action.recalibrate | pause-recalibrate | enabled | disabled until proof | action |
| PauseVeil · action.requestEnd | pause-end | opens dialog | disabled until proof | action |
| result.badge | result-badge | 铜/银/金 | 铜+不完整 | semantic |
| stats.totalCorrect | result-accuracy | 18 | 0 | display |
| stats.totalAttempt | result-accuracy | 21 | 暂无判定 | display |
| stats.normalCorrect | result-normal | 8 | 0 | display |
| stats.normalAttempt | result-normal | 10 | 暂无泡泡 | display |
| stats.goldCorrect | result-gold | 4 | 0 | display |
| stats.goldAttempt | result-gold | 5 | 暂无泡泡 | display |
| stats.grayCorrect | result-gray | 6 | 0 | display |
| stats.grayAttempt | result-gray | 6 | 暂无泡泡 | display |
| best.score | result-best | 1240 | 暂无最高分 | display |
| storage.state | result-save/retry | 已保存 | 未更新+重试 | semantic |
| dialog.open | end-title | visible | hidden | semantic |
| dialog.originState | end-body | 当前进度结算 | safe default | display |
| EndRunDialog · action.cancelEnd | end-cancel | return origin | safe cancel | action |
| EndRunDialog · action.confirmEnd | end-confirm | results/exit | disabled if locked | action |

#### 2.2.4 variants / component-specific states denominator

Every comma-separated token below is one declared fact; trigger is `component` + `variant` or `component state`; expected observable is `#scene[data-component][data-variant/data-component-state]` plus visible inspector label and applicable focus/error/overflow style.

| Component | Variants (individual tokens) | States (individual tokens) | Source |
|---|---|---|---|
| CalibrationHalo | sitting, standing, unknown | default, focused, pressed, disabled, loading, empty, error, overflow | Visual §5.3 |
| BubbleActor | normal, gold, gray | pooled, approaching, gate-active, focused, pressed, grabbed, trackingGrace, paused, terminal, error, overflow | Visual §5.3 |
| InteractionGate | tutorial, game, calibration | default, focused, pressed, disabled, loading, empty, error, overflow, paused | Visual §5.3 |
| GameHUD | tutorial, game, controller, reduceMotion | default, focused, pressed, disabled, loading, empty, error, overflow, paused | Visual §5.3 |
| PauseVeil | normal, constrained, freezeError | default, focused, pressed, disabled, loading, empty, error, overflow | Visual §5.3 |
| Result | bronze, silver, gold, partial, saveError | default, focused, pressed, disabled, loading, empty, error, overflow, partial | Visual §5.3 |
| Dialog | endRun, exitStage | default, focused, pressed, disabled, loading, empty, error, overflow | Visual §5.3 |
| stacking | each component precedence string | selecting higher state visibly overrides base; dialog overlays pause/game | Visual §5.3 |

### 2.2.5 Responsive / Reduce Motion denominator

| Fact | Size/content | Trigger | Observable |
|---|---|---|---|
| Large | result 1120×700/content1072×652 | tier=large | two-column where applicable |
| Compact | window ≈760 CSS / spec state sizes | tier=compact | narrower shell/wrap |
| Constrained | 640 wide; spec content592 | tier=constrained | `.two` one column; text reflow |
| Reduce Motion | interaction §13 | button | `.rm`; drift animation none |

### 2.3 Markdown Declarative Checklist

| Check | Source | Selector | Trigger | Expected | Actual | Verdict |
|---|---|---|---|---|---|---|
| Manifest | §2.2 | report rows | inspect | no missing source group | generation 7/15/39/44/23/62/4; previous QA rebuilt same | ready_for_final_QA |
| State machine | IS §10 | `[data-action],#scene[data-state]` | wired buttons | target/origin renders | CR-05 explicit calibration/origin/TR10/11/14/15/back routes | ready_for_final_QA |
| DOM lookup | VS §5.3 | `[data-preview-id]` + component lab | state/component | correct component selectors | 39 ids in scene/lab; targetByPath maps all 44 | ready_for_final_QA |
| Data modes | VS bindings | `#binding,#mode,[data-binding-proof]` | each binding × three modes | path-specific target/copy | fallbackByPath has every unique path; component duplicate targets explicit | ready_for_final_QA |
| High risk | TR6/14/15 | `[data-state=D1_END_CONFIRM]`, end-* | Back/cancel/confirm | modal blocks and restores origin | dialogKind2 deterministic; Back cancel remains enabled | ready_for_final_QA |
| Responsive/RM | IS §9/13 | `#tier,[data-action=reduce],rm-assert` | tier/select | structural reflow/no animation | Compact/Constrained single column; action stack; content assertion; `.rm` | ready_for_final_QA |

### 2.4 Preview Denominator Reconciliation

| Type | Generation total | QA rebuilt | Difference | Verdict |
|---|---:|---:|---:|---|
| States | 7 | 7 | 0 | pass |
| Transitions | 15 | 15 | 0 | pass |
| render elements | 39 | 39 | 0 | pass |
| bindings | 44 | 44 | 0 | pass |
| variants | 23 | 23 | 0 | pass |
| component states | 62 | 62 | 0 | pass |
| responsive/RM | 4 | 4 | 0 | pass |

### 2.5 Preview Hard Gate

`pass` at invocation 41b5fe16: denominators zero-diff, stateTarget covers all 62 component-state occurrences, 23 variants mutate component primitives, and no Web-fidelity blocker remains.

## 3. Preview Coverage

### 3.1 State / transition → mapping

All rows map to wired `[data-action]` or component buttons and `#scene[data-state]`; `prior`/`origin` restore pause/dialog sources; exitStage reaches S0.

### 3.2 renderSpec → DOM mapping

Every id maps to `[data-preview-id]` in its actual scene and selected component lab; the lab renders the component's complete anatomy, not a selector catalog.

### 3.3 bindings → data/fallback mapping

Every one of 44 component-scoped bindings is selectable via `#binding`; `#mode` shows normal/fallback/error in `[data-binding-proof]`.

### 3.4 variants/states → behavior mapping

All 23 variants and 62 states are selectable; selected component elements remain visible and state produces visual class plus explicit stacking text.

### 3.5 responsive/RM → mapping

Tiers change shell, columns, HUD rows, actions and result scrolling; RM removes motion and `[data-preview-id=rm-assert]` states the result.

## 4. Requirements Traceability

PM R3–R20 map to states, controls, three bubble forms, pause proof, results, fallback and safe-fan copy. R1/R2 build/runtime and R21/R22 device screenshots remain downstream.

## 5. Sample Data

- normal: accuracy 86%, normal 8/10, gold 4/5, gray 6/6, best 1240.
- fallback: missing calibration/clock/best uses readable Chinese.
- error: tracking controller message, freeze pending, storage failure retry.

## 6. Web Logic Consistency Tolerance

CSS meter/depth is illustrative only. Web validates state relationships, selectors and copy, not physical reach/collision/material/audio.

## 7. Device-Validation Boundary

`deviceValidation.status = not_performed`. Must later validate safe fan geometry, behind/overhead/floor exclusions, seated/standing reach, hand/controller thresholds, gesture loss, pause physics, object pool/performance, spatial audio, materials, 180s timing and screenshots.

## 8. Defect List

No open Web-fidelity defect after CR-08. Device/runtime items remain out of scope and `not_performed`.

## 9. Delivery and Recipients

- Preview rev1 for independent QA; not runtime evidence.
