package com.caribbeansea.storyforself.state;

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

import com.caribbeansea.storyforself.component.GameFrame;
import com.caribbeansea.storyforself.component.GamePanel;
import com.caribbeansea.storyforself.component.Vector2f;
import com.caribbeansea.storyforself.handler.KeyHandler;
import com.caribbeansea.storyforself.handler.MouseHandler;
import com.caribbeansea.storyforself.game.GameHandler;
import com.caribbeansea.storyforself.utils.Lists;

import java.awt.*;
import java.util.List;

/**
 * @author tiansheng
 */
public class GameStateManager implements GameHandler
{

    private final List<GameState> states
            = Lists.newArrayList(64);

   public static Vector2f map;

   public static final int PLAY = 0;

   public static final int MENU = 1;

   public static final int PAUSE = 2;

   public static final int GAME_OVER = 3;

    public GameStateManager() {
        map = new Vector2f(GameFrame.WIDTH, GameFrame.HEIGHT);
        Vector2f.setWorld(map.getX(), map.getY());
        states.add(new PlayState(this));
    }

    public void pop(int state) {
        states.remove(state);
    }

    public void add(int state) {
        if(state == PLAY) {
            states.add(new PlayState(this));
        }
        if(state == MENU) {
            states.add(new MenuState(this));
        }
        if(state == PAUSE) {
            states.add(new PauseState(this));
        }
        if(state == GAME_OVER) {
            states.add(new GameOverState(this));
        }
    }

    /**
     * 添加并删除状态
     * @param state 状态常量值
     */
    public void addAndpop(int state) {
        states.remove(0);
        add(state);
    }

    @Override
    public void update()
    {
        Vector2f.setWorld(map.getX(), map.getY());
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
