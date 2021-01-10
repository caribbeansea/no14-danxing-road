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

import com.caribbeansea.caribbean.engine.animation.__animation;
import com.caribbeansea.caribbean.engine.bootstrap.__bootstrap;
import com.caribbeansea.caribbean.engine.entity.__entity;
import com.caribbeansea.caribbean.engine.handler.__key_handler;
import com.caribbeansea.caribbean.engine.handler.__mouse_handler;
import com.caribbeansea.caribbean.engine.map.__vec2f;
import com.caribbeansea.caribbean.engine.render.__depict;
import com.caribbeansea.caribbean.engine.sprites.__sprites;
import com.caribbeansea.caribbean.engine.state.__enable_state;

import java.awt.event.KeyEvent;

/**
 * @author tiansheng
 */
public class __javatest_play_state extends __enable_state {

    /* 控制人物移动 */
    private float x;
    private float y = 200;

    private __animation animation;

    private boolean UP;
    private boolean DOWN;
    private boolean LEFT;
    private boolean RIGHT;

    private int directing;

    @Override
    public void construct() {
        this.entity = new __entity(__sprites.apply("resources/game/linkformatted.png"), new __vec2f(
                __bootstrap.__DIMENSION__().width, __bootstrap.__DIMENSION__().height), 32);
        this.animation = entity.sprites().getAnimation(5);
    }

    /**
     * 人物移动方法
     */
    void move() {
        if (UP) {
            y--;
            set_animation(3);
        } else if (DOWN) {
            y++;
            set_animation(2);
        } else if (LEFT) {
            x--;
            set_animation(1);
        }else if (RIGHT) {
            x++;
            set_animation(0);
        } else {
            set_animation(directing);
            animation.current_frames(0);
        }
    }

    /**
     * 动画切换
     */
    void set_animation(int state) {
        this.directing = state;
        animation = entity.sprites().getAnimation(state);
    }

    @Override
    public void input(__key_handler key_handler, __mouse_handler mouse_handler) {
        this.UP = key_handler.down(KeyEvent.VK_W);
        this.DOWN = key_handler.down(KeyEvent.VK_S);
        this.LEFT = key_handler.down(KeyEvent.VK_A);
        this.RIGHT = key_handler.down(KeyEvent.VK_D);
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void render(__depict depict) {
        depict._number_value((int) x, (int) y, 64, 64);
        animation.render(depict);
    }

}
