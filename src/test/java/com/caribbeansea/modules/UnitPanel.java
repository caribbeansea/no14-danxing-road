package com.caribbeansea.modules;

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

import com.caribbeansea.engine.component.GamePanel;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author tiansheng
 */
public class UnitPanel extends GamePanel
{

    public UnitPanel(int width, int height)
    {
        super(width, height);
    }

    @Override
    public void init_panel()
    {
        running = true;

        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        this.graphics = (Graphics2D) image.getGraphics();

        stateManager = new StateManager();
    }

    /**
     * 更新
     */
    @Override
    public void update()
    {
        stateManager.update();
    }

    /**
     * 渲染
     */
    public void render()
    {

    }

    @Override
    public void render(Graphics2D graphics)
    {
        if (graphics != null)
        {
            graphics.setColor(new Color(66, 134, 244));
            graphics.fillRect(0, 0, getWidth(), getHeight());
            stateManager.render(graphics);
        }
    }

    /**
     * 画图
     */
    @Override
    public void draw()
    {
        Graphics graphics = this.getGraphics();
        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        graphics.dispose();
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {
        stateManager.input(mouse, key);
    }

}
