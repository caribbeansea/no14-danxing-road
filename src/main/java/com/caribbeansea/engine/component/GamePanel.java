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

import com.caribbeansea.modules.exception.UnImplException;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;
import com.caribbeansea.engine.game.GameRender;
import com.caribbeansea.engine.state.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 游戏面板
 *
 * @author tiansheng
 */
public abstract class GamePanel extends JPanel implements Runnable, GameRender
{

    protected Thread thread;

    protected BufferedImage image;

    protected Graphics2D graphics;

    protected volatile boolean running = false;

    protected int x = 0;

    protected MouseHandler mouse;

    protected KeyHandler key;

    protected GameStateManager stateManager;

    public GamePanel(int width, int height)
    {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();

        mouse = new MouseHandler(this);
        key = new KeyHandler(this);
    }

    @Override
    public void addNotify()
    {
        super.addNotify();
        if (thread == null)
        {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    /**
     * 初始化
     */
    public abstract void init_panel();

    @Override
    public void run()
    {
        init_panel();

        while (running)
        {
            update();
            input(mouse, key);
            render(graphics);
            draw();
        }
    }

    /**
     * 画图
     */
    public abstract void draw();

}
