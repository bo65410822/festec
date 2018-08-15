package com.lzhb.latte.net.rx;

import android.content.Context;

import com.lzhb.latte.net.RestCreator;
import com.lzhb.latte.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * author: Lzhb
 * created on: 2018/8/14 9:13
 * description:
 */

public class RxRestClientBuilder {

    private String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private RequestBody mBody;
    private Context mContext;
    private LoaderStyle mLoaderStyle;
    private File mFile;

    RxRestClientBuilder() {

    }

    /**
     * 设置服务器地址url
     */
    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    /**
     * 设置请求参数 WeakHashMap类型
     */
    public final RxRestClientBuilder param(WeakHashMap<String, Object> params) {
        this.PARAMS.putAll(params);
        return this;
    }

    /**
     * 设置请求参数 （键 - 值）
     */
    public final RxRestClientBuilder param(String key, Object value) {
        this.PARAMS.put(key, value);
        return this;
    }

    /**
     * 设置文件
     */
    public final RxRestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    /**
     * 设置文件的路径
     */
    public final RxRestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RxRestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RxRestClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RxRestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }

    public final RxRestClient build() {
        return new RxRestClient(mUrl, PARAMS, mBody, mFile, mContext, mLoaderStyle);
    }
}
