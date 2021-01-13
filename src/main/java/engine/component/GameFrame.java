package engine.component;

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
public abstract class GameFrame extends JFrame
{

    public GameFrame(int w, int h)
    {
        setContentPane(setting_panel(w, h));
        init_frame();
    }

    /**
     * 初始化窗体，以及窗体的各项配置
     */
    public abstract void init_frame();

    /**
     * 返回游戏面板对象实例
     *
     * @param w  窗体初始化宽度
     * @param h 窗体初始化高度
     * @return 面板实例对象
     */
    public abstract GamePanel setting_panel(int w, int h);

}
