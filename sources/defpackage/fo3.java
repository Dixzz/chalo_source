package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: fo3  reason: default package */
public final class fo3 extends kn3 implements do3 {
    public fo3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // defpackage.do3
    public final void C2(String str) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        L(7, C);
    }

    @Override // defpackage.do3
    public final float K2() throws RemoteException {
        Parcel F = F(23, C());
        float readFloat = F.readFloat();
        F.recycle();
        return readFloat;
    }

    @Override // defpackage.do3
    public final LatLng M() throws RemoteException {
        Parcel F = F(4, C());
        LatLng latLng = (LatLng) sn3.a(F, LatLng.CREATOR);
        F.recycle();
        return latLng;
    }

    @Override // defpackage.do3
    public final boolean O1() throws RemoteException {
        Parcel F = F(10, C());
        int i = sn3.f3230a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.do3
    public final void P() throws RemoteException {
        L(11, C());
    }

    @Override // defpackage.do3
    public final void Q1(float f) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        L(25, C);
    }

    @Override // defpackage.do3
    public final void R0(String str) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        L(5, C);
    }

    @Override // defpackage.do3
    public final boolean T1() throws RemoteException {
        Parcel F = F(13, C());
        int i = sn3.f3230a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.do3
    public final void Z(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(9, C);
    }

    @Override // defpackage.do3
    public final void a(float f) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        L(27, C);
    }

    @Override // defpackage.do3
    public final boolean a3() throws RemoteException {
        Parcel F = F(21, C());
        int i = sn3.f3230a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.do3
    public final int b() throws RemoteException {
        Parcel F = F(17, C());
        int readInt = F.readInt();
        F.recycle();
        return readInt;
    }

    @Override // defpackage.do3
    public final ic2 c() throws RemoteException {
        return hj1.n(F(30, C()));
    }

    @Override // defpackage.do3
    public final void c0(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(20, C);
    }

    @Override // defpackage.do3
    public final float c3() throws RemoteException {
        Parcel F = F(26, C());
        float readFloat = F.readFloat();
        F.recycle();
        return readFloat;
    }

    @Override // defpackage.do3
    public final float d() throws RemoteException {
        Parcel F = F(28, C());
        float readFloat = F.readFloat();
        F.recycle();
        return readFloat;
    }

    @Override // defpackage.do3
    public final void e(ic2 ic2) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        L(29, C);
    }

    @Override // defpackage.do3
    public final boolean f2(do3 do3) throws RemoteException {
        Parcel C = C();
        sn3.b(C, do3);
        Parcel F = F(16, C);
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.do3
    public final void g0(float f, float f2) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        C.writeFloat(f2);
        L(24, C);
    }

    @Override // defpackage.do3
    public final String getId() throws RemoteException {
        Parcel F = F(2, C());
        String readString = F.readString();
        F.recycle();
        return readString;
    }

    @Override // defpackage.do3
    public final String getTitle() throws RemoteException {
        Parcel F = F(6, C());
        String readString = F.readString();
        F.recycle();
        return readString;
    }

    @Override // defpackage.do3
    public final boolean isVisible() throws RemoteException {
        Parcel F = F(15, C());
        int i = sn3.f3230a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.do3
    public final void j1() throws RemoteException {
        L(12, C());
    }

    @Override // defpackage.do3
    public final void k2(float f) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        L(22, C);
    }

    @Override // defpackage.do3
    public final void n0(float f, float f2) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        C.writeFloat(f2);
        L(19, C);
    }

    @Override // defpackage.do3
    public final void remove() throws RemoteException {
        L(1, C());
    }

    @Override // defpackage.do3
    public final void s(LatLng latLng) throws RemoteException {
        Parcel C = C();
        sn3.c(C, latLng);
        L(3, C);
    }

    @Override // defpackage.do3
    public final void setVisible(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(14, C);
    }

    @Override // defpackage.do3
    public final void t1(ic2 ic2) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        L(18, C);
    }

    @Override // defpackage.do3
    public final String t3() throws RemoteException {
        Parcel F = F(8, C());
        String readString = F.readString();
        F.recycle();
        return readString;
    }
}
