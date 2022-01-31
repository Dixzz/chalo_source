package defpackage;

import android.os.RemoteException;

/* renamed from: kr4  reason: default package */
public final class kr4 extends ov4 {
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ int j;
    public final /* synthetic */ ay4 k;
    public final /* synthetic */ ur4 l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kr4(ur4 ur4, ay4 ay4, int i2, String str, String str2, int i3, ay4 ay42) {
        super(ay4);
        this.l = ur4;
        this.g = i2;
        this.h = str;
        this.i = str2;
        this.j = i3;
        this.k = ay42;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            ur4 ur4 = this.l;
            ((yw4) ur4.c.k).r3(ur4.f3547a, ur4.i(this.g, this.h, this.i, this.j), ur4.g(), new pr4(this.l, this.k, (char[]) null));
        } catch (RemoteException e) {
            ur4.f.a(e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
