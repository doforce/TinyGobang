package com.example.vampire.tinygobang.net;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * Created by edgar on 16-6-11.
 */
public class GetIP {
    public static String get(Context context){
        try {
            WifiManager wifiManager = (WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int i = wifiInfo.getIpAddress();
            return int2ip(i);
        } catch (Exception ex) {
            return " 获取IP出错鸟!!!!请保证是WIFI,或者请重新打开网络!\n" + ex.getMessage();
        }
    }

    private static String int2ip(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 0xFF).append(".");
        sb.append((i >> 8) & 0xFF).append(".");
        sb.append((i >> 16) & 0xFF).append(".");
        sb.append((i >> 24) & 0xFF);
        return sb.toString();
    }
}
