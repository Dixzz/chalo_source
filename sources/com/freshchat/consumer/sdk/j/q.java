package com.freshchat.consumer.sdk.j;

import android.os.Build;

public class q {
    public static final String TAG = "com.freshchat.consumer.sdk.j.q";

    public static void a(Throwable th) {
        String message = th != null ? th.getMessage() : "";
        StringBuilder i0 = hj1.i0("Exception on ");
        i0.append(Build.MANUFACTURER);
        i0.append(" ");
        i0.append(Build.MODEL);
        i0.append(" Android API ");
        i0.append(Build.VERSION.RELEASE);
        i0.append(" (");
        i0.append(Build.VERSION.SDK_INT);
        i0.append(") >>>>> ");
        i0.append(message);
        ai.e("FRESHCHAT", i0.toString(), th);
    }
}
