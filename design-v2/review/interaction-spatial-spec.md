# 交互与空间设计规范 · BubbleReflexLab

> revision: 6 · active stages: task_model + concept_formation + spatial_structure + composition_synthesis + design_system · roles: `task_decision_designer`, `interaction_xr_designer`, `spatial_design_system_designer` · source revisions: PM4 + UXR2 + Interaction5 + Visual1

## 1. 角色与边界

本修订只确立任务与决策，不预先选择布局、容器附件或视觉样式。任务来源为 R01–R22、UXR2 五类证据/缺口、领域不变量与竞品功能列；竞品仅用于检查任务覆盖，不复用其顺序、组件或动作路径。

## 2. 跨阶段设计原则（Stage 5 初始版）

| # | 可检查原则 | scope | 推导依据 | 下游检查点 | 冲突优先级 |
|---|---|---|---|---|---|
| P1 | 任何挑战都不得要求用户转身、下蹲、侧步或追逐离开胸前舒适区 | product/spatial/safety | PM R04–R09；UXR2 §3A 反模式 | SafeArc、InteractionRibbon、状态异常与生成测试 | 最高：覆盖得分、密度与视觉戏剧性 |
| P2 | 每个泡泡只形成一个可解释的动作决策与一个终局判定 | interaction/data trust | PM R01–R03/R11/R14；UXR2 Domain model | task graph、Judgment、pool receipt、结算分类 | 高：覆盖连击或表现反馈 |
| P3 | 类别必须同时以形状/材质/符号/文字或动作反馈表达，颜色不得独自承载含义 | visual/accessibility | PM R18–R19；UXR2 §3A | visual tokens、组件 anatomy、截图验收 | 高：覆盖主题换色一致性 |
| P4 | 难度增长只来自可预测的数量与组合，音乐和视觉不得暗示紧迫加速 | time/motion/audio | PM R07–R10；UXR2 D2/M rows | 六段时钟、motion、theme/audio mapping | 高：覆盖娱乐强度 |
| P5 | 所有不确定平台能力与本地保存结果都必须显式呈现为待验证、不可用或失败，不伪造成功 | data trust/platform | PM A1/A2/R13/R17；UXR2 P5 | input fallback、save status、preview fallback | 高：覆盖流畅自动切换 |

- 冲突仲裁：物理/前庭舒适与稳定退出 > 判定唯一性/数据可信 > 可辨识性 > 任务效率 > 装饰与得分刺激。
- 禁止项：背后/地下/近头生成；镜头运动；大幅闪躲；仅颜色编码；用 BPM 加速；无确认退出；未验证即宣称手柄可用；局内临时实例化。
- 与概念一致性：Stage 6 选择“前庭弧带实验室”；P1–P5 均保持，无需修改。概念把主要空间价值限制在泡泡方向/深度/身体动作，信息阅读留在平面层，符合原则优先级。

## 3. 任务 / 决策模型

