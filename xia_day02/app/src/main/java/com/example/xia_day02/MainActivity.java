package com.example.xia_day02;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mTl;
    private ViewPager mVp;
    private TabLayout mTbl;
    /**
     * 设置
     */
    private TextView mMeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTl = (Toolbar) findViewById(R.id.tl);
        mTl.setTitle("资讯");
        mTl.setNavigationIcon(R.mipmap.back);
        setSupportActionBar(mTl);
        mTl.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mVp = (ViewPager) findViewById(R.id.vp);
        mTbl = (TabLayout) findViewById(R.id.tbl);
        final List<Fragment> list = new ArrayList<>();
        list.add(new ShowFragment());
        list.add(new MeFragment());
        mMeTv = (TextView) findViewById(R.id.me_tv);
        mMeTv.setOnClickListener(this);
        MyAdapter_fm myAdapter_fm = new MyAdapter_fm(getSupportFragmentManager(), list);
        mVp.setAdapter(myAdapter_fm);
        mTbl.setupWithViewPager(mVp);
        mTbl.getTabAt(0).setIcon(R.drawable.item_one).setText("资讯");
        mTbl.getTabAt(1).setIcon(R.drawable.item_two).setText("我的");
        mTbl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTl.setTitle(tab.getText());
                if (tab.getPosition() == 1) {
                    mMeTv.setVisibility(View.VISIBLE);
                }else {
                    mMeTv.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.me_tv:
                break;
        }
    }

    class MyAdapter_fm extends FragmentPagerAdapter {
        List<Fragment> list = new ArrayList<>();

        public MyAdapter_fm(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
