package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: sp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class sp2 extends fo2<zs2> {
    public sp2() {
        super(zs2.class, new qp2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ zs2 c(g93 g93) throws ma3 {
        return zs2.u(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(zs2 zs2) throws GeneralSecurityException {
        zs2 zs22 = zs2;
        mx2.b(zs22.s(), 0);
        mx2.a(zs22.t().e());
    }

    /* Return type fixed from 'do2<bt2, zs2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, zs2> g() {
        return new rp2(this, bt2.class);
    }
}
