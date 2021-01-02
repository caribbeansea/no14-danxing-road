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

import com.caribbeansea.storyforself.game.GameHandler;
import com.caribbeansea.storyforself.utils.Lists;

import java.util.List;

/**
 * @author tiansheng
 */
public abstract class GameState implements GameHandler
{

    private GameStateManager stateManager;

    public GameState(GameStateManager stateManager)
    {
        this.stateManager = stateManager;
    }



}
