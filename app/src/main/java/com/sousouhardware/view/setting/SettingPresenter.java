package com.sousouhardware.view.setting;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class SettingPresenter implements SettingContract.Presenter {
    private SettingContract.View view;

    public SettingPresenter() {
    }

    public SettingPresenter(SettingContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(SettingContract.View view) {
        this.view = view;
    }
}
