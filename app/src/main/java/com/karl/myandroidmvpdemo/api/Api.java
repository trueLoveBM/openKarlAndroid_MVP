package com.karl.myandroidmvpdemo.api;

import com.karl.openkarlandroid_mvp.base.BaseApi;

public class Api {

    /**
     * 你的服务器地址
     */
    private static final  String baseUrl="https://api.apiopen.top/";

    public static final int CODE_OK=200;

    private volatile static ISongCiService songCiService;

    public static ISongCiService getSongCiService() {
        if (songCiService == null) {
            synchronized (Api.class) {
                if (songCiService == null) {
                    new Api();
                }
            }
        }
        return songCiService;
    }


    private Api() {
        BaseApi baseApi = new BaseApi();
        songCiService = baseApi.getRetrofit(baseUrl).create(ISongCiService.class);
    }


}
