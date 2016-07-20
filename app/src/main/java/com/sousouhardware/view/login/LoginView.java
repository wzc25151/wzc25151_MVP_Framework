package com.sousouhardware.view.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.base.TokenManager;
import com.sousouhardware.config.ViewDictionary;
import com.sousouhardware.event.MsgEvent;
import com.sousouhardware.util.ValidateUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class LoginView extends BaseFragment implements LoginContract.View {
    private Context context;
    private View rootView;
    private LoginContract.Presenter presenter;
    private boolean isCanResume = true;
    private EditText phone_et;
    private EditText password_et;
    private TextView login_tv;
    private TextView register_tv;
    private TextView forgot_password_tv;


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
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
    @Subscribe
    public void onEvent(MsgEvent event) {
        String msgType = event.getMsgType();
        if (msgType.equals(MsgEvent.MSG_LOGIN)){
            getActivity().finish();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 界面创建时，订阅事件， 接受消息
        EventBus.getDefault().register(this);
        rootView = inflater.inflate(R.layout.fg_login, null);
        init();
        initClickButton();
        return rootView;
    }
    private void init() {
        context = getContext();
        phone_et=(EditText)rootView.findViewById(R.id.login_phone_et);
        password_et=(EditText)rootView.findViewById(R.id.login_password_et);
        login_tv = (TextView) rootView.findViewById(R.id.login_login_tv);
        register_tv = (TextView) rootView.findViewById(R.id.login_to_register_tv);
        forgot_password_tv = (TextView) rootView.findViewById(R.id.login_to_forgot_password_tv);
    }
    private void initClickButton() {
        LoginOnclickListener loginOnclickListener = new LoginOnclickListener();
        login_tv.setOnClickListener(loginOnclickListener);
        register_tv.setOnClickListener(loginOnclickListener);
        forgot_password_tv.setOnClickListener(loginOnclickListener);
    }

    @Override
    public void showViewType(int viewType) {
    }

    @Override
    public void onClear() {
        super.onClear();
        isCanResume = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
// 界面销毁时，取消订阅
        EventBus.getDefault().unregister(this);
    }


    private void clickLoginBtn(){
        String phone = phone_et.getText().toString();
        String password = password_et.getText().toString();
        if (!ValidateUtil.isPhoneError(phone)&&!ValidateUtil.isPasswordError(password)){
            TokenManager.updateToken(phone,password);
        }
    }
    private class LoginOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.login_login_tv:
                    clickLoginBtn();
                    break;
                case R.id.login_to_register_tv:
                    MyApplication.instance.showStackActivity(getActivity(), ViewDictionary.REGISTER);
                    break;
                case R.id.login_to_forgot_password_tv:
                    MyApplication.instance.showStackActivity(getActivity(),ViewDictionary.FORGOT_PASSWORD);
                    break;
                default:
                    break;
            }
        }
    }


}
