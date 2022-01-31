package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

/* renamed from: ui5  reason: default package */
/* compiled from: MultiSimManagerLollipop1 */
public class ui5 extends wi5 {
    public static final /* synthetic */ int n = 0;

    public ui5(Context context, TelephonyManager telephonyManager, TelecomManager telecomManager) throws Exception {
        super(context, telephonyManager);
        Class.forName("android.telephony.SmsManager").getMethod("getSmsManagerForSubscriber", Long.TYPE);
        String str = (String) TelecomManager.class.getField("EXTRA_PHONE_ACCOUNT_HANDLE").get(null);
        TelecomManager.class.getMethod("getCallCapablePhoneAccounts", new Class[0]);
        Class.forName("android.telecom.PhoneAccountHandle").getMethod("getId", new Class[0]);
    }
}
