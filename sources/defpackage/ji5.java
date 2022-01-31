package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: ji5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ji5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ji5 f1929a = new ji5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = ej5.i;
        try {
            return new ej5(context, SubscriptionManager.from(context), telephonyManager, (TelecomManager) context.getSystemService("telecom"), (CarrierConfigManager) context.getSystemService("carrier_config"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
