package defpackage;

import defpackage.gv1;
import java.util.Map;
import java.util.Objects;

/* renamed from: bv1  reason: default package */
/* compiled from: AutoValue_EventInternal */
public final class bv1 extends gv1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f479a;
    public final Integer b;
    public final fv1 c;
    public final long d;
    public final long e;
    public final Map<String, String> f;

    /* renamed from: bv1$b */
    /* compiled from: AutoValue_EventInternal */
    public static final class b extends gv1.a {

        /* renamed from: a  reason: collision with root package name */
        public String f480a;
        public Integer b;
        public fv1 c;
        public Long d;
        public Long e;
        public Map<String, String> f;

        @Override // defpackage.gv1.a
        public gv1 b() {
            String str = this.f480a == null ? " transportName" : "";
            if (this.c == null) {
                str = hj1.S(str, " encodedPayload");
            }
            if (this.d == null) {
                str = hj1.S(str, " eventMillis");
            }
            if (this.e == null) {
                str = hj1.S(str, " uptimeMillis");
            }
            if (this.f == null) {
                str = hj1.S(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new bv1(this.f480a, this.b, this.c, this.d.longValue(), this.e.longValue(), this.f, null);
            }
            throw new IllegalStateException(hj1.S("Missing required properties:", str));
        }

        @Override // defpackage.gv1.a
        public Map<String, String> c() {
            Map<String, String> map = this.f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public gv1.a d(fv1 fv1) {
            Objects.requireNonNull(fv1, "Null encodedPayload");
            this.c = fv1;
            return this;
        }

        public gv1.a e(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        public gv1.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f480a = str;
            return this;
        }

        public gv1.a g(long j) {
            this.e = Long.valueOf(j);
            return this;
        }
    }

    public bv1(String str, Integer num, fv1 fv1, long j, long j2, Map map, a aVar) {
        this.f479a = str;
        this.b = num;
        this.c = fv1;
        this.d = j;
        this.e = j2;
        this.f = map;
    }

    @Override // defpackage.gv1
    public Map<String, String> b() {
        return this.f;
    }

    @Override // defpackage.gv1
    public Integer c() {
        return this.b;
    }

    @Override // defpackage.gv1
    public fv1 d() {
        return this.c;
    }

    @Override // defpackage.gv1
    public long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gv1)) {
            return false;
        }
        gv1 gv1 = (gv1) obj;
        if (!this.f479a.equals(gv1.g()) || ((num = this.b) != null ? !num.equals(gv1.c()) : gv1.c() != null) || !this.c.equals(gv1.d()) || this.d != gv1.e() || this.e != gv1.h() || !this.f.equals(gv1.b())) {
            return false;
        }
        return true;
    }

    @Override // defpackage.gv1
    public String g() {
        return this.f479a;
    }

    @Override // defpackage.gv1
    public long h() {
        return this.e;
    }

    public int hashCode() {
        int hashCode = (this.f479a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.d;
        long j2 = this.e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("EventInternal{transportName=");
        i0.append(this.f479a);
        i0.append(", code=");
        i0.append(this.b);
        i0.append(", encodedPayload=");
        i0.append(this.c);
        i0.append(", eventMillis=");
        i0.append(this.d);
        i0.append(", uptimeMillis=");
        i0.append(this.e);
        i0.append(", autoMetadata=");
        i0.append(this.f);
        i0.append("}");
        return i0.toString();
    }
}
