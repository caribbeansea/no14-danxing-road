package com.caribbeansea.storyforself.menun;

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

import com.caribbeansea.storyforself.Utils;
import com.caribbeansea.storyforself.utils.ToolBox;

import java.awt.*;

/**
 * @author tiansheng
 */
public class Cloud
{

    /**
     * 随机取出的Cloud图片
     */
    private Image cloudImage;

    /**
     * 图片宽度
     */
    private int imageWidth;

    /**
     * 面板宽度
     */
    private int width;

    /**
     * 面板高度
     */
    private int height;

    /**
     * 初始化X轴坐标
     */
    private int x;

    /**
     * 初始化Y轴坐标
     */
    private int y;

    /**
     * 取值区间，云可以画的范围在 interval - 0 （这里的0是指的屏幕高度。数值越小，高度越大）,
     * 内任何一个地方随机画出，形成不同高度的云。
     */
    private int interval;

    /**
     * Cloud构造器
     *
     * @param width  面板宽度
     * @param height 面板高度
     */
    public Cloud(int x, int width, int height, int interval)
    {
        initImage();
        this.width = width;
        this.height = height;
        this.interval = interval;
        initCoords(x);
    }

    /**
     * 初始化X,Y坐标
     */
    private void initCoords(int x)
    {
        this.x = x;
        this.y = (Utils.RANDOM.nextInt(interval));
    }

    /**
     * 初始化图片
     */
    private void initImage()
    {
        this.cloudImage = ToolBox.randomCloud();
        this.imageWidth = this.cloudImage.getWidth(null);
    }

    /**
     * 将自己画到面板上
     */
    public void paintSelf(Graphics graphics)
    {
        // 如果云到达边缘就重新初始化X坐标
        if (x == -imageWidth)
        {
            initImage();
            initCoords(width);
        }
        graphics.drawImage(cloudImage, x--, y, null);
    }

}
