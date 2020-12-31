package com.caribbeansea.storyforself;

/* ************************************************************************
 *
 * Copyright (C) 2020 dahan All rights reserved.
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
 * Creates on 2020/12/25.
 */

import com.caribbeansea.storyforself.component.CaribbeanFrame;
import com.caribbeansea.storyforself.component.CaribbeanPanel;
import com.caribbeansea.storyforself.instruction.InstPanel;
import com.caribbeansea.storyforself.key.GlobalKeyEvent;
import com.caribbeansea.storyforself.menun.StartMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 开始编写你的故事
 *
 * @author tiansheng
 */
public class WriteYourStory extends CaribbeanFrame
{

    public static int width = 1245;

    public static int height = 813;

    public WriteYourStory()
    {
        super("单行路22号");
        setSize(width, height);

        Container panels = getContentPane();

        // --------------------------------------------
        // 配置监听事件
        confEventListener(this);
        // --------------------------------------------

        // --------------------------------------------
        // 开始菜单
        StartMenu startMenu = new StartMenu(width, height);
        panels.add(startMenu);
        // --------------------------------------------

        InstPanel instPanel = new InstPanel(startMenu);
        startMenu.setInstPanel(instPanel);

        GlobalKeyEvent globalKeyEvent = new GlobalKeyEvent();
        globalKeyEvent.setInstPanel(instPanel);
        addKeyListener(globalKeyEvent);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new WriteYourStory();
    }

    /**
     * 配置事件监听器
     */
    public void confEventListener(JFrame frame)
    {

//        // 如果当前位置发生改变则输出当前位置
//        this.addComponentListener(new ComponentAdapter()
//        {
//            @Override
//            public void componentResized(ComponentEvent e)
//            {
//                Log.info("当前宽度：【%s】，当前高度：【%s】", e.getComponent().getWidth(), e.getComponent().getHeight());
//            }
//        });
//
        // 鼠标被点击
//        this.addMouseListener(new MouseAdapter()
//        {
//            @Override
//            public void mousePressed(MouseEvent e)
//            {
//                Log.printCoords("鼠标", e.getX(), e.getY());
//                Log.info("窗口宽度：【%s】，窗口高度：【%s】", frame.getWidth(), frame.getHeight());
//            }
//        });

    }

}
