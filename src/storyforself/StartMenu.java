package storyforself;

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

import storyforself.component.RoadPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 开始菜单
 *
 * @author tiansheng
 */
public class StartMenu extends RoadPanel
{

    private int curr_x = 0;

    private int curr_y = 0;

    @Override
    public void paint(Graphics g)
    {
        Utils.sleep(20);
        // 图片背景缓慢移动
        g.drawImage(ResourcesCollects.TerrariaTreeBackground, curr_x--, curr_y, null);
        repaint();
    }

}
