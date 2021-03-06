package com.lzhb.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.lzhb.latte.delegates.LatteDelegate;
import com.lzhb.latte.ec.R;
import com.lzhb.latte.ec.R2;
import com.lzhb.latte.net.RestClient;
import com.lzhb.latte.net.callback.IError;
import com.lzhb.latte.net.callback.ISuccess;
import com.lzhb.latte.util.LatteUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: Lzhb
 * created on: 2018/8/16 13:32
 * description:
 */

public class SignUpDelegate extends LatteDelegate {

    private static final String TAG = SignUpDelegate.class.getPackage().getName();

    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_confirm)
    TextInputEditText mConfirm = null;

    private ISignListener mListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_register)
    void onClickSignUp() {
        if (checkForm()) {
            RestClient.builder()
                    .url("https://blog.csdn.net/c_24363/article/details/78200069")
                    .param("name", name)
                    .param("email", email)
                    .param("phone", phone)
                    .param("password", password)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            Log.i(TAG, "onSuccess: response = " + response);
                            SignHandler.onSignUp(response, mListener);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLink() {
        start(new SignInDelegate(), SINGLETASK);
    }

    private String name, email, phone, password, confirm;

    private boolean checkForm() {
        name = mName.getText().toString();
        email = mEmail.getText().toString();
        phone = mPhone.getText().toString();
        password = mPassword.getText().toString();
        confirm = mConfirm.getText().toString();
        boolean isPass = true;
        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }
        if (phone.isEmpty() || LatteUtil.isMobileNO(phone)) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请输入至少6位密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        if (confirm.isEmpty() || confirm.length() < 6 || !(confirm.equals(password))) {
            mConfirm.setError("两次输入的密码不一致");
            isPass = false;
        } else {
            mConfirm.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_up_sign;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
