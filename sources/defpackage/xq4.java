package defpackage;

import android.os.RemoteException;

/* renamed from: xq4  reason: default package */
public final class xq4 extends ov4 {
    public final /* synthetic */ String g;
    public final /* synthetic */ ay4 h;
    public final /* synthetic */ cr4 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xq4(cr4 cr4, ay4 ay4, String str, ay4 ay42) {
        super(ay4);
        this.i = cr4;
        this.g = str;
        this.h = ay42;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            cr4 cr4 = this.i;
            ((tw4) cr4.f747a.k).y0(cr4.b, cr4.a(cr4, this.g), new br4(this.i, this.h, this.g));
        } catch (RemoteException e) {
            cr4.e.a(e, "requestUpdateInfo(%s)", this.g);
            this.h.a(new RuntimeException(e));
        }
    }
}
