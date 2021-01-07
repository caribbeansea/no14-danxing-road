package com.caribbeansea.caribbean.engine.sprites

import com.caribbeansea.caribbean.engine.sprites.__sprites.__DEFAULT_TILE_SIZE__
import com.caribbeansea.caribbean.engine.tool.{__double_for_achieve, __tool_for_java}

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
 * Sprites是个用于角色、道具、炮弹以及其他2D游戏元素的二维图形对象。2D游戏的图像部分主要是图片的处理，
 * 图片通常称为Sprite精灵。
 * <p>
 * 为了提高2d游戏的效率，会将图片资源拼接成一张大图，在游戏运行的时候在将这张图的莫一部分读取出来作为Sprite显示在屏幕上
 * 该图形是基于Texture2D得到的图像。Sprite类主要识别图像的一部分用于特定的精灵。
 * <p>
 * 此类通过游戏对象上的{@link com.caribbeansea.engine.game.GameRender}的组件应用并实际显示该图像。
 *
 * @param _sprite_sheet 完整的精灵图片
 * @param _rect_width   矩形宽度
 * @param _rect_height  矩形高度
 * @author tiansheng
 */
class __sprites(val _sprite_sheet: BufferedImage, val _rect_width: Int, val _rect_height: Int) {

  /**
   * 精灵图片宽度
   */
  var _sprite_width: Int = _sprite_sheet.getWidth() / _rect_width

  /**
   * 精灵图片高度®
   */
  var _sprite_height: Int = _sprite_sheet.getHeight() / _rect_height

  /**
   * 精灵图集数组
   */
  var _sprite_array: Array[Array[BufferedImage]] = {
    /* 生成一个二维数组 */
    val _sprite_array = Array.ofDim[BufferedImage](_sprite_height, _sprite_width)

    /* FIXME: 垃圾SCALA，还要我这样写for循环 */
    __tool_for_java.__double_for__(_sprite_height, _sprite_width, new __double_for_achieve() {
      override def achieve(x: Int, y: Int): Unit = {
        _sprite_array(x)(y) = _sprite_sheet.getSubimage(y * _rect_height, x * _rect_width, _rect_width, _rect_height)
      }
    })

    _sprite_array /* return */
  }

  /**
   * 构造器
   *
   * @param _sprite_sheet 完整的精灵图片
   */
  def this(_sprite_sheet: BufferedImage) = this(_sprite_sheet, __DEFAULT_TILE_SIZE__, __DEFAULT_TILE_SIZE__)

  /**
   * 获取子精灵图
   *
   * @param x 初始X坐标
   * @param y 初始Y坐标
   * @return 子精灵
   */
  def subsprites(x: Int, y: Int): BufferedImage = _sprite_array(x)(y)

}

object __sprites {

  /**
   * 默认矩形宽高
   */
  val __DEFAULT_TILE_SIZE__ : Int = 32;

}