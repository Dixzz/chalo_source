package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: yb  reason: default package */
/* compiled from: CodedOutputStreamWriter */
public final class yb implements he {

    /* renamed from: a  reason: collision with root package name */
    public final xb f4026a;

    public yb(xb xbVar) {
        Charset charset = mc.f2352a;
        this.f4026a = xbVar;
        xbVar.f3910a = this;
    }

    public void a(int i, double d) throws IOException {
        xb xbVar = this.f4026a;
        Objects.requireNonNull(xbVar);
        xbVar.M(i, Double.doubleToRawLongBits(d));
    }

    public void b(int i, float f) throws IOException {
        xb xbVar = this.f4026a;
        Objects.requireNonNull(xbVar);
        xbVar.K(i, Float.floatToRawIntBits(f));
    }

    public void c(int i, Object obj, rd rdVar) throws IOException {
        xb xbVar = this.f4026a;
        xbVar.W(i, 3);
        rdVar.i((dd) obj, xbVar.f3910a);
        xbVar.W(i, 4);
    }

    public void d(int i, Object obj, rd rdVar) throws IOException {
        this.f4026a.Q(i, (dd) obj, rdVar);
    }

    public final void e(int i, Object obj) throws IOException {
        if (obj instanceof ub) {
            this.f4026a.T(i, (ub) obj);
        } else {
            this.f4026a.S(i, (dd) obj);
        }
    }

    public void f(int i, int i2) throws IOException {
        this.f4026a.X(i, xb.C(i2));
    }

    public void g(int i, long j) throws IOException {
        this.f4026a.Z(i, xb.D(j));
    }
}
