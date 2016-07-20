package com.sousouhardware.view.invite;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * MVP模板
 * Created by wangxiangbo on 2016/7/13.
 */
public interface InviteContract {
    /**
     * UI逻辑
     */
    interface View extends BaseView<InviteContract.Presenter> {
void showNext();
    }

    /**
     * 业务逻辑
     */
    interface Presenter extends BasePresenter<InviteContract.View>  {
        void toRegister(String phone,String password,String refereePhone);
    }
}
