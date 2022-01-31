package defpackage;

import android.os.RemoteException;
import defpackage.f32;

/* renamed from: fe2  reason: default package */
public abstract class fe2<R extends f32> extends l32<R, ge2> {
    public fe2(a32 a32) {
        super(uz1.e, a32);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public void l(ge2 ge2) throws RemoteException {
        ge2 ge22 = ge2;
        ge22.getContext();
        de2 de2 = (de2) this;
        ((je2) ge22.getService()).I0(new ee2(de2), de2.q);
    }
}
