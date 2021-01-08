package com.caribbeansea.caribbean.engine

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

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
 * 资源加载器
 *
 * @author tiansheng
 */
object __resource_loader {

  /**
   * 读取ImageBuffered
   *
   * @param path 相对路径或者是绝对路径
   * @return BufferedImage实例
   */
  def __imageio_read__(path: String): BufferedImage = ImageIO.read(new File(path))

}
