package com.sousouhardware.http;

import com.sousouhardware.config.ApiConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by wangxiangbo on 2016/7/14.
 */
public class ToLogin extends BaseToDo {
    private final String url = ApiConfig.BASE_URL_3 + ApiConfig.LOGIN;
    private String phone;
    private String password;
    private StringCallback callback;


    public ToLogin(String phone,String password, StringCallback callback) {
        this.phone = phone;
        this.password = password;
        this.callback = callback;
    }
@Override
    public void submit() {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("phone", phone)
                .addParams("password", password)
                .build()
                .execute(callback);
    }
}
