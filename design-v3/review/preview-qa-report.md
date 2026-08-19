# Preview / QA Test Report · BubbleReflexLab v3

> revision: 19 · Stage14 rerun-8 final independent PASS · roles: prototype_frontend_engineer + prototype_qa_reviewer · reviewed scope: preview8;previewQA18;interaction5;visual2;pm3;uxr2;critique16;trace39 · invocation: 2a9f8b8d-5e84-4d67-8f6e-870f3502fa54

Stage14 rerun-4 invocation `9a7e51dc-2f68-4d9c-bf7e-fd7f0c32f3ab` rebuilt `10/18/54/54/32/63/8/4`; only the Preview5 exact-scope label and blank T04 consequence copy blocked. CR-08 repairs those two lines in Preview6. All previously passing behavior is unchanged; device validation remains not performed.

Stage14 rerun-5 invocation `5b0ee81e-6c94-4c23-9b4a-0fae6f8d7b7f` independently rebuilt `10/18/54/54/32/63/8/4` with zero differences. Its independent item review is preserved in the verdict column as `pass_independent_r6`; the three explicit blockers are repaired by CR-09 in Preview7/PreviewQA14 and remain subject to a fresh rerun. Device validation remains not performed.

Stage14 rerun-6 invocation `f2e5a34f-95cf-41ef-87b0-7bd7e0ad0c63` independently rebuilt `10/18/54/54/32/63/8/4` with zero differences and directly rechecked Preview7. It confirmed the owning-state C6 input normal/fallback/error behavior, T04 consequence dialog, all reverse lookups, responsive/RM, semantics, and 64px controls. Its behavioral evidence is recorded item by item below as `pass_independent_r6`. Its block was limited to the generation-time QA saying the then-future review was pending and not citing its later receipt; this revision records the result after completion without backdating.

Stage14 rerun-7 invocation `8f0f30be-0b2e-4d10-91cc-580f6731d5f2` independently rebuilt `10/18/54/54/32/63/8/4`, found zero differences and no findings, and passed all five Preview hard gates. `previewImplementationFidelity=pass`, `designStatusImpact=none`, `deviceValidation.status=not_performed`.

Stage14 rerun-8 invocation `2a9f8b8d-5e84-4d67-8f6e-870f3502fa54` independently rebuilt `10/18/54/54/32/63/8/4`, found zero differences and no artifact findings, and passed the active Preview8/PreviewQA18 scope. Device validation remains `not_performed`.

Stage14 rerun-3 invocation `4b92c0e4-6d9a-4b5e-9c7d-2a7f6a0d3e19` independently rebuilt `10/18/54/54/32/63/8/4` and found exactly two blockers: Preview4 header provenance and T04 missing from the confirmation set. CR-07 repairs only those two lines in Preview5; all non-findings remain unchanged. Independent device validation is still not performed.

Stage14 rerun-2 independent Actual/Verdict (invocation `f3b19068-9b1b-4d7a-9f9d-9b9a28d25e1a`) rebuilt `10/18/54/54/32/63/8/4` and blocked Preview3. Preview4 repairs exact provenance, captured-prior guard, C7 input ownership, three actor-kind scoped selectors, component anatomy/state effects, unified N3/N7 dialog flow, and project 64dp action size. The independent verdict is not copied as a pass; it remains block and is invalidated by CR-06 pending rerun.

## 1. Scope and input readiness
- scope: web_design_validation_only
- deviceValidation.status: not_performed
- preview artifact: `../preview.html` Preview8, the active wording-only provenance successor to Preview7; behavior was independently reviewed in Stage14 rerun-7 as `preview8;previewQA16;interaction5;visual2;pm3;uxr2;critique14;trace35`
- independent Preview QA: latest completed Stage14 rerun-7, invocation `8f0f30be-0b2e-4d10-91cc-580f6731d5f2`; evidence recorded after completion in PreviewQA17 and retained in this CR-11 successor

| Input fact | active evidence | assertion | verdict |
|---|---|---|---|
| Design-system review | Critique13 current active record; Visual2 / Interaction5 remain the Stage12-approved design facts | Stage12 independent pass invocation 9f0c1e2a; later critique revisions only record Preview reviews and do not mutate the approved design facts | pass |
| States/transitions | Interaction5 §11 | N0–N9 and T01–T18 complete | pass |
| Core components | Visual2 §§9–10 | 8/8 independent eight-block structures pass | pass |
| renderSpec elements | Visual2 §9 | 54 stable ids rebuilt item by item below | pass |
| dataBindings | Visual2 §9 | 54 target/fallback/type rows rebuilt below | pass |
| variants/states | Visual2 §9 | 32 variants + 63 states + 8 precedence rows | pass |
| responsive/RM | Interaction5 §§10,16; Visual2 §8 | Large/Compact/Constrained/RM explicit | pass |
| visual grammar | Visual2 §§7,12–14 | exact tokens/semantics/materials, no conflict | pass |

Input readiness verdict: pass. The Manifest below was written before preview.html generation.

## 2. Preview Coverage Manifest (declarative denominator before generation)

### 2.1 States and transitions
| type | ID | source | trigger / entry | target / visible result | confirm | verdict |
|---|---|---|---|---|---|---|
| state | N0 | Interaction5 §11 | launch | 静水启程 / C1 overview | N/A | included |
| state | N1 | Interaction5 §11 | T01 | 三印短课 / C1 guided-step | N/A | included |
| state | N2 | Interaction5 §11 | T02 or T07 | 触域定标 / C2 | N/A | included |
| state | N3 | Interaction5 §11 | T03 | C3 Stage entry dialog, Cancel first | yes | included |
| state | N4 | Interaction5 §11 | T04 confirmed | 三泡初见 Stage / C4+C5+C6 | yes | included |
| state | N5 | Interaction5 §11 | T08 | 五段合奏 / C4+C5+C6 | no | included |
| state | N6 | Interaction5 §11 | T05/T10/T11 | C7 frozen recovery surface | no | included |
| state | N7 | Interaction5 §11 | T12 | C7 discard confirmation, Cancel first | yes | included |
| state | N8 | Interaction5 §11 | T09 | 静水结算 / C6+C8 pending | no | included |
| state | N9 | Interaction5 §11 | T15 | 花窗回响 / C8 | no | included |
| transition | T01 | Interaction5 §11.1 | N0 + user.beginPressed | N1 · beginLesson() | no | included |
| transition | T02 | Interaction5 §11.1 | N1 + lesson.triadAcknowledged | N2 · openCalibration() | no | included |
| transition | T03 | Interaction5 §11.1 | N2 + calibration.accepted | N3 · sealCalibration();openStageConsent() | yes | included |
| transition | T04 | Interaction5 §11.1 | N3 + user.confirmStageEntry | N4 · openStageMixed();activateRecipe(0) | yes | included |
| transition | T05 | Interaction5 §11.1 | N4/N5 + user.pausePressed | N6 · captureFreezeSeal(manual) | no | included |
| transition | T06 | Interaction5 §11.1 | N6 + user.resumePressed + valid seal/lease | prior N4/N5 · restoreFreezeSeal();resumeClock() | yes | included |
| transition | T07 | Interaction5 §11.1 | N6 + user.recalibratePressed | N2 · closeStage();preservePaused();openCalibration() | yes | included |
| transition | T08 | Interaction5 §11.1 | N4 + clock 30s + exact triad | N5 · commitBoundary(recipe1/theme1/audio1) | no | included |
| transition | T09 | Interaction5 §11.1 | N5 + clock 180s | N8 · closeSpawns();freezeActors();reconcileLedger() | no | included |
| transition | T10 | Interaction5 §11.1 | N4/N5 + input.lossSustained | N6 · captureFreezeSeal(inputLoss);revokeLease() | no | included |
| transition | T11 | Interaction5 §11.1 | N4/N5 + pose.outsideAcceptedEnvelope | N6 · captureFreezeSeal(poseDrift);stopSeeds() | no | included |
| transition | T12 | Interaction5 §11.1 | N6 + user.exitRunPressed | N7 · openDiscardConfirmationVariant() | yes | included |
| transition | T13 | Interaction5 §11.1 | N7 + cancel/back/Escape | N6 · closeConfirmation();keepSeal() | no | included |
| transition | T14 | Interaction5 §11.1 | N7 + user.confirmDiscard | N0 · returnActors();closeStage();discardRun() | yes | included |
| transition | T15 | Interaction5 §11.1 | N8 + settlement closed/partial | N9 · closeStage();renderResult();attemptSave() | no | included |
| transition | T16 | Interaction5 §11.1 | N9 + user.replayPressed | N1 · clearLedger();beginLesson() | no | included |
| transition | T17 | Interaction5 §11.1 | N9 + home/back | N0 · retainHistory();showHome() | no | included |
| transition | T18 | Interaction5 §11.1 | N9 + user.retrySavePressed | N9 · retryBestWrite();renderOutcome() | yes | included |

