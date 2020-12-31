package com.caribbeansea.storyforself.audio;

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
 * Creates on 2020/12/30.
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/**
 * @author tiansheng
 */
public abstract class AbstractAudioPlay extends Thread implements AudioPlay
{

    protected AudioInputStream stream;

    protected File file;

    protected boolean AUDIO_PAUSE = false;

    protected Play play;

    private final Thread thread;

    public AbstractAudioPlay(String name, File file) throws IOException, UnsupportedAudioFileException
    {
        getAudioInputStream(file);
        this.thread = new Thread(this, name);
        // AudioPlayManager.putAudioTask(this);
    }

    protected void getAudioInputStream(File file) throws IOException, UnsupportedAudioFileException
    {
        this.file = file;
        reload0();
    }

    protected void reload0() throws IOException, UnsupportedAudioFileException
    {
        this.stream = AudioSystem.getAudioInputStream(file);
        reload();
    }

    /**
     * 初始化加载音频所需的IO流，以及重新加载流。
     * <p>
     * 子类不需要去关心{@link #stream}的初始化操作，只需关心自己支持的音频媒体格式的
     * 初始化操作即可。
     */
    protected abstract void reload();

    /**
     * 唤醒当前线程
     */
    protected void wake()
    {

    }

    /**
     * 阻塞当前线程，相当于停止播放
     */
    protected void block()
    {
    }

    @Override
    public void play(Play play)
    {
        this.play = play;
        start();
    }

    @Override
    public void once()
    {
    }

    @Override
    public void loop()
    {
    }

    @Override
    public void replay()
    {
    }

    @Override
    public void pause()
    {
        block();
    }

    @Override
    public void continuePlay()
    {
    }

    @Override
    public void finish()
    {
    }

    @Override
    public void run()
    {
    }

}