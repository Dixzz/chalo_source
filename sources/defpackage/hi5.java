package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: hi5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hi5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ hi5 f1377a = new hi5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = cj5.i;
        try {
            return new cj5(context, SubscriptionManager.from(context), telephonyManager, (TelecomManager) context.getSystemService("telecom"), (CarrierConfigManager) context.getSystemService("carrier_config"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
