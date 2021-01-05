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

    private int width;

    private int height;

    private int tile_width;

    private int tile_height;

    private int tile_columns;

    public static Map<String, Block> blocks = Maps.newHashMap();

    public TileMapObject(String data, Sprites sprites,
                         int width, int height,
                         int tile_width, int tile_height,
                         int tile_columns)
    {
        this.data = data;
        this.sprites = sprites;
        this.width = width;
        this.height = height;
        this.tile_width = tile_width;
        this.tile_height = tile_height;
        this.tile_columns = tile_columns;

        Block temp_block;

        String[] block = data.split(",");
        for (int i = 0, len = (width * height); i < len; i++)
        {
            int temp = Integer.parseInt(block[i].trim());
            if (temp != 0)
            {
                if (temp == 172)
                {
                    temp_block = new HoleBlock(tile_width, tile_height,
                            sprites.getSprite((temp - 1) % tile_columns, (temp - 1) / tile_columns),
                            new Vector2f((int) (i % width) * tile_width, (int) (i / height) * height));
                } else
                {
                    temp_block = new ObjectBlock(tile_width, tile_height,
                            sprites.getSprite((temp - 1) % tile_columns, (temp - 1) / tile_columns),
                            new Vector2f((int) (i % width) * tile_width, (int) (i / height) * height));
                }
                blocks.put(String.valueOf((i % width)).concat(",").concat(String.valueOf((i / height))), temp_block);
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
