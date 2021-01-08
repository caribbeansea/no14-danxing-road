package com.caribbeansea.caribbean.engine.render

import java.awt.{Color, Graphics}
import java.awt.image.BufferedImage

/* ************************************************************************
 *
 * Copyright (C) 2020 caribbeansea All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

/**
 * @author tiansheng
 * @param graphics 画图需要使用的对象（画笔）
 * @param x        初始X坐标
 * @param y        初始Y坐标
 * @param w        初始宽度
 * @param h        初始高度
 */
class __depict(private var graphics: Graphics, var x: Int, var y: Int, var w: Int, var h: Int) {

  /**
   * 辅构造器，只传入画笔对象
   *
   * @param graphics 画笔
   */
  def this(graphics: Graphics) = this(graphics, 0, 0, 0, 0)

  /**
   * 画一个边框
   *
   * @param x 矩形X坐标
   * @param y 矩形Y坐标
   * @param w 矩形宽度
   * @param h 矩形高度
   */
  def _fill_rect(x: Int, y: Int, w: Int, h: Int): Unit = {
    graphics.fillRect(x, y, w, h)
  }

  /**
   * 设置颜色
   *
   * @param color 颜色对象
   */
  def _set_color(color: Color): Unit = {
    graphics.setColor(color)
  }

  /**
   * 在屏幕上画图像，默认的四个参数【x,y,w,h】为对象自带的四个
   * 参数。也就是构造器上面的参数。
   *
   * @param image 被画的图片
   */
  def _draw_image(image: BufferedImage): Unit = {
    _draw_image(image, x, y, w, h)
  }

  /**
   * 在屏幕上画图像
   *
   * @param image 图片
   * @param x     初始X坐标
   * @param y     初始Y坐标
   * @param w     画出来的图片宽度
   * @param h     画出来的图片高度
   */
  def _draw_image(image: BufferedImage, x: Int, y: Int, w: Int, h: Int): Unit = {
    graphics.drawImage(image, x, y, w, h, null)
  }

  def x(x: Int): Unit = this.x = x

  def y(y: Int): Unit = this.y = y

  def width(w: Int): Unit = this.w = w

  def height(h: Int): Unit = this.h = h

}
