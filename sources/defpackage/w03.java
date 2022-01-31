package defpackage;

import android.os.RemoteException;
import com.google.firebase.auth.internal.zzai;
import java.util.Objects;

/* renamed from: w03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class w03 implements e63<y73> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t43 f3702a;

    public w03(t43 t43) {
        this.f3702a = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(y73 y73) {
        t43 t43 = this.f3702a;
        String str = y73.f;
        Objects.requireNonNull(t43);
        try {
            t43.f3307a.E0(str);
        } catch (RemoteException unused) {
            t43.b.b("RemoteException when sending set account info response.", new Object[0]);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f3702a.d(zzai.zza(str));
    }
}
