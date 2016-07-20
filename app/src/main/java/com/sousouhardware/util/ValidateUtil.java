package com.sousouhardware.util;

import android.text.TextUtils;

import com.sousouhardware.base.MyApplication;

import java.util.regex.Pattern;

/**
 * Created by wangxiangbo on 2016/7/5.
 */
public class ValidateUtil {
    private static void alert(String tip) {
        MyApplication.showToast(tip);
    }

    public static boolean isPhoneError(String value) {
        if (TextUtils.isEmpty(value)) {
            alert("请输入手机号码");
            return true;
        }
        if (!Pattern.matches("1[0-9]{10}", value)) {
            alert("请输入正确的手机号码");
            return true;
        }
        return false;
    }

    public static boolean isPasswordError(String value) {
        if (TextUtils.isEmpty(value)) {
            alert("请输入密码");
            return true;
        }
//        if (value.length() < 6 || value.length() > 12 || Pattern.matches("[0-9]+", value) || Pattern.matches("[A-Za-z]+", value) || Pattern.matches("[_\\W]+", value)) {
//            alert("密码必须是6-12个字符，字母加数字或符号的组合，不能单独使用字母、数字或符号");
//            return true;
//        }
        if (value.length() < 6 || value.length() > 12 ) {
            alert("密码必须是6-12个字符，字母加数字或符号的组合");
            return true;
        }
        return false;
    }

    public static boolean isPasswordError(String value0, String value1) {
        if (isPasswordError(value0)) {
            return true;
        }
        if (TextUtils.isEmpty(value1) || value1.length() == 0) {
            alert("请输入确认密码");
            return true;
        }
        if (!value0.equals(value1)) {
            alert("两次输入的密码不一致");
            return true;
        }
        return false;
    }

    public static boolean isPhoneCodeError(String value) {
        if (TextUtils.isEmpty(value) ) {
            alert("请输入验证码");
            return true;
        }
        if (!Pattern.matches("[0-9]{5}", value)) {
            alert("请输入正确的验证码");
            return true;
        }
        return false;
    }

    public static boolean isNickNameError(String value) {
        if (TextUtils.isEmpty(value)) {
            alert("请输入昵称");
            return true;
        }
        if (!Pattern.matches("^[\\w\u4e00-\u9fa5]{2,16}$", value)) {
            alert("昵称应为长度2-16个字符之间的中文、英文字母、数字、下划线组成");
            return true;
        }
        return false;
    }
}