| ID / Task | Actor | Scenario | 输入信息（证据） | 决策输出 | 错误后果 | 频率 | 依赖 | 决策时长 |
|---|---|---|---|---|---|---|---|---|
| T01 选择开始与姿态 | 玩家 | Shared Space 启动 | 三规则、180秒、坐/站、舒适承诺（PM §1–2） | `startRequested(posture)` 或退出 | 未理解规则或姿态错误导致后续校准失败 | 每局1次 | 无 | 5–15s provisional |
| T02 校准互动弧带 | 玩家+系统 | 入 Stage 前 | 头姿/脚底参考、坐站选择、弧带预览、校准有效性（R05/R21） | `calibrationAccepted` / `retry` / `exit` | 目标过近/过高、误触或无法进入游戏 | 首局1次；暂停可重做 | T01 | 5–20s provisional |
| T03 识别当前泡泡类别 | 玩家 | 泡泡从 SafeArc 漂入 | 轮廓、材质、符号、短动作词（R18） | `normal/gold/gray` 心智分类 | 做错动作或追碰灰泡 | 每个泡泡 | T02；当前 segment | <1s target |
| T04 拍破普通泡泡 | 玩家 | 普通泡泡进入 Ribbon | 青色圆泡+手掌裂纹、位置、输入可用状态 | `hit` 或不动作导致 `miss` | 普通类失败；不扣总分但降低准确率 | 教程1次+游戏多次 | T03；InputArbiter armed | 0.8–2.5s |
| T05 抓住金色泡泡 | 玩家 | 金泡进入 Ribbon | 金色环+抓握把手、位置、输入可用状态 | `grab` 或 `miss` | 金色类失败 | 教程1次+游戏多次 | T03；InputArbiter armed | 0.8–2.5s |
| T06 不触碰灰泡 | 玩家 | 灰泡接近并通过 Ribbon | 哑光六角+禁触横杠、“别碰，等它通过” | `untouched` 或误触 `touched` | 灰色类失败；若被误解可能诱导闪躲 | 教程1次+游戏多次 | T03；无需身体位移 | 直到通过，约1–3s |
| T07 处理输入瞬失 | 玩家+系统 | 手势跟踪短暂丢失 | tracking state、300ms grace、回退验证状态（R13/A1/A2） | 等待恢复 / 已验证手柄 / 暂停安全退出 | 双报、误判或游戏继续而无输入 | 条件触发 | T04/T05；InputArbiter | 0.3–3s |
| T08 暂停或恢复 | 玩家 | 游戏/教程中按系统返回或菜单 | 时间、泡泡冻结快照、继续/重校准/退出选项 | `resume` / `recalibrate` / `exitRequested` | 未冻结导致不公平；误退出丢失本局 | 0..多次 | T02；active run | 1–10s |
| T09 确认退出本局 | 玩家 | 暂停中选择退出 | “本局不保存”后果、取消与确认 | `cancelExit` / `confirmExit` | 误丢失进度 | 条件触发 | T08 | 1–5s |
| T10 读取结算并决定下一步 | 玩家 | 180秒结束 | 准确率、三类成功/总数、徽章、本局/最佳、保存状态 | `replay` / `returnShared` / `retrySave` | 误解分类表现或保存失败被掩盖 | 每完整局1次 | T04–T06 Judgments；RunLedger | 5–30s |
| T11 系统生成/回收泡泡 | 系统 | segment clock active | SafeArc constraints、tier script、pool availability、Ribbon passage | `lease→active→judged→returned` 或拒绝生成 | 背后/越界实体、池泄漏、多终局判定 | 每生成事件 | T02；T12；未暂停 | deterministic |
| T12 系统切换六段节奏 | 系统 | 每30秒边界 | SegmentClock、主题/音乐层、tier limits | 原子应用 segment 配置且不补发 | 时间/主题错位、突发压力 | 每局5次边界 | active clock；T11 | boundary atomic |

### 3.1 依赖关系

- 串行主链：T01 → T02 → 教程 T03→(T04,T05,T06 各一次) → 游戏循环 → T10。
- 游戏循环：T12 提供当前档；T11 生成；每个实体先 T03，再互斥进入 T04/T05/T06；终局后统一回池。
- 并行监护：T07 可打断 T04/T05 的新判定；T08 冻结 T03–T07/T11/T12；T09 只从暂停进入。
- 互斥：同一 BubbleSeed 只能有一个 T04/T05/T06 判定路径；暂停/退出确认期间不得继续判定或生成。

### 3.2 关键用户决策

1. 是否开始并选择站/坐；2. 校准是否舒适；3. 当前泡泡属于哪类；4. 拍、抓还是保持不动；5. 输入丢失时等待、用已验证手柄或暂停；6. 暂停后继续、重校准或退出；7. 结算后再来一局或返回。

### 3.3 竞品功能覆盖核对

| 竞品常见功能 | 是否覆盖 | 本项目处理或刻意省略 |
|---|---|---|
| 来向目标+即时反馈 | yes | T03–T06；收敛到固定 Ribbon，不采用高速轨道 |
| 难度档与音乐结构 | yes | T12 六段固定切换；不以 BPM 驱动速度 |
| 计分/结果 | yes | T10，准确率与分类统计优先于排行榜 |
| 全身躲避/姿势墙 | deliberately omitted | 违反 P1；灰泡以不触碰完成，无需闪躲 |
| 连续长轨迹/健身排行 | deliberately omitted | 与三分钟低压反应目标无关，增加疲劳与界面负担 |

## 4. 空间价值论证

