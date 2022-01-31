package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: kp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class kp2 extends do2<ns2, ks2> {
    public kp2(lp2 lp2, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ void a(ns2 ns2) throws GeneralSecurityException {
        ns2 ns22 = ns2;
        mx2.a(ns22.t());
        if (ns22.s().s() != 12 && ns22.s().s() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ ns2 b(g93 g93) throws ma3 {
        return ns2.u(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final ks2 c(ns2 ns2) throws GeneralSecurityException {
        ns2 ns22 = ns2;
        js2 w = ks2.w();
        byte[] a2 = lx2.a(ns22.t());
        g93 A = g93.A(a2, 0, a2.length);
        if (w.h) {
            w.a();
            w.h = false;
        }
        ks2.A((ks2) w.g, A);
        qs2 s = ns22.s();
        if (w.h) {
            w.a();
            w.h = false;
        }
        ks2.z((ks2) w.g, s);
        if (w.h) {
            w.a();
            w.h = false;
        }
        ((ks2) w.g).zzb = 0;
        return (ks2) w.c();
    }
}
