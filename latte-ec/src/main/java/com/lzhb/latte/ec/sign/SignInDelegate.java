package com.lzhb.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lzhb.latte.delegates.LatteDelegate;
import com.lzhb.latte.ec.R;
import com.lzhb.latte.ec.R2;
import com.lzhb.latte.net.RestClient;
import com.lzhb.latte.net.callback.IError;
import com.lzhb.latte.net.callback.ISuccess;

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

    private ISignListener mListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_login)
    void onClickSignIn() {
        if (checkForm()) {
            RestClient.builder()
                    .url("https://blog.csdn.net/c_24363/article/details/78200069")
                    .param("email", account)
                    .param("password", password)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            SignHandler.onSignIn(response, mListener);
                        }
                    })
                    .build()
                    .post();
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

    private String account, password;

    private boolean checkForm() {
        account = mAccount.getText().toString();
        password = mPassword.getText().toString();
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
