package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

public class DevicePowerStateListener {
    private static final IntentFilter FILTER_BATTERY_CHANGED = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter FILTER_POWER_CONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter FILTER_POWER_DISCONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final Context context;
    private boolean isPowerConnected;
    private final BroadcastReceiver powerConnectedReceiver;
    private final BroadcastReceiver powerDisconnectedReceiver;
    private final AtomicBoolean receiversRegistered;

    public DevicePowerStateListener(Context context2) {
        this.context = context2;
        Intent registerReceiver = context2.registerReceiver(null, FILTER_BATTERY_CHANGED);
        int i = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        this.isPowerConnected = i == 2 || i == 5;
        AnonymousClass1 r0 = new BroadcastReceiver() {
            /* class com.crashlytics.android.core.DevicePowerStateListener.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                DevicePowerStateListener.this.isPowerConnected = true;
            }
        };
        this.powerConnectedReceiver = r0;
        AnonymousClass2 r1 = new BroadcastReceiver() {
            /* class com.crashlytics.android.core.DevicePowerStateListener.AnonymousClass2 */

            public void onReceive(Context context, Intent intent) {
                DevicePowerStateListener.this.isPowerConnected = false;
            }
        };
        this.powerDisconnectedReceiver = r1;
        context2.registerReceiver(r0, FILTER_POWER_CONNECTED);
        context2.registerReceiver(r1, FILTER_POWER_DISCONNECTED);
        this.receiversRegistered = new AtomicBoolean(true);
    }

    public void dispose() {
        if (this.receiversRegistered.getAndSet(false)) {
            this.context.unregisterReceiver(this.powerConnectedReceiver);
            this.context.unregisterReceiver(this.powerDisconnectedReceiver);
        }
    }

    public boolean isPowerConnected() {
        return this.isPowerConnected;
    }
}
