package defpackage;

import android.os.RemoteException;
import java.util.Objects;

/* renamed from: n03  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class n03 implements e63<Void> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e63 f2503a;
    public final /* synthetic */ o03 b;

    public n03(o03 o03, e63 e63) {
        this.b = o03;
        this.f2503a = e63;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(Void r3) {
        t43 t43 = this.b.f2629a;
        Objects.requireNonNull(t43);
        try {
            t43.f3307a.h();
        } catch (RemoteException unused) {
            t43.b.b("RemoteException when sending delete account response.", new Object[0]);
        }
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.f2503a.zza(str);
    }
}
