package com.caribbeansea.storyforself.instruction;

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

import com.caribbeansea.storyforself.Resources;
import com.caribbeansea.storyforself.component.CaribbeanPanel;

import java.awt.*;

/**
 * 指令输入面板
 *
 * @author tiansheng
 */
public class InstPanel
{

    private final CaribbeanPanel caribbeanPanel;

    public InstPanel(CaribbeanPanel caribbeanPanel)
    {
        this.caribbeanPanel = caribbeanPanel;
    }

    public void visible()
    {
        caribbeanPanel.setVisibleInst(!caribbeanPanel.isVisibleInst());
    }

    public void drawInst(Graphics g)
    {
        // TODO: 测试显示
        g.drawImage(Resources.terraria_moon_0,0,0, null);
    }
}
