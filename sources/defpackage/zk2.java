package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zze;

/* renamed from: zk2  reason: default package */
public final class zk2 implements yk2, IInterface {
    public final IBinder f;
    public final String g = "com.google.android.gms.clearcut.internal.IClearcutLoggerService";

    public zk2(IBinder iBinder) {
        this.f = iBinder;
    }

    @Override // defpackage.yk2
    public final void B0(wk2 wk2, zze zze) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        int i = ng2.f2550a;
        obtain.writeStrongBinder((sf2) wk2);
        if (zze == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            zze.writeToParcel(obtain, 0);
        }
        try {
            this.f.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f;
    }
}
