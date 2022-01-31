package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: du3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class du3 implements wx3 {

    /* renamed from: a  reason: collision with root package name */
    public final bu3 f889a;

    public du3(bu3 bu3) {
        Charset charset = tu3.f3407a;
        this.f889a = bu3;
        bu3.f475a = this;
    }

    public final void a(int i, double d) throws IOException {
        bu3 bu3 = this.f889a;
        Objects.requireNonNull(bu3);
        bu3.z(i, Double.doubleToRawLongBits(d));
    }

    public final void b(int i, float f) throws IOException {
        bu3 bu3 = this.f889a;
        Objects.requireNonNull(bu3);
        bu3.G(i, Float.floatToRawIntBits(f));
    }

    public final void c(int i, Object obj) throws IOException {
        if (obj instanceof qt3) {
            this.f889a.t(i, (qt3) obj);
        } else {
            this.f889a.i(i, (cw3) obj);
        }
    }

    public final void d(int i, Object obj, qw3 qw3) throws IOException {
        this.f889a.j(i, (cw3) obj, qw3);
    }

    public final void e(int i, Object obj, qw3 qw3) throws IOException {
        bu3 bu3 = this.f889a;
        bu3.f(i, 3);
        qw3.e((cw3) obj, bu3.f475a);
        bu3.f(i, 4);
    }

    public final void f(int i, long j) throws IOException {
        this.f889a.g(i, bu3.R(j));
    }

    public final void g(int i, int i2) throws IOException {
        this.f889a.y(i, bu3.V(i2));
    }
}
