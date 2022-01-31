package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: bg2  reason: default package */
public abstract class bg2 extends tf2 {
    public static final Logger b = Logger.getLogger(bg2.class.getName());
    public static final boolean c = jj2.h;

    /* renamed from: a  reason: collision with root package name */
    public dg2 f427a;

    /* renamed from: bg2$a */
    public static class a extends bg2 {
        public final byte[] d;
        public final int e;
        public final int f;
        public int g;

        public a(byte[] bArr, int i, int i2) {
            super(null);
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) >= 0) {
                this.d = bArr;
                this.e = i;
                this.g = i;
                this.f = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // defpackage.bg2
        public final void A(int i, int i2) throws IOException {
            V((i << 3) | 0);
            if (i2 >= 0) {
                V(i2);
            } else {
                t((long) i2);
            }
        }

        @Override // defpackage.bg2
        public final void B(int i, long j) throws IOException {
            V((i << 3) | 1);
            E(j);
        }

        @Override // defpackage.bg2
        public final void D(int i, int i2) throws IOException {
            V((i << 3) | 0);
            V(i2);
        }

        @Override // defpackage.bg2
        public final void E(long j) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.g;
                int i2 = i + 1;
                this.g = i2;
                bArr[i] = (byte) ((int) j);
                int i3 = i2 + 1;
                this.g = i3;
                bArr[i2] = (byte) ((int) (j >> 8));
                int i4 = i3 + 1;
                this.g = i4;
                bArr[i3] = (byte) ((int) (j >> 16));
                int i5 = i4 + 1;
                this.g = i5;
                bArr[i4] = (byte) ((int) (j >> 24));
                int i6 = i5 + 1;
                this.g = i6;
                bArr[i5] = (byte) ((int) (j >> 32));
                int i7 = i6 + 1;
                this.g = i7;
                bArr[i6] = (byte) ((int) (j >> 40));
                int i8 = i7 + 1;
                this.g = i8;
                bArr[i7] = (byte) ((int) (j >> 48));
                this.g = i8 + 1;
                bArr[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e2);
            }
        }

        @Override // defpackage.bg2
        public final void I(int i, int i2) throws IOException {
            V((i << 3) | 5);
            W(i2);
        }

        @Override // defpackage.bg2
        public final void U(int i) throws IOException {
            if (i >= 0) {
                V(i);
            } else {
                t((long) i);
            }
        }

        @Override // defpackage.bg2
        public final void V(int i) throws IOException {
            if (!bg2.c || k() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.d;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i3 = this.g;
                    this.g = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e2);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.d;
                    int i4 = this.g;
                    this.g = i4 + 1;
                    jj2.g(bArr3, (long) i4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.d;
                int i5 = this.g;
                this.g = i5 + 1;
                jj2.g(bArr4, (long) i5, (byte) i);
            }
        }

        @Override // defpackage.bg2
        public final void W(int i) throws IOException {
            try {
                byte[] bArr = this.d;
                int i2 = this.g;
                int i3 = i2 + 1;
                this.g = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.g = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.g = i5;
                bArr[i4] = (byte) (i >> 16);
                this.g = i5 + 1;
                bArr[i5] = i >> 24;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e2);
            }
        }

        @Override // defpackage.tf2
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            c(bArr, i, i2);
        }

        @Override // defpackage.bg2
        public void b() {
        }

        @Override // defpackage.bg2
        public final void c(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.d, this.g, i2);
                this.g += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), Integer.valueOf(i2)), e2);
            }
        }

        public final void c0(uf2 uf2) throws IOException {
            V(uf2.size());
            uf2.e(this);
        }

        @Override // defpackage.bg2
        public final void d(byte b) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.g;
                this.g = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e2);
            }
        }

        public final void d0(zh2 zh2) throws IOException {
            V(zh2.e());
            zh2.c(this);
        }

        @Override // defpackage.bg2
        public final void e(int i, long j) throws IOException {
            V((i << 3) | 0);
            t(j);
        }

        public final void e0(String str) throws IOException {
            int i = this.g;
            try {
                int Z = bg2.Z(str.length() * 3);
                int Z2 = bg2.Z(str.length());
                if (Z2 == Z) {
                    int i2 = i + Z2;
                    this.g = i2;
                    int b = lj2.b(str, this.d, i2, k());
                    this.g = i;
                    V((b - i) - Z2);
                    this.g = b;
                    return;
                }
                V(lj2.a(str));
                this.g = lj2.b(str, this.d, this.g, k());
            } catch (oj2 e2) {
                this.g = i;
                j(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new c(e3);
            }
        }

        @Override // defpackage.bg2
        public final void f(int i, uf2 uf2) throws IOException {
            V((i << 3) | 2);
            c0(uf2);
        }

        @Override // defpackage.bg2
        public final void g(int i, zh2 zh2) throws IOException {
            V((i << 3) | 2);
            d0(zh2);
        }

        @Override // defpackage.bg2
        public final void h(int i, zh2 zh2, pi2 pi2) throws IOException {
            V((i << 3) | 2);
            lf2 lf2 = (lf2) zh2;
            int h = lf2.h();
            if (h == -1) {
                h = pi2.g(lf2);
                lf2.g(h);
            }
            V(h);
            pi2.h(zh2, this.f427a);
        }

        @Override // defpackage.bg2
        public final void i(int i, String str) throws IOException {
            V((i << 3) | 2);
            e0(str);
        }

        @Override // defpackage.bg2
        public final int k() {
            return this.f - this.g;
        }

        @Override // defpackage.bg2
        public final void p(int i, int i2) throws IOException {
            V((i << 3) | i2);
        }

        @Override // defpackage.bg2
        public final void q(int i, uf2 uf2) throws IOException {
            p(1, 3);
            D(2, i);
            f(3, uf2);
            p(1, 4);
        }

        @Override // defpackage.bg2
        public final void r(int i, zh2 zh2) throws IOException {
            p(1, 3);
            D(2, i);
            g(3, zh2);
            p(1, 4);
        }

        @Override // defpackage.bg2
        public final void s(int i, boolean z) throws IOException {
            V((i << 3) | 0);
            d(z ? (byte) 1 : 0);
        }

        @Override // defpackage.bg2
        public final void t(long j) throws IOException {
            if (!bg2.c || k() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.d;
                    int i = this.g;
                    this.g = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.d;
                    int i3 = this.g;
                    this.g = i3 + 1;
                    jj2.g(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.d;
                int i4 = this.g;
                this.g = i4 + 1;
                jj2.g(bArr4, (long) i4, (byte) ((int) j));
            }
        }
    }

    /* renamed from: bg2$b */
    public static final class b extends a {
        public final ByteBuffer h;
        public int i;

        public b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            this.h = byteBuffer;
            this.i = byteBuffer.position();
        }

        @Override // defpackage.bg2, defpackage.bg2.a
        public final void b() {
            this.h.position(this.i + (this.g - this.e));
        }
    }

    /* renamed from: bg2$c */
    public static class c extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0011
                java.lang.String r3 = r0.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x0016:
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.bg2.c.<init>(java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: defpackage.bg2.c.<init>(java.lang.String, java.lang.Throwable):void");
        }

        public c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* renamed from: bg2$d */
    public static final class d extends bg2 {
        public final ByteBuffer d;
        public final ByteBuffer e;

        public d(ByteBuffer byteBuffer) {
            super(null);
            this.d = byteBuffer;
            this.e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.position();
        }

        @Override // defpackage.bg2
        public final void A(int i, int i2) throws IOException {
            V((i << 3) | 0);
            if (i2 >= 0) {
                V(i2);
            } else {
                t((long) i2);
            }
        }

        @Override // defpackage.bg2
        public final void B(int i, long j) throws IOException {
            V((i << 3) | 1);
            E(j);
        }

        @Override // defpackage.bg2
        public final void D(int i, int i2) throws IOException {
            V((i << 3) | 0);
            V(i2);
        }

        @Override // defpackage.bg2
        public final void E(long j) throws IOException {
            try {
                this.e.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        @Override // defpackage.bg2
        public final void I(int i, int i2) throws IOException {
            V((i << 3) | 5);
            W(i2);
        }

        @Override // defpackage.bg2
        public final void U(int i) throws IOException {
            if (i >= 0) {
                V(i);
            } else {
                t((long) i);
            }
        }

        @Override // defpackage.bg2
        public final void V(int i) throws IOException {
            while ((i & -128) != 0) {
                this.e.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.e.put((byte) i);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        @Override // defpackage.bg2
        public final void W(int i) throws IOException {
            try {
                this.e.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        @Override // defpackage.tf2
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            c(bArr, i, i2);
        }

        @Override // defpackage.bg2
        public final void b() {
            this.d.position(this.e.position());
        }

        @Override // defpackage.bg2
        public final void c(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.e.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(e2);
            } catch (BufferOverflowException e3) {
                throw new c(e3);
            }
        }

        public final void c0(uf2 uf2) throws IOException {
            V(uf2.size());
            uf2.e(this);
        }

        @Override // defpackage.bg2
        public final void d(byte b) throws IOException {
            try {
                this.e.put(b);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        public final void d0(zh2 zh2, pi2 pi2) throws IOException {
            lf2 lf2 = (lf2) zh2;
            int h = lf2.h();
            if (h == -1) {
                h = pi2.g(lf2);
                lf2.g(h);
            }
            V(h);
            pi2.h(zh2, this.f427a);
        }

        @Override // defpackage.bg2
        public final void e(int i, long j) throws IOException {
            V((i << 3) | 0);
            t(j);
        }

        public final void e0(zh2 zh2) throws IOException {
            V(zh2.e());
            zh2.c(this);
        }

        @Override // defpackage.bg2
        public final void f(int i, uf2 uf2) throws IOException {
            V((i << 3) | 2);
            c0(uf2);
        }

        public final void f0(String str) throws IOException {
            int position = this.e.position();
            try {
                int Z = bg2.Z(str.length() * 3);
                int Z2 = bg2.Z(str.length());
                if (Z2 == Z) {
                    int position2 = this.e.position() + Z2;
                    this.e.position(position2);
                    try {
                        lj2.c(str, this.e);
                        int position3 = this.e.position();
                        this.e.position(position);
                        V(position3 - position2);
                        this.e.position(position3);
                    } catch (IndexOutOfBoundsException e2) {
                        throw new c(e2);
                    }
                } else {
                    V(lj2.a(str));
                    try {
                        lj2.c(str, this.e);
                    } catch (IndexOutOfBoundsException e3) {
                        throw new c(e3);
                    }
                }
            } catch (oj2 e4) {
                this.e.position(position);
                j(str, e4);
            } catch (IllegalArgumentException e5) {
                throw new c(e5);
            }
        }

        @Override // defpackage.bg2
        public final void g(int i, zh2 zh2) throws IOException {
            V((i << 3) | 2);
            e0(zh2);
        }

        @Override // defpackage.bg2
        public final void h(int i, zh2 zh2, pi2 pi2) throws IOException {
            V((i << 3) | 2);
            d0(zh2, pi2);
        }

        @Override // defpackage.bg2
        public final void i(int i, String str) throws IOException {
            V((i << 3) | 2);
            f0(str);
        }

        @Override // defpackage.bg2
        public final int k() {
            return this.e.remaining();
        }

        @Override // defpackage.bg2
        public final void p(int i, int i2) throws IOException {
            V((i << 3) | i2);
        }

        @Override // defpackage.bg2
        public final void q(int i, uf2 uf2) throws IOException {
            p(1, 3);
            D(2, i);
            f(3, uf2);
            p(1, 4);
        }

        @Override // defpackage.bg2
        public final void r(int i, zh2 zh2) throws IOException {
            p(1, 3);
            D(2, i);
            g(3, zh2);
            p(1, 4);
        }

        @Override // defpackage.bg2
        public final void s(int i, boolean z) throws IOException {
            V((i << 3) | 0);
            d(z ? (byte) 1 : 0);
        }

        @Override // defpackage.bg2
        public final void t(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.e.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.e.put((byte) ((int) j));
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }
    }

    /* renamed from: bg2$e */
    public static final class e extends bg2 {
        public final ByteBuffer d;
        public final ByteBuffer e;
        public final long f;
        public final long g;
        public final long h;
        public final long i;
        public long j;

        public e(ByteBuffer byteBuffer) {
            super(null);
            this.d = byteBuffer;
            this.e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long k = jj2.f.k(byteBuffer, jj2.j);
            this.f = k;
            long position = ((long) byteBuffer.position()) + k;
            this.g = position;
            long limit = k + ((long) byteBuffer.limit());
            this.h = limit;
            this.i = limit - 10;
            this.j = position;
        }

        @Override // defpackage.bg2
        public final void A(int i2, int i3) throws IOException {
            V((i2 << 3) | 0);
            if (i3 >= 0) {
                V(i3);
            } else {
                t((long) i3);
            }
        }

        @Override // defpackage.bg2
        public final void B(int i2, long j2) throws IOException {
            V((i2 << 3) | 1);
            E(j2);
        }

        @Override // defpackage.bg2
        public final void D(int i2, int i3) throws IOException {
            V((i2 << 3) | 0);
            V(i3);
        }

        @Override // defpackage.bg2
        public final void E(long j2) throws IOException {
            this.e.putLong((int) (this.j - this.f), j2);
            this.j += 8;
        }

        @Override // defpackage.bg2
        public final void I(int i2, int i3) throws IOException {
            V((i2 << 3) | 5);
            W(i3);
        }

        @Override // defpackage.bg2
        public final void U(int i2) throws IOException {
            if (i2 >= 0) {
                V(i2);
            } else {
                t((long) i2);
            }
        }

        @Override // defpackage.bg2
        public final void V(int i2) throws IOException {
            if (this.j <= this.i) {
                while ((i2 & -128) != 0) {
                    long j2 = this.j;
                    this.j = j2 + 1;
                    jj2.f.b(j2, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                long j3 = this.j;
                this.j = 1 + j3;
                jj2.f.b(j3, (byte) i2);
                return;
            }
            while (true) {
                long j4 = this.j;
                if (j4 >= this.h) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
                } else if ((i2 & -128) == 0) {
                    this.j = 1 + j4;
                    jj2.f.b(j4, (byte) i2);
                    return;
                } else {
                    this.j = j4 + 1;
                    jj2.f.b(j4, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            }
        }

        @Override // defpackage.bg2
        public final void W(int i2) throws IOException {
            this.e.putInt((int) (this.j - this.f), i2);
            this.j += 4;
        }

        @Override // defpackage.tf2
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // defpackage.bg2
        public final void b() {
            this.d.position((int) (this.j - this.f));
        }

        @Override // defpackage.bg2
        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = (long) i3;
                long j3 = this.j;
                if (this.h - j2 >= j3) {
                    jj2.f.h(bArr, (long) i2, j3, j2);
                    this.j += j2;
                    return;
                }
            }
            Objects.requireNonNull(bArr, FirebaseAnalytics.Param.VALUE);
            throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), Integer.valueOf(i3)));
        }

        public final void c0(uf2 uf2) throws IOException {
            V(uf2.size());
            uf2.e(this);
        }

        @Override // defpackage.bg2
        public final void d(byte b) throws IOException {
            long j2 = this.j;
            if (j2 < this.h) {
                this.j = 1 + j2;
                jj2.f.b(j2, b);
                return;
            }
            throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
        }

        public final void d0(zh2 zh2, pi2 pi2) throws IOException {
            lf2 lf2 = (lf2) zh2;
            int h2 = lf2.h();
            if (h2 == -1) {
                h2 = pi2.g(lf2);
                lf2.g(h2);
            }
            V(h2);
            pi2.h(zh2, this.f427a);
        }

        @Override // defpackage.bg2
        public final void e(int i2, long j2) throws IOException {
            V((i2 << 3) | 0);
            t(j2);
        }

        public final void e0(zh2 zh2) throws IOException {
            V(zh2.e());
            zh2.c(this);
        }

        @Override // defpackage.bg2
        public final void f(int i2, uf2 uf2) throws IOException {
            V((i2 << 3) | 2);
            c0(uf2);
        }

        public final void f0(String str) throws IOException {
            long j2 = this.j;
            try {
                int Z = bg2.Z(str.length() * 3);
                int Z2 = bg2.Z(str.length());
                if (Z2 == Z) {
                    int i2 = ((int) (this.j - this.f)) + Z2;
                    this.e.position(i2);
                    lj2.c(str, this.e);
                    int position = this.e.position() - i2;
                    V(position);
                    this.j += (long) position;
                    return;
                }
                int a2 = lj2.a(str);
                V(a2);
                this.e.position((int) (this.j - this.f));
                lj2.c(str, this.e);
                this.j += (long) a2;
            } catch (oj2 e2) {
                this.j = j2;
                this.e.position((int) (j2 - this.f));
                j(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new c(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new c(e4);
            }
        }

        @Override // defpackage.bg2
        public final void g(int i2, zh2 zh2) throws IOException {
            V((i2 << 3) | 2);
            e0(zh2);
        }

        @Override // defpackage.bg2
        public final void h(int i2, zh2 zh2, pi2 pi2) throws IOException {
            V((i2 << 3) | 2);
            d0(zh2, pi2);
        }

        @Override // defpackage.bg2
        public final void i(int i2, String str) throws IOException {
            V((i2 << 3) | 2);
            f0(str);
        }

        @Override // defpackage.bg2
        public final int k() {
            return (int) (this.h - this.j);
        }

        @Override // defpackage.bg2
        public final void p(int i2, int i3) throws IOException {
            V((i2 << 3) | i3);
        }

        @Override // defpackage.bg2
        public final void q(int i2, uf2 uf2) throws IOException {
            p(1, 3);
            D(2, i2);
            f(3, uf2);
            p(1, 4);
        }

        @Override // defpackage.bg2
        public final void r(int i2, zh2 zh2) throws IOException {
            p(1, 3);
            D(2, i2);
            g(3, zh2);
            p(1, 4);
        }

        @Override // defpackage.bg2
        public final void s(int i2, boolean z) throws IOException {
            V((i2 << 3) | 0);
            d(z ? (byte) 1 : 0);
        }

        @Override // defpackage.bg2
        public final void t(long j2) throws IOException {
            if (this.j <= this.i) {
                while (true) {
                    int i2 = ((j2 & -128) > 0 ? 1 : ((j2 & -128) == 0 ? 0 : -1));
                    long j3 = this.j;
                    if (i2 == 0) {
                        this.j = 1 + j3;
                        jj2.f.b(j3, (byte) ((int) j2));
                        return;
                    }
                    this.j = j3 + 1;
                    jj2.f.b(j3, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
            } else {
                while (true) {
                    long j4 = this.j;
                    if (j4 >= this.h) {
                        throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
                    } else if ((j2 & -128) == 0) {
                        this.j = 1 + j4;
                        jj2.f.b(j4, (byte) ((int) j2));
                        return;
                    } else {
                        this.j = j4 + 1;
                        jj2.f.b(j4, (byte) ((((int) j2) & 127) | 128));
                        j2 >>>= 7;
                    }
                }
            }
        }
    }

    public bg2() {
    }

    public bg2(cg2 cg2) {
    }

    public static int C(int i, long j) {
        return H(j) + X(i);
    }

    public static int F(int i, long j) {
        return H(j) + X(i);
    }

    public static int G(int i, long j) {
        return H(R(j)) + X(i);
    }

    public static int H(long j) {
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

    public static int J(int i) {
        return X(i) + 8;
    }

    public static int K(int i, int i2) {
        return Y(i2) + X(i);
    }

    public static int L(long j) {
        return H(R(j));
    }

    public static int M(int i) {
        return X(i) + 8;
    }

    public static int N(int i, int i2) {
        return Z(i2) + X(i);
    }

    public static int O(String str) {
        int i;
        try {
            i = lj2.a(str);
        } catch (oj2 unused) {
            i = str.getBytes(wg2.f3775a).length;
        }
        return Z(i) + i;
    }

    public static int P(int i, int i2) {
        return Z(b0(i2)) + X(i);
    }

    public static int Q(int i) {
        return X(i) + 4;
    }

    public static long R(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int S(int i) {
        return X(i) + 4;
    }

    public static int T(int i, int i2) {
        return Y(i2) + X(i);
    }

    public static int X(int i) {
        return Z(i << 3);
    }

    public static int Y(int i) {
        if (i >= 0) {
            return Z(i);
        }
        return 10;
    }

    public static int Z(int i) {
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

    public static int a0(int i) {
        return Z(b0(i));
    }

    public static int b0(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int l(int i) {
        return X(i) + 4;
    }

    public static int m(int i, String str) {
        return O(str) + X(i);
    }

    public static int n(uf2 uf2) {
        int size = uf2.size();
        return Z(size) + size;
    }

    public static int o(zh2 zh2, pi2 pi2) {
        lf2 lf2 = (lf2) zh2;
        int h = lf2.h();
        if (h == -1) {
            h = pi2.g(lf2);
            lf2.g(h);
        }
        return Z(h) + h;
    }

    public static int u(int i) {
        return X(i) + 8;
    }

    public static int v(int i) {
        return X(i) + 1;
    }

    public static int w(int i, uf2 uf2) {
        int X = X(i);
        int size = uf2.size();
        return Z(size) + size + X;
    }

    public static int x(int i, zh2 zh2) {
        int X = X(i);
        int e2 = zh2.e();
        return X + Z(e2) + e2;
    }

    @Deprecated
    public static int y(int i, zh2 zh2, pi2 pi2) {
        int X = X(i) << 1;
        lf2 lf2 = (lf2) zh2;
        int h = lf2.h();
        if (h == -1) {
            h = pi2.g(lf2);
            lf2.g(h);
        }
        return X + h;
    }

    public static int z(zh2 zh2) {
        int e2 = zh2.e();
        return Z(e2) + e2;
    }

    public abstract void A(int i, int i2) throws IOException;

    public abstract void B(int i, long j) throws IOException;

    public abstract void D(int i, int i2) throws IOException;

    public abstract void E(long j) throws IOException;

    public abstract void I(int i, int i2) throws IOException;

    public abstract void U(int i) throws IOException;

    public abstract void V(int i) throws IOException;

    public abstract void W(int i) throws IOException;

    public abstract void b() throws IOException;

    public abstract void c(byte[] bArr, int i, int i2) throws IOException;

    public abstract void d(byte b2) throws IOException;

    public abstract void e(int i, long j) throws IOException;

    public abstract void f(int i, uf2 uf2) throws IOException;

    public abstract void g(int i, zh2 zh2) throws IOException;

    public abstract void h(int i, zh2 zh2, pi2 pi2) throws IOException;

    public abstract void i(int i, String str) throws IOException;

    public final void j(String str, oj2 oj2) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) oj2);
        byte[] bytes = str.getBytes(wg2.f3775a);
        try {
            V(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new c(e2);
        } catch (c e3) {
            throw e3;
        }
    }

    public abstract int k();

    public abstract void p(int i, int i2) throws IOException;

    public abstract void q(int i, uf2 uf2) throws IOException;

    public abstract void r(int i, zh2 zh2) throws IOException;

    public abstract void s(int i, boolean z) throws IOException;

    public abstract void t(long j) throws IOException;
}
