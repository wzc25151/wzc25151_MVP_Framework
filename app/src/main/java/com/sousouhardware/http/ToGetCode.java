package com.sousouhardware.http;

import com.sousouhardware.config.ApiConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by wangxiangbo on 2016/7/14.
 */
public class ToGetCode extends BaseToDo {
    private final String url = ApiConfig.USER_BASE_URL + ApiConfig.SENDCODE;
    private String phone;
    private String type;
    private StringCallback callback;

    public final static String CODETYPE_REGISTER = "1";
    public final static String CODETYPE_FORGOT_PASSWORD = "2";

    /**
     * @param type 1是注册账号,2是找回密码
     *
     */
    public ToGetCode(String phone, String type, StringCallback callback) {
        this.phone = phone;
        this.type = type;
        this.callback = callback;
    }
@Override
    public void submit() {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("phone", phone)
                .addParams("type", type)
                .build()
                .execute(callback);
    }
}
