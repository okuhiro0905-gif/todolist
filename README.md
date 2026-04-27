Quadrant Planner · 四象限待办应用
📌 项目简介

Quadrant Planner 是一个基于「时间管理四象限法则」设计的待办事项应用，帮助用户按照“重要 / 紧急”维度对任务进行分类，从而更高效地安排时间。

项目以移动端体验为核心，支持添加到手机桌面（PWA），提供接近原生 App 的使用方式。

🚀 在线体验

👉 https://okuhiro0905-gif.github.io/todolist/

✨ 核心功能
📝 任务管理
添加 / 删除 / 标记完成任务
使用 localStorage 持久化数据
🧭 四象限分类
重要且紧急
重要不紧急
紧急不重要
不重要不紧急
🔀 拖拽排序（核心功能）
支持任务自由拖拽排序
支持跨象限拖拽（自动改变任务类别）
拖拽结果自动保存
📅 日历视图
查看每日任务分布
支持按日期筛选任务
📱 PWA 支持
可添加到 iPhone 主屏幕
支持离线访问（Service Worker）
🛠 技术实现
HTML / CSS / JavaScript（原生实现）
localStorage 数据持久化
原生 Drag & Drop API 实现排序逻辑
Service Worker 实现离线缓存
GitHub Pages 静态部署
🎯 项目亮点
📱 移动端优先设计（非简单网页适配）
🔥 跨象限拖拽交互（核心亮点）
⚡ 零依赖实现（无框架）
🧠 将时间管理方法论产品化
🧩 完整实现从 UI 到数据逻辑的闭环
📷 项目预览


<img width="1536" height="1024" alt="quadrant-planner-showcase-01" src="https://github.com/user-attachments/assets/350f6f62-a010-4432-ba00-f8139ae7247e" /><img width="1536" height="1024" alt="quadrant-planner-showcase-02" src="https://github.com/user-attachments/assets/e8f59bd6-c110-4529-b456-3e1b696f67a0" />


四象限主界面
拖拽排序界面
日历视图
📱 使用方式
使用 Safari 打开在线链接
点击底部「分享」按钮
选择「添加到主屏幕」
从桌面图标启动应用
🔮 后续优化方向
☁️ 云端同步（多设备数据共享）
🔐 用户登录系统
🎨 UI 动画优化
📊 任务数据统计分析
👨‍💻 关于作者

这是一个个人独立完成的前端项目，用于练习：

产品设计能力
移动端 Web 开发
交互与状态管理实现

新增：
本项目最初为 localStorage 版 TodoList PWA。
正在设计追加 Spring Boot 后端 API，并连接 MySQL 数据库，实现任务数据的持久化保存。
前端通过 fetch 调用 REST API，实现任务的查询、新增、更新、删除和排序。

欢迎交流与改进建议。
