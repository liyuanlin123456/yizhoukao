package com.example.liyuanlin20190102.contract;

import com.example.liyuanlin20190102.net.RequestCallback;

import java.util.HashMap;

public interface IHomeContract {
    public abstract class HomePresenter{
        public abstract void home(HashMap<String,String> params);
        public abstract void product(HashMap<String,String> params);
    }
    interface IHomeModel{
        void home(HashMap<String,String> params, RequestCallback requestCallback);
        void product(HashMap<String,String> params,RequestCallback requestCallback);
    }
    interface IHomeView{
        void onFailUre(String msg);
        void onSuccess(String result);
        void onSuccessMsg(String msg);
    }
}
