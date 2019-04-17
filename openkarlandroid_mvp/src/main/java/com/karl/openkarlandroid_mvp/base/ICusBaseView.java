package com.karl.openkarlandroid_mvp.base;

import com.karl.openkarlandroid_mvp.mvp.IMVPBaseView;

import io.reactivex.ObservableTransformer;

public interface ICusBaseView extends IMVPBaseView {
    <T> ObservableTransformer<T, T> bindLifecycle();

    void showFailedMsg(String msg);
}
