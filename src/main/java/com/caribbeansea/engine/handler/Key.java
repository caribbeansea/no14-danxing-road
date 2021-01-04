package com.caribbeansea.engine.handler;

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
 * @author tiansheng
 */
public class Key implements Cloneable
{

    int presses, absorbs;

    boolean down, clicked;

    public Key()
    {
    }

    public void toggle(boolean pressed)
    {
        if (pressed != down)
        {
            down = pressed;
        }

        if (pressed)
        {
            presses++;
        }
    }

    public void tick()
    {
        if (absorbs < presses)
        {
            absorbs++;
            clicked = true;
        } else
        {
            clicked = false;
        }
    }

    public int getPresses()
    {
        return presses;
    }

    public int getAbsorbs()
    {
        return absorbs;
    }

    public boolean isDown()
    {
        return down;
    }

    public boolean isClicked()
    {
        return clicked;
    }

    @Override
    protected Key clone() throws CloneNotSupportedException {
        return (Key) super.clone();
    }

}
