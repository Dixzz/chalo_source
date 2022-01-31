package defpackage;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: ub3  reason: default package */
public final class ub3 implements Runnable {
    public final /* synthetic */ nd3 f;
    public final /* synthetic */ sb3 g;

    public ub3(sb3 sb3, nd3 nd3) {
        this.g = sb3;
        this.f = nd3;
    }

    public final void run() {
        long j;
        mc3 mc3 = this.g.h;
        nd3 nd3 = this.f;
        Objects.requireNonNull(mc3);
        Objects.requireNonNull(nd3, "null reference");
        jz1.c();
        mc3.g0();
        if (mc3.r) {
            mc3.P("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            mc3.k("Delivering hit", nd3);
        }
        if (TextUtils.isEmpty(nd3.c("_m", ""))) {
            xd3 xd3 = mc3.E().k;
            long c = xd3.c();
            if (c == 0) {
                j = 0;
            } else {
                Objects.requireNonNull((db2) xd3.c.f.c);
                j = Math.abs(c - System.currentTimeMillis());
            }
            long j2 = xd3.b;
            Pair pair = null;
            if (j >= j2) {
                if (j > (j2 << 1)) {
                    xd3.b();
                } else {
                    String string = xd3.c.h.getString(xd3.e(), null);
                    long j3 = xd3.c.h.getLong(xd3.d(), 0);
                    xd3.b();
                    if (string != null && j3 > 0) {
                        pair = new Pair(string, Long.valueOf(j3));
                    }
                }
            }
            if (pair != null) {
                String str = (String) pair.first;
                String valueOf = String.valueOf((Long) pair.second);
                String y = hj1.y(hj1.g0(str, valueOf.length() + 1), valueOf, ProductDiscountsObject.KEY_DELIMITER, str);
                HashMap hashMap = new HashMap(nd3.f2542a);
                hashMap.put("_m", y);
                nd3 = new nd3(mc3, hashMap, nd3.d, nd3.f, nd3.c, nd3.e, nd3.b);
            }
        }
        mc3.m0();
        if (mc3.l.m0(nd3)) {
            mc3.P("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            mc3.i.w0(nd3);
            mc3.q0();
        } catch (SQLiteException e) {
            mc3.L("Delivery failed to save hit to a database", e);
            mc3.t().i0(nd3, "deliver: failed to insert hit to database");
        }
    }
}
