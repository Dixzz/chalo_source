package defpackage;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: zq4  reason: default package */
public class zq4<T> extends uw4 {
    public final nv4 f;
    public final ay4<T> g;
    public final /* synthetic */ cr4 h;

    public zq4(cr4 cr4, nv4 nv4, ay4<T> ay4) {
        this.h = cr4;
        this.f = nv4;
        this.g = ay4;
    }

    @Override // defpackage.vw4
    public void V0(Bundle bundle) throws RemoteException {
        this.h.f747a.b();
        this.f.b(4, "onCompleteUpdate", new Object[0]);
    }

    @Override // defpackage.vw4
    public void w1(Bundle bundle) throws RemoteException {
        this.h.f747a.b();
        this.f.b(4, "onRequestInfo", new Object[0]);
    }
}
