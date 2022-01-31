package j$.time;

import java.io.Serializable;

public abstract class a {

    /* access modifiers changed from: package-private */
    /* renamed from: j$.time.a$a  reason: collision with other inner class name */
    public static final class C0029a extends a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final ZoneId f1592a;

        C0029a(ZoneId zoneId) {
            this.f1592a = zoneId;
        }

        @Override // j$.time.a
        public long a() {
            return System.currentTimeMillis();
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0029a) {
                return this.f1592a.equals(((C0029a) obj).f1592a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1592a.hashCode() + 1;
        }

        public String toString() {
            StringBuilder a2 = j$.com.android.tools.r8.a.a("SystemClock[");
            a2.append(this.f1592a);
            a2.append("]");
            return a2.toString();
        }
    }

    protected a() {
    }

    public static a b() {
        return new C0029a(h.e);
    }

    public abstract long a();
}
