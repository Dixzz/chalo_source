package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: in5  reason: default package */
/* compiled from: InAppRemoteConfig */
public class in5 {

    /* renamed from: a  reason: collision with root package name */
    public final a f1540a;

    /* renamed from: in5$a */
    /* compiled from: InAppRemoteConfig */
    public static class a {
        public static final long e;
        public static final long f;
        public static final long g;
        public static final /* synthetic */ int h = 0;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1541a;
        public final long b;
        public final long c;
        public final long d;

        static {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            e = timeUnit.toSeconds(600000);
            f = timeUnit.toSeconds(3600000);
            g = timeUnit.toSeconds(600000);
        }

        public a(boolean z, long j, long j2, long j3) {
            this.f1541a = z;
            this.b = j;
            this.c = j2;
            this.d = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1541a == aVar.f1541a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.b;
            long j2 = this.c;
            long j3 = this.d;
            return ((((((this.f1541a ? 1 : 0) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }

    public in5(a aVar) {
        this.f1540a = aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || in5.class != obj.getClass()) {
            return false;
        }
        return this.f1540a.equals(((in5) obj).f1540a);
    }

    public int hashCode() {
        return this.f1540a.hashCode();
    }
}
