package com.sousouhardware.view.register;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.config.ViewDictionary;
import com.sousouhardware.util.ValidateUtil;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class RegisterView extends BaseFragment implements RegisterContract.View {
    private Context context;
    private View rootView;
    private EditText phone_et;
    private EditText password_et;
    private EditText code_et;
    private Button code_btn;
    private Button next_btn;
    private RegisterContract.Presenter presenter;
    private boolean isCanResume = true;



    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
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
        rootView = inflater.inflate(R.layout.fg_register, null);
        init();
        initClickButton();
        return rootView;
    }
    private void init() {
        context = getContext();
        phone_et = (EditText) rootView.findViewById(R.id.register_phone_et);
        password_et = (EditText) rootView.findViewById(R.id.register_password_et);
        code_et = (EditText) rootView.findViewById(R.id.register_code_et);
        code_btn = (Button) rootView.findViewById(R.id.register_code_btn);
        next_btn = (Button) rootView.findViewById(R.id.register_next_btn);
    }

    private void initClickButton() {
        RegisterOnClickListener registerOnClickListener = new RegisterOnClickListener();
        code_btn.setOnClickListener(registerOnClickListener);
        next_btn.setOnClickListener(registerOnClickListener);
    }

    @Override
    public void showViewType(int viewType) {
    }

    @Override
    public void showCountDown() {
        code_btn.setEnabled(false);
        new RegisterCountDownTimer(30000,1000).start();
    }

    private void onClickGetCodeBtn(){
        if (!ValidateUtil.isPhoneError(phone_et.getText().toString())&&!ValidateUtil.isPasswordError(password_et.getText().toString())){
            presenter.getCode(phone_et.getText().toString());
        }
    }
    private void onClickNextBtn(){
//        if (!ValidateUtil.isPhoneError(phone_et.getText().toString())&&!ValidateUtil.isPasswordError(password_et.getText().toString())&&!ValidateUtil.isPhoneCodeError(code_et.getText().toString())){
//            presenter.toNext(phone_et.getText().toString(),code_et.getText().toString());
//        }
        MyApplication.instance.showStackActivity(getActivity(), ViewDictionary.INVITE);
    }

    @Override
    public void onClear() {
        super.onClear();
        isCanResume = true;
    }
    private class RegisterOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.register_code_btn:
                    onClickGetCodeBtn();
                    break;
                case R.id.register_next_btn:
                    onClickNextBtn();
                    break;
                default:
                    break;
            }
        }
    }
   private class RegisterCountDownTimer extends CountDownTimer {
        public RegisterCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onFinish() {
            code_btn.setText("点击重新发送");
            code_btn.setEnabled(true);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            code_btn.setText("请等待30秒(" + millisUntilFinished / 1000 + ")...");
        }
    }

}
