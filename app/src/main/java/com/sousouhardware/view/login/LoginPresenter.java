package com.sousouhardware.view.login;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    public LoginPresenter() {
    }

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }
}
