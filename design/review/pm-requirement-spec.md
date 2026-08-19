# Spatial App Requirement Spec · BubbleReflexLab

> Role: `product_strategist` | Active revision: 4 | Sources: user request digest `e18c…28fc`, UXR rev2, PICO design-method project rules v2.2.0 | CR-01 + provenance micro-patch

## 0. Reasoning Guidance

本角色只冻结产品结果、边界、风险与未知项；布局、组件和视觉方向留给后续角色。用户原话为最高优先级证据，未给出的设备型号、场地尺寸和手势 API 可靠性均按假设治理。

## 1. Direct Description of Outputs

交付已冻结的意图定义、假设清单与质量契约。Stage 3 根据 UXR 平台证据纠正 Stage 的空间状态表达；Stage 4 初审后已完成 CR-01，当前修订等待问题/证据门禁复审。

## 2. Background and Problem

- **一句话需求**：为 PICO Spatial SDK Stage 设计一款名为 BubbleReflexLab 的三分钟中文空间反应小游戏，让玩家用“拍普通、抓金色、不碰灰色”三条规则，在舒适、可预期的前方空间完成反应练习。
- **目标用户**：首次或轻度使用空间交互的中文玩家；希望短时娱乐、避免高速压迫和大幅身体移动的成年人。
- **使用场景**：室内安全空间，戴头显后站姿或坐姿，正前方有可用互动距离；单人、单局、可暂停。
- **佩戴姿态**：默认站姿，坐姿兼容；不要求转身、下蹲、跨步或大幅闪躲。
- **频率与时长**：每局固定 180 秒；前 30 秒为游戏内短教程，此后每 30 秒一个固定档位/主题段；可重复游玩并比较本地最高分。
- **空间必要性初判**：泡泡从前方扇形沿深度缓慢漂入固定互动区，空间中的拍击/抓取/保持不动构成身体—方向—距离直接映射；普通 2D 屏幕不能等价表达空间可达范围和迎面接近。

## 3. Key Moment

- **屏幕难以替代的瞬间**：三种形态明确的泡泡在不同前方方位缓慢进入同一个舒适互动区，玩家以短距离手部动作选择拍、抓或保持不动；灰泡成功通过时无需躲闪而获得柔和确认。
- **沉浸谱系**：开始为 Shared Space 的 Planar WindowContainer；用户显式进入后切换到 Full Space 的 Stage Mixed，教程/游戏/暂停/结算由 Stage 承载；退出 Stage 稳定返回 Shared Space。
- **进入路径**：开始窗完成校准并由用户点“进入练习”；不直接强制 Full Space。

## 4. Product Research

| Dimension | Content | Source |
|---|---|---|
| Competitor baseline | 迎面对象、直接动作、音乐反馈是三个相邻产品样本的观察；本项目差异是三规则、固定安全扇形、灰泡“不动成功”、受控速度 | UXR rev2 §3A C1–C3 |
| Decision duration | 教程 30s、总时长 180s、每段 30s 是用户硬约束；识别 ≤1.2s 与反馈 120–250ms 是待真机验证候选值 | UXR rev2 §10 |
| Safety / comfort | 禁止自动相机和持续闪烁；需 Reduce Motion、手柄回退、稳定退出；Stage 的空间状态需下游锁定 SDK 后复核 | UXR rev2 E-P3/E-S1/A-P4 |

## 5. Intent Definition (frozen items)

