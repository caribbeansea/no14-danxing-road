package com.simplegame.state;

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
 * Creates on 2021/1/8.
 */

import com.caribbeansea.caribbean.engine.bootstrap.__bootstrap;
import com.caribbeansea.caribbean.engine.entity.__entity;
import com.caribbeansea.caribbean.engine.handler.__key_handler;
import com.caribbeansea.caribbean.engine.handler.__mouse_handler;
import com.caribbeansea.caribbean.engine.map.__vec2f;
import com.caribbeansea.caribbean.engine.render.__depict;
import com.caribbeansea.caribbean.engine.sprites.__sprites;
import com.caribbeansea.caribbean.engine.state.__enable_state;

/**
 * @author tiansheng
 */
public class __javatest_play_state extends __enable_state
{

    @Override
    public void construct() {
        this.entity = new __entity(__sprites.apply("resources/game/linkformatted.png"), new __vec2f(
                __bootstrap.__DIMENSION__().width, __bootstrap.__DIMENSION__().height), 32);
    }

    @Override
    public void input(__key_handler key_handler, __mouse_handler mouse_handler)
    {

    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(__depict depict)
    {
        depict.x(200);
        depict.y(200);
        depict.width(128);
        depict.height(128);
        this.entity.sprites().animations()[0].render(depict);
    }

}
