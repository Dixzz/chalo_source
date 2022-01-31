package defpackage;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: cm6  reason: default package */
/* compiled from: BasicCertificateChainCleaner.kt */
public final class cm6 extends em6 {

    /* renamed from: a  reason: collision with root package name */
    public final gm6 f583a;

    public cm6(gm6 gm6) {
        n86.f(gm6, "trustRootIndex");
        this.f583a = gm6;
    }

    @Override // defpackage.em6
    public List<Certificate> a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        n86.f(list, "chain");
        n86.f(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        n86.b(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj != null) {
                X509Certificate x509Certificate = (X509Certificate) obj;
                X509Certificate a2 = this.f583a.a(x509Certificate);
                if (a2 != null) {
                    if (arrayList.size() > 1 || (!n86.a(x509Certificate, a2))) {
                        arrayList.add(a2);
                    }
                    if (b(a2, a2)) {
                        return arrayList;
                    }
                    z = true;
                } else {
                    Iterator it = arrayDeque.iterator();
                    n86.b(it, "queue.iterator()");
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next != null) {
                            X509Certificate x509Certificate2 = (X509Certificate) next;
                            if (b(x509Certificate, x509Certificate2)) {
                                it.remove();
                                arrayList.add(x509Certificate2);
                            }
                        } else {
                            throw new p56("null cannot be cast to non-null type java.security.cert.X509Certificate");
                        }
                    }
                    if (z) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
            } else {
                throw new p56("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!n86.a(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof cm6) && n86.a(((cm6) obj).f583a, this.f583a);
    }

    public int hashCode() {
        return this.f583a.hashCode();
    }
}
