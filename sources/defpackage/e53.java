package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzno;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzvl;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: e53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public interface e53 extends IInterface {
    void E0(String str) throws RemoteException;

    void G2(zzno zzno) throws RemoteException;

    void H1(zzvl zzvl) throws RemoteException;

    void K3(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void R1(zzwg zzwg) throws RemoteException;

    void X(PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void b() throws RemoteException;

    void b1(String str) throws RemoteException;

    void e2(zzwg zzwg, zzvz zzvz) throws RemoteException;

    void f() throws RemoteException;

    void f0(String str) throws RemoteException;

    void h() throws RemoteException;

    void i1(zznq zznq) throws RemoteException;

    void w3(zzwr zzwr) throws RemoteException;

    void z1(Status status) throws RemoteException;
}
