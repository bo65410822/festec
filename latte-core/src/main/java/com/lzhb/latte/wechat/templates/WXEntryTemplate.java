package com.lzhb.latte.wechat.templates;

import com.lzhb.latte.wechat.BaseWXEntryActivity;
import com.lzhb.latte.wechat.LatteWeChat;

/**
 * author: Lzhb
 * created on: 2018/8/21 11:12
 * description:
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
