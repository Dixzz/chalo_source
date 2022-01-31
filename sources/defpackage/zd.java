package defpackage;

import defpackage.he;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: zd  reason: default package */
/* compiled from: UnknownFieldSetLite */
public final class zd {
    public static final zd f = new zd(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f4158a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public zd() {
        this(0, new int[8], new Object[8], true);
    }

    public static void c(int i, Object obj, he heVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((yb) heVar).f4026a.Z(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((yb) heVar).f4026a.M(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((yb) heVar).f4026a.I(i2, (ub) obj);
        } else if (i3 == 3) {
            yb ybVar = (yb) heVar;
            he.a aVar = he.a.ASCENDING;
            if (aVar == aVar) {
                ybVar.f4026a.W(i2, 3);
                ((zd) obj).d(heVar);
                ybVar.f4026a.W(i2, 4);
                return;
            }
            ybVar.f4026a.W(i2, 4);
            ((zd) obj).d(heVar);
            ybVar.f4026a.W(i2, 3);
        } else if (i3 == 5) {
            ((yb) heVar).f4026a.K(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(nc.c());
        }
    }

    public int a() {
        int i;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4158a; i4++) {
            int i5 = this.b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = xb.A(i6, ((Long) this.c[i4]).longValue());
            } else if (i7 == 1) {
                i = xb.h(i6, ((Long) this.c[i4]).longValue());
            } else if (i7 == 2) {
                i = xb.c(i6, (ub) this.c[i4]);
            } else if (i7 == 3) {
                i3 = ((zd) this.c[i4]).a() + (xb.x(i6) * 2) + i3;
            } else if (i7 == 5) {
                i = xb.g(i6, ((Integer) this.c[i4]).intValue());
            } else {
                throw new IllegalStateException(nc.c());
            }
            i3 = i + i3;
        }
        this.d = i3;
        return i3;
    }

    public void b(int i, Object obj) {
        if (this.e) {
            int i2 = this.f4158a;
            int[] iArr = this.b;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.b = Arrays.copyOf(iArr, i3);
                this.c = Arrays.copyOf(this.c, i3);
            }
            int[] iArr2 = this.b;
            int i4 = this.f4158a;
            iArr2[i4] = i;
            this.c[i4] = obj;
            this.f4158a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void d(he heVar) throws IOException {
        if (this.f4158a != 0) {
            Objects.requireNonNull((yb) heVar);
            he.a aVar = he.a.ASCENDING;
            if (aVar == aVar) {
                for (int i = 0; i < this.f4158a; i++) {
                    c(this.b[i], this.c[i], heVar);
                }
                return;
            }
            for (int i2 = this.f4158a - 1; i2 >= 0; i2--) {
                c(this.b[i2], this.c[i2], heVar);
            }
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zd)) {
            return false;
        }
        zd zdVar = (zd) obj;
        int i = this.f4158a;
        if (i == zdVar.f4158a) {
            int[] iArr = this.b;
            int[] iArr2 = zdVar.b;
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
                Object[] objArr2 = zdVar.c;
                int i3 = this.f4158a;
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

    public int hashCode() {
        int i = this.f4158a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.c;
        int i7 = this.f4158a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public zd(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f4158a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
