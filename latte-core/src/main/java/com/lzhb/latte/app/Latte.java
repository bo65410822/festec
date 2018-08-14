package com.lzhb.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * author: Lzhb
 * created on: 2018/8/13 15:40
 * description:
 */

public final class Latte {
    public static Configurator init(Context context) {
        getLatteConfigs().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static WeakHashMap<String, Object> getLatteConfigs() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication() {
        return (Context) Configurator.getInstance().getLatteConfigs().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
