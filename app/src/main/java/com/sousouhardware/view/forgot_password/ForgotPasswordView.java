package com.sousouhardware.view.forgot_password;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.util.ValidateUtil;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class ForgotPasswordView extends BaseFragment implements ForgotPasswordContract.View {
    private Context context;
    private View rootView;
    private ForgotPasswordContract.Presenter presenter;
    private boolean isCanResume = true;
    private TextView phone_et;
    private TextView password_1_et;
    private TextView password_2_et;
    private TextView code_et;
    private Button code_btn;
    private Button next_btn;
    private CountDownTimer coutDown;


    @Override
    public void setPresenter(ForgotPasswordContract.Presenter presenter) {
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
        rootView = inflater.inflate(R.layout.fg_forgot_password, null);
        init();
        initClickButton();
        return rootView;
    }

    private void init() {
        context = getContext();
        phone_et = (EditText) rootView.findViewById(R.id.forgot_password_phone_et);
        password_1_et = (EditText) rootView.findViewById(R.id.forgot_password_password_1_et);
        password_2_et = (EditText) rootView.findViewById(R.id.forgot_password_password_2_et);
        code_et = (EditText) rootView.findViewById(R.id.forgot_password_code_et);
        code_btn = (Button) rootView.findViewById(R.id.forgot_password_code_btn);
        next_btn = (Button) rootView.findViewById(R.id.forgot_password_next_btn);
    }

    private void initClickButton() {
        ForgotPasswordOnClickListener forgotPasswordOnClickListener = new ForgotPasswordOnClickListener();
        code_btn.setOnClickListener(forgotPasswordOnClickListener);
        next_btn.setOnClickListener(forgotPasswordOnClickListener);
    }

    private void onClickCodeBtn() {
        String phone = phone_et.getText().toString();
        if (!ValidateUtil.isPhoneError(phone)) {
            presenter.getCode(phone);
        }
    }

    @Override
    public void showCountDown() {
        code_btn.setEnabled(false);
        coutDown = new ForgotPasswordCountDownTimer(30000, 1000).start();
    }

    @Override
    public void showViewType(int viewType) {
    }

    @Override
    public void onClear() {
        super.onClear();
        isCanResume = true;
        phone_et.setText("");
        password_1_et.setText("");
        password_2_et.setText("");
        code_et.setText("");
        code_btn.setText("获取验证码");
    }

    private class ForgotPasswordOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.forgot_password_code_btn:
                    onClickCodeBtn();
                    break;
                case R.id.forgot_password_next_btn:
                    break;
                default:
                    break;
            }
        }
    }

    private class ForgotPasswordCountDownTimer extends CountDownTimer {
        public ForgotPasswordCountDownTimer(long millisInFuture, long countDownInterval) {
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
