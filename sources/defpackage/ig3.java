package defpackage;

import java.io.Serializable;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: ig3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ig3<T> implements gg3<T>, Serializable {
    public final gg3<T> f;
    public volatile transient boolean g;
    @NullableDecl
    public transient T h;

    public ig3(gg3<T> gg3) {
        Objects.requireNonNull(gg3);
        this.f = gg3;
    }

    @Override // defpackage.gg3
    public final T get() {
        if (!this.g) {
            synchronized (this) {
                if (!this.g) {
                    T t = this.f.get();
                    this.h = t;
                    this.g = true;
                    return t;
                }
            }
        }
        return this.h;
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
}