### 2.2 renderSpec.elements[]
| component | element id | source | visible label | bind | conditional rule | verdict |
|---|---|---|---|---|---|---|
| C1 | c1-title | Visual2 §9 C1 | 记住三条就够了 | lesson.step | always | included |
| C1 | c1-ordinary | Visual2 §9 C1 | 普通泡泡·拍 | lesson.acknowledgedKinds.ordinary | always | included |
| C1 | c1-gold | Visual2 §9 C1 | 金色泡泡·抓 | lesson.acknowledgedKinds.gold | always | included |
| C1 | c1-gray | Visual2 §9 C1 | 灰色泡泡·别碰 | lesson.acknowledgedKinds.gray | always | included |
| C1 | c1-best | Visual2 §9 C1 | 最高分 | bestMark.readState/value | N0 only; value conditional on read state | included |
| C1 | c1-cue | Visual2 §9 C1 | 轮到你确认 | lesson.validationMessage | N1 or error | included |
| C1 | c1-primary | Visual2 §9 C1 | 开始 / 下一条 | lesson.primaryAction | label/action state dependent | included |
| C2 | c2-diagram | Visual2 §9 C2 | 你的前方花窗 | sessionEnvelope.envelope | always in N2 | included |
| C2 | c2-band | Visual2 §9 C2 | 互动区 | sessionEnvelope.bandPose | hide when envelope invalid | included |
| C2 | c2-posture | Visual2 §9 C2 | 坐姿 / 站姿 | sessionEnvelope.posture | always in N2 | included |
| C2 | c2-input | Visual2 §9 C2 | 手势 / 手柄 | inputLease.source/armed | always in N2 | included |
| C2 | c2-sample | Visual2 §9 C2 | 请自然伸手 | pose.sampleState | always in N2 | included |
| C2 | c2-retry | Visual2 §9 C2 | 重新测量 | pose.retryAllowed | show for sampled/error | included |
| C2 | c2-confirm | Visual2 §9 C2 | 确认互动区 | sessionEnvelope.canAccept | always; disabled if false | included |
| C3 | c3-title | Visual2 §9 C3 | 进入花窗场？ | static | N3 | included |
| C3 | c3-summary | Visual2 §9 C3 | 互动区已确认 | sessionEnvelope.* | N3 | included |
| C3 | c3-input | Visual2 §9 C3 | 当前输入 | inputLease.source/armed | N3 | included |
| C3 | c3-status | Visual2 §9 C3 | 进入后将切换到全空间 | stage.openState | N3 | included |
| C3 | c3-cancel | Visual2 §9 C3 | 取消 | static | N3 | included |
| C3 | c3-enter | Visual2 §9 C3 | 进入花窗场 | stage.canOpen | N3; disabled if false | included |
| C4 | c4-contour | Visual2 §9 C4 | 安全出现区 | sessionEnvelope.envelope | N4/N5/N6/N8 | included |
| C4 | c4-band | Visual2 §9 C4 | 互动区 | sessionEnvelope.bandPose | hide if invalid | included |
| C4 | c4-forward | Visual2 §9 C4 | 你的前方 | sessionEnvelope.forwardAxis | N4/N5 | included |
| C4 | c4-invalid | Visual2 §9 C4 | 需要重新校准 | sessionEnvelope.validity | show stale/error only | included |
| C5 | c5-shell | Visual2 §9 C5 | category human label | driftActor.kind | when actor acquired | included |
| C5 | c5-verb | Visual2 §9 C5 | 拍 / 抓 / 别碰 | driftActor.kind | when actor acquired | included |
| C5 | c5-proximity | Visual2 §9 C5 | 即将到达 | driftActor.bandPhase | eligible phase only | included |
| C5 | c5-verdict | Visual2 §9 C5 | 拍破 / 抓住 / 已避开 / 动作不符 | ruleVerdict.result | terminal only | included |
| C5 | c5-tail | Visual2 §9 C5 | no visible label | driftActor.velocity | hide in Reduce Motion/fallback | included |
| C6 | c6-time | Visual2 §9 C6 | 03:00 | sessionClock.remaining | N4/N5/N6 | included |
| C6 | c6-segment | Visual2 §9 C6 | 短课 / 第1–5段 | segmentRecipe.index/themeLabel | N4/N5 | included |
| C6 | c6-input | Visual2 §9 C6 | 手势 / 手柄 / 未就绪 | inputLease.source/armed | N4/N5 | included |
| C6 | c6-pause | Visual2 §9 C6 | 暂停 | run.canPause | N4/N5; disabled frozen/settling | included |
| C6 | c6-settle | Visual2 §9 C6 | 正在核对本局 | runTally.completeness | N8 only | included |
| C7 | c7-title | Visual2 §9 C7 | 已暂停 | freezeSeal.reason/state | N6/N7 | included |
| C7 | c7-proof | Visual2 §9 C7 | 时间、泡泡和判定都已冻结 | freezeSeal.integrity | N6/N7 | included |
| C7 | c7-input | Visual2 §9 C7 | 当前输入 | inputLease.source/armed | N6 | included |
| C7 | c7-resume | Visual2 §9 C7 | 继续 | freezeSeal.canResume | N6; disabled if invalid | included |
| C7 | c7-switch | Visual2 §9 C7 | 切换输入 | inputLease.availableSources | N6; disabled if empty | included |
| C7 | c7-calibrate | Visual2 §9 C7 | 重新校准 | sessionEnvelope.calRev | N6 | included |
| C7 | c7-exit | Visual2 §9 C7 | 结束本局 | run.active | N6 when active | included |
| C7 | c7-confirm-copy | Visual2 §9 C7 | 舍弃本局进度？ | run.discardState | N7 only | included |
| C7 | c7-cancel | Visual2 §9 C7 | 取消 | static | N7 only | included |
| C7 | c7-discard | Visual2 §9 C7 | 舍弃本局 | run.discardState | N7 only | included |
| C8 | c8-accuracy | Visual2 §9 C8 | 准确率 | runTally.accuracy | N9; hidden pending N8 | included |
| C8 | c8-badge | Visual2 §9 C8 | 铜徽章 / 银徽章 / 金徽章 | runTally.badge | complete only | included |
| C8 | c8-score | Visual2 §9 C8 | 本局得分 | runTally.score | N9 trusted data | included |
| C8 | c8-ordinary | Visual2 §9 C8 | 普通泡泡 | runTally.categories.ordinary | N9 | included |
| C8 | c8-gold | Visual2 §9 C8 | 金色泡泡 | runTally.categories.gold | N9 | included |
| C8 | c8-gray | Visual2 §9 C8 | 灰色泡泡 | runTally.categories.gray | N9 | included |
| C8 | c8-best | Visual2 §9 C8 | 最高分 | bestMark.value/writeState | N9 | included |
| C8 | c8-replay | Visual2 §9 C8 | 再来一局 | static | N9 | included |
| C8 | c8-home | Visual2 §9 C8 | 返回 | static | N9 | included |
| C8 | c8-save-retry | Visual2 §9 C8 | 重试保存 | bestMark.writeState | save-error only | included |

