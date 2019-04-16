package com.learn.library_common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorkUtils {
    /**
     * check if the network connected or not
     * @param context context
     * @return true: connected, false:not, null:unknown
     */
    public static Boolean isNetworkConnected(Context context) {
        try {
            context = context.getApplicationContext();
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
