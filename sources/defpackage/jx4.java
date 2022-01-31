package defpackage;

import android.os.RemoteException;

/* renamed from: jx4  reason: default package */
public final class jx4 extends ov4 {
    public final /* synthetic */ ay4 g;
    public final /* synthetic */ lx4 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public jx4(lx4 lx4, ay4 ay4, ay4 ay42) {
        super(ay4);
        this.h = lx4;
        this.g = ay42;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            lx4 lx4 = this.h;
            ((kv4) lx4.f2291a.k).t2(lx4.b, av4.a("review"), new kx4(this.h, this.g));
        } catch (RemoteException e) {
            lx4.c.a(e, "error requesting in-app review for %s", this.h.b);
            this.g.a(new RuntimeException(e));
        }
    }
}
