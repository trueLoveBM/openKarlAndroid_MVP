package com.karl.openkarlandroid_mvp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class MVPBaseAcitivity<V extends IMVPBaseView,T extends MVPBasePresenter<V>> extends AppCompatActivity {

    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();
        mPresenter.attachView((V)this);
        mPresenter.attachContext(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null) {
            mPresenter.detachView();
            mPresenter.detachContext();
        }
    }

    public T getPresenter() {
        return mPresenter;
    }

    /**
     * 创建presenter对象
     * @return
     */
    protected abstract T createPresenter();
}
