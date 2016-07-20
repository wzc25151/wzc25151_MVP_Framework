package com.sousouhardware.view.cart;

import android.text.TextUtils;

import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.DecodeIsSuccessBean;
import com.sousouhardware.config.Constants;
import com.sousouhardware.http.ToGetUserInfo;
import com.sousouhardware.util.JsonUtil;
import com.sousouhardware.base.TokenManager;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class CartPresenter implements CartContract.Presenter {
    private CartContract.View view;

    public CartPresenter() {
    }

    public CartPresenter(CartContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        toGetUserInfo(TokenManager.getToken());
    }

    @Override
    public void setView(CartContract.View view) {
        this.view = view;
    }

    public void toGetUserInfo(String token) {
        new ToGetUserInfo(token, mineGetUserInfoCallback).submit();
    }

    private void dispenseJson(String userInfoJson) {
        view.setIsCanResume(false);
        DecodeIsSuccessBean decodeSuccessBean = JsonUtil.fromJson(userInfoJson, DecodeIsSuccessBean.class);
        if (decodeSuccessBean.isSuccess()) {
            view.showViewType(Constants.VIEWTYPE_MISSING);
        } else {
            view.showViewType(Constants.VIEWTYPE_UNLOGIN);
        }
    }

    private StringCallback mineGetUserInfoCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {
            String str_mine_getUserInfo_json = MyApplication.aCache.getAsString(ToGetUserInfo.class.getSimpleName());
            if (!TextUtils.isEmpty(str_mine_getUserInfo_json)) {
                dispenseJson(str_mine_getUserInfo_json);
            }
        }

        @Override
        public void onResponse(String response, int id) {
            String str_mine_getUserInfo_json = MyApplication.aCache.getAsString(ToGetUserInfo.class.getSimpleName());
            if (!response.equals(str_mine_getUserInfo_json)) {
                MyApplication.aCache.put(ToGetUserInfo.class.getSimpleName(), response);
            }
            dispenseJson(response);
        }
    };
}
