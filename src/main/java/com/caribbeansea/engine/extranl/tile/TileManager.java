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

import com.caribbeansea.engine.Log;
import com.caribbeansea.engine.component.Sprites;
import com.caribbeansea.engine.game.GameRender;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;
import com.caribbeansea.engine.utils.Lists;
import com.caribbeansea.engine.utils.ToolBox;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.List;

/**
 * Tiled工具搭建出来的场景模型管理器
 *
 * @author tiansheng
 */
public class TileManager implements GameRender
{

    public static List<TileMap> tile_maps;

    public TileManager()
    {
    }

    public TileManager(String path)
    {
        tile_maps = Lists.newArrayList();
        addTiledMap(path, 64, 64);
    }

    public void addTiledMap(String path, int block_w, int block_h)
    {
        String image_path;

        int w = 0;
        int h = 0;
        int tile_w = 0;
        int tile_h = 0;

        int tile_count = 0;
        int tile_columns = 0;

        int layer = 0;

        Sprites sprites = null;

        String[] data = new String[10];

        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(path));
            document.getDocumentElement().normalize();

            // 读取tileset中的数据
            NodeList nodes = document.getElementsByTagName("tileset");
            Element element = (Element) nodes.item(0);

            image_path = element.getAttribute("name");
            tile_w = Integer.parseInt(element.getAttribute("tilew"));
            tile_h = Integer.parseInt(element.getAttribute("tileh"));
            tile_count = Integer.parseInt(element.getAttribute("tilecount"));
            tile_columns = Integer.parseInt(element.getAttribute("columns"));

            sprites = new Sprites(ToolBox.read_buffimg_in_resources("/tile/" + image_path + ".png"), tile_w, tile_h);

            // 读取layer
            nodes = document.getElementsByTagName("layer");
            layer = nodes.getLength();

            for (int i = 0; i < layer; i++)
            {
                element = (Element) nodes.item(i);
                if (i == 0)
                {
                    w = Integer.parseInt(element.getAttribute("w"));
                    h = Integer.parseInt(element.getAttribute("h"));
                }

                data[i] = element.getElementsByTagName("data").item(0).getTextContent();

                if(i > 0) {
                    tile_maps.add(new TileMapNorm(data[i], sprites, w, h, block_w, block_h, tile_columns));
                } else {
                    tile_maps.add(new TileMapObject(data[i], sprites, w, h, block_w, block_h, tile_columns));
                }
            }

        } catch (Throwable e)
        {
            Log.error("cloud not read tile xml from: %s", path, e);
            e.printStackTrace();
        }
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(Graphics2D graphics)
    {
        for (TileMap tile_map : tile_maps)
        {
            tile_map.render(graphics);
        }
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {

    }
}
