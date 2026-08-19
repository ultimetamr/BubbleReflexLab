# BubbleReflexLab 模拟器验收记录

日期：2026-08-14，增量复验 2026-08-17（Asia/Shanghai）  
设备：PICO managed emulator `emulator-5554`  
包名：`com.pico.swan.bubblereflex`

## 构建与自动测试

- `gradlew testDebugUnitTest assembleDebug`：PASS，13 tests，Debug APK 生成成功。
- Debug APK SHA-256：`363F36F06366C39D6A8B52EB576778E3828B199C156632E00F468E062476E916`。
- 10,000 个 `SafeFan.sample` 点全部满足：`z < -0.45m`、高度 `0.90–1.90m`、前向夹角不超过 38°，无背后/地下/近头顶生成。
- 首 30 秒在 1.5s / 6.5s / 11.5s 依次引入普通、金色、灰色，随后在 16.5s / 21.5s / 26.5s 加入三组舒缓复习波；首段共生成 9 个泡泡。
- 30–180 秒使用五张固定波次配方逐档增加数量与组合；全程漂移速度固定为 `0.24m/s`，提高响应感但不靠高速制造压力。
- 每个 30 秒边界在三套主题间循环；泡泡材质色板与舒缓音乐和声层同步切换，五级固定难度仍按原时间表推进。
- 所有侧方出生点沿三维速度向量汇聚到本局校准后固定的世界坐标互动区。
- 暂停后时间与全部泡泡 Transform 不变。
- 灰泡未触碰通过记正确；触碰记错误。
- 手势连续丢失 350ms 后进入暂停冻结。
- 手/手柄输入使用 900ms 来源租约；手柄以空间射线选中目标，暂停态拒绝回退输入。

## 模拟器短测

- APK streamed install：Success。
- 显式启动 `.platform.LaunchActivity`：Success。
- 最终 APK 自动短局输出：`ACCEPTANCE_PASS frontFan pause trackingGrace oobRecycle result`。
- 最终进行态观察 5 秒：进程 `com.pico.swan.bubblereflex` 存活。
- Logcat：未发现 `FATAL EXCEPTION` / `AndroidRuntime` 崩溃。
- 进行态确定性短测同时放置三类泡泡；屏幕中所有目标均位于用户正前方，没有背后、地下或近头顶目标。
- 普通泡与灰泡为透明 PBR 圆球泡泡；金泡为无外层薄膜的单层亮金黄色 PBR 球体。三类均不叠加色块或平面圆圈，并以大小和中文动作标签“拍/抓/别碰”辅助区分。
- 在 PICO Emulator 6.0.0 房间光照下复拍确认：金泡呈高饱和亮金黄色，没有橙红偏色；单层球体保留高光和环境反射。
- 2026-08-17 增量复验：开始游戏后完整面板自动收起为“03:00 · 展开”小按钮；收起态位于右下角固定世界坐标，展开态也使用固定世界坐标，代码中不再使用相机锚点。

## 真机短测

- 真机：PICO `B3110`（序列号 `PB314XHGKC160016G`），Android 16 / API 36，`arm64-v8a`，测试时电量 80%。
- 最新 Debug APK streamed install：`Success`；包路径位于真机 `/data/app/.../com.pico.swan.bubblereflex.../base.apk`。
- `.platform.LaunchActivity` 正常启动，系统 `mFocusedApp` 指向 `com.pico.swan.bubblereflex`，应用进程持续存活。
- 真机自动短局输出：`ACCEPTANCE_PASS frontFan pause trackingGrace oobRecycle result`。
- 真机能力报告：`hand=SUCCESS/SUPPORTED`；当前 `controller=PENDING/DEVICE_NOT_SUPPORTED`，手部主输入链路可用。
- 正常启动后 Spatial Stage 完成 `FirstFramePush`；日志未发现 `FATAL EXCEPTION` / `AndroidRuntime` 崩溃。
- `pico-cli capture screenshot` 返回 `ADB screencap returned non-PNG output: Capturing failed`；这是 Spatial 合成层无法通过普通 ADB 截图的设备限制，因此未伪造真机截图证据。

## 截图

- [教程态](screenshots/tutorial.png)
- [进行态](screenshots/gameplay.png)
- [最终金色材质模拟器实拍](screenshots/gold-color-final.png)
- [右下角固定收起态](screenshots/fixed-lower-right-ui.png)

## 边界

模拟器报告手部能力 `DEVICE_NOT_SUPPORTED`，手柄能力 `SUPPORTED`，但没有可重复的真实物理输入轨迹。因此本次自动验收覆盖构建、领域规则、Stage 渲染、运行稳定性、手柄射线数学与视觉安全；真实手部命中精度、手柄物理输入、疲劳与舒适度仍需头显实机验证。
