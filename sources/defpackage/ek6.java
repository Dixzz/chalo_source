package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.ei6;
import java.io.IOException;
import java.util.List;

/* renamed from: ek6  reason: default package */
/* compiled from: RealInterceptorChain.kt */
public final class ek6 implements ei6.a {

    /* renamed from: a  reason: collision with root package name */
    public int f986a;
    public final nj6 b;
    public final List<ei6> c;
    public final int d;
    public final lj6 e;
    public final ji6 f;
    public final int g;
    public final int h;
    public final int i;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends ei6> */
    /* JADX WARN: Multi-variable type inference failed */
    public ek6(nj6 nj6, List<? extends ei6> list, int i2, lj6 lj6, ji6 ji6, int i3, int i4, int i5) {
        n86.f(nj6, AnalyticsConstants.CALL);
        n86.f(list, "interceptors");
        n86.f(ji6, "request");
        this.b = nj6;
        this.c = list;
        this.d = i2;
        this.e = lj6;
        this.f = ji6;
        this.g = i3;
        this.h = i4;
        this.i = i5;
    }

    public static ek6 b(ek6 ek6, int i2, lj6 lj6, ji6 ji6, int i3, int i4, int i5, int i6) {
        int i7 = (i6 & 1) != 0 ? ek6.d : i2;
        lj6 lj62 = (i6 & 2) != 0 ? ek6.e : lj6;
        ji6 ji62 = (i6 & 4) != 0 ? ek6.f : ji6;
        int i8 = (i6 & 8) != 0 ? ek6.g : i3;
        int i9 = (i6 & 16) != 0 ? ek6.h : i4;
        int i10 = (i6 & 32) != 0 ? ek6.i : i5;
        n86.f(ji62, "request");
        return new ek6(ek6.b, ek6.c, i7, lj62, ji62, i8, i9, i10);
    }

    @Override // defpackage.ei6.a
    public ni6 a(ji6 ji6) throws IOException {
        n86.f(ji6, "request");
        boolean z = false;
        if (this.d < this.c.size()) {
            this.f986a++;
            lj6 lj6 = this.e;
            if (lj6 != null) {
                if (lj6.e.b(ji6.b)) {
                    if (!(this.f986a == 1)) {
                        StringBuilder i0 = hj1.i0("network interceptor ");
                        i0.append(this.c.get(this.d - 1));
                        i0.append(" must call proceed() exactly once");
                        throw new IllegalStateException(i0.toString().toString());
                    }
                } else {
                    StringBuilder i02 = hj1.i0("network interceptor ");
                    i02.append(this.c.get(this.d - 1));
                    i02.append(" must retain the same host and port");
                    throw new IllegalStateException(i02.toString().toString());
                }
            }
            ek6 b2 = b(this, this.d + 1, null, ji6, 0, 0, 0, 58);
            ei6 ei6 = this.c.get(this.d);
            ni6 a2 = ei6.a(b2);
            if (a2 != null) {
                if (this.e != null) {
                    if (!(this.d + 1 >= this.c.size() || b2.f986a == 1)) {
                        throw new IllegalStateException(("network interceptor " + ei6 + " must call proceed() exactly once").toString());
                    }
                }
                if (a2.m != null) {
                    z = true;
                }
                if (z) {
                    return a2;
                }
                throw new IllegalStateException(("interceptor " + ei6 + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + ei6 + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // defpackage.ei6.a
    public ji6 request() {
        return this.f;
    }
}
