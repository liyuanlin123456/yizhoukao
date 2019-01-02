package com.example.liyuanlin20190102.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liyuanlin20190102.R;
import com.example.liyuanlin20190102.entity.Home;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends BaseAdapter {
    private Context context;
    private List<Home.Data.TuiJian.Tui> list;

    public HomeAdapter(Context context) {
        this.context = context;
        this.list=new ArrayList<>();
    }

    public void setList(List<Home.Data.TuiJian.Tui> list) {
        if (list!=null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Home.Data.TuiJian.Tui getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.linear,parent,false);
            viewHolder=new ViewHolder(convertView);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bindView(getItem(position));
        return convertView;
    }

    class ViewHolder{
        ImageView image;
        TextView title;
        TextView price;

        public ViewHolder(View itemView) {
            this.image = itemView.findViewById(R.id.image);
            this.title = itemView.findViewById(R.id.title);
            this.price = itemView.findViewById(R.id.price);
            itemView.setTag(this);
        }
        public void bindView(Home.Data.TuiJian.Tui tui){
            for (int i=0;i<list.size();i++){
                String[] split = list.get(i).getImages().split("!");
                Glide.with(context).load(split[0]).into(this.image);
            }
            this.title.setText(tui.getTitle());
            this.price.setText(tui.getPrice()+"");
        }
    }
}
