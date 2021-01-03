package com.caribbeansea.storyforself.state;

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

import com.caribbeansea.storyforself.component.GameFont;
import com.caribbeansea.storyforself.component.Vector2f;
import com.caribbeansea.storyforself.component.Sprite;
import com.caribbeansea.storyforself.handler.KeyHandler;
import com.caribbeansea.storyforself.handler.MouseHandler;
import com.caribbeansea.storyforself.resources.ImageResources;

import java.awt.*;

/**
 * @author tiansheng
 */
public class PlayState extends GameState
{

    private GameFont font;

    public PlayState(GameStateManager stateManager)
    {
        super(stateManager);
        this.font = new GameFont(ImageResources.FONT_0, 16, 16);
    }

    @Override
    public void update()
    {
    }

    @Override
    public void render(Graphics2D graphics)
    {
        Sprite.drawArray(graphics, font, "A I love you", new Vector2f(100, 100), 32, 32, 16, 0);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {
        if (key.VK_DOWN.isDown())
        {
            System.out.println("down");
        }
    }

}
