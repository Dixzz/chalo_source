package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: o02  reason: default package */
public final class o02 extends q02<Status> {
    public o02(a32 a32) {
        super(a32);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ f32 d(Status status) {
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final void l(m02 m02) throws RemoteException {
        m02 m022 = m02;
        ((v02) m022.getService()).F1(new p02(this), m022.f2301a);
    }
}
