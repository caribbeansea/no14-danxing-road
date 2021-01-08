package com.caribbeansea.engine.extranl.tile;

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

import com.caribbeansea.engine.component.Sprites;
import com.caribbeansea.engine.component.Vector2f;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;
import com.caribbeansea.engine.map.Block;
import com.caribbeansea.engine.map.HoleBlock;
import com.caribbeansea.engine.map.ObjectBlock;
import com.caribbeansea.engine.utils.Maps;

import java.awt.*;
import java.util.Map;

/**
 * @author tiansheng
 */
public class TileMapObject extends TileMap
{

    private String data;

    private Sprites sprites;

    private int w;

    private int h;

    private int tile_w;

    private int tile_h;

    private int tile_columns;

    public static Map<String, Block> blocks = Maps.newHashMap();

    public TileMapObject(String data, Sprites sprites,
                         int w, int h,
                         int tile_w, int tile_h,
                         int tile_columns)
    {
        this.data = data;
        this.sprites = sprites;
        this.w = w;
        this.h = h;
        this.tile_w = tile_w;
        this.tile_h = tile_h;
        this.tile_columns = tile_columns;

        Block temp_block;

        String[] block = data.split(",");
        for (int i = 0, len = (w * h); i < len; i++)
        {
            int temp = Integer.parseInt(block[i].trim());
            if (temp != 0)
            {
                if (temp == 172)
                {
                    temp_block = new HoleBlock(tile_w, tile_h,
                            sprites.getSprite((temp - 1) % tile_columns, (temp - 1) / tile_columns),
                            new Vector2f((int) (i % w) * tile_w, (int) (i / h) * h));
                } else
                {
                    temp_block = new ObjectBlock(tile_w, tile_h,
                            sprites.getSprite((temp - 1) % tile_columns, (temp - 1) / tile_columns),
                            new Vector2f((int) (i % w) * tile_w, (int) (i / h) * h));
                }
                blocks.put(String.valueOf((i % w)).concat(",").concat(String.valueOf((i / h))), temp_block);
            }
        }
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(Graphics2D graphics)
    {
        for (Block value : blocks.values())
        {
            value.render(graphics);
        }
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {

    }
}
