package com.sousouhardware.util;

/**
 * Created by wangxiangbo on 2016/7/5.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 网络处理模块
 */
public class NetWorkUtil {
    /**
     * 获取网络是否连接
     *
     * @return 连接与否
     */
    public static boolean getNetConnecState(Context context) {
        ConnectivityManager connectMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectMgr != null) {
            NetworkInfo[] info = connectMgr.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 获取网络连接类型
     *
     * @return 连接网络的状态WIFI表示无线网络;mobile表示手机网络)
     */
    public static String getNetConnecType(Context context) {
        ConnectivityManager connectMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectMgr != null) {
            NetworkInfo[] info = connectMgr.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return info[i].getTypeName();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 获取ipV4地址
     *
     * @return 地址
     */
    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
//                    if (!inetAddress.isLoopbackAddress() && InetAddressUtils.isIPv4Address(inetAddress.getHostAddress())) {
//                        return inetAddress.getHostAddress().toString();
//                    }
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * @param context
     * @return
     */
    public static String getLocalMacAddress(Context context) {
        String macSerial = null;
        String str = "";
        InputStreamReader ir = null;
        LineNumberReader input = null;
        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
            ir = new InputStreamReader(pp.getInputStream());
            input = new LineNumberReader(ir);
            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();
                }
            }
        } catch (IOException ex) {
            Log.e("msg", ex.getMessage() + "");
        } finally {
            try {
                if (ir != null)
                    ir.close();
                if (input != null)
                    input.close();
            } catch (IOException e) {
                Log.e("msg", e.getMessage() + "");
            }
        }
        if (macSerial == null) {
            macSerial = getWifiMacAddress(context);
        }
        return macSerial;
    }

    public static String macAddress = null;

    /**
     * 有WiFi获取MAC
     *
     * @param context
     * @return
     */
    public static String getWifiMacAddress(Context context) {
        try {
            final WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if (wifi == null)
                return null;
            WifiInfo info = wifi.getConnectionInfo();
            macAddress = info.getMacAddress();
            if (macAddress == null && !wifi.isWifiEnabled()) {
                new Thread() {
                    @Override
                    public void run() {
                        wifi.setWifiEnabled(true);
                        for (int i = 0; i < 10; i++) {
                            WifiInfo _info = wifi.getConnectionInfo();
                            macAddress = _info.getMacAddress();
                            if (macAddress != null)
                                break;
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        wifi.setWifiEnabled(false);
                    }
                }.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return macAddress;
    }

    /**
     * 获取设备标号
     * @param context
     * @return
     */
    public static String getDiviceNo(Context context) {
        TelephonyManager telephonyManager = null;
        // 获取手机管理对象
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        // 设备标号
        String diviceNo = telephonyManager.getDeviceId();
        if (diviceNo == null || diviceNo.length() <= 0) {
            diviceNo = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return diviceNo;
    }

    /**
     * 是否连接互联网
     * @param context
     * @return
     */
    public static boolean isNetConnected(Context context) {
        boolean flag = false;
        if (!isNetworkConnected(context)) {
            flag = false;
            return flag;
        }
        if (isWifiConnected(context) || isMobileConnected(context)) {
            flag = true;
        }
        return flag;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

}
