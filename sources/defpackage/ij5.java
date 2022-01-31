package defpackage;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: ij5  reason: default package */
/* compiled from: MultiSimManagerMotorola */
public class ij5 extends ri5 {
    public static final /* synthetic */ int m = 0;
    public final Object c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Method g;
    public final Method h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Object l;

    @SuppressLint({"PrivateApi"})
    public ij5(Context context) throws Exception {
        super(context);
        Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
        this.c = cls.getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
        Class<?> cls2 = Integer.TYPE;
        this.d = cls.getMethod("getNetworkOperatorName", cls2);
        this.e = cls.getMethod("getLine1Number", cls2);
        this.f = cls.getMethod("getSimOperator", cls2);
        this.g = cls.getMethod("getSimCountryIso", cls2);
        this.h = cls.getMethod("getDeviceId", cls2);
        this.i = cls.getMethod("getSimSerialNumber", cls2);
        this.j = cls.getMethod("isNetworkRoaming", cls2);
        cls.getMethod("getNetworkCountryIso", cls2);
        this.k = cls.getMethod("getSubscriberId", cls2);
        cls.getMethod("isMultiSimEnabled", new Class[0]);
        cls.getMethod("getDefaultSubscription", new Class[0]);
        Class<?> cls3 = Class.forName("android.telephony.MSimSmsManager");
        this.l = cls3.getMethod("getDefault", new Class[0]).invoke(cls3, new Object[0]);
        cls3.getMethod("sendTextMessage", String.class, String.class, String.class, PendingIntent.class, PendingIntent.class, cls2);
        cls3.getMethod("sendMultipartTextMessage", String.class, String.class, ArrayList.class, ArrayList.class, ArrayList.class, cls2);
        Class<?> cls4 = Class.forName("android.provider.Telephony$Sms");
        String str = (String) cls4.getField("SUB_ID").get(cls4);
        Class<?> cls5 = Class.forName("android.provider.Telephony$Mms");
        String str2 = (String) cls5.getField("SUB_ID").get(cls5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r5 == null) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00de A[SYNTHETIC] */
    @Override // defpackage.qi5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.truecaller.multisim.SimInfo> a() {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ij5.a():java.util.List");
    }
}
