package defpackage;

import defpackage.ci6;
import java.io.Closeable;
import java.util.Objects;

/* renamed from: ni6  reason: default package */
/* compiled from: Response.kt */
public final class ni6 implements Closeable {
    public hh6 f;
    public final ji6 g;
    public final ii6 h;
    public final String i;
    public final int j;
    public final bi6 k;
    public final ci6 l;
    public final oi6 m;
    public final ni6 n;
    public final ni6 o;
    public final ni6 p;
    public final long q;
    public final long r;
    public final lj6 s;

    public ni6(ji6 ji6, ii6 ii6, String str, int i2, bi6 bi6, ci6 ci6, oi6 oi6, ni6 ni6, ni6 ni62, ni6 ni63, long j2, long j3, lj6 lj6) {
        n86.f(ji6, "request");
        n86.f(ii6, "protocol");
        n86.f(str, "message");
        n86.f(ci6, "headers");
        this.g = ji6;
        this.h = ii6;
        this.i = str;
        this.j = i2;
        this.k = bi6;
        this.l = ci6;
        this.m = oi6;
        this.n = ni6;
        this.o = ni62;
        this.p = ni63;
        this.q = j2;
        this.r = j3;
        this.s = lj6;
    }

    public static String c(ni6 ni6, String str, String str2, int i2) {
        int i3 = i2 & 2;
        Objects.requireNonNull(ni6);
        n86.f(str, "name");
        String b = ni6.l.b(str);
        if (b != null) {
            return b;
        }
        return null;
    }

    public final hh6 a() {
        hh6 hh6 = this.f;
        if (hh6 != null) {
            return hh6;
        }
        hh6 b = hh6.o.b(this.l);
        this.f = b;
        return b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        oi6 oi6 = this.m;
        if (oi6 != null) {
            oi6.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final boolean e() {
        int i2 = this.j;
        return 200 <= i2 && 299 >= i2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Response{protocol=");
        i0.append(this.h);
        i0.append(", code=");
        i0.append(this.j);
        i0.append(", message=");
        i0.append(this.i);
        i0.append(", url=");
        i0.append(this.g.b);
        i0.append('}');
        return i0.toString();
    }

    /* renamed from: ni6$a */
    /* compiled from: Response.kt */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ji6 f2562a;
        public ii6 b;
        public int c;
        public String d;
        public bi6 e;
        public ci6.a f;
        public oi6 g;
        public ni6 h;
        public ni6 i;
        public ni6 j;
        public long k;
        public long l;
        public lj6 m;

        public a() {
            this.c = -1;
            this.f = new ci6.a();
        }

        public ni6 a() {
            int i2 = this.c;
            if (i2 >= 0) {
                ji6 ji6 = this.f2562a;
                if (ji6 != null) {
                    ii6 ii6 = this.b;
                    if (ii6 != null) {
                        String str = this.d;
                        if (str != null) {
                            return new ni6(ji6, ii6, str, i2, this.e, this.f.d(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            StringBuilder i0 = hj1.i0("code < 0: ");
            i0.append(this.c);
            throw new IllegalStateException(i0.toString().toString());
        }

        public a b(ni6 ni6) {
            c("cacheResponse", ni6);
            this.i = ni6;
            return this;
        }

        public final void c(String str, ni6 ni6) {
            if (ni6 != null) {
                boolean z = false;
                if (ni6.m == null) {
                    if (ni6.n == null) {
                        if (ni6.o == null) {
                            if (ni6.p == null) {
                                z = true;
                            }
                            if (!z) {
                                throw new IllegalArgumentException(hj1.S(str, ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException(hj1.S(str, ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException(hj1.S(str, ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException(hj1.S(str, ".body != null").toString());
            }
        }

        public a d(ci6 ci6) {
            n86.f(ci6, "headers");
            this.f = ci6.e();
            return this;
        }

        public a e(String str) {
            n86.f(str, "message");
            this.d = str;
            return this;
        }

        public a f(ii6 ii6) {
            n86.f(ii6, "protocol");
            this.b = ii6;
            return this;
        }

        public a g(ji6 ji6) {
            n86.f(ji6, "request");
            this.f2562a = ji6;
            return this;
        }

        public a(ni6 ni6) {
            n86.f(ni6, "response");
            this.c = -1;
            this.f2562a = ni6.g;
            this.b = ni6.h;
            this.c = ni6.j;
            this.d = ni6.i;
            this.e = ni6.k;
            this.f = ni6.l.e();
            this.g = ni6.m;
            this.h = ni6.n;
            this.i = ni6.o;
            this.j = ni6.p;
            this.k = ni6.q;
            this.l = ni6.r;
            this.m = ni6.s;
        }
    }
}
