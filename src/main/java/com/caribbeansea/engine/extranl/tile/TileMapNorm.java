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
import com.caribbeansea.engine.map.NormBlock;
import com.caribbeansea.engine.utils.Lists;

import java.awt.*;
import java.util.List;

/**
 * @author tiansheng
 */
public class TileMapNorm extends TileMap
{

    private String data;

    private Sprites sprites;

    private int width;

    private int height;

    private int tile_width;

    private int tile_height;

    private int tile_columns;

    private List<Block> blocks;

    public TileMapNorm(String data, Sprites sprites,
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

        this.blocks = Lists.newArrayList();

        String[] block = data.split(",");
        for (int i = 0, len = (width * height); i < len; i++)
        {
            int temp = Integer.parseInt(block[i].trim());
            if (temp != 0)
            {
                blocks.add(new NormBlock(tile_width, tile_height,
                        sprites.getSprite((temp - 1) % tile_columns, (temp - 1) / tile_columns),
                        new Vector2f((int) (i % width) * tile_width, (int) (i / height) * height)));
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
        for (Block block : blocks)
        {
            block.render(graphics);
        }
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {

    }
}
