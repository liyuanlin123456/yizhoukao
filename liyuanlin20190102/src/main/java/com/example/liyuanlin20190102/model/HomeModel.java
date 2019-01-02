package com.example.liyuanlin20190102.model;

import android.os.Handler;
import android.text.TextUtils;

import com.example.liyuanlin20190102.api.HomeApi;
import com.example.liyuanlin20190102.contract.IHomeContract;
import com.example.liyuanlin20190102.net.OkhttpCallback;
import com.example.liyuanlin20190102.net.OkhttpUtils;
import com.example.liyuanlin20190102.net.RequestCallback;

import java.util.HashMap;

public class HomeModel implements IHomeContract.IHomeModel {
    private Handler handler=new Handler();
    @Override
    public void home(HashMap<String, String> params, final RequestCallback requestCallback) {
        OkhttpUtils.getmInstance().doPost(HomeApi.HOME_SHOW, params, new OkhttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.onFailUre("网络异常，请稍后再试");
                        }
                    });
                }
            }

            @Override
            public void onSuccess(final String result) {
                if (!TextUtils.isEmpty(result)){
                    if (requestCallback!=null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                requestCallback.onSuccess(result);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void product(HashMap<String, String> params, final RequestCallback requestCallback) {
        OkhttpUtils.getmInstance().doPost1(HomeApi.PRODUCT_SHOW, params, new OkhttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.onFailUre("网络异常，请稍后再试");
                        }
                    });
                }
            }

            @Override
            public void onSuccess(final String result) {
                if (!TextUtils.isEmpty(result)){
                    if (requestCallback!=null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                requestCallback.onSuccess(result);
                            }
                        });
                    }
                }
            }
        });
    }
}
