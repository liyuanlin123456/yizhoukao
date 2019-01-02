package com.example.liyuanlin20190102.net;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtils {
    private Handler handler=new Handler();
    private OkHttpClient okHttpClient;
    private static OkhttpUtils mInstance;

    public OkhttpUtils() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();

    }
    public void doPost(String apiUrl, HashMap<String,String> params, final OkhttpCallback okhttpCallback){
        FormBody.Builder formBody = new FormBody.Builder();
        Request request = new Request.Builder().url(apiUrl).post(formBody.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (okhttpCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            okhttpCallback.onFailUre("网络异常");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                int code = response.code();
                if (okhttpCallback!=null){
                    if (200==code){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                okhttpCallback.onSuccess(result);
                            }
                        });
                    }
                }
            }
        });
    }
    public void doPost1(String apiUrl, HashMap<String,String> params, final OkhttpCallback okhttpCallback){
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String,String> p:params.entrySet()){
            formBody.add(p.getKey(),p.getValue());
        }
        Request request = new Request.Builder().url(apiUrl).post(formBody.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (okhttpCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            okhttpCallback.onFailUre("网络异常");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                int code = response.code();
                if (okhttpCallback!=null){
                    if (200==code){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                okhttpCallback.onSuccess(result);
                            }
                        });
                    }
                }
            }
        });
    }

    public static OkhttpUtils getmInstance() {
        if (mInstance==null){
            synchronized (OkhttpUtils.class){
                if (mInstance==null){
                    mInstance=new OkhttpUtils();
                }
            }
        }
        return mInstance;
    }
    public void okHttpCancel(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
    }
}
