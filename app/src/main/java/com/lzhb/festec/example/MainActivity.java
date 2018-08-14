package com.lzhb.festec.example;


import com.lzhb.latte.activities.ProxyActivity;
import com.lzhb.latte.delegates.LatteDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
