package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.ni6;
import defpackage.yk6;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: wk6  reason: default package */
/* compiled from: Http2ExchangeCodec.kt */
public final class wk6 implements bk6 {
    public static final List<String> g = vi6.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List<String> h = vi6.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    public volatile yk6 f3796a;
    public final ii6 b;
    public volatile boolean c;
    public final sj6 d;
    public final ek6 e;
    public final pk6 f;

    public wk6(hi6 hi6, sj6 sj6, ek6 ek6, pk6 pk6) {
        n86.f(hi6, "client");
        n86.f(sj6, "connection");
        n86.f(ek6, "chain");
        n86.f(pk6, "http2Connection");
        this.d = sj6;
        this.e = ek6;
        this.f = pk6;
        List<ii6> list = hi6.y;
        ii6 ii6 = ii6.H2_PRIOR_KNOWLEDGE;
        this.b = !list.contains(ii6) ? ii6.HTTP_2 : ii6;
    }

    @Override // defpackage.bk6
    public void a() {
        yk6 yk6 = this.f3796a;
        if (yk6 != null) {
            ((yk6.a) yk6.g()).close();
        } else {
            n86.k();
            throw null;
        }
    }

    @Override // defpackage.bk6
    public void b(ji6 ji6) {
        int i;
        yk6 yk6;
        n86.f(ji6, "request");
        if (this.f3796a == null) {
            boolean z = false;
            boolean z2 = ji6.e != null;
            n86.f(ji6, "request");
            ci6 ci6 = ji6.d;
            ArrayList arrayList = new ArrayList(ci6.size() + 4);
            arrayList.add(new mk6(mk6.f, ji6.c));
            zm6 zm6 = mk6.g;
            di6 di6 = ji6.b;
            n86.f(di6, "url");
            String b2 = di6.b();
            String d2 = di6.d();
            if (d2 != null) {
                b2 = b2 + '?' + d2;
            }
            arrayList.add(new mk6(zm6, b2));
            String b3 = ji6.b("Host");
            if (b3 != null) {
                arrayList.add(new mk6(mk6.i, b3));
            }
            arrayList.add(new mk6(mk6.h, ji6.b.b));
            int size = ci6.size();
            for (int i2 = 0; i2 < size; i2++) {
                String d3 = ci6.d(i2);
                Locale locale = Locale.US;
                n86.b(locale, "Locale.US");
                if (d3 != null) {
                    String lowerCase = d3.toLowerCase(locale);
                    n86.b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (!g.contains(lowerCase) || (n86.a(lowerCase, "te") && n86.a(ci6.n(i2), "trailers"))) {
                        arrayList.add(new mk6(lowerCase, ci6.n(i2)));
                    }
                } else {
                    throw new p56("null cannot be cast to non-null type java.lang.String");
                }
            }
            pk6 pk6 = this.f;
            Objects.requireNonNull(pk6);
            n86.f(arrayList, "requestHeaders");
            boolean z3 = !z2;
            synchronized (pk6.E) {
                synchronized (pk6) {
                    if (pk6.k > 1073741823) {
                        pk6.h(lk6.REFUSED_STREAM);
                    }
                    if (!pk6.l) {
                        i = pk6.k;
                        pk6.k = i + 2;
                        yk6 = new yk6(i, pk6, z3, false, null);
                        if (!z2 || pk6.B >= pk6.C || yk6.c >= yk6.d) {
                            z = true;
                        }
                        if (yk6.i()) {
                            pk6.h.put(Integer.valueOf(i), yk6);
                        }
                    } else {
                        throw new kk6();
                    }
                }
                pk6.E.g(z3, i, arrayList);
            }
            if (z) {
                pk6.E.flush();
            }
            this.f3796a = yk6;
            if (this.c) {
                yk6 yk62 = this.f3796a;
                if (yk62 == null) {
                    n86.k();
                    throw null;
                } else {
                    yk62.e(lk6.CANCEL);
                    throw new IOException("Canceled");
                }
            } else {
                yk6 yk63 = this.f3796a;
                if (yk63 != null) {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    yk63.i.g((long) this.e.h, timeUnit);
                    yk6 yk64 = this.f3796a;
                    if (yk64 != null) {
                        yk64.j.g((long) this.e.i, timeUnit);
                    } else {
                        n86.k();
                        throw null;
                    }
                } else {
                    n86.k();
                    throw null;
                }
            }
        }
    }

    @Override // defpackage.bk6
    public qn6 c(ni6 ni6) {
        n86.f(ni6, "response");
        yk6 yk6 = this.f3796a;
        if (yk6 != null) {
            return yk6.g;
        }
        n86.k();
        throw null;
    }

    @Override // defpackage.bk6
    public void cancel() {
        this.c = true;
        yk6 yk6 = this.f3796a;
        if (yk6 != null) {
            yk6.e(lk6.CANCEL);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.bk6
    public ni6.a d(boolean z) {
        ci6 ci6;
        yk6 yk6 = this.f3796a;
        if (yk6 != null) {
            synchronized (yk6) {
                yk6.i.i();
                while (yk6.e.isEmpty() && yk6.k == null) {
                    try {
                        yk6.l();
                    } catch (Throwable th) {
                        yk6.i.m();
                        throw th;
                    }
                }
                yk6.i.m();
                if (!yk6.e.isEmpty()) {
                    ci6 removeFirst = yk6.e.removeFirst();
                    n86.b(removeFirst, "headersQueue.removeFirst()");
                    ci6 = removeFirst;
                } else {
                    Throwable th2 = yk6.l;
                    if (th2 == null) {
                        lk6 lk6 = yk6.k;
                        if (lk6 == null) {
                            n86.k();
                            throw null;
                        }
                        th2 = new el6(lk6);
                    }
                    throw th2;
                }
            }
            ii6 ii6 = this.b;
            n86.f(ci6, "headerBlock");
            n86.f(ii6, "protocol");
            ArrayList arrayList = new ArrayList(20);
            int size = ci6.size();
            hk6 hk6 = null;
            for (int i = 0; i < size; i++) {
                String d2 = ci6.d(i);
                String n = ci6.n(i);
                if (n86.a(d2, ":status")) {
                    hk6 = hk6.a("HTTP/1.1 " + n);
                } else if (!h.contains(d2)) {
                    n86.f(d2, "name");
                    n86.f(n, FirebaseAnalytics.Param.VALUE);
                    arrayList.add(d2);
                    arrayList.add(ea6.K(n).toString());
                }
            }
            if (hk6 != null) {
                ni6.a aVar = new ni6.a();
                aVar.f(ii6);
                aVar.c = hk6.b;
                aVar.e(hk6.c);
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    aVar.d(new ci6((String[]) array, null));
                    if (!z || aVar.c != 100) {
                        return aVar;
                    }
                    return null;
                }
                throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
        n86.k();
        throw null;
    }

    @Override // defpackage.bk6
    public void e() {
        this.f.E.flush();
    }

    @Override // defpackage.bk6
    public long f(ni6 ni6) {
        n86.f(ni6, "response");
        if (!ck6.a(ni6)) {
            return 0;
        }
        return vi6.k(ni6);
    }

    @Override // defpackage.bk6
    public on6 g(ji6 ji6, long j) {
        n86.f(ji6, "request");
        yk6 yk6 = this.f3796a;
        if (yk6 != null) {
            return yk6.g();
        }
        n86.k();
        throw null;
    }

    @Override // defpackage.bk6
    public sj6 getConnection() {
        return this.d;
    }
}
