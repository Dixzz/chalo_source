package defpackage;

import android.os.RemoteException;
import com.google.android.gms.internal.location.zzbf;
import defpackage.t32;

/* renamed from: jn3  reason: default package */
public final class jn3 extends xl3 {
    public final /* synthetic */ g34 q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public jn3(a32 a32, g34 g34) {
        super(a32);
        this.q = g34;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final void l(sm3 sm3) throws RemoteException {
        g34 g34 = this.q;
        String simpleName = g34.class.getSimpleName();
        gj1.l(g34, "Listener must not be null");
        gj1.l(simpleName, "Listener type must not be null");
        gj1.i(simpleName, "Listener type must not be empty");
        t32.a aVar = new t32.a(g34, simpleName);
        yl3 yl3 = new yl3(this);
        nm3 nm3 = sm3.c;
        nm3.f2575a.f1004a.checkConnected();
        gj1.l(aVar, "Invalid null listener key");
        synchronized (nm3.d) {
            qm3 remove = nm3.d.remove(aVar);
            if (remove != null) {
                synchronized (remove) {
                    t32<g34> t32 = remove.g;
                    t32.b = null;
                    t32.c = null;
                }
                ((jm3) nm3.f2575a.a()).F2(zzbf.l1(remove, yl3));
            }
        }
    }
}
