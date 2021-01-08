package com.caribbeansea.caribbean.engine.entity

import com.caribbeansea.caribbean.engine.boundbox.__aabb
import com.caribbeansea.caribbean.engine.map.__vec2f
import com.caribbeansea.caribbean.engine.sprites.__sprites

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
 * 游戏对象实体
 *
 * @param sprites 游戏精灵
 * @param vec2f   地图数据
 * @param size    包围盒大小
 * @author tiansheng
 */
class __entity(val sprites: __sprites, var vec2f: __vec2f, var size: Int) {

  /**
   * 包围盒
   */
  var aabb: __aabb = {new __aabb}

  /**
   * 用于移动盒子等物体
   */
  var dx, dy: Float = 0F

}
