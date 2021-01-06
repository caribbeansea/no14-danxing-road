package com.caribbeansea.caribbean.engine.bootstrap;

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
 * Creates on 2021/1/5.
 */

import com.caribbeansea.caribbean.engine.handler.__key_handler;
import com.caribbeansea.caribbean.engine.handler.__mouse_handler;
import com.caribbeansea.caribbean.engine.process.__inputer;
import com.caribbeansea.caribbean.engine.process.__renderer;
import com.caribbeansea.caribbean.engine.process.__updater;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 游戏面板，游戏所有的东西都是画在这个面板上的。以及
 * 一些游戏控制也是在这个面板做。
 *
 * @author tiansheng
 */
public abstract class __panel extends JPanel
        implements __updater, __renderer, __inputer
{

    /**
     * 是否显示当前FPS
     */
    protected boolean visible_fps = false;

    /**
     * 键盘输入监听
     */
    protected __key_handler key_handler;

    /**
     * 鼠标输入监听
     */
    protected __mouse_handler mouse_handler;

    /**
     * 是否暂停游戏
     */
    protected boolean running = false;

    /**
     * 窗口尺寸
     */
    protected Dimension dimension;

    public __panel(Dimension dimension)
    {
        this.dimension = dimension;

        setPreferredSize(dimension);
        setFocusable(true);
        requestFocus();

        /* 定时器，每秒执行一次 */
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                do_every_second();
            }
        }, 0, 1000L);

        /* key&mouse 监听器 */
        key_handler = new __key_handler(this);
        mouse_handler = new __mouse_handler(this);

    }

    /**
     * 每秒会执行一次这个方法
     */
    public abstract void do_every_second();

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        if (!running)
        {
            update();
            input(key_handler, mouse_handler);
            render(g);
        }

        repaint();
    }

    /**
     * 暂停游戏
     */
    public void pause()
    {
        this.running = true;
    }

    public void running(boolean running)
    {
        this.running = running;
    }

    public boolean visible_fps()
    {
        return visible_fps;
    }

    public void visible_fps(boolean visible_fps)
    {
        this.visible_fps = visible_fps;
    }

}