- **Domain / sub-domain**：空间休闲游戏 / 短局反应与手部动作分类。
- **Target identity**：项目名 `BubbleReflexLab`；包名 `com.pico.swan.bubblereflex`（只作下游输入，本技能不生成项目代码）。
- **Risk level**：中等；生成方位、追踪丢失、视觉混淆、暂停运动与过度动作是关键风险。
- **Default space**：入口为 Shared Space；玩法经显式动作进入 Full Space Stage Mixed；关闭 Stage 返回 Shared Space。
- **Core scenarios**：开始与校准；30 秒三规则引导；150 秒五档游戏；暂停/恢复；结算与本地最高分；输入丢失恢复；越界回收。
- **Core decisions**：普通拍破、金色抓住、灰色不触碰；灰泡成功定义为其通过互动区前未触碰。
- **Data / AI / sensors / permissions**：无 AI、联网、账号；使用头位、手追踪，手柄按键/抓取键回退；仅本地最高分。具体权限/API 由下游按目标 SDK 核对。
- **Collaboration**：无多用户或多设备协作。
- **Required states**：开始、短教程、游戏、暂停、结算；另含校准失败、追踪瞬失、存储失败等异常子态。

## 6. Assumptions List

| # | Assumption | Confidence | Impact | Validation Plan |
|---|---|---|---|---|
| A1 | 年龄、惯用手和无障碍需求未指定，先按双手等价、单手可完成 | medium | 提示位置/容错 | 左右手各一局，3–5 名新手观察误触 |
| A2 | 房间与身高未知，以头部相对坐标校准互动区 | high | 坐姿兼容/安全 | 坐站各验证可达性和房间边界 |
| A3 | 设备与 SDK 版本未知 | low | API 与素材能力 | 下游锁定 BOM 后查官方文档并构建 |
| A4 | 最高分算法未给定，暂按正确事件计分，准确率决定徽章 | medium | 结算/排序 | 产品验收前确认权重，fixture 可替换 |
| A5 | 音乐素材和许可未提供 | low | 主题音乐层 | 发布前完成素材授权清单 |
| A6 | 瞬时手势丢失候选为 0.2–1.0 秒；Spatial SDK 自动切换机制未知 | medium | 判定连续性 | 真机注入丢失；锁定 BOM 后做 device×OS×SDK×input 支持矩阵，无自动能力则显式仲裁 |
| A8 | 安全扇形与互动区使用 UXR G-S2 的候选包络，尚非真机舒适结论 | low | 生成安全与可达性 | 坐/站逐个边界值和越界值真机测量后冻结 |
| A7 | 截图尺寸/设备未知 | low | 验收格式 | 下游按目标设备截图并记录环境 |

## 7. Quality Contract

- **Required business outcomes**：三规则不扩展；严格 180 秒（0–30s 教程，之后 5×30s）；只从前方安全扇形生成并漂入固定区；暂停冻结；池化回收；手势瞬失不误判且手柄回退；结算含准确率、三类统计、铜银金与本地最高分。
- **Success / efficiency criteria**：教程三类各一次且提示 ≤10 汉字；5 名新手至少 4 人在 **≤1.2 秒**无文字正确分类；所有生成点同时通过 UXR G-S2 候选水平/垂直/径向/近脸/头顶/地面包络，逐测边界内外值；阶段边界准确为 30/60/90/120/150/180s；暂停前后泡泡位置与 session time 相等；3×3 判定案例各有唯一结果。
- **Risks and must-not-fail**：任何背后/头顶近距/地下生成、暂停运动、灰泡迫使躲闪、追踪丢失扣分、重复结算、自动移动相机或持续强闪均为 P0。结束本局/退出 Stage 需确认 Dialog；普通暂停无需确认。
- **Default visible primary windows**：Shared Space 默认 1 个 Planar 主窗；游戏时 1 个 Full Space Stage。Stage HUD 是辅助层，不是第二主窗。
- **Domain-specialized components**：安全扇形生成、互动门、三类泡泡、判定回执、阶段/主题、输入连续性、暂停冻结、结算/徽章；每个核心组件需任务、数据和完整八段结构。
- **Real-time data trust**：显示追踪状态；短失联不惩罚；最高分写失败显示可读提示与重试。本地事件不伪装网络实时。
- **PICO platform / project constraints**：本插件方法要求 Shared Space 不含 Stage、Stage 显式进入 Full Space并稳定退出，以及 Planar 合法范围/深度/FOV/点击字体下限；其上游官方适用性须由下游锁定 SDK 后复核。禁止相机移动/闪烁、Reduce Motion/textScaling/Controller Fallback 是本项目不可放松的安全契约。手与手柄等价是结果要求，不假定 Android Spatial SDK 自动切换 API。
- **Originality requirement**：吸收 UXR §3A 直接动作/音乐反馈/迎面路径，拒绝高速通道、视野外警报、躲闪谱面和霓虹复制；差异由“舒适扇形 + 不动也算正确动作 + 柔和段落”产生。
- **Acceptance plan**：六文档、17 收据、独立评审、组件八段、Preview manifest/五表全部通过；下游另做 Android 构建、短局、无背后生成断言、三类辨识和教程/进行态截图。真机舒适/输入/尺度/性能本阶段 `not_performed`。

