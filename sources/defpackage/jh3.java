package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: jh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class jh3 implements al3 {

    /* renamed from: a  reason: collision with root package name */
    public final hh3 f1925a;

    public jh3(hh3 hh3) {
        Charset charset = zh3.f4175a;
        this.f1925a = hh3;
        hh3.f1372a = this;
    }

    public final void a(int i, double d) throws IOException {
        hh3 hh3 = this.f1925a;
        Objects.requireNonNull(hh3);
        hh3.u(i, Double.doubleToRawLongBits(d));
    }

    public final void b(int i, float f) throws IOException {
        hh3 hh3 = this.f1925a;
        Objects.requireNonNull(hh3);
        hh3.B(i, Float.floatToRawIntBits(f));
    }

    public final void c(int i, Object obj) throws IOException {
        if (obj instanceof xg3) {
            this.f1925a.m(i, (xg3) obj);
        } else {
            this.f1925a.d(i, (gj3) obj);
        }
    }

    public final void d(int i, Object obj, sj3 sj3) throws IOException {
        this.f1925a.e(i, (gj3) obj, sj3);
    }

    public final void e(int i, long j) throws IOException {
        this.f1925a.b(i, hh3.J(j));
    }

    public final void f(int i, Object obj, sj3 sj3) throws IOException {
        hh3 hh3 = this.f1925a;
        hh3.l(i, 3);
        sj3.i((gj3) obj, hh3.f1372a);
        hh3.l(i, 4);
    }

    public final void g(int i, int i2) throws IOException {
        this.f1925a.w(i, hh3.U(i2));
    }
}
