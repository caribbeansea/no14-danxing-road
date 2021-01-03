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

    public Player(Sprite sprite, Vector2f origin, int size)
    {
        super(sprite, origin, size);
    }

    @Override
    public void update()
    {
        super.update();
        move();
        origin.setX(origin.getX() + dx);
        origin.setY(origin.getY() + dy);
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
            if (dy < max_speed)
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
    public void render(Graphics2D graphics)
    {
        graphics.drawImage(animation.getFrames(), (int) origin.getX(), (int) origin.getY(), size, size, null);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {

        if (mouse.getButton() == 1)
        {
            System.out.println("Player: " + origin.getX() + ", " + origin.getY());
        }

        this.up = key.VK_UP.isDown();
        this.down = key.VK_DOWN.isDown();
        this.left = key.VK_LEFT.isDown();
        this.right = key.VK_RIGHT.isDown();
        this.attack = key.VK_ATTACK.isDown();
    }

}
