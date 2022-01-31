package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.appindexing.Indexable;
import java.util.Map;
import java.util.Objects;

/* renamed from: e10  reason: default package */
/* compiled from: ChaloTimeFeature.kt */
public final class e10 implements g20 {
    public static final a l = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f913a;
    public final Map<String, String> b;
    public final Handler c = new Handler();
    public long d = 500;
    public int e = 5;
    public int f = Indexable.MAX_BYTE_SIZE;
    public long g = DefaultRefreshIntervals.ACTIVE_CONV_MIN_FETCH_INTERVAL;
    public long h = 259200000;
    public String i = "configuration/chalo-props/v1";
    public boolean j;
    public boolean k;

    /* renamed from: e10$a */
    /* compiled from: ChaloTimeFeature.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e10(android.content.Context r21) {
        /*
        // Method dump skipped, instructions count: 463
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e10.<init>(android.content.Context):void");
    }

    public static final boolean d(e10 e10, long j2, long j3) {
        Objects.requireNonNull(e10);
        if (j2 == -1) {
            ed1 l2 = hj1.l("fetched chaloTime invalid", Long.MIN_VALUE, "event description", "invalid reason default time");
            hj1.d(xt.f3961a.v().f, l2, "is foreground", l2);
            return false;
        } else if (SystemClock.elapsedRealtime() - j3 <= ((long) 2) * e10.g) {
            return true;
        } else {
            ed1 l3 = hj1.l("fetched chaloTime invalid", Long.MIN_VALUE, "event description", "request timed out");
            hj1.d(xt.f3961a.v().f, l3, "is foreground", l3);
            return false;
        }
    }

    public static final void e(e10 e10, long j2, long j3) {
        Objects.requireNonNull(e10);
        long elapsedRealtime = ((SystemClock.elapsedRealtime() - j3) / ((long) 2)) + j2;
        e10.b.put("keyCachedChaloTime", String.valueOf(elapsedRealtime));
        e10.b.put("keyCachedElapsedRealTime", String.valueOf(SystemClock.elapsedRealtime()));
        e10.b.put("keyCachedSystemTime", String.valueOf(System.currentTimeMillis()));
        e10.j = true;
        String j4 = n86.j("adjusted chalo time ", Long.valueOf(elapsedRealtime));
        ed1 ed1 = new ed1("chaloTime fetched valid", Long.MIN_VALUE);
        if (j4 != null) {
            ed1.a("event description", j4);
        }
        hj1.d(xt.f3961a.v().f, ed1, "is foreground", ed1);
    }

    @Override // defpackage.g20
    public void a() {
        if (!this.j && !this.k) {
            h(0);
        }
    }

    @Override // defpackage.g20
    public boolean b() {
        return (f() == -1 || g() == -1) ? false : true;
    }

    @Override // defpackage.g20
    public long c() {
        long f2 = f();
        long g2 = g();
        if (f2 == -1 || g2 == -1) {
            return System.currentTimeMillis();
        }
        return (SystemClock.elapsedRealtime() - g2) + f2;
    }

    public final long f() {
        String str = this.b.get("keyCachedChaloTime");
        Long valueOf = str == null ? null : Long.valueOf(Long.parseLong(str));
        if (valueOf != null) {
            return valueOf.longValue();
        }
        return -1;
    }

    public final long g() {
        String str = this.b.get("keyCachedElapsedRealTime");
        Long valueOf = str == null ? null : Long.valueOf(Long.parseLong(str));
        if (valueOf != null) {
            return valueOf.longValue();
        }
        return -1;
    }

    public final void h(int i2) {
        if (i2 >= this.e) {
            String j2 = n86.j("retry count", Integer.valueOf(i2));
            ed1 ed1 = new ed1("chaloTime max retries exceeded", Long.MIN_VALUE);
            if (j2 != null) {
                ed1.a("event description", j2);
            }
            hj1.d(xt.f3961a.v().f, ed1, "is foreground", ed1);
            this.k = false;
            return;
        }
        this.c.postDelayed(new e00(this, i2), ((long) i2) * this.d);
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "event");
        if (vn.K0(this.f913a) && !this.j && !this.k) {
            a();
        }
    }
}
