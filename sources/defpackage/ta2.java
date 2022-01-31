package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: ta2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ta2 extends gl2 implements ua2 {
    public ta2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // defpackage.ua2
    public final ic2 zzd() throws RemoteException {
        return hj1.n(C(1, F()));
    }

    @Override // defpackage.ua2
    public final int zze() throws RemoteException {
        Parcel C = C(2, F());
        int readInt = C.readInt();
        C.recycle();
        return readInt;
    }
}
