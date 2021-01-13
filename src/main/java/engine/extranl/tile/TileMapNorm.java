package engine.extranl.tile;

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

import engine.component.Sprites;
import engine.component.Vector2f;
import engine.handler.KeyHandler;
import engine.handler.MouseHandler;
import engine.map.Block;
import engine.map.NormBlock;
import engine.utils.Lists;

import java.awt.*;
import java.util.List;

/**
 * @author tiansheng
 */
public class TileMapNorm extends TileMap
{

    private String data;

    private Sprites sprites;

    private int w;

    private int h;

    private int tile_w;

    private int tile_h;

    private int tile_columns;

    private List<Block> blocks;

    public TileMapNorm(String data, Sprites sprites,
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

        this.blocks = Lists.newArrayList();

        String[] block = data.split(",");
        for (int i = 0, len = (w * h); i < len; i++)
        {
            int temp = Integer.parseInt(block[i].trim());
            if (temp != 0)
            {
                blocks.add(new NormBlock(tile_w, tile_h,
                        sprites.getSprite((temp - 1) % tile_columns, (temp - 1) / tile_columns),
                        new Vector2f((int) (i % w) * tile_w, (int) (i / h) * h)));
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
