package engine.state;

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

import engine.game.GameRender;

/**
 * 游戏状态，它的用处比如当人物死亡的时候可以调用一个GameOver类似
 * 的状态去画出一个人物死亡的效果。
 *
 * 它主要的内容需要子类去实现{@link GameRender}接口，在里面进行渲染、更新以及设备的监听。
 *
 * @author tiansheng
 */
public abstract class GameState implements GameRender
{

    private GameStateManager stateManager;

    public GameState(GameStateManager stateManager)
    {
        this.stateManager = stateManager;
    }



}
