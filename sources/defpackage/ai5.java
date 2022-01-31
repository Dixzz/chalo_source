package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

/* renamed from: ai5  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ai5 implements si5 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ai5 f169a = new ai5();

    @Override // defpackage.si5
    public final qi5 a(Context context, TelephonyManager telephonyManager) {
        int i = ui5.n;
        try {
            return new ui5(context, telephonyManager, (TelecomManager) context.getSystemService("telecom"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
