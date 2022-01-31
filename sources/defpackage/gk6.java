package defpackage;

import com.google.firebase.perf.FirebasePerformance;
import defpackage.di6;
import defpackage.ji6;
import defpackage.wj6;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: gk6  reason: default package */
/* compiled from: RetryAndFollowUpInterceptor.kt */
public final class gk6 implements ei6 {

    /* renamed from: a  reason: collision with root package name */
    public final hi6 f1275a;

    public gk6(hi6 hi6) {
        n86.f(hi6, "client");
        this.f1275a = hi6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // defpackage.ei6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.ni6 a(defpackage.ei6.a r49) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 780
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gk6.a(ei6$a):ni6");
    }

    public final ji6 b(ni6 ni6, lj6 lj6) throws IOException {
        String c;
        sj6 sj6;
        mi6 mi6 = null;
        pi6 pi6 = (lj6 == null || (sj6 = lj6.b) == null) ? null : sj6.q;
        int i = ni6.j;
        ji6 ji6 = ni6.g;
        String str = ji6.c;
        boolean z = false;
        if (!(i == 307 || i == 308)) {
            if (i == 401) {
                return this.f1275a.l.a(pi6, ni6);
            }
            if (i == 421) {
                mi6 mi62 = ji6.e;
                if ((mi62 != null && mi62.isOneShot()) || lj6 == null || !(!n86.a(lj6.e.h.f839a.e, lj6.b.q.f2809a.f839a.e))) {
                    return null;
                }
                sj6 sj62 = lj6.b;
                synchronized (sj62) {
                    sj62.j = true;
                }
                return ni6.g;
            } else if (i == 503) {
                ni6 ni62 = ni6.p;
                if ((ni62 == null || ni62.j != 503) && d(ni6, Integer.MAX_VALUE) == 0) {
                    return ni6.g;
                }
                return null;
            } else if (i != 407) {
                if (i != 408) {
                    switch (i) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (!this.f1275a.k) {
                    return null;
                } else {
                    mi6 mi63 = ji6.e;
                    if (mi63 != null && mi63.isOneShot()) {
                        return null;
                    }
                    ni6 ni63 = ni6.p;
                    if ((ni63 == null || ni63.j != 408) && d(ni6, 0) <= 0) {
                        return ni6.g;
                    }
                    return null;
                }
            } else if (pi6 == null) {
                n86.k();
                throw null;
            } else if (pi6.b.type() == Proxy.Type.HTTP) {
                return this.f1275a.t.a(pi6, ni6);
            } else {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
        }
        if (!this.f1275a.m || (c = ni6.c(ni6, "Location", null, 2)) == null) {
            return null;
        }
        di6 di6 = ni6.g.b;
        Objects.requireNonNull(di6);
        n86.f(c, "link");
        di6.a g = di6.g(c);
        di6 c2 = g != null ? g.c() : null;
        if (c2 == null) {
            return null;
        }
        if (!n86.a(c2.b, ni6.g.b.b) && !this.f1275a.n) {
            return null;
        }
        ji6.a aVar = new ji6.a(ni6.g);
        if (dk6.a(str)) {
            int i2 = ni6.j;
            n86.f(str, "method");
            if (n86.a(str, "PROPFIND") || i2 == 308 || i2 == 307) {
                z = true;
            }
            n86.f(str, "method");
            if (!(!n86.a(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                if (z) {
                    mi6 = ni6.g.e;
                }
                aVar.f(str, mi6);
            } else {
                aVar.f(FirebasePerformance.HttpMethod.GET, null);
            }
            if (!z) {
                aVar.g("Transfer-Encoding");
                aVar.g("Content-Length");
                aVar.g("Content-Type");
            }
        }
        if (!vi6.a(ni6.g.b, c2)) {
            aVar.g("Authorization");
        }
        aVar.j(c2);
        return aVar.b();
    }

    public final boolean c(IOException iOException, nj6 nj6, ji6 ji6, boolean z) {
        boolean z2;
        wj6 wj6;
        sj6 sj6;
        if (!this.f1275a.k) {
            return false;
        }
        if (z) {
            mi6 mi6 = ji6.e;
            if ((mi6 != null && mi6.isOneShot()) || (iOException instanceof FileNotFoundException)) {
                return false;
            }
        }
        if (!(!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) : (iOException instanceof SocketTimeoutException) && !z))) {
            return false;
        }
        mj6 mj6 = nj6.k;
        pi6 pi6 = null;
        if (mj6 != null) {
            int i = mj6.c;
            if (i == 0 && mj6.d == 0 && mj6.e == 0) {
                z2 = false;
            } else {
                if (mj6.f == null) {
                    if (i <= 1 && mj6.d <= 1 && mj6.e <= 0 && (sj6 = mj6.i.l) != null) {
                        synchronized (sj6) {
                            if (sj6.k == 0) {
                                if (vi6.a(sj6.q.f2809a.f839a, mj6.h.f839a)) {
                                    pi6 = sj6.q;
                                }
                            }
                        }
                    }
                    if (pi6 != null) {
                        mj6.f = pi6;
                    } else {
                        wj6.a aVar = mj6.f2387a;
                        if ((aVar == null || !aVar.a()) && (wj6 = mj6.b) != null) {
                            z2 = wj6.a();
                        }
                    }
                }
                z2 = true;
            }
            return z2;
        }
        n86.k();
        throw null;
    }

    public final int d(ni6 ni6, int i) {
        String c = ni6.c(ni6, "Retry-After", null, 2);
        if (c == null) {
            return i;
        }
        n86.e("\\d+", "pattern");
        Pattern compile = Pattern.compile("\\d+");
        n86.d(compile, "Pattern.compile(pattern)");
        n86.e(compile, "nativePattern");
        n86.e(c, "input");
        if (!compile.matcher(c).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(c);
        n86.b(valueOf, "Integer.valueOf(header)");
        return valueOf.intValue();
    }
}
