package storyforself;

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

import storyforself.menun.StartMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * 开始编写你的故事
 *
 * @author tiansheng
 */
public class WriteYourStory extends JFrame
{

    public static int width = 1023;
    public static int height = 559;

    public WriteYourStory()
    {
        super("单行路22号");
        setSize(width, height);

        Container panels = getContentPane();

        // --------------------------------------------
        // 配置监听事件
        confEventListener();
        // --------------------------------------------

        // --------------------------------------------
        // 加载地图
        panels.add(new StartMenu(width, height));
        // --------------------------------------------

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
    public void confEventListener()
    {
        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                Log.info("当前宽度：【%s】，当前高度：【%s】", e.getComponent().getWidth(), e.getComponent().getHeight());
            }
        });
    }

}
