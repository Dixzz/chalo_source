package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: dj5  reason: default package */
/* compiled from: MultiSimManagerMarshmallowXiaomi */
public class dj5 extends zi5 {
    public static final /* synthetic */ int i = 0;

    public dj5(Context context, SubscriptionManager subscriptionManager, TelephonyManager telephonyManager, TelecomManager telecomManager, CarrierConfigManager carrierConfigManager) throws Exception {
        super(context, subscriptionManager, telephonyManager, telecomManager, carrierConfigManager);
        Class.forName("miui.provider.ExtraTelephony$XiaomiId");
    }
}
