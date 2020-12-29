package storyforself.menun;

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
 * Creates on 2020/12/28.
 */

import storyforself.ResourcesCollects;
import storyforself.Utils;
import storyforself.component.RoadPanel;

import java.awt.*;

/**
 * 开始菜单
 *
 * @author tiansheng
 */
@SuppressWarnings("SameParameterValue")
public class StartMenu extends RoadPanel
{

    /**
     * 移动速度
     */
    private final int speed = 20;

    private int width;

    private int curr_x_group1, curr_y_group1;

    private int curr_x_group2, curr_y_group2;

    /**
     * 云彩需要跟随着场景而移动，所以这边为5个云彩定义个X和Y轴坐标
     */
    private int cloud_x_1 = 0, cloud_y_1 = 0,
            cloud_x_2     = 0, cloud_y_2 = 0,
            cloud_x_3     = 0, cloud_y_3 = 0,
            cloud_x_4     = 0, cloud_y_4 = 0,
            cloud_x_5     = 0, cloud_y_5 = 0,
            cloud_x_6     = 0, cloud_y_6 = 0;

    private Image cloud_1 =
            null;

    private Image cloud_2 =
            null;

    private Image cloud_3 =
            null;

    private Image cloud_4 =
            null;

    private Image cloud_5 =
            null;

    private Image cloud_6 =
            null;

    // 是否初始化了过云图片了
    private boolean initCloud = false;

    /**
     * 太阳和月亮位置
     */
    private int sun_moon_x = 900, sun_moon_y = -20;

    /**
     * 当第一组的图片完全跑到窗口外的时候停止绘制，并重制X，Y轴
     */
    private boolean isDrawGroup1 = true;

    /**
     * 当第二组的图片完全跑到窗口外的时候停止绘制，并重制X，Y轴
     */
    private boolean isDrawGroup2 = false;

    /**
     * 窗口左边边缘的位置
     */
    private int negativeWidth;

    public StartMenu(int width, int height)
    {
        this.width = width;
        initGroup1();
        initGroup2();
        this.negativeWidth = -width;
    }

    void initGroup1()
    {
        curr_x_group1 = 0;
        curr_y_group1 = 0;
    }

    void initGroup2()
    {
        curr_x_group2 = width;
        curr_y_group2 = 0;
    }

    /**
     * 停止第一组图片的绘制并初始化
     */
    void stopDrawGroup1()
    {
        isDrawGroup1 = false;
        initGroup1();
    }

    /**
     * 停止第二组图片的绘制并初始化
     */
    void stopDrawGroup2()
    {
        isDrawGroup2 = false;
        initGroup1();
    }

    void startDrawGroup1(int x, int y)
    {
        isDrawGroup1 = true;
        curr_x_group1 = x;
        curr_y_group1 = y;
    }

    void startDrawGroup2(int x, int y)
    {
        isDrawGroup2 = true;
        curr_x_group2 = x;
        curr_y_group2 = y;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Utils.sleep(speed);
        // 图片背景缓慢移动
        drawBackground(g);
        repaint();
    }

    /**
     * 绘制背景图片
     *
     * @param g 画笔
     */
    private void drawBackground(Graphics g)
    {
        drawCloud(g);
        drawSunOrMoon(g);

        if (isDrawGroup1)
        {
            currXGroup1Speed();
            // # GROUP 1
            drawBackground(g, curr_x_group1, curr_y_group1);
            // # END
        }

        if (isDrawGroup2)
        {
            currXGroup2Speed();
            // # GROUP 2
            drawBackground(g, curr_x_group2, curr_y_group2);
            // # END
        }

        whenXForGroup1LeZero();
        whenXForGroup1LeNegativeWidth();
        whenXForGroup2LeWidth();

        // Log.info("X1：【%s】，Y1：【%s】| X2：【%s】，Y2：【%s】", curr_x_group1, curr_y_group1, curr_x_group2, curr_y_group2);
    }

    void currXGroup1Speed()
    {
        curr_x_group1--;
    }

    void currXGroup2Speed()
    {
        curr_x_group2--;
    }

    /**
     * 绘制图片
     *
     * @param g 画笔
     * @param x 图片在x轴的位置
     * @param y 图片在y轴的位置
     */
    void drawBackground(Graphics g, int x, int y)
    {
        // 绘制高山背景
        g.drawImage(ResourcesCollects.terraria_background_25, x, y, null);
        // 绘制树木背景
        g.drawImage(ResourcesCollects.terraria_background_61, x, y, null);
    }

    /**
     * 绘制太阳和月亮
     * <p>
     * FIXME: 目前只设置了月亮，如果你愿意你可以根据时间来设置，如果当前是晚上就使用月亮。
     *        也可以让太阳和月亮有个类似抛物线的动作，来实现日月交替的功能。
     *
     * @param g 画笔
     */
    void drawSunOrMoon(Graphics g)
    {
        // 太阳和月亮的位置
        g.drawImage(ResourcesCollects.terraria_sun, sun_moon_x, sun_moon_y, null);
    }

    /**
     * 随机画出几朵云彩
     *
     * @param g 画笔
     */
    void drawCloud(Graphics g)
    {
        // 随机取出几朵云彩
        cloud_1 = ResourcesCollects.ToolBox.randomCloud();
        cloud_2 = ResourcesCollects.ToolBox.randomCloud();
        cloud_3 = ResourcesCollects.ToolBox.randomCloud();
        cloud_4 = ResourcesCollects.ToolBox.randomCloud();
        cloud_5 = ResourcesCollects.ToolBox.randomCloud();
        cloud_6 = ResourcesCollects.ToolBox.randomCloud();
        g.drawImage(cloud_1, cloud_x_1, cloud_y_1, null);
    }

    /**
     * 随机云彩位置
     *
     * @param specify 自定云彩索引，1 - 6
     */
    void randomCloudXYLocation(int specify)
    {
        switch (specify)
        {
            case 1:
            {
                this.cloud_x_1 = 0;
                this.cloud_y_1 = 0;
                break;
            }
            case 2:
            {
                this.cloud_x_2 = 0;
                this.cloud_y_2 = 0;
                break;
            }
            case 3:
            {
                this.cloud_x_3 = 0;
                this.cloud_y_3 = 0;
                break;
            }
            case 4:
            {
                this.cloud_x_4 = 0;
                this.cloud_y_4 = 0;
                break;
            }
            case 5:
            {
                this.cloud_x_5 = 0;
                this.cloud_y_5 = 0;
                break;
            }
            case 6:
            {
                this.cloud_x_6 = 0;
                this.cloud_y_6 = 0;
                break;
            }
        }
    }

    /**
     * 如果第一组图片的X轴小于0代表它从左往右绘制的时候已经绘制出
     * 屏幕的框了，所以我们需要启动第二组图片进行绘制。填充空白的位置
     */
    void whenXForGroup1LeZero()
    {
        if (curr_x_group1 < 0 && !isDrawGroup2)
        {
            startDrawGroup2(width, 0);
        }
    }

    /**
     * 当第一组的X轴坐标小于当前窗口宽度时停止绘制第一组图片
     */
    void whenXForGroup1LeNegativeWidth()
    {
        if (curr_x_group1 <= negativeWidth)
        {
            stopDrawGroup1();
        }
    }

    /**
     * 当第二组图片的X轴小于{@link #width}时停止第二组图片的绘制，并启动
     * 第一组图片的绘制工作。
     */
    void whenXForGroup2LeWidth()
    {
        if (curr_x_group2 <= width && !isDrawGroup1)
        {
            stopDrawGroup2();
            startDrawGroup1(0, 0);
        }
    }

}
