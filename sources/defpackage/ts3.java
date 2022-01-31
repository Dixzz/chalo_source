package defpackage;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: ts3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ts3<T> extends us3<T> {
    public static final ts3<Object> f = new ts3<>();

    @Override // defpackage.us3
    public final boolean b() {
        return false;
    }

    @Override // defpackage.us3
    public final T c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
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
