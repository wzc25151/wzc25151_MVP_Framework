package com.sousouhardware.view.register;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface RegisterContract {
    interface View extends BaseView<RegisterContract.Presenter> {
        void showCountDown();
    }

    interface Presenter extends BasePresenter<RegisterContract.View> {
        void getCode(String phone);

        void toNext(String phone, String code);
    }
}
