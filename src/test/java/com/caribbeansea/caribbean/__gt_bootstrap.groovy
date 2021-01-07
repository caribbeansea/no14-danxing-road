package com.caribbeansea.caribbean

import com.caribbeansea.caribbean.engine.bootstrap.__bootstrap

class __gt_bootstrap extends __bootstrap {

    @Override
    void init() {
        panel(new __gt_panel(size()))
        size(1000, 1000)
    }

    static void main(String[] args) {
        new __gt_bootstrap()
    }

}
