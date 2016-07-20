package com.sousouhardware.view.setting;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;

/**
 * MVP模板
 * Created by wangxiangbo on 2016/7/13.
 */
public interface SettingContract {
    /**
     * UI逻辑
     */
    interface View extends BaseView<SettingContract.Presenter> {

    }

    /**
     * 业务逻辑
     */
    interface Presenter extends BasePresenter<SettingContract.View>  {
    }
}
