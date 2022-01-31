package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public class ServiceStarter {
    public static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    public static final int ERROR_UNKNOWN = 500;
    private static ServiceStarter instance;
    private Boolean hasAccessNetworkStatePermission = null;
    private Boolean hasWakeLockPermission = null;

    private ServiceStarter() {
    }

    public static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (instance == null) {
                instance = new ServiceStarter();
            }
            serviceStarter = instance;
        }
        return serviceStarter;
    }

    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }

    public boolean hasAccessNetworkStatePermission(Context context) {
        if (this.hasAccessNetworkStatePermission == null) {
            this.hasAccessNetworkStatePermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    public boolean hasWakeLockPermission(Context context) {
        if (this.hasWakeLockPermission == null) {
            this.hasWakeLockPermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.hasWakeLockPermission.booleanValue();
    }
}
