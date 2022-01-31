package defpackage;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import java.util.Objects;

/* renamed from: wz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class wz2 implements e63<o83> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e63 f3865a;
    public final /* synthetic */ xz2 b;

    public wz2(xz2 xz2, e63 e63) {
        this.b = xz2;
        this.f3865a = e63;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(o83 o83) {
        o83 o832 = o83;
        if (!TextUtils.isEmpty(o832.j)) {
            Status status = new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE, null);
            t43 t43 = this.b.b;
            PhoneAuthCredential zzc = PhoneAuthCredential.zzc(o832.k, o832.j);
            Objects.requireNonNull(t43);
            try {
                t43.f3307a.K3(status, zzc);
            } catch (RemoteException unused) {
                t43.b.b("RemoteException when sending failure result.", new Object[0]);
            }
        } else {
            this.b.c.f(new zzwg(o832.g, o832.f, Long.valueOf(o832.h), "Bearer"), null, "phone", Boolean.valueOf(o832.i), null, this.b.b, this.f3865a);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f3865a.zza(str);
    }
}
