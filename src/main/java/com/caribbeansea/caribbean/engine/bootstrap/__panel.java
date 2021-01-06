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

import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 游戏面板，游戏所有的东西都是画在这个面板上的。以及
 * 一些游戏控制也是在这个面板做。
 *
 * @author tiansheng
 */
public abstract class __panel extends JPanel
        implements __updater, __renderer, __inputer, Runnable
{

    /**
     * 是否显示当前FPS
     */
    private boolean visible_fps = false;

    /**
     * 游戏启动线程
     */
    private Thread thread;

    /**
     * 键盘输入监听
     */
    private __key_handler key_handler;

    /**
     * 鼠标输入监听
     */
    private __mouse_handler mouse_handler;

    /**
     * 是否暂停游戏
     */
    private boolean running = false;

    public __panel()
    {
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

        thread = new Thread(this, "game-thread-bootstrap");
    }

    /**
     * 每秒会执行一次这个方法
     */
    public abstract void do_every_second();

    @Override
    public void run()
    {
        while (true)
        {
            if (running)
            {
                update();
                input(key_handler, mouse_handler);
                render();
            }
        }
    }

    /**
     * 开始游戏
     */
    public void start_game()
    {
        this.running = true;
        thread.start();
    }

    /**
     * 暂停游戏
     */
    public void pause()
    {
        this.running = false;
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
