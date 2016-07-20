package com.sousouhardware.view.mine;

import android.text.TextUtils;

import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.DecodeIsSuccessBean;
import com.sousouhardware.bean.UserInfoBean;
import com.sousouhardware.config.Constants;
import com.sousouhardware.http.ToGetUserInfo;
import com.sousouhardware.util.JsonUtil;
import com.sousouhardware.base.TokenManager;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class MinePresenter implements MineContract.Presenter {
    private MineContract.View view;

    public MinePresenter(){
    }

    public MinePresenter(MineContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        toGetUserInfo(TokenManager.getToken());
    }

    @Override
    public void setView(MineContract.View view) {
        this.view = view;
    }

    public void toGetUserInfo(String token) {
        new ToGetUserInfo(token, mineGetUserInfoCallback).submit();
    }

    private void dispenseJson(String userInfoJson) {
        view.setIsCanResume(false);
        DecodeIsSuccessBean decodeSuccessBean = JsonUtil.fromJson(userInfoJson, DecodeIsSuccessBean.class);
        if (decodeSuccessBean.isSuccess()) {
            UserInfoBean userInfoBean = JsonUtil.fromJson(userInfoJson, UserInfoBean.class);
            view.refreshView(userInfoBean.getMsg());
        } else {
            view.showViewType(Constants.VIEWTYPE_MISSING);
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