| Task | 空间价值判断 | 空间化理由 | 2D 反事实 | 竞品空间对照 | 评级 |
|---|---|---|---|---|---|
| T01 开始/姿态 | position/time 低 | 平面阅读与选择足够，无需在 Stage 内完成 | 标准2D启动面板即可完整完成 | 三竞品常直接进入沉浸，本项目刻意保留显式入口 | Low；留在 Window |
| T02 校准 Ribbon | direction/distance/position/body 高 | 用户必须看到胸前弧带相对头姿、身体与地面的实际空间关系 | 2D 可选坐/站与显示数值，但不能表达实际前后/高度位置 | 相比竞品全身轨道/墙，本项目只校准局部舒适区 | High |
| T03 类别识别 | direction/depth/motion 中高 | 来向、剩余深度和互不遮挡角度共同决定何时识别；体积/材质辅助语义 | 2D 屏幕可用三类移动圆形实现反应测试，但失去真实前后接近与双手动作映射 | 吸收 Beat Saber/Synth Riders 来向可读，避免多轨拥挤 | High for gameplay |
| T04 拍普通 | distance/position/body/simulation 高 | 手掌与体积在 Ribbon 内相交、破裂空间反馈是核心动作价值 | 2D 点击可判定但变为指点游戏，拍击距离与姿态消失 | 不用刀具与方向斩击，缩小到胸前手掌动作 | High |
| T05 抓金色 | distance/position/body/simulation 高 | 抓握需手部接近、闭合和短暂保持，与拍击形成可感知差异 | 2D 长按可模拟，但不能验证自然抓取或双手可达 | 吸收空间直接操作的即时反馈，不复制轨道 | High |
| T06 不碰灰色 | motion/time/inhibition 高 | 目标穿过同一区域而用户保持手静止，形成空间抑制而非屏幕不点击 | 2D 可实现“不点灰圆”，规则成立但不具身体克制感 | 反转 OhShape/Beat Saber 的躲障碍范式 | Medium-High |
| T07 输入瞬失 | body/time 中 | 丢失的是空间手部状态，必须冻结判定并保持目标关系；手柄只在验证后接管 | 2D 鼠标离开可暂停，但不能代表追踪置信与重新武装 | 竞品无足够证据，保守显式处理 | Medium |
| T08 暂停或恢复 | time/state 低 | Stage 只需冻结并遮罩；决定继续、重校准或退出是平面阅读/选择，不需要新空间对象 | 2D 暂停面板能完整呈现冻结快照与三个选项 | 避免用悬浮附件制造空间感 | Low；Stage 非必要，平面层足够 |
| T09 确认退出本局 | consequence/data trust 低 | 高风险确认应稳定、近场、不可与泡泡混淆；空间深度不增加决策质量 | 2D Dialog 明示“本局不保存”、取消/确认即可完整完成 | 不把危险操作放在装饰性空间控件 | Low；Stage 非必要，Dialog 必需 |
| T10 结算 | data comparison 低 | 准确率与分类统计是平面比较；徽章可有轻微深度但不要求 Stage | 2D 结果页完整且更易读 | 不复制健身排行墙 | Low；回到 Window |
| T11 系统生成/回收泡泡 | direction/distance/depth/simulation 高 | SafeArc 采样、Ribbon 穿越、角距与越界回收都依赖世界空间几何；这是 Stage 的核心必要性 | 2D 可验证对象池与生命周期，但无法证明背后/地下/近头禁区或真实前后轨迹 | 保留迎面空间运动，去除多轨高速 | High；Stage 必要 |
| T12 系统切换六段节奏 | time/state 低到中 | 30秒边界和配置原子切换本身是时间状态机；Stage 只承载切换后的泡泡/环境表现，不是计时必要条件 | 2D 状态机可完整验证六段顺序、冻结和不补发 | 音乐只提供结构，不驱动运动 | Low for logic；Stage 非必要于计时、仅用于结果表现 |

结论：Stage 只承载 T02–T07、T11–T12；T01、T08–T10 的信息与高风险确认坚持平面表达。空间价值来自前方方向、深度接近、身体动作与不触碰抑制的联合判定，不来自增加浮窗。

## 5. 三个实质不同的设计假设

