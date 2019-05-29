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
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by 只想暴富 on 2019/5/28.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<User>list;
    private OnClick onClick;
    private OnLongClick onLongClick;
    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public void setOnLongClick(OnLongClick onLongClick) {
        this.onLongClick = onLongClick;
    }

    public MyAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_a, viewGroup, false);
            return  new one(inflate);
        }else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_b, viewGroup, false);
            return  new two(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final User user = list.get(i);
        int type = getItemViewType(i);
        if (type==0){
          one holderone = (one) viewHolder;
          holderone.ban.setImages(list).setImageLoader(new ImageLoader() {
              @Override
              public void displayImage(Context context, Object path, ImageView imageView) {
                  User usera= (User) path;
                  Glide.with(context).load(usera.getUrl()).into(imageView);
              }
          }).start();
        }else {
            two two= (MyAdapter.two) viewHolder;
            two.tv.setText(user.getDesc());
            Glide.with(context).load(user.getUrl()).into(two.iv);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClick!=null){
                    onClick.OnClick(i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onLongClick!=null){
                    onLongClick.OnLongClick(i);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class  one extends  RecyclerView.ViewHolder{
        Banner ban;
        public one(@NonNull View itemView) {
            super(itemView);
            ban = itemView.findViewById(R.id.ban);
        }
    }
    class  two extends  RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public two(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.rv_iv);
            tv=itemView.findViewById(R.id.rv_tv);
        }
    }
    public  interface  OnClick{
        void OnClick(int position);
    }
    public  interface  OnLongClick{
        void OnLongClick(int position);
    }
}
