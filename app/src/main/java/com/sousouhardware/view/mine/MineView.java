package com.sousouhardware.view.mine;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.UserInfoBean;
import com.sousouhardware.config.ApiConfig;
import com.sousouhardware.config.Constants;
import com.sousouhardware.config.ViewDictionary;
import com.sousouhardware.event.MsgEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class MineView extends BaseFragment implements MineContract.View {
    private Context context;
    private View rootView;
    private MineContract.Presenter presenter;
    private boolean isCanResume = true;
    private View missing_v;
    private TextView to_login_tv;
    private View content_v;
    private ImageView header_iv;
    private TextView name_tv;
    private TextView invite_code_tv;
    private TextView all_order_tv;
    private TextView unpay_tv;
    private TextView unsend_tv;
    private TextView unreceive_tv;
    private TextView unevaluate_tv;
    private TextView unrefund_tv;


    @Override
    public void onResume() {
        super.onResume();
        if (isCanResume ) {
            presenter.start();
        }
    }

    @Override
    public void setPresenter(MineContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setIsCanResume(boolean b) {
        isCanResume = b;
    }

    @Subscribe
    public void onEvent(MsgEvent event) {
        String msgType = event.getMsgType();
        if (msgType.equals(MsgEvent.MSG_LOGIN)) {
            presenter.toGetUserInfo(event.getContent());
        }
        if (msgType.equals(MsgEvent.MSG_LOGOUT)) {
            showViewType(Constants.VIEWTYPE_MISSING);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 界面创建时，订阅事件， 接受消息
        EventBus.getDefault().register(this);
        rootView = inflater.inflate(R.layout.fg_mine, null);
        init();
        initClickButton();
        return rootView;
    }

    private void init() {
        this.context = getContext();
        missing_v = rootView.findViewById(R.id.mine_missing);
        to_login_tv = (TextView) rootView.findViewById(R.id.mine_to_login_tv);
        content_v = rootView.findViewById(R.id.mine_content);
        header_iv = (ImageView) rootView.findViewById(R.id.mine_buyer_header_iv);
        name_tv = (TextView) rootView.findViewById(R.id.mine_buyer_name_tv);
        invite_code_tv = (TextView) rootView.findViewById(R.id.mine_buyer_invite_code_tv);
        all_order_tv = (TextView) rootView.findViewById(R.id.mine_buyer_all_order_tv);

        unpay_tv = (TextView) rootView.findViewById(R.id.mine_buyer_unpay_tv);
        unsend_tv = (TextView) rootView.findViewById(R.id.mine_buyer_unsend_tv);
        unreceive_tv = (TextView) rootView.findViewById(R.id.mine_buyer_unreceive_tv);
        unevaluate_tv = (TextView) rootView.findViewById(R.id.mine_buyer_unevaluate_tv);
        unrefund_tv = (TextView) rootView.findViewById(R.id.mine_buyer_unrefund_tv);
    }

    private void initClickButton() {
        MineOnClickListener mineOnClickListener = new MineOnClickListener();
        to_login_tv.setOnClickListener(mineOnClickListener);
        all_order_tv.setOnClickListener(mineOnClickListener);
    }

    public void refreshView(UserInfoBean.MsgBean msg) {
        showViewType(Constants.VIEWTYPE_CONTENT);
        Glide.with(this).load(ApiConfig.BASE_URL_3 + msg.getUserPhoto()).centerCrop().into(header_iv);
        name_tv.setText(msg.getNickName());
        invite_code_tv.setText("" + msg.getInviteCode());
        unpay_tv.setText("" + msg.getPayIng());//待付款
        unsend_tv.setText("" + msg.getShippIng());//待发货
        unreceive_tv.setText("" + msg.getReceivIng());//待收货
        unevaluate_tv.setText("" + msg.getEvaluateIng());//待评价
        unrefund_tv.setText("" + msg.getRefundIng());//退款中
    }


    @Override
    public void showTitle(String title) {
    }

    @Override
    public void showViewType(int viewType) {
        switch (viewType) {
            case Constants.VIEWTYPE_UNLOGIN:
//                unlogin_v.setVisibility(View.VISIBLE);
//                loading_v.setVisibility(View.GONE);
                missing_v.setVisibility(View.GONE);
                content_v.setVisibility(View.GONE);
                break;
            case Constants.VIEWTYPE_LOADING:
//                unlogin_v.setVisibility(View.GONE);
//                loading_v.setVisibility(View.VISIBLE);
                missing_v.setVisibility(View.GONE);
                content_v.setVisibility(View.GONE);
                break;
            case Constants.VIEWTYPE_MISSING:
//                unlogin_v.setVisibility(View.GONE);
//                loading_v.setVisibility(View.GONE);
                missing_v.setVisibility(View.VISIBLE);
                content_v.setVisibility(View.GONE);
                break;
            case Constants.VIEWTYPE_CONTENT:
//                unlogin_v.setVisibility(View.GONE);
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
        isCanResume = true;
        // 界面销毁时，取消订阅
        EventBus.getDefault().unregister(this);
    }
    private class MineOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mine_to_login_tv:
                    MyApplication.instance.showStackActivity(getActivity(), ViewDictionary.LOGIN);
                    break;
                case R.id.mine_buyer_all_order_tv:
                    MyApplication.instance.showStackActivity(getActivity(), ViewDictionary.ALL_ORDER);
                    break;
                default:
                    break;
            }
        }
    }


}
