package defpackage;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;

/* renamed from: in3  reason: default package */
public final class in3 extends xl3 {
    public final /* synthetic */ LocationRequest q;
    public final /* synthetic */ g34 r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public in3(a32 a32, LocationRequest locationRequest, g34 g34) {
        super(a32);
        this.q = locationRequest;
        this.r = g34;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final void l(sm3 sm3) throws RemoteException {
        sm3 sm32 = sm3;
        yl3 yl3 = new yl3(this);
        LocationRequest locationRequest = this.q;
        g34 g34 = this.r;
        gj1.o(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        Looper myLooper = Looper.myLooper();
        String simpleName = g34.class.getSimpleName();
        gj1.l(g34, "Listener must not be null");
        gj1.l(myLooper, "Looper must not be null");
        gj1.l(simpleName, "Listener type must not be null");
        t32<g34> t32 = new t32<>(myLooper, g34, simpleName);
        synchronized (sm32.c) {
            sm32.c.b(locationRequest, t32, yl3);
        }
    }
}
