package defpackage;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: fg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class fg3<T> extends eg3<T> {
    public final T f;

    public fg3(T t) {
        this.f = t;
    }

    @Override // defpackage.eg3
    public final T a() {
        return this.f;
    }

    @Override // defpackage.eg3
    public final boolean b() {
        return true;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof fg3) {
            return this.f.equals(((fg3) obj).f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        return hj1.y(valueOf.length() + 13, "Optional.of(", valueOf, ")");
    }
}
