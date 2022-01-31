package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: ci5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ci5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ci5 f568a = new ci5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = xi5.g;
        try {
            return new xi5(context, SubscriptionManager.from(context), telephonyManager, (TelecomManager) context.getSystemService("telecom"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
