package com.example.liyuanlin20190102.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.liyuanlin20190102.R;
import com.example.liyuanlin20190102.adapter.HomeAdapter;
import com.example.liyuanlin20190102.contract.IHomeContract;
import com.example.liyuanlin20190102.entity.Home;
import com.example.liyuanlin20190102.net.OkhttpUtils;
import com.example.liyuanlin20190102.presenter.HomePresenter;
import com.google.gson.Gson;

public class ShowActivity extends AppCompatActivity implements IHomeContract.IHomeView {

    private GridView gv;
    private HomePresenter presenter;
    private HomeAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        gv = findViewById(R.id.gv);
        myAdapter = new HomeAdapter(this);
        presenter = new HomePresenter(this);
        presenter.home(null);
    }

    @Override
    public void onFailUre(String msg) {

    }

    @Override
    public void onSuccess(String result) {
        final Home home = new Gson().fromJson(result, Home.class);
        myAdapter.setList(home.getData().getTuijian().getList());
        gv.setAdapter(myAdapter);
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                home.getData().getTuijian().getList().remove(position);
                myAdapter.notifyDataSetChanged();
                Toast.makeText(ShowActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Home.Data.TuiJian.Tui tui = home.getData().getTuijian().getList().get(position);
                int pid = tui.getPid();
                Intent intent = new Intent(ShowActivity.this, ProductActivity.class);
                intent.putExtra("pid",pid+"");
                startActivity(intent);
            }
        });
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
