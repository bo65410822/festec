package com.lzhb.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.lzhb.festec.R;
import com.lzhb.latte.delegates.LatteDelegate;
import com.lzhb.latte.net.RestClient;
import com.lzhb.latte.net.callback.IError;
import com.lzhb.latte.net.callback.IFailure;
import com.lzhb.latte.net.callback.ISuccess;

/**
 * author: Lzhb
 * created on: 2018/8/13 17:01
 * description:
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder().url("http://news.baidu.com/")
//                .param("", "")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                    }
                })
                .build()
                .get();


    }
}
