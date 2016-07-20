package com.sousouhardware.view.cart;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface CartContract {
    interface View extends BaseView<CartContract.Presenter> {

    }

    interface Presenter extends BasePresenter<CartContract.View> {
    }
}
