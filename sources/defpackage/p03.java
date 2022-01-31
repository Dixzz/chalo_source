package defpackage;

import android.os.RemoteException;
import com.google.firebase.auth.internal.zzai;
import java.util.Objects;

/* renamed from: p03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class p03 implements e63<Void> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f2753a;

    public p03(t43 t43) {
        this.f2753a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(Void r3) {
        t43 t43 = this.f2753a;
        Objects.requireNonNull(t43);
        try {
            t43.f3307a.f();
        } catch (RemoteException unused) {
            t43.b.b("RemoteException when setting FirebaseUI Version", new Object[0]);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2753a.d(zzai.zza(str));
    }
}
