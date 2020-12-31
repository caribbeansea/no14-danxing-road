package thread;

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

import com.caribbeansea.storyforself.Log;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Scanner;
import com.caribbeansea.storyforself.utils.ToolBox;

/**
 * @author tiansheng
 */
public class ThreadTest
{

    public static final Object object = new Object();

    public static boolean block = false;

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

    public static void main(String[] args) throws InterruptedException
    {
        // thread0线程
        Thread thread0 = new Thread(() ->
        {
            while (true)
            {
                ToolBox.sleep(1000);
                System.out.println("-------------thread0");
                if (block)
                {
                    UNSAFE.park(false, 0L);
                }
            }
        });

        // thread1线程
        Thread thread1 = new Thread(() ->
        {
            while (true)
            {
                ToolBox.sleep(1000);
                System.out.println("thread1-------------");
            }
        });

        // 启动 thread0 & thread1
        thread0.start();
        thread1.start();


        // 执行主线程的Scanner方法
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            int value = scanner.nextInt();

            if (value == 0)
            {
                Log.info("暂停thread0");
                block = true;
            } else
            {
                Log.info("唤醒thread0");
                UNSAFE.unpark(thread0);
                block = false;
            }

        }

    }

}