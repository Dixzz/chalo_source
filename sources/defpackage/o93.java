package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: o93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class o93 {

    /* renamed from: a  reason: collision with root package name */
    public final n93 f2666a;

    public o93(n93 n93) {
        Charset charset = ka3.f2038a;
        this.f2666a = n93;
        n93.f2524a = this;
    }

    public final void a(int i, float f) throws IOException {
        this.f2666a.n(i, Float.floatToRawIntBits(f));
    }

    public final void b(int i, double d) throws IOException {
        this.f2666a.q(i, Double.doubleToRawLongBits(d));
    }

    public final void c(int i, int i2) throws IOException {
        this.f2666a.m(i, n93.g(i2));
    }

    public final void d(int i, long j) throws IOException {
        this.f2666a.o(i, n93.h(j));
    }

    public final void e(int i, Object obj, mm2 mm2) throws IOException {
        this.f2666a.u(i, (bm2) obj, mm2);
    }

    public final void f(int i, Object obj, mm2 mm2) throws IOException {
        n93 n93 = this.f2666a;
        n93.k(i, 3);
        mm2.i((bm2) obj, n93.f2524a);
        n93.k(i, 4);
    }
}
