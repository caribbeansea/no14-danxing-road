package com.simplegame;

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
 * Creates on 2021/1/8.
 */

import com.caribbeansea.caribbean.engine.bootstrap.__bootstrap;

/**
 * @author tiansheng
 */
public class __javatest_bootstrap extends __bootstrap
{

    @Override
    public void init()
    {
        title("简单的小游戏 - 测试专用");
        size(1000,800);
    }

    public static void main(String[] args)
    {
        __javatest_bootstrap bootstrap = new __javatest_bootstrap();
        bootstrap.addPanel(new __javatest_panel());

    }

}
