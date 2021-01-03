package com.caribbeansea.engine.audio.type;

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

import com.caribbeansea.engine.audio.AbstractAudioPlay;
import com.caribbeansea.engine.utils.ToolBox;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author tiansheng
 */
@SuppressWarnings("FieldCanBeLocal")
public class PlayMp3 extends AbstractAudioPlay
{

    private DataLine.Info dinfo;

    private SourceDataLine line;

    private AudioFormat target;

    private int len = -1;

    public PlayMp3(File file) throws IOException, UnsupportedAudioFileException
    {
        super("MP3", file);
    }

    @Override
    protected void reloadVal()
    {
        //设定输出格式为pcm格式的音频文件
        AudioFormat baseFormat = stream.getFormat();
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false);

        // 输出到音频
        stream = AudioSystem.getAudioInputStream(format, stream);
        this.target = stream.getFormat();

        this.dinfo = new DataLine.Info(SourceDataLine.class, this.target, AudioSystem.NOT_SPECIFIED);
    }

    /**
     * 播放一次后结束
     */
    private void startPlayAudioOnce() {
        try
        {
            line = (SourceDataLine) AudioSystem.getLine(dinfo);
            line.open(target);
            line.start();
            byte[] buffer = new byte[1024];
            while ((len = stream.read(buffer)) > 0)
            {
                if(park) {
                     ToolBox.UNSAFE.park(false, 0L);
                }
                line.write(buffer, 0, len);
            }
            line.drain();
            line.stop();
            line.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 循环播放
     */
    private void startPlayAudioLoop() {
        try
        {
            while (true) {
                startPlayAudioOnce();
                reload();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * look for #run()
     */
    @Override
    public void play(Play play)
    {
        start();
    }

    @Override
    public void run()
    {
        if(play == Play.ONCE)
        {
            startPlayAudioOnce();
        } else {
            startPlayAudioLoop();
        }
    }

}
