package defpackage;

import java.lang.annotation.Annotation;

/* renamed from: kb3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class kb3 implements Annotation {

    /* renamed from: a  reason: collision with root package name */
    public final int f2044a;
    public final nb3 b;

    public kb3(int i, nb3 nb3) {
        this.f2044a = i;
        this.b = nb3;
    }

    @Override // java.lang.annotation.Annotation
    public final Class<? extends Annotation> annotationType() {
        return kb3.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kb3)) {
            return false;
        }
        kb3 kb3 = (kb3) obj;
        return this.f2044a == kb3.f2044a && this.b.equals(kb3.b);
    }

    public final int hashCode() {
        return (this.f2044a ^ 14552422) + (this.b.hashCode() ^ 2041407134);
    }

    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf" + "(tag=" + this.f2044a + "intEncoding=" + this.b + ')';
    }
}
