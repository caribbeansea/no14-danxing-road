package com.caribbeansea.caribbean.engine.state;

/* ************************************************************************
 *
 * Copyright (C) 2020 caribbeansea All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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
 * Creates on 2021/1/5.
 */

import com.caribbeansea.caribbean.engine.entity.__entity;
import com.caribbeansea.caribbean.engine.process.__inputer;
import com.caribbeansea.caribbean.engine.process.__updater;
import com.caribbeansea.caribbean.engine.render.__renderer;

/**
 * 游戏状态
 *
 * @author tiansheng
 */
public abstract class __state implements __updater, __renderer, __inputer
{

    /**
     * 是否启用，如果状态被禁用的话将不会去调用
     */
    protected boolean enable = false;

    /**
     * 游戏实体
     */
    protected __entity entity;

    public __state()
    {
        construct();
    }

    /**
     * 初始化操作
     */
    public abstract void construct();

}
