package defpackage;

/* renamed from: rs  reason: default package */
/* compiled from: WorkSpec */
public final class rs {

    /* renamed from: a  reason: collision with root package name */
    public String f3122a;
    public zp b = zp.ENQUEUED;
    public String c;
    public String d;
    public np e;
    public np f;
    public long g;
    public long h;
    public long i;
    public lp j;
    public int k;
    public jp l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;

    /* renamed from: rs$a */
    /* compiled from: WorkSpec */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f3123a;
        public zp b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            return this.f3123a.equals(aVar.f3123a);
        }

        public int hashCode() {
            return this.b.hashCode() + (this.f3123a.hashCode() * 31);
        }
    }

    static {
        tp.e("WorkSpec");
    }

    public rs(String str, String str2) {
        np npVar = np.c;
        this.e = npVar;
        this.f = npVar;
        this.j = lp.i;
        this.l = jp.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.f3122a = str;
        this.c = str2;
    }

    public long a() {
        long j2;
        long j3;
        long j4;
        boolean z = false;
        if (this.b == zp.ENQUEUED && this.k > 0) {
            if (this.l == jp.LINEAR) {
                z = true;
            }
            if (z) {
                j4 = this.m * ((long) this.k);
            } else {
                j4 = (long) Math.scalb((float) this.m, this.k - 1);
            }
            j3 = this.n;
            j2 = Math.min(18000000L, j4);
        } else {
            long j5 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = this.n;
                int i2 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
                if (i2 == 0) {
                    j6 = this.g + currentTimeMillis;
                }
                long j7 = this.i;
                long j8 = this.h;
                if (j7 != j8) {
                    z = true;
                }
                if (z) {
                    if (i2 == 0) {
                        j5 = j7 * -1;
                    }
                    return j6 + j8 + j5;
                }
                if (i2 != 0) {
                    j5 = j8;
                }
                return j6 + j5;
            }
            j2 = this.n;
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
            }
            j3 = this.g;
        }
        return j2 + j3;
    }

    public boolean b() {
        return !lp.i.equals(this.j);
    }

    public boolean c() {
        return this.h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rs)) {
            return false;
        }
        rs rsVar = (rs) obj;
        if (this.g != rsVar.g || this.h != rsVar.h || this.i != rsVar.i || this.k != rsVar.k || this.m != rsVar.m || this.n != rsVar.n || this.o != rsVar.o || this.p != rsVar.p || this.q != rsVar.q || !this.f3122a.equals(rsVar.f3122a) || this.b != rsVar.b || !this.c.equals(rsVar.c)) {
            return false;
        }
        String str = this.d;
        if (str == null ? rsVar.d != null : !str.equals(rsVar.d)) {
            return false;
        }
        if (this.e.equals(rsVar.e) && this.f.equals(rsVar.f) && this.j.equals(rsVar.j) && this.l == rsVar.l) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.c, (this.b.hashCode() + (this.f3122a.hashCode() * 31)) * 31, 31);
        String str = this.d;
        int hashCode = str != null ? str.hashCode() : 0;
        int hashCode2 = this.e.hashCode();
        int hashCode3 = this.f.hashCode();
        long j2 = this.g;
        long j3 = this.h;
        long j4 = this.i;
        int hashCode4 = this.j.hashCode();
        int hashCode5 = this.l.hashCode();
        long j5 = this.m;
        long j6 = this.n;
        long j7 = this.o;
        long j8 = this.p;
        return ((((((((((hashCode5 + ((((hashCode4 + ((((((((hashCode3 + ((hashCode2 + ((r0 + hashCode) * 31)) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31)) * 31) + this.k) * 31)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.q ? 1 : 0);
    }

    public String toString() {
        return hj1.a0(hj1.i0("{WorkSpec: "), this.f3122a, "}");
    }

    public rs(rs rsVar) {
        np npVar = np.c;
        this.e = npVar;
        this.f = npVar;
        this.j = lp.i;
        this.l = jp.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.f3122a = rsVar.f3122a;
        this.c = rsVar.c;
        this.b = rsVar.b;
        this.d = rsVar.d;
        this.e = new np(rsVar.e);
        this.f = new np(rsVar.f);
        this.g = rsVar.g;
        this.h = rsVar.h;
        this.i = rsVar.i;
        this.j = new lp(rsVar.j);
        this.k = rsVar.k;
        this.l = rsVar.l;
        this.m = rsVar.m;
        this.n = rsVar.n;
        this.o = rsVar.o;
        this.p = rsVar.p;
        this.q = rsVar.q;
    }
}
