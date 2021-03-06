package engine.utils;

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

import engine.Log;
import modules.WriteYourStory;
import sun.misc.Unsafe;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.Random;

/**
 * 工具箱
 */
public class ToolBox
{

    public static Random RANDOM = new Random();

    public static Unsafe UNSAFE;

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
            UNSAFE = AccessController.doPrivileged(action);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    /**
     * 线程休眠
     *
     * @param ms 毫秒
     */
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
     * 从List中随机取出一个数据。取值范围为 0 - #size()
     *
     * @param a 集合
     * @return 随机取出的值
     */
    public static <T> T randomValue(List<T> a)
    {
        return a.get(RANDOM.nextInt(a.size()));
    }

    public static long getTimeSeconds()
    {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 读取图片
     *
     * @param path 图片路径
     * @return Image对象
     */
    public static BufferedImage read_buffimg_in_resources(String path)
    {
        BufferedImage image =
                null;
        File imageFile = read_file_in_resources(path);
        try
        {
            image = ImageIO.read(imageFile);
        } catch (IOException e)
        {
            Log.error("cloud not load image for %s", e, imageFile.getPath());
        }
        return image;
    }

    public static File read_file_in_resources(String path)
    {
        return new File(WriteYourStory.RESOURCES.concat(path));
    }
}
