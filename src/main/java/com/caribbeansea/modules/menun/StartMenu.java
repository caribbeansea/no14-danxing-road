package com.caribbeansea.modules.menun;

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

import com.caribbeansea.engine.audio.AudioPlay;
import com.caribbeansea.engine.audio.AudioPlays;
import com.caribbeansea.modules.resources.AudioResrouces;
import com.caribbeansea.modules.resources.ImageResources;
import com.caribbeansea.engine.utils.Lists;
import com.caribbeansea.engine.utils.ToolBox;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 开始菜单
 *
 * @author tiansheng
 */
@SuppressWarnings({
        "FieldCanBeLocal",
        "FieldMayBeFinal",
        "SameParameterValue",
})
public class StartMenu extends JPanel
{

    /**
     * 绘制速度
     */
    private final int speed = 15;

    private int w;

    private int h;

    private int curr_x_group1, curr_y_group1;

    private int curr_x_group2, curr_y_group2;

    /**
     * 一次性画6朵云，当一朵云移动到屏幕外侧时重新初始化一个Cloud对象。
     * 并从屏幕右侧缓缓出现在屏幕中。<------- Cloud
     */
    private Cloud cloud_1, cloud_2, cloud_3;

    /**
     * 太阳和月亮位置
     * <p>
     * sun_moon_x的赋值操作在构造器中
     */
    private int sun_moon_x, sun_moon_y = -20;

    /**
     * 当第一组的图片完全跑到窗口外的时候停止绘制，并重制X，Y轴
     */
    private boolean isDrawGroup1 = true;

    /**
     * 当第二组的图片完全跑到窗口外的时候停止绘制，并重制X，Y轴
     */
    private boolean isDrawGroup2 = false;

    /**
     * 是否初始化了云朵
     */
    private boolean isInitCloud = false;

    /**
     * 窗口左边边缘的位置
     */
    private final int negativeWidth;

    /**
     * 两张图片绘制拼接的间距
     */
    private final int spacing = 1;

    /**
     * 背景音乐集合
     */
    private List<AudioPlay> backgroundAudios = Lists.newArrayList(
            AudioPlays.getAudioPlayInstance(AudioResrouces.HOME_OVE_MELAA_TIMES_MP3),
            AudioPlays.getAudioPlayInstance(AudioResrouces.HOME_OVEMELAA_HEAVENSINGS_MP3),
            AudioPlays.getAudioPlayInstance(AudioResrouces.HOME_OVEMELAA_THEMECRYSTALIZED_MP3)
    );

    private AudioPlay curr_play_bgm;

    public StartMenu(int w, int h)
    {
        this.w = w;
        this.h = h;
        initGroup1();
        initGroup2();
        this.negativeWidth = -w;
        this.sun_moon_x = w - 130;

        this.curr_play_bgm = ToolBox.randomValue(backgroundAudios);
        this.curr_play_bgm.play(AudioPlay.Play.LOOP);
    }

    void initGroup1()
    {
        curr_x_group1 = 0;
        curr_y_group1 = 0;
    }

    void initGroup2()
    {
        curr_x_group2 = w;
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

        // 初始化3朵云
        if (!isInitCloud)
        {
            cloud_1 = new Cloud(300, w, h, 30);
            cloud_2 = new Cloud(600, w, h, 30);
            cloud_3 = new Cloud(930, w, h, 30);
            isInitCloud = true;
        }

        // 设置图片的绘制速度，每隔20毫秒绘制一次
        ToolBox.sleep(speed);

        // 绘制图片
        drawImage(g);

        // 重新绘制所有图片，否则如果不清空面板再重新绘制的话会出现之前绘制的图片
        // 会停留在屏幕中，导致屏幕中出现非常多的图片。同时会导致内存的递增从而抛出OOM异常。
        repaint();
    }

    /**
     * 绘制背景图片
     *
     * @param g 画笔
     */
    private void drawImage(Graphics g)
    {
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
            drawBackground(g, curr_x_group2 - spacing, curr_y_group2);
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
        g.drawImage(ImageResources.TERRARIA_BACKGROUND_25.getBufferedImage(), x, y, null);
        // 绘制云层
        drawClouds(g);
        // 绘制树木背景
        g.drawImage(ImageResources.TERRARIA_BACKGROUND_178.getBufferedImage(), x, y, null);
    }

    /**
     * 绘制太阳和月亮
     * <p>
     * FIXME: 目前只设置了月亮，如果你愿意你可以根据时间来设置，如果当前是晚上就使用月亮。
     * FIXME: 也可以让太阳和月亮有个类似抛物线的动作，来实现日月交替的功能。
     */
    void drawSunOrMoon(Graphics graphics)
    {
        // 太阳和月亮的位置
        graphics.drawImage(ImageResources.TERRARIA_SUN.getBufferedImage(), sun_moon_x, sun_moon_y, null);
    }

    /**
     * 绘制云层
     */
    void drawClouds(Graphics g)
    {
        if (cloud_1 != null) cloud_1.paintSelf(g);
        if (cloud_2 != null) cloud_2.paintSelf(g);
        if (cloud_3 != null) cloud_3.paintSelf(g);
    }

    /**
     * 如果第一组图片的X轴小于0代表它从左往右绘制的时候已经绘制出
     * 屏幕的框了，所以我们需要启动第二组图片进行绘制。填充空白的位置
     */
    void whenXForGroup1LeZero()
    {
        if (curr_x_group1 < 0 && !isDrawGroup2)
        {
            startDrawGroup2(w, 0);
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
     * 当第二组图片的X轴小于{@link #w}时停止第二组图片的绘制，并启动
     * 第一组图片的绘制工作。
     */
    void whenXForGroup2LeWidth()
    {
        if (curr_x_group2 <= w && !isDrawGroup1)
        {
            stopDrawGroup2();
            startDrawGroup1(0, 0);
        }
    }

}