| Hypothesis | 信息组织模型 | 空间化程度 | 容器策略 | 用户路径 | 主要交互 | 风险 / 工程成本 |
|---|---|---|---|---|---|---|
| A 前庭弧带实验室 | 游戏时只显示单一动作提示+时间；统计局后集中解释 | 中高：固定 SafeArc→Ribbon，环境安静、相机静止 | Shared Space 平面启动/结算 + 显式 Full Space Stage 游戏；暂停为受控层 | 启动→校准→三例教程→五档游戏→结算 | 胸前拍/抓/保持不动；控制器为验证后回退 | 需空间生成/手追踪/对象池，但边界固定可测试；舒适风险最低 |
| B 桌面泡泡温室 | 状态、分数、类别图例始终围绕桌面微缩场景 | 中：Volumetric 窗内微缩泡泡，手指近场操作 | 全程 Shared Space Volumetric，不进入 Stage | 打开温室→桌面校准→三分钟→同窗结算 | 指尖点/捏微缩泡泡 | 工程较低、易共存；但抓/拍变成小目标，空间价值弱且有56dp风险 |
| C 六瓣环形游园 | 六个30秒主题分别占前方环形扇区，信息随段迁移 | 很高：环境、目标与提示沿环形位置变化 | Full Space Progressive Stage，全程空间导航，无主平面窗 | 进入→跟随六区轮转→终点徽章空间揭示 | 双手动作+头部转向跟随 | 视觉独特但要求转头、离开中央舒适区；状态/遮挡/性能成本高 |

## 6. 概念选择矩阵

评分 1–5（5最佳）；每格含简短依据，舒适硬门不可由总分补偿。

| Hypothesis | 任务效率 | 空间价值 | PICO舒适 | 领域深度 | 安全 | 可达性 | 工程可行 | 独特性 | Overall | Verdict |
|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---|
| A 前庭弧带实验室 | 5 单焦点 | 5 深度+身体+抑制 | 5 固定前方 | 5 判定/时钟/池完整 | 5 不闪躲 | 5 坐站/回退 | 4 需Stage输入 | 5 三动作语法 | 39/40 | Selected |
| B 桌面泡泡温室 | 4 路径短 | 2 近似2D微缩 | 4 环境共存 | 3 判定简化 | 4 无全身压力 | 2 小目标风险 | 5 边界清楚 | 3 常见桌面玩具 | 27/40 | Rejected |
| C 六瓣环形游园 | 2 注意迁移 | 5 强空间变化 | 1 需转头 | 4 六段映射强 | 1 违反前方限定 | 2 坐姿困难 | 2 复杂 | 5 空间叙事强 | 22/40 | Rejected |

- 选定概念：**前庭弧带实验室**——在静止 Full Space 中，仅让三类泡泡从前方远端缓慢进入固定胸前弧带，把空间价值集中到方向、距离与身体动作；阅读与结算回到平面窗。
- 市场定位：不是健身节奏游戏，而是一局三分钟、无需闪躲、可坐可站的低压空间抑制/反应实验。
- 差异证据：UXR2 M1/M2/M3 与 §3A 聚合机会。吸收 Beat Saber/Synth Riders 的迎面来向可读、即时反馈、音乐结构；避开其高速轨道/全身编舞，以及 OhShape 的大型逼近墙和躲避姿势；用“拍/抓/等它通过”、固定 Ribbon 和速度封顶落实质量契约。
- 拒绝 B：2D 反事实几乎等价，且微缩目标削弱动作区分并造成点击下限风险。
- 拒绝 C：违反 R04/P1 的中央前方与无需转身约束；舒适硬门不可由独特性补偿。
- 风险诚实性：A 的差异主要来自低压交互命题而非已验证的视觉新颖性；趣味与舒适仍需 U1/D2 真机研究。

## 7. 体验与容器架构

### 7.1 体验层

| 层 | 职责 | Host | 进入/退出 | fallback |
|---|---|---|---|---|
| 准备与复盘 | 三规则、坐/站、开始、最高分、结算分类、保存状态 | `LabConsole` Planar WindowContainer，Shared Space | 应用启动可见；明确“开始三分钟”进入校准；结算/退出回此窗 | Stage 不可开时仍可阅读规则与安全退出，不伪造可玩 |
| 空间校准 | 显示 SafeArc/Ribbon、确认可达高度/深度 | `ReflexStage`，Full Space Mixed | 从窗口明确确认打开 Stage；成功进入教程，失败重试/关 Stage | 跟踪/空间能力不可用则关闭 Stage 返回窗口 |
| 低压互动 | 教程、五档游戏、冻结暂停 | `ReflexStage`，Full Space Mixed | 校准成功进入；完成/确认退出关 Stage | 输入丢失超宽限则暂停；无已验证回退就安全退出 |

沉浸价值：Stage 仅为前方深度轨迹、身体拍/抓/抑制与实际可达校准服务；没有这些任务时回 Planar。

### 7.2 容器事实

