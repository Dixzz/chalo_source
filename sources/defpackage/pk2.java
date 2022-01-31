package defpackage;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: pk2  reason: default package */
public final class pk2 extends ak2<pk2> implements Cloneable {
    public String[] h;
    public String[] i;
    public int[] j = fk2.f1133a;
    public long[] k;
    public long[] l;

    public pk2() {
        String[] strArr = fk2.c;
        this.h = strArr;
        this.i = strArr;
        long[] jArr = fk2.b;
        this.k = jArr;
        this.l = jArr;
        this.g = null;
        this.f = -1;
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final void a(yj2 yj2) throws IOException {
        String[] strArr = this.h;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.h;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    yj2.c(1, str);
                }
                i3++;
            }
        }
        String[] strArr3 = this.i;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.i;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    yj2.c(2, str2);
                }
                i4++;
            }
        }
        int[] iArr = this.j;
        if (iArr != null && iArr.length > 0) {
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.j;
                if (i5 >= iArr2.length) {
                    break;
                }
                yj2.k(3, iArr2[i5]);
                i5++;
            }
        }
        long[] jArr = this.k;
        if (jArr != null && jArr.length > 0) {
            int i6 = 0;
            while (true) {
                long[] jArr2 = this.k;
                if (i6 >= jArr2.length) {
                    break;
                }
                yj2.o(4, jArr2[i6]);
                i6++;
            }
        }
        long[] jArr3 = this.l;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.l;
                if (i2 >= jArr4.length) {
                    break;
                }
                yj2.o(5, jArr4[i2]);
                i2++;
            }
        }
        super.a(yj2);
    }

    @Override // defpackage.ak2, java.lang.Object, defpackage.ek2
    public final Object clone() throws CloneNotSupportedException {
        try {
            pk2 pk2 = (pk2) super.clone();
            String[] strArr = this.h;
            if (strArr != null && strArr.length > 0) {
                pk2.h = (String[]) strArr.clone();
            }
            String[] strArr2 = this.i;
            if (strArr2 != null && strArr2.length > 0) {
                pk2.i = (String[]) strArr2.clone();
            }
            int[] iArr = this.j;
            if (iArr != null && iArr.length > 0) {
                pk2.j = (int[]) iArr.clone();
            }
            long[] jArr = this.k;
            if (jArr != null && jArr.length > 0) {
                pk2.k = (long[]) jArr.clone();
            }
            long[] jArr2 = this.l;
            if (jArr2 != null && jArr2.length > 0) {
                pk2.l = (long[]) jArr2.clone();
            }
            return pk2;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final int d() {
        int i2;
        long[] jArr;
        int[] iArr;
        super.d();
        String[] strArr = this.h;
        int i3 = 0;
        if (strArr == null || strArr.length <= 0) {
            i2 = 0;
        } else {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.h;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i4];
                if (str != null) {
                    i6++;
                    int a2 = yj2.a(str);
                    i5 += yj2.t(a2) + a2;
                }
                i4++;
            }
            i2 = (i6 * 1) + i5 + 0;
        }
        String[] strArr3 = this.i;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.i;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i7];
                if (str2 != null) {
                    i9++;
                    int a3 = yj2.a(str2);
                    i8 += yj2.t(a3) + a3;
                }
                i7++;
            }
            i2 = i2 + i8 + (i9 * 1);
        }
        int[] iArr2 = this.j;
        if (iArr2 != null && iArr2.length > 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                iArr = this.j;
                if (i10 >= iArr.length) {
                    break;
                }
                i11 += yj2.s(iArr[i10]);
                i10++;
            }
            i2 = i2 + i11 + (iArr.length * 1);
        }
        long[] jArr2 = this.k;
        if (jArr2 != null && jArr2.length > 0) {
            int i12 = 0;
            int i13 = 0;
            while (true) {
                jArr = this.k;
                if (i12 >= jArr.length) {
                    break;
                }
                i13 += yj2.q(jArr[i12]);
                i12++;
            }
            i2 = i2 + i13 + (jArr.length * 1);
        }
        long[] jArr3 = this.l;
        if (jArr3 == null || jArr3.length <= 0) {
            return i2;
        }
        int i14 = 0;
        while (true) {
            long[] jArr4 = this.l;
            if (i3 >= jArr4.length) {
                return i2 + i14 + (jArr4.length * 1);
            }
            i14 += yj2.q(jArr4[i3]);
            i3++;
        }
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final /* synthetic */ ek2 e() throws CloneNotSupportedException {
        return (pk2) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof pk2)) {
            return false;
        }
        pk2 pk2 = (pk2) obj;
        if (!dk2.c(this.h, pk2.h) || !dk2.c(this.i, pk2.i) || !dk2.a(this.j, pk2.j) || !dk2.b(this.k, pk2.k) || !dk2.b(this.l, pk2.l)) {
            return false;
        }
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            return this.g.equals(pk2.g);
        }
        bk2 bk22 = pk2.g;
        return bk22 == null || bk22.a();
    }

    /* Return type fixed from 'ak2' to match base method */
    @Override // defpackage.ak2
    public final /* synthetic */ pk2 f() throws CloneNotSupportedException {
        return (pk2) clone();
    }

    public final int hashCode() {
        int hashCode = (((((pk2.class.getName().hashCode() + 527) * 31) + dk2.d(this.h)) * 31) + dk2.d(this.i)) * 31;
        int[] iArr = this.j;
        int i2 = 0;
        int hashCode2 = (hashCode + ((iArr == null || iArr.length == 0) ? 0 : Arrays.hashCode(iArr))) * 31;
        long[] jArr = this.k;
        int hashCode3 = (hashCode2 + ((jArr == null || jArr.length == 0) ? 0 : Arrays.hashCode(jArr))) * 31;
        long[] jArr2 = this.l;
        int hashCode4 = (hashCode3 + ((jArr2 == null || jArr2.length == 0) ? 0 : Arrays.hashCode(jArr2))) * 31;
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            i2 = this.g.hashCode();
        }
        return hashCode4 + i2;
    }
}
