package com.sousouhardware.view.mine;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;
import com.sousouhardware.bean.UserInfoBean;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface MineContract {
    interface View extends BaseView<MineContract.Presenter> {
        void refreshView(UserInfoBean.MsgBean msg);
        void showTitle(String title);
    }

    interface Presenter extends BasePresenter<MineContract.View> {
        void toGetUserInfo(String token);
    }
}
