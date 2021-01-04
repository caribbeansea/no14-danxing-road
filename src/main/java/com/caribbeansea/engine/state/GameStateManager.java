package com.caribbeansea.engine.state;

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

import com.caribbeansea.engine.component.GameFrame;
import com.caribbeansea.engine.component.Vector2f;
import com.caribbeansea.engine.game.GameRender;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;
import com.caribbeansea.engine.utils.Lists;

import java.awt.*;
import java.util.List;

/**
 * 游戏状态管理
 *
 * @author tiansheng
 */
public abstract class GameStateManager implements GameRender
{

    protected final List<GameState> states
            = Lists.newArrayList(64);

    public static Vector2f map;

    public GameStateManager()
    {
        map = new Vector2f(GameFrame.WIDTH, GameFrame.HEIGHT);
        Vector2f.setWorld(map.x, map.y);

       init_state();
    }

    /**
     * 初始化状态列表
     */
    public abstract void init_state();

    public void pop(int state)
    {
        states.remove(state);
    }

    /**
     * 添加状态
     * @param state 状态值，子类自己去定义
     */
    public abstract void add_state(int state);

    /**
     * 添加并删除状态
     *
     * @param state 状态常量值
     */
    public void addAndpop(int state)
    {
        states.remove(0);
        add_state(state);
    }

    @Override
    public void update()
    {
        Vector2f.setWorld(map.x, map.y);
        for (GameState state : states)
        {
            state.update();
        }
    }

    @Override
    public void render(Graphics2D graphics)
    {
        for (GameState state : states)
        {
            state.render(graphics);
        }
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {
        for (GameState state : states)
        {
            state.input(mouse, key);
        }
    }

}
