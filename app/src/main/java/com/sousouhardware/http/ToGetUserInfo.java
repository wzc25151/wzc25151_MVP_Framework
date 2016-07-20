package com.sousouhardware.http;

import com.sousouhardware.config.ApiConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by wangxiangbo on 2016/7/14.
 */
public class ToGetUserInfo extends BaseToDo {
    private final String url = ApiConfig.BASE_URL_3 + ApiConfig.GETMEINFO;
    private String token;
    private StringCallback callback;


    public ToGetUserInfo(String token, StringCallback callback) {
        this.token = token;
        this.callback = callback;
    }

    @Override
    public void submit() {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("token", token)
                .build()
                .execute(callback);
    }
}
