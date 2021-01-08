package com.caribbeansea.caribbean.engine.bootstrap

/* ************************************************************************
 *
 * Copyright (C) 2020 caribbeansea All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ************************************************************************/

/*
 * Creates on 2021/1/5.
 */

import com.caribbeansea.caribbean.engine.__initable
import com.caribbeansea.caribbean.engine.bootstrap.__bootstrap.__DIMENSION__
import com.caribbeansea.caribbean.engine.state.__state_manager

import java.awt.Dimension
import javax.swing.JFrame


/**
 * 游戏启动器，这个启动器的作用就是整合了我们的（JPanel、JFrame）不需要我们
 * 去单独配置它们两个的各项参数。{@link javax.swing.JPanel} & {@link javax.swing.JFrame}
 * <p>
 * 所有统一参数会在启动器中去进行配置，也可以抽成配置文件进行配置。看用户自己的需求而定。
 *
 * @param panel 游戏面板，所有的图像都画在它上面。
 * @author tiansheng
 */
abstract class __bootstrap(var panel: __panel) extends __initable {

  /**
   * 是否显示窗体，默认为true
   */
  var visible: Boolean = true

  /**
   * 当游戏关闭时程序也随之关闭, 默认为 true
   */
  var exit_on_close: Boolean = true

  /**
   * 当游戏启动时默认居中显示
   */
  var centered: Boolean = true

  /**
   * 窗体对象，所有的参数配置实际上都是在配置它。
   */
  val frame: JFrame = new JFrame()

  /**
   * 构造器，里面调用初始化方法
   */
  def this() {
    this(null)
    init() /* 所有成员配置都使用它来配置 */

    if (this.panel == null && panel != null)
      this.panel = panel

    frame.setSize(__DIMENSION__)

    if (exit_on_close)
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    if (centered)
      frame.setLocationRelativeTo(null)

    frameConfigure(frame) /* 用户对 __frame 的自定义配置*/

    if (panel != null) {
      frame.setContentPane(panel) /* 添加面板 */
    }

    frame.setVisible(visible)
  }

  /**
   * 设置窗口标题
   */
  def title(title: String): Unit = frame.setTitle(title)

  /**
   * 设置窗体大小
   *
   * @param w 窗口宽度
   * @param h 窗口高度
   */
  def size(w: Int, h: Int): Unit = __DIMENSION__.setSize(w, h)

  /**
   * @return 当前窗口的尺寸大小
   */
  def size(): Dimension = __DIMENSION__

  /**
   * 如果有特殊需要去单独配置 __frame 的话可以去重写这个方法进行配置。
   *
   *
   * @param frame __frame实例
   */
  def frameConfigure(frame: JFrame): Unit = {
    // do nothing
  }

  /**
   * 添加游戏面板
   *
   * @param panel 面板对象
   */
  def addPanel(panel: __panel): Unit = this.panel = panel

}

object __bootstrap {

  /**
   * 窗口的尺寸（宽高），默认是一个 500*500 大小的窗口。
   * <p>
   * 这个窗体的长宽高是具有传递性的，也就是说在我们的{@link __panel},{@link __state_manager},
   * {@link com.caribbeansea.caribbean.engine.state.__state}等对象中全局通用的。
   */
  var __DIMENSION__ : Dimension = new Dimension(500, 500)

}
