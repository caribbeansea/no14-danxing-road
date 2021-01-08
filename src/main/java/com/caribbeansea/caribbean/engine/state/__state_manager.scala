package com.caribbeansea.caribbean.engine.state

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

import com.caribbeansea.caribbean.engine.handler.__key_handler
import com.caribbeansea.caribbean.engine.handler.__mouse_handler
import com.caribbeansea.caribbean.engine.process.__inputer
import com.caribbeansea.caribbean.engine.process.__updater
import com.caribbeansea.caribbean.engine.render.__depict
import com.caribbeansea.caribbean.engine.render.__renderer

import scala.collection.mutable.ArrayBuffer

/**
 * 状态管理器
 *
 * @author tiansheng
 */
class __state_manager extends __updater with __renderer with __inputer {

  /**
   * 状态列表
   */
  val states: ArrayBuffer[__state] = new ArrayBuffer[__state]()

  /**
   * 添加状态
   *
   * @param state 状态实例
   */
  def addState(state: __state): Unit = states += state /* 在数组末端插入元素 */

  /**
   * 实现这个接口进行游戏更新
   */
  override def update(): Unit =
    for (item <- states.filter(state => state.disable)) item.update()

  /**
   * 实现此方法进行图像渲染
   */
  override def render(depict: __depict): Unit =
    for (item <- states.filter(state => state.disable)) item.render(depict)

  /**
   * 设备输入接口
   *
   * @param key_handler   键盘输入
   * @param mouse_handler 鼠标输入
   */
  override def input(key_handler: __key_handler, mouse_handler: __mouse_handler): Unit =
    for (item <- states.filter(state => state.disable)) item.input(key_handler, mouse_handler)

}
