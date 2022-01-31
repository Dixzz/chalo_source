package defpackage;

import java.util.Map;

/* renamed from: kb  reason: default package */
/* compiled from: Preferences.kt */
public abstract class kb {

    /* renamed from: kb$a */
    /* compiled from: Preferences.kt */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f2041a;

        public a(String str) {
            n86.e(str, "name");
            this.f2041a = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return n86.a(this.f2041a, ((a) obj).f2041a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2041a.hashCode();
        }

        public String toString() {
            return this.f2041a;
        }
    }

    /* renamed from: kb$b */
    /* compiled from: Preferences.kt */
    public static final class b<T> {
    }

    public abstract Map<a<?>, Object> a();
}
