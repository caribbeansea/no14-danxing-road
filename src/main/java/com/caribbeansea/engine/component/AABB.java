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
 * Creates on 2021/1/4.
 */

/**
 * 包围盒
 *
 * @author tiansheng
 */
public class AABB
{

    private Vector2f vec2f;

    private float width;

    private float height;

    private float radius;

    private int size;

    private float x_offset;

    private float y_offset;

    private GameEntity entity;

    public AABB(Vector2f vec2f, int width, int height)
    {
        setBox(vec2f, width, height);
    }

    public AABB(Vector2f vec2f, int radius, GameEntity entity)
    {
        this.vec2f = vec2f;
        this.radius = radius;
        this.size = radius;
        this.entity = entity;
    }

    public void setBox(Vector2f vec2f, int width, int height)
    {
        this.vec2f = vec2f;
        this.width = width;
        this.height = height;

        this.size = Math.max(width, height);
    }

    /**
     * 碰撞检测
     *
     * @param box 包围盒
     * @return true代表包围盒已经重叠发生了碰撞，false反之。
     */
    public boolean collides(AABB box)
    {
        float a_x = ((vec2f.get_world().getX() + x_offset) + (width / 2));
        float a_y = ((vec2f.get_world().getY() + y_offset) + (height / 2));

        float b_x = ((vec2f.get_world().getX() + box.x_offset) + (width / 2));
        float b_y = ((vec2f.get_world().getY() + box.y_offset) + (height / 2));

        return Math.abs(a_x - b_x) < ((this.width / 2) + box.width / 2) &&
                Math.abs(a_y - b_y) < ((this.height / 2) + box.height / 2);
    }

    /**
     * 园框
     */
    public boolean colCircle_box(AABB box)
    {
        float c_x = (float) (vec2f.get_world().getX() + radius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));
        float c_y = (float) (vec2f.get_world().getY() + radius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));

        float x_delta = c_x - Math.max(box.vec2f.get_world().getX() + (box.width/2), Math.min(c_x, box.getVector2f().getX()));
        float y_delta = c_x - Math.max(box.vec2f.get_world().getY() + (box.width/2), Math.min(c_y, box.getVector2f().getY()));

        return (x_delta * x_delta + y_delta * y_delta) < ((this.radius / Math.sqrt(2)) * (this.radius / Math.sqrt(2)));
    }

    public void setVector2f(Vector2f vec2f)
    {
        this.vec2f = vec2f;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public void setRadius(float radius)
    {
        this.radius = radius;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public void setXOffset(float x_offset)
    {
        this.x_offset = x_offset;
    }

    public void setYOffset(float y_offset)
    {
        this.y_offset = y_offset;
    }

    public Vector2f getVector2f()
    {
        return vec2f;
    }

    public float getWidth()
    {
        return width;
    }

    public float getHeight()
    {
        return height;
    }

    public float getRadius()
    {
        return radius;
    }

    public int getSize()
    {
        return size;
    }

    public float getXOffset()
    {
        return x_offset;
    }

    public float getYOffset()
    {
        return y_offset;
    }

    public GameEntity getEntity()
    {
        return entity;
    }

    public void setEntity(GameEntity entity)
    {
        this.entity = entity;
    }
}
