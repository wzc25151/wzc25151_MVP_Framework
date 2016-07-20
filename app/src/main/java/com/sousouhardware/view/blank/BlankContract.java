package com.sousouhardware.view.blank;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * MVP模板
 * Created by wangxiangbo on 2016/7/13.
 */
public interface BlankContract {
    /**
     * UI逻辑
     */
    interface View extends BaseView<BlankContract.Presenter> {

    }

    /**
     * 业务逻辑
     */
    interface Presenter extends BasePresenter<BlankContract.View>  {
    }
}
