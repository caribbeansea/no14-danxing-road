package com.caribbeansea.caribbean.engine.bootstrap;

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
 * Creates on 2021/1/5.
 */

import com.caribbeansea.caribbean.engine.__initable;
import com.caribbeansea.caribbean.engine.state.__state_manager;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏启动器，这个启动器的作用就是整合了我们的（JPanel、JFrame）不需要我们
 * 去单独配置它们两个的各项参数。{@link javax.swing.JPanel} & {@link javax.swing.JFrame}
 * <p>
 * 所有统一参数会在启动器中去进行配置，也可以抽成配置文件进行配置。看用户自己的需求而定。
 *
 * @author tiansheng
 */
public abstract class __bootstrap implements __initable
{
    /**
     * 窗口的尺寸（宽高），默认是一个 500*500 大小的窗口。
     * <p>
     * 这个窗体的长宽高是具有传递性的，也就是说在我们的{@link __panel},{@link __state_manager},
     * {@link com.caribbeansea.caribbean.engine.state.__state}等对象中全局通用的。
     */
    private final Dimension dimension
            = new Dimension(500, 500);

    /**
     * 是否显示窗体，默认为true
     */
    private boolean visible = true;

    /**
     * 当游戏关闭时程序也随之关闭, 默认为 true
     */
    private boolean exit_on_close = true;

    /**
     * 当游戏启动时默认居中显示
     */
    private boolean centered = true;

    /**
     * 窗体对象，所有的参数配置实际上都是在配置它。
     */
    private final __frame frame;

    /**
     * 游戏面板，所有的图像都画在它上面。
     */
    private __panel panel;

    public __bootstrap()
    {
        this(null);
    }

    /**
     * 构造器，里面调用初始化方法
     */
    public __bootstrap(__panel panel)
    {
        if (panel != null)
            this.panel = panel;

        init(); /* 所有成员配置都使用它来配置 */

        this.frame = new __frame();

        this.frame.setSize(dimension);

        if (exit_on_close)
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (centered)
            this.frame.setLocationRelativeTo(null);

        __frame_configure(this.frame); /* 用户对 __frame 的自定义配置*/

        this.frame.setContentPane(panel); /* 添加面板 */

        this.frame.setVisible(visible);
    }

    /**
     * 设置窗体大小
     *
     * @param width  窗口宽度
     * @param height 窗口高度
     */
    public void size(int width, int height)
    {
        this.dimension.setSize(width, height);
    }

    /**
     * 如果有特殊需要去单独配置 __frame 的话可以去重写这个方法进行配置。
     *
     * @param frame __frame实例
     */
    public void __frame_configure(__frame frame)
    {
        // do nothing
    }

    public __panel panel()
    {
        return panel;
    }

    public void panel(__panel panel)
    {
        this.panel = panel;
    }

    public __frame frame()
    {
        return frame;
    }

    public boolean centered()
    {
        return centered;
    }

    public void centered(boolean centered)
    {
        this.centered = centered;
    }

    public boolean exit_on_close()
    {
        return exit_on_close;
    }

    public void exit_on_close(boolean exit_on_close)
    {
        this.exit_on_close = exit_on_close;
    }

    public boolean visible()
    {
        return visible;
    }

    public void visible(boolean visible)
    {
        this.visible = visible;
    }

    public int width()
    {
        return this.dimension.width;
    }

    public void width(int width)
    {
        this.dimension.width = width;
    }

    public int height()
    {
        return this.dimension.height;
    }

    public void height(int height)
    {
        this.dimension.height = height;
    }

}
