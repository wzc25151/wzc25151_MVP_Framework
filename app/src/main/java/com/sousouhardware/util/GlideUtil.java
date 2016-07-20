package com.sousouhardware.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by wangxiangbo on 2016/7/8.
 */
public class GlideUtil {
    public static void into(Context con, String url, ImageView v) {
        Glide.with(con).load(url).centerCrop().dontAnimate().into(v);
    }
    public static void into(Context con, int url, ImageView v) {
        Glide.with(con).load(url).centerCrop().dontAnimate().into(v);
    }
    //                .placeholder(R.mipmap.ic_launcher)
    //                .error(R.mipmap.ic_launcher)
    //                        .crossFade()
}
