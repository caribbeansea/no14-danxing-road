package com.caribbeansea.storyforself.component;

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

import com.caribbeansea.storyforself.exception.UnImplException;
import com.caribbeansea.storyforself.handler.KeyHandler;
import com.caribbeansea.storyforself.handler.MouseHandler;
import com.caribbeansea.storyforself.game.GameHandler;
import com.caribbeansea.storyforself.state.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 游戏面板
 *
 * @author tiansheng
 */
public class GamePanel extends JPanel implements Runnable, GameHandler
{

    private Thread thread;

    private BufferedImage image;

    private Graphics2D graphics;

    private volatile boolean running = false;

    private int x = 0;

    private MouseHandler mouse;

    private KeyHandler key;

    private GameStateManager stateManager;

    public GamePanel(int width, int height)
    {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
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
    public void init()
    {
        running = true;

        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        this.graphics = (Graphics2D) image.getGraphics();

        mouse = new MouseHandler();
        key = new KeyHandler(this);

        stateManager = new GameStateManager();
    }

    @Override
    public void run()
    {
        init();

        while (running)
        {
            update();
            input(mouse, key);
            render();
            draw();
        }

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
        if (graphics != null)
        {
            graphics.setColor(new Color(66, 134, 244));
            graphics.fillRect(0, 0, getWidth(), getHeight());
            stateManager.render(graphics);
        }
    }

    @Override
    public void render(Graphics2D graphics)
    {
        throw new UnImplException("The game panel unimpl render(Graphics2D) method.");
    }

    /**
     * 画图
     */
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
