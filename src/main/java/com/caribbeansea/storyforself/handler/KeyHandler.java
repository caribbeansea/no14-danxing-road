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
import com.caribbeansea.storyforself.utils.Lists;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * @author tiansheng
 */
public class KeyHandler implements KeyListener
{

    public static List<Key> keys = Lists.newArrayList();

    public Key VK_UP     = new Key();
    public Key VK_DOWN   = new Key();
    public Key VK_LEFT   = new Key();
    public Key VK_RIGHT  = new Key();
    public Key VK_ATTACK = new Key();
    public Key VK_MENU   = new Key();
    public Key VK_ENTER  = new Key();
    public Key VK_ESCAPE = new Key();
    public Key VK_MAP    = new Key();

    public KeyHandler(GamePanel gamePanel)
    {
        gamePanel.addKeyListener(this);
    }

    public void releaseAll()
    {
        for (Key key : keys)
        {
            key.down = false;
        }
    }

    public void tick()
    {
        for (Key key : keys)
        {
            key.tick();
        }
    }

    public void toggle(KeyEvent e, boolean pressed)
    {

        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            {
                VK_UP.toggle(pressed);
                break;
            }
            case KeyEvent.VK_DOWN:
            {
                VK_DOWN.toggle(pressed);
                break;
            }
            case KeyEvent.VK_LEFT:
            {
                VK_LEFT.toggle(pressed);
                break;
            }
            case KeyEvent.VK_RIGHT:
            {
                VK_RIGHT.toggle(pressed);
                break;
            }
            case KeyEvent.VK_A:
            {
                VK_ATTACK.toggle(pressed);
                break;
            }
            case KeyEvent.VK_ENTER:
            {
                VK_ENTER.toggle(pressed);
                break;
            }
            case KeyEvent.VK_E:
            {
                VK_MENU.toggle(pressed);
                break;
            }
            case KeyEvent.VK_ESCAPE:
            {
                VK_ESCAPE.toggle(pressed);
                break;
            }
            case KeyEvent.VK_M:
            {
                VK_MAP.toggle(pressed);
                break;
            }
        }

    }

    public static class Key
    {

        private int presses, absorbs;

        private boolean down, clicked;

        public Key()
        {
            keys.add(this);
        }

        public void toggle(boolean pressed)
        {
            if (pressed != down)
            {
                down = pressed;
            }

            if (pressed)
            {
                presses++;
            }
        }

        public void tick()
        {
            if (absorbs < presses)
            {
                absorbs++;
                clicked = true;
            } else
            {
                clicked = false;
            }
        }

        public int getPresses()
        {
            return presses;
        }

        public int getAbsorbs()
        {
            return absorbs;
        }

        public boolean isDown()
        {
            return down;
        }

        public boolean isClicked()
        {
            return clicked;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        toggle(e, false);
    }

}