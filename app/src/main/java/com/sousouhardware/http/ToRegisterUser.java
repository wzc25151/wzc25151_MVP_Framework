package com.sousouhardware.http;

import com.sousouhardware.config.ApiConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by wangxiangbo on 2016/7/14.
 */
public class ToRegisterUser extends BaseToDo {
    private final String url = ApiConfig.USER_BASE_URL + ApiConfig.REGISTERUSER;
    private String phone;
    private String password;
    private String userytpe;
    private String refereePhone;
    private StringCallback callback;

    public final  static String USERYTYPE_D ="10";


    /**
     * @param phone
     * @param password
     * @param userytpe 10表示D用户
     * @param callback
     */
    public ToRegisterUser(String phone, String password,String userytpe,String refereePhone, StringCallback callback) {
        this.phone = phone;
        this.password = password;
        this.userytpe = userytpe;
        this.refereePhone = refereePhone;
        this.callback = callback;
    }
@Override
    public void submit() {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("phone", phone)
                .addParams("password", password)
                .addParams("userytpe", userytpe)
                .addParams("refereePhone", refereePhone)
                .build()
                .execute(callback);
    }
}
