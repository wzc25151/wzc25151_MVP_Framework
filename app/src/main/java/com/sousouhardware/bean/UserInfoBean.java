package com.sousouhardware.bean;

/**
 * Created by wangxiangbo on 2016/7/17.
 */
public class UserInfoBean {

    /**
     * ShippIng : 3
     * easemobUserId : 2016062977671410
     * evaluateIng : 0
     * gredeName : 普通会员
     * hotPhone : 4006-312-532
     * inviteCode : 1075
     * isChangeCity : false
     * nickName : 张子萱看见了
     * payIng : 0
     * receivIng : 0
     * refundIng : 0
     * shopType : 10
     * userId : 1075
     * userPhoto : /Storage/Member/8461ca80-f19c-40be-a03a-c5f4f197753f.jpg
     */

    private MsgBean msg;
    /**
     * msg : {"ShippIng":3,"easemobUserId":"2016062977671410","evaluateIng":0,"gredeName":"普通会员","hotPhone":"4006-312-532","inviteCode":1075,"isChangeCity":false,"nickName":"张子萱看见了","payIng":0,"receivIng":0,"refundIng":0,"shopType":10,"userId":1075,"userPhoto":"/Storage/Member/8461ca80-f19c-40be-a03a-c5f4f197753f.jpg"}
     * status : 0
     * success : true
     */

    private int status;
    private boolean success;

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class MsgBean {
        private int ShippIng;
        private String easemobUserId;
        private int evaluateIng;
        private String gredeName;
        private String hotPhone;
        private int inviteCode;
        private boolean isChangeCity;
        private String nickName;
        private int payIng;
        private int receivIng;
        private int refundIng;
        private int shopType;
        private int userId;
        private String userPhoto;

        public int getShippIng() {
            return ShippIng;
        }

        public void setShippIng(int ShippIng) {
            this.ShippIng = ShippIng;
        }

        public String getEasemobUserId() {
            return easemobUserId;
        }

        public void setEasemobUserId(String easemobUserId) {
            this.easemobUserId = easemobUserId;
        }

        public int getEvaluateIng() {
            return evaluateIng;
        }

        public void setEvaluateIng(int evaluateIng) {
            this.evaluateIng = evaluateIng;
        }

        public String getGredeName() {
            return gredeName;
        }

        public void setGredeName(String gredeName) {
            this.gredeName = gredeName;
        }

        public String getHotPhone() {
            return hotPhone;
        }

        public void setHotPhone(String hotPhone) {
            this.hotPhone = hotPhone;
        }

        public int getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(int inviteCode) {
            this.inviteCode = inviteCode;
        }

        public boolean isIsChangeCity() {
            return isChangeCity;
        }

        public void setIsChangeCity(boolean isChangeCity) {
            this.isChangeCity = isChangeCity;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getPayIng() {
            return payIng;
        }

        public void setPayIng(int payIng) {
            this.payIng = payIng;
        }

        public int getReceivIng() {
            return receivIng;
        }

        public void setReceivIng(int receivIng) {
            this.receivIng = receivIng;
        }

        public int getRefundIng() {
            return refundIng;
        }

        public void setRefundIng(int refundIng) {
            this.refundIng = refundIng;
        }

        public int getShopType() {
            return shopType;
        }

        public void setShopType(int shopType) {
            this.shopType = shopType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }
    }
}
