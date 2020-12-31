package com.caribbeansea.storyforself.utils;

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
 * Creates on 2020/12/31.
 */

import com.caribbeansea.storyforself.ResourcesCollects;
import com.caribbeansea.storyforself.Utils;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 素材工具箱
 */
public class ToolBox
{

    public static final ExecutorService EXEC_INSTANCE = Executors.newCachedThreadPool();

    /**
     * @return 从 {@link ResourcesCollects#terraria_clouds} 集合中随机获取一片云
     */
    public static Image randomCloud()
    {
        int index = Utils.RANDOM.nextInt(ResourcesCollects.terraria_clouds.size());
        return ResourcesCollects.terraria_clouds.get(index);
    }

    public static void exec(Runnable runnable)
    {

    }

}
