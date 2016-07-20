package com.sousouhardware.view.register;

import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.DecodeIsSuccessBean;
import com.sousouhardware.bean.DecodeMsgBean;
import com.sousouhardware.http.ToGetCode;
import com.sousouhardware.http.ToInvalidCode;
import com.sousouhardware.util.JsonUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;

    public RegisterPresenter() {
    }

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void getCode(String phone) {
        new ToGetCode(phone, ToGetCode.CODETYPE_REGISTER, getCodeCallback).submit();
    }

    @Override
    public void toNext(String phone, String code) {
        new ToInvalidCode(phone, code, invalidCodeCallback).submit();
    }

    private StringCallback getCodeCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            DecodeIsSuccessBean decodeIsSuccessBean = JsonUtil.fromJson(response, DecodeIsSuccessBean.class);
            if (decodeIsSuccessBean.isSuccess()) {
                DecodeMsgBean decodeMsgBean = JsonUtil.fromJson(response, DecodeMsgBean.class);
                view.showCountDown();
                MyApplication.showToast(decodeMsgBean.getMsg());
            } else {
                DecodeMsgBean decodeMsgBean = JsonUtil.fromJson(response, DecodeMsgBean.class);
                MyApplication.showToast(decodeMsgBean.getMsg());
            }
        }
    };
    private StringCallback invalidCodeCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            DecodeIsSuccessBean decodeIsSuccessBean = JsonUtil.fromJson(response, DecodeIsSuccessBean.class);
            if (decodeIsSuccessBean.isSuccess()) {

            } else {
                DecodeMsgBean decodeMsgBean = JsonUtil.fromJson(response, DecodeMsgBean.class);
                MyApplication.showToast(decodeMsgBean.getMsg());
            }
        }
    };
}
