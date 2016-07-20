package com.sousouhardware.view.invite;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.config.ViewDictionary;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class InviteView extends BaseFragment implements InviteContract.View {
    private Context context;
    private View rootView;
    private InviteContract.Presenter presenter;
    private EditText code_et;
    private Button next_btn;
    private boolean isCanResume = true;


    @Override
    public void setPresenter(InviteContract.Presenter presenter) {
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
        rootView = inflater.inflate(R.layout.fg_invite, null);
        init();
        initClickButton();
        return rootView;
    }
    private void init() {
        context = getContext();
        code_et = (EditText) rootView.findViewById(R.id.invite_code_et);
        next_btn = (Button) rootView.findViewById(R.id.invite_next_btn);
    }

    private void initClickButton() {
        InviteOnClickListener inviteOnClickListener = new InviteOnClickListener();
        next_btn.setOnClickListener(inviteOnClickListener);
    }

    @Override
    public void showNext() {
        MyApplication.instance.showStackActivity(getActivity(), ViewDictionary.LOGIN);
    }

    @Override
    public void showViewType(int viewType) {
    }

    @Override
    public void onClear() {
        super.onClear();
        isCanResume = true;
    }

    private class InviteOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.invite_next_btn:
//                    presenter.toRegister("","","");
                    showNext();
                    break;
                default:
                    break;
            }
        }
    }
}
