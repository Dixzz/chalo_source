package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: cj5  reason: default package */
/* compiled from: MultiSimManagerMarshmallowSamsung */
public class cj5 extends zi5 {
    public static final /* synthetic */ int i = 0;

    public cj5(Context context, SubscriptionManager subscriptionManager, TelephonyManager telephonyManager, TelecomManager telecomManager, CarrierConfigManager carrierConfigManager) throws Exception {
        super(context, subscriptionManager, telephonyManager, telecomManager, carrierConfigManager);
        Class<?> cls;
        try {
            cls = Class.forName("com.samsung.android.telephony.MultiSimManager");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            cls.getMethod("getEnabledSimCount", Context.class);
        }
    }
}
