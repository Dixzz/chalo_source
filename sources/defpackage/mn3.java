package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mn3  reason: default package */
public final class mn3 extends kn3 implements ho3 {
    public mn3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    @Override // defpackage.ho3
    public final boolean D() throws RemoteException {
        Parcel F = F(14, C());
        int i = sn3.f3230a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.ho3
    public final void K0(Cap cap) throws RemoteException {
        Parcel C = C();
        sn3.c(C, cap);
        L(21, C);
    }

    @Override // defpackage.ho3
    public final void V2(Cap cap) throws RemoteException {
        Parcel C = C();
        sn3.c(C, cap);
        L(19, C);
    }

    @Override // defpackage.ho3
    public final boolean Y0(ho3 ho3) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ho3);
        Parcel F = F(15, C);
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.ho3
    public final void a(float f) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        L(9, C);
    }

    @Override // defpackage.ho3
    public final int b() throws RemoteException {
        Parcel F = F(16, C());
        int readInt = F.readInt();
        F.recycle();
        return readInt;
    }

    @Override // defpackage.ho3
    public final ic2 c() throws RemoteException {
        return hj1.n(F(28, C()));
    }

    @Override // defpackage.ho3
    public final float d() throws RemoteException {
        Parcel F = F(10, C());
        float readFloat = F.readFloat();
        F.recycle();
        return readFloat;
    }

    @Override // defpackage.ho3
    public final void e(ic2 ic2) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        L(27, C);
    }

    @Override // defpackage.ho3
    public final List<PatternItem> e1() throws RemoteException {
        Parcel F = F(26, C());
        ArrayList createTypedArrayList = F.createTypedArrayList(PatternItem.CREATOR);
        F.recycle();
        return createTypedArrayList;
    }

    @Override // defpackage.ho3
    public final boolean g() throws RemoteException {
        Parcel F = F(18, C());
        int i = sn3.f3230a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.ho3
    public final String getId() throws RemoteException {
        Parcel F = F(2, C());
        String readString = F.readString();
        F.recycle();
        return readString;
    }

    @Override // defpackage.ho3
    public final void i(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(17, C);
    }

    @Override // defpackage.ho3
    public final void i0(List<PatternItem> list) throws RemoteException {
        Parcel C = C();
        C.writeTypedList(list);
        L(25, C);
    }

    @Override // defpackage.ho3
    public final boolean isVisible() throws RemoteException {
        Parcel F = F(12, C());
        int i = sn3.f3230a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.ho3
    public final float k() throws RemoteException {
        Parcel F = F(6, C());
        float readFloat = F.readFloat();
        F.recycle();
        return readFloat;
    }

    @Override // defpackage.ho3
    public final void k1(int i) throws RemoteException {
        Parcel C = C();
        C.writeInt(i);
        L(7, C);
    }

    @Override // defpackage.ho3
    public final int m3() throws RemoteException {
        Parcel F = F(8, C());
        int readInt = F.readInt();
        F.recycle();
        return readInt;
    }

    @Override // defpackage.ho3
    public final void n2(int i) throws RemoteException {
        Parcel C = C();
        C.writeInt(i);
        L(23, C);
    }

    @Override // defpackage.ho3
    public final void remove() throws RemoteException {
        L(1, C());
    }

    @Override // defpackage.ho3
    public final void s2(float f) throws RemoteException {
        Parcel C = C();
        C.writeFloat(f);
        L(5, C);
    }

    @Override // defpackage.ho3
    public final void setVisible(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(11, C);
    }

    @Override // defpackage.ho3
    public final List<LatLng> t() throws RemoteException {
        Parcel F = F(4, C());
        ArrayList createTypedArrayList = F.createTypedArrayList(LatLng.CREATOR);
        F.recycle();
        return createTypedArrayList;
    }

    @Override // defpackage.ho3
    public final Cap u3() throws RemoteException {
        Parcel F = F(22, C());
        Cap cap = (Cap) sn3.a(F, Cap.CREATOR);
        F.recycle();
        return cap;
    }

    @Override // defpackage.ho3
    public final void v(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(13, C);
    }

    @Override // defpackage.ho3
    public final Cap v0() throws RemoteException {
        Parcel F = F(20, C());
        Cap cap = (Cap) sn3.a(F, Cap.CREATOR);
        F.recycle();
        return cap;
    }

    @Override // defpackage.ho3
    public final void y(List<LatLng> list) throws RemoteException {
        Parcel C = C();
        C.writeTypedList(list);
        L(3, C);
    }

    @Override // defpackage.ho3
    public final int y1() throws RemoteException {
        Parcel F = F(24, C());
        int readInt = F.readInt();
        F.recycle();
        return readInt;
    }
}
