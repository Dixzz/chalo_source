package com.freshchat.consumer.sdk.j.b;

import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import j$.util.DesugarTimeZone;
import java.util.GregorianCalendar;

public class c {
    public static final String TAG = "com.freshchat.consumer.sdk.j.b.c";
    public static volatile String kq = null;
    private static a kr = null;
    private static long ks = -1;
    private static long kt = 43200000;

    public static void a(a aVar) {
        synchronized (a.class) {
            kr = aVar;
            ks = System.currentTimeMillis();
            String str = TAG;
            ai.d(str, "NTP Recalculated at " + ks);
        }
    }

    public static a fC() {
        return kr;
    }

    public static void fD() {
        boolean z;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - ks;
            if (j <= kt) {
                if (j > 0) {
                    z = false;
                    String str = TAG;
                    ai.d(str, "NTP c: " + currentTimeMillis + " lntp: " + ks + " d: " + j + " int: " + kt + " calc: " + z);
                    if (fC() != null || z) {
                        ai.d(str, "Re-initing network time");
                        new Thread(new b()).start();
                    }
                    return;
                }
            }
            z = true;
            String str2 = TAG;
            ai.d(str2, "NTP c: " + currentTimeMillis + " lntp: " + ks + " d: " + j + " int: " + kt + " calc: " + z);
            if (fC() != null) {
            }
            ai.d(str2, "Re-initing network time");
            new Thread(new b()).start();
        } catch (Exception e) {
            q.a(e);
        }
    }

    public static long fE() {
        a fC = fC();
        long timeInMillis = new GregorianCalendar(DesugarTimeZone.getTimeZone("GMT")).getTimeInMillis();
        if (fC == null) {
            return timeInMillis;
        }
        long fB = fC.fB();
        if (fB == -2147483648L) {
            return timeInMillis;
        }
        String str = TAG;
        ai.d(str, "Adjustment offset for time " + fB);
        return timeInMillis + fB;
    }
}
