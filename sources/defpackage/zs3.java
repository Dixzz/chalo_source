package defpackage;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: zs3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zs3<T> implements ws3<T> {
    public volatile ws3<T> f;
    public volatile boolean g;
    @NullableDecl
    public T h;

    public zs3(ws3<T> ws3) {
        Objects.requireNonNull(ws3);
        this.f = ws3;
    }

    public final String toString() {
        Object obj = this.f;
        if (obj == null) {
            String valueOf = String.valueOf(this.h);
            obj = hj1.y(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        }
        String valueOf2 = String.valueOf(obj);
        return hj1.y(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }

    @Override // defpackage.ws3
    public final T zza() {
        if (!this.g) {
            synchronized (this) {
                if (!this.g) {
                    T zza = this.f.zza();
                    this.h = zza;
                    this.g = true;
                    this.f = null;
                    return zza;
                }
            }
        }
        return this.h;
    }
}
