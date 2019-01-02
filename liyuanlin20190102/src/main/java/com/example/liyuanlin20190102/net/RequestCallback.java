package com.example.liyuanlin20190102.net;

public interface RequestCallback {
    void onFailUre(String msg);
    void onSuccess(String result);
    void onSuccessMsg(String msg);
}
