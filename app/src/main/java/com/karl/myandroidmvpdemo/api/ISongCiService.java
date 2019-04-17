package com.karl.myandroidmvpdemo.api;



import com.karl.myandroidmvpdemo.bean.SongCiResponseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ISongCiService {

    /**
     * 获取宋词
     *
     * @param page  第几页
     * @param count 数量
     * @return
     */
    @GET("/getSongPoetry")
    Observable<SongCiResponseBean> getSongCi(@Query("page") int page, @Query("count") int count);
}
