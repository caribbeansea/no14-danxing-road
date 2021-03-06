package modules.resources;

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

import engine.utils.Lists;
import engine.utils.ToolBox;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author tiansheng
 */
public enum ImageResources
{


    TERRARIA_BACKGROUND_61(ToolBox.read_buffimg_in_resources("/ui/Background_61.png")),

    TERRARIA_BACKGROUND_25(ToolBox.read_buffimg_in_resources("/ui/Background_25.png")),

    TERRARIA_BACKGROUND_178(ToolBox.read_buffimg_in_resources("/ui/Background_178.png")),

    // #######################################################################
    // ----------------------------  太阳和月亮以及星星 ------------------------
    // #######################################################################

    TERRARIA_STAR_1(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Star_1.png")),

    TERRARIA_STAR_0(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Star_0.png")),

    TERRARIA_STAR_2(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Star_2.png")),

    TERRARIA_STAR_3(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Star_3.png")),

    TERRARIA_STAR_4(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Star_4.png")),

    TERRARIA_SUN3(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Sun3.png")),

    TERRARIA_SUN2(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Sun2.png")),

    TERRARIA_MOON_SNOW(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Moon_Snow.png")),

    TERRARIA_MOON_PUMPKIN(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Moon_Pumpkin.png")),

    TERRARIA_SUN(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Sun.png")),

    TERRARIA_MOON_2(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Moon_2.png")),

    TERRARIA_MOON_1(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Moon_1.png")),

    TERRARIA_MOON_0(ToolBox.read_buffimg_in_resources("/ui/moon&sun&star/Moon_0.png")),

    // #######################################################################
    // ---------------------------- 字体图标 ------------------------
    // #######################################################################
    FONT_0(ToolBox.read_buffimg_in_resources("/ui/font/font_0.png")),
    FONT_1(ToolBox.read_buffimg_in_resources("/ui/font/font_1.png")),

    TERRARIA_CLOUDS(Lists.newArrayList(
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_4.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_5.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_6.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_7.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_8.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_9.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_10.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_11.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_12.png"),
            ToolBox.read_buffimg_in_resources("/ui/cloud/Cloud_13.png")
    )),

    LINK_FORMATTED(ToolBox.read_buffimg_in_resources("/game/linkformatted.png"))

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

}
