package com.karl.myandroidmvpdemo.model;

import android.content.Context;

import com.karl.myandroidmvpdemo.api.Api;
import com.karl.myandroidmvpdemo.bean.SongCiResponseBean;
import com.karl.openkarlandroid_mvp.base.CusBaseModel;
import com.karl.openkarlandroid_mvp.progress.ObserverResponseListener;

import javax.xml.transform.Transformer;

import io.reactivex.ObservableTransformer;

public class SongCiModel<T> extends CusBaseModel {


    public void getSongCi(Context context, int page, int count, boolean isDialog, boolean cancelable, ObservableTransformer<T, T> transformer, ObserverResponseListener<SongCiResponseBean> listener) {
        subscribe(context, Api.getSongCiService().getSongCi(page, count), listener, transformer, isDialog, cancelable);
    }

}