- Space State：启动/结算为 Shared Space；打开任何 Stage 后切换 Full Space；不存在 Shared Space 内 Stage。
- `LabConsole`：WindowContainer `Planar`，承载 T01/T10 和 Stage 前后状态；深度固定 640dp。默认只显示一个主窗。
- `ReflexStage`：Stage `Mixed (immersion=0)`，真实环境可见以维持方向感；不请求 anchor/plane 权限。手姿能力是否请求取决于锁定 SDK，属于下游验证。
- Entry value：只有 Stage 能承载无边界前方 SafeArc 与身体直接互动；用户必须触发 `user.confirmStageEntry`。
- Stable exit：暂停→退出确认→关闭 Stage→Shared Space `ReadyHome`；完成也关闭 Stage→`RunResult`。
- 默认可见：Shared 时 LabConsole 1个；Full 时 ReflexStage 1个，LabConsole 不作为常驻漂浮面板。

## 8. Window Attachment 决策矩阵

| Need | placement | selected | host | semantic role | persistence/frequency | rationale | rejected options（含 InlineControl / None） | validation |
|---|---|---|---|---|---|---|---|---|
| 三规则与坐/站/开始 | in-window | InlineControl | LabConsole | 当前步骤操作 | 启动时常驻/每局一次 | 控件紧邻规则与姿态 | TabBar非页面切换；Toolbar非工具；None会缺操作；外置附件增加扫视 | 56dp、眼视+捏合 |
| 退出本局确认 | in-window modal | Dialog | ReflexStage pause layer | 高风险确认 | 条件触发 | 必须阻断误退出 | InlineControl 不足以隔离风险；None违反确认；SpatialPopup非模态 | 取消/确认/系统返回 |
| 暂停菜单 | in-window | InlineControl | ReflexStage pause layer | 继续/重校准/退出 | 暂停时持续 | 操作只作用当前冻结态 | Toolbar会像常驻工具；None无法恢复；Subwindow过重 | 冻结期间逐项触发 |
| 首次三类提示 | in-window anchored | Coachmark | ReflexStage | 一次性动作说明 | 教程每类一次 | 短文案靠近目标且不持续占位 | InlineControl会暗示按钮；None降低学习；Popup可能遮挡 | 教程三提示截屏与触发 |
| 时间/段落/当前动作 | none | None | ReflexStage | Stage 内原生HUD实体，不属窗口附件 | 游戏持续 | 不为HUD制造 WindowContainer 附件 | InlineControl无宿主内容；Augment仅围窗且无窗；Toolbar语义错误 | 核心65°×40°内检查 |
| 结算动作 | in-window | InlineControl | LabConsole | 再来一局/返回/重试保存 | 结算持续 | 紧邻结果 | TabBar/Toolbar均无价值；None缺后续路径 | 56dp与错误态 |

选择：无 TabBar、Toolbar、Subwindow、SpatialPopup、Augment；唯一附件语义为高风险 Dialog 与教程 Coachmark，其余 None/InlineControl。内容无重复导航。

## 9. Window sizing 推导

`LabConsole` 是熟悉的2D阅读/选择/比较任务，Planar(dp)，productivity/main content。官方起点1280×720dp、合法320×180～2700×1800dp、深度固定640dp；默认距离约1.75m，`worldScale=Dynamic`。坐/站、单次约5–30秒。

| Candidate | size | content/FOV tradeoff | verdict |
|---|---:|---|---|
| Constrained | 720×620dp | 单列，规则/统计内部滚动；56dp按钮与≥12dp正文成立；约核心FOV下部 | min |
| Default/Compact | 1120×720dp | 比1280基线窄，三规则一行或结算2列；核心内容估计≤65°×40° | selected |
| Large | 1440×840dp | 更宽但正文列限约50汉字；次要统计可并列，仍不得需转头 | max |

- content area：默认扣 96dp TitleBar 与四边32dp inset，约1056×560dp；无 Docked attachment overhead。
- floors：所有动作 hit target≥56×56dp；正文≥16sp（硬底12dp）；标题≥28sp；圆角32dp。
- 默认/最小/最大：1120×720 / 720×620 / 1440×840dp；均在官方范围。`ResizeRestriction=ContentSize`，限制两端以保证重排事实。
- aspect：非固定16:9；保持宽高范围，默认约14:9。
- Large：规则/分类统计3列；Compact/default：规则3列、结算2列；Constrained：全部单列、内部纵向滚动、主CTA固定底部，不整体缩放。
- FOV/occlusion：只有1个窗；核心主CTA/本局准确率在65°×40°，边缘帮助不越85°×55°；Dynamic只描述相对视场占用，不把dp声称为物理尺寸。移动/缩放大窗用渐隐，无快速位移。
- downstream validation：在 Large/Compact/Constrained 截图验证无裁切、56dp、12dp、≤50汉字/行；真机从1.75m检查FOV与坐站可读性。