### 2.3 dataBindings[]
| component | source path | target | normal sample | fallback/error sample | kind | verdict |
|---|---|---|---|---|---|---|
| C1 | lesson.step | c1-title text + active seal | overview=0 | invalid→请重新开始短课 | display-only | included |
| C1 | lesson.acknowledgedKinds.* | seal selected | ordinary/gold/gray true | conflict→clear + 请留意 | semantic | included |
| C1 | bestMark.readState | c1-best label/shape | fresh | loading/error human status; never 0 | semantic | included |
| C1 | bestMark.value | c1-best value | 1260 | null→暂无数据 | display-only | included |
| C1 | lesson.validationMessage | c1-cue text | 看形状，也看动作字 | null→same guidance | display-only | included |
| C1 | lesson.primaryAction | c1-primary label/enabled | 开始 | missing→disabled 请先确认 | semantic | included |
| C2 | sessionEnvelope.posture | c2-posture selected | 坐姿 | null→unselected + confirm disabled | semantic | included |
| C2 | sessionEnvelope.envelope | c2-diagram path | front 80° valid | absent→尚未测量; invalid→blocked | semantic | included |
| C2 | sessionEnvelope.bandPose | c2-band geometry | confirmed band | absent→ghost only; invalid uncommitted | semantic | included |
| C2 | sessionEnvelope.calRev | confirm caption | 互动区已确认 | absent→尚未保存; conflict retry | display-only | included |
| C2 | inputLease.source/armed | c2-input | 手势 已就绪 | none→尚未连接; denied→controller option | semantic | included |
| C2 | pose.sampleState | c2-sample | 测量完成 | unavailable/stale→中断 + retain prior | semantic | included |
| C2 | sessionEnvelope.canAccept | c2-confirm enabled | true | false/missing→disabled reason | semantic | included |
| C3 | sessionEnvelope.calRev | c3-summary | 互动区已确认 | absent/conflict→未确认 + enter disabled | semantic | included |
| C3 | sessionEnvelope.posture | c3-summary | 坐姿 | null→姿态未选择 | display-only | included |
| C3 | inputLease.source/armed | c3-input | 手势 已就绪 | none→输入尚未就绪 | semantic | included |
| C3 | stage.canOpen | c3-enter enabled | true | false→disabled prerequisite | semantic | included |
| C3 | stage.openState | c3-status | ready | loading/error→正在进入/暂时无法进入 | semantic | included |
| C4 | sessionEnvelope.envelope | c4-contour vertices | valid front fan | absent/invalid→no seeds + blocked | semantic | included |
| C4 | sessionEnvelope.bandPose | c4-band transform | confirmed | absent→hidden; stale→freeze | semantic | included |
| C4 | sessionEnvelope.calRev | geometry ownership | rev-3 | mismatch→freeze + recalibrate | semantic | included |
| C4 | sessionEnvelope.forwardAxis | c4-forward orientation | front | unavailable→stop seeds + frozen last | semantic | included |
| C4 | arrivalSeed.eligibility/pose | admitted glint | eligible +12° | invalid→not rendered + returned | semantic | included |
| C4 | freezeSeal.state | c4 frozen style | running | invalid seal→blocked/no resume | semantic | included |
| C5 | arrivalSeed.pose/eligibility | actor acquire | eligible front pose | invalid→never visible + pool return | semantic | included |
| C5 | driftActor.kind | shell/verb | ordinary | unknown→blocked + recycle | semantic | included |
| C5 | driftActor.lifecycle | visibility/collider | approaching | conflict/terminal reused→collider off | semantic | included |
| C5 | driftActor.transform | world transform | z=1.8m | stale/OOB→no teleport + return | semantic | included |
| C5 | driftActor.bandPhase | proximity/eligibility | eligible | missing→no judgment | semantic | included |
| C5 | driftActor.velocity | tail direction | 0.30m/s | missing→tail hidden | display-only | included |
| C5 | ruleVerdict.result | verdict label | success | absent→no success; conflict→待核对/no score | semantic | included |
| C6 | sessionClock.remaining | c6-time mm:ss | 02:30 | missing/stale→时间已暂停 | display-only | included |
| C6 | segmentRecipe.index | c6-segment | 第2段 | invalid→段落待核对 + freeze | semantic | included |
| C6 | segmentRecipe.themeLabel | segment secondary | 薄荷 | null→omit; last layer remains | display-only | included |
| C6 | inputLease.source/armed | c6-input | 手势 | none→未就绪 + recovery | semantic | included |
| C6 | run.canPause | c6-pause enabled | true | false→disabled 已暂停/结算 | semantic | included |
| C6 | runTally.completeness | c6-settle | complete | partial/conflict→统计不完整 | semantic | included |
| C7 | freezeSeal.reason/state | c7-title | 手动暂停 / frozen | missing→原因未知 + resume disabled | semantic | included |
| C7 | freezeSeal.integrity | c7-proof checks | all true | incomplete/conflict→不可继续 | semantic | included |
| C7 | freezeSeal.canResume | c7-resume enabled | true | false/missing→disabled first reason | semantic | included |
| C7 | inputLease.source/armed | c7-input | 手势 | none→未就绪 | semantic | included |
| C7 | inputLease.availableSources | c7-switch choices | 手势,手柄 | empty→disabled 没有可用输入 | semantic | included |
| C7 | sessionEnvelope.calRev | recalibrate context | rev-3 | stale/mismatch→建议重新校准 | semantic | included |
| C7 | run.active | c7-exit visibility | true | false→hide; unknown disabled | semantic | included |
| C7 | run.discardState | nested confirm/error | confirming | failure→stay paused + retry | semantic | included |
| C8 | runTally.completeness | whole result eligibility | complete | partial/conflict→no badge/save | semantic | included |
| C8 | runTally.accuracy | c8-accuracy | 92% | null/denominator0→暂无数据 | display-only | included |
| C8 | runTally.badge | c8-badge | 银徽章 | null complete→未获得; partial hidden | semantic | included |
| C8 | runTally.score | c8-score | 1260 | null→暂无数据 | display-only | included |
| C8 | runTally.categories.ordinary | c8-ordinary | 拍对 9/10 | absent→暂无数据; mismatch partial | display-only | included |
| C8 | runTally.categories.gold | c8-gold | 抓住 6/7 | absent→暂无数据; mismatch partial | display-only | included |
| C8 | runTally.categories.gray | c8-gray | 避开 7/7 | absent→暂无数据; mismatch partial | display-only | included |
| C8 | bestMark.value | c8-best | 1450 | null→暂无数据; retain result | display-only | included |
| C8 | bestMark.writeState | c8-best/retry | 已保存 | loading/failed→正在保存/未保存可重试 | semantic | included |

