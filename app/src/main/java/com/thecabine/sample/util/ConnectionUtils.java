package com.thecabine.sample.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by admin on 10/22/15.
 */
public class ConnectionUtils {

    public static boolean isConnected(Context context) {
        return isMobileInternetConnected(context) || isWiFiConnected(context);
    }

    public static boolean isMobileInternetConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return mobileInfo != null && mobileInfo.isConnected();
    }

    public static boolean isWiFiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return wifiInfo != null && wifiInfo.isConnected();
    }
}
