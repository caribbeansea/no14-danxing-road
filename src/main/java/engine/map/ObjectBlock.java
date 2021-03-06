package engine.map;

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

import engine.component.AABB;
import engine.component.Vector2f;
import engine.handler.KeyHandler;
import engine.handler.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author tiansheng
 */
public class ObjectBlock extends Block
{

    public ObjectBlock(int w, int h, BufferedImage buffimage, Vector2f vec2f)
    {
        super(w, h, buffimage, vec2f);
    }

    @Override
    public boolean update(AABB box)
    {
        return true;
    }

    @Override
    public void update()
    {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {

    }

    @Override
    public void render(Graphics2D graphics)
    {
        super.render(graphics);
        graphics.setColor(Color.white);
        graphics.drawRect((int) vec2f.get_world().x, (int) vec2f.get_world().y, w, h);
    }
}
