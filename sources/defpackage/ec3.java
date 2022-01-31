package defpackage;

import android.os.RemoteException;
import java.util.Collections;
import java.util.Objects;

/* renamed from: ec3  reason: default package */
public final class ec3 extends yb3 {
    public final gc3 h = new gc3(this);
    public od3 i;
    public final cd3 j;
    public final ee3 k;

    public ec3(ac3 ac3) {
        super(ac3);
        this.k = new ee3(ac3.c);
        this.j = new fc3(this, ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
    }

    public final void i0() {
        jz1.c();
        g0();
        try {
            za2.b().c(this.f.f146a, this.h);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.i != null) {
            this.i = null;
            sb3 A = A();
            A.g0();
            jz1.c();
            mc3 mc3 = A.h;
            jz1.c();
            mc3.g0();
            mc3.M("Service disconnected");
        }
    }

    public final boolean j0() {
        jz1.c();
        g0();
        return this.i != null;
    }

    public final boolean m0(nd3 nd3) {
        String str;
        Objects.requireNonNull(nd3, "null reference");
        jz1.c();
        g0();
        od3 od3 = this.i;
        if (od3 == null) {
            return false;
        }
        if (nd3.f) {
            str = ad3.d();
        } else {
            str = ad3.e();
        }
        try {
            od3.x2(nd3.f2542a, nd3.d, str, Collections.emptyList());
            o0();
            return true;
        } catch (RemoteException unused) {
            M("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final void o0() {
        this.k.a();
        this.j.e(id3.z.f1906a.longValue());
    }
}
