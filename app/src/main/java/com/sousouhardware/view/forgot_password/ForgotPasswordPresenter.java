package com.sousouhardware.view.forgot_password;

import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.DecodeIsSuccessBean;
import com.sousouhardware.bean.DecodeMsgBean;
import com.sousouhardware.http.ToGetCode;
import com.sousouhardware.util.JsonUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class ForgotPasswordPresenter implements ForgotPasswordContract.Presenter {
    private ForgotPasswordContract.View view;

    public ForgotPasswordPresenter() {
    }

    public ForgotPasswordPresenter(ForgotPasswordContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(ForgotPasswordContract.View view) {
        this.view = view;
    }

    public void getCode(String phone){
        new ToGetCode(phone,ToGetCode.CODETYPE_FORGOT_PASSWORD,getCodeCallback).submit();
    }

    private StringCallback getCodeCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            DecodeIsSuccessBean decodeIsSuccessBean = JsonUtil.fromJson(response, DecodeIsSuccessBean.class);
            if (decodeIsSuccessBean.isSuccess()){
                view.showCountDown();
                DecodeMsgBean decodeMsgBean = JsonUtil.fromJson(response, DecodeMsgBean.class);
                MyApplication.showToast(decodeMsgBean.getMsg());
            }else {
                DecodeMsgBean decodeMsgBean = JsonUtil.fromJson(response, DecodeMsgBean.class);
                MyApplication.showToast(decodeMsgBean.getMsg());
            }
        }
    };
}
