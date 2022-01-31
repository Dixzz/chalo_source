package defpackage;

import android.content.Context;
import android.provider.Telephony;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

/* renamed from: vi5  reason: default package */
/* compiled from: MultiSimManagerLollipop2 */
public class vi5 extends ui5 {
    public static final /* synthetic */ int o = 0;

    public vi5(Context context, TelephonyManager telephonyManager, TelecomManager telecomManager) throws Exception {
        super(context, telephonyManager, telecomManager);
        String str = (String) Telephony.Sms.class.getField("PHONE_ID").get(null);
        String str2 = (String) Telephony.Mms.class.getField("PHONE_ID").get(null);
    }
}