`ReflexStage` 无固定dp窗口尺寸；SafeArc/InteractionRibbon 使用 Interaction3/PM4 的米制项目参数，不套用 Planar尺寸。

## 10. 状态图 / 转移图

| ID State | Main task / decision | Primary focus | Container / layout / components | Data | Entry | Exit | Exception / return |
|---|---|---|---|---|---|---|---|
| S0 ReadyHome | T01 开始/姿态 | 三规则+开始 | LabConsole；规则行+姿态+CTA | bestScore optional | app launch / Stage close | S1 | 无最佳显示“暂无”；系统返回退出app |
| S1 ArcCalibration | T02 接受/重试 | Ribbon轮廓 | ReflexStage；空间弧带+确认 | pose/calibration validity | confirm Stage entry | S2 | invalid→本态提示；close→S0 |
| S2 GuidedThree | T03–T06 各一次 | 单泡+动作词 | Stage；单目标+Coachmark+细计时 | tutorial script/input | calibration accepted | S3 at 30s | tracking→S4；失败仍继续下一示例并解释 |
| S3 GentleRun | T03–T07/T11–T12 | 最近可判定泡泡 | Stage；Ribbon+≤5泡+HUD | clock/tier/pool/judgments | tutorial complete/resume | S6 at 180s | tracking→S4；pool overflow回收并记telemetry |
| S4 FrozenPause | T08 | “已暂停”与三选择 | Stage冻结+近场不透明pause layer | frozen snapshot/fallback support | pause/tracking timeout | S3/S1/S5 | 恢复条件不足保持冻结；back=S3 |
| S5 ExitConfirm | T09 | 本局不保存 | Dialog，取消/退出≥56dp | run incomplete | exitRequested | S4 or S0 | system back=cancel to S4 |
| S6 RunResult | T10 | 准确率+分类+徽章 | close Stage→LabConsole；结果2列+CTA | RunLedger/save state | clock complete | S0 or S1 | save error保留本局+重试 |
| S7 InputUnavailable | T07 | 输入不可用说明 | Frozen Stage + safe-exit panel | tracking/fallback matrix | no valid input from S2/S3 | S4 or S0 | 不启用未验证fallback；恢复需re-arm |

| Transition ID | Start→Target | Trigger | action | confirm |
|---|---|---|---|---|
| TR01 | S0→S1 | `user.confirmStageEntry` | validatePosture;openStage;beginCalibration | yes |
| TR02 | S1→S2 | `calibration.accepted` | freezeReference;startSegmentClock | yes |
| TR03 | S1→S0 | `user.cancelCalibration` | closeStage | yes |
| TR04 | S2→S3 | `clock.reaches30` | switchTierT1;switchThemeAudioAtomically | no |
| TR05 | S2/S3→S4 | `user.pause` | freezeClockSpawnerMotionJudgementAudio | no |
| TR06 | S2/S3→S7 | `tracking.graceExpired` | inhibitJudgement;freezeRun;evaluateFallback | no |
| TR07 | S7→S3 | `input.verifiedAndRearmed` | resumeFrozenSnapshot | no |
| TR08 | S4→S3 | `user.resume` | resumeWithoutCatchup | no |
| TR09 | S4→S1 | `user.recalibrate` | retainFrozenRun;showRibbonCalibration | yes |
| TR10 | S4→S5 | `user.requestExit` | openExitDialog | yes |
| TR11 | S5→S4 | `user.cancelExit` / system back | closeDialog | no |
| TR12 | S5→S0 | `user.confirmExit` | discardIncompleteRun;returnAll;closeStage | yes |
| TR13 | S3→S6 | `clock.reaches180` | freeze;finalizeLedger;returnAll;closeStage;saveBest | no |
| TR14 | S6→S1 | `user.replay` | openStage;beginCalibration | yes |
| TR15 | S6→S0 | `user.returnHome` | clearResultFocus | no |
| TR16 | S6→S6 | `user.retrySave` | retryBestWrite;showStatus | no |

## 11. 端到端流

