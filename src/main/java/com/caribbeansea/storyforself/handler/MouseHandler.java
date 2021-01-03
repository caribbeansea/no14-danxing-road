package com.caribbeansea.storyforself.handler;

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
 * Creates on 2021/1/2.
 */

import com.caribbeansea.storyforself.component.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author tiansheng
 */
public class MouseHandler implements MouseListener, MouseMotionListener
{

    private int MOUSE_X = -1;

    private int MOUSE_Y = -1;

    private int MOUSE_B = -1;

    public MouseHandler(GamePanel gamePanel) {
        gamePanel.addMouseListener(this);
    }

    public int getX() {
        return MOUSE_X;
    }

    public int getY() {
        return MOUSE_Y;
    }

    public int getButton() {
        return MOUSE_B
                ;
    }

    private void setMouseXY(MouseEvent e) {
        this.MOUSE_X = e.getX();
        this.MOUSE_Y = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        this.MOUSE_B = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
       this.MOUSE_B = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    /**
     * 拖拽鼠标
     */
    @Override
    public void mouseDragged(MouseEvent e)
    {
        setMouseXY(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

}
