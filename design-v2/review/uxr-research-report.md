# 研究与领域证据 · BubbleReflexLab

> revision: 2 · stage: research · source revision: uxr1 + CR-01 evidence patch · observed: 2026-08-13 · method: desk research only

## 1. 研究问题与边界

本阶段回答：Stage/Full Space 边界是什么、输入回退能诚实承诺到哪一层、同类空间节奏产品有哪些可吸收与应避免的模式、以及三规则在舒适前提下怎样可判定。未做访谈、真机、可用性、竞品实测；所有用户结论均为待验证假设。

## 2. 证据账本

| ID | 五类 | 可支持的事实或证据缺口 | 来源/authority | 置信度 | 限制与下游动作 |
|---|---|---|---|---|---|
| P1 | platform | PICO Spatial SDK 以 Kotlin/Android 提供原生空间应用能力；资源页列 v0.13.x、Project Swan 与 Emulator | [PICO Resources](https://developer.picoxr.com/resources/) / official | high | 生成时重新锁定实际 BOM/设备 |
| P2 | platform | `Stage` 是 PICO OS 提供的容器；id 用于开关，Progressive 可配置 immersion | [Stage API](https://developer.picoxr.com/spatial-api/0.12.2/spatialui/foundation/com.pico.spatial.ui.foundation.dsl/-stage.html) / official | high | API页版本0.12.2；实现需按锁定版本复核 |
| P3 | platform | 打开 Stage 进入 Full Space；Full/Shared 互斥；Stage 坐标系以脚底为原点 | [Spatial Anchor](https://developer.picoxr.com/document/spatial-sdk/spatial-anchor/) / official | high | 只借用空间状态与坐标事实，不要求持久 anchor |
| P4 | platform | `openStage` 接受 id/style/bundle/upperLimbRenderMode 并返回结果 | [openStage API](https://developer.picoxr.com/spatial-api/0.11.7/spatialui/platform/com.pico.spatial.ui.platform.containers/-spatial-navigator/open-stage.html) / official | high | 版本页0.11.7；实现以安装 SDK 为准 |
| P5 | platform | 官方 Unity 路径可跟踪26手关节，且 `Controller And Hands` 可自动切换 | [PICO Hand Tracking](https://developer.picoxr.com/home-api/document/unity/hand-tracking/) / official | high for Unity only | **不可推断 Spatial SDK 同名机制**；本产品使用显式 InputArbiter 假设，生成前核对 |
| P6 | platform | Spatial 工具需特定 Android Studio、PICO Spatial Plugin、Emulator/Editor | [环境设置](https://developer.picoxr.com/document/spatial-sdk/set-up-development-environment/) / official | high | 属实施环境，不证明运行时行为 |
| M1 | market | Beat Saber 明确以迎面目标、方向/颜色、快速节奏与侧步/下蹲障碍构成挑战 | [PlayStation 官方页](https://www.playstation.com/en-us/games/beat-saber/) / first-party storefront | high | 只作为对比机会，不复制布局/表现 |
| M2 | market | Synth Riders 以音乐同步、轨道与全身动作建立节奏体验 | [Synth Riders 官网](https://synthridersvr.com/) / first-party | medium | 官网营销信息；未独立实测 |
| M3 | market | OhShape 让玩家随音乐通过、击打或躲避墙体，强调全身运动与健身 | [OhShape 官网](https://ohshapevr.com/) / first-party | high for advertised mechanics | 未独立实测；只用于识别“全身躲避压力”反模式 |
| U1 | user | 目标用户是否能在30秒后复述三规则、是否把灰泡理解为“等待通过” | evidence gap：原始需求推论，无用户研究 | low | 5名目标用户教程后口述与行为观察；当前旅程保持 provisional |
| D1 | domain | “拍/抓/不碰”的互斥判定、单终局事件、暂停冻结等是本项目领域不变量 | original requirement + design derivation | medium | 不是外部领域共识；用状态模型测试验证，不能表述为行业事实 |
| D2 | domain | 0.22–0.48m/s、1.4秒间隔、12°角距能否构成低压反应节奏 | evidence gap：无同人群遥测/实验 | low | 真机分段遥测与访谈；只允许向更舒适方向调整 |
| S1 | safety | 禁止相机自动运动/持续闪烁；56×56dp、减弱动效、稳定退出等为本设计流程硬约束 | local `knowledge/official-rules.json` / project_method | high in this workflow | 不表述为平台 API；真机舒适仍未验证 |

## 3A. 逐竞品四维基准与机会矩阵

| 产品 | 功能需求 | 交互体验 | 视觉体验 | 空间能力使用 | 值得吸收（需求级） | 应避免反模式 | BubbleReflexLab 差异机会 |
|---|---|---|---|---|---|---|---|
| Beat Saber | 迎面节奏目标、方向规则、计分与障碍 | 双手挥砍，部分障碍要求侧移/下蹲，节奏压力强 | 高对比霓虹轨道、方向箭头、强节拍反馈 | 目标沿深度轨道接近，动作幅度与全身障碍形成空间挑战 | 来向可读、动作后即时多模态确认、规则使用非颜色通道 | 不复制刀具/轨道布局、霓虹隧道、强制躲墙和高速压力 | 把深度接近收敛到前方 SafeArc 与胸前 InteractionRibbon；用拍/抓/静止三语法而非方向挥砍 |
| Synth Riders | 音乐同步目标、连续轨迹、全身节奏组合 | 手部跟随/触碰并配合身体移动，连贯性高 | 彩色轨道与音乐同步环境，强调流动感 | 多轨迹从远处进入，身体位置与双手运动共同参与 | 音乐分层维持流畅气氛、运动路径应连贯可预测 | 不复制音符轨道、全身编舞、用BPM推动难度或拥挤视野 | 音乐层每30秒柔和变化，但速度不被音乐驱动；组合只增加类别/数量且保留空隙 |
| OhShape | 随节拍穿过、击打或躲避墙体，强调全身健身 | 以身体姿势、出拳、闪躲完成关卡，运动范围大 | 大型轮廓墙与姿势缺口占据主要视野 | 大尺度墙体向用户逼近，以身体整体相对位置为判定核心 | 轮廓符号比单色更利于快速读懂动作要求 | 不复制全身躲墙、健身强度、大面积逼近遮挡和姿势匹配 | 灰泡成功定义为“不触碰直到通过”，身体无需离开舒适姿势；单个小体积目标不遮挡环境 |

聚合机会：保留“迎面来向可读、即时反馈、音乐层提供节奏结构”这三个已验证需求范式；将差异集中于固定胸前弧带、无需闪躲的抑制判定、三动作语法与舒适上限。吸收边界只到机会/约束，不复用任何竞品布局、状态图、组件组合或视觉概念。

## 4. 原创性前置约束

- `templateReuse=false`：未使用模板页面、既有项目截图或失效包的布局/状态/组件结构。
- 差异化命题：以“前庭弧带 + 三种动作语法 + 温和六段色声层”形成产品身份；不采用霓虹隧道、刀具、音符轨道、健身排行或躲避墙。
- 后续相似性审计必须比较：状态序列、布局标识、组件顺序/工具栏、视觉概念；吸收的仅是“即时反馈、来向可读、音乐分层”这些需求级原则。

## 5. 领域模型

| 术语 | 定义 | 不变量 |
|---|---|---|
| SafeArc | 以校准头姿为基准的前方生成体积 | yaw ±32°、pitch −18°..+18°、1.6..2.4m、floor上方 |
| InteractionRibbon | 胸前固定弧带，唯一产生接触判定的区域 | 0.75..1.05m深度、0.85..1.45m高度；暂停冻结 |
| BubbleSeed | 池化泡泡实体及其类别、轨迹、武装状态 | 每次租借只有一个终局 Judgment |
| InputArbiter | 手势与手柄的显式仲裁器 | 追踪宽限期禁新判定；不能双报 |
| Judgment | `hit/grab/untouched/touched/miss` 之一 | 原子写入、不可重入 |
| SegmentClock | 180秒游戏时钟与六个30秒段 | 暂停不推进；不追赶生成 |
| ThemeLayer | 每段柔和彩色与音乐编排 | 只改变气氛，不改变相机和速度上限 |
| RunLedger | 本局统计与本地最佳 | 保存失败不改本局事实 |

## 6. 关键任务证据与推论

| 任务 | 证据 | 推论 | 置信度 |
|---|---|---|---|
| 进入空间游戏 | P2–P4 | Shared Space 启动窗必须显式打开 Stage，并提供反向退出 | high |
| 拍/抓输入 | P5 + 用户要求 | 设计双输入，但 Spatial SDK 具体切换机制为待核实实现假设 | medium |
| 前方生成 | P3 + S1 + 用户要求 | 使用脚底/头姿组合校准，边界收窄优先 | medium |
| 低压节奏 | M1/M2 对比 + 用户要求 | 数量/组合上升，速度仅小幅且封顶；音层不发出危险信号 | medium |
| 灰泡成功 | 用户明确要求 | 以穿过弧带且无触碰为成功，不引导躲闪 | high |

## 7. 假设用户旅程（provisional）

用户在启动窗看到三条动作词 → 选择坐/站并校准弧带 → 明确进入 Stage → 30秒逐一练习 → 五档温和组合 → 可随时暂停/重校准/退出 → 结算查看总准确率与三类统计 → 最高分安全写入。本旅程尚未经用户研究验证。

## 8. 安全边界与测试矩阵

| 边界 | inside样本 | outside样本 | 期待 |
|---|---|---|---|
| yaw | ±31.9° | ±32.1° | 仅 inside 可生成 |
| pitch | −17.9°/+17.9° | −18.1°/+18.1° | 仅 inside |
| distance | 1.61/2.39m | 1.59/2.41m | 仅 inside |
| floor | y≥0.85m进入弧带 | y<0m | 地下永不生成 |
| forward | dot>0 | dot≤0 | 背后/侧后永不生成 |
| head-near | distance≥1.6m | <1.6m | 近头拒绝 |

判定顺序为全部约束 AND；任何一项失败都拒绝采样，不允许以单一 forward-dot 替代完整体积测试。

## 9. 研究缺口

1. Spatial SDK v0.13.x 对 hand/controller 共存、回调与 Stage style 的精确 API：生成前官方文档+本机 SDK 复核。
2. 1.6m 生成远端、0.75m互动近端与坐姿高度的舒适性：真机 5 人测试。
3. 0.22–0.48m/s、1.4秒最短间隔是否低压：遥测+访谈验证，只可收窄挑战。
4. 灰泡“完全不动”是否被误解为遗漏：教程观察与口述验证。
5. 六层音乐的响度与疲劳：耳机/扬声器真机混音测试。

## 10. Minimum Completeness Gate

| 检查 | evidence | verdict |
|---|---|---|
| market/user/domain/platform/safety 五类证据或显式 gap | §2 M/U/D/P/S rows | pass |
| claim/authority/scope/置信度/限制 | §2 | pass |
| ≥3竞品逐项四维、吸收/避免/差异 | §3A Beat Saber / Synth Riders / OhShape | pass |
| 原创性前置约束 | §4 | pass |
| 明确研究缺口 | §9 | pass |

`minimumCompletenessGate=pass`
