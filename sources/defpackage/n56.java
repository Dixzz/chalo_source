package defpackage;

import java.io.Serializable;

/* renamed from: n56  reason: default package */
/* compiled from: Result.kt */
public final class n56<T> implements Serializable {

    /* renamed from: n56$a */
    /* compiled from: Result.kt */
    public static final class a implements Serializable {
        public final Throwable f;

        public a(Throwable th) {
            n86.e(th, "exception");
            this.f = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && n86.a(this.f, ((a) obj).f);
        }

        public int hashCode() {
            return this.f.hashCode();
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Failure(");
            i0.append(this.f);
            i0.append(')');
            return i0.toString();
        }
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).f;
        }
        return null;
    }
}
