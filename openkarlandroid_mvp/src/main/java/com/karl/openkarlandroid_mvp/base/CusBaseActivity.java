package com.karl.openkarlandroid_mvp.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.karl.openkarlandroid_mvp.mvp.IMVPBaseView;
import com.karl.openkarlandroid_mvp.mvp.MVPBasePresenter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * 无法使用MVPBaseActivity，因为MVPBaseActivity继承自AppCompatActivity
 * 这里要使用RXJava，必须继承自RxAppCompatActivity
 * 所以拷贝MVPBaseActivity至此，并修改基类
 * 并添加ButterKnife初始化内容
 *
 * @param <V>
 * @param <T>
 */
public abstract class CusBaseActivity<V extends IMVPBaseView, T extends MVPBasePresenter<V>> extends RxAppCompatActivity {
    private T mPresenter;
    LocalBroadcastManager localBroadcastManager;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //BUtterKnife绑定
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        mPresenter.attachContext(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.detachContext();
            mPresenter = null;
        }


        if (receiver != null) {
            localBroadcastManager.unregisterReceiver(receiver);
            receiver = null;
        }
    }

    public T getPresenter() {
        return mPresenter;
    }

    /**
     * 创建presenter对象
     *
     * @return
     */
    protected abstract T createPresenter();

    //由子类指定具体类型
    public abstract int getLayoutId();

}
