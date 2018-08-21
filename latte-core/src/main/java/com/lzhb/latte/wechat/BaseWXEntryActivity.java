package com.lzhb.latte.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzhb.latte.net.RestClient;
import com.lzhb.latte.net.callback.ISuccess;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

/**
 * author: Lzhb
 * created on: 2018/8/21 15:36
 * description:
 */

public abstract class BaseWXEntryActivity extends BaseWXActivity {
    //用户登陆成功后回调
    protected abstract void onSignInSuccess(String userInfo);

    //微信发送请求到第三方应用后回调
    @Override
    public void onReq(BaseReq baseReq) {
    }

    //第三方应用发送到微信请求后回调
    @Override
    public void onResp(BaseResp baseResp) {
        final String code = ((SendAuth.Resp) baseResp).code;
        final StringBuilder authUrl = new StringBuilder();
        authUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=")
                .append(LatteWeChat.APP_ID)
                .append("&secret=")
                .append(LatteWeChat.APP_SECRET)
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code");

        getAuth(authUrl.toString());
    }

    private void getAuth(String authUrl) {
        RestClient.builder().url(authUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject authObj = JSON.parseObject(response);
                        final String accessToken = authObj.getString("access_token");
                        final String openId = authObj.getString("openid");
                        final StringBuilder userInfoUrl = new StringBuilder();
                        userInfoUrl.append("https://api.weixin.qq.com/sns/userinfo?access_token=")
                                .append(accessToken)
                                .append("&openid=")
                                .append(openId)
                                .append("@lang=zh_CN");

                        getUserInfo(userInfoUrl.toString());

                    }
                }).build().get();
    }

    private void getUserInfo(String userInfoUrl) {
        RestClient.builder().url(userInfoUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        onSignInSuccess(response);
                    }
                }).build().get();
    }
}
