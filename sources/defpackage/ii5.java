package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: ii5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ii5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ii5 f1520a = new ii5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = dj5.i;
        try {
            return new dj5(context, SubscriptionManager.from(context), telephonyManager, (TelecomManager) context.getSystemService("telecom"), (CarrierConfigManager) context.getSystemService("carrier_config"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
