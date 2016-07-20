package com.sousouhardware.view.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.base.TokenManager;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class SettingView extends BaseFragment implements SettingContract.View {
    private Context context;
    private View rootView;
    private SettingContract.Presenter presenter;
    private boolean isCanResume = true;
    private Button logout_btn;


    @Override
    public void setPresenter(SettingContract.Presenter presenter) {
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
        rootView = inflater.inflate(R.layout.fg_setting, null);
        init();
        initClickButton();
        return rootView;
    }

    private void init() {
        context = getContext();
        logout_btn = (Button) rootView.findViewById(R.id.setting_logout_btn);
    }

    private void initClickButton() {
        logout_btn.setOnClickListener(new SettingOnClickListener());
    }

    @Override
    public void showViewType(int viewType) {
    }

    @Override
    public void onClear() {
        super.onClear();
        isCanResume = true;
    }

    private class SettingOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.setting_logout_btn:
                    TokenManager.postTokenFailureEvent();
                    break;
                default:
                    break;
            }
        }
    }
}
