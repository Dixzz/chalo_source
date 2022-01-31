package defpackage;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: to2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class to2 implements wo2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fo2 f3384a;

    public to2(fo2 fo2) {
        this.f3384a = fo2;
    }

    @Override // defpackage.wo2
    public final <Q> ao2<Q> b(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new bo2(this.f3384a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // defpackage.wo2
    public final ao2<?> zzb() {
        fo2 fo2 = this.f3384a;
        return new bo2(fo2, fo2.c);
    }

    @Override // defpackage.wo2
    public final Class<?> zzc() {
        return this.f3384a.getClass();
    }

    @Override // defpackage.wo2
    public final Set<Class<?>> zzd() {
        return this.f3384a.f();
    }

    @Override // defpackage.wo2
    public final Class<?> zze() {
        return null;
    }
}
