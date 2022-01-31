package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import defpackage.t32;

/* renamed from: p62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class p62 extends m62<Boolean> {
    public final t32.a<?> c;

    public p62(t32.a<?> aVar, zi4<Boolean> zi4) {
        super(4, zi4);
        this.c = aVar;
    }

    @Override // defpackage.q62
    public final /* bridge */ /* synthetic */ void c(f42 f42, boolean z) {
    }

    @Override // defpackage.c62
    public final Feature[] f(p52<?> p52) {
        if (p52.k.get(this.c) == null) {
            return null;
        }
        throw null;
    }

    @Override // defpackage.c62
    public final boolean g(p52<?> p52) {
        if (p52.k.get(this.c) == null) {
            return false;
        }
        throw null;
    }

    @Override // defpackage.m62
    public final void h(p52<?> p52) throws RemoteException {
        if (p52.k.remove(this.c) == null) {
            this.b.b((T) Boolean.FALSE);
            return;
        }
        throw null;
    }
}
