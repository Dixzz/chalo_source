package com.urbanairship.push.adm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.push.PushProvider;
import server.zophop.Constants;

public class AdmPushProvider implements PushProvider, AirshipVersionInfo {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f738a;

    public static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public String f739a;
        public String b;

        public b(a aVar) {
        }

        public void onReceive(Context context, Intent intent) {
            if (!(intent == null || intent.getExtras() == null || !"com.amazon.device.messaging.intent.REGISTRATION".equals(intent.getAction()))) {
                if (intent.getExtras().containsKey("error")) {
                    yj5.c("ADM error occurred: %s", intent.getExtras().getString("error"));
                    this.b = intent.getExtras().getString("error");
                } else {
                    this.f739a = intent.getStringExtra("registration_id");
                }
            }
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override // com.urbanairship.AirshipVersionInfo
    public String getAirshipVersion() {
        return "14.6.0";
    }

    @Override // com.urbanairship.push.PushProvider
    public String getDeliveryType() {
        return "adm";
    }

    @Override // com.urbanairship.AirshipVersionInfo
    public String getPackageVersion() {
        return "!SDK-VERSION-STRING!:com.urbanairship.android:urbanairship-adm:14.6.0";
    }

    @Override // com.urbanairship.push.PushProvider
    public int getPlatform() {
        return 1;
    }

    @Override // com.urbanairship.push.PushProvider
    public String getRegistrationToken(Context context) throws PushProvider.a {
        String s1 = hd3.s1(context);
        if (s1 != null) {
            return s1;
        }
        b bVar = new b(null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.amazon.device.messaging.intent.REGISTRATION");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(bVar, intentFilter, "com.amazon.device.messaging.permission.SEND", new Handler(Looper.getMainLooper()));
        hd3.W2(context);
        try {
            synchronized (bVar) {
                bVar.wait(Constants.THRESHOLD_TIMESTAMP);
            }
            context.unregisterReceiver(bVar);
            if (bVar.b == null) {
                return bVar.f739a;
            }
            throw new PushProvider.a(bVar.b, false);
        } catch (InterruptedException e) {
            throw new PushProvider.a("ADM registration interrupted", true, e);
        }
    }

    @Override // com.urbanairship.push.PushProvider
    public boolean isAvailable(Context context) {
        return true;
    }

    @Override // com.urbanairship.push.PushProvider
    public boolean isSupported(Context context) {
        if (f738a == null) {
            try {
                Class.forName("com.amazon.device.messaging.ADM");
                f738a = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f738a = Boolean.FALSE;
            }
        }
        if (f738a.booleanValue()) {
            return hd3.Q1();
        }
        return false;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ADM Push Provider ");
        i0.append(getAirshipVersion());
        return i0.toString();
    }
}
