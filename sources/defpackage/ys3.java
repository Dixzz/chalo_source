package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: ys3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ys3<T> implements ws3<T>, Serializable {
    @NullableDecl
    public final T f;

    public ys3(@NullableDecl T t) {
        this.f = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof ys3) {
            return hd3.S3(this.f, ((ys3) obj).f);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        return hj1.y(valueOf.length() + 22, "Suppliers.ofInstance(", valueOf, ")");
    }

    @Override // defpackage.ws3
    public final T zza() {
        return this.f;
    }
}
