# 加勒比2D游戏引擎

> 这个游戏引擎是为Java开发者而打造的一个简单且能够快速上手的游戏引擎。为了就是弥补我们Java开发者
> 没有一个可用游戏引擎的悲哀。
> 所以对于我们Java开发者来说通常我们要开发游戏都需要去
> 学习`C/C++`或者是`C#`等在Windows平台上著名的游戏引擎支持的语言。
> 
> 游戏是一种艺术，它能够直观的表达出你想象中的世界以及你对任何事物的憧憬与幻想。所以为了弥补我们Java开发者没有
> 好的游戏引擎的悲哀我决定开发了这款游戏引擎。

**首先我这里回答大家脑袋里最多的几个问题，来方便大家理解Java做游戏到底行不行。**

**1）为什么那么多人说Java不适合做游戏？**

Java适合做游戏吗？对此我的答案是肯定的，Way not？当然是可以做游戏的。为什么我们说`C/C++`性能很高，因为它可以做到`直接访问`。什么叫直接访问呢？
就是说我们可以直接去操作内存，但是这就避免不了要手动的去管理内存。

Java有`GC`，这是一个非常好的功能。避免我们去手动管理内存从而大幅度的提升了开发效率。可是GC会出现停顿。
所以在`分代模型`以前GC的停顿时间完全就是取决于我们的堆里面的垃圾有多少。

我们在`JDK1.8`以及以前使用的`Parallel/CMS`等分代模型的GC他们的GC回收时间都是不可控的。

但是当我们`G1`、`ZGC`、`shenandoah`这种跨时代的GC出现后，我们用Java做的游戏性能将得到大幅度的提升和改善。
因为这些GC他们的回收时间基本会控制在`10ms`,G1需要手动设置。

所以对于10毫秒的延迟基本上是不会影响游戏整体的性能的。

**2) Java不能调用DirectX和openGL**

`DirectX`和`openGL`是用于实现硬件加速以及图像的渲染速度的，在`JavaFX`出现之前我们的GUI开发一共有两大体系，`awt`和`swing`。awt和swing都是对
图形渲染接口的封装。

为什么Java的UI那么丑，起初GUI的开发团队是想实现跨平台的，用系统的基本的样式。但是考虑到当时win对DirectX支持好但是对openGL的支持不是很好。

而OSX上对openGL支持非常好，但是不支持DirectX所以JavaGUI的开发团队就完全排除了系统的自带样式使用了从出来就被唾弃到现在的UI。

**转折点**

当FX出来后，与JDK脱离了之后就支持在各个平台打不同的包，并且支持`DirectX和openGL`进行`硬件加速`做到高性能的图形渲染。

***所以如果在Fx出来之前你问我Java适合开发游戏吗？我的回答一定是不是很适合。但是现在我可以告诉大家，Java适合开发游戏！***


# Caribbean 2D Game Engine

> This game engine is a simple and quick-to-use game engine for Java developers. In order to make up for us Java developers
> The sorrow of not having a game engine available.
> So for us Java developers, we usually need to develop games
> Learn `C/C++` or `C#` and other languages ​​supported by famous game engines on the Windows platform.
>
> Game is a kind of art, it can directly express the world in your imagination and your longing and fantasy about anything. So in order to make up for our Java developers
> The sadness of a good game engine I decided to develop this game engine.

**First of all, I am here to answer the most common questions in your head to help you understand whether Java is good for games.**

**1) Why do so many people say that Java is not suitable for games?**

Is Java suitable for games? My answer to this is yes, Way not? Of course you can play games. Why do we say that `C/C++` has high performance, because it can do `direct access`. What is direct access?
That is to say, we can directly manipulate the memory, but this unavoidable to manually manage the memory.

Java has `GC`, which is a very good feature. It avoids us to manually manage memory, which greatly improves development efficiency. But the GC will pause.
So before the `generational model`, the pause time of GC depends entirely on the amount of garbage in our heap.

The GC collection time of the generational model such as the `JDK1.8` and the previous use of `Parallel/CMS` is uncontrollable.

But when we see the emergence of cross-epoch GC such as `G1`, `ZGC`, and `shenandoah`, the performance of our games made with Java will be greatly improved and improved.
Because the recovery time of these GCs is basically controlled at `10ms`, G1 needs to be set manually.

Therefore, the 10 millisecond delay will basically not affect the overall performance of the game.

**2) Java cannot call DirectX and openGL**

`DirectX` and `openGL` are used to achieve hardware acceleration and image rendering speed. Before the emergence of `JavaFX`, our GUI development had two major systems, `awt` and `swing`. awt and swing are both right
The encapsulation of the graphics rendering interface.

Why is the Java UI so ugly? At first, the GUI development team wanted to achieve cross-platform, using the basic style of the system. But considering that win had good support for DirectX but not very good support for openGL.

OSX supports openGL very well, but does not support DirectX, so the JavaGUI development team completely ruled out the system’s own style and used the UI that has been cast aside since it came out.

**Turning Point**

When FX came out, it was separated from the JDK to support different packages on various platforms, and support `DirectX and openGL` for `hardware acceleration` to achieve high-performance graphics rendering.

***So if you ask me before Fx comes out, is Java suitable for game development? My answer must be very suitable. But now I can tell you that Java is suitable for developing games!***