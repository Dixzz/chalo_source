package defpackage;

import java.util.Objects;

/* renamed from: kg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class kg4 implements Runnable {
    public final /* synthetic */ sg4 f;
    public final /* synthetic */ lg4 g;

    public kg4(lg4 lg4, sg4 sg4) {
        this.g = lg4;
        this.f = sg4;
    }

    public final void run() {
        lg4 lg4 = this.g;
        lg4.j.f().b();
        h64 h64 = new h64(lg4);
        h64.l();
        lg4.c = h64;
        lg4.j.g.c = lg4.f2214a;
        rf4 rf4 = new rf4(lg4);
        rf4.l();
        lg4.i = rf4;
        ch4 ch4 = new ch4(lg4);
        ch4.l();
        lg4.f = ch4;
        he4 he4 = new he4(lg4);
        he4.l();
        lg4.h = he4;
        ig4 ig4 = new ig4(lg4);
        ig4.l();
        lg4.e = ig4;
        lg4.d = new cb4(lg4);
        if (lg4.o != lg4.p) {
            lg4.j.g().f.c("Not all upload components initialized", Integer.valueOf(lg4.o), Integer.valueOf(lg4.p));
        }
        lg4.k = true;
        lg4 lg42 = this.g;
        lg42.j.f().b();
        lg42.K().h0();
        if (lg42.j.n().e.a() == 0) {
            ib4 ib4 = lg42.j.n().e;
            Objects.requireNonNull((db2) lg42.j.n);
            ib4.b(System.currentTimeMillis());
        }
        lg42.w();
    }
}
