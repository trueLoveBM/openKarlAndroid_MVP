package com.karl.myandroidmvpdemo.cusapp;

import android.app.Application;

import com.karl.openkarlandroid_mvp.MVPModule;

public class CusApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化MVP模块
        MVPModule.getInstance().init(this);
    }
}
