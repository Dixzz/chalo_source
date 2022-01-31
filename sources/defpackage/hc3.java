package defpackage;

import java.util.Objects;

/* renamed from: hc3  reason: default package */
public final class hc3 implements Runnable {
    public final /* synthetic */ od3 f;
    public final /* synthetic */ gc3 g;

    public hc3(gc3 gc3, od3 od3) {
        this.g = gc3;
        this.f = od3;
    }

    public final void run() {
        if (!this.g.c.j0()) {
            this.g.c.P("Connected to service after a timeout");
            ec3 ec3 = this.g.c;
            od3 od3 = this.f;
            Objects.requireNonNull(ec3);
            jz1.c();
            ec3.i = od3;
            ec3.o0();
            sb3 A = ec3.A();
            Objects.requireNonNull(A);
            jz1.c();
            A.h.i0();
        }
    }
}
