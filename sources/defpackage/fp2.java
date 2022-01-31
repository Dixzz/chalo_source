package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: fp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class fp2 extends fo2<vr2> {
    public fp2() {
        super(vr2.class, new dp2(vn2.class));
    }

    @Override // defpackage.fo2
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // defpackage.fo2
    public final wu2 b() {
        return wu2.SYMMETRIC;
    }

    /* Return type fixed from 'bm2' to match base method */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ vr2 c(g93 g93) throws ma3 {
        return vr2.v(g93, s93.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bm2] */
    @Override // defpackage.fo2
    public final /* bridge */ /* synthetic */ void d(vr2 vr2) throws GeneralSecurityException {
        vr2 vr22 = vr2;
        mx2.b(vr22.s(), 0);
        new ip2();
        ip2.h(vr22.t());
        new hr2();
        hr2.h(vr22.u());
    }

    /* Return type fixed from 'do2<yr2, vr2>' to match base method */
    @Override // defpackage.fo2
    public final do2<?, vr2> g() {
        return new ep2(this, yr2.class);
    }
}
