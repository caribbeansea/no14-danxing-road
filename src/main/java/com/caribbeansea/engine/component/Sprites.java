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
 * Creates on 2021/1/2.
 */

import com.caribbeansea.modules.resources.ImageResources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Sprites是个用于角色、道具、炮弹以及其他2D游戏元素的二维图形对象。2D游戏的图像部分主要是图片的处理，
 * 图片通常称为Sprite精灵。
 * <p>
 * 为了提高2d游戏的效率，会将图片资源拼接成一张大图，在游戏运行的时候在将这张图的莫一部分读取出来作为Sprite显示在屏幕上
 * 该图形是基于Texture2D得到的图像。Sprite类主要识别图像的一部分用于特定的精灵。
 * <p>
 * 此类通过游戏对象上的{@link com.caribbeansea.engine.game.GameRender}的组件应用并实际显示该图像。
 *
 * @author tiansheng
 */
public class Sprites
{

    protected final BufferedImage SPRITESHEET;

    protected BufferedImage[][] spriteArray;

    protected int width;

    protected int height;

    protected int spriteWidth;

    protected int spriteHeight;

    protected static final int TILE_SIZE = 32;

    public Sprites(ImageResources resources)
    {
        this(resources, TILE_SIZE, TILE_SIZE);
    }

    public Sprites(ImageResources resources, int width, int height)
    {
        this.width = width;
        this.height = height;

        this.SPRITESHEET = resources.getBufferedImage();

        this.spriteWidth = this.SPRITESHEET.getWidth() / width;
        this.spriteHeight = this.SPRITESHEET.getHeight() / height;

        loadSpriteArray();
    }

    public void setSize(int width, int height)
    {
        setWidth(width);
        setHeight(height);
    }

    public void loadSpriteArray()
    {
        this.spriteArray = new BufferedImage[spriteHeight][spriteWidth];

        for (int x = 0; x < spriteWidth; x++)
        {
            for (int y = 0; y < spriteHeight; y++)
            {
                spriteArray[y][x] = getSprite(x, y);
            }
        }
    }

    public BufferedImage getSprite(int x, int y)
    {
        return SPRITESHEET.getSubimage(x * width, y * height, width, height);
    }

    public void setWidth(int width)
    {
        this.width = width;
        this.spriteWidth = SPRITESHEET.getWidth() / this.width;
    }

    public void setHeight(int height)
    {
        this.height = height;
        this.spriteHeight = SPRITESHEET.getHeight();
    }

    public BufferedImage[] getSpriteArray(int i)
    {
        return this.spriteArray[i];
    }

    public BufferedImage[][] getSpriteArray2(int i)
    {
        return this.spriteArray;
    }

    public BufferedImage getSpriteSheet()
    {
        return SPRITESHEET;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getSpriteWidth()
    {
        return spriteWidth;
    }

    public int getSpriteHeight()
    {
        return spriteHeight;
    }

    public static void drawArray(Graphics2D graphics, List<BufferedImage> images, Vector2f vec2f,
                                 int width,
                                 int height,
                                 int xOffset,
                                 int yOffset)
    {
        float x = vec2f.x;
        float y = vec2f.y;

        for (BufferedImage image : images)
        {
            if (image != null)
                graphics.drawImage(image, (int) x, (int) y, width, height, null);

            x += xOffset;
            y += yOffset;
        }
    }

    public static void drawArray(Graphics2D graphics, GameFont font, String word, Vector2f vec2f,
                                 int width,
                                 int height,
                                 int xOffset,
                                 int yOffset)
    {
        float x = vec2f.x;
        float y = vec2f.y;

        char[] charArray = word.toCharArray();
        for (char ch : charArray)
        {
            // 32 ' '
            if (ch != 32)
                graphics.drawImage(font.getFont(ch), (int) x, (int) y, width, height, null);

            x += xOffset;
            y += yOffset;
        }
    }

}
