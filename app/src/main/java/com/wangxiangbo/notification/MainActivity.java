package com.wangxiangbo.notification;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.wangxiangbo.notification.fragment.AboutFragment;
import com.wangxiangbo.notification.fragment.HomeFragment;


/**
 * Created by Wangxiangbo on 2016/4/2.
 */
public class MainActivity extends FragmentActivity {
    private HomeFragment homeFragment;
    private AboutFragment aboutFragment;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        homeFragment =new HomeFragment();
        aboutFragment = new AboutFragment();
         ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_fragment,homeFragment);
        ft.commit();
    }
}
