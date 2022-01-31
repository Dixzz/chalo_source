package defpackage;

import android.os.IBinder;
import android.os.RemoteException;

/* renamed from: uv4  reason: default package */
public final class uv4 extends ov4 {
    public final /* synthetic */ IBinder g;
    public final /* synthetic */ wv4 h;

    public uv4(wv4 wv4, IBinder iBinder) {
        this.h = wv4;
        this.g = iBinder;
    }

    @Override // defpackage.ov4
    public final void a() {
        xv4 xv4 = this.h.f3843a;
        xv4.k = xv4.g.a(this.g);
        xv4 xv42 = this.h.f3843a;
        xv42.b.b(4, "linkToDeath", new Object[0]);
        try {
            xv42.k.asBinder().linkToDeath(xv42.i, 0);
        } catch (RemoteException e) {
            xv42.b.a(e, "linkToDeath failed", new Object[0]);
        }
        xv4 xv43 = this.h.f3843a;
        xv43.e = false;
        for (ov4 ov4 : xv43.d) {
            ov4.run();
        }
        this.h.f3843a.d.clear();
    }
}
