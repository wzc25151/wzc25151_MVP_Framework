package com.sousouhardware.view.cart;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.config.Constants;
import com.sousouhardware.event.MsgEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class CartView extends BaseFragment implements CartContract.View {
    private Context context;
    private View rootView;
    private CartContract.Presenter presenter;
    private boolean isCanResume = true;
    private View unlogin_v;
    private View missing_v;
    private View content_v;


    @Override
    public void setPresenter(CartContract.Presenter presenter) {
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
        if (msgType.equals(MsgEvent.MSG_LOGIN)) {
            showViewType(Constants.VIEWTYPE_MISSING);
        }
        if (msgType.equals(MsgEvent.MSG_LOGOUT)) {
            showViewType(Constants.VIEWTYPE_UNLOGIN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 界面创建时，订阅事件， 接受消息
        EventBus.getDefault().register(this);
        rootView = inflater.inflate(R.layout.fg_cart, null);
        init();
        return rootView;
    }

    private void init() {
        context = getContext();
        unlogin_v = rootView.findViewById(R.id.cart_unlogin);
        missing_v = rootView.findViewById(R.id.cart_missing);
        content_v = rootView.findViewById(R.id.cart_content);
    }

    @Override
    public void showViewType(int viewType) {
        switch (viewType) {
            case Constants.VIEWTYPE_UNLOGIN:
                unlogin_v.setVisibility(View.VISIBLE);
//                loading_v.setVisibility(View.GONE);
                missing_v.setVisibility(View.GONE);
                content_v.setVisibility(View.GONE);
                break;
            case Constants.VIEWTYPE_LOADING:
                unlogin_v.setVisibility(View.GONE);
//                loading_v.setVisibility(View.VISIBLE);
                missing_v.setVisibility(View.GONE);
                content_v.setVisibility(View.GONE);
                break;
            case Constants.VIEWTYPE_MISSING:
                unlogin_v.setVisibility(View.GONE);
//                loading_v.setVisibility(View.GONE);
                missing_v.setVisibility(View.VISIBLE);
                content_v.setVisibility(View.GONE);
                break;
            case Constants.VIEWTYPE_CONTENT:
                unlogin_v.setVisibility(View.GONE);
//                loading_v.setVisibility(View.GONE);
                missing_v.setVisibility(View.GONE);
                content_v.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
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
}
