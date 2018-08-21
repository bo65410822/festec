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
import com.lzhb.latte.net.rx.RxRestClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        rxTestRestClient();
    }

    private void testRestClient() {
        RestClient.builder().url("http://192.168.0.69:8080/index.jsp")
//                .param("", "")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
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

    private void rxTestRestClient() {
        final String url = "index.jsp";
        RxRestClient.builder()
                .url(url)
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
