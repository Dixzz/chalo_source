package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;

/* renamed from: x92  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class x92 extends gl2 implements z92 {
    public x92(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // defpackage.z92
    public final boolean P1(zzs zzs, ic2 ic2) throws RemoteException {
        Parcel F = F();
        il2.b(F, zzs);
        il2.c(F, ic2);
        Parcel C = C(5, F);
        boolean z = C.readInt() != 0;
        C.recycle();
        return z;
    }

    @Override // defpackage.z92
    public final zzq o1(zzn zzn) throws RemoteException {
        Parcel F = F();
        il2.b(F, zzn);
        Parcel C = C(6, F);
        zzq zzq = (zzq) il2.a(C, zzq.CREATOR);
        C.recycle();
        return zzq;
    }

    @Override // defpackage.z92
    public final boolean x() throws RemoteException {
        Parcel C = C(7, F());
        int i = il2.f1532a;
        boolean z = C.readInt() != 0;
        C.recycle();
        return z;
    }
}
