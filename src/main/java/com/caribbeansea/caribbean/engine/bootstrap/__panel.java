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
import com.caribbeansea.caribbean.engine.render.__depict;
import com.caribbeansea.caribbean.engine.state.__state;
import com.caribbeansea.caribbean.engine.state.__state_manager;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 游戏面板，游戏所有的东西都是画在这个面板上的。以及
 * 一些游戏控制也是在这个面板做。
 *
 * @author tiansheng
 */
public abstract class __panel extends JPanel
{

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

    /**
     * 帧数
     */
    private int count_frames = 0;

    /**
     * 状态管理
     */
    private final __state_manager __STATE_MANAGER__ = new __state_manager();

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
                count_frames = 0;
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
            __STATE_MANAGER__.update();
            __STATE_MANAGER__.input(key_handler, mouse_handler);
            __STATE_MANAGER__.render(new __depict((Graphics2D) g));
        }

        repaint();

        count_frames++;
    }

    /**
     * 暂停游戏
     */
    public void pause()
    {
        this.running = true;
    }

    /**
     * @return 当前游戏帧数
     */
    public int fps()
    {
        return count_frames;
    }

    /**
     * 继续游戏
     */
    public void __continue__()
    {
        this.running = true;
    }

    /**
     * 添加状态
     */
    public void addState(__state state) {
        __STATE_MANAGER__.addState(state);
    }

}
