package defpackage;

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
import com.google.firebase.auth.internal.zzai;

/* renamed from: d53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class d53 extends mo2 implements e53 {
    public d53() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // defpackage.mo2
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                ((a63) this).R1((zzwg) mp2.a(parcel, zzwg.CREATOR));
                return true;
            case 2:
                ((a63) this).e2((zzwg) mp2.a(parcel, zzwg.CREATOR), (zzvz) mp2.a(parcel, zzvz.CREATOR));
                return true;
            case 3:
                ((a63) this).H1((zzvl) mp2.a(parcel, zzvl.CREATOR));
                return true;
            case 4:
                ((a63) this).w3((zzwr) mp2.a(parcel, zzwr.CREATOR));
                return true;
            case 5:
                ((a63) this).z1((Status) mp2.a(parcel, Status.CREATOR));
                return true;
            case 6:
                ((a63) this).h();
                return true;
            case 7:
                ((a63) this).b();
                return true;
            case 8:
                ((a63) this).E0(parcel.readString());
                return true;
            case 9:
                ((a63) this).f0(parcel.readString());
                return true;
            case 10:
                ((a63) this).X((PhoneAuthCredential) mp2.a(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 11:
                ((a63) this).b1(parcel.readString());
                return true;
            case 12:
                ((a63) this).K3((Status) mp2.a(parcel, Status.CREATOR), (PhoneAuthCredential) mp2.a(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 13:
                ((a63) this).f();
                return true;
            case 14:
                zzno zzno = (zzno) mp2.a(parcel, zzno.CREATOR);
                ((a63) this).F(zzno.f, zzno.g, zzno.h, zzno.i);
                return true;
            case 15:
                d63 d63 = ((a63) this).f;
                d63.p = (zznq) mp2.a(parcel, zznq.CREATOR);
                d63.h(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
                return true;
            default:
                return false;
        }
    }
}
