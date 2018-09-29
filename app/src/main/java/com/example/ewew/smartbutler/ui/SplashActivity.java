package com.example.ewew.smartbutler.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;

import com.example.ewew.smartbutler.MainActivity;
import com.example.ewew.smartbutler.R;
import com.example.ewew.smartbutler.util.ShareUtils;
import com.example.ewew.smartbutler.util.StaticClass;

//闪屏页
public class SplashActivity extends AppCompatActivity {

    private TextView tv_splash;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:
                    if (isFirst()){
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };

    private boolean isFirst() {
        boolean isFIrst=ShareUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST,true);
        if (isFIrst){
            ShareUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST,false);
            return true;
        }else {
            return false;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    //初始化
    private void initView(){

        //延时2000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);

        tv_splash=(TextView)findViewById(R.id.tv_splash);

        //自定义字体Typeface
        //必须新建Folder assets，将字体存在其中
        Typeface fonttype=Typeface.createFromAsset(getAssets(),"Mali-BoldItalic.ttf");
        tv_splash.setTypeface(fonttype);
    }

    //禁止返回键
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
