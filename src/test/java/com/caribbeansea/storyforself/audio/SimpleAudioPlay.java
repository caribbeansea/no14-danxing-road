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

import javax.sound.sampled.*;
import java.io.File;

/**
 * @author tiansheng
 */
public class SimpleAudioPlay
{

    public static void main(String[] args) throws Throwable
    {
        Clip clip = AudioSystem.getClip();
        AudioInputStream audioInputStream
                // FIXME: 这个好像是只支持WAV格式。目前暂时没有这个格式的音频，有了可以加上
                = AudioSystem.getAudioInputStream(new File("resources/audio/home/OveMelaa-HeavenSings.mp3"));

        clip.open(audioInputStream);

        while (true) {

        }

    }

}
