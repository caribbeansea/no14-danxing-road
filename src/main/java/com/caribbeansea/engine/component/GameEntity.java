package com.caribbeansea.engine.component;

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
 * Creates on 2021/1/3.
 */

import com.caribbeansea.engine.game.Render;

import java.awt.image.BufferedImage;

/**
 * @author tiansheng
 */
public abstract class GameEntity implements Render
{

    protected final Sprite sprite;

    protected final Vector2f origin;

    protected int size;

    protected Animation animation;

    protected final int UP    = 0;
    protected final int DOWN  = 1;
    protected final int LEFT  = 2;
    protected final int RIGHT = 3;

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;
    protected boolean attackSpeed;
    protected boolean attackDuration;

    protected boolean dx;
    protected boolean dy;

    protected float max_speed;

    protected float acc;

    protected float deacc;

    protected int current_animation;

    public GameEntity(Sprite sprite, Vector2f origin, int size)
    {
        this.sprite = sprite;
        this.origin = origin;
        this.size = size;

        this.animation = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

   public void setAnimation(int const_i, BufferedImage[] frames, int delay) {
        current_animation = const_i;
        animation.setFrames(frames);
        animation.setDelay(delay);
   }

}
