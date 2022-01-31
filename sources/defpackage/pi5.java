package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: pi5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class pi5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ pi5 f2808a = new pi5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = lj5.o;
        try {
            return new lj5(context, (TelecomManager) context.getSystemService("telecom"), SubscriptionManager.from(context));
        } catch (Throwable unused) {
            return null;
        }
    }
}
