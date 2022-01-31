package defpackage;

import android.os.RemoteException;
import java.util.Map;

/* renamed from: yu4  reason: default package */
public final class yu4 extends ov4 {
    public final /* synthetic */ Map g;
    public final /* synthetic */ ay4 h;
    public final /* synthetic */ ur4 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yu4(ur4 ur4, ay4 ay4, Map map, ay4 ay42) {
        super(ay4);
        this.i = ur4;
        this.g = map;
        this.h = ay42;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            ur4 ur4 = this.i;
            ((yw4) ur4.c.k).Z2(ur4.f3547a, ur4.h(this.g), new rr4(this.i, this.h));
        } catch (RemoteException e) {
            ur4.f.a(e, "syncPacks", new Object[0]);
            this.h.a(new RuntimeException(e));
        }
    }
}
