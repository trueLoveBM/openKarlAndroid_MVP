package com.karl.openkarlandroid_mvp.progress;

import com.karl.openkarlandroid_mvp.utils.ExceptionHandle;
import com.karl.openkarlandroid_mvp.utils.ExceptionHandle.ResponeThrowable;


public interface ObserverResponseListener<T> {

    /**
     * 响应成功
     *
     * @param t
     */
    void onNext(T t);


    /**
     * 响应失败
     *
     * @param e
     */
    void onError(ResponeThrowable e);

}
