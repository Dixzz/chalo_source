package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: va2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class va2 extends gl2 implements d82 {
    public va2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // defpackage.d82
    public final void J1(int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel F = F();
        F.writeInt(i);
        F.writeStrongBinder(iBinder);
        il2.b(F, null);
        Parcel obtain = Parcel.obtain();
        try {
            this.f.transact(1, F, obtain, 0);
            obtain.readException();
        } finally {
            F.recycle();
            obtain.recycle();
        }
    }
}
