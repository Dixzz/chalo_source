package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ps4  reason: default package */
public final class ps4 {
    public static final nv4 j = new nv4("ExtractorLooper");

    /* renamed from: a  reason: collision with root package name */
    public final dt4 f2845a;
    public final ns4 b;
    public final fu4 c;
    public final qt4 d;
    public final vt4 e;
    public final zt4 f;
    public final kw4<vu4> g;
    public final gt4 h;
    public final AtomicBoolean i = new AtomicBoolean(false);

    public ps4(dt4 dt4, kw4<vu4> kw4, ns4 ns4, fu4 fu4, qt4 qt4, vt4 vt4, zt4 zt4, gt4 gt4) {
        this.f2845a = dt4;
        this.g = kw4;
        this.b = ns4;
        this.c = fu4;
        this.d = qt4;
        this.e = vt4;
        this.f = zt4;
        this.h = gt4;
    }

    public final void a(int i2, Exception exc) {
        try {
            dt4 dt4 = this.f2845a;
            dt4.b(new ws4(dt4, i2, null));
            dt4 dt42 = this.f2845a;
            dt42.b(new ws4(dt42, i2));
        } catch (os4 unused) {
            j.b(6, "Error during error handling: %s", new Object[]{exc.getMessage()});
        }
    }
}
