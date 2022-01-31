package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import defpackage.x22;

/* renamed from: p82  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class p82 extends s82 {
    public p82(a32 a32) {
        super(a32);
    }

    @Override // defpackage.l32
    public final void l(x22.b bVar) throws RemoteException {
        v82 v82 = (v82) ((t82) bVar).getService();
        q82 q82 = new q82(this);
        Parcel C = v82.C();
        re2.b(C, q82);
        try {
            v82.f.transact(1, C, null, 1);
        } finally {
            C.recycle();
        }
    }
}
