package com.lzhb.latte.app;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * author: Lzhb
 * created on: 2018/8/13 15:42
 * description:
 */

public class Configurator {

    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    /**
     * @return 获取单利
     */
    static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * @return 返回配置信息的HashMap 只能在同一包下调用
     */
    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    private Configurator() {
        //默认没有完成配置
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 在初始化配置时候调用该方法，否则会抛出异常
     */
    public final void configure() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    /**
     * 配置服务器的host
     *
     * @param host 域名
     * @return
     */
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST.name(), host);
        return this;
    }

    /**
     * 添加一个拦截器
     *
     * @param interceptor 拦截器
     * @return
     */
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    /**
     * 添加拦截器的list集合
     *
     * @param interceptors 拦截器的list
     * @return
     */
    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withWeChatAPPId(String appId) {
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configurator withWeChatAPPSecret(String appSecret) {
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET, appSecret);
        return this;
    }

    public final Configurator withActivity(Activity activity) {
        LATTE_CONFIGS.put(ConfigKeys.AACTIVITY, activity);
        return this;
    }

    /**
     * 检查配置是否完成
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    /**
     * 配置信息
     *
     * @param key 根据key获取
     * @param <T> 泛型
     * @return 返回泛型
     */
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key);
    }
}
