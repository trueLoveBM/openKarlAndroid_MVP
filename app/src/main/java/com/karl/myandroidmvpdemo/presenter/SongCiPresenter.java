package com.karl.myandroidmvpdemo.presenter;

import com.karl.myandroidmvpdemo.api.Api;
import com.karl.myandroidmvpdemo.bean.SongCiResponseBean;
import com.karl.myandroidmvpdemo.contract.ISongCiContract;
import com.karl.myandroidmvpdemo.model.SongCiModel;
import com.karl.openkarlandroid_mvp.progress.ObserverResponseListener;
import com.karl.openkarlandroid_mvp.utils.ExceptionHandle;

public class SongCiPresenter extends ISongCiContract.Presenter {

    SongCiModel model;

    public SongCiPresenter() {
        this.model = new SongCiModel();
    }

    @Override
    public void loadSongCiList(int page, int count, boolean isDialog, boolean cancel) {
        if (getContext() != null) {
            model.getSongCi(getContext(), page, count, isDialog, cancel, getView().bindLifecycle(), new ObserverResponseListener<SongCiResponseBean>() {
                @Override
                public void onNext(SongCiResponseBean responseBean) {
                    if (getView() != null) {
                        if (responseBean.getCode() == Api.CODE_OK) {
                            getView().getSongCiListSuccess(responseBean.getResult());
                        } else {
                            getView().showFailedMsg(responseBean.getMessage());
                        }
                    }
                }

                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {
                    if (getView() != null) {
                        getView().showFailedMsg(e.getMessage());
                    }
                }
            });
        }
    }
}
