package com.caribbeansea.caribbean;

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
 * Creates on 2021/1/6.
 */

import com.caribbeansea.caribbean.engine.bootstrap.__panel;
import com.caribbeansea.caribbean.engine.handler.__key_handler;
import com.caribbeansea.caribbean.engine.handler.__mouse_handler;
import com.caribbeansea.caribbean.engine.render.__depict;

import java.awt.*;

/**
 * @author tiansheng
 */
public class __gt_panel extends __panel
{

    public __gt_panel(Dimension dimension)
    {
        super(dimension);
    }

    @Override
    public void do_every_second()
    {
        System.out.printf("NEW SECOND %s MS, FPS:[%s]\n", System.currentTimeMillis(), fps());
    }

    @Override
    public void input(__key_handler key_handler, __mouse_handler mouse_handler)
    {

    }

    @Override
    public void render(__depict depict)
    {
        depict._set_color(new Color(66, 134, 244));
        depict._fill_rect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void update()
    {

    }

}