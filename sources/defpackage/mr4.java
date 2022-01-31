package defpackage;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: mr4  reason: default package */
public final class mr4 extends ov4 {
    public final /* synthetic */ int g;
    public final /* synthetic */ ay4 h;
    public final /* synthetic */ ur4 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public mr4(ur4 ur4, ay4 ay4, int i2, ay4 ay42) {
        super(ay4);
        this.i = ur4;
        this.g = i2;
        this.h = ay42;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            ur4 ur4 = this.i;
            String str = ur4.f3547a;
            int i2 = this.g;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i2);
            ((yw4) ur4.c.k).t0(str, bundle, ur4.g(), new pr4(this.i, this.h, (int[]) null));
        } catch (RemoteException e) {
            ur4.f.a(e, "notifySessionFailed", new Object[0]);
        }
    }
}
