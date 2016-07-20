package com.sousouhardware.view.good_classify;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class GoodClassifyPresenter implements GoodClassifyContract.Presenter {
    private GoodClassifyContract.View view;

    public GoodClassifyPresenter() {
    }

    public GoodClassifyPresenter(GoodClassifyContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(GoodClassifyContract.View view) {
        this.view = view;
    }
}
