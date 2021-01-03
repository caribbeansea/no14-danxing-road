package com.caribbeansea.storyforself.resources;

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
 * Creates on 2021/1/1.
 */

import com.caribbeansea.storyforself.Log;
import com.caribbeansea.storyforself.WriteYourStory;
import com.caribbeansea.storyforself.utils.Lists;
import com.caribbeansea.storyforself.utils.ToolBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author tiansheng
 */
public enum ImageResources
{


    TERRARIA_BACKGROUND_61(read("/ui/Background_61.png")),

    TERRARIA_BACKGROUND_25(read("/ui/Background_25.png")),

    TERRARIA_BACKGROUND_178(read("/ui/Background_178.png")),

    // #######################################################################
    // ----------------------------  太阳和月亮以及星星 ------------------------
    // #######################################################################

    TERRARIA_STAR_1(read("/ui/moon&sun&star/Star_1.png")),

    TERRARIA_STAR_0(read("/ui/moon&sun&star/Star_0.png")),

    TERRARIA_STAR_2(read("/ui/moon&sun&star/Star_2.png")),

    TERRARIA_STAR_3(read("/ui/moon&sun&star/Star_3.png")),

    TERRARIA_STAR_4(read("/ui/moon&sun&star/Star_4.png")),

    TERRARIA_SUN3(read("/ui/moon&sun&star/Sun3.png")),

    TERRARIA_SUN2(read("/ui/moon&sun&star/Sun2.png")),

    TERRARIA_MOON_SNOW(read("/ui/moon&sun&star/Moon_Snow.png")),

    TERRARIA_MOON_PUMPKIN(read("/ui/moon&sun&star/Moon_Pumpkin.png")),

    TERRARIA_SUN(read("/ui/moon&sun&star/Sun.png")),

    TERRARIA_MOON_2(read("/ui/moon&sun&star/Moon_2.png")),

    TERRARIA_MOON_1(read("/ui/moon&sun&star/Moon_1.png")),

    TERRARIA_MOON_0(read("/ui/moon&sun&star/Moon_0.png")),

    // #######################################################################
    // ---------------------------- 字体图标 ------------------------
    // #######################################################################
    FONT_0(read("/ui/font/font_0.png")),

    TERRARIA_CLOUDS(Lists.newArrayList(
            read("/ui/cloud/Cloud_4.png"),
            read("/ui/cloud/Cloud_5.png"),
            read("/ui/cloud/Cloud_6.png"),
            read("/ui/cloud/Cloud_7.png"),
            read("/ui/cloud/Cloud_8.png"),
            read("/ui/cloud/Cloud_9.png"),
            read("/ui/cloud/Cloud_10.png"),
            read("/ui/cloud/Cloud_11.png"),
            read("/ui/cloud/Cloud_12.png"),
            read("/ui/cloud/Cloud_13.png")
    )),

    ;

    private BufferedImage value;

    /**
     * 图片集合，一般用于需要随机取出使用的场景。比如云
     */
    private List<BufferedImage> images;
    
    ImageResources(BufferedImage value)
    {
        this.value = value;
    }

    ImageResources(List<BufferedImage> images) {
        this.images = images;
    }

    public BufferedImage getBufferedImage()
    {
        return this.value;
    }

    public List<BufferedImage> getBufferedImageList() {
        return this.images;
    }

    /**
     * 从集合中随机取一张图片
     */
    public BufferedImage getRandomBufferedImage() {
        return ToolBox.randomValue(this.images);
    }

    /**
     * 读取图片
     *
     * @param path 图片路径
     * @return Image对象
     */
    public static BufferedImage read(String path)
    {
        BufferedImage image =
                null;
        File imageFile = new File(WriteYourStory.RESOURCES.concat(path));
        try
        {
            image = ImageIO.read(imageFile);
        } catch (IOException e)
        {
            Log.error("cloud not load image for %s", e, imageFile.getPath());
        }
        return image;
    }

}
