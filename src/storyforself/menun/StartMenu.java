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

import storyforself.Log;
import storyforself.ResourcesCollects;
import storyforself.Utils;
import storyforself.component.RoadPanel;

import java.awt.*;

/**
 * 开始菜单
 *
 * @author tiansheng
 */
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
     * 当第一组的图片完全跑到窗口外的时候停止绘制，并重制X，Y轴
     */
    private boolean isDrawGroup1 = true;

    /**
     * 当第二组的图片完全跑到窗口外的时候停止绘制，并重制X，Y轴
     */
    private boolean isDrawGroup2 = false;

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

        if (isDrawGroup1)
        {
            currXGroup1Speed();
            g.drawImage(ResourcesCollects.TerrariaBcakgroup_25, curr_x_group1, curr_y_group1, null);
            g.drawImage(ResourcesCollects.TerrariaBcakgroup_61, curr_x_group1, curr_y_group1, null);
        }

        if (isDrawGroup2)
        {
            currXGroup2Speed();
            g.drawImage(ResourcesCollects.TerrariaBcakgroup_25, curr_x_group2, curr_y_group2, null);
            g.drawImage(ResourcesCollects.TerrariaBcakgroup_61, curr_x_group2, curr_y_group2, null);
        }

        if (curr_x_group1 < 0 && !isDrawGroup2)
        {
            startDrawGroup2(width, 0);
        }

        if (curr_x_group1 <= negativeWidth)
        {
            stopDrawGroup1();
        }

        if (curr_x_group2 <= width && !isDrawGroup1)
        {
            stopDrawGroup2();
            startDrawGroup1(0, 0);
        }

        // 当第一组的X轴坐标小于当前窗口宽度时停止绘制第一组图片

        Log.info("X1：【%s】，Y1：【%s】| X2：【%s】，Y2：【%s】", curr_x_group1, curr_y_group1, curr_x_group2, curr_y_group2);
    }

    void currXGroup1Speed()
    {
        curr_x_group1--;
    }

    void currXGroup2Speed()
    {
        curr_x_group2--;
    }

}
