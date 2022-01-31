package defpackage;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: uo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class uo2 implements wo2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ so2 f3533a;
    public final /* synthetic */ fo2 b;

    public uo2(so2 so2, fo2 fo2) {
        this.f3533a = so2;
        this.b = fo2;
    }

    @Override // defpackage.wo2
    public final <Q> ao2<Q> b(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new ro2(this.f3533a, this.b, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // defpackage.wo2
    public final ao2<?> zzb() {
        so2 so2 = this.f3533a;
        return new ro2(so2, this.b, so2.c);
    }

    @Override // defpackage.wo2
    public final Class<?> zzc() {
        return this.f3533a.getClass();
    }

    @Override // defpackage.wo2
    public final Set<Class<?>> zzd() {
        return this.f3533a.f();
    }

    @Override // defpackage.wo2
    public final Class<?> zze() {
        return this.b.getClass();
    }
}
