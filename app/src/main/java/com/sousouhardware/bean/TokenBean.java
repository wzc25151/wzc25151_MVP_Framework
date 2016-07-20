package com.sousouhardware.bean;

/**
 * Created by wangxiangbo on 2016/7/17.
 */
public class TokenBean {

    /**
     * success : true
     * status : 0
     * msg : {"Token":"b212318d-4e80-4179-b361-1da154391ce1"}
     */

    private boolean success;
    private int status;
    /**
     * Token : b212318d-4e80-4179-b361-1da154391ce1
     */

    private MsgBean msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        private String Token;

        public String getToken() {
            return Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }
    }
}
