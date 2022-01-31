package defpackage;

import com.google.firebase.perf.util.Constants;
import defpackage.de;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: xb  reason: default package */
/* compiled from: CodedOutputStream */
public abstract class xb extends sb {
    public static final Logger b = Logger.getLogger(xb.class.getName());
    public static final boolean c = ce.h;

    /* renamed from: a  reason: collision with root package name */
    public yb f3910a;

    /* renamed from: xb$b */
    /* compiled from: CodedOutputStream */
    public static abstract class b extends xb {
        public final byte[] d;
        public final int e;
        public int f;
        public int g;

        public b(int i) {
            super(null);
            if (i >= 0) {
                int max = Math.max(i, 20);
                this.d = new byte[max];
                this.e = max;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void b0(int i) {
            byte[] bArr = this.d;
            int i2 = this.f;
            int i3 = i2 + 1;
            this.f = i3;
            bArr[i2] = (byte) (i & Constants.MAX_HOST_LENGTH);
            int i4 = i3 + 1;
            this.f = i4;
            bArr[i3] = (byte) ((i >> 8) & Constants.MAX_HOST_LENGTH);
            int i5 = i4 + 1;
            this.f = i5;
            bArr[i4] = (byte) ((i >> 16) & Constants.MAX_HOST_LENGTH);
            this.f = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & Constants.MAX_HOST_LENGTH);
            this.g += 4;
        }

        public final void c0(long j) {
            byte[] bArr = this.d;
            int i = this.f;
            int i2 = i + 1;
            this.f = i2;
            bArr[i] = (byte) ((int) (j & 255));
            int i3 = i2 + 1;
            this.f = i3;
            bArr[i2] = (byte) ((int) ((j >> 8) & 255));
            int i4 = i3 + 1;
            this.f = i4;
            bArr[i3] = (byte) ((int) ((j >> 16) & 255));
            int i5 = i4 + 1;
            this.f = i5;
            bArr[i4] = (byte) ((int) (255 & (j >> 24)));
            int i6 = i5 + 1;
            this.f = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & Constants.MAX_HOST_LENGTH);
            int i7 = i6 + 1;
            this.f = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & Constants.MAX_HOST_LENGTH);
            int i8 = i7 + 1;
            this.f = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & Constants.MAX_HOST_LENGTH);
            this.f = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & Constants.MAX_HOST_LENGTH);
            this.g += 8;
        }

        public final void d0(int i) {
            if (xb.c) {
                long j = (long) this.f;
                while ((i & -128) != 0) {
                    byte[] bArr = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    ce.q(bArr, (long) i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                ce.q(bArr2, (long) i3, (byte) i);
                this.g += (int) (((long) this.f) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                bArr3[i4] = (byte) ((i & 127) | 128);
                this.g++;
                i >>>= 7;
            }
            byte[] bArr4 = this.d;
            int i5 = this.f;
            this.f = i5 + 1;
            bArr4[i5] = (byte) i;
            this.g++;
        }

        public final void e0(long j) {
            if (xb.c) {
                long j2 = (long) this.f;
                while ((j & -128) != 0) {
                    byte[] bArr = this.d;
                    int i = this.f;
                    this.f = i + 1;
                    ce.q(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                ce.q(bArr2, (long) i2, (byte) ((int) j));
                this.g += (int) (((long) this.f) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                this.g++;
                j >>>= 7;
            }
            byte[] bArr4 = this.d;
            int i4 = this.f;
            this.f = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.g++;
        }
    }

    /* renamed from: xb$c */
    /* compiled from: CodedOutputStream */
    public static class c extends xb {
        public final byte[] d;
        public final int e;
        public int f;

        public c(byte[] bArr, int i, int i2) {
            super(null);
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) >= 0) {
                this.d = bArr;
                this.f = i;
                this.e = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // defpackage.xb
        public final void F(byte b) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        @Override // defpackage.xb
        public final void G(int i, boolean z) throws IOException {
            Y((i << 3) | 0);
            F(z ? (byte) 1 : 0);
        }

        @Override // defpackage.xb
        public final void H(byte[] bArr, int i, int i2) throws IOException {
            Y(i2);
            c0(bArr, i, i2);
        }

        @Override // defpackage.xb
        public final void I(int i, ub ubVar) throws IOException {
            Y((i << 3) | 2);
            J(ubVar);
        }

        @Override // defpackage.xb
        public final void J(ub ubVar) throws IOException {
            Y(ubVar.size());
            ubVar.v(this);
        }

        @Override // defpackage.xb
        public final void K(int i, int i2) throws IOException {
            Y((i << 3) | 5);
            L(i2);
        }

        @Override // defpackage.xb
        public final void L(int i) throws IOException {
            try {
                byte[] bArr = this.d;
                int i2 = this.f;
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) (i & Constants.MAX_HOST_LENGTH);
                int i4 = i3 + 1;
                this.f = i4;
                bArr[i3] = (byte) ((i >> 8) & Constants.MAX_HOST_LENGTH);
                int i5 = i4 + 1;
                this.f = i5;
                bArr[i4] = (byte) ((i >> 16) & Constants.MAX_HOST_LENGTH);
                this.f = i5 + 1;
                bArr[i5] = (byte) ((i >> 24) & Constants.MAX_HOST_LENGTH);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        @Override // defpackage.xb
        public final void M(int i, long j) throws IOException {
            Y((i << 3) | 1);
            N(j);
        }

        @Override // defpackage.xb
        public final void N(long j) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                bArr[i] = (byte) (((int) j) & Constants.MAX_HOST_LENGTH);
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) (((int) (j >> 8)) & Constants.MAX_HOST_LENGTH);
                int i4 = i3 + 1;
                this.f = i4;
                bArr[i3] = (byte) (((int) (j >> 16)) & Constants.MAX_HOST_LENGTH);
                int i5 = i4 + 1;
                this.f = i5;
                bArr[i4] = (byte) (((int) (j >> 24)) & Constants.MAX_HOST_LENGTH);
                int i6 = i5 + 1;
                this.f = i6;
                bArr[i5] = (byte) (((int) (j >> 32)) & Constants.MAX_HOST_LENGTH);
                int i7 = i6 + 1;
                this.f = i7;
                bArr[i6] = (byte) (((int) (j >> 40)) & Constants.MAX_HOST_LENGTH);
                int i8 = i7 + 1;
                this.f = i8;
                bArr[i7] = (byte) (((int) (j >> 48)) & Constants.MAX_HOST_LENGTH);
                this.f = i8 + 1;
                bArr[i8] = (byte) (((int) (j >> 56)) & Constants.MAX_HOST_LENGTH);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        @Override // defpackage.xb
        public final void O(int i, int i2) throws IOException {
            Y((i << 3) | 0);
            if (i2 >= 0) {
                Y(i2);
            } else {
                a0((long) i2);
            }
        }

        @Override // defpackage.xb
        public final void P(int i) throws IOException {
            if (i >= 0) {
                Y(i);
            } else {
                a0((long) i);
            }
        }

        @Override // defpackage.xb
        public final void Q(int i, dd ddVar, rd rdVar) throws IOException {
            Y((i << 3) | 2);
            Y(((nb) ddVar).c(rdVar));
            rdVar.i(ddVar, this.f3910a);
        }

        @Override // defpackage.xb
        public final void R(dd ddVar) throws IOException {
            Y(ddVar.getSerializedSize());
            ddVar.a(this);
        }

        @Override // defpackage.xb
        public final void S(int i, dd ddVar) throws IOException {
            W(1, 3);
            X(2, i);
            Y(26);
            Y(ddVar.getSerializedSize());
            ddVar.a(this);
            W(1, 4);
        }

        @Override // defpackage.xb
        public final void T(int i, ub ubVar) throws IOException {
            W(1, 3);
            X(2, i);
            I(3, ubVar);
            W(1, 4);
        }

        @Override // defpackage.xb
        public final void U(int i, String str) throws IOException {
            Y((i << 3) | 2);
            V(str);
        }

        @Override // defpackage.xb
        public final void V(String str) throws IOException {
            int i = this.f;
            try {
                int z = xb.z(str.length() * 3);
                int z2 = xb.z(str.length());
                if (z2 == z) {
                    int i2 = i + z2;
                    this.f = i2;
                    int c = de.c(str, this.d, i2, b0());
                    this.f = i;
                    Y((c - i) - z2);
                    this.f = c;
                    return;
                }
                Y(de.d(str));
                this.f = de.c(str, this.d, this.f, b0());
            } catch (de.c e2) {
                this.f = i;
                E(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new d(e3);
            }
        }

        @Override // defpackage.xb
        public final void W(int i, int i2) throws IOException {
            Y((i << 3) | i2);
        }

        @Override // defpackage.xb
        public final void X(int i, int i2) throws IOException {
            Y((i << 3) | 0);
            Y(i2);
        }

        @Override // defpackage.xb
        public final void Y(int i) throws IOException {
            if (!xb.c || qb.a() || b0() < 5) {
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
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                ce.q(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.d;
                int i5 = this.f;
                this.f = i5 + 1;
                ce.q(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.d;
                    int i7 = this.f;
                    this.f = i7 + 1;
                    ce.q(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.d;
                int i8 = this.f;
                this.f = i8 + 1;
                ce.q(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.d;
                    int i10 = this.f;
                    this.f = i10 + 1;
                    ce.q(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.d;
                int i11 = this.f;
                this.f = i11 + 1;
                ce.q(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.d;
                    int i13 = this.f;
                    this.f = i13 + 1;
                    ce.q(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.d;
                int i14 = this.f;
                this.f = i14 + 1;
                ce.q(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.d;
                int i15 = this.f;
                this.f = i15 + 1;
                ce.q(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // defpackage.xb
        public final void Z(int i, long j) throws IOException {
            Y((i << 3) | 0);
            a0(j);
        }

        @Override // defpackage.sb
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            c0(bArr, i, i2);
        }

        @Override // defpackage.xb
        public final void a0(long j) throws IOException {
            if (!xb.c || b0() < 10) {
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
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    ce.q(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                ce.q(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final int b0() {
            return this.e - this.f;
        }

        public final void c0(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e2);
            }
        }
    }

    /* renamed from: xb$d */
    /* compiled from: CodedOutputStream */
    public static class d extends IOException {
        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public d(String str, Throwable th) {
            super(hj1.S("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }
    }

    /* renamed from: xb$e */
    /* compiled from: CodedOutputStream */
    public static final class e extends b {
        public final OutputStream h;

        public e(OutputStream outputStream, int i) {
            super(i);
            Objects.requireNonNull(outputStream, "out");
            this.h = outputStream;
        }

        @Override // defpackage.xb
        public void F(byte b) throws IOException {
            if (this.f == this.e) {
                f0();
            }
            byte[] bArr = this.d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b;
            this.g++;
        }

        @Override // defpackage.xb
        public void G(int i, boolean z) throws IOException {
            g0(11);
            d0((i << 3) | 0);
            byte b = z ? (byte) 1 : 0;
            byte[] bArr = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr[i2] = b;
            this.g++;
        }

        @Override // defpackage.xb
        public void H(byte[] bArr, int i, int i2) throws IOException {
            g0(5);
            d0(i2);
            h0(bArr, i, i2);
        }

        @Override // defpackage.xb
        public void I(int i, ub ubVar) throws IOException {
            Y((i << 3) | 2);
            J(ubVar);
        }

        @Override // defpackage.xb
        public void J(ub ubVar) throws IOException {
            Y(ubVar.size());
            ubVar.v(this);
        }

        @Override // defpackage.xb
        public void K(int i, int i2) throws IOException {
            g0(14);
            d0((i << 3) | 5);
            b0(i2);
        }

        @Override // defpackage.xb
        public void L(int i) throws IOException {
            g0(4);
            b0(i);
        }

        @Override // defpackage.xb
        public void M(int i, long j) throws IOException {
            g0(18);
            d0((i << 3) | 1);
            c0(j);
        }

        @Override // defpackage.xb
        public void N(long j) throws IOException {
            g0(8);
            c0(j);
        }

        @Override // defpackage.xb
        public void O(int i, int i2) throws IOException {
            g0(20);
            d0((i << 3) | 0);
            if (i2 >= 0) {
                d0(i2);
            } else {
                e0((long) i2);
            }
        }

        @Override // defpackage.xb
        public void P(int i) throws IOException {
            if (i >= 0) {
                g0(5);
                d0(i);
                return;
            }
            a0((long) i);
        }

        @Override // defpackage.xb
        public void Q(int i, dd ddVar, rd rdVar) throws IOException {
            Y((i << 3) | 2);
            Y(((nb) ddVar).c(rdVar));
            rdVar.i(ddVar, this.f3910a);
        }

        @Override // defpackage.xb
        public void R(dd ddVar) throws IOException {
            Y(ddVar.getSerializedSize());
            ddVar.a(this);
        }

        @Override // defpackage.xb
        public void S(int i, dd ddVar) throws IOException {
            W(1, 3);
            X(2, i);
            Y(26);
            Y(ddVar.getSerializedSize());
            ddVar.a(this);
            W(1, 4);
        }

        @Override // defpackage.xb
        public void T(int i, ub ubVar) throws IOException {
            W(1, 3);
            X(2, i);
            I(3, ubVar);
            W(1, 4);
        }

        @Override // defpackage.xb
        public void U(int i, String str) throws IOException {
            Y((i << 3) | 2);
            V(str);
        }

        @Override // defpackage.xb
        public void V(String str) throws IOException {
            int i;
            try {
                int length = str.length() * 3;
                int z = xb.z(length);
                int i2 = z + length;
                int i3 = this.e;
                if (i2 > i3) {
                    byte[] bArr = new byte[length];
                    int c = de.c(str, bArr, 0, length);
                    Y(c);
                    h0(bArr, 0, c);
                    return;
                }
                if (i2 > i3 - this.f) {
                    f0();
                }
                int z2 = xb.z(str.length());
                int i4 = this.f;
                if (z2 == z) {
                    int i5 = i4 + z2;
                    try {
                        this.f = i5;
                        int c2 = de.c(str, this.d, i5, this.e - i5);
                        this.f = i4;
                        i = (c2 - i4) - z2;
                        d0(i);
                        this.f = c2;
                    } catch (de.c e) {
                        this.g -= this.f - i4;
                        this.f = i4;
                        throw e;
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        throw new d(e2);
                    }
                } else {
                    i = de.d(str);
                    d0(i);
                    this.f = de.c(str, this.d, this.f, i);
                }
                this.g += i;
            } catch (de.c e3) {
                E(str, e3);
            }
        }

        @Override // defpackage.xb
        public void W(int i, int i2) throws IOException {
            Y((i << 3) | i2);
        }

        @Override // defpackage.xb
        public void X(int i, int i2) throws IOException {
            g0(20);
            d0((i << 3) | 0);
            d0(i2);
        }

        @Override // defpackage.xb
        public void Y(int i) throws IOException {
            g0(5);
            d0(i);
        }

        @Override // defpackage.xb
        public void Z(int i, long j) throws IOException {
            g0(20);
            d0((i << 3) | 0);
            e0(j);
        }

        @Override // defpackage.sb
        public void a(byte[] bArr, int i, int i2) throws IOException {
            h0(bArr, i, i2);
        }

        @Override // defpackage.xb
        public void a0(long j) throws IOException {
            g0(10);
            e0(j);
        }

        public final void f0() throws IOException {
            this.h.write(this.d, 0, this.f);
            this.f = 0;
        }

        public final void g0(int i) throws IOException {
            if (this.e - this.f < i) {
                f0();
            }
        }

        public void h0(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.e;
            int i4 = this.f;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.d, i4, i2);
                this.f += i2;
                this.g += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.d, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f = this.e;
            this.g += i5;
            f0();
            if (i7 <= this.e) {
                System.arraycopy(bArr, i6, this.d, 0, i7);
                this.f = i7;
            } else {
                this.h.write(bArr, i6, i7);
            }
            this.g += i7;
        }
    }

    public xb() {
    }

    public static int A(int i, long j) {
        return B(j) + x(i);
    }

    public static int B(long j) {
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
        return (i >> 31) ^ (i << 1);
    }

    public static long D(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int b(int i, boolean z) {
        return x(i) + 1;
    }

    public static int c(int i, ub ubVar) {
        return x(i) + o(ubVar.size());
    }

    public static int d(ub ubVar) {
        return o(ubVar.size());
    }

    public static int e(int i, double d2) {
        return x(i) + 8;
    }

    public static int f(int i, int i2) {
        return x(i) + l(i2);
    }

    public static int g(int i, int i2) {
        return x(i) + 4;
    }

    public static int h(int i, long j) {
        return x(i) + 8;
    }

    public static int i(int i, float f) {
        return x(i) + 4;
    }

    @Deprecated
    public static int j(int i, dd ddVar, rd rdVar) {
        return (x(i) * 2) + ((nb) ddVar).c(rdVar);
    }

    public static int k(int i, int i2) {
        return l(i2) + x(i);
    }

    public static int l(int i) {
        if (i >= 0) {
            return z(i);
        }
        return 10;
    }

    public static int m(int i, long j) {
        return x(i) + B(j);
    }

    public static int n(qc qcVar) {
        int i;
        if (qcVar.b != null) {
            i = qcVar.b.size();
        } else {
            i = qcVar.f2927a != null ? qcVar.f2927a.getSerializedSize() : 0;
        }
        return o(i);
    }

    public static int o(int i) {
        return z(i) + i;
    }

    public static int p(int i, int i2) {
        return x(i) + 4;
    }

    public static int q(int i, long j) {
        return x(i) + 8;
    }

    public static int r(int i, int i2) {
        return s(i2) + x(i);
    }

    public static int s(int i) {
        return z(C(i));
    }

    public static int t(int i, long j) {
        return u(j) + x(i);
    }

    public static int u(long j) {
        return B(D(j));
    }

    public static int v(int i, String str) {
        return w(str) + x(i);
    }

    public static int w(String str) {
        int i;
        try {
            i = de.d(str);
        } catch (de.c unused) {
            i = str.getBytes(mc.f2352a).length;
        }
        return o(i);
    }

    public static int x(int i) {
        return z((i << 3) | 0);
    }

    public static int y(int i, int i2) {
        return z(i2) + x(i);
    }

    public static int z(int i) {
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

    public final void E(String str, de.c cVar) throws IOException {
        b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) cVar);
        byte[] bytes = str.getBytes(mc.f2352a);
        try {
            Y(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new d(e2);
        } catch (d e3) {
            throw e3;
        }
    }

    public abstract void F(byte b2) throws IOException;

    public abstract void G(int i, boolean z) throws IOException;

    public abstract void H(byte[] bArr, int i, int i2) throws IOException;

    public abstract void I(int i, ub ubVar) throws IOException;

    public abstract void J(ub ubVar) throws IOException;

    public abstract void K(int i, int i2) throws IOException;

    public abstract void L(int i) throws IOException;

    public abstract void M(int i, long j) throws IOException;

    public abstract void N(long j) throws IOException;

    public abstract void O(int i, int i2) throws IOException;

    public abstract void P(int i) throws IOException;

    public abstract void Q(int i, dd ddVar, rd rdVar) throws IOException;

    public abstract void R(dd ddVar) throws IOException;

    public abstract void S(int i, dd ddVar) throws IOException;

    public abstract void T(int i, ub ubVar) throws IOException;

    public abstract void U(int i, String str) throws IOException;

    public abstract void V(String str) throws IOException;

    public abstract void W(int i, int i2) throws IOException;

    public abstract void X(int i, int i2) throws IOException;

    public abstract void Y(int i) throws IOException;

    public abstract void Z(int i, long j) throws IOException;

    public abstract void a0(long j) throws IOException;

    public xb(a aVar) {
    }
}
