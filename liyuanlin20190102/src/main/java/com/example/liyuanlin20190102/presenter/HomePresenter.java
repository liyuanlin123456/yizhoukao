package com.example.liyuanlin20190102.presenter;

import com.example.liyuanlin20190102.contract.IHomeContract;
import com.example.liyuanlin20190102.model.HomeModel;
import com.example.liyuanlin20190102.net.RequestCallback;

import java.util.HashMap;

public class HomePresenter extends IHomeContract.HomePresenter {
    private HomeModel homeModel;
    private IHomeContract.IHomeView iHomeView;

    public HomePresenter(IHomeContract.IHomeView iHomeView) {
        this.homeModel=new HomeModel();
        this.iHomeView = iHomeView;
    }

    @Override
    public void home(HashMap<String, String> params) {
        if (homeModel!=null){
            homeModel.home(params, new RequestCallback() {
                @Override
                public void onFailUre(String msg) {
                    if (iHomeView!=null){
                        iHomeView.onFailUre(msg);
                    }
                }

                @Override
                public void onSuccess(String result) {
                    if (iHomeView!=null){
                        iHomeView.onSuccess(result);
                    }
                }

                @Override
                public void onSuccessMsg(String msg) {
                    if (iHomeView!=null){
                        iHomeView.onSuccessMsg(msg);
                    }
                }
            });
        }
    }

    @Override
    public void product(HashMap<String, String> params) {
        if (homeModel!=null){
            homeModel.product(params, new RequestCallback() {
                @Override
                public void onFailUre(String msg) {
                    if (iHomeView!=null){
                        iHomeView.onFailUre(msg);
                    }
                }

                @Override
                public void onSuccess(String result) {
                    if (iHomeView!=null){
                        iHomeView.onSuccess(result);
                    }
                }

                @Override
                public void onSuccessMsg(String msg) {
                    if (iHomeView!=null){
                        iHomeView.onSuccessMsg(msg);
                    }
                }
            });
        }
    }

    public void destroy(){
        if (iHomeView!=null){
            iHomeView=null;
        }
    }
}
