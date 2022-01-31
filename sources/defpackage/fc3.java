package defpackage;

import java.util.Objects;

/* renamed from: fc3  reason: default package */
public final class fc3 extends cd3 {
    public final /* synthetic */ ec3 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fc3(ec3 ec3, ac3 ac3) {
        super(ac3);
        this.e = ec3;
    }

    @Override // defpackage.cd3
    public final void c() {
        ec3 ec3 = this.e;
        Objects.requireNonNull(ec3);
        jz1.c();
        if (ec3.j0()) {
            ec3.M("Inactivity, disconnecting from device AnalyticsService");
            ec3.i0();
        }
    }
}
