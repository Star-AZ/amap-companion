package com.autonavi.companion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "AmapCompanion";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (context == null || !MainActivity.isAutoStartEnabled(context)) {
            return;
        }
        String action = intent == null ? "" : intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)
                || Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)) {
            Log.d(TAG, "auto start overlay service after " + action);
            MainActivity.startOverlayService(context);
        }
    }
}
