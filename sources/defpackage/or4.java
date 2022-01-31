package defpackage;

import android.os.RemoteException;

/* renamed from: or4  reason: default package */
public final class or4 extends ov4 {
    public final /* synthetic */ ay4 g;
    public final /* synthetic */ ur4 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public or4(ur4 ur4, ay4 ay4, ay4 ay42) {
        super(ay4);
        this.h = ur4;
        this.g = ay42;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            ur4 ur4 = this.h;
            ((yw4) ur4.d.k).f1(ur4.f3547a, ur4.g(), new sr4(this.h, this.g));
        } catch (RemoteException e) {
            ur4.f.a(e, "keepAlive", new Object[0]);
        }
    }
}
