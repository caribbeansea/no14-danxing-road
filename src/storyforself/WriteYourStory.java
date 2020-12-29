package storyforself;

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
 * Creates on 2020/12/25.
 */

import javax.swing.*;
import java.awt.*;

/**
 * 开始编写你的故事
 *
 * @author tiansheng
 */
public class WriteYourStory extends JFrame
{

    public static int width = 868;
    public static int height = 772;

    public WriteYourStory() {
        super("单行路22号");
        setSize(width,height);

        Container panels = getContentPane();

        // --------------------------------------------
        // 加载地图
        panels.add(new StartMenu());
        // --------------------------------------------

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new WriteYourStory();
    }

}
