package com.karl.openkarlandroid_mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karl.openkarlandroid_mvp.mvp.IMVPBaseView;
import com.karl.openkarlandroid_mvp.mvp.MVPBasePresenter;
import com.trello.rxlifecycle2.components.support.RxAppCompatDialogFragment;


public abstract class CusMVPBaseFragment<V extends IMVPBaseView, T extends MVPBasePresenter<V>> extends RxAppCompatDialogFragment {

    private String fragmentLabel;
    protected T mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        View v = inflater.inflate(layoutId, container, false);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        mPresenter.attachContext(getContext());
        return v;
    }


    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.detachContext();
        }
        super.onDestroy();
    }

    /**
     * 抽象方法，创建Presenter对象
     *
     * @return
     */
    protected abstract T createPresenter();

    protected abstract int getLayoutId();

    public T getPresenter() {
        return mPresenter;
    }

    public String getFragmentLabel() {
        return fragmentLabel;
    }

    public void setFragmentLabel(String fragmentLabel) {
        this.fragmentLabel = fragmentLabel;
    }
}
