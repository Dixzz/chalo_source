package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: op2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class op2 extends do2<ws2, ts2> {
    public op2(pp2 pp2, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ void a(ws2 ws2) throws GeneralSecurityException {
        mx2.a(ws2.s());
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.do2
    public final /* bridge */ /* synthetic */ ws2 b(g93 g93) throws ma3 {
        return ws2.t(g93, s93.a());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.do2
    public final ts2 c(ws2 ws2) throws GeneralSecurityException {
        ss2 v = ts2.v();
        byte[] a2 = lx2.a(ws2.s());
        g93 A = g93.A(a2, 0, a2.length);
        if (v.h) {
            v.a();
            v.h = false;
        }
        ts2.y((ts2) v.g, A);
        if (v.h) {
            v.a();
            v.h = false;
        }
        ((ts2) v.g).zzb = 0;
        return (ts2) v.c();
    }
}
