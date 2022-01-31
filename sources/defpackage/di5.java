package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: di5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class di5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ di5 f841a = new di5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = yi5.h;
        try {
            return new yi5(context, SubscriptionManager.from(context), telephonyManager, (TelecomManager) context.getSystemService("telecom"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
