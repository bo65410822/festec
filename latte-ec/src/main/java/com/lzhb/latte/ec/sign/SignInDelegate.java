package com.lzhb.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Toast;

import com.lzhb.latte.delegates.LatteDelegate;
import com.lzhb.latte.ec.R;
import com.lzhb.latte.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: Lzhb
 * created on: 2018/8/16 15:11
 * description:
 */

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_in_account)
    TextInputEditText mAccount = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    @OnClick(R2.id.btn_login)
    void onClickSignIn() {
        if (checkForm()) {

        }
    }

    @OnClick(R2.id.sign_in_we_chat)
    void onClickWeChat() {
        Toast.makeText(getContext(), "微信登陆", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        start(new SignUpDelegate(), SINGLETASK);
    }

    private boolean checkForm() {
        final String account = mAccount.getText().toString();
        final String password = mPassword.getText().toString();
        boolean isPass = true;
        if (account.isEmpty()) {
            mAccount.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mAccount.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请输入至少6位密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_in_sigin;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
