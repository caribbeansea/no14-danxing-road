package com.caribbeansea.caribbean.engine.render

import java.awt.Graphics

/**
 * 图像渲染接口
 */
trait __renderer {

  /**
   * 实现此方法进行图像渲染
   */
  def render(depict: __depict): Unit

}
