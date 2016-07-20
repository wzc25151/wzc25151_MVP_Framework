package com.sousouhardware.view.all_order;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * MVP模板
 * Created by wangxiangbo on 2016/7/13.
 */
public interface AllOrderContract {
    /**
     * UI逻辑
     */
    interface View extends BaseView<AllOrderContract.Presenter> {

    }

    /**
     * 业务逻辑
     */
    interface Presenter extends BasePresenter<AllOrderContract.View>  {
        void getOrder();
    }
}
