package com.sousouhardware.view.store_classify;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class StoreClassifyPresenter implements StoreClassifyContract.Presenter {
    private StoreClassifyContract.View view;

    public StoreClassifyPresenter() {
    }

    public StoreClassifyPresenter(StoreClassifyContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(StoreClassifyContract.View view) {
        this.view = view;
    }
}
