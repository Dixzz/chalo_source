package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: at3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class at3 extends io3 implements bs3 {
    public at3(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // defpackage.bs3
    public final Bundle zza(Bundle bundle) throws RemoteException {
        Parcel C = C();
        hp3.c(C, bundle);
        Parcel F = F(1, C);
        Bundle bundle2 = (Bundle) hp3.a(F, Bundle.CREATOR);
        F.recycle();
        return bundle2;
    }
}
