package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: kg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class kg3<T> implements gg3<T>, Serializable {
    @NullableDecl
    public final T f;

    public kg3(@NullableDecl T t) {
        this.f = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof kg3)) {
            return false;
        }
        T t = this.f;
        T t2 = ((kg3) obj).f;
        if (t == t2) {
            return true;
        }
        if (t == null || !t.equals(t2)) {
            return false;
        }
        return true;
    }

    @Override // defpackage.gg3
    public final T get() {
        return this.f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        return hj1.y(valueOf.length() + 22, "Suppliers.ofInstance(", valueOf, ")");
    }
}
