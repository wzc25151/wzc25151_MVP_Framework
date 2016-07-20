package com.sousouhardware.view.forgot_password;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface ForgotPasswordContract {
    interface View extends BaseView<ForgotPasswordContract.Presenter> {
void showCountDown();
    }

    interface Presenter extends BasePresenter<ForgotPasswordContract.View>  {
        void getCode(String phone);
    }
}
