package com.sousouhardware.view.store_classify;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class StoreClassifyView extends BaseFragment implements StoreClassifyContract.View {
    private Context context;
    private View rootView;
    private StoreClassifyContract.Presenter presenter;
    private boolean isCanResume = true;



    @Override
    public void setPresenter(StoreClassifyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setIsCanResume(boolean b) {
        isCanResume = b;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isCanResume) {
            presenter.start();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fg_store_classify, null);
        init();
        return rootView;
    }
    private void init() {
        this.context = getContext();
    }

    @Override
    public void showViewType(int viewType) {
    }

    @Override
    public void onClear() {
        super.onClear();
        isCanResume = true;
    }
}
