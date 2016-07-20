package com.sousouhardware.view.login;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface LoginContract {
    interface View extends BaseView<LoginContract.Presenter> {
    }

    interface Presenter extends BasePresenter<LoginContract.View>  {
    }
}
