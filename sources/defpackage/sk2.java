package defpackage;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: sk2  reason: default package */
public final class sk2 extends ak2<sk2> implements Cloneable {
    public long h = 0;
    public long i = 0;
    public tk2[] j;
    public byte[] k;
    public gk2 l;
    public byte[] m;
    public String n;
    public String o;
    public pk2 p;
    public String q;
    public long r;
    public qk2 s;
    public byte[] t;
    public String u;
    public int[] v;
    public hk2 w;
    public boolean x;

    public sk2() {
        if (tk2.h == null) {
            synchronized (dk2.f848a) {
                if (tk2.h == null) {
                    tk2.h = new tk2[0];
                }
            }
        }
        this.j = tk2.h;
        byte[] bArr = fk2.e;
        this.k = bArr;
        this.l = null;
        this.m = bArr;
        this.n = "";
        this.o = "";
        this.p = null;
        this.q = "";
        this.r = 180000;
        this.s = null;
        this.t = bArr;
        this.u = "";
        this.v = fk2.f1133a;
        this.w = null;
        this.x = false;
        this.g = null;
        this.f = -1;
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final void a(yj2 yj2) throws IOException {
        long j2 = this.h;
        if (j2 != 0) {
            yj2.o(1, j2);
        }
        tk2[] tk2Arr = this.j;
        if (tk2Arr != null && tk2Arr.length > 0) {
            int i2 = 0;
            while (true) {
                tk2[] tk2Arr2 = this.j;
                if (i2 >= tk2Arr2.length) {
                    break;
                }
                tk2 tk2 = tk2Arr2[i2];
                if (tk2 != null) {
                    yj2.b(3, tk2);
                }
                i2++;
            }
        }
        byte[] bArr = this.k;
        byte[] bArr2 = fk2.e;
        if (!Arrays.equals(bArr, bArr2)) {
            yj2.d(4, this.k);
        }
        if (!Arrays.equals(this.m, bArr2)) {
            yj2.d(6, this.m);
        }
        pk2 pk2 = this.p;
        if (pk2 != null) {
            yj2.b(7, pk2);
        }
        String str = this.n;
        if (str != null && !str.equals("")) {
            yj2.c(8, this.n);
        }
        gk2 gk2 = this.l;
        if (gk2 != null) {
            yj2.n(9, gk2);
        }
        String str2 = this.o;
        if (str2 != null && !str2.equals("")) {
            yj2.c(13, this.o);
        }
        String str3 = this.q;
        if (str3 != null && !str3.equals("")) {
            yj2.c(14, this.q);
        }
        long j3 = this.r;
        if (j3 != 180000) {
            yj2.j(15, 0);
            yj2.p((j3 >> 63) ^ (j3 << 1));
        }
        qk2 qk2 = this.s;
        if (qk2 != null) {
            yj2.b(16, qk2);
        }
        long j4 = this.i;
        if (j4 != 0) {
            yj2.o(17, j4);
        }
        if (!Arrays.equals(this.t, bArr2)) {
            yj2.d(18, this.t);
        }
        int[] iArr = this.v;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.v;
                if (i3 >= iArr2.length) {
                    break;
                }
                yj2.k(20, iArr2[i3]);
                i3++;
            }
        }
        hk2 hk2 = this.w;
        if (hk2 != null) {
            yj2.n(23, hk2);
        }
        String str4 = this.u;
        if (str4 != null && !str4.equals("")) {
            yj2.c(24, this.u);
        }
        boolean z = this.x;
        if (z) {
            yj2.j(25, 0);
            byte b = z ? (byte) 1 : 0;
            if (yj2.f4057a.hasRemaining()) {
                yj2.f4057a.put(b);
            } else {
                throw new zj2(yj2.f4057a.position(), yj2.f4057a.limit());
            }
        }
        super.a(yj2);
    }

    @Override // defpackage.ak2, java.lang.Object, defpackage.ek2
    public final Object clone() throws CloneNotSupportedException {
        try {
            sk2 sk2 = (sk2) super.clone();
            tk2[] tk2Arr = this.j;
            if (tk2Arr != null && tk2Arr.length > 0) {
                sk2.j = new tk2[tk2Arr.length];
                int i2 = 0;
                while (true) {
                    tk2[] tk2Arr2 = this.j;
                    if (i2 >= tk2Arr2.length) {
                        break;
                    }
                    if (tk2Arr2[i2] != null) {
                        sk2.j[i2] = (tk2) tk2Arr2[i2].clone();
                    }
                    i2++;
                }
            }
            gk2 gk2 = this.l;
            if (gk2 != null) {
                sk2.l = gk2;
            }
            pk2 pk2 = this.p;
            if (pk2 != null) {
                sk2.p = (pk2) pk2.clone();
            }
            qk2 qk2 = this.s;
            if (qk2 != null) {
                sk2.s = (qk2) qk2.clone();
            }
            int[] iArr = this.v;
            if (iArr != null && iArr.length > 0) {
                sk2.v = (int[]) iArr.clone();
            }
            hk2 hk2 = this.w;
            if (hk2 != null) {
                sk2.w = hk2;
            }
            return sk2;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final int d() {
        int[] iArr;
        super.d();
        long j2 = this.h;
        int i2 = 0;
        int l2 = j2 != 0 ? yj2.l(1, j2) + 0 : 0;
        tk2[] tk2Arr = this.j;
        if (tk2Arr != null && tk2Arr.length > 0) {
            int i3 = 0;
            while (true) {
                tk2[] tk2Arr2 = this.j;
                if (i3 >= tk2Arr2.length) {
                    break;
                }
                tk2 tk2 = tk2Arr2[i3];
                if (tk2 != null) {
                    l2 += yj2.g(3, tk2);
                }
                i3++;
            }
        }
        byte[] bArr = this.k;
        byte[] bArr2 = fk2.e;
        if (!Arrays.equals(bArr, bArr2)) {
            l2 += yj2.i(4, this.k);
        }
        if (!Arrays.equals(this.m, bArr2)) {
            l2 += yj2.i(6, this.m);
        }
        pk2 pk2 = this.p;
        if (pk2 != null) {
            l2 += yj2.g(7, pk2);
        }
        String str = this.n;
        if (str != null && !str.equals("")) {
            l2 += yj2.h(8, this.n);
        }
        gk2 gk2 = this.l;
        if (gk2 != null) {
            l2 += bg2.x(9, gk2);
        }
        String str2 = this.o;
        if (str2 != null && !str2.equals("")) {
            l2 += yj2.h(13, this.o);
        }
        String str3 = this.q;
        if (str3 != null && !str3.equals("")) {
            l2 += yj2.h(14, this.q);
        }
        long j3 = this.r;
        if (j3 != 180000) {
            l2 += yj2.q((j3 >> 63) ^ (j3 << 1)) + yj2.r(15);
        }
        qk2 qk2 = this.s;
        if (qk2 != null) {
            l2 += yj2.g(16, qk2);
        }
        long j4 = this.i;
        if (j4 != 0) {
            l2 += yj2.l(17, j4);
        }
        if (!Arrays.equals(this.t, bArr2)) {
            l2 += yj2.i(18, this.t);
        }
        int[] iArr2 = this.v;
        if (iArr2 != null && iArr2.length > 0) {
            int i4 = 0;
            while (true) {
                iArr = this.v;
                if (i2 >= iArr.length) {
                    break;
                }
                i4 += yj2.s(iArr[i2]);
                i2++;
            }
            l2 = l2 + i4 + (iArr.length * 2);
        }
        hk2 hk2 = this.w;
        if (hk2 != null) {
            l2 += bg2.x(23, hk2);
        }
        String str4 = this.u;
        if (str4 != null && !str4.equals("")) {
            l2 += yj2.h(24, this.u);
        }
        return this.x ? l2 + yj2.r(25) + 1 : l2;
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final /* synthetic */ ek2 e() throws CloneNotSupportedException {
        return (sk2) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sk2)) {
            return false;
        }
        sk2 sk2 = (sk2) obj;
        if (this.h != sk2.h || this.i != sk2.i || !dk2.c(this.j, sk2.j) || !Arrays.equals(this.k, sk2.k)) {
            return false;
        }
        gk2 gk2 = this.l;
        if (gk2 == null) {
            if (sk2.l != null) {
                return false;
            }
        } else if (!gk2.equals(sk2.l)) {
            return false;
        }
        if (!Arrays.equals(this.m, sk2.m)) {
            return false;
        }
        String str = this.n;
        if (str == null) {
            if (sk2.n != null) {
                return false;
            }
        } else if (!str.equals(sk2.n)) {
            return false;
        }
        String str2 = this.o;
        if (str2 == null) {
            if (sk2.o != null) {
                return false;
            }
        } else if (!str2.equals(sk2.o)) {
            return false;
        }
        pk2 pk2 = this.p;
        if (pk2 == null) {
            if (sk2.p != null) {
                return false;
            }
        } else if (!pk2.equals(sk2.p)) {
            return false;
        }
        String str3 = this.q;
        if (str3 == null) {
            if (sk2.q != null) {
                return false;
            }
        } else if (!str3.equals(sk2.q)) {
            return false;
        }
        if (this.r != sk2.r) {
            return false;
        }
        qk2 qk2 = this.s;
        if (qk2 == null) {
            if (sk2.s != null) {
                return false;
            }
        } else if (!qk2.equals(sk2.s)) {
            return false;
        }
        if (!Arrays.equals(this.t, sk2.t)) {
            return false;
        }
        String str4 = this.u;
        if (str4 == null) {
            if (sk2.u != null) {
                return false;
            }
        } else if (!str4.equals(sk2.u)) {
            return false;
        }
        if (!dk2.a(this.v, sk2.v)) {
            return false;
        }
        hk2 hk2 = this.w;
        if (hk2 == null) {
            if (sk2.w != null) {
                return false;
            }
        } else if (!hk2.equals(sk2.w)) {
            return false;
        }
        if (this.x != sk2.x) {
            return false;
        }
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            return this.g.equals(sk2.g);
        }
        bk2 bk22 = sk2.g;
        return bk22 == null || bk22.a();
    }

    /* Return type fixed from 'ak2' to match base method */
    @Override // defpackage.ak2
    public final /* synthetic */ sk2 f() throws CloneNotSupportedException {
        return (sk2) clone();
    }

    public final int hashCode() {
        long j2 = this.h;
        long j3 = this.i;
        int i2 = 0;
        int i3 = 1237;
        int hashCode = Arrays.hashCode(this.k) + ((((((((((((((((sk2.class.getName().hashCode() + 527) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31 * 31) + 0) * 31) + 0) * 31) + 0) * 31 * 31) + 1237) * 31) + dk2.d(this.j)) * 31);
        gk2 gk2 = this.l;
        int hashCode2 = (Arrays.hashCode(this.m) + (((hashCode * 31) + (gk2 == null ? 0 : gk2.hashCode())) * 31)) * 31;
        String str = this.n;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.o;
        int hashCode4 = hashCode3 + (str2 == null ? 0 : str2.hashCode());
        pk2 pk2 = this.p;
        int hashCode5 = ((hashCode4 * 31) + (pk2 == null ? 0 : pk2.hashCode())) * 31;
        String str3 = this.q;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        long j4 = this.r;
        qk2 qk2 = this.s;
        int hashCode7 = (Arrays.hashCode(this.t) + ((((((hashCode5 + hashCode6) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (qk2 == null ? 0 : qk2.hashCode())) * 31)) * 31;
        String str4 = this.u;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31 * 31;
        int[] iArr = this.v;
        int hashCode9 = (iArr == null || iArr.length == 0) ? 0 : Arrays.hashCode(iArr);
        hk2 hk2 = this.w;
        int hashCode10 = (((hashCode8 + hashCode9) * 31 * 31) + (hk2 == null ? 0 : hk2.hashCode())) * 31;
        if (this.x) {
            i3 = 1231;
        }
        int i4 = (hashCode10 + i3) * 31;
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            i2 = this.g.hashCode();
        }
        return i4 + i2;
    }
}
