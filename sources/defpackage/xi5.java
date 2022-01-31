package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: xi5  reason: default package */
/* compiled from: MultiSimManagerLollipopMr1 */
public class xi5 extends ri5 {
    public static final /* synthetic */ int g = 0;
    public final SubscriptionManager c;
    public final TelephonyManager d;
    public final Method e;
    public final Method f;

    public xi5(Context context, SubscriptionManager subscriptionManager, TelephonyManager telephonyManager, TelecomManager telecomManager) throws Exception {
        super(context);
        this.c = subscriptionManager;
        this.d = telephonyManager;
        Class<?> cls = Class.forName("android.telecom.PhoneAccountHandle");
        Method method = null;
        String str = (String) TelecomManager.class.getField("EXTRA_PHONE_ACCOUNT_HANDLE").get(null);
        TelecomManager.class.getMethod("getCallCapablePhoneAccounts", new Class[0]);
        cls.getMethod("getId", new Class[0]);
        Class cls2 = Integer.TYPE;
        this.e = TelephonyManager.class.getMethod("getDeviceId", cls2);
        try {
            method = TelephonyManager.class.getMethod("getSubscriberId", cls2);
        } catch (NoSuchMethodException unused) {
        }
        this.f = method;
        TelecomManager.class.getMethod("getUserSelectedOutgoingPhoneAccount", new Class[0]);
        TelecomManager.class.getMethod("setUserSelectedOutgoingPhoneAccount", cls);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b7  */
    @Override // defpackage.qi5
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.truecaller.multisim.SimInfo> a() {
        /*
        // Method dump skipped, instructions count: 196
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xi5.a():java.util.List");
    }

    public String b(int i) {
        try {
            return (String) this.e.invoke(this.d, Integer.valueOf(i));
        } catch (IllegalAccessException | SecurityException | InvocationTargetException unused) {
            return null;
        }
    }
}
