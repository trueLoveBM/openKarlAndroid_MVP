package com.karl.openkarlandroid_mvp.mvp;

import android.content.Context;

import java.lang.ref.WeakReference;

public class MVPBasePresenter<T extends IMVPBaseView> {

    /**
     * View的弱引用
     */
    protected WeakReference<T> mViewRef;

    /**
     * 因为View可能是Context，也可能不是
     * 所以这里Context再加个弱引用
     */
    protected WeakReference<Context> mContext;

    /**
     * 持有view
     *
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }


    public void attachContext(Context context) {
        mContext = new WeakReference<>(context);
    }

    public void detachContext() {
        if (mContext != null) {
            mContext.clear();
            mContext = null;
        }
    }

    /**
     * 获取view的实例
     *
     * @return
     */
    public T getView() {
        return mViewRef.get();
    }

    public Context getContext() {
        return mContext.get();
    }


    public  void recycle(){

    }
}
