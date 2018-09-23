package com.example.ewew.smartbutler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ewew.smartbutler.fragment.BulterFragment;
import com.example.ewew.smartbutler.fragment.GirlfFragment;
import com.example.ewew.smartbutler.fragment.UserFragment;
import com.example.ewew.smartbutler.fragment.WechatFragment;
import com.example.ewew.smartbutler.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TabLayout
    private TabLayout mTabLayout;
    //ViewPager
    private ViewPager mViewPager;
    //Title
    private List<String>mTitlle;
    //Fragment
    private List<Fragment>mFragment;

    private FloatingActionButton fab_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去掉阴影
        getSupportActionBar().setElevation(0);
        initData();
        initView();
    }

    //初始化数据
    private void initData(){
        mTitlle=new ArrayList<>();
        mTitlle.add("服务管家");
        mTitlle.add("微信精选");
        mTitlle.add("美女社区");
        mTitlle.add("个人中心");

        mFragment=new ArrayList<>();
        mFragment.add(new BulterFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlfFragment());
        mFragment.add(new UserFragment());


    }
//初始化
    @SuppressLint("RestrictedApi")
    private void  initView(){
        fab_setting=findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);
    mTabLayout=(TabLayout)findViewById(R.id.mTabLayout);
    mViewPager=(ViewPager)findViewById(R.id.mViewpager);
//默认隐藏
        fab_setting.setVisibility(View.GONE);
    //滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }


            @SuppressLint("RestrictedApi")
            @Override
            public void onPageSelected(int position) {
                Log.i("TAG","position:"+position);
                if (position==0){
                    fab_setting.setVisibility(View.GONE);
                }
                else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int i) {
                return mFragment.get(i);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return  mTitlle.get(position);
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }
}
