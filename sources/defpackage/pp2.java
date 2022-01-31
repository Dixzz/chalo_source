package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: pp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class pp2 extends fo2<ts2> {
    public pp2() {
        super(ts2.class, new np2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ ts2 c(g93 g93) throws ma3 {
        return ts2.u(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(ts2 ts2) throws GeneralSecurityException {
        ts2 ts22 = ts2;
        mx2.b(ts22.s(), 0);
        mx2.a(ts22.t().e());
    }

    /* Return type fixed from 'do2<ws2, ts2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, ts2> g() {
        return new op2(this, ws2.class);
    }
}