### 2.4 Variants, component states and stacking combinations
| component | class | item | source | trigger method | expected observable result | verdict |
|---|---|---|---|---|---|---|
| C1 | variant | overview | Visual2 §9 C1 | Component Lab: select C1, then choose variant=overview | show three equal seals | included |
| C1 | variant | guided-step | Visual2 §9 C1 | Component Lab: select C1, then choose variant=guided-step | one hero seal + step | included |
| C1 | variant | recall-complete | Visual2 §9 C1 | Component Lab: select C1, then choose variant=recall-complete | three checked + 去校准 | included |
| C1 | state | default | Visual2 §9 C1 | Component Lab: select C1, then choose state=default | base seals | included |
| C1 | state | focused | Visual2 §9 C1 | Component Lab: select C1, then choose state=focused | 3dp outline + 1.03 | included |
| C1 | state | selected | Visual2 §9 C1 | Component Lab: select C1, then choose state=selected | check + semantic fill | included |
| C1 | state | disabled | Visual2 §9 C1 | Component Lab: select C1, then choose state=disabled | readable .55 + reason | included |
| C1 | state | loading | Visual2 §9 C1 | Component Lab: select C1, then choose state=loading | best progress only | included |
| C1 | state | empty | Visual2 §9 C1 | Component Lab: select C1, then choose state=empty | best 暂无数据 | included |
| C1 | state | error | Visual2 §9 C1 | Component Lab: select C1, then choose state=error | attention/retry | included |
| C1 | state | overflow | Visual2 §9 C1 | Component Lab: select C1, then choose state=overflow | paged seal + scroll | included |
| C1 | stack | error>disabled>focused>selected>default | Visual2 §9 C1 | Component Lab: select C1, then choose stack=error>disabled>focused>selected>default | error wins | included |
| C2 | variant | seated | Visual2 §9 C2 | Component Lab: select C2, then choose variant=seated | lower band illustration | included |
| C2 | variant | standing | Visual2 §9 C2 | Component Lab: select C2, then choose variant=standing | standing band | included |
| C2 | variant | controller-conservative | Visual2 §9 C2 | Component Lab: select C2, then choose variant=controller-conservative | reduced unverified band | included |
| C2 | variant | recalibration | Visual2 §9 C2 | Component Lab: select C2, then choose variant=recalibration | prior dashed + new sample | included |
| C2 | state | default | Visual2 §9 C2 | Component Lab: select C2, then choose state=default | ghost contour | included |
| C2 | state | focused | Visual2 §9 C2 | Component Lab: select C2, then choose state=focused | 3dp focused control | included |
| C2 | state | sampling | Visual2 §9 C2 | Component Lab: select C2, then choose state=sampling | progressive contour | included |
| C2 | state | selected | Visual2 §9 C2 | Component Lab: select C2, then choose state=selected | check + label | included |
| C2 | state | boundary-disabled | Visual2 §9 C2 | Component Lab: select C2, then choose state=boundary-disabled | blocked + confirm disabled | included |
| C2 | state | stale | Visual2 §9 C2 | Component Lab: select C2, then choose state=stale | dashed prior contour | included |
| C2 | state | error | Visual2 §9 C2 | Component Lab: select C2, then choose state=error | retry/controller alternative | included |
| C2 | state | overflow | Visual2 §9 C2 | Component Lab: select C2, then choose state=overflow | stack + scroll | included |
| C2 | stack | error>boundary-disabled>stale>focused>selected>sampling>default | Visual2 §9 C2 | Component Lab: select C2, then choose stack=error>boundary-disabled>stale>focused>selected>sampling>default | highest state wins | included |
| C3 | variant | ready | Visual2 §9 C3 | Component Lab: select C3, then choose variant=ready | enter enabled | included |
| C3 | variant | prerequisite-blocked | Visual2 §9 C3 | Component Lab: select C3, then choose variant=prerequisite-blocked | missing facts + disabled | included |
| C3 | variant | open-retry | Visual2 §9 C3 | Component Lab: select C3, then choose variant=open-retry | open error + retry | included |
| C3 | state | default | Visual2 §9 C3 | Component Lab: select C3, then choose state=default | Cancel first | included |
| C3 | state | focused | Visual2 §9 C3 | Component Lab: select C3, then choose state=focused | 3dp control | included |
| C3 | state | pressed | Visual2 §9 C3 | Component Lab: select C3, then choose state=pressed | 0.98 action | included |
| C3 | state | disabled | Visual2 §9 C3 | Component Lab: select C3, then choose state=disabled | Enter disabled + reason | included |
| C3 | state | loading | Visual2 §9 C3 | Component Lab: select C3, then choose state=loading | 正在进入 + locked | included |
| C3 | state | error | Visual2 §9 C3 | Component Lab: select C3, then choose state=error | open failed + Cancel | included |
| C3 | state | overflow | Visual2 §9 C3 | Component Lab: select C3, then choose state=overflow | vertical actions | included |
| C3 | stack | error>loading>disabled>focused>pressed>default | Visual2 §9 C3 | Component Lab: select C3, then choose stack=error>loading>disabled>focused>pressed>default | modal precedence | included |
| C4 | variant | tutorial | Visual2 §9 C4 | Component Lab: select C4, then choose variant=tutorial | strong contour + persistent band label | included |
| C4 | variant | play | Visual2 §9 C4 | Component Lab: select C4, then choose variant=play | quiet contour + label fade | included |
| C4 | variant | reduced-envelope | Visual2 §9 C4 | Component Lab: select C4, then choose variant=reduced-envelope | narrow geometry + label | included |
| C4 | variant | reduce-motion | Visual2 §9 C4 | Component Lab: select C4, then choose variant=reduce-motion | static contour | included |
| C4 | state | loading | Visual2 §9 C4 | Component Lab: select C4, then choose state=loading | 定位中 no seeds | included |
| C4 | state | ready | Visual2 §9 C4 | Component Lab: select C4, then choose state=ready | valid contour/band | included |
| C4 | state | actor-eligible | Visual2 §9 C4 | Component Lab: select C4, then choose state=actor-eligible | band emphasis | included |
| C4 | state | frozen | Visual2 §9 C4 | Component Lab: select C4, then choose state=frozen | blue dashed static | included |
| C4 | state | stale | Visual2 §9 C4 | Component Lab: select C4, then choose state=stale | attention no seeds | included |
| C4 | state | error | Visual2 §9 C4 | Component Lab: select C4, then choose state=error | blocked + no contour | included |
| C4 | state | empty | Visual2 §9 C4 | Component Lab: select C4, then choose state=empty | field only | included |
| C4 | state | overflow | Visual2 §9 C4 | Component Lab: select C4, then choose state=overflow | invalid actor not admitted | included |
| C4 | stack | error>stale>frozen>actor-eligible>ready>empty/loading | Visual2 §9 C4 | Component Lab: select C4, then choose stack=error>stale>frozen>actor-eligible>ready>empty/loading | semantic priority | included |
| C5 | variant | ordinary | Visual2 §9 C5 | Component Lab: select C5, then choose variant=ordinary | circle + 拍 | included |
| C5 | variant | gold | Visual2 §9 C5 | Component Lab: select C5, then choose variant=gold | double diamond + 抓 | included |
| C5 | variant | gray | Visual2 §9 C5 | Component Lab: select C5, then choose variant=gray | dashed + 别碰 | included |
| C5 | variant | tutorial | Visual2 §9 C5 | Component Lab: select C5, then choose variant=tutorial | persistent larger badge | included |
| C5 | variant | pooled-performance | Visual2 §9 C5 | Component Lab: select C5, then choose variant=pooled-performance | no tail/highlight | included |
| C5 | state | pooled | Visual2 §9 C5 | Component Lab: select C5, then choose state=pooled | hidden collider off | included |
| C5 | state | approaching | Visual2 §9 C5 | Component Lab: select C5, then choose state=approaching | actor drifts | included |
| C5 | state | eligible | Visual2 §9 C5 | Component Lab: select C5, then choose state=eligible | outline + proximity | included |
| C5 | state | hold-progress | Visual2 §9 C5 | Component Lab: select C5, then choose state=hold-progress | gold loop closes | included |
| C5 | state | frozen | Visual2 §9 C5 | Component Lab: select C5, then choose state=frozen | static blue outer ring | included |
| C5 | state | terminal-success | Visual2 §9 C5 | Component Lab: select C5, then choose state=terminal-success | label + fade | included |
| C5 | state | terminal-error | Visual2 §9 C5 | Component Lab: select C5, then choose state=terminal-error | 动作不符 | included |
| C5 | state | out-of-bounds | Visual2 §9 C5 | Component Lab: select C5, then choose state=out-of-bounds | hidden return | included |
| C5 | stack | OOB/pooled>terminal-error>terminal-success>frozen>hold>eligible>approaching | Visual2 §9 C5 | Component Lab: select C5, then choose stack=OOB/pooled>terminal-error>terminal-success>frozen>hold>eligible>approaching | lifecycle priority | included |
| C6 | variant | tutorial | Visual2 §9 C6 | Component Lab: select C6, then choose variant=tutorial | 短课 1/3 | included |
| C6 | variant | recipe | Visual2 §9 C6 | Component Lab: select C6, then choose variant=recipe | 第n段 + theme | included |
| C6 | variant | settling | Visual2 §9 C6 | Component Lab: select C6, then choose variant=settling | center reconcile | included |
| C6 | variant | reduce-motion | Visual2 §9 C6 | Component Lab: select C6, then choose variant=reduce-motion | no slide/breath | included |
| C6 | state | default | Visual2 §9 C6 | Component Lab: select C6, then choose state=default | active strip | included |
| C6 | state | focused | Visual2 §9 C6 | Component Lab: select C6, then choose state=focused | Pause outline | included |
| C6 | state | pressed | Visual2 §9 C6 | Component Lab: select C6, then choose state=pressed | Pause 0.98 | included |
| C6 | state | boundary | Visual2 §9 C6 | Component Lab: select C6, then choose state=boundary | theme after commit | included |
| C6 | state | input-none | Visual2 §9 C6 | Component Lab: select C6, then choose state=input-none | 未就绪 | included |
| C6 | state | frozen | Visual2 §9 C6 | Component Lab: select C6, then choose state=frozen | constant time | included |
| C6 | state | settling | Visual2 §9 C6 | Component Lab: select C6, then choose state=settling | 核对本局 | included |
| C6 | state | error | Visual2 §9 C6 | Component Lab: select C6, then choose state=error | clock/recipe conflict | included |
| C6 | stack | error>settling>frozen>input-none>boundary>focused>pressed>default | Visual2 §9 C6 | Component Lab: select C6, then choose stack=error>settling>frozen>input-none>boundary>focused>pressed>default | status priority | included |
| C7 | variant | manual-pause | Visual2 §9 C7 | Component Lab: select C7, then choose variant=manual-pause | Resume primary | included |
| C7 | variant | input-loss | Visual2 §9 C7 | Component Lab: select C7, then choose variant=input-loss | input recovery primary | included |
| C7 | variant | pose-drift | Visual2 §9 C7 | Component Lab: select C7, then choose variant=pose-drift | recalibrate primary | included |
| C7 | variant | invalid-seal | Visual2 §9 C7 | Component Lab: select C7, then choose variant=invalid-seal | Resume absent/disabled | included |
| C7 | variant | exit-confirm | Visual2 §9 C7 | Component Lab: select C7, then choose variant=exit-confirm | nested Cancel first | included |
| C7 | state | loading | Visual2 §9 C7 | Component Lab: select C7, then choose state=loading | 正在安全暂停 | included |
| C7 | state | valid | Visual2 §9 C7 | Component Lab: select C7, then choose state=valid | all invariant checks | included |
| C7 | state | input-wait | Visual2 §9 C7 | Component Lab: select C7, then choose state=input-wait | Resume disabled | included |
| C7 | state | boundary-disabled | Visual2 §9 C7 | Component Lab: select C7, then choose state=boundary-disabled | recalibrate primary | included |
| C7 | state | focused | Visual2 §9 C7 | Component Lab: select C7, then choose state=focused | 3dp action | included |
| C7 | state | exit-confirm | Visual2 §9 C7 | Component Lab: select C7, then choose state=exit-confirm | focus trap | included |
| C7 | state | error | Visual2 §9 C7 | Component Lab: select C7, then choose state=error | stable retry | included |
| C7 | state | overflow | Visual2 §9 C7 | Component Lab: select C7, then choose state=overflow | one-column actions | included |
| C7 | stack | error>exit-confirm>boundary-disabled>input-wait>focused>valid>loading | Visual2 §9 C7 | Component Lab: select C7, then choose stack=error>exit-confirm>boundary-disabled>input-wait>focused>valid>loading | recovery priority | included |
| C8 | variant | complete-bronze/silver/gold | Visual2 §9 C8 | Component Lab: select C8, then choose variant=complete-bronze/silver/gold | badge changes | included |
| C8 | variant | complete-no-badge | Visual2 §9 C8 | Component Lab: select C8, then choose variant=complete-no-badge | no badge copy | included |
| C8 | variant | partial | Visual2 §9 C8 | Component Lab: select C8, then choose variant=partial | warning no save | included |
| C8 | variant | save-failed | Visual2 §9 C8 | Component Lab: select C8, then choose variant=save-failed | retry visible | included |
| C8 | state | loading | Visual2 §9 C8 | Component Lab: select C8, then choose state=loading | 正在核对 | included |
| C8 | state | complete | Visual2 §9 C8 | Component Lab: select C8, then choose state=complete | trusted metrics | included |
| C8 | state | focused | Visual2 §9 C8 | Component Lab: select C8, then choose state=focused | action outline | included |
| C8 | state | empty | Visual2 §9 C8 | Component Lab: select C8, then choose state=empty | 没有可结算数据 | included |
| C8 | state | partial | Visual2 §9 C8 | Component Lab: select C8, then choose state=partial | no award/save | included |
| C8 | state | save-loading | Visual2 §9 C8 | Component Lab: select C8, then choose state=save-loading | 正在保存 | included |
| C8 | state | save-error | Visual2 §9 C8 | Component Lab: select C8, then choose state=save-error | 未保存 + retry | included |
| C8 | state | overflow | Visual2 §9 C8 | Component Lab: select C8, then choose state=overflow | stack + fixed actions | included |
| C8 | stack | partial/error>empty>save-error>save-loading>focused>complete>loading | Visual2 §9 C8 | Component Lab: select C8, then choose stack=partial/error>empty>save-error>save-loading>focused>complete>loading | truth priority | included |

