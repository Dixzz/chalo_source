package defpackage;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: qj6  reason: default package */
/* compiled from: RealConnection.kt */
public final class qj6 extends o86 implements h76<List<? extends X509Certificate>> {
    public final /* synthetic */ sj6 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qj6(sj6 sj6) {
        super(0);
        this.f = sj6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public List<? extends X509Certificate> invoke() {
        bi6 bi6 = this.f.d;
        if (bi6 != null) {
            List<Certificate> c = bi6.c();
            ArrayList arrayList = new ArrayList(hd3.I(c, 10));
            for (T t : c) {
                if (t != null) {
                    arrayList.add(t);
                } else {
                    throw new p56("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
            }
            return arrayList;
        }
        n86.k();
        throw null;
    }
}
