package com.caribbeansea.storyforself;

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
 * Creates on 2020/12/28.
 */


import com.caribbeansea.storyforself.utils.Lists;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 资源管理接口
 *
 * @author tiansheng
 */
public interface ResourcesCollects
{
    String RESOURCES = "resources";

    Image terraria_background_61 = ImageRead.read("/ui/Background_61.png");

    Image terraria_background_25 = ImageRead.read("/ui/Background_25.png");

    Image terraria_background_178 = ImageRead.read("/ui/Background_178.png");

    /**
     * 泰拉瑞亚中的云彩
     */
    List<Image> terraria_clouds = Lists.newArrayList(
            ImageRead.read("/ui/cloud/Cloud_4.png"),
            ImageRead.read("/ui/cloud/Cloud_5.png"),
            ImageRead.read("/ui/cloud/Cloud_6.png"),
            ImageRead.read("/ui/cloud/Cloud_7.png"),
            ImageRead.read("/ui/cloud/Cloud_8.png"),
            ImageRead.read("/ui/cloud/Cloud_9.png"),
            ImageRead.read("/ui/cloud/Cloud_10.png"),
            ImageRead.read("/ui/cloud/Cloud_11.png"),
            ImageRead.read("/ui/cloud/Cloud_12.png"),
            ImageRead.read("/ui/cloud/Cloud_13.png")
    );

    // #############################################################################################
    // ----------------------------- 泰拉瑞亚中的太阳和月亮以及星星 ------------------------------------
    // #############################################################################################

    Image terraria_star_1 = ImageRead.read("/ui/moon&sun&star/Star_1.png");

    Image terraria_star_0 = ImageRead.read("/ui/moon&sun&star/Star_0.png");

    Image terraria_star_2 = ImageRead.read("/ui/moon&sun&star/Star_2.png");

    Image terraria_star_3 = ImageRead.read("/ui/moon&sun&star/Star_3.png");

    Image terraria_star_4 = ImageRead.read("/ui/moon&sun&star/Star_4.png");

    Image terraria_sun3 = ImageRead.read("/ui/moon&sun&star/Sun3.png");

    Image terraria_sun2 = ImageRead.read("/ui/moon&sun&star/Sun2.png");

    Image terraria_moon_snow = ImageRead.read("/ui/moon&sun&star/Moon_Snow.png");

    Image terraria_moon_pumpkin = ImageRead.read("/ui/moon&sun&star/Moon_Pumpkin.png");

    Image terraria_sun = ImageRead.read("/ui/moon&sun&star/Sun.png");

    Image terraria_moon_2 = ImageRead.read("/ui/moon&sun&star/Moon_2.png");

    Image terraria_moon_1 = ImageRead.read("/ui/moon&sun&star/Moon_1.png");

    Image terraria_moon_0 = ImageRead.read("/ui/moon&sun&star/Moon_0.png");

    // #############################################################################################
    // -----------------------------  AUDIO --------------------------------
    // #############################################################################################

    File HOME_OVEMELAA_HEAVENSINGS_MP3 = AudioRead.read("/home/OveMelaa-HeavenSings.mp3");

    class ImageRead
    {

        static Image read(String path)
        {
            Image image =
                    null;
            File imageFile = new File(RESOURCES.concat(path));
            try
            {
                image = ImageIO.read(imageFile);
            } catch (IOException e)
            {
                Log.error("image file path %s", e, imageFile.getPath());
            }
            return image;
        }
    }

    class AudioRead
    {

        static final String AUDIO_RESOURCES = RESOURCES.concat("/audio");

        static File read(String path)
        {
            File audiof = new File(AUDIO_RESOURCES.concat(path));
            if(!audiof.exists()) {
                Log.error("image file path %s", audiof.getPath());
            }
            return audiof;
        }
    }

}
