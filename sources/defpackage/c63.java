package defpackage;

import android.os.Parcelable;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzx;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: c63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class c63<ResultT, CallbackT> {

    /* renamed from: a  reason: collision with root package name */
    public final d63<ResultT, CallbackT> f525a;
    public final zi4<ResultT> b;

    public c63(d63<ResultT, CallbackT> d63, zi4<ResultT> zi4) {
        this.f525a = d63;
        this.b = zi4;
    }

    public final void a(ResultT resultt, Status status) {
        FirebaseException firebaseException;
        gj1.l(this.b, "completion source cannot be null");
        if (status != null) {
            d63<ResultT, CallbackT> d63 = this.f525a;
            if (d63.p != null) {
                zi4<ResultT> zi4 = this.b;
                FirebaseAuth instance = FirebaseAuth.getInstance(d63.c);
                d63<ResultT, CallbackT> d632 = this.f525a;
                zznq zznq = d632.p;
                FirebaseUser firebaseUser = ("reauthenticateWithCredential".equals(d632.zza()) || "reauthenticateWithCredentialWithData".equals(this.f525a.zza())) ? this.f525a.d : null;
                SparseArray<Pair<String, String>> sparseArray = w43.f3727a;
                Objects.requireNonNull(instance);
                Objects.requireNonNull(zznq);
                Pair<String, String> pair = w43.f3727a.get(17078);
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                Parcelable.Creator<zzae> creator = zzae.CREATOR;
                List<MultiFactorInfo> zzb = zzba.zzb(zznq.g);
                ArrayList arrayList = new ArrayList();
                for (MultiFactorInfo multiFactorInfo : zzb) {
                    if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                        arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                    }
                }
                zi4.f4178a.u(new FirebaseAuthMultiFactorException(str, str2, new zzae(arrayList, zzag.zzb(zzba.zzb(zznq.g), zznq.f), instance.zze().getName(), zznq.h, (zzx) firebaseUser)));
                return;
            }
            AuthCredential authCredential = d63.m;
            if (authCredential != null) {
                zi4<ResultT> zi42 = this.b;
                String str3 = d63.n;
                String str4 = d63.o;
                SparseArray<Pair<String, String>> sparseArray2 = w43.f3727a;
                int i = status.g;
                if (i == 17012 || i == 17007 || i == 17025) {
                    Pair<String, String> pair2 = w43.f3727a.get(i);
                    FirebaseAuthUserCollisionException firebaseAuthUserCollisionException = new FirebaseAuthUserCollisionException(w43.c(i), w43.b(pair2 != null ? (String) pair2.second : "An internal error has occurred.", status));
                    firebaseAuthUserCollisionException.zzb(authCredential);
                    firebaseAuthUserCollisionException.zza(str3);
                    firebaseAuthUserCollisionException.zzc(str4);
                    firebaseException = firebaseAuthUserCollisionException;
                } else {
                    firebaseException = w43.a(status);
                }
                zi42.f4178a.u(firebaseException);
                return;
            }
            this.b.f4178a.u(w43.a(status));
            return;
        }
        this.b.f4178a.t(resultt);
    }
}
