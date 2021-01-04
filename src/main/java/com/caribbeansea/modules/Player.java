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

import com.caribbeansea.engine.component.GameEntity;
import com.caribbeansea.engine.component.Sprite;
import com.caribbeansea.engine.component.Vector2f;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;

import java.awt.*;

/**
 * @author tiansheng
 */
public class Player extends GameEntity
{

    protected final int UP    = 3;
    protected final int DOWN  = 2;
    protected final int LEFT  = 1;
    protected final int RIGHT = 0;

    protected final int DEATH = 4;

    protected final int UP_ATTACK    = 8;
    protected final int DOWN_ATTACK  = 7;
    protected final int LEFT_ATTACK  = 6;
    protected final int RIGHT_ATTACK = 5;

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;
    protected boolean attack;
    protected boolean attackSpeed;
    protected boolean attackDuration;

    protected float max_speed = 2F;
    protected float acc = 1F;
    protected float deacc = 0.1F;

    private int direction; // 当前人物方向

    public Player(Sprite sprite, Vector2f origin, int size)
    {
        super(sprite, origin, size);
        this.setting_delay = 30;
        set_animation(RIGHT, sprite.getSpriteArray(RIGHT), setting_delay);
    }

    @Override
    public void update()
    {
        super.update();
        move();
        origin.x += dx;
        origin.y += dy;
        animation.update();
    }

    public void move()
    {
        if (up)
        {
            dy -= acc;
            if (dy < -max_speed)
            {
                dy = -max_speed;
            }
        } else
        {
            if (dy < 0)
            {
                dy += deacc;
                if (dy > 0)
                {
                    dy = 0;
                }
            }
        }

        if (down)
        {
            dy += acc;
            if (dy > max_speed)
            {
                dy = max_speed;
            }
        } else
        {
            if (dy > 0)
            {
                dy -= deacc;
                if (dy < 0)
                {
                    dy = 0;
                }
            }
        }

        if (left)
        {
            dx -= acc;
            if (dx < -max_speed)
            {
                dx = -max_speed;
            }
        } else
        {
            if (dx < 0)
            {
                dx += deacc;
                if (dx > 0)
                {
                    dx = 0;
                }
            }
        }

        if (right)
        {
            dx += acc;
            if (dx > max_speed)
            {
                dx = max_speed;
            }
        } else
        {
            if (dx > 0)
            {
                dx -= deacc;
                if (dx < 0)
                {
                    dx = 0;
                }
            }
        }

    }

    @Override
    public void animate()
    {
        if (up)
        {
            if (current_animation != UP || animation.getDelay() == -1)
            {
                set_animation(UP, sprite.getSpriteArray(UP), setting_delay);
            }
            direction = UP;
        } else if (down)
        {
            if (current_animation != DOWN || animation.getDelay() == -1)
            {
                set_animation(DOWN, sprite.getSpriteArray(DOWN), setting_delay);
            }
            direction = DOWN;
        } else if (left)
        {
            if (current_animation != LEFT || animation.getDelay() == -1)
            {
                set_animation(LEFT, sprite.getSpriteArray(LEFT), setting_delay);
            }
            direction = LEFT;
        } else if (right)
        {
            if (current_animation != RIGHT || animation.getDelay() == -1)
            {
                set_animation(RIGHT, sprite.getSpriteArray(RIGHT), setting_delay);
            }
            direction = RIGHT;
        } else
        {
            set_animation(current_animation, sprite.getSpriteArray(current_animation), -1);
        }


    }

    @Override
    public void set_hit_box_direction()
    {
        if (up)
        {
            this.hit_bounds.setXOffset((float) -size / 2);
            this.hit_bounds.setYOffset((float) -size / 2);
        } else if (down)
        {
            this.hit_bounds.setXOffset((float) -size / 2);
            this.hit_bounds.setYOffset((float) size / 2);
        } else if (left)
        {
            this.hit_bounds.setXOffset((float) -size);
            this.hit_bounds.setYOffset(0);
        } else if (right)
        {
            this.hit_bounds.setXOffset(0);
            this.hit_bounds.setYOffset(0);
        }
    }

    @Override
    public void render(Graphics2D graphics)
    {
        graphics.drawImage(animation.getFrames(), (int) origin.x, (int) origin.y, size, size, null);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {
        this.up = key.VK_UP.isDown();
        this.down = key.VK_DOWN.isDown();
        this.left = key.VK_LEFT.isDown();
        this.right = key.VK_RIGHT.isDown();
        this.attack = key.VK_ATTACK.isDown();
    }

}
