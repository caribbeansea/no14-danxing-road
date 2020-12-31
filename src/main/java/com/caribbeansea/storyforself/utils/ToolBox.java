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
import sun.misc.Unsafe;

import java.awt.*;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Random;

/**
 * 工具箱
 */
public class ToolBox
{

    public static Random RANDOM = new Random();

    public static Unsafe THE_UNSAFE;

    static
    {
        try
        {
            final PrivilegedExceptionAction<Unsafe> action = () ->
            {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe) theUnsafe.get(null);
            };
            THE_UNSAFE = AccessController.doPrivileged(action);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    public static void sleep(long ms)
    {
        try
        {
            Thread.sleep(ms);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @return 从 {@link ResourcesCollects#terraria_clouds} 集合中随机获取一片云
     */
    public static Image randomCloud()
    {
        int index = ToolBox.RANDOM.nextInt(ResourcesCollects.terraria_clouds.size());
        return ResourcesCollects.terraria_clouds.get(index);
    }

}
