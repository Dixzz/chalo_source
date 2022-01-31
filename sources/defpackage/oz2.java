package defpackage;

import android.os.RemoteException;
import com.google.android.gms.internal.p000firebaseauthapi.zzvl;
import com.google.firebase.auth.internal.zzai;
import java.util.Objects;

/* renamed from: oz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class oz2 implements e63<zzvl> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f2748a;

    public oz2(t43 t43) {
        this.f2748a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzvl zzvl) {
        zzvl zzvl2 = zzvl;
        t43 t43 = this.f2748a;
        Objects.requireNonNull(t43);
        try {
            t43.f3307a.H1(zzvl2);
        } catch (RemoteException unused) {
            t43.b.b("RemoteException when sending create auth uri response.", new Object[0]);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2748a.d(zzai.zza(str));
    }
}
