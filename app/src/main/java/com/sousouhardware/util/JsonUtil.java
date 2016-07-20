package com.sousouhardware.util;

import com.google.gson.Gson;

/**
 * Created by wangxiangbo on 2016/7/19.
 */
public class JsonUtil {
    private static Gson gson = new Gson();
    public static <T> T fromJson(String json,Class<T> clazz){
        LogUtil.defaultInfo(clazz.getSimpleName()+"\t"+json);
        return gson.fromJson(json, clazz);
    }
}
