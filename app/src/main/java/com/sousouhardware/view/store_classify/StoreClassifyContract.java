package com.sousouhardware.view.store_classify;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface StoreClassifyContract {
    interface View extends BaseView<StoreClassifyContract.Presenter> {
    }

    interface Presenter extends BasePresenter<StoreClassifyContract.View> {
    }
}
