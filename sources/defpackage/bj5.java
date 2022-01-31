package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: bj5  reason: default package */
/* compiled from: MultiSimManagerMarshmallowLg */
public class bj5 extends zi5 {
    public static final /* synthetic */ int i = 0;

    public bj5(Context context, SubscriptionManager subscriptionManager, TelephonyManager telephonyManager, TelecomManager telecomManager, CarrierConfigManager carrierConfigManager) throws Exception {
        super(context, subscriptionManager, telephonyManager, telecomManager, carrierConfigManager);
        Class.forName("com.lge.internal.telephony.LGGsmAlphabet");
    }
}
