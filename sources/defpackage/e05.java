package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: e05  reason: default package */
/* compiled from: CodedOutputStreamWriter */
public final class e05 implements n25 {

    /* renamed from: a  reason: collision with root package name */
    public final d05 f912a;

    public e05(d05 d05) {
        Charset charset = s05.f3160a;
        this.f912a = d05;
        d05.f774a = this;
    }

    public void a(int i, double d) throws IOException {
        d05 d05 = this.f912a;
        Objects.requireNonNull(d05);
        d05.M(i, Double.doubleToRawLongBits(d));
    }

    public void b(int i, float f) throws IOException {
        d05 d05 = this.f912a;
        Objects.requireNonNull(d05);
        d05.K(i, Float.floatToRawIntBits(f));
    }

    public void c(int i, Object obj, x15 x15) throws IOException {
        d05 d05 = this.f912a;
        d05.W(i, 3);
        x15.h((j15) obj, d05.f774a);
        d05.W(i, 4);
    }

    public void d(int i, Object obj, x15 x15) throws IOException {
        this.f912a.Q(i, (j15) obj, x15);
    }

    public final void e(int i, Object obj) throws IOException {
        if (obj instanceof a05) {
            this.f912a.T(i, (a05) obj);
        } else {
            this.f912a.S(i, (j15) obj);
        }
    }

    public void f(int i, int i2) throws IOException {
        this.f912a.X(i, d05.C(i2));
    }

    public void g(int i, long j) throws IOException {
        this.f912a.Z(i, d05.D(j));
    }
}
