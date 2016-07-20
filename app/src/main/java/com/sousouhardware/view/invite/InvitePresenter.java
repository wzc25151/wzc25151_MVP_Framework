package com.sousouhardware.view.invite;

import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.DecodeIsSuccessBean;
import com.sousouhardware.bean.DecodeMsgBean;
import com.sousouhardware.http.ToRegisterUser;
import com.sousouhardware.util.JsonUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class InvitePresenter implements InviteContract.Presenter {
    private InviteContract.View view;

    public InvitePresenter() {
    }

    public InvitePresenter(InviteContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(InviteContract.View view) {
        this.view = view;
    }

    public void toRegister(String phone, String password, String refereePhone) {
        new ToRegisterUser(phone, password, ToRegisterUser.USERYTYPE_D, refereePhone, registerCallback).submit();
    }

    private StringCallback registerCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            DecodeIsSuccessBean decodeIsSuccessBean = JsonUtil.fromJson(response, DecodeIsSuccessBean.class);
            if (decodeIsSuccessBean.isSuccess()){
                view.showNext();
            }else {
                DecodeMsgBean decodeMsgBean = JsonUtil.fromJson(response, DecodeMsgBean.class);
                MyApplication.showToast(decodeMsgBean.getMsg());
            }
        }
    };
}