`S0 →(明确确认) S1 → S2 → S3 → S6 → S0/重玩`；S2/S3 可进入 S4/S7，S4 经 S5 确认退出。任何 Full Space 状态均有关闭 Stage 回 Shared 的稳定路径；暂停/追踪丢失冻结且不补发。

## 12. 眼手与回退交互规范

- 所有平面可操作元素支持眼视聚焦+捏合；focused 使用2dp高亮描边+1.03x，120ms ease-out，不依赖颜色。
- Stage 直接动作：普通泡泡=开放手掌速度越过 0.35m/s 且接触；金泡=手进入把手体积后抓握阈值成立≥120ms；灰泡任何有效接触=`touched`，不要求身体移动。
- 300ms 瞬失：保持目标姿态快照、禁止新 Judgement；恢复后手需离开碰撞体≥80mm再 re-arm，避免恢复瞬间误判。
- 控制器：仅通过 device×OS×SDK 验证后显示；扳机射线确认普通泡泡，抓取键确认金泡；灰泡仍以不触碰为成功。未验证路径不可见且不宣称可用。
- system back：S2/S3→S4；S4返回恢复；S5返回取消；S1返回需确认关闭Stage；S6返回S0。
- 高风险：Stage entry、重校准（改变空间参考）、退出未完成本局均明确确认；Dialog含取消与确认，焦点默认在取消。
- 错误恢复：pool耗尽跳过生成并记诊断，不新增实例；越界立即回池；校准无效停在S1；保存失败保留本局结果并提供重试。

| Gesture/input | target | condition | action | feedback |
|---|---|---|---|---|
| gaze+pinch | ≥56dp control | focused且enabled | activate once | stroke+短音+可选触觉 |
| palm slap | normal BubbleActor | armed+Ribbon+velocity threshold | emit hit once | 破裂缩散+“拍中了” |
| hand grab | gold BubbleActor | handle volume+grip 120ms | emit grab once | 环收束+“抓住了” |
| no contact | gray BubbleActor | passes Ribbon uncontacted | emit untouched once | 横杠柔亮+“做得好，没碰它” |

## 13. Motion Spec

| motion | trigger/purpose | duration | easing | amplitude | Reduce Motion | performance fallback |
|---|---|---:|---|---|---|---|
| Stage enter | TR01空间准备 | 500ms | (0,0,0.2,1) | 仅环境fade；无相机位移 | 250ms fade | 直接opacity，无blur |
| Bubble drift | lease→Ribbon | 由0.22–0.48m/s与距离确定 | linear | 只目标世界位移，相机0 | 保留必要轨迹，去除轻浮摆动 | 禁粒子/动态反射 |
| Normal hit | Judgement.hit | 240ms | (0,0,0.2,1) | scale 1→1.08→0.85，碎片≤0.12m | 140ms dissolve | 单环fade |
| Gold grab | Judgement.grab | 280ms | (0.2,0,0,1) | handle收束≤0.06m | 160ms luminance fade | 静态勾形+fade |
| Gray untouched | pass Ribbon | 220ms | standard | 横杠opacity，位移0 | 120ms opacity | 文本替代 |
| Segment theme | clock boundary | 800ms | standard | 环境颜色crossfade；相机0 | 400ms crossfade | 单次颜色切换，无渐变动画 |
| Pause | TR05/TR06 | 180ms | ease-out | 所有世界实体位移立即0；面板fade | 100ms fade | opaque panel |
| Window/Stage exit | TR13/TR12 | 350ms | ease-in-out | fade，无强制视野移动 | 180ms fade | direct state switch |
| focused | gaze | 120ms | ease-out | ≤1.03x | 描边-only | 描边-only |

全局可达性：`reduceMotion=enabled`、`controllerFallback=conditional_verified`、`colorIndependentSemantics=enabled`、`textScaling=enabled_reflow_no_global_scale`、`stableExit=enabled`。禁止镜头运动、持续闪烁与大面积快速位移；音乐层切换不改变泡泡速度。

## 14. 构图综合与布局几何

### 14.1 LabConsole · ReadyHome / RunResult

| Fact | ReadyHome | RunResult |
|---|---|---|
| derivation | T01 高频一次性决策；三规则并列同级；开始为唯一主动作 | T10 先判断整体准确率，再比较三类，最后选下一步 |
| primaryFocusCount | 1=`开始三分钟` | 1=`准确率+徽章` |
| regions | title 96；rule strip 184；posture/status 120；CTA 96 | hero 160；category stats 216；best/save 88；actions 96 |
| density ceiling | 最多3条规则+2姿态+1主CTA；无调试信息 | 1总指标+3分类+1最佳+2动作；错误只占一行 |
| responsive | Large规则3列；Compact同；Constrained规则单列滚动，CTA底部固定 | Large/Compact统计3列或2+1；Constrained单列，hero始终首屏 |
| rejected | 左侧导航+右侧内容：制造Dashboard且增加扫视 | 排行榜墙：不服务个人三分钟复盘；饼图：精确类别数更难读 |

