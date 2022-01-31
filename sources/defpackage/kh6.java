package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.zm6;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: kh6  reason: default package */
/* compiled from: CertificatePinner.kt */
public final class kh6 {
    public static final kh6 c = new kh6(y56.D(new ArrayList()), null, 2);
    public static final a d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final Set<b> f2061a;
    public final em6 b;

    /* renamed from: kh6$a */
    /* compiled from: CertificatePinner.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final String a(Certificate certificate) {
            n86.f(certificate, "certificate");
            return "sha256/" + b((X509Certificate) certificate).a();
        }

        public final zm6 b(X509Certificate x509Certificate) {
            n86.f(x509Certificate, "$this$sha256Hash");
            zm6.a aVar = zm6.j;
            PublicKey publicKey = x509Certificate.getPublicKey();
            n86.b(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            n86.b(encoded, "publicKey.encoded");
            return zm6.a.d(aVar, encoded, 0, 0, 3).c("SHA-256");
        }
    }

    /* renamed from: kh6$b */
    /* compiled from: CertificatePinner.kt */
    public static final class b {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            Objects.requireNonNull(bVar);
            if (!n86.a(null, null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            if (!n86.a(null, null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            return !(n86.a(null, null) ^ true);
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((String) null);
            sb.append('/');
            throw null;
        }
    }

    public kh6(Set set, em6 em6, int i) {
        int i2 = i & 2;
        n86.f(set, "pins");
        this.f2061a = set;
        this.b = null;
    }

    public final void a(String str, h76<? extends List<? extends X509Certificate>> h76) {
        n86.f(str, "hostname");
        n86.f(h76, "cleanedPeerCertificatesFn");
        n86.f(str, "hostname");
        Set<b> set = this.f2061a;
        List<b> list = b66.f;
        for (T t : set) {
            Objects.requireNonNull(t);
            n86.f(str, "hostname");
            if (ea6.G(null, "**.", false, 2)) {
                throw null;
            } else if (ea6.G(null, "*.", false, 2)) {
                throw null;
            } else if (n86.a(str, null)) {
                if (list.isEmpty()) {
                    list = new ArrayList();
                }
                b96.a(list).add(t);
            }
        }
        if (!list.isEmpty()) {
            List<X509Certificate> list2 = (List) h76.invoke();
            for (X509Certificate x509Certificate : list2) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    Objects.requireNonNull((b) it.next());
                    throw null;
                }
            }
            StringBuilder k0 = hj1.k0("Certificate pinning failure!", "\n  Peer certificate chain:");
            for (X509Certificate x509Certificate2 : list2) {
                k0.append("\n    ");
                n86.f(x509Certificate2, "certificate");
                StringBuilder sb = new StringBuilder();
                sb.append("sha256/");
                n86.f(x509Certificate2, "$this$sha256Hash");
                zm6.a aVar = zm6.j;
                PublicKey publicKey = x509Certificate2.getPublicKey();
                n86.b(publicKey, "publicKey");
                byte[] encoded = publicKey.getEncoded();
                n86.b(encoded, "publicKey.encoded");
                sb.append(zm6.a.d(aVar, encoded, 0, 0, 3).c("SHA-256").a());
                k0.append(sb.toString());
                k0.append(": ");
                Principal subjectDN = x509Certificate2.getSubjectDN();
                n86.b(subjectDN, "element.subjectDN");
                k0.append(subjectDN.getName());
            }
            k0.append("\n  Pinned certificates for ");
            k0.append(str);
            k0.append(ProductDiscountsObject.KEY_DELIMITER);
            for (b bVar : list) {
                k0.append("\n    ");
                k0.append(bVar);
            }
            String sb2 = k0.toString();
            n86.b(sb2, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(sb2);
        }
    }

    public final kh6 b(em6 em6) {
        n86.f(em6, "certificateChainCleaner");
        return n86.a(this.b, em6) ? this : new kh6(this.f2061a, em6);
    }

    public boolean equals(Object obj) {
        if (obj instanceof kh6) {
            kh6 kh6 = (kh6) obj;
            return n86.a(kh6.f2061a, this.f2061a) && n86.a(kh6.b, this.b);
        }
    }

    public int hashCode() {
        int hashCode = (this.f2061a.hashCode() + 1517) * 41;
        em6 em6 = this.b;
        return hashCode + (em6 != null ? em6.hashCode() : 0);
    }

    public kh6(Set<b> set, em6 em6) {
        n86.f(set, "pins");
        this.f2061a = set;
        this.b = em6;
    }
}
