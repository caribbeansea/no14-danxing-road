package com.caribbeansea.caribbean.engine.animation

import com.caribbeansea.caribbean.engine.render.{__depict, __renderer}
import com.caribbeansea.caribbean.engine.sprites.__sprites

import java.awt.Graphics
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
 * 游戏动画
 *
 * @author tiansheng
 * @param frames 每帧动画图片数组
 * @param delay   播放延迟，默认为2。代表每调用两次播放一次
 */
class __animation(val frames: Array[BufferedImage], val delay: Int) extends __renderer {

  /**
   * 当前播放到了第几帧
   */
  var _current_frames: Int = 0

  /**
   * 播放次数
   */
  var _time_played: Int = 0

  /**
   * 辅构造器
   *
   * @param frames 每帧动画图片数组
   */
  def this(frames: Array[BufferedImage]) = this(frames, 2)

  /**
   * 实现此方法进行图像渲染
   */
  override def render(depict: __depict): Unit = {

  }

}
