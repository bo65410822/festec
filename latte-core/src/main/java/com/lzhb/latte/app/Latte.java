package com.lzhb.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * author: Lzhb
 * created on: 2018/8/13 15:40
 * description:
 */

public final class Latte {

    /**
     * 在项目application中调用初始化方法
     *
     * @param context 上下文对象 传application
     * @return 返回 Configurator 单利对象
     */
    public static Configurator init(Context context) {
        getLatteConfigs().put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return getConfigurator();
    }

    /**
     * @return 存放配置信息的HashMap
     */
    public static HashMap<Object, Object> getLatteConfigs() {
        return Configurator.getInstance().getLatteConfigs();
    }

    /**
     * @return 返回 Configurator 单利对象
     */
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    /**
     * 获取配置的信息
     * @param key 根据key获取
     * @param <T> 泛型
     * @return 返回泛型
     */
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    /**
     * 获取全局上下文对象
     * @return 返回全局上下文对象
     */
    public static Context getApplicationContext() {
        return Configurator.getInstance().getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }
}
