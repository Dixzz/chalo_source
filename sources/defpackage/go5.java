package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: go5  reason: default package */
/* compiled from: FrequencyConstraint */
public class go5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1290a;
    public final long b;
    public final int c;

    /* renamed from: go5$b */
    /* compiled from: FrequencyConstraint */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f1291a;
        public long b;
        public int c;

        public b(a aVar) {
        }

        public b a(TimeUnit timeUnit, long j) {
            this.b = timeUnit.toMillis(j);
            return this;
        }
    }

    public go5(b bVar, a aVar) {
        this.f1290a = bVar.f1291a;
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || go5.class != obj.getClass()) {
            return false;
        }
        go5 go5 = (go5) obj;
        if (this.b == go5.b && this.c == go5.c) {
            return this.f1290a.equals(go5.f1290a);
        }
        return false;
    }

    public int hashCode() {
        long j = this.b;
        return (((this.f1290a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.c;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("FrequencyConstraint{id='");
        hj1.U0(i0, this.f1290a, '\'', ", range=");
        i0.append(this.b);
        i0.append(", count=");
        return hj1.W(i0, this.c, '}');
    }
}
