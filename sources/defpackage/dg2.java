package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: dg2  reason: default package */
public final class dg2 implements xj2 {

    /* renamed from: a  reason: collision with root package name */
    public final bg2 f832a;

    public dg2(bg2 bg2) {
        Charset charset = wg2.f3775a;
        this.f832a = bg2;
        bg2.f427a = this;
    }

    public final void a(int i, double d) throws IOException {
        bg2 bg2 = this.f832a;
        Objects.requireNonNull(bg2);
        bg2.B(i, Double.doubleToRawLongBits(d));
    }

    public final void b(int i, float f) throws IOException {
        bg2 bg2 = this.f832a;
        Objects.requireNonNull(bg2);
        bg2.I(i, Float.floatToRawIntBits(f));
    }

    public final void c(int i, Object obj) throws IOException {
        if (obj instanceof uf2) {
            this.f832a.q(i, (uf2) obj);
        } else {
            this.f832a.r(i, (zh2) obj);
        }
    }

    public final void d(int i, Object obj, pi2 pi2) throws IOException {
        this.f832a.h(i, (zh2) obj, pi2);
    }

    public final void e(int i, long j) throws IOException {
        this.f832a.e(i, bg2.R(j));
    }

    public final void f(int i, Object obj, pi2 pi2) throws IOException {
        bg2 bg2 = this.f832a;
        bg2.p(i, 3);
        pi2.h((zh2) obj, bg2.f427a);
        bg2.p(i, 4);
    }

    public final void g(int i, int i2) throws IOException {
        this.f832a.D(i, bg2.b0(i2));
    }
}
