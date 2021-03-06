# 单行路14号(no14-danxing-road)

CODE: S20200214E20201115

> 一个虚拟的故事，带着我最开始对未来的无限向往和憧憬。在另一个时空也许你们的故事会一直被续写下去。也或许和我们一样带着遗憾离开。
>
> 我们的故事虽然结束了，但是你们的故事带着新的希望开始了！

# 项目介绍

no14-danxing-road中文叫做**单行路14号**，英文全称叫**danxing road 14 number**, 游戏中会还原整个周家坝、仁义村、光明村、怀远村以及怀远九义校等地方。
然后呢会根据小时候的各个时间线还原我们童年光着屁股做的那些幼稚又沙雕的事情，例如对我来说无非就是通宵上网, 天天被骂等事情。

但是我个人的能力始终是有限的，如果大家有兴趣参与到这个项目中来的话。那它会因为有你的存在而更加完整。

游戏风格为RPG，类似去月球这样的游戏！

# 参与规则

有能力的同学，并且了解GIT等版本控制工具的同学可以一起参与到这个项目的开发中，将你想停留的所有时间线定格在**单行路14号**。没有能力丹却有兴趣的同学可以参与地图的绘画工作中，
因为目前好多童年去过的地方早已换了模样，但或许你们还记得!

# Build no14-danxing-road

- `Jdk8`以上`JDK11`以下
- `Maven3.6.0`或以上

# 提交规范

    <type>(<scope>): <subject> #header

- `fix`修补BUG
- `conf`配置文件
- `docs`文档
- `feat`新功能或者文件等
- `refactor`重构代码
- `del`删除
- `release`发布版本
- `build`构建工具或过程等辅助类的变动
- `issue`议题
- `test`测试

例如：
    
    1. feat(Audio): 新增音频MP3音频播放
    2. fix(Audio): 修复音频播放阻塞问题

以上两个案例为什么需要加模块呢？即时这个模块不存在。原因是音频是概括了很多种格式的。mp3只是其中的
一种而已。所以它属于模块