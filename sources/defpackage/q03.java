package defpackage;

import android.os.RemoteException;
import com.google.firebase.auth.internal.zzai;
import java.util.Objects;

/* renamed from: q03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class q03 implements e63<m73> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f2879a;

    public q03(t43 t43) {
        this.f2879a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(m73 m73) {
        t43 t43 = this.f2879a;
        Objects.requireNonNull(t43);
        try {
            t43.f3307a.b();
        } catch (RemoteException unused) {
            t43.b.b("RemoteException when sending email verification response.", new Object[0]);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2879a.d(zzai.zza(str));
    }
}
