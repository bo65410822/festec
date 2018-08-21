package com.lzhb.latte.wechat;


import android.app.Activity;

import com.lzhb.latte.app.ConfigKeys;
import com.lzhb.latte.app.Latte;
import com.lzhb.latte.wechat.callbacks.IWeChatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * author: Lzhb
 * created on: 2018/8/21 15:17
 * description:
 */

public class LatteWeChat {
    public static final String APP_ID = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    public static final String APP_SECRET = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;

    private IWeChatSignInCallback mSignInCallback;

    private static final class Holder {
        private static final LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private LatteWeChat() {
        final Activity activity = Latte.getConfiguration(ConfigKeys.AACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }

    public LatteWeChat onSignSuccess(IWeChatSignInCallback signInCallback) {
        this.mSignInCallback = signInCallback;
        return this;
    }

    public IWeChatSignInCallback getSignInCallback() {
        return mSignInCallback;
    }
}
