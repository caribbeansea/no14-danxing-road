package com.caribbeansea.engine.component;

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
 * Creates on 2020/12/28.
 */

import javax.swing.*;

/**
 * 窗口
 *
 * @author tiansheng
 */
public class GameFrame extends JFrame
{

    public static int width = 1245;

    public static int height = 813;

    public GameFrame() {
        this(width, height);
    }

    public GameFrame(int width, int height) {
        setTitle("game name");
        // 当窗口关闭时即退出整个程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(width, height));
        pack();
        // 窗口居中显示
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
