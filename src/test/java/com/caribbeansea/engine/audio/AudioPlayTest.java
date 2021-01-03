package com.caribbeansea.engine.audio;

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

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author tiansheng
 */
public class AudioPlayTest
{

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException
    {
        AudioInputStream ais
                = AudioSystem.getAudioInputStream(new File("resources/audio/home/OveMelaa_HeavenSings.mp3"));

        AudioFormat af = ais.getFormat();
        System.out.println(af.toString());
        System.out.println("音频总帧数：" + ais.getFrameLength());
        System.out.println("每秒播放帧数：" + af.getSampleRate());
        float len0 = ais.getFrameLength() / af.getSampleRate();
        System.out.println("音频时长（秒）：" + len0);
        System.out.println("音频时长：" + (int) len0 / 60 + "分" + (int) len0 % 60 + "秒");

        //使用 mp3spi 解码 mp3 音频文件
        MpegAudioFileReader mp = new MpegAudioFileReader();
        AudioFormat baseFormat = ais.getFormat();

        //设定输出格式为pcm格式的音频文件
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false);

        // 输出到音频
        ais = AudioSystem.getAudioInputStream(format, ais);
        AudioFormat target = ais.getFormat();
        DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, target, AudioSystem.NOT_SPECIFIED);
        SourceDataLine line = null;
        int len = -1;
        try
        {
            line = (SourceDataLine) AudioSystem.getLine(dinfo);
            line.open(target);
            line.start();
            byte[] buffer = new byte[1024];
            while ((len = ais.read(buffer)) > 0)
            {
                line.write(buffer, 0, len);
            }
            line.drain();
            line.stop();
            line.close();
        } catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        } finally
        {
            ais.close();
        }

    }

}
