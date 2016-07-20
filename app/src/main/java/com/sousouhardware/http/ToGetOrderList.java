package com.sousouhardware.http;

import com.sousouhardware.config.ApiConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by wangxiangbo on 2016/7/14.
 */
public class ToGetOrderList extends BaseToDo {
    private final String url = ApiConfig.BASE_URL_3 + ApiConfig.GETORDERLIST;
    private String token;
    private String type;
    private String page;
    private StringCallback callback;

    public static final String TYPE_ALL = "0";          //全部订单
    public static final String TYPE_UNPAY = "1"; //待付款
    public static final String TYPE_UNSEND = "2";    //待发货
    public static final String TYPE_UNRECEIVE = "3";    //待收获
    public static final String TYPE_CLOSE = "4";        //交易关闭
    public static final String TYPE_SUCCEED = "5";       //交易完成
    public static final String TYPE_UNEVALUATE = "6";//待评价
    public static final String TYPE_UNREFUND = "7";        //退款中


    public ToGetOrderList(String token, String type, String page, StringCallback callback) {
        this.token = token;
        this.type = type;
        this.page = page;
        this.callback = callback;
    }

    @Override
    public void submit() {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("token", token)
                .addParams("type", type)
                .addParams("page", page)
                .build()
                .execute(callback);
    }
}
