package defpackage;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;

/* renamed from: ua4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ua4 implements Runnable {
    public final /* synthetic */ int f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ ra4 k;

    public ua4(ra4 ra4, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.k = ra4;
        this.f = i2;
        this.g = str;
        this.h = obj;
        this.i = obj2;
        this.j = obj3;
    }

    public final void run() {
        eb4 n = this.k.f3331a.n();
        if (!n.k()) {
            this.k.u(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        ra4 ra4 = this.k;
        boolean z = true;
        if (ra4.c == 0) {
            d64 d64 = ra4.f3331a.g;
            if (d64.d == null) {
                synchronized (d64) {
                    if (d64.d == null) {
                        ApplicationInfo applicationInfo = d64.f3331a.f3627a.getApplicationInfo();
                        String a2 = gb2.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            d64.d = Boolean.valueOf(str != null && str.equals(a2));
                        }
                        if (d64.d == null) {
                            d64.d = Boolean.TRUE;
                            d64.g().f.a("My process not in the list of running processes");
                        }
                    }
                }
            }
            if (d64.d.booleanValue()) {
                this.k.c = 'C';
            } else {
                this.k.c = 'c';
            }
        }
        ra4 ra42 = this.k;
        if (ra42.d < 0) {
            ra42.d = 33025;
        }
        char charAt = "01VDIWEA?".charAt(this.f);
        ra4 ra43 = this.k;
        char c = ra43.c;
        long j2 = ra43.d;
        String t = ra4.t(true, this.g, this.h, this.i, this.j);
        StringBuilder sb = new StringBuilder(String.valueOf(t).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(c);
        sb.append(j2);
        sb.append(ProductDiscountsObject.KEY_DELIMITER);
        sb.append(t);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.g.substring(0, 1024);
        }
        lb4 lb4 = n.d;
        lb4.e.b();
        if (lb4.e.v().getLong(lb4.f2197a, 0) == 0) {
            lb4.a();
        }
        if (sb2 == null) {
            sb2 = "";
        }
        long j3 = lb4.e.v().getLong(lb4.b, 0);
        if (j3 <= 0) {
            SharedPreferences.Editor edit = lb4.e.v().edit();
            edit.putString(lb4.c, sb2);
            edit.putLong(lb4.b, 1);
            edit.apply();
            return;
        }
        long j4 = j3 + 1;
        if ((lb4.e.h().u0().nextLong() & Long.MAX_VALUE) >= Long.MAX_VALUE / j4) {
            z = false;
        }
        SharedPreferences.Editor edit2 = lb4.e.v().edit();
        if (z) {
            edit2.putString(lb4.c, sb2);
        }
        edit2.putLong(lb4.b, j4);
        edit2.apply();
    }
}
