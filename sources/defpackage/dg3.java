package defpackage;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: dg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class dg3<T> extends eg3<T> {
    public static final dg3<Object> f = new dg3<>();

    @Override // defpackage.eg3
    public final T a() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // defpackage.eg3
    public final boolean b() {
        return false;
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