## 8. Requirements Traceability

| ID | Requirement | Implementation Node | Validation Method |
|---|---|---|---|
| R1 | 项目名/包名 | PM §5；仅下游 | 检查生成项目 |
| R2 | PICO Stage | IS §7 | 显式 Full Space 转移；下游构建 |
| R3 | 中文三分钟 | IS §10 | 时间线与文案检查 |
| R4 | 三条精确规则 | TutorialDeck/BubbleActor | 三步教学+分类夹具 |
| R5 | 只在前方安全扇形生成 | SafeFanSpawner | 按 UXR G-S2 水平±35°、垂直−20…+18°、1.35–2.10m及近脸/头顶/地面边界逐项断言；真机后冻结 |
| R6 | 缓慢漂入固定互动区 | BubbleActor/InteractionGate | 路径/速度上限 |
| R7 | 首 30s 三类各一次 | TutorialDirector | 事件日志 |
| R8 | 后续五固定档 | DifficultyTimeline | 六个边界时间 |
| R9 | 每 30s 柔和主题/音乐层 | ThemePulse | 六段事件、无闪烁/速度突变 |
| R10 | 灰泡未触碰通过即成功 | JudgmentLedger | touched/untouched 案例 |
| R11 | 不要求大幅躲闪 | 几何/规则 | 头部位移观察（下游） |
| R12 | 对象池 | PoolLifecycle | acquire/release 计数（下游） |
| R13 | 拍/抓/未触碰三判定 | JudgmentLedger | 3×3 矩阵 |
| R14 | 手柄回退 | InputContinuity | 切换场景 |
| R15 | 准确率/分类/徽章 | ResultConstellation | 统计 fixture |
| R16 | 开始/教程/游戏/暂停/结算/最高分 | State graph/BestScoreStore | 全转移+重启读取 |
| R17 | 手势瞬失 | InputContinuity | 丢失注入 |
| R18 | 越界回收 | PoolLifecycle | 越界 fixture |
| R19 | 互动区校准 | CalibrationHalo | 坐站真机测试 |
| R20 | 暂停冻结所有泡泡 | PauseVeil | 快照相等 |
| R21 | 短验收局/无背后/可分辨 | Device QA boundary | 仪器化短局+新手辨识 |
| R22 | 教程与进行态截图 | Downstream artifact list | 目标设备截图清单 |

## 9. Minimum Completeness Gate

| Check Item | Minimum Pass Condition | Evidence Anchor | Verdict |
|---|---|---|---|
| Background and intent | six foundations explicit | §2–§5 | pass |
| Assumption governance | confidence/impact/validation on all unknowns | §6 | pass |
| Quality contract | all nine items complete/testable | §7 | pass |
| Requirements traceability | all mandatory requirements mapped | §8 R1–R22 | pass |

| Field | Value |
|---|---|
| minimumCompletenessGate | pass |

## 10. Delivery and Recipients

- **Deliverables**：冻结意图与项目质量契约。
- **Recipients**：Evidence Reviewer、Task/Spatial Designer、Visual Designer、Design System、QA。
