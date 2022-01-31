package defpackage;

import android.os.Bundle;
import java.util.Map;

/* renamed from: b64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class b64 extends a94 {
    public final Map<String, Long> b = new n2();
    public final Map<String, Integer> c = new n2();
    public long d;

    public b64(vb4 vb4) {
        super(vb4);
    }

    public final void s(long j) {
        je4 v = o().v(false);
        for (String str : this.b.keySet()) {
            v(str, j - this.b.get(str).longValue(), v);
        }
        if (!this.b.isEmpty()) {
            t(j - this.d, v);
        }
        w(j);
    }

    public final void t(long j, je4 je4) {
        if (je4 == null) {
            g().n.a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            g().n.b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            ie4.z(je4, bundle, true);
            k().G("am", "_xa", bundle);
        }
    }

    public final void u(String str, long j) {
        if (str == null || str.length() == 0) {
            g().f.a("Ad unit id must be a non-empty string");
        } else {
            f().u(new z74(this, str, j));
        }
    }

    public final void v(String str, long j, je4 je4) {
        if (je4 == null) {
            g().n.a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            g().n.b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            ie4.z(je4, bundle, true);
            k().G("am", "_xu", bundle);
        }
    }

    public final void w(long j) {
        for (String str : this.b.keySet()) {
            this.b.put(str, Long.valueOf(j));
        }
        if (!this.b.isEmpty()) {
            this.d = j;
        }
    }

    public final void x(String str, long j) {
        if (str == null || str.length() == 0) {
            g().f.a("Ad unit id must be a non-empty string");
        } else {
            f().u(new y64(this, str, j));
        }
    }
}
