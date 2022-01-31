package defpackage;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* renamed from: ql6  reason: default package */
/* compiled from: AndroidCertificateChainCleaner.kt */
public final class ql6 extends em6 {

    /* renamed from: a  reason: collision with root package name */
    public final X509TrustManager f2961a;
    public final X509TrustManagerExtensions b;

    public ql6(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        n86.f(x509TrustManager, "trustManager");
        n86.f(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f2961a = x509TrustManager;
        this.b = x509TrustManagerExtensions;
    }

    @Override // defpackage.em6
    public List<Certificate> a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        n86.f(list, "chain");
        n86.f(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        if (array != null) {
            try {
                List<X509Certificate> checkServerTrusted = this.b.checkServerTrusted((X509Certificate[]) array, "RSA", str);
                n86.b(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
                return checkServerTrusted;
            } catch (CertificateException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            }
        } else {
            throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ql6) && ((ql6) obj).f2961a == this.f2961a;
    }

    public int hashCode() {
        return System.identityHashCode(this.f2961a);
    }
}
