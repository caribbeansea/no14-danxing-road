package com.caribbeansea.storyforself.component;

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

import com.caribbeansea.storyforself.instruction.InstPanel;
import com.caribbeansea.storyforself.resources.ImageResources;

import javax.swing.*;
import java.awt.*;

/**
 * @author tiansheng
 */
public class CaribbeanPanel extends JPanel
{

    boolean visibleInst = false;

    private InstPanel instPanel;

    public void repaint()
    {
        if (visibleInst)
        {
            instPanel.drawInst(getGraphics());
        }

        super.repaint();
    }

    public boolean isVisibleInst()
    {
        return visibleInst;
    }

    public void setVisibleInst(boolean visibleInst)
    {
        this.visibleInst = visibleInst;
    }

    public InstPanel getInstPanel()
    {
        return instPanel;
    }

    public void setInstPanel(InstPanel instPanel)
    {
        this.instPanel = instPanel;
    }

    public void drawImage(Graphics graphics, ImageResources resources, int x, int y)
    {
        drawImage(graphics, resources.getBufferedImage(), x, y, false);
    }

    public void drawImage(Graphics graphics, ImageResources resources, int x, int y, boolean variety)
    {
        drawImage(graphics, resources.getBufferedImage(), x, y, variety);
    }

    public void drawImage(Graphics graphics, Image image, int x, int y)
    {
        drawImage(graphics, image, x, y, false);
    }

    public void drawImage(Graphics graphics, Image image, int x, int y, boolean variety)
    {
        if (variety)
        {
            graphics.drawImage(image, x, y, getWidth(), getHeight(), null);
        } else
        {
            graphics.drawImage(image, x, y, null);
        }
    }

}
