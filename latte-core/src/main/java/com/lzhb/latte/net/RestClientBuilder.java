package com.lzhb.latte.net;

import android.content.Context;

import com.lzhb.latte.net.callback.IError;
import com.lzhb.latte.net.callback.IFailure;
import com.lzhb.latte.net.callback.IRequest;
import com.lzhb.latte.net.callback.ISuccess;
import com.lzhb.latte.ui.loader.LoaderStyle;

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

public class RestClientBuilder {

    private String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mRequest;
    private ISuccess mSuccess;
    private IFailure mFailure;
    private IError mError;
    private RequestBody mBody;
    private Context mContext;
    private LoaderStyle mLoaderStyle;
    private File mFile;
    private String mDownload_dir;
    private String mExtension;
    private String mName;

    RestClientBuilder() {

    }

    /**
     * 设置服务器地址url
     */
    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    /**
     * 设置请求参数 WeakHashMap类型
     */
    public final RestClientBuilder param(WeakHashMap<String, Object> params) {
        this.PARAMS.putAll(params);
        return this;
    }

    /**
     * 设置请求参数 （键 - 值）
     */
    public final RestClientBuilder param(String key, Object value) {
        this.PARAMS.put(key, value);
        return this;
    }

    /**
     * 设置文件
     */
    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    /**
     * 设置文件的路径
     */
    public final RestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownload_dir = dir;
        return this;
    }

    public final RestClientBuilder extentsion(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
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
        return new RestClient(mUrl, PARAMS, mDownload_dir, mExtension, mName, mRequest, mSuccess, mFailure, mError, mBody, mFile, mContext, mLoaderStyle);
    }
}
