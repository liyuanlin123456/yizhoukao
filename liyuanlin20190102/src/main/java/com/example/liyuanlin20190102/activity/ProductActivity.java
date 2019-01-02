package com.example.liyuanlin20190102.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liyuanlin20190102.R;
import com.example.liyuanlin20190102.contract.IHomeContract;
import com.example.liyuanlin20190102.entity.Product;
import com.example.liyuanlin20190102.net.OkhttpUtils;
import com.example.liyuanlin20190102.presenter.HomePresenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class ProductActivity extends AppCompatActivity implements IHomeContract.IHomeView {

    private ImageView image;
    private TextView title;
    private TextView price;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        presenter = new HomePresenter(this);
        HashMap<String,String> params=new HashMap<>();
        params.put("pid", pid);
        presenter.product(params);
    }

    @Override
    public void onFailUre(String msg) {

    }

    @Override
    public void onSuccess(String result) {
        Product product = new Gson().fromJson(result, Product.class);
        Product.Data data = product.getData();
        String[] split = data.getImages().split("!");
        Glide.with(this).load(split[0]).into(image);
        title.setText(data.getTitle());
        price.setText(data.getPrice()+"");
    }

    @Override
    public void onSuccessMsg(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
        OkhttpUtils.getmInstance().okHttpCancel();
    }
}
