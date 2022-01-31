package defpackage;

import android.os.RemoteException;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzai;
import java.util.Objects;

/* renamed from: rz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class rz2 implements e63<zzwg> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f3154a;

    public rz2(t43 t43) {
        this.f3154a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzwg zzwg) {
        zzwg zzwg2 = zzwg;
        t43 t43 = this.f3154a;
        Objects.requireNonNull(t43);
        try {
            t43.f3307a.R1(zzwg2);
        } catch (RemoteException unused) {
            t43.b.b("RemoteException when sending token result.", new Object[0]);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f3154a.d(zzai.zza(str));
    }
}
