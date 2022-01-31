package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: ej2  reason: default package */
public final class ej2 {
    public static final ej2 f = new ej2(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f979a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public ej2() {
        this(0, new int[8], new Object[8], true);
    }

    public ej2(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f979a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static void c(int i, Object obj, xj2 xj2) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((dg2) xj2).f832a.e(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((dg2) xj2).f832a.B(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((dg2) xj2).f832a.f(i2, (uf2) obj);
        } else if (i3 == 3) {
            dg2 dg2 = (dg2) xj2;
            dg2.f832a.p(i2, 3);
            ((ej2) obj).d(xj2);
            dg2.f832a.p(i2, 4);
        } else if (i3 == 5) {
            ((dg2) xj2).f832a.I(i2, ((Integer) obj).intValue());
        } else {
            int i4 = ah2.f;
            throw new RuntimeException(new bh2("Protocol message tag had invalid wire type."));
        }
    }

    public static ej2 e() {
        return new ej2(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int i;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f979a; i4++) {
            int i5 = this.b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = bg2.F(i6, ((Long) this.c[i4]).longValue());
            } else if (i7 == 1) {
                ((Long) this.c[i4]).longValue();
                i = bg2.J(i6);
            } else if (i7 == 2) {
                i = bg2.w(i6, (uf2) this.c[i4]);
            } else if (i7 == 3) {
                i3 = ((ej2) this.c[i4]).a() + (bg2.X(i6) << 1) + i3;
            } else if (i7 == 5) {
                ((Integer) this.c[i4]).intValue();
                i = bg2.Q(i6);
            } else {
                int i8 = ah2.f;
                throw new IllegalStateException(new bh2("Protocol message tag had invalid wire type."));
            }
            i3 = i + i3;
        }
        this.d = i3;
        return i3;
    }

    public final void b(int i, Object obj) {
        if (this.e) {
            int i2 = this.f979a;
            int[] iArr = this.b;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.b = Arrays.copyOf(iArr, i3);
                this.c = Arrays.copyOf(this.c, i3);
            }
            int[] iArr2 = this.b;
            int i4 = this.f979a;
            iArr2[i4] = i;
            this.c[i4] = obj;
            this.f979a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(xj2 xj2) throws IOException {
        if (this.f979a != 0) {
            Objects.requireNonNull(xj2);
            for (int i = 0; i < this.f979a; i++) {
                c(this.b[i], this.c[i], xj2);
            }
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ej2)) {
            return false;
        }
        ej2 ej2 = (ej2) obj;
        int i = this.f979a;
        if (i == ej2.f979a) {
            int[] iArr = this.b;
            int[] iArr2 = ej2.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.c;
                Object[] objArr2 = ej2.c;
                int i3 = this.f979a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.f979a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.c;
        int i7 = this.f979a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
