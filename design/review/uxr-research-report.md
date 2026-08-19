# User Research Report · BubbleReflexLab

> Role: `research_analyst` | Active revision: 2 | Sources: PM rev1, user brief, PICO design-method project rules v2.2.0, public product pages observed 2026-08-13 | Bounded patch CR-01 closes EI-01..05

## 0. Reasoning Guidance

本报告只沉淀证据、缺口和领域模型。竞品只用于能力覆盖与反模式判断，不提供布局、状态图、组件或视觉复用依据。

## 1. Direct Description of Outputs

交付五类研究证据、三个相邻产品基线、领域工作流/变量/实体/风险，以及明确的未验证用户研究缺口。

## 2. Research Goals and Questions

- **待验证假设**：A1 双手等价与单手可完成；A2 头部相对互动区能兼容坐/站；A4 准确率优先计分；A6 手追踪瞬失宽限；三类泡泡无需文字也能快速分辨。
- **方法**：本阶段为案头研究（用户 brief、PICO 官方规则、官方/一方产品页）；未做访谈、可用性测试或真机竞品实测。
- **样本**：外部产品 3 个；用户样本 0。用户样本缺口在上线前以 3–5 名中文 XR 新手的坐/站短局测试补齐。

## 3. Five Categories of Research Evidence

