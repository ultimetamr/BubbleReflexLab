# 用户研究报告 · BubbleReflexLab v3

> revision: 2 · role: `research_analyst` · stage: research + CR-01 source mapping · sources newly observed 2026-08-13 · original prompt P0 in Trace2 · v1/v2 excluded

## 1. Research questions and method

- Questions: How does PICO distinguish Shared/Full Space and Stage? Which input/fallback claims are safe? What do adjacent XR reaction games teach at the opportunity layer? What user, comfort and timing evidence remains unknown?
- Method: original-prompt analysis; fresh review of PICO official docs; fresh first-party competitor-page benchmark. No user interview, hands-on headset session, analytics, or device test was performed.
- Sample: three adjacent commercial XR rhythm/action products; one prompt-defined provisional user group. This is not market-share or usability evidence.

## 2. Five-category evidence register

| ID | category | evidence or explicit gap | source / type | scope | confidence | observed | validation plan |
|---|---|---|---|---|---|---|---|
| E01 | market | Fast incoming targets, music synchronization and body movement are common adjacent-category propositions; they do not establish suitability for this gentle game. | Beat Saber PlayStation page; Synth Riders official; OhShape official / official | adjacent XR products | high for described features | 2026-08-13 | hands-on comparison before commercial positioning |
| E02 | market | Evidence gap: no reliable current market-size, retention, price or Chinese-audience adoption data was collected. | none / assumption | business opportunity | low | 2026-08-13 | product research, store analytics, interviews |
| E03 | user | The prompt explicitly requires Chinese, three rules, gentle pressure, no large dodge, seated/standing calibration, recovery and three-minute duration. | original prompt / user_supplied | intended product | high | 2026-08-13 | confirm with requester and acceptance test |
| E04 | user | Evidence gap: age, XR expertise, accessibility distribution, handedness, room size, reach and motion sensitivity are unknown. | none / assumption | target users | low | 2026-08-13 | recruit novice/experienced, seated/standing and limited-reach users |
| E05 | domain | Slap, grab and inhibition require mutually exclusive intent classification and exactly-once terminal judgment; this is a project domain model derived from requirements, not a platform guarantee. | original prompt / user_supplied | game logic | high | 2026-08-13 | deterministic unit/state tests downstream |
| E06 | domain | Evidence gap: no measured input thresholds, allowed grace duration, spawn speed or badge thresholds exist. | none / assumption | tuning | low | 2026-08-13 | prototype telemetry + device playtest |
| E07 | platform | PICO OS 6 exposes WindowContainer and Stage; showing Stage enters Full Space, while WindowContainer is manageable and can be Planar or Volumetric. | https://developer.picoxr.com/document/discover/pico-os-6-overview/ / official | PICO OS 6 spatial apps | high | 2026-08-13 | recheck installed SDK/version downstream |
| E08 | platform | Stage is a boundless container with a unique id; when opened, other apps’ windows are hidden. | https://developer.picoxr.com/spatial-api/0.12.2/spatialui/foundation/com.pico.spatial.ui.foundation.dsl/-stage.html / official | API 0.12.2 page | high | 2026-08-13 | verify current 0.13.x API before implementation |
| E09 | platform | PICO describes gaze/gesture, controllers and keyboard/mouse as input families, but this does not prove automatic fallback in this app. | https://developer.picoxr.com/ / official | platform positioning | medium | 2026-08-13 | verify actual Spatial SDK input APIs/device behavior |
| E10 | platform | Official resources observed on 2026-08-13 list Spatial SDK 0.13.x, Android Studio 2025.1.x, Project Swan and PICO Emulator. | https://developer.picoxr.com/resources/ / official | environment snapshot | high | 2026-08-13 | environment doctor downstream |
| E11 | safety | The user explicitly prohibits rear/near-overhead/below-floor spawns, large dodges and high-speed pressure; these are binding product constraints. | original prompt / user_supplied | all game states | high | 2026-08-13 | spawn invariant and short device run |
| E12 | safety | PICO emulator documentation says its configured rendering FOV is not device physical FOV; emulator screenshots cannot validate headset comfort. | https://developer.picoxr.com/document/spatial-toolkit/pico-emulator-ui/ / official | emulator evidence boundary | high | 2026-08-13 | device validation after implementation |
| E13 | safety | Evidence gap: no device-measured comfortable reach band, fatigue threshold, collision false-positive rate or motion sickness data exists for this product. | none / assumption | comfort/safety | low | 2026-08-13 | seated/standing device study; stop criteria |

