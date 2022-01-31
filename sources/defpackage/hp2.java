package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: hp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class hp2 extends do2<es2, bs2> {
    public final /* synthetic */ ip2 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hp2(ip2 ip2, Class cls) {
        super(cls);
        this.b = ip2;
    }

    public static final bs2 d(es2 es2) throws GeneralSecurityException {
        as2 w = bs2.w();
        hs2 s = es2.s();
        if (w.h) {
            w.a();
            w.h = false;
        }
        bs2.A((bs2) w.g, s);
        byte[] a2 = lx2.a(es2.t());
        g93 A = g93.A(a2, 0, a2.length);
        if (w.h) {
            w.a();
            w.h = false;
        }
        bs2.B((bs2) w.g, A);
        if (w.h) {
            w.a();
            w.h = false;
        }
        ((bs2) w.g).zzb = 0;
        return (bs2) w.c();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final void a(es2 es2) throws GeneralSecurityException {
        es2 es22 = es2;
        mx2.a(es22.t());
        ip2.i(es22.s());
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ es2 b(g93 g93) throws ma3 {
        return es2.u(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ bs2 c(es2 es2) throws GeneralSecurityException {
        return d(es2);
    }
}
