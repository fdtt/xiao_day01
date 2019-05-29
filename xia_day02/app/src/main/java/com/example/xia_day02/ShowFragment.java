package com.example.xia_day02;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xia_day02.Presenter.presenter;
import com.example.xia_day02.View.Iview;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment implements Iview {


    private View view;
    private RecyclerView mRv;
    private int page=0;
    private List<User> list;
    private MyAdapter myAdapter;

    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_show, container, false);
        initView(inflate);
        mvp();
        return inflate;
    }

    private void mvp() {
        presenter presenter = new presenter(this);
        presenter.wan(page);
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        list = new ArrayList<>();
        myAdapter = new MyAdapter(getContext(), list);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRv.setAdapter(myAdapter);
        myAdapter.setOnClick(new MyAdapter.OnClick() {
            @Override
            public void OnClick(int position) {
                User user = list.get(position);
                Intent intent = new Intent(getContext(), XiangActivity.class);
                intent.putExtra("link", user.getLink());
                startActivity(intent);

            }
        });
        myAdapter.setOnLongClick(new MyAdapter.OnLongClick() {
            @Override
            public void OnLongClick(int position) {
                User user = list.get(position);
                Mydao.insert(user);
                Toast.makeText(getContext(), "已喜欢", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void sessend(final User user) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.add(user);
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
