package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: fi5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fi5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ fi5 f1128a = new fi5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = aj5.i;
        try {
            return new aj5(context, SubscriptionManager.from(context), telephonyManager, (TelecomManager) context.getSystemService("telecom"), (CarrierConfigManager) context.getSystemService("carrier_config"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
