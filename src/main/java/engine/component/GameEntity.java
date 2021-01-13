package engine.component;

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

import engine.game.GameRender;

import java.awt.image.BufferedImage;

/**
 * 游戏内的实体对象，它可以是NPC也可以是物品人物等东西。
 *
 * @author tiansheng
 */
public abstract class GameEntity implements GameRender
{

    protected final Sprites sprites;

    protected final Vector2f origin;

    protected int size;

    protected Animation animation;

    // 用于移动盒子等物体
    protected float dx;
    protected float dy;

    protected int current_animation;

    protected AABB hit_bounds;

    protected AABB bounds;

    protected int setting_delay = 20;

    public GameEntity(Sprites sprites, Vector2f origin, int size)
    {
        this.sprites = sprites;
        this.origin = origin;
        this.size = size;

        this.bounds = new AABB(origin, size, size);
        this.hit_bounds = new AABB(new Vector2f(origin.x + ((float) (size / 2)), origin.y), size, size);

        this.animation = new Animation();
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

    /**
     * 播放动画的帧数切换，比如人物向上、向下、向左、向右的时候应该
     * 选取哪个阶段的播放动画。
     */
    public abstract void animate();

    @Override
    public void update()
    {
        animate();
        set_hit_box_direction();
        animation.update();
    }

    public abstract void set_hit_box_direction();

    public int getSetting_delay()
    {
        return setting_delay;
    }

    public void setSetting_delay(int setting_delay)
    {
        this.setting_delay = setting_delay;
    }

    public Sprites getSprite()
    {
        return sprites;
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
