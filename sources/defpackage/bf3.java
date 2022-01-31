package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.icing.zzw;
import com.google.firebase.appindexing.internal.zza;

/* renamed from: bf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class bf3 extends jf3 implements ze3 {
    public bf3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
    }

    @Override // defpackage.ze3
    public final void M1(af3 af3, zza[] zzaArr) throws RemoteException {
        Parcel zza = zza();
        ch3.b(zza, af3);
        zza.writeTypedArray(zzaArr, 0);
        zzb(7, zza);
    }

    @Override // defpackage.ze3
    public final void v2(af3 af3, String str, zzw[] zzwArr) throws RemoteException {
        Parcel zza = zza();
        ch3.b(zza, af3);
        zza.writeString(null);
        zza.writeTypedArray(zzwArr, 0);
        zzb(1, zza);
    }
}
