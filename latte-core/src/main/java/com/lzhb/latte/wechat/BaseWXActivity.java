package com.lzhb.latte.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * author: Lzhb
 * created on: 2018/8/21 15:33
 * description:
 */

public abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须写在onCreate中
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(),this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(),this);
    }
}
