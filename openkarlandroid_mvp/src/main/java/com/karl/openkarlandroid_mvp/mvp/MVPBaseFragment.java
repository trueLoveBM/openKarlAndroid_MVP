package com.karl.openkarlandroid_mvp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class MVPBaseFragment<V extends IMVPBaseView, T extends MVPBasePresenter<V>> extends Fragment {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        mPresenter.attachContext(getContext());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.detachContext();
        }
    }

    /**
     * 抽象方法，创建Presenter对象
     *
     * @return
     */
    protected abstract T createPresenter();
}
