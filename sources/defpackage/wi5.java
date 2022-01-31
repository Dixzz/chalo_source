package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.truecaller.multisim.SimInfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: wi5  reason: default package */
/* compiled from: MultiSimManagerLollipopBase */
public abstract class wi5 extends ri5 {
    public final TelephonyManager c;
    public final Method d;
    public final Method e = SubscriptionManager.class.getMethod("getActiveSubIdList", new Class[0]);
    public final Method f;
    public final Method g;
    public final Method h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    @SuppressLint({"NewApi"})
    public wi5(Context context, TelephonyManager telephonyManager) throws Exception {
        super(context);
        this.c = telephonyManager;
        SubscriptionManager.class.getMethod("getActiveSubInfoCount", new Class[0]);
        SubscriptionManager.class.getMethod("getDefaultSubId", new Class[0]);
        Class cls = Integer.TYPE;
        this.d = SubscriptionManager.class.getMethod("getSubId", cls);
        Class cls2 = Long.TYPE;
        this.f = TelephonyManager.class.getMethod("getSimOperatorName", cls2);
        this.g = TelephonyManager.class.getMethod("getLine1NumberForSubscriber", cls2);
        this.h = TelephonyManager.class.getMethod("getSimOperator", cls2);
        this.i = TelephonyManager.class.getMethod("getSimCountryIso", cls2);
        this.j = TelephonyManager.class.getMethod("getImei", cls);
        this.k = TelephonyManager.class.getMethod("getSimSerialNumber", cls2);
        this.l = TelephonyManager.class.getMethod("isNetworkRoaming", cls2);
        TelephonyManager.class.getMethod("getNetworkCountryIso", cls2);
        this.m = TelephonyManager.class.getMethod("getSubscriberId", cls2);
    }

    @Override // defpackage.qi5
    public List<SimInfo> a() {
        ArrayList arrayList = new ArrayList();
        try {
            for (long j2 : (long[]) this.e.invoke(null, new Object[0])) {
                SimInfo b = b(String.valueOf(j2));
                if (b != null) {
                    arrayList.add(b);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return arrayList;
    }

    public SimInfo b(String str) {
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z;
        try {
            if (String.valueOf(((long[]) this.d.invoke(null, 0))[0]).equals(str)) {
                i2 = 0;
            } else {
                if (String.valueOf(((long[]) this.d.invoke(null, 1))[0]).equals(str)) {
                    i2 = 1;
                }
                return null;
            }
            try {
                str2 = (String) this.g.invoke(this.c, Long.valueOf(str));
            } catch (Exception unused) {
                str2 = null;
            }
            try {
                str3 = (String) this.f.invoke(this.c, Long.valueOf(str));
            } catch (Exception unused2) {
                str3 = null;
            }
            try {
                str4 = (String) this.h.invoke(this.c, Long.valueOf(str));
            } catch (Exception unused3) {
                str4 = "";
            }
            try {
                str5 = (String) this.i.invoke(this.c, Long.valueOf(str));
            } catch (Exception unused4) {
                str5 = null;
            }
            try {
                str6 = (String) this.j.invoke(this.c, Integer.valueOf(i2));
            } catch (Exception unused5) {
                str6 = null;
            }
            try {
                str7 = (String) this.k.invoke(this.c, Long.valueOf(str));
            } catch (Exception unused6) {
                str7 = null;
            }
            try {
                str8 = (String) this.m.invoke(this.c, Long.valueOf(str));
            } catch (Exception unused7) {
                str8 = null;
            }
            try {
                z = ((Boolean) this.l.invoke(this.c, Long.valueOf(str))).booleanValue();
            } catch (Exception unused8) {
                z = false;
            }
            return new SimInfo(i2, str, str2, str3, str4, str5, str6, str7, str8, z);
        } catch (Exception unused9) {
        }
    }
}
