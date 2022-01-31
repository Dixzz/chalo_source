package com.google.firebase.appindexing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzu extends jf3 implements zzr {
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.firebase.appindexing.internal.IAppIndexingService");
    }

    @Override // com.google.firebase.appindexing.internal.zzr
    public final zzg zza(q32 q32, zzy zzy) throws RemoteException {
        Parcel zza = zza();
        ch3.b(zza, q32);
        if (zzy == null) {
            zza.writeInt(0);
        } else {
            zza.writeInt(1);
            zzy.writeToParcel(zza, 0);
        }
        Parcel zza2 = zza(8, zza);
        zzg zzg = (zzg) ch3.a(zza2, zzg.CREATOR);
        zza2.recycle();
        return zzg;
    }
}
