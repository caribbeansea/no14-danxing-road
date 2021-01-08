package com.caribbeansea.modules.font;

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
 * Creates on 2021/1/4.
 */

import com.caribbeansea.engine.component.GameFont;
import com.caribbeansea.modules.resources.ImageResources;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author tiansheng
 */
public class Font1 extends GameFont
{

    public Font1()
    {
        this(ImageResources.FONT_1, 10, 10);
    }

    public Font1(ImageResources resources)
    {
        super(resources);
    }

    public Font1(ImageResources resources, int w, int h)
    {
        super(resources, w, h);
    }

    @Override
    public BufferedImage getLetter(int x, int y)
    {
        return SPRITESHEET.getSubimage(x * w, y * w, w, h);
    }

    @Override
    public Image getFont(char ch)
    {
        int value = ch;
        int x = value % spriteWidth;
        int y = value / spriteWidth;

        return getLetter(x, y);
    }

}
