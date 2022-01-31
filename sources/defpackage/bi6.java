package defpackage;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: bi6  reason: default package */
/* compiled from: Handshake.kt */
public final class bi6 {

    /* renamed from: a  reason: collision with root package name */
    public final j56 f435a;
    public final qi6 b;
    public final nh6 c;
    public final List<Certificate> d;

    /* renamed from: bi6$a */
    /* compiled from: Handshake.kt */
    public static final class a extends o86 implements h76<List<? extends Certificate>> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h76 h76) {
            super(0);
            this.f = h76;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public List<? extends Certificate> invoke() {
            try {
                return (List) this.f.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return b66.f;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends java.security.cert.Certificate> */
    /* JADX WARN: Multi-variable type inference failed */
    public bi6(qi6 qi6, nh6 nh6, List<? extends Certificate> list, h76<? extends List<? extends Certificate>> h76) {
        n86.f(qi6, "tlsVersion");
        n86.f(nh6, "cipherSuite");
        n86.f(list, "localCertificates");
        n86.f(h76, "peerCertificatesFn");
        this.b = qi6;
        this.c = nh6;
        this.d = list;
        this.f435a = hd3.a2(new a(h76));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final defpackage.bi6 a(javax.net.ssl.SSLSession r5) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi6.a(javax.net.ssl.SSLSession):bi6");
    }

    public final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        n86.b(type, "type");
        return type;
    }

    public final List<Certificate> c() {
        return (List) this.f435a.getValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof bi6) {
            bi6 bi6 = (bi6) obj;
            return bi6.b == this.b && n86.a(bi6.c, this.c) && n86.a(bi6.c(), c()) && n86.a(bi6.d, this.d);
        }
    }

    public int hashCode() {
        int hashCode = this.c.hashCode();
        int hashCode2 = c().hashCode();
        return this.d.hashCode() + ((hashCode2 + ((hashCode + ((this.b.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public String toString() {
        List<Certificate> c2 = c();
        ArrayList arrayList = new ArrayList(hd3.I(c2, 10));
        Iterator<T> it = c2.iterator();
        while (it.hasNext()) {
            arrayList.add(b(it.next()));
        }
        String obj = arrayList.toString();
        StringBuilder k0 = hj1.k0("Handshake{", "tlsVersion=");
        k0.append(this.b);
        k0.append(' ');
        k0.append("cipherSuite=");
        k0.append(this.c);
        k0.append(' ');
        k0.append("peerCertificates=");
        k0.append(obj);
        k0.append(' ');
        k0.append("localCertificates=");
        List<Certificate> list = this.d;
        ArrayList arrayList2 = new ArrayList(hd3.I(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b(it2.next()));
        }
        k0.append(arrayList2);
        k0.append('}');
        return k0.toString();
    }
}
