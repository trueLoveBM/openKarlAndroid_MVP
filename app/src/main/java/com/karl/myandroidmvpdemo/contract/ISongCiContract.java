package com.karl.myandroidmvpdemo.contract;

import com.karl.myandroidmvpdemo.bean.SongCiBean;
import com.karl.openkarlandroid_mvp.base.ICusBaseView;
import com.karl.openkarlandroid_mvp.mvp.MVPBasePresenter;

import java.util.List;

public interface ISongCiContract {

    interface View extends ICusBaseView{

        void getSongCiListSuccess(List<SongCiBean> list);
    }

    public abstract class Presenter extends MVPBasePresenter<ISongCiContract.View>{

        /**
         * 加载宋词
         */
       public abstract void loadSongCiList(int page,int count,boolean isDialog,boolean cancel);
    }

}
