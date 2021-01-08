package com.caribbeansea.engine.component;

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
 * Creates on 2021/1/3.
 */

import com.caribbeansea.modules.resources.ImageResources;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 游戏字体
 *
 * @author tiansheng
 */
public abstract class GameFont extends Sprites
{

    public GameFont() {}

    public GameFont(ImageResources resources)
    {
        super(resources);
    }

    public GameFont(ImageResources resources, int w, int h)
    {
        super(resources, w, h);
    }

    /**
     * 获取字母对应的Image
     *
     * @param x 字符在整张图片中对应的X轴坐标位置
     * @param y 字符在整张图片中对应的Y轴坐标位置
     * @return 字符图片
     */
    public abstract BufferedImage getLetter(int x, int y);

    /**
     * 获取字体图片
     *
     * @param ch char
     * @return 对应的字符图片
     */
    public abstract Image getFont(char ch);

}
