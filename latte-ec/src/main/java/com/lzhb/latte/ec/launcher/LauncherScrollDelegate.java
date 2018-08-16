package com.lzhb.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.lzhb.latte.delegates.LatteDelegate;
import com.lzhb.latte.ec.R;
import com.lzhb.latte.ui.launcher.LauncherHolderCreator;
import com.lzhb.latte.ui.launcher.ScrollLauncherTag;
import com.lzhb.latte.util.storage.LattePreference;

import java.util.ArrayList;

/**
 * author: Lzhb
 * created on: 2018/8/16 10:13
 * description:
 */

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener {
    private static final String TAG = LauncherScrollDelegate.class.getPackage().getName();
    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        mConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        //如果点击的是最后一个，再次打开APP就不会出现导航界面
        if (position == INTEGERS.size() - 1) {
            Log.i(TAG, "onItemClick: Click the last one!");
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), true);
        }
    }
}
