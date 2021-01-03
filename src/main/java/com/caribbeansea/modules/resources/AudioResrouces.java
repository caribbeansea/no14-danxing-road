package com.caribbeansea.modules.resources;

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

import com.caribbeansea.engine.Log;
import com.caribbeansea.modules.WriteYourStory;

import java.io.File;

/**
 * @author tiansheng
 */
public enum AudioResrouces
{

    HOME_OVE_MELAA_TIMES_MP3(read("/home/Ove_Melaa_Times.mp3")),

    HOME_OVEMELAA_THEMECRYSTALIZED_MP3(read("/home/OveMelaa_HeavenSings.mp3")),

    HOME_OVEMELAA_HEAVENSINGS_MP3(read("/home/OveMelaa_ThemeCrystalized .mp3")),

    ;

    private File file;

    AudioResrouces(File file)
    {
        this.file = file;
    }

    public File getAudioFile() {
        return this.file;
    }

    static File read(String path)
    {
        File audiof = new File(WriteYourStory.AUDIO_RESOURCES.concat(path));
        if (!audiof.exists())
        {
            Log.error("cloud not load audio for path %s", audiof.getPath());
        }
        return audiof;
    }

}

