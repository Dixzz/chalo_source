package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: dx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class dx3 {
    public static final dx3 f = new dx3(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f900a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public dx3() {
        this(0, new int[8], new Object[8], true);
    }

    public static void b(int i, Object obj, wx3 wx3) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((du3) wx3).f889a.g(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((du3) wx3).f889a.z(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((du3) wx3).f889a.h(i2, (qt3) obj);
        } else if (i3 == 3) {
            du3 du3 = (du3) wx3;
            du3.f889a.f(i2, 3);
            ((dx3) obj).d(wx3);
            du3.f889a.f(i2, 4);
        } else if (i3 == 5) {
            ((du3) wx3).f889a.G(i2, ((Integer) obj).intValue());
        } else {
            int i4 = cv3.f;
            throw new RuntimeException(new bv3("Protocol message tag had invalid wire type."));
        }
    }

    public static dx3 c() {
        return new dx3(0, new int[8], new Object[8], true);
    }

    public final void a(int i, Object obj) {
        if (this.e) {
            int i2 = this.f900a;
            int[] iArr = this.b;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.b = Arrays.copyOf(iArr, i3);
                this.c = Arrays.copyOf(this.c, i3);
            }
            int[] iArr2 = this.b;
            int i4 = this.f900a;
            iArr2[i4] = i;
            this.c[i4] = obj;
            this.f900a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(wx3 wx3) throws IOException {
        if (this.f900a != 0) {
            Objects.requireNonNull(wx3);
            for (int i = 0; i < this.f900a; i++) {
                b(this.b[i], this.c[i], wx3);
            }
        }
    }

    public final int e() {
        int i;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f900a; i4++) {
            int i5 = this.b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = bu3.E(i6, ((Long) this.c[i4]).longValue());
            } else if (i7 == 1) {
                ((Long) this.c[i4]).longValue();
                i = bu3.N(i6);
            } else if (i7 == 2) {
                i = bu3.w(i6, (qt3) this.c[i4]);
            } else if (i7 == 3) {
                i3 = ((dx3) this.c[i4]).e() + (bu3.D(i6) << 1) + i3;
            } else if (i7 == 5) {
                ((Integer) this.c[i4]).intValue();
                i = bu3.S(i6);
            } else {
                int i8 = cv3.f;
                throw new IllegalStateException(new bv3("Protocol message tag had invalid wire type."));
            }
            i3 = i + i3;
        }
        this.d = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof dx3)) {
            return false;
        }
        dx3 dx3 = (dx3) obj;
        int i = this.f900a;
        if (i == dx3.f900a) {
            int[] iArr = this.b;
            int[] iArr2 = dx3.b;
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
                Object[] objArr2 = dx3.c;
                int i3 = this.f900a;
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
        int i = this.f900a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.c;
        int i7 = this.f900a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public dx3(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f900a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
