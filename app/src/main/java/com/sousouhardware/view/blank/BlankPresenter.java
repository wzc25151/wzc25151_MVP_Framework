package com.sousouhardware.view.blank;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class BlankPresenter implements BlankContract.Presenter {
    private BlankContract.View view;

    public BlankPresenter() {
    }

    public BlankPresenter(BlankContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(BlankContract.View view) {
        this.view = view;
    }
}
