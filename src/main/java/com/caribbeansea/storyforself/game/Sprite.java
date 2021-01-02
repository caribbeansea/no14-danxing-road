package com.caribbeansea.storyforself.game;

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

import com.caribbeansea.storyforself.resources.ImageResources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 游戏精灵
 *
 * @author tiansheng
 */
public class Sprite
{

    private final BufferedImage SPRITESHEET;

    private BufferedImage[][] spriteArray;

    private int width;

    private int height;

    private int spriteWidth;

    private int spriteHeight;

    private static final int TILE_SIZE = 32;

    public Sprite(ImageResources resources)
    {
        this(resources, TILE_SIZE, TILE_SIZE);
    }

    public Sprite(ImageResources resources, int width, int height)
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
        this.spriteArray = new BufferedImage[spriteWidth][spriteHeight];

        for(int x=0; x<spriteWidth; x++) {
            for(int y=0; y<spriteHeight; y++) {
                spriteArray[x][y] = getSprite(x, y);
            }
        }
    }

    public BufferedImage getSprite(int x, int y) {
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

    public BufferedImage[] getSpriteArray(int i) {
        return this.spriteArray[i];
    }

    public BufferedImage[][] getSpriteArray2(int i) {
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

    public static void drawArray(Graphics2D graphics, List<BufferedImage> iamges) {

    }

}
