package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: jf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class jf3 implements IInterface {
    private final IBinder zzb;
    private final String zzc;

    public jf3(IBinder iBinder, String str) {
        this.zzb = iBinder;
        this.zzc = str;
    }

    public IBinder asBinder() {
        return this.zzb;
    }

    public final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzc);
        return obtain;
    }

    public final void zzb(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzb.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final Parcel zza(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.zzb.transact(8, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }
}
