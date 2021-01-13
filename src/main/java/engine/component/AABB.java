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
 * Creates on 2021/1/4.
 */

import engine.extranl.tile.TileMapObject;

/**
 * 包围盒
 *
 * @author tiansheng
 */
public class AABB
{

    private Vector2f vec2f;

    private float w;

    private float h;

    private float radius;

    private int size;

    private float x_offset;

    private float y_offset;

    private GameEntity entity;

    public AABB(Vector2f vec2f, int w, int h)
    {
        setBox(vec2f, w, h);
    }

    public AABB(Vector2f vec2f, int radius, GameEntity entity)
    {
        this.vec2f = vec2f;
        this.radius = radius;
        this.size = radius;
        this.entity = entity;
    }

    public void setBox(Vector2f vec2f, int w, int h)
    {
        this.vec2f = vec2f;
        this.w = w;
        this.h = h;

        this.size = Math.max(w, h);
    }

    /**
     * 碰撞检测
     *
     * @param box 包围盒
     * @return true代表包围盒已经重叠发生了碰撞，false反之。
     */
    public boolean collides(AABB box)
    {
        float a_x = ((vec2f.get_world().x + x_offset) + (w / 2));
        float a_y = ((vec2f.get_world().y + y_offset) + (h / 2));

        float b_x = ((vec2f.get_world().x + box.x_offset) + (w / 2));
        float b_y = ((vec2f.get_world().y + box.y_offset) + (h / 2));

        return Math.abs(a_x - b_x) < ((this.w / 2) + box.w / 2) &&
                Math.abs(a_y - b_y) < ((this.h / 2) + box.h / 2);
    }

    /**
     * 园框
     */
    public boolean colCircle_box(AABB box)
    {
        float c_x = (float) (vec2f.get_world().x + radius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));
        float c_y = (float) (vec2f.get_world().y + radius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));

        float x_delta = c_x - Math.max(box.vec2f.get_world().x + (box.w / 2), Math.min(c_x, box.getVector2f().x));
        float y_delta = c_x - Math.max(box.vec2f.get_world().y + (box.w / 2), Math.min(c_y, box.getVector2f().y));

        return (x_delta * x_delta + y_delta * y_delta) < ((this.radius / Math.sqrt(2)) * (this.radius / Math.sqrt(2)));
    }

    public boolean collisionTile(float box_x, float box_y)
    {
        for (int c = 0; c < 4; c++)
        {
            int xt = (int) ((vec2f.x + box_x) + (c % 2) * w + x_offset) / 64;
            int yt = (int) ((vec2f.x + box_y) + (c / 2) * h + y_offset) / 64;

            String key = xt + "," + yt;
            if (TileMapObject.blocks.containsKey(key))
            {
                return TileMapObject.blocks.get(key).update(this);
            }
        }

        return false;
    }

    public void setVector2f(Vector2f vec2f)
    {
        this.vec2f = vec2f;
    }

    public void setWidth(float w)
    {
        this.w = w;
    }

    public void setHeight(float h)
    {
        this.h = h;
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
        return w;
    }

    public float getHeight()
    {
        return h;
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
