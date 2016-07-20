package com.sousouhardware.base;

import android.text.TextUtils;

import com.sousouhardware.bean.DecodeIsSuccessBean;
import com.sousouhardware.bean.DecodeMsgBean;
import com.sousouhardware.bean.TokenBean;
import com.sousouhardware.config.Constants;
import com.sousouhardware.event.MsgEvent;
import com.sousouhardware.http.ToLogin;
import com.sousouhardware.util.JsonUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/17.
 */
public class TokenManager {
    public static String getToken() {
        String token = MyApplication.aCache.getAsString(Constants.TOKENT);
        if (TextUtils.isEmpty(token)) {
            token = "";
        }
        return token;
    }

    public static void updateToken(String phone, String password) {
        new ToLogin(phone, password, loginCallback).submit();
    }

    public static void postTokenFailureEvent() {
        MyApplication.aCache.put(Constants.TOKENT, "");
        EventBus.getDefault().post(new MsgEvent(MsgEvent.MSG_LOGOUT, ""));
    }

    private static void postTokenUpdateEvent(String token) {
        MyApplication.aCache.put(Constants.TOKENT, token);
        EventBus.getDefault().post(new MsgEvent(MsgEvent.MSG_LOGIN, token));
    }

    private static StringCallback loginCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {
            MyApplication.showToast("登录失败，可能是网络原因，请检查网络或稍后再试");
            EventBus.getDefault().post(new MsgEvent(MsgEvent.MSG_LOGOUT, ""));
        }

        @Override
        public void onResponse(String response, int id) {
            DecodeIsSuccessBean decodeSuccessBean = JsonUtil.fromJson(response, DecodeIsSuccessBean.class);
            if (decodeSuccessBean.isSuccess()) {
                TokenBean tokenBean = JsonUtil.fromJson(response, TokenBean.class);
                if (tokenBean.isSuccess()) {
                    MyApplication.showToast("登录成功");
                    postTokenUpdateEvent(tokenBean.getMsg().getToken());
                } else {
                    MyApplication.showToast("登录失败");
                }
            } else {
                DecodeMsgBean decodeMsgBean = JsonUtil.fromJson(response, DecodeMsgBean.class);
                MyApplication.showToast(decodeMsgBean.getMsg());
            }
        }
    };
}