LabConsole anchor=center, x=0,y=0,w=1120,h=720,z=20dp logical; contentInset=32dp；Constrained 720×620，Large 1440×840。TitleBar 96dp 已在尺寸推导扣除。

### 14.2 ReflexStage · Calibration / Tutorial / Run / Pause

| State | Derivation / single primary focus | Regions / world geometry | Density | Responsive / exception | Rejected |
|---|---|---|---|---|---|
| S1 Calibration | T02；focus=Ribbon舒适确认 | SafeArc yaw±32°, pitch±18°,1.6–2.4m；Ribbon depth0.75–1.05m,height0.85–1.45m；确认面板视线下8°、0.9m | 1 Ribbon+2 actions | 坐/站使用同一相对舒适逻辑；invalid只显示原因+重试 | 手动拖拽多个锚点：复杂且易越界 |
| S2 Tutorial | T03–T06；focus=当前唯一泡泡 | 目标沿前向从1.6–2.4m到Ribbon；动作词在目标上方约10°；Coachmark不遮手 | 同时1泡+1提示+时间细弧 | tracking exception冻结原位；每类仅一次 | 三规则同时展示：分散首次动作学习 |
| S3 Run | 最近进入Ribbon的可判定目标 | 泡泡≤5；目标间yaw角距≥12°；主交互保持核心65°×40°；时间细弧在上方 | 最多5泡+1动作词+1时间/段提示；无常驻统计卡 | 目标重叠时延迟生成而非缩小；越界立即回池；Constrained不适用Stage | 环形六区与多轨：要求转头、接近竞品套路 |
| S4/S7 Pause | focus=已暂停/输入不可用 | 冻结世界；不透明面板中心0.85m、视线下6°；按钮纵列≥56dp | 标题+状态+最多3动作 | 未验证手柄不显示为可用；安全退出始终可见 | Toolbar：语义错误且暂停前后常驻 |

深度语义：环境 z0；SafeArc/Ribbon z1；泡泡随世界深度 z2→z3；动作提示与暂停层最靠近 z4。重要性由近距+大小+轮廓共同表达，不靠颜色叠层。

### 14.3 Region ownership / placement

| layer | anchor | x/y | w/h | z | owner |
|---|---|---|---|---|---|
| LabConsole | view center | 0/0 | 1120/720dp default | 20dp logical | ReadyHome/RunResult regions |
| InteractionRibbon | calibrated head-forward | yaw0°, y0.85–1.45m | yaw64° span / depth0.30m | 0.75–1.05m distance | BubbleField |
| SafeArc | calibrated head-forward | yaw±32°/pitch±18° | radial 1.6–2.4m | world | SpawnDirector |
| ActionCue | target-facing | target x / +0.18m | max angular width 18° | 0.08m nearer than target | RuleCue |
| PauseLayer | view center fixed at pause | 0/−6° | within core FOV | nearest | PauseCard/Dialog |

所有布局均从任务/数据关系、频率、FOV与选定 D1 推导，无 layout ID、模板或案例结构。

## 15. Minimum Completeness Gate（Stage 5 局部）

| Check | Evidence | Verdict |
|---|---|---|
| 原则有依据、落点与冲突优先级 | §2 | pass |
| 每个任务含输入/决策/错误/频率/依赖 | §3 | pass |
| 竞品功能列用于覆盖检查且未复制路径 | §3.3 | pass |
| 空间价值含2D反事实 | §4 | pass |
| 三假设实质差异、矩阵和拒绝理由 | §5–§6 | pass |
| 容器、附件、尺寸链 | §7–§9 | pass |
| 状态/转移/异常/稳定退出 | §10–§11 | pass |
| 布局含推导/单焦点/区域/密度/响应/拒绝项 | §14 | pass |
| 眼手/回退/高风险/错误恢复 | §12 | pass |
| motion含时长/幅度/减弱动效/性能fallback | §13 | pass |
| 全文最终完整度 | §2–§14 | pass |

`minimumCompletenessGate=pass`
