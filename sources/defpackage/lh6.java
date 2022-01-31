package defpackage;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: lh6  reason: default package */
/* compiled from: CertificatePinner.kt */
public final class lh6 extends o86 implements h76<List<? extends X509Certificate>> {
    public final /* synthetic */ kh6 f;
    public final /* synthetic */ List g;
    public final /* synthetic */ String h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public lh6(kh6 kh6, List list, String str) {
        super(0);
        this.f = kh6;
        this.g = list;
        this.h = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public List<? extends X509Certificate> invoke() {
        List<Certificate> list;
        em6 em6 = this.f.b;
        if (em6 == null || (list = em6.a(this.g, this.h)) == null) {
            list = this.g;
        }
        ArrayList arrayList = new ArrayList(hd3.I(list, 10));
        for (T t : list) {
            if (t != null) {
                arrayList.add(t);
            } else {
                throw new p56("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        return arrayList;
    }
}
