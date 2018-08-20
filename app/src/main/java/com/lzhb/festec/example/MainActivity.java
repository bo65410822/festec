package com.lzhb.festec.example;


import android.widget.Toast;

import com.lzhb.latte.activities.ProxyActivity;
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
