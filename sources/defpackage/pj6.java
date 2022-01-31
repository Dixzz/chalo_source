package defpackage;

import java.security.cert.Certificate;
import java.util.List;

/* renamed from: pj6  reason: default package */
/* compiled from: RealConnection.kt */
public final class pj6 extends o86 implements h76<List<? extends Certificate>> {
    public final /* synthetic */ kh6 f;
    public final /* synthetic */ bi6 g;
    public final /* synthetic */ dh6 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public pj6(kh6 kh6, bi6 bi6, dh6 dh6) {
        super(0);
        this.f = kh6;
        this.g = bi6;
        this.h = dh6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public List<? extends Certificate> invoke() {
        em6 em6 = this.f.b;
        if (em6 != null) {
            return em6.a(this.g.c(), this.h.f839a.e);
        }
        n86.k();
        throw null;
    }
}
