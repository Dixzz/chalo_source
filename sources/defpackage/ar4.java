package defpackage;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: ar4  reason: default package */
public final class ar4 extends zq4<Void> {
    public ar4(cr4 cr4, ay4<Void> ay4) {
        super(cr4, new nv4("OnCompleteUpdateCallback"), ay4);
    }

    @Override // defpackage.vw4, defpackage.zq4
    public final void V0(Bundle bundle) throws RemoteException {
        this.h.f747a.b();
        this.f.b(4, "onCompleteUpdate", new Object[0]);
        if (bundle.getInt("error.code", -2) != 0) {
            this.g.a(new ev4(bundle.getInt("error.code", -2)));
        } else {
            this.g.b(null);
        }
    }
}
