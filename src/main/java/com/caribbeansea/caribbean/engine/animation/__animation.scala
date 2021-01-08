package com.caribbeansea.caribbean.engine.animation

import com.caribbeansea.caribbean.engine.process.__updater
import com.caribbeansea.caribbean.engine.render.{__depict, __renderer}
import com.caribbeansea.caribbean.engine.tool.__tool_box

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
 * @param delay  播放延迟，默认为1毫秒播放一次
 */
class __animation(val frames: Array[BufferedImage], var delay: Int = 1)
  extends __renderer with __updater {

  /**
   * 当前播放到了第几帧
   */
  var current_frames: Int = 0

  /**
   * 播放次数
   */
  var time_played: Int = 0

  /**
   * 调用次数统计
   */
  var call_count: Int = 0

  /**
   * 动画播放速度控制
   */
  var speed: Long = System.currentTimeMillis()

  /**
   * 辅构造器
   *
   * @param frames 每帧动画图片数组
   */
  def this(frames: Array[BufferedImage]) = this(frames, 2)

  /**
   * 实现这个接口进行游戏更新
   */
  override def update(): Unit = {}

  /**
   * 实现此方法进行图像渲染
   */
  override def render(depict: __depict): Unit = {

    if (delay == -1) return

    /* 到达延迟后播放下一帧 */
    if (__tool_box.__interval_millis__(speed) >= delay) {
      speed = System.currentTimeMillis();
      current_frames += 1
    }

    /* 如果当前调用帧数到达最后一帧后就重置回0 */
    if (current_frames == frames.length) {
      current_frames = 0
      time_played += 1
    }

    depict._draw_image(frames(current_frames))

  }

}
