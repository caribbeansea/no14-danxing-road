package com.caribbeansea.storyforself;

/* ************************************************************************
 *
 * Copyright (C) 2020 dahan All rights reserved.
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
 * Creates on 2020/12/29.
 */

import java.io.PrintStream;

/**
 * @author tiansheng
 */
public class Log
{

    private static final PrintStream out = System.out;

    private static final PrintStream err = System.err;

    private static final String INFO = "[INFO] - ";

    private static final String DEBUG = "[DEBUG] - ";

    private static final String ERROR = "[ERROR] - ";

    public static void printCoords(String name, int x, int y)
    {
        info("%s X：【%s】，Y：【%s】", name, x, y);
    }

    public static void info(String msg)
    {
        info(msg, (Object) null);
    }

    public static void info(String msg, Object... args)
    {
        out.printf(INFO.concat(msg).concat("\n"), args);
    }

    public static void debug(String msg)
    {
        info(msg, (Object) null);
    }

    public static void debug(String msg, Object... args)
    {
        out.printf(DEBUG.concat(msg).concat("\n"), args);
    }

    public static void error(String msg)
    {
        error(msg, null, (Object) null);
    }

    public static void error(String msg, Object... args)
    {
        error(msg, null, args);
    }

    public static void error(String msg, Throwable e, Object... args)
    {
        err.printf(ERROR.concat(msg).concat("\n"), args);
        if (e != null)
        {
            e.printStackTrace();
        }
    }

    public static void note(String msg)
    {
        info(msg);
    }

}
