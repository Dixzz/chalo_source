package defpackage;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: hg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class hg3<T> implements gg3<T> {
    public volatile gg3<T> f;
    public volatile boolean g;
    @NullableDecl
    public T h;

    public hg3(gg3<T> gg3) {
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
                    this.f = null;
                    return t;
                }
            }
        }
        return this.h;
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
}
