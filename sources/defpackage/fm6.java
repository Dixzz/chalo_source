package defpackage;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* renamed from: fm6  reason: default package */
/* compiled from: OkHostnameVerifier.kt */
public final class fm6 implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final fm6 f1142a = new fm6();

    public final List<String> a(X509Certificate x509Certificate, int i) {
        b66 b66 = b66.f;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null) {
                        if (list.size() >= 2) {
                            if (!(!n86.a(list.get(0), Integer.valueOf(i)))) {
                                Object obj = list.get(1);
                                if (obj != null) {
                                    arrayList.add((String) obj);
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        } catch (CertificateParsingException unused) {
        }
        return b66;
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0139 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.String r13, java.security.cert.X509Certificate r14) {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fm6.b(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    public boolean verify(String str, SSLSession sSLSession) {
        n86.f(str, "host");
        n86.f(sSLSession, SettingsJsonConstants.SESSION_KEY);
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return b(str, (X509Certificate) certificate);
            }
            throw new p56("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
