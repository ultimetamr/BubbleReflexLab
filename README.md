# BubbleReflexLab / 泡泡反应室

PICO Spatial SDK `stage` 项目，包名 `com.pico.swan.bubblereflex`。一局固定三分钟：普通泡泡拍破、金色泡泡抓住、灰色泡泡保持不触碰；30 秒慢速教学后进入五级固定难度，三套柔和主题循环切换并保存本地最高分。

## 构建

```powershell
$Env:JAVA_HOME='C:\Users\Administrator\.jdks\corretto-17.0.13'
$Env:PATH="$Env:JAVA_HOME\bin;$Env:PATH"
.\gradlew.bat testDebugUnitTest assembleDebug
```

APK：`app/build/outputs/apk/debug/app-debug.apk`

## 模拟器

```powershell
pico-cli app install app/build/outputs/apk/debug/app-debug.apk -d emulator-5554
pico-cli app launch com.pico.swan.bubblereflex -d emulator-5554 --activity .platform.LaunchActivity
```

空间窗口不能可靠地用二维 `input tap` 自动操作。项目保留三个仅用于验收的启动参数：`captureMode=tutorial`、`captureMode=gameplay` 与 `captureMode=acceptance`；最后一个会自动验证前方生成、暂停冻结、追踪宽限、越界回收和结算并输出 `ACCEPTANCE_PASS`。

## 结构

- `domain/BubbleGame.kt`：三分钟流程、首 30 秒依次教学三类后加入舒缓复习波（共 9 个泡泡）、五张固定组合配方、恒定 `0.24m/s` 漂移、安全扇形、向固定校准区汇聚、对象池、输入租约、判定、统计、冻结与追踪宽限。
- `content/BubbleSceneRenderer.kt`：PICO Spatial ECS 泡泡实体池；普通泡与灰泡使用透明 PBR 球壳，金泡使用无外层薄膜、带黄色自发光底色的单层亮金黄色 PBR 球体，并以大小和中文动作标签辅助区分。
- `content/HomeStage.kt`：SpatialView、SpatialUI 面板、双手独立挥拍/捏合与双手柄输入、开始/游戏/暂停/结算；任意一侧仍被追踪时游戏保持运行，同一泡泡只结算一次。首页一次点击即采样校准并开始，首 30 秒在游戏内完成教程；结算可再来一局、返回开始或真正结束应用。
- `content/CalmMusicLayer.kt`：原创两小节五声音阶旋律，三套主题每 30 秒换调；教程到第五档从 88 BPM 温和提高到 108 BPM，并逐级加入短促协和和弦与闪光层，暂停或结算时真正暂停并清空音轨。
- `BubbleGameTest.kt`：13 项规则测试，覆盖前方安全采样、开局教学与复习数量、恒定漂移速度、五档难度与三套主题、固定区汇聚、暂停冻结、灰泡未触碰、追踪丢失、手柄射线、输入仲裁、校准限幅和越界回收。

设计事实与独立评审位于 `design-v3/`；旧的 `design/` 与 `design-v2/` 是明确保留的无效审计证据，不是实现输入。
