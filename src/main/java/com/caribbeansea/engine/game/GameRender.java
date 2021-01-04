package com.caribbeansea.engine.game;

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

import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;

import java.awt.*;

/**
 * @author tiansheng
 */
public interface GameRender
{

    /**
     * 更新
     */
    void update();

    /**
     * 渲染
     * @param graphics 画笔
     */
    void render(Graphics2D graphics);

    /**
     * 处理键盘和输入等其他设备的信号输入
     *
     * @param mouse 鼠标输入
     * @param key   键盘输入
     */
    void input(MouseHandler mouse, KeyHandler key);

}
