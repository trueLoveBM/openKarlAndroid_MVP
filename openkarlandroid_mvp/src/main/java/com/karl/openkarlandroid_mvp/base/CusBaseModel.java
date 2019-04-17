package com.karl.openkarlandroid_mvp.base;

import android.content.Context;

import com.karl.openkarlandroid_mvp.mvp.MVPBaseModel;
import com.karl.openkarlandroid_mvp.progress.ObserverResponseListener;
import com.karl.openkarlandroid_mvp.progress.ProgressObserver;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class CusBaseModel<T> extends MVPBaseModel {

    /**
     * 封装线程管理和订阅的过程
     * flag  是否添加progressdialog
     */
    public void subscribe(Context context, final Observable observable, ObserverResponseListener<T> listener,
                          ObservableTransformer<T, T> transformer, boolean isDialog, boolean cancelable) {
        final Observer<T> observer = new ProgressObserver(context, listener, isDialog, cancelable);
        observable.compose(transformer)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void subscribe(Context context, final Observable observable, ObserverResponseListener<T> listener,
                          ObservableTransformer<T, T> transformer) {
        subscribe(context, observable, listener, transformer, true, true);
    }


    /**
     * 带自定义消息的提示框
     * @param context
     * @param observable
     * @param listener
     * @param transformer
     * @param isDialog
     * @param cancelable
     * @param msg
     */
    public void subscribe(Context context, final Observable observable, ObserverResponseListener<T> listener,
                          ObservableTransformer<T, T> transformer, boolean isDialog, boolean cancelable, String msg) {
        final Observer<T> observer = new ProgressObserver(context, msg, listener, isDialog, cancelable);
        observable.compose(transformer)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void subscribe(Context context, final Observable observable, ObserverResponseListener<T> listener,
                          ObservableTransformer<T, T> transformer, String msg) {
        subscribe(context, observable, listener, transformer, true, true, msg);
    }
}