Source conflict handling: API page E08 is version 0.12.2 while resources E10 lists 0.13.x. The container concept is evidence; concrete signatures remain a downstream version check, not a frozen implementation claim.

## 3. Competitive benchmark

| # | product / platform | functional needs | interaction experience | visual experience (observation only) | spatial capability usage | source |
|---|---|---|---|---|---|---|
| B1 | Beat Saber / VR, PlayStation page | colored/directional beats, scoring, music packs, modifiers; fast flow and obstacle avoidance; not designed around three gentle semantic actions | two controllers/sabers; rapid slash and body dodge; quick to understand but speed and direction load rise | neon, high contrast, forward stream, spectacle; readable targets but intentionally intense | direction, approach depth, bilateral hands, whole body and wide lanes; no evidence of seated gentle inhibition | https://www.playstation.com/en-us/games/beat-saber/ · official · observed 2026-08-13 |
| B2 | Synth Riders / VR | official homepage supports freestyle-dance rhythm positioning, music catalog, multiplayer/modes and fitness; it is not evidence for this product’s three-minute calm need | official MR update supports catch notes, ride rails and avoid obstacles in MR; the “continuous choreography” interpretation is bounded to those described mechanics | homepage supports music/visual experience framing; “dense synchronized flow” is an analyst observation, not a copied style fact | MR update supports room-as-stage, notes/rails/obstacles; homepage supports music synchronization/genre framing | Mechanics/MR: https://synthridersvr.com/synth-riders-mixed-reality-update/ ; genre/music/modes/fitness: https://synthridersvr.com/ · official · observed 2026-08-13 |
| B3 | OhShape / VR incl. PICO | punch, dodge and pose through walls, difficulty modes, fitness; full-body demand differs materially | full-body pose/punch/dodge; direct silhouette metaphor but larger motion cost | large wall silhouettes dominate view; strong immediate action cue, potential occlusion/body-pressure for this brief | body scale and spatial walls are essential; directly conflicts with “no large dodge” | https://ohshapevr.com/ · official · observed 2026-08-13 |

### 3.1 Absorb / avoid

| product | absorb at requirement/opportunity level | avoid |
|---|---|---|
| Beat Saber | targets readable before arrival; immediate success feedback; learnable action mapping | tempo escalation, directional cuts, lanes, neon tunnel, crouch/side-step obstacles |
| Synth Riders | predictable approach and musical layering; stable hand-to-category relationship | rails, continuous choreography, crowded tracks, BPM-driven pressure |
| OhShape | shape as a redundant semantic channel; unmistakable inhibition object | full-screen walls, pose matching, body dodges, fitness framing, occlusion |

### 3.2 Differentiation opportunities

1. Replace the genre’s “track coming at you” with a **quiet forward arrival field** whose targets emerge only from a calibrated fan and settle toward a fixed hand-height interaction band.
2. Make inhibition a genuine third action: gray success comes from stillness and untouched passage, not body avoidance.
3. Use sound as a soft 30-second layer boundary, never as a tempo command; difficulty changes through recipe and spacing.
4. Offer an explicit recovery contract: transient input loss freezes judgment, pause freezes the entire actor/clock set, controller fallback is visible and arbitrated.
5. Preserve one-glance distinction through Chinese verb + silhouette + material behavior, without copying competitor colors, tracks, walls, state sequences or components.

Sample size=3, all adjacent XR products and all first-party pages. Gaps: no comparative measured comfort, onboarding time, error rate, accessibility or Chinese localization quality. Absorption boundary: opportunity only; no layout/state/component/visual reuse.

