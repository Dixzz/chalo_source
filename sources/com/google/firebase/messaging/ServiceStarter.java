package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.rabbitmq.client.AMQP;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class ServiceStarter {
    public static final int ERROR_UNKNOWN = 500;
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    @GuardedBy("this")
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private Boolean hasWakeLockPermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    private ServiceStarter() {
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName componentName;
        String resolveServiceClassName = resolveServiceClassName(context, intent);
        if (resolveServiceClassName != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                if (resolveServiceClassName.length() != 0) {
                    "Restricting intent to a specific service: ".concat(resolveServiceClassName);
                } else {
                    new String("Restricting intent to a specific service: ");
                }
            }
            intent.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                componentName = WakeLockHolder.startWakefulService(context, intent);
            } else {
                componentName = context.startService(intent);
            }
            if (componentName == null) {
                return AMQP.NOT_FOUND;
            }
            return -1;
        } catch (SecurityException unused) {
            return 401;
        } catch (IllegalStateException e) {
            String.valueOf(e).length();
            return AMQP.INVALID_PATH;
        }
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

    private synchronized String resolveServiceClassName(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.firebaseMessagingServiceClassName;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || (serviceInfo = resolveService.serviceInfo) == null) {
            return null;
        }
        if (!context.getPackageName().equals(serviceInfo.packageName) || (str = serviceInfo.name) == null) {
            String str3 = serviceInfo.packageName;
            String str4 = serviceInfo.name;
            String.valueOf(str3).length();
            String.valueOf(str4).length();
            return null;
        }
        if (str.startsWith(".")) {
            String valueOf = String.valueOf(context.getPackageName());
            String valueOf2 = String.valueOf(serviceInfo.name);
            this.firebaseMessagingServiceClassName = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.firebaseMessagingServiceClassName = serviceInfo.name;
        }
        return this.firebaseMessagingServiceClassName;
    }

    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }

    public Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    public boolean hasAccessNetworkStatePermission(Context context) {
        if (this.hasAccessNetworkStatePermission == null) {
            this.hasAccessNetworkStatePermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    public boolean hasWakeLockPermission(Context context) {
        if (this.hasWakeLockPermission == null) {
            this.hasWakeLockPermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    public int startMessagingService(Context context, Intent intent) {
        Log.isLoggable(Constants.TAG, 3);
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(com.google.firebase.iid.ServiceStarter.ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }
}
