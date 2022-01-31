package defpackage;

import defpackage.zw1;
import java.util.Set;

/* renamed from: xw1  reason: default package */
/* compiled from: AutoValue_SchedulerConfig_ConfigValue */
public final class xw1 extends zw1.a {

    /* renamed from: a  reason: collision with root package name */
    public final long f3971a;
    public final long b;
    public final Set<zw1.b> c;

    /* renamed from: xw1$b */
    /* compiled from: AutoValue_SchedulerConfig_ConfigValue */
    public static final class b extends zw1.a.AbstractC0072a {

        /* renamed from: a  reason: collision with root package name */
        public Long f3972a;
        public Long b;
        public Set<zw1.b> c;

        @Override // defpackage.zw1.a.AbstractC0072a
        public zw1.a a() {
            String str = this.f3972a == null ? " delta" : "";
            if (this.b == null) {
                str = hj1.S(str, " maxAllowedDelay");
            }
            if (this.c == null) {
                str = hj1.S(str, " flags");
            }
            if (str.isEmpty()) {
                return new xw1(this.f3972a.longValue(), this.b.longValue(), this.c, null);
            }
            throw new IllegalStateException(hj1.S("Missing required properties:", str));
        }

        @Override // defpackage.zw1.a.AbstractC0072a
        public zw1.a.AbstractC0072a b(long j) {
            this.f3972a = Long.valueOf(j);
            return this;
        }

        @Override // defpackage.zw1.a.AbstractC0072a
        public zw1.a.AbstractC0072a c(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    public xw1(long j, long j2, Set set, a aVar) {
        this.f3971a = j;
        this.b = j2;
        this.c = set;
    }

    @Override // defpackage.zw1.a
    public long b() {
        return this.f3971a;
    }

    @Override // defpackage.zw1.a
    public Set<zw1.b> c() {
        return this.c;
    }

    @Override // defpackage.zw1.a
    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zw1.a)) {
            return false;
        }
        zw1.a aVar = (zw1.a) obj;
        if (this.f3971a == aVar.b() && this.b == aVar.d() && this.c.equals(aVar.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f3971a;
        long j2 = this.b;
        return this.c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ConfigValue{delta=");
        i0.append(this.f3971a);
        i0.append(", maxAllowedDelay=");
        i0.append(this.b);
        i0.append(", flags=");
        i0.append(this.c);
        i0.append("}");
        return i0.toString();
    }
}
