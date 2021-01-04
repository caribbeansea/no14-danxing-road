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

import com.caribbeansea.engine.component.GameFrame;
import com.caribbeansea.engine.component.GamePanel;

import javax.swing.*;

/**
 * @author tiansheng
 */
public class UnitFrame extends GameFrame
{

    public UnitFrame(int width, int height)
    {
        super(width, height);
    }

    @Override
    public void init_frame()
    {
        setTitle("game name");
        // 当窗口关闭时即退出整个程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        // 窗口居中显示
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public GamePanel setting_panel(int width, int height)
    {
        return new UnitPanel(width, height);
    }
}
