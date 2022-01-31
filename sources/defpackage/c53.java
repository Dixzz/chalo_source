package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzno;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzvl;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: c53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class c53 extends kl2 implements e53 {
    public c53(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // defpackage.e53
    public final void E0(String str) throws RemoteException {
        Parcel L = L();
        L.writeString(str);
        F(8, L);
    }

    @Override // defpackage.e53
    public final void G2(zzno zzno) throws RemoteException {
        Parcel L = L();
        mp2.b(L, zzno);
        F(14, L);
    }

    @Override // defpackage.e53
    public final void H1(zzvl zzvl) throws RemoteException {
        Parcel L = L();
        mp2.b(L, zzvl);
        F(3, L);
    }

    @Override // defpackage.e53
    public final void K3(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel L = L();
        mp2.b(L, status);
        mp2.b(L, phoneAuthCredential);
        F(12, L);
    }

    @Override // defpackage.e53
    public final void R1(zzwg zzwg) throws RemoteException {
        Parcel L = L();
        mp2.b(L, zzwg);
        F(1, L);
    }

    @Override // defpackage.e53
    public final void X(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel L = L();
        mp2.b(L, phoneAuthCredential);
        F(10, L);
    }

    @Override // defpackage.e53
    public final void b() throws RemoteException {
        F(7, L());
    }

    @Override // defpackage.e53
    public final void b1(String str) throws RemoteException {
        Parcel L = L();
        L.writeString(str);
        F(11, L);
    }

    @Override // defpackage.e53
    public final void e2(zzwg zzwg, zzvz zzvz) throws RemoteException {
        Parcel L = L();
        mp2.b(L, zzwg);
        mp2.b(L, zzvz);
        F(2, L);
    }

    @Override // defpackage.e53
    public final void f() throws RemoteException {
        F(13, L());
    }

    @Override // defpackage.e53
    public final void f0(String str) throws RemoteException {
        Parcel L = L();
        L.writeString(str);
        F(9, L);
    }

    @Override // defpackage.e53
    public final void h() throws RemoteException {
        F(6, L());
    }

    @Override // defpackage.e53
    public final void i1(zznq zznq) throws RemoteException {
        Parcel L = L();
        mp2.b(L, zznq);
        F(15, L);
    }

    @Override // defpackage.e53
    public final void w3(zzwr zzwr) throws RemoteException {
        Parcel L = L();
        mp2.b(L, zzwr);
        F(4, L);
    }

    @Override // defpackage.e53
    public final void z1(Status status) throws RemoteException {
        Parcel L = L();
        mp2.b(L, status);
        F(5, L);
    }
}
