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

import com.caribbeansea.engine.state.GameStateManager;
import com.caribbeansea.modules.state.GameOverState;
import com.caribbeansea.modules.state.MenuState;
import com.caribbeansea.modules.state.PauseState;
import com.caribbeansea.modules.state.PlayState;

/**
 * @author tiansheng
 */
public class StateManager extends GameStateManager
{

    public static final int PLAY = 0;

    public static final int MENU = 1;

    public static final int PAUSE = 2;

    public static final int GAME_OVER = 3;

    @Override
    public void init_state()
    {
        states.add(new PlayState(this));
    }

    @Override
    public void add_state(int state)
    {
        if (state == PLAY)
        {
            states.add(new PlayState(this));
        }
        if (state == MENU)
        {
            states.add(new MenuState(this));
        }
        if (state == PAUSE)
        {
            states.add(new PauseState(this));
        }
        if (state == GAME_OVER)
        {
            states.add(new GameOverState(this));
        }
    }

}
