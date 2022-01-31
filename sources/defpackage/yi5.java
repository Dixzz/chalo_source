package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: yi5  reason: default package */
/* compiled from: MultiSimManagerLollipopMr1Xiaomi */
public class yi5 extends xi5 {
    public static final /* synthetic */ int h = 0;

    public yi5(Context context, SubscriptionManager subscriptionManager, TelephonyManager telephonyManager, TelecomManager telecomManager) throws Exception {
        super(context, subscriptionManager, telephonyManager, telecomManager);
        String str = (String) Class.forName("miui.provider.ExtraTelephony$Sms").getField("SIM_ID").get(null);
        String str2 = (String) Class.forName("miui.provider.ExtraTelephony$Mms").getField("SIM_ID").get(null);
        String str3 = (String) Class.forName("miui.provider.ExtraContacts$Calls").getField("SIM_ID").get(null);
    }
}