### 2.5 Responsive tiers and Reduce Motion
| scenario | source | tier/content area | trigger | expected result | verdict |
|---|---|---|---|---|---|
| Large | Interaction5 §10; Visual2 §8 | default 1200×800 / content 1136×656 | click data-responsive=large | three seal row; 7:5 calibration/result columns; no scale | included |
| Compact | Interaction5 §10; Visual2 §8 | 960×720 / content 896×576 | click data-responsive=compact | wrap seals; stack preview/control and result ledger | included |
| Constrained | Interaction5 §10; Visual2 §8 | min 760×640 / content 696×496 | click data-responsive=constrained | single scroll column + fixed-bottom action; 56dp preserved | included |
| Reduce Motion | Interaction5 §16; Visual2 component variants | N/A | toggle data-reduce-motion | remove breath/tails/displacement; preserve position/verdict/freeze | included |

## 3. Manifest totals

| denominator | design fact total | Manifest total | pre-generation difference |
|---|---:|---:|---:|
| states | 10 | 10 | 0 |
| transitions | 18 | 18 | 0 |
| renderSpec.elements[] | 54 | 54 | 0 |
| dataBindings[] | 54 | 54 | 0 |
| variants | 32 | 32 | 0 |
| component states | 63 | 63 | 0 |
| stacking combinations | 8 | 8 | 0 |
| variants + states + stacking | 103 | 103 | 0 |
| responsive + Reduce Motion | 4 | 4 | 0 |

## 4. Generation observation

- `preview.html` revision 1 was written at `2026-08-13T22:57:30+08:00`, after the input-readiness manifest.
- JavaScript syntax: pass (`node --check --input-type=commonjs`).
- The prototype exposes N0–N9, T01–T18, real transition source guards, high-risk modal confirm/cancel/default focus, Escape/system-back, data normal/fallback/error, Large/Compact/Constrained, Reduce Motion, and a component-root laboratory for C1–C8.
- Primary actions use native `button` controls with CSS `min-height:56px`; the three bubble semantics simultaneously expose shape, color, and Chinese action label.
- Generation-side counts remain the authoritative pre-generation denominators in §3. Independent reverse lookup and per-item Actual/Verdict remain intentionally reserved for Stage14.

Generation verdict: completed. Independent Preview QA rerun-6 completed and its item evidence is recorded below; fresh post-record verification remains required. Device validation remains `not_performed`.


## 5. Generation per-item evidence ledger

Each row records source, stable selector, real trigger, expected, generation-observed actual, and generation verdict. Independent verdict remains Stage14-owned.

### 5.1 States and transitions

| item | source | selector | trigger | expected | actual | verdict |
|---|---|---|---|---|---|---|
| N0 | Interaction5 §11 | `#state;#scene` | select N0 | owning scene visible | render branch N0 replaces #scene | pass_independent_r6 |
| N1 | Interaction5 §11 | `#state;#scene` | select N1 | owning scene visible | render branch N1 replaces #scene | pass_independent_r6 |
| N2 | Interaction5 §11 | `#state;#scene` | select N2 | owning scene visible | render branch N2 replaces #scene | pass_independent_r6 |
| N3 | Interaction5 §11 | `#state;#scene` | select N3 | owning scene visible | render branch N3 replaces #scene | pass_independent_r6 |
| N4 | Interaction5 §11 | `#state;#scene` | select N4 | owning scene visible | render branch N4 replaces #scene | pass_independent_r6 |
| N5 | Interaction5 §11 | `#state;#scene` | select N5 | owning scene visible | render branch N5 replaces #scene | pass_independent_r6 |
| N6 | Interaction5 §11 | `#state;#scene` | select N6 | owning scene visible | render branch N6 replaces #scene | pass_independent_r6 |
| N7 | Interaction5 §11 | `#state;#scene` | select N7 | owning scene visible | render branch N7 replaces #scene | pass_independent_r6 |
| N8 | Interaction5 §11 | `#state;#scene` | select N8 | owning scene visible | render branch N8 replaces #scene | pass_independent_r6 |
| N9 | Interaction5 §11 | `#state;#scene` | select N9 | owning scene visible | render branch N9 replaces #scene | pass_independent_r6 |
| T01 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T01; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T02 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T02; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T03 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T03; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T04 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T04; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T05 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T05; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T06 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T06; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T07 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T07; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T08 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T08; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T09 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T09; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T10 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T10; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T11 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T11; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T12 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T12; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T13 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T13; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T14 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T14; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T15 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T15; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T16 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T16; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T17 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T17; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |
| T18 | Interaction5 §11.1 | `#transition;#runTransition;#scene` | select T18; run | source guard + target result | sources/guards/targets execute visible target | pass_independent_r6 |

### 5.2 Render elements

