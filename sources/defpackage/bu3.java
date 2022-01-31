package defpackage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: bu3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class bu3 extends rt3 {
    public static final Logger b = Logger.getLogger(bu3.class.getName());
    public static final boolean c = kx3.g;

    /* renamed from: a  reason: collision with root package name */
    public du3 f475a;

    /* renamed from: bu3$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class a extends IOException {
        public a(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.bu3.a.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    /* renamed from: bu3$b */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class b extends bu3 {
        public final byte[] d;
        public final int e;
        public int f;

        public b(byte[] bArr, int i) {
            super(null);
            if ((i | 0 | (bArr.length - i)) >= 0) {
                this.d = bArr;
                this.f = 0;
                this.e = i;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }

        @Override // defpackage.bu3
        public final void A(long j) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                bArr[i] = (byte) ((int) j);
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) ((int) (j >> 8));
                int i4 = i3 + 1;
                this.f = i4;
                bArr[i3] = (byte) ((int) (j >> 16));
                int i5 = i4 + 1;
                this.f = i5;
                bArr[i4] = (byte) ((int) (j >> 24));
                int i6 = i5 + 1;
                this.f = i6;
                bArr[i5] = (byte) ((int) (j >> 32));
                int i7 = i6 + 1;
                this.f = i7;
                bArr[i6] = (byte) ((int) (j >> 40));
                int i8 = i7 + 1;
                this.f = i8;
                bArr[i7] = (byte) ((int) (j >> 48));
                this.f = i8 + 1;
                bArr[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        @Override // defpackage.bu3
        public final void C(int i) throws IOException {
            try {
                byte[] bArr = this.d;
                int i2 = this.f;
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.f = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.f = i5;
                bArr[i4] = (byte) (i >> 16);
                this.f = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        @Override // defpackage.bu3
        public final void G(int i, int i2) throws IOException {
            r((i << 3) | 5);
            C(i2);
        }

        public final void W(qt3 qt3) throws IOException {
            r(qt3.d());
            qt3.u(this);
        }

        public final void X(cw3 cw3) throws IOException {
            r(cw3.a());
            cw3.b(this);
        }

        public final void Y(String str) throws IOException {
            int i = this.f;
            try {
                int L = bu3.L(str.length() * 3);
                int L2 = bu3.L(str.length());
                if (L2 == L) {
                    int i2 = i + L2;
                    this.f = i2;
                    int b = lx3.f2290a.b(str, this.d, i2, a());
                    this.f = i;
                    r((b - i) - L2);
                    this.f = b;
                    return;
                }
                r(lx3.a(str));
                this.f = lx3.f2290a.b(str, this.d, this.f, a());
            } catch (px3 e2) {
                this.f = i;
                bu3.b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
                byte[] bytes = str.getBytes(tu3.f3407a);
                try {
                    r(bytes.length);
                    Z(bytes, 0, bytes.length);
                } catch (IndexOutOfBoundsException e3) {
                    throw new a(e3);
                } catch (a e4) {
                    throw e4;
                }
            } catch (IndexOutOfBoundsException e5) {
                throw new a(e5);
            }
        }

        public final void Z(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e2);
            }
        }

        @Override // defpackage.bu3
        public final int a() {
            return this.e - this.f;
        }

        @Override // defpackage.bu3
        public final void d(byte b) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        @Override // defpackage.bu3
        public final void e(int i) throws IOException {
            if (i >= 0) {
                r(i);
            } else {
                m((long) i);
            }
        }

        @Override // defpackage.bu3
        public final void f(int i, int i2) throws IOException {
            r((i << 3) | i2);
        }

        @Override // defpackage.bu3
        public final void g(int i, long j) throws IOException {
            r((i << 3) | 0);
            m(j);
        }

        @Override // defpackage.bu3
        public final void h(int i, qt3 qt3) throws IOException {
            r((i << 3) | 2);
            W(qt3);
        }

        @Override // defpackage.bu3
        public final void i(int i, cw3 cw3) throws IOException {
            f(1, 3);
            y(2, i);
            f(3, 2);
            X(cw3);
            f(1, 4);
        }

        @Override // defpackage.bu3
        public final void j(int i, cw3 cw3, qw3 qw3) throws IOException {
            r((i << 3) | 2);
            it3 it3 = (it3) cw3;
            int i2 = it3.i();
            if (i2 == -1) {
                i2 = qw3.c(it3);
                it3.j(i2);
            }
            r(i2);
            qw3.e(cw3, this.f475a);
        }

        @Override // defpackage.bu3
        public final void k(int i, String str) throws IOException {
            r((i << 3) | 2);
            Y(str);
        }

        @Override // defpackage.bu3
        public final void l(int i, boolean z) throws IOException {
            r((i << 3) | 0);
            d(z ? (byte) 1 : 0);
        }

        @Override // defpackage.bu3
        public final void m(long j) throws IOException {
            if (!bu3.c || a() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.d;
                    int i = this.f;
                    this.f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    kx3.g(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                kx3.g(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // defpackage.bu3
        public final void r(int i) throws IOException {
            if (!bu3.c || nt3.a() || a() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                kx3.g(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.d;
                int i5 = this.f;
                this.f = i5 + 1;
                kx3.g(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.d;
                    int i7 = this.f;
                    this.f = i7 + 1;
                    kx3.g(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.d;
                int i8 = this.f;
                this.f = i8 + 1;
                kx3.g(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.d;
                    int i10 = this.f;
                    this.f = i10 + 1;
                    kx3.g(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.d;
                int i11 = this.f;
                this.f = i11 + 1;
                kx3.g(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.d;
                    int i13 = this.f;
                    this.f = i13 + 1;
                    kx3.g(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.d;
                int i14 = this.f;
                this.f = i14 + 1;
                kx3.g(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.d;
                int i15 = this.f;
                this.f = i15 + 1;
                kx3.g(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // defpackage.bu3
        public final void s(int i, int i2) throws IOException {
            r((i << 3) | 0);
            if (i2 >= 0) {
                r(i2);
            } else {
                m((long) i2);
            }
        }

        @Override // defpackage.bu3
        public final void t(int i, qt3 qt3) throws IOException {
            f(1, 3);
            y(2, i);
            h(3, qt3);
            f(1, 4);
        }

        @Override // defpackage.bu3
        public final void y(int i, int i2) throws IOException {
            r((i << 3) | 0);
            r(i2);
        }

        @Override // defpackage.bu3
        public final void z(int i, long j) throws IOException {
            r((i << 3) | 1);
            A(j);
        }
    }

    public bu3() {
    }

    public static int B(int i, long j) {
        return F(j) + L(i << 3);
    }

    public static int D(int i) {
        return L(i << 3);
    }

    public static int E(int i, long j) {
        return F(j) + L(i << 3);
    }

    public static int F(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int H(int i) {
        if (i >= 0) {
            return L(i);
        }
        return 10;
    }

    public static int I(int i, int i2) {
        return H(i2) + L(i << 3);
    }

    public static int J(int i, long j) {
        return F(R(j)) + L(i << 3);
    }

    public static int K(long j) {
        return F(R(j));
    }

    public static int L(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int M(int i, int i2) {
        return L(i2) + L(i << 3);
    }

    public static int N(int i) {
        return L(i << 3) + 8;
    }

    public static int O(int i) {
        return L(V(i));
    }

    public static int P(int i, int i2) {
        return L(V(i2)) + L(i << 3);
    }

    public static int Q(int i) {
        return L(i << 3) + 8;
    }

    public static long R(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int S(int i) {
        return L(i << 3) + 4;
    }

    public static int T(int i) {
        return L(i << 3) + 4;
    }

    public static int U(int i, int i2) {
        return H(i2) + L(i << 3);
    }

    public static int V(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int b(hv3 hv3) {
        int a2 = hv3.a();
        return L(a2) + a2;
    }

    public static int c(cw3 cw3, qw3 qw3) {
        it3 it3 = (it3) cw3;
        int i = it3.i();
        if (i == -1) {
            i = qw3.c(it3);
            it3.j(i);
        }
        return L(i) + i;
    }

    public static int n(int i) {
        return L(i << 3) + 4;
    }

    public static int o(int i, String str) {
        return q(str) + L(i << 3);
    }

    public static int p(qt3 qt3) {
        int d = qt3.d();
        return L(d) + d;
    }

    public static int q(String str) {
        int i;
        try {
            i = lx3.a(str);
        } catch (px3 unused) {
            i = str.getBytes(tu3.f3407a).length;
        }
        return L(i) + i;
    }

    public static int u(int i) {
        return L(i << 3) + 8;
    }

    public static int v(int i) {
        return L(i << 3) + 1;
    }

    public static int w(int i, qt3 qt3) {
        int L = L(i << 3);
        int d = qt3.d();
        return L(d) + d + L;
    }

    @Deprecated
    public static int x(int i, cw3 cw3, qw3 qw3) {
        int L = L(i << 3) << 1;
        it3 it3 = (it3) cw3;
        int i2 = it3.i();
        if (i2 == -1) {
            i2 = qw3.c(it3);
            it3.j(i2);
        }
        return L + i2;
    }

    public abstract void A(long j) throws IOException;

    public abstract void C(int i) throws IOException;

    public abstract void G(int i, int i2) throws IOException;

    public abstract int a();

    public abstract void d(byte b2) throws IOException;

    public abstract void e(int i) throws IOException;

    public abstract void f(int i, int i2) throws IOException;

    public abstract void g(int i, long j) throws IOException;

    public abstract void h(int i, qt3 qt3) throws IOException;

    public abstract void i(int i, cw3 cw3) throws IOException;

    public abstract void j(int i, cw3 cw3, qw3 qw3) throws IOException;

    public abstract void k(int i, String str) throws IOException;

    public abstract void l(int i, boolean z) throws IOException;

    public abstract void m(long j) throws IOException;

    public abstract void r(int i) throws IOException;

    public abstract void s(int i, int i2) throws IOException;

    public abstract void t(int i, qt3 qt3) throws IOException;

    public abstract void y(int i, int i2) throws IOException;

    public abstract void z(int i, long j) throws IOException;

    public bu3(au3 au3) {
    }
}
