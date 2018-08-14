package com.lzhb.festec;

import android.app.Application;

import com.lzhb.latte.app.Latte;

/**
 * author: Lzhb
 * created on: 2018/8/13 16:10
 * description:
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("https://www.baidu.com/")
                .configure();
    }
}
