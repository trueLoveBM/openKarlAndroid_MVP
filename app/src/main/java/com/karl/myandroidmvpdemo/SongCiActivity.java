package com.karl.myandroidmvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.karl.myandroidmvpdemo.adapter.SongCiAdapter;
import com.karl.myandroidmvpdemo.bean.SongCiBean;
import com.karl.myandroidmvpdemo.contract.ISongCiContract;
import com.karl.myandroidmvpdemo.presenter.SongCiPresenter;
import com.karl.openandroid.widget.RecycleViewDivider;
import com.karl.openkarlandroid_mvp.base.CusBaseActivity;
import com.karl.openkarlandroid_mvp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.ObservableTransformer;

public class SongCiActivity extends CusBaseActivity<ISongCiContract.View, ISongCiContract.Presenter> implements ISongCiContract.View {


    RecyclerView recyclerView;
    List<SongCiBean> datas;
    SongCiAdapter SongCiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView=findViewById(R.id.rvTest);
        datas=new ArrayList<>();
        SongCiAdapter=new SongCiAdapter(datas);
        recyclerView.setAdapter(SongCiAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));

        getPresenter().loadSongCiList(1, 20, true, false);
    }

    @Override
    protected ISongCiContract.Presenter createPresenter() {
        return new SongCiPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_song_ci;
    }

    @Override
    public void getSongCiListSuccess(List<SongCiBean> list) {
        datas.clear();
        datas.addAll(list);
        SongCiAdapter.notifyDataSetChanged();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void showFailedMsg(String msg) {
        ToastUtil.showLongToast(msg);
    }


}
