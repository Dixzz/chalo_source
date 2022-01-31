package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.ci6;
import defpackage.ei6;
import defpackage.lj6;
import defpackage.ni6;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;

/* renamed from: zj6  reason: default package */
/* compiled from: CallServerInterceptor.kt */
public final class zj6 implements ei6 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4185a;

    public zj6(boolean z) {
        this.f4185a = z;
    }

    @Override // defpackage.ei6
    public ni6 a(ei6.a aVar) throws IOException {
        boolean z;
        ni6.a aVar2;
        int i;
        ni6 ni6;
        n86.f(aVar, "chain");
        ek6 ek6 = (ek6) aVar;
        lj6 lj6 = ek6.e;
        if (lj6 != null) {
            ji6 ji6 = ek6.f;
            mi6 mi6 = ji6.e;
            long currentTimeMillis = System.currentTimeMillis();
            n86.f(ji6, "request");
            try {
                xh6 xh6 = lj6.d;
                nj6 nj6 = lj6.c;
                Objects.requireNonNull(xh6);
                n86.f(nj6, AnalyticsConstants.CALL);
                lj6.f.b(ji6);
                xh6 xh62 = lj6.d;
                nj6 nj62 = lj6.c;
                Objects.requireNonNull(xh62);
                n86.f(nj62, AnalyticsConstants.CALL);
                n86.f(ji6, "request");
                if (!dk6.a(ji6.c) || mi6 == null) {
                    lj6.c.g(lj6, true, false, null);
                    z = true;
                    aVar2 = null;
                } else {
                    if (ea6.f("100-continue", ji6.b("Expect"), true)) {
                        lj6.c();
                        aVar2 = lj6.e(true);
                        lj6.f();
                        z = false;
                    } else {
                        z = true;
                        aVar2 = null;
                    }
                    if (aVar2 != null) {
                        lj6.c.g(lj6, true, false, null);
                        if (!lj6.b.j()) {
                            lj6.f.getConnection().l();
                        }
                    } else if (mi6.isDuplex()) {
                        lj6.c();
                        on6 b = lj6.b(ji6, true);
                        n86.f(b, "$this$buffer");
                        mi6.writeTo(new jn6(b));
                    } else {
                        on6 b2 = lj6.b(ji6, false);
                        n86.f(b2, "$this$buffer");
                        jn6 jn6 = new jn6(b2);
                        mi6.writeTo(jn6);
                        jn6.close();
                    }
                }
                if (mi6 == null || !mi6.isDuplex()) {
                    try {
                        lj6.f.a();
                    } catch (IOException e) {
                        xh6 xh63 = lj6.d;
                        nj6 nj63 = lj6.c;
                        Objects.requireNonNull(xh63);
                        n86.f(nj63, AnalyticsConstants.CALL);
                        n86.f(e, "ioe");
                        lj6.g(e);
                        throw e;
                    }
                }
                if (aVar2 == null) {
                    aVar2 = lj6.e(false);
                    if (aVar2 == null) {
                        n86.k();
                        throw null;
                    } else if (z) {
                        lj6.f();
                        z = false;
                    }
                }
                aVar2.g(ji6);
                aVar2.e = lj6.b.d;
                aVar2.k = currentTimeMillis;
                aVar2.l = System.currentTimeMillis();
                ni6 a2 = aVar2.a();
                int i2 = a2.j;
                if (i2 == 100) {
                    ni6.a e2 = lj6.e(false);
                    if (e2 != null) {
                        if (z) {
                            lj6.f();
                        }
                        e2.g(ji6);
                        e2.e = lj6.b.d;
                        e2.k = currentTimeMillis;
                        e2.l = System.currentTimeMillis();
                        a2 = e2.a();
                        i2 = a2.j;
                    } else {
                        n86.k();
                        throw null;
                    }
                }
                n86.f(a2, "response");
                xh6 xh64 = lj6.d;
                nj6 nj64 = lj6.c;
                Objects.requireNonNull(xh64);
                n86.f(nj64, AnalyticsConstants.CALL);
                n86.f(a2, "response");
                if (!this.f4185a || i2 != 101) {
                    i = i2;
                    n86.f(a2, "response");
                    ji6 ji62 = a2.g;
                    ii6 ii6 = a2.h;
                    int i3 = a2.j;
                    String str = a2.i;
                    bi6 bi6 = a2.k;
                    ci6.a e3 = a2.l.e();
                    ni6 ni62 = a2.n;
                    ni6 ni63 = a2.o;
                    ni6 ni64 = a2.p;
                    long j = a2.q;
                    long j2 = a2.r;
                    lj6 lj62 = a2.s;
                    n86.f(a2, "response");
                    try {
                        String c = ni6.c(a2, "Content-Type", null, 2);
                        long f = lj6.f.f(a2);
                        lj6.b bVar = new lj6.b(lj6, lj6.f.c(a2), f);
                        n86.f(bVar, "$this$buffer");
                        fk6 fk6 = new fk6(c, f, new kn6(bVar));
                        if (!(i3 >= 0)) {
                            throw new IllegalStateException(hj1.I("code < 0: ", i3).toString());
                        } else if (ji62 == null) {
                            throw new IllegalStateException("request == null".toString());
                        } else if (ii6 == null) {
                            throw new IllegalStateException("protocol == null".toString());
                        } else if (str != null) {
                            ni6 = new ni6(ji62, ii6, str, i3, bi6, e3.d(), fk6, ni62, ni63, ni64, j, j2, lj62);
                        } else {
                            throw new IllegalStateException("message == null".toString());
                        }
                    } catch (IOException e4) {
                        xh6 xh65 = lj6.d;
                        nj6 nj65 = lj6.c;
                        Objects.requireNonNull(xh65);
                        n86.f(nj65, AnalyticsConstants.CALL);
                        n86.f(e4, "ioe");
                        lj6.g(e4);
                        throw e4;
                    }
                } else {
                    n86.f(a2, "response");
                    ji6 ji63 = a2.g;
                    ii6 ii62 = a2.h;
                    int i4 = a2.j;
                    String str2 = a2.i;
                    bi6 bi62 = a2.k;
                    ci6.a e5 = a2.l.e();
                    ni6 ni65 = a2.n;
                    ni6 ni66 = a2.o;
                    ni6 ni67 = a2.p;
                    long j3 = a2.q;
                    i = i2;
                    long j4 = a2.r;
                    lj6 lj63 = a2.s;
                    oi6 oi6 = vi6.c;
                    if (!(i4 >= 0)) {
                        throw new IllegalStateException(hj1.I("code < 0: ", i4).toString());
                    } else if (ji63 == null) {
                        throw new IllegalStateException("request == null".toString());
                    } else if (ii62 == null) {
                        throw new IllegalStateException("protocol == null".toString());
                    } else if (str2 != null) {
                        ni6 = new ni6(ji63, ii62, str2, i4, bi62, e5.d(), oi6, ni65, ni66, ni67, j3, j4, lj63);
                    } else {
                        throw new IllegalStateException("message == null".toString());
                    }
                }
                if (ea6.f("close", ni6.g.b("Connection"), true) || ea6.f("close", ni6.c(ni6, "Connection", null, 2), true)) {
                    lj6.f.getConnection().l();
                }
                if (i == 204 || i == 205) {
                    oi6 oi62 = ni6.m;
                    if ((oi62 != null ? oi62.contentLength() : -1) > 0) {
                        StringBuilder j0 = hj1.j0("HTTP ", i, " had non-zero Content-Length: ");
                        oi6 oi63 = ni6.m;
                        j0.append(oi63 != null ? Long.valueOf(oi63.contentLength()) : null);
                        throw new ProtocolException(j0.toString());
                    }
                }
                return ni6;
            } catch (IOException e6) {
                xh6 xh66 = lj6.d;
                nj6 nj66 = lj6.c;
                Objects.requireNonNull(xh66);
                n86.f(nj66, AnalyticsConstants.CALL);
                n86.f(e6, "ioe");
                lj6.g(e6);
                throw e6;
            }
        } else {
            n86.k();
            throw null;
        }
    }
}
