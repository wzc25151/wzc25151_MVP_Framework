package com.wangxiangbo.notification.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wangxiangbo.notification.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        view.findViewById(R.id.home_btn_0).setOnClickListener(this);
        view.findViewById(R.id.home_btn_1).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_btn_0:
                Generate();
                break;
            case R.id.home_btn_1:
                break;
            default:
        }
    }

    private void Generate() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        builder.setContentTitle("title");
        builder.setContentText("text");
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setNumber(5);
        builder.setDefaults(Notification.DEFAULT_ALL);
        //notification显示在通知栏时滚动的内容（如收到短信时滚动短信内容）
        builder.setTicker("ticker");
        builder.setSubText("subtext");
        //必须存在
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
//        NotificationListenerService.
//        notificationManager.

    }

}