## 4. Domain model

### 4.1 Workflow

1. Establish safe session: choose posture → calibrate forward generation fan and fixed hand band → explicitly accept.
2. Learn vocabulary: one slow ordinary → one slow gold → one slow gray, each with a short cue and no overlap.
3. Run five recipes: every 30s select next recipe and soft theme/audio layer atomically; preserve gentle speed ceiling.
4. Judge an actor: validate pose/lifecycle → arm one input source → recognize slap/grab/contact/no-contact passage → commit one terminal outcome.
5. Recover: transient input loss starts grace freeze; persistent loss shows pause/recovery; manual pause/recalibration freezes world and clock.
6. Settle: reconcile category ledger → calculate accuracy/badge/score only from complete events → attempt local best save → report truthfully.

### 4.2 Decision variables

| variable | affects | unsafe/invalid response |
|---|---|---|
| calibrated posture/reach | fan height, interaction-band center | block start / recalibrate |
| spawn azimuth/elevation/radius | actor eligibility | reject seed before visible |
| actor type | expected action | unknown type returns to pool |
| time-to-band / crossed-band | timing and gray success | no premature terminal judgment |
| input source/confidence/continuity | arming and grace freeze | disarm/freeze, never double count |
| contact profile / grip state | slap vs grab | ambiguous input yields no judgment |
| recipe index / active count / spacing | difficulty | cap density; do not raise speed pressure |
| world freeze token | pause invariant | all movement/spawn/clock/judgment frozen |
| ledger completeness | score/badge/save eligibility | show incomplete, do not fabricate |

### 4.3 Data entities and timeliness

| entity | meaning | freshness | owner / trust rule |
|---|---|---|---|
| SessionEnvelope | posture, calibration revision, state | session / on recalibration | invalid revision blocks spawn |
| ArrivalSeed | type, safe pose, recipe, spawn time | per spawn | validate before actor acquire |
| DriftActor | pooled lifecycle, transform, band crossing | frame/event | one owner; one terminal return |
| InputLease | source, confidence, armed, loss timestamp | frame/event | one active source only |
| RuleVerdict | expected action, observed action, result | terminal event | immutable once committed |
| SegmentRecipe | 30s segment, mix, count, spacing, layers | segment boundary | fixed six-entry table |
| FreezeSeal | clock/actor/spawn/judgment snapshot | pause/input loss | atomic invariant |
| RunTally | correct/eligible totals by category, score, badge | terminal events / settlement | incomplete flag prevents award |
| BestMark | local best value and write state | settlement / persistent | visible save failure; retain run result |

### 4.4 Specialized risks and anti-patterns

- Spawn teleportation, rear cues, low-floor actors, face-near appearance, above-head reach.
- Gray represented as an obstacle wall or requiring torso movement.
- Theme changes coupled to speed, flashing or escalating loudness.
- Multiple actors visually merging; target ambiguity at the interaction band.
- Hand loss counted as miss; controller and hand both armed; pause clock frozen but actors still drift.
- Pool return twice, stale collider remaining active, out-of-bounds actors leaking.
- Accuracy denominator mixing gray avoidance with action attempts without explicit eligibility.
- False “saved” or best-score claim after storage failure.

### 4.5 User mental model

The intended mental model is not “dance to a track” but “watch the calm front field, read one verb, respond only when it arrives at hand height.” Three stable pairings: round/拍, precious/抓, quiet-blocked/别碰. Timing is forgiving; not acting can be the correct action.

## 5. User evidence, provisional persona and journey

### 5.1 Evidence status

No interviews exist. The following is a **prompt-derived proto-persona**, not an observed demographic persona.

| dimension | bounded content |
|---|---|
| identity | Chinese-speaking solo player; age/occupation unknown |
| XR expertise | unknown; design must support novice comprehension |
| scenario | indoor, seated or standing, one three-minute run |
| goal | enjoy a clear, low-pressure reaction challenge |
| frustration to avoid | unexpected direction, rapid pressure, confusing bubble categories, unfair loss during tracking interruption |
| accessibility | color-only distinction prohibited by requirement intent; reach/mobility needs unknown |
| verbatim source | “普通泡泡拍破，金色泡泡抓住，灰色泡泡不要触碰。” — original prompt |

