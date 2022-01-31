package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.List;

/* renamed from: la4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class la4 extends io3 implements ja4 {
    public la4(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // defpackage.ja4
    public final void H2(zzaq zzaq, zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzaq);
        hp3.c(C, zzn);
        L(1, C);
    }

    @Override // defpackage.ja4
    public final List<zzku> L1(String str, String str2, boolean z, zzn zzn) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        ClassLoader classLoader = hp3.f1408a;
        C.writeInt(z ? 1 : 0);
        hp3.c(C, zzn);
        Parcel F = F(14, C);
        ArrayList createTypedArrayList = F.createTypedArrayList(zzku.CREATOR);
        F.recycle();
        return createTypedArrayList;
    }

    @Override // defpackage.ja4
    public final void N1(zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzn);
        L(4, C);
    }

    @Override // defpackage.ja4
    public final String O0(zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzn);
        Parcel F = F(11, C);
        String readString = F.readString();
        F.recycle();
        return readString;
    }

    @Override // defpackage.ja4
    public final void P2(Bundle bundle, zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, bundle);
        hp3.c(C, zzn);
        L(19, C);
    }

    @Override // defpackage.ja4
    public final byte[] R(zzaq zzaq, String str) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzaq);
        C.writeString(str);
        Parcel F = F(9, C);
        byte[] createByteArray = F.createByteArray();
        F.recycle();
        return createByteArray;
    }

    @Override // defpackage.ja4
    public final void S(zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzn);
        L(20, C);
    }

    @Override // defpackage.ja4
    public final void l1(long j, String str, String str2, String str3) throws RemoteException {
        Parcel C = C();
        C.writeLong(j);
        C.writeString(str);
        C.writeString(str2);
        C.writeString(str3);
        L(10, C);
    }

    @Override // defpackage.ja4
    public final List<zzku> p0(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        C.writeString(str3);
        ClassLoader classLoader = hp3.f1408a;
        C.writeInt(z ? 1 : 0);
        Parcel F = F(15, C);
        ArrayList createTypedArrayList = F.createTypedArrayList(zzku.CREATOR);
        F.recycle();
        return createTypedArrayList;
    }

    @Override // defpackage.ja4
    public final void p1(zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzn);
        L(18, C);
    }

    @Override // defpackage.ja4
    public final List<zzz> q1(String str, String str2, String str3) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        C.writeString(str3);
        Parcel F = F(17, C);
        ArrayList createTypedArrayList = F.createTypedArrayList(zzz.CREATOR);
        F.recycle();
        return createTypedArrayList;
    }

    @Override // defpackage.ja4
    public final void q2(zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzn);
        L(6, C);
    }

    @Override // defpackage.ja4
    public final void q3(zzku zzku, zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzku);
        hp3.c(C, zzn);
        L(2, C);
    }

    @Override // defpackage.ja4
    public final List<zzz> s1(String str, String str2, zzn zzn) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        hp3.c(C, zzn);
        Parcel F = F(16, C);
        ArrayList createTypedArrayList = F.createTypedArrayList(zzz.CREATOR);
        F.recycle();
        return createTypedArrayList;
    }

    @Override // defpackage.ja4
    public final void v3(zzz zzz, zzn zzn) throws RemoteException {
        Parcel C = C();
        hp3.c(C, zzz);
        hp3.c(C, zzn);
        L(12, C);
    }
}
