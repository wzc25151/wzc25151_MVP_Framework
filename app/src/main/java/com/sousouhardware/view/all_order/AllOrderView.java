package com.sousouhardware.view.all_order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class AllOrderView extends BaseFragment implements AllOrderContract.View {
    private Context context;
    private View rootView;
    private AllOrderContract.Presenter presenter;
    private boolean isCanResume = true;

    @Override
    public void setPresenter(AllOrderContract.Presenter presenter) {
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
        rootView = inflater.inflate(R.layout.fg_all_order, null);
        init();
        return rootView;
    }

    private void init() {
        context = getContext();
        Button btn =  (Button)rootView.findViewById(R.id.allorder_get_order_btn);
       btn . setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getOrder();
            }
        });
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
