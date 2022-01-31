package defpackage;

/* renamed from: rt5  reason: default package */
/* compiled from: JobInfo */
public class rt5 {

    /* renamed from: a  reason: collision with root package name */
    public final zt5 f3129a;
    public final String b;
    public final String c;
    public final boolean d;
    public final long e;
    public final int f;

    /* renamed from: rt5$b */
    /* compiled from: JobInfo */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f3130a;
        public String b;
        public boolean c;
        public long d;
        public zt5 e;
        public int f = 0;

        public b(a aVar) {
        }

        public rt5 a() {
            hd3.E(this.f3130a, "Missing action.");
            return new rt5(this, null);
        }

        public b b(Class<? extends oj5> cls) {
            this.b = cls.getName();
            return this;
        }
    }

    public rt5(b bVar, a aVar) {
        this.b = bVar.f3130a;
        String str = bVar.b;
        this.c = str == null ? "" : str;
        zt5 zt5 = bVar.e;
        this.f3129a = zt5 == null ? zt5.g : zt5;
        this.d = bVar.c;
        this.e = bVar.d;
        this.f = bVar.f;
    }

    public static b a() {
        return new b(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rt5.class != obj.getClass()) {
            return false;
        }
        rt5 rt5 = (rt5) obj;
        if (this.d == rt5.d && this.e == rt5.e && this.f == rt5.f && this.f3129a.equals(rt5.f3129a) && this.b.equals(rt5.b)) {
            return this.c.equals(rt5.c);
        }
        return false;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.b, this.f3129a.hashCode() * 31, 31);
        long j = this.e;
        return ((((hj1.r0(this.c, r0, 31) + (this.d ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("JobInfo{extras=");
        i0.append(this.f3129a);
        i0.append(", action='");
        hj1.U0(i0, this.b, '\'', ", airshipComponentName='");
        hj1.U0(i0, this.c, '\'', ", isNetworkAccessRequired=");
        i0.append(this.d);
        i0.append(", initialDelay=");
        i0.append(this.e);
        i0.append(", conflictStrategy=");
        return hj1.W(i0, this.f, '}');
    }
}
