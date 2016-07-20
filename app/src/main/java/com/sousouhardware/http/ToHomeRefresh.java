package com.sousouhardware.http;

import com.sousouhardware.config.ApiConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by wangxiangbo on 2016/7/14.
 */
public class ToHomeRefresh extends BaseToDo {
    private final String url = ApiConfig.BASE_URL + ApiConfig.MOBILE_HOME_PRODUCTS_LIST;
    private String regionName;
    private StringCallback callback;


    public ToHomeRefresh(String regionName, StringCallback callback) {
        this.regionName = regionName;
        this.callback = callback;
    }
@Override
    public void submit() {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("regionName", regionName)
                .build()
                .execute(callback);
    }
}
