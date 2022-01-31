package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: mo3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class mo3 extends io3 implements ko3 {
    public mo3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // defpackage.ko3
    public final void a2(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        hp3.c(C, bundle);
        C.writeLong(j);
        L(1, C);
    }

    @Override // defpackage.ko3
    public final int zza() throws RemoteException {
        Parcel F = F(2, C());
        int readInt = F.readInt();
        F.recycle();
        return readInt;
    }
}
