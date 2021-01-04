package com.caribbeansea.engine.component;

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
 * Creates on 2021/1/3.
 */

import com.caribbeansea.engine.game.GameRender;
import com.caribbeansea.engine.handler.KeyHandler;
import com.caribbeansea.engine.handler.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 游戏动画
 *
 * @author tiansheng
 */
public class Animation implements GameRender
{

    /**
     * 动画的没帧图片
     */
    private BufferedImage[] frames;

    /**
     * 当前帧
     */
    private int curr_frames;

    /**
     * 当前动画总共有多少帧
     */
    private int number_frames;

    /**
     * update被调用次数
     */
    private int count;

    /**
     * 播放延迟
     */
    private int delay;

    /**
     * 播放次数
     */
    private int timesPlayed;

    public Animation()
    {
        this.timesPlayed = 0;
    }

    public Animation(BufferedImage[] frames)
    {
        setFrames(frames);
    }

    public void setFrames(BufferedImage[] frames)
    {
        this.frames = frames;
        this.curr_frames = 0;
        this.count = 0;
        this.timesPlayed = 0;
        this.delay = 2;
        this.number_frames = frames.length;
    }

    @Override
    public void update()
    {
        if (delay == -1) return;

        count++;

        // 当被调用次数达到delay延迟要求时候播放下一帧
        if (count == delay)
        {
            this.curr_frames++;
            this.count = 0;
        }

        if (curr_frames == number_frames)
        {
            this.curr_frames = 0;
            timesPlayed++;
        }
    }

    @Override
    public void render(Graphics2D graphics)
    {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key)
    {

    }

    public boolean hasPlayedOnce()
    {
        return timesPlayed > 0;
    }

    public boolean hasPlayed(int palyed)
    {
        return timesPlayed == palyed;
    }

    public void setDelay(int delay)
    {
        this.delay = delay;
    }

    public void setCurrFrames(int frames)
    {
        this.curr_frames = frames;
    }

    public void setNumberFrames(int frames)
    {
        this.number_frames = frames;
    }

    public BufferedImage getFrames()
    {
        return frames[curr_frames];
    }

    public int getCurrFrames()
    {
        return curr_frames;
    }

    public int getNumberFrames()
    {
        return number_frames;
    }

    public int getCount()
    {
        return count;
    }

    public int getDelay()
    {
        return delay;
    }

    public int getTimesPlayed()
    {
        return timesPlayed;
    }
}
