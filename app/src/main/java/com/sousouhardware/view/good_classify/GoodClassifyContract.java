package com.sousouhardware.view.good_classify;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface GoodClassifyContract {
    interface View extends BaseView<GoodClassifyContract.Presenter> {
    }

    interface Presenter extends BasePresenter<GoodClassifyContract.View>  {
    }
}
