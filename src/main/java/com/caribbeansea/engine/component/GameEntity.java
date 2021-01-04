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

    protected final int UP    = 3;
    protected final int DOWN  = 2;
    protected final int LEFT  = 1;
    protected final int RIGHT = 0;

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;
    protected boolean attack;
    protected boolean attackSpeed;
    protected boolean attackDuration;

    // 用于移动盒子等物体
    protected float dx;
    protected float dy;

    protected float max_speed;

    protected float acc;

    protected float deacc;

    protected int current_animation;

    protected AABB hit_bounds;

    protected AABB bounds;

    private int setting_delay = 20;

    public GameEntity(Sprite sprite, Vector2f origin, int size)
    {
        this.sprite = sprite;
        this.origin = origin;
        this.size = size;

        this.bounds = new AABB(origin, size, size);
        this.hit_bounds = new AABB(new Vector2f(origin.getX() + ((float) (size / 2)), origin.getY()), size, size);

        this.animation = new Animation();
        set_animation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

    public void set_animation(int const_i, BufferedImage[] frames, int delay)
    {
        current_animation = const_i;
        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    public int getSize()
    {
        return size;
    }

    public void animate()
    {
        if (up)
        {
            if (current_animation != UP || animation.getDelay() == -1)
            {
                set_animation(UP, sprite.getSpriteArray(UP), setting_delay);
            }
        } else if (down)
        {
            if (current_animation != DOWN || animation.getDelay() == -1)
            {
                set_animation(DOWN, sprite.getSpriteArray(DOWN), setting_delay);
            }
        } else if (left)
        {
            if (current_animation != LEFT || animation.getDelay() == -1)
            {
                set_animation(LEFT, sprite.getSpriteArray(LEFT), setting_delay);
            }
        } else if (right)
        {
            if (current_animation != RIGHT || animation.getDelay() == -1)
            {
                set_animation(RIGHT, sprite.getSpriteArray(RIGHT), setting_delay);
            }
        } else
        {
            set_animation(current_animation, sprite.getSpriteArray(current_animation), -1);
        }
    }

    @Override
    public void update()
    {
        animate();
        set_hit_box_direction();
        animation.update();
    }

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

    public Sprite getSprite()
    {
        return sprite;
    }

    public Vector2f getOrigin()
    {
        return origin;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public Animation getAnimation()
    {
        return animation;
    }

    public void setAnimation(Animation animation)
    {
        this.animation = animation;
    }

    public int getUP()
    {
        return UP;
    }

    public int getDOWN()
    {
        return DOWN;
    }

    public int getLEFT()
    {
        return LEFT;
    }

    public int getRIGHT()
    {
        return RIGHT;
    }

    public boolean isUp()
    {
        return up;
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }

    public boolean isDown()
    {
        return down;
    }

    public void setDown(boolean down)
    {
        this.down = down;
    }

    public boolean isLeft()
    {
        return left;
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }

    public boolean isRight()
    {
        return right;
    }

    public void setRight(boolean right)
    {
        this.right = right;
    }

    public boolean isAttack()
    {
        return attack;
    }

    public void setAttack(boolean attack)
    {
        this.attack = attack;
    }

    public boolean isAttackSpeed()
    {
        return attackSpeed;
    }

    public void setAttackSpeed(boolean attackSpeed)
    {
        this.attackSpeed = attackSpeed;
    }

    public boolean isAttackDuration()
    {
        return attackDuration;
    }

    public void setAttackDuration(boolean attackDuration)
    {
        this.attackDuration = attackDuration;
    }

    public float getDx()
    {
        return dx;
    }

    public void setDx(float dx)
    {
        this.dx = dx;
    }

    public float getDy()
    {
        return dy;
    }

    public void setDy(float dy)
    {
        this.dy = dy;
    }

    public float getMax_speed()
    {
        return max_speed;
    }

    public void setMax_speed(float max_speed)
    {
        this.max_speed = max_speed;
    }

    public float getAcc()
    {
        return acc;
    }

    public void setAcc(float acc)
    {
        this.acc = acc;
    }

    public float getDeacc()
    {
        return deacc;
    }

    public void setDeacc(float deacc)
    {
        this.deacc = deacc;
    }

    public int getCurrent_animation()
    {
        return current_animation;
    }

    public void setCurrent_animation(int current_animation)
    {
        this.current_animation = current_animation;
    }

    public AABB getHit_bounds()
    {
        return hit_bounds;
    }

    public void setHit_bounds(AABB hit_bounds)
    {
        this.hit_bounds = hit_bounds;
    }

    public AABB getBounds()
    {
        return bounds;
    }

    public void setBounds(AABB bounds)
    {
        this.bounds = bounds;
    }
}
