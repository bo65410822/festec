package com.lzhb.festec.example;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.lzhb.latte.activities.ProxyActivity;
import com.lzhb.latte.app.Latte;
import com.lzhb.latte.delegates.LatteDelegate;
import com.lzhb.latte.ec.launcher.LauncherDelegate;
import com.lzhb.latte.ec.sign.ISignListener;
import com.lzhb.latte.ec.sign.SignInDelegate;
import com.lzhb.latte.ec.sign.SignUpDelegate;
import com.lzhb.latte.ui.launcher.ILauncherListener;
import com.lzhb.latte.ui.launcher.OnLauncherFinishTag;

public class MainActivity extends ProxyActivity implements
        ISignListener, ILauncherListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "用户登陆了", Toast.LENGTH_SHORT).show();
                startWithPop(new ExampleDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "用户没登陆", Toast.LENGTH_SHORT).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
