package com.example.xia_day02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SqlActivity extends AppCompatActivity {

    private RecyclerView mXrv;
    private List<User> list;
    private Mydater mydater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        initView();
        initMore();
    }

    private void initMore() {
        List<User> show = Mydao.show();
        list.clear();
        list.addAll(show);
        mydater.notifyDataSetChanged();
    }

    private void initView() {
        mXrv = (RecyclerView) findViewById(R.id.xrv);
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        mydater = new Mydater(this, list);
        mXrv.setAdapter(mydater);

    }
}
