package defpackage;

import java.io.Serializable;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: xs3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class xs3<T> implements ws3<T>, Serializable {
    public final ws3<T> f;
    public volatile transient boolean g;
    @NullableDecl
    public transient T h;

    public xs3(ws3<T> ws3) {
        Objects.requireNonNull(ws3);
        this.f = ws3;
    }

    public final String toString() {
        Object obj;
        if (this.g) {
            String valueOf = String.valueOf(this.h);
            obj = hj1.y(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        } else {
            obj = this.f;
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
                    return zza;
                }
            }
        }
        return this.h;
    }
}
