package com.caribbeansea.caribbean

import com.caribbeansea.caribbean.engine.sprites.__sprites

import javax.imageio.ImageIO

class __gt_sprites {

    static String __sprite_image__ = "resources/game/linkformatted.png"

    static void main(String[] args) {

        new __sprites(ImageIO.read(new File(__sprite_image__)))

        println ""

    }

}
