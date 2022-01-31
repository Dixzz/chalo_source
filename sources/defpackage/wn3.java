package defpackage;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: wn3  reason: default package */
public final class wn3 extends kn3 implements un3 {
    public wn3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // defpackage.un3
    public final ic2 h() throws RemoteException {
        return hj1.n(F(4, C()));
    }

    @Override // defpackage.un3
    public final ic2 j(int i) throws RemoteException {
        Parcel C = C();
        C.writeInt(i);
        return hj1.n(F(1, C));
    }

    @Override // defpackage.un3
    public final ic2 p2(float f) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        return hj1.n(F(5, C));
    }

    @Override // defpackage.un3
    public final ic2 r1(Bitmap bitmap) throws RemoteException {
        Parcel C = C();
        sn3.c(C, bitmap);
        return hj1.n(F(6, C));
    }

    @Override // defpackage.un3
    public final ic2 zza(String str) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        return hj1.n(F(2, C));
    }

    @Override // defpackage.un3
    public final ic2 zzb(String str) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        return hj1.n(F(3, C));
    }

    @Override // defpackage.un3
    public final ic2 zzc(String str) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        return hj1.n(F(7, C));
    }
}
