package defpackage;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: vs3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class vs3<T> extends us3<T> {
    public final T f;

    public vs3(T t) {
        this.f = t;
    }

    @Override // defpackage.us3
    public final boolean b() {
        return true;
    }

    @Override // defpackage.us3
    public final T c() {
        return this.f;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof vs3) {
            return this.f.equals(((vs3) obj).f);
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
