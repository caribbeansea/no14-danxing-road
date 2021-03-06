package com.caribbeansea.caribbean.engine.process

import com.caribbeansea.caribbean.engine.handler.{__key_handler, __mouse_handler}

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
 * 游戏设备输入监听器
 *
 * @author tiansheng
 */
trait __inputer {

  /**
   * 设备输入接口
   *
   * @param key_handler   键盘输入
   * @param mouse_handler 鼠标输入
   */
  def input(key_handler: __key_handler, mouse_handler: __mouse_handler): Unit

}
