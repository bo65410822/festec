package com.lzhb.latte.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.lzhb.latte.app.Latte;

/**
 * author: Lzhb
 * created on: 2018/8/14 13:10
 * description:
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
