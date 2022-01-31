package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import java.util.concurrent.TimeUnit;

@TargetApi(22)
/* renamed from: xh5  reason: default package */
/* compiled from: LollipopCallLogInfoUtil */
public class xh5 extends wh5 {
    public final TelephonyManager c;

    static {
        TimeUnit.MINUTES.toMillis(2);
    }

    public xh5(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.c = telephonyManager;
        SubscriptionManager.from(context);
        try {
            telephonyManager.getClass().getDeclaredMethod("getCallState", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        context.getContentResolver();
    }
}
