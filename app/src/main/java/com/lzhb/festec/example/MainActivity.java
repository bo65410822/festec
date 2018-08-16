package com.lzhb.festec.example;


import com.lzhb.latte.activities.ProxyActivity;
import com.lzhb.latte.delegates.LatteDelegate;
import com.lzhb.latte.ec.launcher.LauncherDelegate;
import com.lzhb.latte.ec.launcher.LauncherScrollDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
    }
}