### 5.2 Requirement-derived journey

| phase | enter | calibrate | learn | play | pause/recover | settle/exit |
|---|---|---|---|---|---|---|
| goal | understand three rules | make hand zone comfortable | succeed once per type | maintain calm accuracy | avoid unfair loss | understand outcome/save |
| action | read and start | choose posture/reach | slap, grab, refrain | respond to mixtures | resume/recalibrate/exit | inspect stats, replay/home |
| space | Shared window | Full Stage | Full Stage | Full Stage | Full Stage overlay/state | Shared window after Stage close or in-app result, decided later |
| likely emotion | curious | cautious | reassured | focused | potentially frustrated | satisfied/clear |
| evidence | prompt | prompt | prompt | prompt | prompt | prompt |
| opportunity | three-rule compression | visual preview of fan/band | one actor only | recipe not speed | atomic freeze and visible reason | truthful category ledger |

Emotional low point hypothesis: input loss or calibration mismatch producing an unfair miss. Confidence low until testing; prioritize recovery visibility.

## 6. Key findings

| ID | finding | evidence | confidence | downstream implication |
|---|---|---|---|---|
| F01 | Full Space Stage is justified only for direction/distance/body interaction; entry must be explicit | E07/E08 + prompt | high | Shared launch → explicit Stage |
| F02 | Competitor readability may be absorbed, but track/wall/fitness pressure conflicts with the brief | B1–B3 | high | derive a quiet arrival field independently |
| F03 | No-touch is an inhibition judgment, not a dodge task | prompt, B3 contrast | high | crossing event closes gray success |
| F04 | Input fallback is a product requirement but automatic Spatial SDK behavior is unverified | E09, E10 | medium | visible single-source lease; downstream verification |
| F05 | User comfort values and gesture thresholds are absent | E04/E06/E13 | low | explicit assumptions and device study |
| F06 | Emulator cannot prove physical FOV/comfort | E12 | high | preview/device boundary must remain explicit |

## 7. Posture, FOV, interaction and duration gaps

| topic | current evidence | usable constraint | gap / validation |
|---|---|---|---|
| posture | prompt requires calibration and no large dodge | support seated + standing; no locomotion | distribution and reach unknown; device test |
| arm range | no measured source | derive no universal meters as fact | calibrate per user; measure downstream |
| central FOV | emulator page warns virtual FOV ≠ physical FOV | keep primary target front and avoid rear dependence | device visibility test |
| gaze/pinch hit rate | none | do not assert a percentage | usability test |
| slap/grab threshold | none | no guessed production threshold | telemetry + device calibration |
| glance decision | no measured product data | qualitative one-glance requirement only | time-to-correct-action study |
| fine-tuning dwell | not applicable to gameplay; calibration dwell unknown | explicit confirmation without forced dwell | test calibration completion time |
| fatigue/motion sickness | no product data | three minutes, static viewpoint, gentle drift, no forced dodge | device questionnaire and stop criteria |

High Motion labeling is undecided; the design intent is low motion, but only downstream device evidence can classify comfort. Recommended rest cadence is not asserted without evidence.

## 8. Minimum Completeness Gate

| check | evidence | verdict |
|---|---|---|
| five categories | E01–E13 include market/user/domain/platform/safety and explicit gaps | pass |
| ≥3 competitors / four dimensions | B1–B3 + absorb/avoid + differentiation + boundary | pass |
| domain model | workflow, variables, nine entities/timeliness, risks, mental model | pass |
| user evidence | explicit no-interview boundary, source-bounded proto-persona and journey | pass |
| quantitative/safety | posture/FOV/input/duration/fatigue values are sourced or explicit gaps | pass |

`minimumCompletenessGate=pass` (research-side self-check; Stage 4 must independently review).
