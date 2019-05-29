package com.example.xia_day02;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 只想暴富 on 2019/5/28.
 */

public class Mydater extends RecyclerView.Adapter<Mydater.two> {
    private Context context;
    private List<User>list=new ArrayList<>();

    public Mydater(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Mydater.two onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_b, viewGroup, false);
        return  new two(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Mydater.two two, int i) {
        User user = list.get(i);

        two.tv.setText(user.getDesc());
        Glide.with(context).load(user.getUrl()).into(two.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull two two, int i) {
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
    class  two extends  RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public two(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.rv_iv);
            tv=itemView.findViewById(R.id.rv_tv);
        }
    }
}
