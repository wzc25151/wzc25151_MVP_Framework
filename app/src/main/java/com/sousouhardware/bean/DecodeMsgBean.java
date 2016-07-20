package com.sousouhardware.bean;

/**
 * Created by wangxiangbo on 2016/7/17.
 */
public class DecodeMsgBean {
    private String status;
    private boolean success;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
