package defpackage;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* renamed from: dm6  reason: default package */
/* compiled from: BasicTrustRootIndex.kt */
public final class dm6 implements gm6 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<X500Principal, Set<X509Certificate>> f858a;

    public dm6(X509Certificate... x509CertificateArr) {
        n86.f(x509CertificateArr, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            n86.b(subjectX500Principal, "caCert.subjectX500Principal");
            Object obj = linkedHashMap.get(subjectX500Principal);
            if (obj == null) {
                obj = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, obj);
            }
            ((Set) obj).add(x509Certificate);
        }
        this.f858a = linkedHashMap;
    }

    @Override // defpackage.gm6
    public X509Certificate a(X509Certificate x509Certificate) {
        boolean z;
        n86.f(x509Certificate, "cert");
        Set<X509Certificate> set = this.f858a.get(x509Certificate.getIssuerX500Principal());
        T t = null;
        if (set == null) {
            return null;
        }
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            try {
                x509Certificate.verify(next.getPublicKey());
                z = true;
                continue;
            } catch (Exception unused) {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        return t;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof dm6) && n86.a(((dm6) obj).f858a, this.f858a));
    }

    public int hashCode() {
        return this.f858a.hashCode();
    }
}
