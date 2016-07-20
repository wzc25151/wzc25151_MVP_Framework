package com.sousouhardware.event;

import android.text.TextUtils;

import com.sousouhardware.util.LogUtil;

/**
 * Created by wangxiangbo on 2016/7/18.
 */
public class MsgEvent extends BaseEvent{
    public static String MSG_LOGIN = "MSG_LOGIN";
    public static String MSG_LOGOUT = "MSG_LOGOUT";
    public static String MSG_LOCATION = "MSG_LOCATION";

    private String msgType ;
    private String content ;
    public MsgEvent(String msgType,String content){
        this.msgType = msgType;
        this.content = content;
        LogUtil.defaultInfo("EventBus : "+msgType);
    }

    public String getMsgType(){
        return msgType;
    }
    public String getContent(){
        return TextUtils.isEmpty(content)?"":content;
    }

}
