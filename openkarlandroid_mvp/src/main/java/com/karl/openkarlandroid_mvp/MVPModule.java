package com.karl.openkarlandroid_mvp;


import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * MVP初始化
 * author Fan.Huang
 * eamil  940523199@qq.com
 * created 2019/4/17 15:02
 */
public class MVPModule {

    private  WeakReference<Context> contextWeakReference;


    private static class MVPModuleHolder {
        private static final MVPModule INSTANCE = new MVPModule();
    }

    private MVPModule() {
    }

    /**
     * 初始化MVP依赖库
     *
     * @param context
     * @return
     */
    public void init(Context context) {
        contextWeakReference = new WeakReference<>(context);
    }

    public Context getContext() {
        return contextWeakReference.get();
    }

    public static final MVPModule getInstance() {
        return MVPModuleHolder.INSTANCE;
    }
}
