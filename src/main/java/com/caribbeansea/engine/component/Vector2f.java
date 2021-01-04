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

/**
 * @author tiansheng
 */
public class Vector2f
{

    public float x;

    public float y;

    public static float WORLD_X;

    public static float WORLD_Y;

    public Vector2f()
    {
    }

    public Vector2f(Vector2f vec2f)
    {
        this(vec2f.x, vec2f.y);
    }

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void addX(float x)
    {
        this.x += x;
    }

    public void addY(float y)
    {
        this.y += y;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setVector2f(Vector2f vec2f)
    {
        this.x = vec2f.x;
        this.y = vec2f.y;
    }

    public void setVector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2f get_world()
    {
        return new Vector2f(x - WORLD_X, y - WORLD_Y);
    }

    public static void setWorld(float x, float y)
    {
        WORLD_X = x;
        WORLD_Y = y;
    }

    @Override
    public String toString()
    {
        return "Vector2f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}