| item | source | selector | trigger | expected | actual | verdict |
|---|---|---|---|---|---|---|
| c1-title | Visual2 §9 C1 | `[data-preview-id="c1-title"]` | choose C1; Apply | component-local element visible/conditional | elements.C1 instantiates stable target | pass_independent_r6 |
| c1-ordinary | Visual2 §9 C1 | `[data-preview-id="c1-ordinary"]` | choose C1; Apply | component-local element visible/conditional | elements.C1 instantiates stable target | pass_independent_r6 |
| c1-gold | Visual2 §9 C1 | `[data-preview-id="c1-gold"]` | choose C1; Apply | component-local element visible/conditional | elements.C1 instantiates stable target | pass_independent_r6 |
| c1-gray | Visual2 §9 C1 | `[data-preview-id="c1-gray"]` | choose C1; Apply | component-local element visible/conditional | elements.C1 instantiates stable target | pass_independent_r6 |
| c1-best | Visual2 §9 C1 | `[data-preview-id="c1-best"]` | choose C1; Apply | component-local element visible/conditional | elements.C1 instantiates stable target | pass_independent_r6 |
| c1-cue | Visual2 §9 C1 | `[data-preview-id="c1-cue"]` | choose C1; Apply | component-local element visible/conditional | elements.C1 instantiates stable target | pass_independent_r6 |
| c1-primary | Visual2 §9 C1 | `[data-preview-id="c1-primary"]` | choose C1; Apply | component-local element visible/conditional | elements.C1 instantiates stable target | pass_independent_r6 |
| c2-diagram | Visual2 §9 C2 | `[data-preview-id="c2-diagram"]` | choose C2; Apply | component-local element visible/conditional | elements.C2 instantiates stable target | pass_independent_r6 |
| c2-band | Visual2 §9 C2 | `[data-preview-id="c2-band"]` | choose C2; Apply | component-local element visible/conditional | elements.C2 instantiates stable target | pass_independent_r6 |
| c2-posture | Visual2 §9 C2 | `[data-preview-id="c2-posture"]` | choose C2; Apply | component-local element visible/conditional | elements.C2 instantiates stable target | pass_independent_r6 |
| c2-input | Visual2 §9 C2 | `[data-preview-id="c2-input"]` | choose C2; Apply | component-local element visible/conditional | elements.C2 instantiates stable target | pass_independent_r6 |
| c2-sample | Visual2 §9 C2 | `[data-preview-id="c2-sample"]` | choose C2; Apply | component-local element visible/conditional | elements.C2 instantiates stable target | pass_independent_r6 |
| c2-retry | Visual2 §9 C2 | `[data-preview-id="c2-retry"]` | choose C2; Apply | component-local element visible/conditional | elements.C2 instantiates stable target | pass_independent_r6 |
| c2-confirm | Visual2 §9 C2 | `[data-preview-id="c2-confirm"]` | choose C2; Apply | component-local element visible/conditional | elements.C2 instantiates stable target | pass_independent_r6 |
| c3-title | Visual2 §9 C3 | `[data-preview-id="c3-title"]` | choose C3; Apply | component-local element visible/conditional | elements.C3 instantiates stable target | pass_independent_r6 |
| c3-summary | Visual2 §9 C3 | `[data-preview-id="c3-summary"]` | choose C3; Apply | component-local element visible/conditional | elements.C3 instantiates stable target | pass_independent_r6 |
| c3-input | Visual2 §9 C3 | `[data-preview-id="c3-input"]` | choose C3; Apply | component-local element visible/conditional | elements.C3 instantiates stable target | pass_independent_r6 |
| c3-status | Visual2 §9 C3 | `[data-preview-id="c3-status"]` | choose C3; Apply | component-local element visible/conditional | elements.C3 instantiates stable target | pass_independent_r6 |
| c3-cancel | Visual2 §9 C3 | `[data-preview-id="c3-cancel"]` | choose C3; Apply | component-local element visible/conditional | elements.C3 instantiates stable target | pass_independent_r6 |
| c3-enter | Visual2 §9 C3 | `[data-preview-id="c3-enter"]` | choose C3; Apply | component-local element visible/conditional | elements.C3 instantiates stable target | pass_independent_r6 |
| c4-contour | Visual2 §9 C4 | `[data-preview-id="c4-contour"]` | choose C4; Apply | component-local element visible/conditional | elements.C4 instantiates stable target | pass_independent_r6 |
| c4-band | Visual2 §9 C4 | `[data-preview-id="c4-band"]` | choose C4; Apply | component-local element visible/conditional | elements.C4 instantiates stable target | pass_independent_r6 |
| c4-forward | Visual2 §9 C4 | `[data-preview-id="c4-forward"]` | choose C4; Apply | component-local element visible/conditional | elements.C4 instantiates stable target | pass_independent_r6 |
| c4-invalid | Visual2 §9 C4 | `[data-preview-id="c4-invalid"]` | choose C4; Apply | component-local element visible/conditional | elements.C4 instantiates stable target | pass_independent_r6 |
| c5-shell | Visual2 §9 C5 | `[data-preview-id="c5-shell"]` | choose C5; Apply | component-local element visible/conditional | elements.C5 instantiates stable target | pass_independent_r6 |
| c5-verb | Visual2 §9 C5 | `[data-preview-id="c5-verb"]` | choose C5; Apply | component-local element visible/conditional | elements.C5 instantiates stable target | pass_independent_r6 |
| c5-proximity | Visual2 §9 C5 | `[data-preview-id="c5-proximity"]` | choose C5; Apply | component-local element visible/conditional | elements.C5 instantiates stable target | pass_independent_r6 |
| c5-verdict | Visual2 §9 C5 | `[data-preview-id="c5-verdict"]` | choose C5; Apply | component-local element visible/conditional | elements.C5 instantiates stable target | pass_independent_r6 |
| c5-tail | Visual2 §9 C5 | `[data-preview-id="c5-tail"]` | choose C5; Apply | component-local element visible/conditional | elements.C5 instantiates stable target | pass_independent_r6 |
| c6-time | Visual2 §9 C6 | `[data-preview-id="c6-time"]` | choose C6; Apply | component-local element visible/conditional | elements.C6 instantiates stable target | pass_independent_r6 |
| c6-segment | Visual2 §9 C6 | `[data-preview-id="c6-segment"]` | choose C6; Apply | component-local element visible/conditional | elements.C6 instantiates stable target | pass_independent_r6 |
| c6-input | Visual2 §9 C6 | `[data-preview-id="c6-input"]` | choose C6; Apply | component-local element visible/conditional | elements.C6 instantiates stable target | pass_independent_r6 |
| c6-pause | Visual2 §9 C6 | `[data-preview-id="c6-pause"]` | choose C6; Apply | component-local element visible/conditional | elements.C6 instantiates stable target | pass_independent_r6 |
| c6-settle | Visual2 §9 C6 | `[data-preview-id="c6-settle"]` | choose C6; Apply | component-local element visible/conditional | elements.C6 instantiates stable target | pass_independent_r6 |
| c7-title | Visual2 §9 C7 | `[data-preview-id="c7-title"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-proof | Visual2 §9 C7 | `[data-preview-id="c7-proof"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-input | Visual2 §9 C7 | `[data-preview-id="c7-input"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-resume | Visual2 §9 C7 | `[data-preview-id="c7-resume"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-switch | Visual2 §9 C7 | `[data-preview-id="c7-switch"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-calibrate | Visual2 §9 C7 | `[data-preview-id="c7-calibrate"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-exit | Visual2 §9 C7 | `[data-preview-id="c7-exit"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-confirm-copy | Visual2 §9 C7 | `[data-preview-id="c7-confirm-copy"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-cancel | Visual2 §9 C7 | `[data-preview-id="c7-cancel"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c7-discard | Visual2 §9 C7 | `[data-preview-id="c7-discard"]` | choose C7; Apply | component-local element visible/conditional | elements.C7 instantiates stable target | pass_independent_r6 |
| c8-accuracy | Visual2 §9 C8 | `[data-preview-id="c8-accuracy"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-badge | Visual2 §9 C8 | `[data-preview-id="c8-badge"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-score | Visual2 §9 C8 | `[data-preview-id="c8-score"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-ordinary | Visual2 §9 C8 | `[data-preview-id="c8-ordinary"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-gold | Visual2 §9 C8 | `[data-preview-id="c8-gold"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-gray | Visual2 §9 C8 | `[data-preview-id="c8-gray"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-best | Visual2 §9 C8 | `[data-preview-id="c8-best"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-replay | Visual2 §9 C8 | `[data-preview-id="c8-replay"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-home | Visual2 §9 C8 | `[data-preview-id="c8-home"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |
| c8-save-retry | Visual2 §9 C8 | `[data-preview-id="c8-save-retry"]` | choose C8; Apply | component-local element visible/conditional | elements.C8 instantiates stable target | pass_independent_r6 |

### 5.3 Data bindings

| item | source | selector | trigger | expected | actual | verdict |
|---|---|---|---|---|---|---|
| lesson.step#1 | Visual2 §9 C1 | `#binding option[value="0"];[data-preview-id]` | choose binding; switch dataMode | c1-title text + active seal; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| lesson.acknowledgedKinds.*#2 | Visual2 §9 C1 | `#binding option[value="1"];[data-preview-id]` | choose binding; switch dataMode | seal selected; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| bestMark.readState#3 | Visual2 §9 C1 | `#binding option[value="2"];[data-preview-id]` | choose binding; switch dataMode | c1-best label/shape; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| bestMark.value#4 | Visual2 §9 C1 | `#binding option[value="3"];[data-preview-id]` | choose binding; switch dataMode | c1-best value; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| lesson.validationMessage#5 | Visual2 §9 C1 | `#binding option[value="4"];[data-preview-id]` | choose binding; switch dataMode | c1-cue text; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| lesson.primaryAction#6 | Visual2 §9 C1 | `#binding option[value="5"];[data-preview-id]` | choose binding; switch dataMode | c1-primary label/enabled; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.posture#7 | Visual2 §9 C2 | `#binding option[value="6"];[data-preview-id]` | choose binding; switch dataMode | c2-posture selected; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.envelope#8 | Visual2 §9 C2 | `#binding option[value="7"];[data-preview-id]` | choose binding; switch dataMode | c2-diagram path; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.bandPose#9 | Visual2 §9 C2 | `#binding option[value="8"];[data-preview-id]` | choose binding; switch dataMode | c2-band geometry; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.calRev#10 | Visual2 §9 C2 | `#binding option[value="9"];[data-preview-id]` | choose binding; switch dataMode | confirm caption; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| inputLease.source/armed#11 | Visual2 §9 C2 | `#binding option[value="10"];[data-preview-id]` | choose binding; switch dataMode | c2-input; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| pose.sampleState#12 | Visual2 §9 C2 | `#binding option[value="11"];[data-preview-id]` | choose binding; switch dataMode | c2-sample; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.canAccept#13 | Visual2 §9 C2 | `#binding option[value="12"];[data-preview-id]` | choose binding; switch dataMode | c2-confirm enabled; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.calRev#14 | Visual2 §9 C3 | `#binding option[value="13"];[data-preview-id]` | choose binding; switch dataMode | c3-summary; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.posture#15 | Visual2 §9 C3 | `#binding option[value="14"];[data-preview-id]` | choose binding; switch dataMode | c3-summary; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| inputLease.source/armed#16 | Visual2 §9 C3 | `#binding option[value="15"];[data-preview-id]` | choose binding; switch dataMode | c3-input; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| stage.canOpen#17 | Visual2 §9 C3 | `#binding option[value="16"];[data-preview-id]` | choose binding; switch dataMode | c3-enter enabled; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| stage.openState#18 | Visual2 §9 C3 | `#binding option[value="17"];[data-preview-id]` | choose binding; switch dataMode | c3-status; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.envelope#19 | Visual2 §9 C4 | `#binding option[value="18"];[data-preview-id]` | choose binding; switch dataMode | c4-contour vertices; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.bandPose#20 | Visual2 §9 C4 | `#binding option[value="19"];[data-preview-id]` | choose binding; switch dataMode | c4-band transform; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.calRev#21 | Visual2 §9 C4 | `#binding option[value="20"];[data-preview-id]` | choose binding; switch dataMode | geometry ownership; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.forwardAxis#22 | Visual2 §9 C4 | `#binding option[value="21"];[data-preview-id]` | choose binding; switch dataMode | c4-forward orientation; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| arrivalSeed.eligibility/pose#23 | Visual2 §9 C4 | `#binding option[value="22"];[data-preview-id]` | choose binding; switch dataMode | admitted glint; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| freezeSeal.state#24 | Visual2 §9 C4 | `#binding option[value="23"];[data-preview-id]` | choose binding; switch dataMode | c4 frozen style; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| arrivalSeed.pose/eligibility#25 | Visual2 §9 C5 | `#binding option[value="24"];[data-preview-id]` | choose binding; switch dataMode | actor acquire; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| driftActor.kind#26 | Visual2 §9 C5 | `#binding option[value="25"];[data-preview-id]` | choose binding; switch dataMode | shell/verb; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| driftActor.lifecycle#27 | Visual2 §9 C5 | `#binding option[value="26"];[data-preview-id]` | choose binding; switch dataMode | visibility/collider; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| driftActor.transform#28 | Visual2 §9 C5 | `#binding option[value="27"];[data-preview-id]` | choose binding; switch dataMode | world transform; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| driftActor.bandPhase#29 | Visual2 §9 C5 | `#binding option[value="28"];[data-preview-id]` | choose binding; switch dataMode | proximity/eligibility; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| driftActor.velocity#30 | Visual2 §9 C5 | `#binding option[value="29"];[data-preview-id]` | choose binding; switch dataMode | tail direction; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| ruleVerdict.result#31 | Visual2 §9 C5 | `#binding option[value="30"];[data-preview-id]` | choose binding; switch dataMode | verdict label; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionClock.remaining#32 | Visual2 §9 C6 | `#binding option[value="31"];[data-preview-id]` | choose binding; switch dataMode | c6-time mm:ss; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| segmentRecipe.index#33 | Visual2 §9 C6 | `#binding option[value="32"];[data-preview-id]` | choose binding; switch dataMode | c6-segment; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| segmentRecipe.themeLabel#34 | Visual2 §9 C6 | `#binding option[value="33"];[data-preview-id]` | choose binding; switch dataMode | segment secondary; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| inputLease.source/armed#35 | Visual2 §9 C6 | `#binding option[value="34"];[data-preview-id]` | choose binding; switch dataMode | c6-input; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| run.canPause#36 | Visual2 §9 C6 | `#binding option[value="35"];[data-preview-id]` | choose binding; switch dataMode | c6-pause enabled; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.completeness#37 | Visual2 §9 C6 | `#binding option[value="36"];[data-preview-id]` | choose binding; switch dataMode | c6-settle; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| freezeSeal.reason/state#38 | Visual2 §9 C7 | `#binding option[value="37"];[data-preview-id]` | choose binding; switch dataMode | c7-title; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| freezeSeal.integrity#39 | Visual2 §9 C7 | `#binding option[value="38"];[data-preview-id]` | choose binding; switch dataMode | c7-proof checks; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| freezeSeal.canResume#40 | Visual2 §9 C7 | `#binding option[value="39"];[data-preview-id]` | choose binding; switch dataMode | c7-resume enabled; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| inputLease.source/armed#41 | Visual2 §9 C7 | `#binding option[value="40"];[data-preview-id]` | choose binding; switch dataMode | c7-input; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| inputLease.availableSources#42 | Visual2 §9 C7 | `#binding option[value="41"];[data-preview-id]` | choose binding; switch dataMode | c7-switch choices; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| sessionEnvelope.calRev#43 | Visual2 §9 C7 | `#binding option[value="42"];[data-preview-id]` | choose binding; switch dataMode | recalibrate context; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| run.active#44 | Visual2 §9 C7 | `#binding option[value="43"];[data-preview-id]` | choose binding; switch dataMode | c7-exit visibility; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| run.discardState#45 | Visual2 §9 C7 | `#binding option[value="44"];[data-preview-id]` | choose binding; switch dataMode | nested confirm/error; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.completeness#46 | Visual2 §9 C8 | `#binding option[value="45"];[data-preview-id]` | choose binding; switch dataMode | whole result eligibility; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.accuracy#47 | Visual2 §9 C8 | `#binding option[value="46"];[data-preview-id]` | choose binding; switch dataMode | c8-accuracy; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.badge#48 | Visual2 §9 C8 | `#binding option[value="47"];[data-preview-id]` | choose binding; switch dataMode | c8-badge; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.score#49 | Visual2 §9 C8 | `#binding option[value="48"];[data-preview-id]` | choose binding; switch dataMode | c8-score; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.categories.ordinary#50 | Visual2 §9 C8 | `#binding option[value="49"];[data-preview-id]` | choose binding; switch dataMode | c8-ordinary; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.categories.gold#51 | Visual2 §9 C8 | `#binding option[value="50"];[data-preview-id]` | choose binding; switch dataMode | c8-gold; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| runTally.categories.gray#52 | Visual2 §9 C8 | `#binding option[value="51"];[data-preview-id]` | choose binding; switch dataMode | c8-gray; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| bestMark.value#53 | Visual2 §9 C8 | `#binding option[value="52"];[data-preview-id]` | choose binding; switch dataMode | c8-best; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |
| bestMark.writeState#54 | Visual2 §9 C8 | `#binding option[value="53"];[data-preview-id]` | choose binding; switch dataMode | c8-best/retry; normal/fallback/error conversion | bindingSpecs maps owning target; highlight/copy/disable changes | pass_independent_r6 |

### 5.4 Variants, states and precedence

| item | source | selector | trigger | expected | actual | verdict |
|---|---|---|---|---|---|---|
| C1.variant.overview | Visual2 §9 C1 | `#variant;#componentDemo[data-component="C1"]` | choose overview; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.variant.guided-step | Visual2 §9 C1 | `#variant;#componentDemo[data-component="C1"]` | choose guided-step; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.variant.recall-complete | Visual2 §9 C1 | `#variant;#componentDemo[data-component="C1"]` | choose recall-complete; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.default | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose default; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.focused | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose focused; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.selected | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose selected; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.disabled | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose disabled; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.loading | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose loading; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.empty | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose empty; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.error | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.state.overflow | Visual2 §9 C1 | `#componentState;#componentDemo[data-component="C1"]` | choose overflow; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C1.stack.error>disabled>focused>selected>default | Visual2 §9 C1 | `#stack;#componentDemo[data-component="C1"]` | choose error>disabled>focused>selected>default; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.variant.seated | Visual2 §9 C2 | `#variant;#componentDemo[data-component="C2"]` | choose seated; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.variant.standing | Visual2 §9 C2 | `#variant;#componentDemo[data-component="C2"]` | choose standing; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.variant.controller-conservative | Visual2 §9 C2 | `#variant;#componentDemo[data-component="C2"]` | choose controller-conservative; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.variant.recalibration | Visual2 §9 C2 | `#variant;#componentDemo[data-component="C2"]` | choose recalibration; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.default | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose default; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.focused | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose focused; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.sampling | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose sampling; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.selected | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose selected; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.boundary-disabled | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose boundary-disabled; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.stale | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose stale; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.error | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.state.overflow | Visual2 §9 C2 | `#componentState;#componentDemo[data-component="C2"]` | choose overflow; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C2.stack.error>boundary-disabled>stale>focused>selected>sampling>default | Visual2 §9 C2 | `#stack;#componentDemo[data-component="C2"]` | choose error>boundary-disabled>stale>focused>selected>sampling>default; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.variant.ready | Visual2 §9 C3 | `#variant;#componentDemo[data-component="C3"]` | choose ready; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.variant.prerequisite-blocked | Visual2 §9 C3 | `#variant;#componentDemo[data-component="C3"]` | choose prerequisite-blocked; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.variant.open-retry | Visual2 §9 C3 | `#variant;#componentDemo[data-component="C3"]` | choose open-retry; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.state.default | Visual2 §9 C3 | `#componentState;#componentDemo[data-component="C3"]` | choose default; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.state.focused | Visual2 §9 C3 | `#componentState;#componentDemo[data-component="C3"]` | choose focused; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.state.pressed | Visual2 §9 C3 | `#componentState;#componentDemo[data-component="C3"]` | choose pressed; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.state.disabled | Visual2 §9 C3 | `#componentState;#componentDemo[data-component="C3"]` | choose disabled; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.state.loading | Visual2 §9 C3 | `#componentState;#componentDemo[data-component="C3"]` | choose loading; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.state.error | Visual2 §9 C3 | `#componentState;#componentDemo[data-component="C3"]` | choose error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.state.overflow | Visual2 §9 C3 | `#componentState;#componentDemo[data-component="C3"]` | choose overflow; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C3.stack.error>loading>disabled>focused>pressed>default | Visual2 §9 C3 | `#stack;#componentDemo[data-component="C3"]` | choose error>loading>disabled>focused>pressed>default; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.variant.tutorial | Visual2 §9 C4 | `#variant;#componentDemo[data-component="C4"]` | choose tutorial; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.variant.play | Visual2 §9 C4 | `#variant;#componentDemo[data-component="C4"]` | choose play; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.variant.reduced-envelope | Visual2 §9 C4 | `#variant;#componentDemo[data-component="C4"]` | choose reduced-envelope; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.variant.reduce-motion | Visual2 §9 C4 | `#variant;#componentDemo[data-component="C4"]` | choose reduce-motion; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.loading | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose loading; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.ready | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose ready; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.actor-eligible | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose actor-eligible; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.frozen | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose frozen; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.stale | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose stale; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.error | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.empty | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose empty; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.state.overflow | Visual2 §9 C4 | `#componentState;#componentDemo[data-component="C4"]` | choose overflow; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C4.stack.error>stale>frozen>actor-eligible>ready>empty/loading | Visual2 §9 C4 | `#stack;#componentDemo[data-component="C4"]` | choose error>stale>frozen>actor-eligible>ready>empty/loading; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.variant.ordinary | Visual2 §9 C5 | `#variant;#componentDemo[data-component="C5"]` | choose ordinary; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.variant.gold | Visual2 §9 C5 | `#variant;#componentDemo[data-component="C5"]` | choose gold; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.variant.gray | Visual2 §9 C5 | `#variant;#componentDemo[data-component="C5"]` | choose gray; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.variant.tutorial | Visual2 §9 C5 | `#variant;#componentDemo[data-component="C5"]` | choose tutorial; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.variant.pooled-performance | Visual2 §9 C5 | `#variant;#componentDemo[data-component="C5"]` | choose pooled-performance; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.pooled | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose pooled; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.approaching | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose approaching; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.eligible | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose eligible; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.hold-progress | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose hold-progress; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.frozen | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose frozen; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.terminal-success | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose terminal-success; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.terminal-error | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose terminal-error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.state.out-of-bounds | Visual2 §9 C5 | `#componentState;#componentDemo[data-component="C5"]` | choose out-of-bounds; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C5.stack.OOB/pooled>terminal-error>terminal-success>frozen>hold>eligible>approaching | Visual2 §9 C5 | `#stack;#componentDemo[data-component="C5"]` | choose OOB/pooled>terminal-error>terminal-success>frozen>hold>eligible>approaching; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.variant.tutorial | Visual2 §9 C6 | `#variant;#componentDemo[data-component="C6"]` | choose tutorial; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.variant.recipe | Visual2 §9 C6 | `#variant;#componentDemo[data-component="C6"]` | choose recipe; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.variant.settling | Visual2 §9 C6 | `#variant;#componentDemo[data-component="C6"]` | choose settling; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.variant.reduce-motion | Visual2 §9 C6 | `#variant;#componentDemo[data-component="C6"]` | choose reduce-motion; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.default | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose default; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.focused | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose focused; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.pressed | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose pressed; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.boundary | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose boundary; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.input-none | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose input-none; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.frozen | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose frozen; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.settling | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose settling; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.state.error | Visual2 §9 C6 | `#componentState;#componentDemo[data-component="C6"]` | choose error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C6.stack.error>settling>frozen>input-none>boundary>focused>pressed>default | Visual2 §9 C6 | `#stack;#componentDemo[data-component="C6"]` | choose error>settling>frozen>input-none>boundary>focused>pressed>default; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.variant.manual-pause | Visual2 §9 C7 | `#variant;#componentDemo[data-component="C7"]` | choose manual-pause; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.variant.input-loss | Visual2 §9 C7 | `#variant;#componentDemo[data-component="C7"]` | choose input-loss; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.variant.pose-drift | Visual2 §9 C7 | `#variant;#componentDemo[data-component="C7"]` | choose pose-drift; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.variant.invalid-seal | Visual2 §9 C7 | `#variant;#componentDemo[data-component="C7"]` | choose invalid-seal; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.variant.exit-confirm | Visual2 §9 C7 | `#variant;#componentDemo[data-component="C7"]` | choose exit-confirm; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.loading | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose loading; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.valid | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose valid; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.input-wait | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose input-wait; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.boundary-disabled | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose boundary-disabled; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.focused | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose focused; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.exit-confirm | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose exit-confirm; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.error | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.state.overflow | Visual2 §9 C7 | `#componentState;#componentDemo[data-component="C7"]` | choose overflow; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C7.stack.error>exit-confirm>boundary-disabled>input-wait>focused>valid>loading | Visual2 §9 C7 | `#stack;#componentDemo[data-component="C7"]` | choose error>exit-confirm>boundary-disabled>input-wait>focused>valid>loading; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.variant.complete-bronze/silver/gold | Visual2 §9 C8 | `#variant;#componentDemo[data-component="C8"]` | choose complete-bronze/silver/gold; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.variant.complete-no-badge | Visual2 §9 C8 | `#variant;#componentDemo[data-component="C8"]` | choose complete-no-badge; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.variant.partial | Visual2 §9 C8 | `#variant;#componentDemo[data-component="C8"]` | choose partial; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.variant.save-failed | Visual2 §9 C8 | `#variant;#componentDemo[data-component="C8"]` | choose save-failed; Apply | component-local variant behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.loading | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose loading; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.complete | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose complete; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.focused | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose focused; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.empty | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose empty; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.partial | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose partial; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.save-loading | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose save-loading; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.save-error | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose save-error; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.state.overflow | Visual2 §9 C8 | `#componentState;#componentDemo[data-component="C8"]` | choose overflow; Apply | component-local state behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |
| C8.stack.partial/error>empty>save-error>save-loading>focused>complete>loading | Visual2 §9 C8 | `#stack;#componentDemo[data-component="C8"]` | choose partial/error>empty>save-error>save-loading>focused>complete>loading; Apply | component-local stack behavior | root data + anatomy/semantic/action mutation; winner visible | pass_independent_r6 |

### 5.5 Responsive and motion

| item | source | selector | trigger | expected | actual | verdict |
|---|---|---|---|---|---|---|
| Large | Interaction5 §10 | `#tier;#window.large` | choose Large | 1200/default multi-column | large class, three-column seals | pass_independent_r6 |
| Compact | Interaction5 §10 | `#tier;#window.compact` | choose Compact | 960 stack/wrap | compact class, column and seal reflow | pass_independent_r6 |
| Constrained | Interaction5 §10 | `#tier;#window.constrained` | choose Constrained | 760 single column/sticky action | constrained class, single columns and sticky actions | pass_independent_r6 |
| Reduce Motion | Interaction5 §16 | `#rm;body.reduced;.bubble` | toggle RM | bob stops, semantics remain | animation none; shape/color/Chinese labels unchanged | pass_independent_r6 |
