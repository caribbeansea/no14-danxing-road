package com.opengl;

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
 * Creates on 2021/1/11.
 */

import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

/**
 * @author tiansheng
 */
public class HelloOpengl {

    public static void main(String[] args) {

        HelloOpenglLis test = new HelloOpenglLis();

        JFrame jf = new JFrame();
        GLCanvas canvas = new GLCanvas();

        jf.setSize(500,500);
        canvas.setSize(500,500);

        canvas.addGLEventListener(test);

        jf.getContentPane().add(canvas);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


}
