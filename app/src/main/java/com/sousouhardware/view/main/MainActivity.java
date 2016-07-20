package com.sousouhardware.view.main;

import android.support.v4.view.ViewPager;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.sousouhardware.R;
import com.sousouhardware.base.BaseActivity;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.base.ObjViewManager;
import com.sousouhardware.event.MsgEvent;
import com.sousouhardware.util.PermissionUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wangxiangbo on 2016/7/5.
 */
public class MainActivity extends BaseActivity {
    //findView优先往列
    private ViewPager content_vp;
    private final int[] arr_tabIds = new int[]{R.id.main_tab_0, R.id.main_tab_1, R.id.main_tab_2, R.id.main_tab_3, R.id.main_tab_4};
    private final String[] arr_className = new String[]{
            "home.Home",
            "good_classify.GoodClassify",
            "store_classify.StoreClassify",
            "cart.Cart",
            "mine.Mine"
    };
    private AMapLocationClient locationClient ;
    private AMapLocationClientOption locationOption;
    private boolean isNeedLocation;

    @Override
    protected void init() {
        // 界面创建时，订阅事件， 接受消息
        EventBus.getDefault().register(this);
        setContentView(R.layout.act_main);
        initLocationOption();
        initLocationClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocation();
    }

    @Override
    protected void initLayout() {
        content_vp = (ViewPager) findViewById(R.id.main_context_vp);
        for (int i = 0; i < arr_className.length; i++) {
            ObjViewManager.setupContract(arr_className[i]);
        }
        content_vp.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), arr_className));
        content_vp.setOffscreenPageLimit(arr_className.length);
    }

    @Override
    protected void initClickButton() {
        MainOnClickListener mainOnClickListener = new MainOnClickListener(arr_tabIds,content_vp);
        for (int i : arr_tabIds){
            findViewById(i).setOnClickListener(mainOnClickListener);
        }
    }

    private void initLocationClient() {
        isNeedLocation = true;
        AMapLocationClient.setApiKey("661838c55160a89698dad9f576b0cb18");
        locationClient = new AMapLocationClient(getApplicationContext());
        locationClient.setLocationListener(new MainLocationListener());
        locationClient.setLocationOption(locationOption);
    }

    private void initLocationOption() {
        locationOption  = new AMapLocationClientOption();
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        locationOption.setOnceLocation(true);
        locationOption.setNeedAddress(true);
    }

    public void startLocation(){
        if(isNeedLocation){
            PermissionUtil.checkPermissions(this);
            locationClient.startLocation();
        }
    }

    @Subscribe
    public void onEvent(MsgEvent event) {
        if (event.getMsgType().equals(MsgEvent.MSG_LOCATION)){
            isNeedLocation = false;
            MyApplication.showToast("定位成功："+event.getContent());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 界面销毁时，取消订阅
        EventBus.getDefault().unregister(this);
        if (null != locationClient) {
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }

}
