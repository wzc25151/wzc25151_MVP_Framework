package com.sousouhardware.http;

import com.sousouhardware.config.ApiConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by wangxiangbo on 2016/7/14.
 */
public class ToInvalidCode extends BaseToDo {
    private final String url = ApiConfig.USER_BASE_URL + ApiConfig.INVALIDCODE;
    private String phone;
    private String code;
    private StringCallback callback;


    public ToInvalidCode(String phone, String code, StringCallback callback) {
        this.phone = phone;
        this.code = code;
        this.callback = callback;
    }
@Override
    public void submit() {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("phone", phone)
                .addParams("code", code)
                .build()
                .execute(callback);
    }
}
