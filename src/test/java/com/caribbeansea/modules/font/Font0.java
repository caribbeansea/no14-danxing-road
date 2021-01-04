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
public class Font0 extends GameFont
{

    public Font0()
    {
        this(ImageResources.FONT_0, 16, 16);
    }

    public Font0(ImageResources resources)
    {
        super(resources);
    }

    public Font0(ImageResources resources, int width, int height)
    {
        super(resources, width, height);
    }

    @Override
    public BufferedImage getLetter(int x, int y)
    {
        return null;
    }

    @Override
    public Image getFont(char ch)
    {
        int value = ch - 65;
        int x = value % spriteWidth;
        int y = value / spriteWidth;

        return getLetter(x, y);
    }

}
