package defpackage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: hh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class hh3 extends yg3 {
    public static final Logger b = Logger.getLogger(hh3.class.getName());
    public static final boolean c = mk3.h;

    /* renamed from: a  reason: collision with root package name */
    public jh3 f1372a;

    /* renamed from: hh3$a */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
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
            throw new UnsupportedOperationException("Method not decompiled: defpackage.hh3.a.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    /* renamed from: hh3$b */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static class b extends hh3 {
        public final byte[] d;
        public final int e;
        public int f;

        public b(byte[] bArr, int i) {
            super(null);
            int i2 = i + 0;
            if ((i | 0 | (bArr.length - i2)) >= 0) {
                this.d = bArr;
                this.f = 0;
                this.e = i2;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }

        @Override // defpackage.hh3
        public final void B(int i, int i2) throws IOException {
            N((i << 3) | 5);
            P(i2);
        }

        @Override // defpackage.hh3
        public final void M(int i) throws IOException {
            if (i >= 0) {
                N(i);
            } else {
                n((long) i);
            }
        }

        @Override // defpackage.hh3
        public final void N(int i) throws IOException {
            if (!hh3.c || wg3.a() || h() < 5) {
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
                mk3.e(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.d;
                int i5 = this.f;
                this.f = i5 + 1;
                mk3.e(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.d;
                    int i7 = this.f;
                    this.f = i7 + 1;
                    mk3.e(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.d;
                int i8 = this.f;
                this.f = i8 + 1;
                mk3.e(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.d;
                    int i10 = this.f;
                    this.f = i10 + 1;
                    mk3.e(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.d;
                int i11 = this.f;
                this.f = i11 + 1;
                mk3.e(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.d;
                    int i13 = this.f;
                    this.f = i13 + 1;
                    mk3.e(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.d;
                int i14 = this.f;
                this.f = i14 + 1;
                mk3.e(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.d;
                int i15 = this.f;
                this.f = i15 + 1;
                mk3.e(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // defpackage.hh3
        public final void P(int i) throws IOException {
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

        public final void V(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e2);
            }
        }

        public final void W(xg3 xg3) throws IOException {
            N(xg3.size());
            xg3.k(this);
        }

        public final void X(String str) throws IOException {
            int i = this.f;
            try {
                int S = hh3.S(str.length() * 3);
                int S2 = hh3.S(str.length());
                if (S2 == S) {
                    int i2 = i + S2;
                    this.f = i2;
                    int b = pk3.f2815a.b(str, this.d, i2, h());
                    this.f = i;
                    N((b - i) - S2);
                    this.f = b;
                    return;
                }
                N(pk3.a(str));
                this.f = pk3.f2815a.b(str, this.d, this.f, h());
            } catch (tk3 e2) {
                this.f = i;
                hh3.b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
                byte[] bytes = str.getBytes(zh3.f4175a);
                try {
                    N(bytes.length);
                    V(bytes, 0, bytes.length);
                } catch (IndexOutOfBoundsException e3) {
                    throw new a(e3);
                } catch (a e4) {
                    throw e4;
                }
            } catch (IndexOutOfBoundsException e5) {
                throw new a(e5);
            }
        }

        @Override // defpackage.hh3
        public final void b(int i, long j) throws IOException {
            N((i << 3) | 0);
            n(j);
        }

        @Override // defpackage.hh3
        public final void c(int i, xg3 xg3) throws IOException {
            N((i << 3) | 2);
            W(xg3);
        }

        @Override // defpackage.hh3
        public final void d(int i, gj3 gj3) throws IOException {
            l(1, 3);
            w(2, i);
            l(3, 2);
            N(gj3.r());
            gj3.t(this);
            l(1, 4);
        }

        @Override // defpackage.hh3
        public final void e(int i, gj3 gj3, sj3 sj3) throws IOException {
            N((i << 3) | 2);
            qg3 qg3 = (qg3) gj3;
            int c = qg3.c();
            if (c == -1) {
                c = sj3.h(qg3);
                qg3.d(c);
            }
            N(c);
            sj3.i(gj3, this.f1372a);
        }

        @Override // defpackage.hh3
        public final void f(int i, String str) throws IOException {
            N((i << 3) | 2);
            X(str);
        }

        @Override // defpackage.hh3
        public final void g(int i, boolean z) throws IOException {
            N((i << 3) | 0);
            s(z ? (byte) 1 : 0);
        }

        @Override // defpackage.hh3
        public final int h() {
            return this.e - this.f;
        }

        @Override // defpackage.hh3
        public final void l(int i, int i2) throws IOException {
            N((i << 3) | i2);
        }

        @Override // defpackage.hh3
        public final void m(int i, xg3 xg3) throws IOException {
            l(1, 3);
            w(2, i);
            c(3, xg3);
            l(1, 4);
        }

        @Override // defpackage.hh3
        public final void n(long j) throws IOException {
            if (!hh3.c || h() < 10) {
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
                    mk3.e(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                mk3.e(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // defpackage.hh3
        public final void s(byte b) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        @Override // defpackage.hh3
        public final void t(int i, int i2) throws IOException {
            N((i << 3) | 0);
            if (i2 >= 0) {
                N(i2);
            } else {
                n((long) i2);
            }
        }

        @Override // defpackage.hh3
        public final void u(int i, long j) throws IOException {
            N((i << 3) | 1);
            x(j);
        }

        @Override // defpackage.hh3
        public final void w(int i, int i2) throws IOException {
            N((i << 3) | 0);
            N(i2);
        }

        @Override // defpackage.hh3
        public final void x(long j) throws IOException {
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
    }

    public hh3() {
    }

    public static int A(long j) {
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

    public static int C(int i) {
        return Q(i) + 8;
    }

    public static int D(int i, int i2) {
        return R(i2) + Q(i);
    }

    public static int E(long j) {
        return A(J(j));
    }

    public static int F(int i) {
        return Q(i) + 8;
    }

    public static int G(int i, int i2) {
        return S(i2) + Q(i);
    }

    public static int H(int i, int i2) {
        return S(U(i2)) + Q(i);
    }

    public static int I(int i) {
        return Q(i) + 4;
    }

    public static long J(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int K(int i) {
        return Q(i) + 4;
    }

    public static int L(int i, int i2) {
        return R(i2) + Q(i);
    }

    public static int O(String str) {
        int i;
        try {
            i = pk3.a(str);
        } catch (tk3 unused) {
            i = str.getBytes(zh3.f4175a).length;
        }
        return S(i) + i;
    }

    public static int Q(int i) {
        return S(i << 3);
    }

    public static int R(int i) {
        if (i >= 0) {
            return S(i);
        }
        return 10;
    }

    public static int S(int i) {
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

    public static int T(int i) {
        return S(U(i));
    }

    public static int U(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int a(gj3 gj3, sj3 sj3) {
        qg3 qg3 = (qg3) gj3;
        int c2 = qg3.c();
        if (c2 == -1) {
            c2 = sj3.h(qg3);
            qg3.d(c2);
        }
        return S(c2) + c2;
    }

    public static int i(int i) {
        return Q(i) + 4;
    }

    public static int j(int i, String str) {
        return O(str) + Q(i);
    }

    public static int k(xg3 xg3) {
        int size = xg3.size();
        return S(size) + size;
    }

    public static int o(int i) {
        return Q(i) + 8;
    }

    public static int p(int i) {
        return Q(i) + 1;
    }

    public static int q(int i, xg3 xg3) {
        int Q = Q(i);
        int size = xg3.size();
        return S(size) + size + Q;
    }

    @Deprecated
    public static int r(int i, gj3 gj3, sj3 sj3) {
        int Q = Q(i) << 1;
        qg3 qg3 = (qg3) gj3;
        int c2 = qg3.c();
        if (c2 == -1) {
            c2 = sj3.h(qg3);
            qg3.d(c2);
        }
        return Q + c2;
    }

    public static int v(int i, long j) {
        return A(j) + Q(i);
    }

    public static int y(int i, long j) {
        return A(j) + Q(i);
    }

    public static int z(int i, long j) {
        return A(J(j)) + Q(i);
    }

    public abstract void B(int i, int i2) throws IOException;

    public abstract void M(int i) throws IOException;

    public abstract void N(int i) throws IOException;

    public abstract void P(int i) throws IOException;

    public abstract void b(int i, long j) throws IOException;

    public abstract void c(int i, xg3 xg3) throws IOException;

    public abstract void d(int i, gj3 gj3) throws IOException;

    public abstract void e(int i, gj3 gj3, sj3 sj3) throws IOException;

    public abstract void f(int i, String str) throws IOException;

    public abstract void g(int i, boolean z) throws IOException;

    public abstract int h();

    public abstract void l(int i, int i2) throws IOException;

    public abstract void m(int i, xg3 xg3) throws IOException;

    public abstract void n(long j) throws IOException;

    public abstract void s(byte b2) throws IOException;

    public abstract void t(int i, int i2) throws IOException;

    public abstract void u(int i, long j) throws IOException;

    public abstract void w(int i, int i2) throws IOException;

    public abstract void x(long j) throws IOException;

    public hh3(gh3 gh3) {
    }
}
