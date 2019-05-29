package com.example.xia_day02;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {


    private View view;
    private ImageView mMeIv;
    /**
     * 长玲姐
     */
    private TextView mMeeTv;
    /**
     * 我的收藏
     */
    private TextView mLove;
    /**
     * 我的下载
     */
    private TextView mXia;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_me, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mMeIv = (ImageView) inflate.findViewById(R.id.me_iv);
        mMeeTv = (TextView) inflate.findViewById(R.id.mee_tv);
        mLove = (TextView) inflate.findViewById(R.id.love);
        mLove.setOnClickListener(this);
        mXia = (TextView) inflate.findViewById(R.id.xia);
        mXia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.love:
                startActivity(new Intent(getContext(),SqlActivity.class));
                break;
            case R.id.xia:
                startActivity(new Intent(getContext(),XiaActivity.class));
                break;
        }
    }
}
