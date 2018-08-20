package com.lzhb.festec;

import android.app.Application;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.lzhb.latte.app.Latte;
import com.lzhb.latte.ec.database.DatabaseManager;
import com.lzhb.latte.net.interceptors.DebugInterceptor;

/**
 * author: Lzhb
 * created on: 2018/8/13 16:10
 * description:
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //测试    http://192.168.0.69:8080/index.jsp
        Latte.init(this)
                .withApiHost("http://192.168.0.69:8080/")
//                .withInterceptor(new DebugInterceptor("index.jsp", R.raw.test))
                .configure()
        ;
        initStetho();
        DatabaseManager.getInstance().init(this);
    }

    private void initStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }
}
