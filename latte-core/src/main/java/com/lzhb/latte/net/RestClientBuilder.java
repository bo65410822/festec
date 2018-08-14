package com.lzhb.latte.net;

import android.content.Context;

import com.lzhb.latte.net.callback.IError;
import com.lzhb.latte.net.callback.IFailure;
import com.lzhb.latte.net.callback.IRequest;
import com.lzhb.latte.net.callback.ISuccess;
import com.lzhb.latte.ui.LatteLoader;
import com.lzhb.latte.ui.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

/**
 * author: Lzhb
 * created on: 2018/8/14 9:13
 * description:
 */

public class RestClientBuilder {

    private String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mRequest;
    private ISuccess mSuccess;
    private IFailure mFailure;
    private IError mError;
    private ResponseBody mBody;
    private Context mContext;
    private LoaderStyle mLoaderStyle;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder param(WeakHashMap<String, Object> params) {
        this.PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder param(String key, Object value) {

        this.PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = ResponseBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest request) {
        this.mRequest = request;
        return this;
    }

    public final RestClientBuilder success(ISuccess success) {
        this.mSuccess = success;
        return this;
    }

    public final RestClientBuilder failure(IFailure failure) {
        this.mFailure = failure;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.mError = error;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mFailure, mError, mBody, mContext, mLoaderStyle);
    }

}
