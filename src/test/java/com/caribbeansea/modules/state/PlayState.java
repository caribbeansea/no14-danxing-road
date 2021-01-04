package com.caribbeansea.modules.state;

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

import com.caribbeansea.engine.component.GameFont;
import com.caribbeansea.engine.component.GamePanel;
import com.caribbeansea.engine.component.Sprites;
import com.caribbeansea.engine.component.Vector2f;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;
import com.caribbeansea.engine.state.GameState;
import com.caribbeansea.engine.state.GameStateManager;
import com.caribbeansea.modules.entity.PlayerUnit;
import com.caribbeansea.modules.resources.ImageResources;

import java.awt.*;

/**
 * @author tiansheng
 */
public class PlayState extends GameState
{

    private GameFont font;

    private PlayerUnit player;

    public PlayState(GameStateManager stateManager)
    {
        super(stateManager);
        this.font = new GameFont(ImageResources.FONT_0, 16, 16);
        this.player = new PlayerUnit(new Sprites(ImageResources.LINK_FORMATTED), new Vector2f(300, 300), 128);
    }

    @Override
    public void update()
    {
        player.update();
    }

    @Override
    public void render(Graphics2D graphics)
    {
        player.render(graphics);
        Sprites.drawArray(graphics, font, "A I love you", new Vector2f(100, 100), 32, 32, 16, 0);

        String fps = GamePanel.GAME_CURRENT_FPS + "FPS";
        Sprites.drawArray(graphics, font, fps, new Vector2f(100, 100), 32, 32, 16, 0);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {
        player.input(mouse, key);
    }

}
