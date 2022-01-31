package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: h54  reason: default package */
public final class h54 extends kn3 implements g54 {
    public h54(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // defpackage.g54
    public final void R2(ic2 ic2, int i) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        C.writeInt(i);
        L(6, C);
    }

    @Override // defpackage.g54
    public final m44 n3(ic2 ic2) throws RemoteException {
        m44 m44;
        Parcel C = C();
        sn3.b(C, ic2);
        Parcel F = F(2, C);
        IBinder readStrongBinder = F.readStrongBinder();
        if (readStrongBinder == null) {
            m44 = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (queryLocalInterface instanceof m44) {
                m44 = (m44) queryLocalInterface;
            } else {
                m44 = new l54(readStrongBinder);
            }
        }
        F.recycle();
        return m44;
    }

    @Override // defpackage.g54
    public final k44 zze() throws RemoteException {
        k44 k44;
        Parcel F = F(4, C());
        IBinder readStrongBinder = F.readStrongBinder();
        if (readStrongBinder == null) {
            k44 = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if (queryLocalInterface instanceof k44) {
                k44 = (k44) queryLocalInterface;
            } else {
                k44 = new z44(readStrongBinder);
            }
        }
        F.recycle();
        return k44;
    }

    @Override // defpackage.g54
    public final un3 zzf() throws RemoteException {
        un3 un3;
        Parcel F = F(5, C());
        IBinder readStrongBinder = F.readStrongBinder();
        int i = vn3.f;
        if (readStrongBinder == null) {
            un3 = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            if (queryLocalInterface instanceof un3) {
                un3 = (un3) queryLocalInterface;
            } else {
                un3 = new wn3(readStrongBinder);
            }
        }
        F.recycle();
        return un3;
    }
}