| ID | Category | Evidence / Gap | Source | Type | Scope | Confidence | Observed | Validation Plan |
|---|---|---|---|---|---|---|---|---|
| E-M1 | market | 本次有目的选取的三个相邻 VR 产品样本均使用迎面/来向对象、明确身体动作或音乐反馈；此观察不代表整个市场 | Beat Saber、Fruit Ninja VR 2、Synth Riders 产品页（见 §3A） | external | 仅 C1–C3 三个样本 | medium | 2026-08-13 | 实机体验三个产品各 15 分钟并扩样后再判断品类普遍性 |
| E-U1 | user | 目标玩家只需记住“普通拍、金色抓、灰色不碰”，且不得被高速或大幅躲闪施压 | 用户原始 brief | user_supplied | 本项目 | high | 2026-08-13 | 让 5 名新手复述规则并完成 30 秒教程 |
| G-U2 | user | 未知目标年龄、色觉、手部活动度和坐/站比例 | none | assumption | 目标人群 | low | 2026-08-13 | 招募记录年龄/XR经验/惯用手/坐站偏好；覆盖色弱模拟 |
| E-D1 | domain | 三类刺激对应三种判定；“避开灰泡”只要求未触碰直到通过互动区 | 用户原始 brief | user_supplied | 反应循环 | high | 2026-08-13 | 事件日志核对每个对象只产生一个终局判定 |
| E-P1 | platform | PICO 硬件/Unity 集成文档证明受支持设备可提供 26 手关节，并在 Unity 集成中提供 Controller And Hands 模式；**不能据此推断 Android Spatial SDK 自动切换 API** | [PICO Hand Tracking · Unity](https://developer.picoxr.com/home-api/document/unity/hand-tracking/) | official | 仅页面列出的 PICO 设备、系统版本与 Unity 集成 | high | 2026-08-13 | 下游锁定 Spatial SDK/BOM 后建立 device×OS×SDK×hands×controller 矩阵；若无自动切换 API，实现显式输入仲裁 |
| E-P2 | platform | PICO Spatial SDK 基于 Android，覆盖渲染、输入、追踪、MR；官方设计/SpatialUI 文档存在 | [PICO Developer Documentation](https://developer.picoxr.com/document/?platform=web) | official | PICO Spatial | high | 2026-08-13 | 生成阶段重新核对 SDK 版本与 Stage API |
| E-P3 | platform | 本项目设计流程要求：Shared Space 不含 Stage，Stage 需显式进入 Full Space 且有稳定退出；这是**本插件的设计方法硬约束**，不是在本报告内重新证明的 PICO 官方 API 事实 | local `knowledge/official-rules.json` PICO-SPACESTATE-001/002 (`source=official/project+comfort`) | user_supplied/project_method | 本设计包与下游桥 | medium | 2026-08-13 | 下游锁定 SDK 后以 PICO Spatial SDK Stage 官方文档核对术语、API 和设备范围；若冲突则发起 frozen-reasoning Change Request |
| E-S1 | safety | 本项目质量门禁止自动移动相机/持续闪烁，并要求 Reduce Motion、手柄回退、稳定退出；这些是**项目安全契约**，不冒充统一官方能力 | local `official-rules.json` PICO-MOTION-001/002、PICO-ACCESS-001/002/004 (`source=safety/project`) | user_supplied/project_method | 本项目 | high | 2026-08-13 | Preview 覆盖逻辑开关；真机核对相机静止与退出路径 |
| A-P4 | platform | Spatial SDK 是否能自动在手与手柄间切换未知；设计只要求两种输入达到等价判定，输入源仲裁机制待下游确认 | none | assumption | 目标 device/OS/Spatial SDK | low | 2026-08-13 | 锁定 BOM 后建立支持矩阵；无自动能力则用显式最近有效输入源仲裁，设备测试连续性 |
| G-S2 | safety | 精确舒适边界无本项目真机数据；**候选生成包络**为相对头部水平 ±35°、垂直 −20°…+18°、径向 1.35–2.10m；近脸 <0.60m、头顶以上 0.30m 内、估算地面以下/低于地面 0.20m 均禁止。互动区候选为前方 0.55–0.85m、水平 ±0.42m、相对头部垂直 −0.55…+0.12m | none | assumption | 坐/站、不同身高；仅候选设计值 | low | 2026-08-13 | 坐/站真机逐测水平±35/36°、垂直边界、1.34/1.35/2.10/2.11m、近脸、头顶、地面；记录头手轨迹与舒适评分后冻结 |

- **市场证据边界**：只用于覆盖“迎面可读对象、即时反馈、教程和危险物”的需求，不决定本项目界面结构。
- **冲突处理**：PM rev1 的“Shared Space 中 Stage Mixed”与 E-P3 冲突；Stage 3 必须修订为“Shared Space 开始窗 → 显式进入 Full Space Stage Mixed → 稳定退出”。

## 3A. Competitive Benchmark

| # | Product / Platform | Feature needs | Interaction experience | Visual experience | Spatial-capability usage | Source / observed |
|---|---|---|---|---|---|---|
| C1 | Beat Saber / PS VR, VR2 等 | 迎面方块、方向/颜色匹配、计分、音乐；含躲避障碍，偏高速全身节奏 | 双手控制器挥砍；规则秒懂但方向+颜色+躲避叠加增加负荷 | 高对比霓虹、隧道式深度、节奏密集；可读但强刺激 | 使用前后深度、双手身体动作与躲闪；高速/侧步/下蹲不适合本 brief | [PlayStation Beat Saber](https://www.playstation.com/en-us/games/beat-saber/), external, 2026-08-13 |
| C2 | Fruit Ninja VR 2 / PC VR；“离屏指示”只作 Fruit Ninja VR 前代系列旁证 | VR2 产品页：切水果、弓箭/小游戏、节奏关卡；前代一方更新：离屏水果/炸弹提示（不宣称 VR2 同样实现） | VR2：控制器挥砍、直接物理隐喻；丰富模式提高选择成本 | VR2：卡通彩色、物体语义直接；未实测具体密度 | VR2 使用空间挥砍/来物轨迹；前代离屏提示仅说明该系列曾治理视野外注意风险 | [VR2 Steam](https://store.steampowered.com/app/1575520/Fruit_Ninja_VR_2/), [前代一方更新](https://steamcommunity.com/app/486780/announcements/), external, 2026-08-13 |
| C3 | Synth Riders / 多 XR 平台 | 接触音符、轨道、障碍、音乐体验、多人/健身 | 双手跟随音符与轨道，身体舞动；流畅但可含躲避和高运动量 | 合成波霓虹、音乐同步动画、沉浸感强；信息以节拍对象为主 | 使用方向、身体与时间变化，音乐与场景强同步；强度取决于谱面 | [Synth Riders 官网](https://synthridersvr.com/), external, 2026-08-13 |

**Per-product absorb / avoid distillation**

| # | Strengths worth absorbing | Weaknesses / anti-patterns to avoid |
|---|---|---|
| C1 | 单次动作—对象反馈强、迎面深度路径易懂、得分闭环明确 | 高速、下蹲/侧步、方向+颜色多重规则、强闪烁 |
| C2 | “一眼知道要切什么”的物理隐喻、类别反馈丰富、离屏风险值得显式治理 | 对象从视野外进入、模式/武器过多、过度粒子可能遮挡 |
| C3 | 音乐层与空间运动同步、动作连续且有愉悦流动感 | 让玩家追节拍与大幅身体移动；霓虹同质化和视觉压力 |

- **Our differentiation opportunities**：把同类产品的“迎面对象、直接动作、音乐响应、可见反馈”压缩为三条中文规则；用前方扇形生成与固定互动区保证可预期，不引入视野外警告，因为对象根本不从背后/头顶近处/地下生成；灰泡的正确动作是舒适地不动；30 秒柔和换色/加音乐层提供变化但速度上限受控；手势瞬失不惩罚并提供手柄回退。
- **Sample and gap notes**：样本数 3，为有目的选取的相邻 VR 产品，不能代表市场总体；未实机测量教程时长、容差和视觉参数。C2 前代证据已明确与 VR2 分离。
- **Absorption boundary**：只吸收需求层原则，不复制其通道式布局、状态序列、对象组合、霓虹色板或组件。

## 4. Domain Model

- **Domain workflow**：校准头部与互动区 → 显式进入 Stage → 30 秒规则教学（三类各一次）→ 五个 30 秒固定档位 → 暂停/恢复可中断 → 结算统计/徽章/最高分 → 返回开始。
- **Decision variables**：`bubble.kind`（normal/gold/gray）、外形通道、材质/颜色通道、距互动区时间、是否在互动区、手势有效性、触碰速度、抓取保持、是否已终局、当前阶段/主题、暂停状态。
- **Data entities and timeliness**：`SessionClock` 每帧；`DifficultyTier` 每 30 秒；`BubbleInstance` 每帧位置且一次性终局；`InputSample` 每帧并含 lastValidAt；`JudgementEvent` 即时追加；`SessionStats` 每判定更新；`BestScore` 结算时本地读写；`ThemeLayer` 每 30 秒切换。
- **Specialized risks**：同一泡泡多重计分；手势丢失误判漏/错；灰泡错误要求躲避；暂停仍移动；生成越界/背后；对象漏回收；主题切换引发闪烁或掉帧；断电/写入失败损坏最高分。
- **User mental model**：“泡泡慢慢来到手边；看外形就知道拍、抓或别碰；不碰灰泡就是成功”。固定互动区是“判定门”，不是需要身体穿过的障碍。
- **Patterns**：短教程中立即实践、类别用颜色+形状+纹理双/三通道、判定后即时消散、稳定前方工作区。
- **Anti-patterns**：从侧后方补怪、贴脸/头顶出现、地下穿出、速度突然翻倍、以强红闪/警报制造压力、追踪丢失即扣分、暂停继续模拟、让用户为灰泡侧移。

## 5. Persona

### Persona 1: “第一次戴 PICO 也想马上玩懂的轻度玩家”

| Dimension | Content |
|---|---|
| Basic information | **研究假设，不是受访者**：18+，非专业玩家，XR novice–intermediate |
| Use scenario and frequency | 室内，偶发 3 分钟短局，坐或站 |
| Goals / motivations | 三十秒内学会；动作有爽感；不因反应慢而焦虑 |
| Pain points / frustrations | 规则多、对象来自看不见方向、突然加速、追踪丢失被扣分 |
| Spatial usage habits | 手臂自然前伸的小范围动作；不愿转身/深蹲 |
| Accessibility needs | 双手等价、单手可完成；颜色以形状/纹理冗余；文字可缩放 |
| Key quote | 用户原话：“不能要求大幅闪躲。” |

## 6. Journey Map

| Stage | Awareness / entry | First hands-on | Core use | Depth / immersion | Exit / return |
|---|---|---|---|---|---|
| User goal | 知道三条规则 | 做对三次 | 保持稳定准确 | 感受五档和主题变化 | 看懂结果并可再玩 |
| Behavior | 看开始窗并校准 | 拍普通、抓金、不碰灰 | 小幅手部动作 | 在固定互动区判断 | 查看统计/徽章/最高分 |
| Touchpoint | Shared Space Planar | Full Space Stage tutorial | Full Space Stage game | Stage Mixed + 轻 HUD | Planar results / 返回 Shared Space |
| Thought | “会不会很难？” | “原来就三种” | “下一颗是什么？” | “颜色变了但不慌” | “我哪类最好？” |
| Emotion | 😐 | 😀 | 😀 | 😀 | 😀 |
| Pain point | 校准不清 | 视觉混淆 | 手势瞬失/误判 | 对象太多或过快 | 只有总分看不出原因 |
| Opportunity | 一键校准+示意 | 三类各一次 | 宽限期+回退 | 固定档位/速度封顶 | 类别统计+徽章 |

- **Emotional low point**：首个错误若来自“看不懂类别/追踪掉线”会破坏信任，优先以形色纹三通道和瞬失宽限解决。
- **Key opportunities**：把“不动”也做成正向确认；主题变化只改变情绪层，不改变规则和安全区域。

## 7. Key Findings

| # | Finding | Evidence | Confidence | Design Implication |
|---|---|---|---|---|
| F1 | 三规则是不可扩展的记忆上限 | E-U1 | high | 全局只使用三类，不在高档位新增规则 |
| F2 | 安全来自生成约束而非离屏警报 | E-U1 + C2 anti-pattern | high | 生成器先验证前方扇形和互动区路径，否则不出池 |
| F3 | Stage 合法路径需 Full Space 显式进入/退出 | E-P3 | high | 开始窗明确按钮；暂停/结算都有稳定退出 |
| F4 | 类别必须不依赖颜色 | E-S1/PICO-COLOR-001 | high | 普通圆润/金色带冠环/灰色多孔哑光并配短标签 |
| F5 | 具体舒适数值仍需设备证据 | G-S2 | low | 设计给候选值和真机校准计划，禁止声称已验证 |

## 8. Wearing Posture and Field-of-View Insights

- **Usual posture**：用户 brief 要求不大幅躲闪；实际坐/站分布未知（G-U2）。设计同时支持坐/站。
- **Arm range**：采用 G-S2 候选包络；所有数值均是待验证设计假设，不是人体工学或设备结论。
- **Central FOV**：官方规则要求核心内容验证在 65°×40°、次要内容在 85°×55°；空间泡泡活动主带应更窄并始终在前方。
- **Fatigue threshold**：单局已由用户固定为 3 分钟；仍需真机记录手臂疲劳和眩晕，不能由短时 Preview 推断。

## 9. Eye-Hand Interaction Usability

- **Measured hit rate**：证据缺口；尚无本项目真机命中率。
- **Low-load interaction**：玩法不采用持续射线选择；拍/抓发生在胸前互动区，灰泡无需动作。
- **Mis-touch and feedback**：候选方案为 120ms 视觉接近提示、触碰/抓取成功立刻形变+音效；数值需设备验证。
- **Tracking-loss policy**：短失联期间冻结该手的判定资格但不冻结世界；恢复后需连续有效样本再重新武装，手柄可立即接管。

## 10. Duration Baseline Data

| Decision Type | Duration Anchor | Source |
|---|---|---|
| Rule recognition | 统一候选阈值 ≤1.2s；参与者级验收为 5 名新手至少 4 人达标 | assumption，需逐试次日志验证 |
| Gesture confirmation | 候选 120–250ms 反馈；未实测 | assumption，需真机高速录像/事件时间戳 |
| Tutorial | exactly 30s, 三类各一次 | user_supplied |
| Session / tier | 180s total；之后五档各 30s | user_supplied |

## 11. Motion Sickness / Fatigue and Safety

- **Risk scenarios**：虚拟相机移动、对象贴脸/头顶/地下或从背后、强闪、速度突变、必须大幅躲避、暂停仍运动。
- **High Motion label**：设计目标为 no；是否达到需真机舒适度复核。
- **Rest cadence**：每局 3 分钟结束给明确停顿，不自动连开下一局；玩家可随时暂停/退出。
- **Device boundary**：眩晕、手臂疲劳、遮挡、真实尺度、输入命中与音频定位均 `not_performed`，转交下游真机验收。

## 12. Minimum Completeness Gate

| Check Item | Minimum Pass Condition | Evidence Anchor | Verdict |
|---|---|---|---|
| Five evidence categories | each has evidence or explicit gap | §3 E-M1…G-S2 | pass |
| Competitive benchmark | 3 products × 4 dimensions | §3A C1–C3 | pass |
| Domain model | workflow/variables/entities/risks/model/anti-patterns | §4 | pass |
| User evidence | provisional persona and journey clearly labeled, findings sourced | §5–§7 | pass |
| Quantitative and safety | values or explicit device gaps | §8–§11 | pass |

| Field | Value |
|---|---|
| minimumCompletenessGate | pass |

## 13. Delivery and Recipients

- **Deliverables**：五类证据、竞品基线、领域模型与验证缺口。
- **Recipients**：PM、Task/Spatial Designer、Visual Designer、下游设备 QA。
