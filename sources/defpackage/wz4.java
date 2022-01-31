package defpackage;

import defpackage.a05;
import defpackage.c15;
import defpackage.t05;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* renamed from: wz4  reason: default package */
/* compiled from: BinaryReader */
public abstract class wz4 implements w15 {

    /* renamed from: wz4$b */
    /* compiled from: BinaryReader */
    public static final class b extends wz4 {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f3866a;
        public final byte[] b;
        public int c;
        public int d;
        public int e;
        public int f;

        public b(ByteBuffer byteBuffer, boolean z) {
            super(null);
            this.f3866a = z;
            this.b = byteBuffer.array();
            this.c = byteBuffer.position() + byteBuffer.arrayOffset();
            this.d = byteBuffer.limit() + byteBuffer.arrayOffset();
        }

        @Override // defpackage.w15
        public void A(List<Float> list) throws IOException {
            int i;
            int i2;
            if (list instanceof o05) {
                o05 o05 = (o05) list;
                int i3 = this.e & 7;
                if (i3 == 2) {
                    int b0 = b0();
                    i0(b0);
                    int i4 = this.c + b0;
                    while (this.c < i4) {
                        o05.d(Float.intBitsToFloat(V()));
                    }
                } else if (i3 == 5) {
                    do {
                        o05.d(readFloat());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else {
                    throw t05.d();
                }
            } else {
                int i5 = this.e & 7;
                if (i5 == 2) {
                    int b02 = b0();
                    i0(b02);
                    int i6 = this.c + b02;
                    while (this.c < i6) {
                        list.add(Float.valueOf(Float.intBitsToFloat(V())));
                    }
                } else if (i5 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public int B() throws IOException {
            g0(0);
            return b0();
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
        @Override // defpackage.w15
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean C() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 134
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.wz4.b.C():boolean");
        }

        @Override // defpackage.w15
        public int D() throws IOException {
            g0(5);
            return U();
        }

        @Override // defpackage.w15
        public void E(List<a05> list) throws IOException {
            int i;
            if ((this.e & 7) == 2) {
                do {
                    list.add(z());
                    if (!Q()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (b0() == this.e);
                this.c = i;
                return;
            }
            throw t05.d();
        }

        @Override // defpackage.w15
        public void F(List<Double> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f05) {
                f05 f05 = (f05) list;
                int i3 = this.e & 7;
                if (i3 == 1) {
                    do {
                        f05.d(readDouble());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = b0();
                    j0(b0);
                    int i4 = this.c + b0;
                    while (this.c < i4) {
                        f05.d(Double.longBitsToDouble(X()));
                    }
                } else {
                    throw t05.d();
                }
            } else {
                int i5 = this.e & 7;
                if (i5 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i5 == 2) {
                    int b02 = b0();
                    j0(b02);
                    int i6 = this.c + b02;
                    while (this.c < i6) {
                        list.add(Double.valueOf(Double.longBitsToDouble(X())));
                    }
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public long G() throws IOException {
            g0(0);
            return c0();
        }

        @Override // defpackage.w15
        public String H() throws IOException {
            return Z(true);
        }

        @Override // defpackage.w15
        public void I(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof a15) {
                a15 a15 = (a15) list;
                int i3 = this.e & 7;
                if (i3 == 1) {
                    do {
                        a15.d(d());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = b0();
                    j0(b0);
                    int i4 = this.c + b0;
                    while (this.c < i4) {
                        a15.d(X());
                    }
                } else {
                    throw t05.d();
                }
            } else {
                int i5 = this.e & 7;
                if (i5 == 1) {
                    do {
                        list.add(Long.valueOf(d()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i5 == 2) {
                    int b02 = b0();
                    j0(b02);
                    int i6 = this.c + b02;
                    while (this.c < i6) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw t05.d();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.w15
        public <T> void J(List<T> list, x15<T> x15, i05 i05) throws IOException {
            int i;
            int i2 = this.e;
            if ((i2 & 7) == 3) {
                do {
                    list.add(T(x15, i05));
                    if (!Q()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (b0() == i2);
                this.c = i;
                return;
            }
            throw t05.d();
        }

        @Override // defpackage.w15
        public <T> T K(Class<T> cls, i05 i05) throws IOException {
            g0(2);
            return (T) Y(t15.c.a(cls), i05);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.w15
        public <T> void L(List<T> list, x15<T> x15, i05 i05) throws IOException {
            int i;
            int i2 = this.e;
            if ((i2 & 7) == 2) {
                do {
                    list.add(Y(x15, i05));
                    if (!Q()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (b0() == i2);
                this.c = i;
                return;
            }
            throw t05.d();
        }

        @Override // defpackage.w15
        public <T> T M(x15<T> x15, i05 i05) throws IOException {
            g0(3);
            return (T) T(x15, i05);
        }

        @Override // defpackage.w15
        public <T> T N(Class<T> cls, i05 i05) throws IOException {
            g0(3);
            return (T) T(t15.c.a(cls), i05);
        }

        @Override // defpackage.w15
        public <T> T O(x15<T> x15, i05 i05) throws IOException {
            g0(2);
            return (T) Y(x15, i05);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.w15
        public <K, V> void P(Map<K, V> map, c15.a<K, V> aVar, i05 i05) throws IOException {
            g0(2);
            int b0 = b0();
            e0(b0);
            int i = this.d;
            this.d = this.c + b0;
            try {
                Object obj = aVar.b;
                Object obj2 = aVar.d;
                while (true) {
                    int w = w();
                    if (w == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    } else if (w == 1) {
                        obj = S(aVar.f504a, null, null);
                    } else if (w != 2) {
                        try {
                            if (!C()) {
                                throw new t05("Unable to parse map entry.");
                            }
                        } catch (t05.a unused) {
                            if (!C()) {
                                throw new t05("Unable to parse map entry.");
                            }
                        }
                    } else {
                        obj2 = S(aVar.c, aVar.d.getClass(), i05);
                    }
                }
            } finally {
                this.d = i;
            }
        }

        public final boolean Q() {
            return this.c == this.d;
        }

        public final byte R() throws IOException {
            int i = this.c;
            if (i != this.d) {
                byte[] bArr = this.b;
                this.c = i + 1;
                return bArr[i];
            }
            throw t05.h();
        }

        public final Object S(l25 l25, Class<?> cls, i05 i05) throws IOException {
            switch (l25.ordinal()) {
                case 0:
                    return Double.valueOf(readDouble());
                case 1:
                    return Float.valueOf(readFloat());
                case 2:
                    return Long.valueOf(G());
                case 3:
                    return Long.valueOf(c());
                case 4:
                    return Integer.valueOf(B());
                case 5:
                    return Long.valueOf(d());
                case 6:
                    return Integer.valueOf(h());
                case 7:
                    return Boolean.valueOf(i());
                case 8:
                    return Z(true);
                case 9:
                default:
                    throw new RuntimeException("unsupported field type.");
                case 10:
                    return K(cls, i05);
                case 11:
                    return z();
                case 12:
                    return Integer.valueOf(l());
                case 13:
                    return Integer.valueOf(q());
                case 14:
                    return Integer.valueOf(D());
                case 15:
                    return Long.valueOf(j());
                case 16:
                    return Integer.valueOf(s());
                case 17:
                    return Long.valueOf(t());
            }
        }

        public final <T> T T(x15<T> x15, i05 i05) throws IOException {
            int i = this.f;
            this.f = ((this.e >>> 3) << 3) | 4;
            try {
                T d2 = x15.d();
                x15.i(d2, this, i05);
                x15.e(d2);
                if (this.e == this.f) {
                    return d2;
                }
                throw t05.g();
            } finally {
                this.f = i;
            }
        }

        public final int U() throws IOException {
            e0(4);
            return V();
        }

        public final int V() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public final long W() throws IOException {
            e0(8);
            return X();
        }

        public final long X() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public final <T> T Y(x15<T> x15, i05 i05) throws IOException {
            int b0 = b0();
            e0(b0);
            int i = this.d;
            int i2 = this.c + b0;
            this.d = i2;
            try {
                T d2 = x15.d();
                x15.i(d2, this, i05);
                x15.e(d2);
                if (this.c == i2) {
                    return d2;
                }
                throw t05.g();
            } finally {
                this.d = i;
            }
        }

        public String Z(boolean z) throws IOException {
            g0(2);
            int b0 = b0();
            if (b0 == 0) {
                return "";
            }
            e0(b0);
            if (z) {
                byte[] bArr = this.b;
                int i = this.c;
                if (!j25.h(bArr, i, i + b0)) {
                    throw t05.c();
                }
            }
            String str = new String(this.b, this.c, b0, s05.f3160a);
            this.c += b0;
            return str;
        }

        @Override // defpackage.w15
        public int a() {
            return this.e;
        }

        public void a0(List<String> list, boolean z) throws IOException {
            int i;
            int i2;
            if ((this.e & 7) != 2) {
                throw t05.d();
            } else if (!(list instanceof y05) || z) {
                do {
                    list.add(Z(z));
                    if (!Q()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (b0() == this.e);
                this.c = i;
            } else {
                y05 y05 = (y05) list;
                do {
                    y05.K(z());
                    if (!Q()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (b0() == this.e);
                this.c = i2;
            }
        }

        @Override // defpackage.w15
        public void b(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof r05) {
                r05 r05 = (r05) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        r05.d(s());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        r05.d(b05.b(b0()));
                    }
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Integer.valueOf(s()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Integer.valueOf(b05.b(b0())));
                    }
                } else {
                    throw t05.d();
                }
            }
        }

        public final int b0() throws IOException {
            int i;
            int i2 = this.c;
            int i3 = this.d;
            if (i3 != i2) {
                byte[] bArr = this.b;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.c = i4;
                    return b2;
                } else if (i3 - i4 < 9) {
                    return (int) d0();
                } else {
                    int i5 = i4 + 1;
                    int i6 = b2 ^ (bArr[i4] << 7);
                    if (i6 < 0) {
                        i = i6 ^ -128;
                    } else {
                        int i7 = i5 + 1;
                        int i8 = i6 ^ (bArr[i5] << 14);
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            i5 = i7 + 1;
                            int i9 = i8 ^ (bArr[i7] << 21);
                            if (i9 < 0) {
                                i = i9 ^ -2080896;
                            } else {
                                i7 = i5 + 1;
                                byte b3 = bArr[i5];
                                i = (i9 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
                                    i5 = i7 + 1;
                                    if (bArr[i7] < 0) {
                                        i7 = i5 + 1;
                                        if (bArr[i5] < 0) {
                                            i5 = i7 + 1;
                                            if (bArr[i7] < 0) {
                                                i7 = i5 + 1;
                                                if (bArr[i5] < 0) {
                                                    i5 = i7 + 1;
                                                    if (bArr[i7] < 0) {
                                                        throw t05.e();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i5 = i7;
                    }
                    this.c = i5;
                    return i;
                }
            } else {
                throw t05.h();
            }
        }

        @Override // defpackage.w15
        public long c() throws IOException {
            g0(0);
            return c0();
        }

        public long c0() throws IOException {
            long j;
            long j2;
            long j3;
            int i;
            int i2 = this.c;
            int i3 = this.d;
            if (i3 != i2) {
                byte[] bArr = this.b;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.c = i4;
                    return (long) b2;
                } else if (i3 - i4 < 9) {
                    return d0();
                } else {
                    int i5 = i4 + 1;
                    int i6 = b2 ^ (bArr[i4] << 7);
                    if (i6 < 0) {
                        i = i6 ^ -128;
                    } else {
                        int i7 = i5 + 1;
                        int i8 = i6 ^ (bArr[i5] << 14);
                        if (i8 >= 0) {
                            i5 = i7;
                            j = (long) (i8 ^ 16256);
                        } else {
                            i5 = i7 + 1;
                            int i9 = i8 ^ (bArr[i7] << 21);
                            if (i9 < 0) {
                                i = i9 ^ -2080896;
                            } else {
                                long j4 = (long) i9;
                                int i10 = i5 + 1;
                                long j5 = j4 ^ (((long) bArr[i5]) << 28);
                                if (j5 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    i5 = i10 + 1;
                                    long j6 = j5 ^ (((long) bArr[i10]) << 35);
                                    if (j6 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i10 = i5 + 1;
                                        j5 = j6 ^ (((long) bArr[i5]) << 42);
                                        if (j5 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i5 = i10 + 1;
                                            j6 = j5 ^ (((long) bArr[i10]) << 49);
                                            if (j6 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                int i11 = i5 + 1;
                                                long j7 = (j6 ^ (((long) bArr[i5]) << 56)) ^ 71499008037633920L;
                                                if (j7 < 0) {
                                                    i5 = i11 + 1;
                                                    if (((long) bArr[i11]) < 0) {
                                                        throw t05.e();
                                                    }
                                                } else {
                                                    i5 = i11;
                                                }
                                                j = j7;
                                            }
                                        }
                                    }
                                    j = j6 ^ j2;
                                }
                                j = j5 ^ j3;
                                i5 = i10;
                            }
                        }
                        this.c = i5;
                        return j;
                    }
                    j = (long) i;
                    this.c = i5;
                    return j;
                }
            } else {
                throw t05.h();
            }
        }

        @Override // defpackage.w15
        public long d() throws IOException {
            g0(1);
            return W();
        }

        public final long d0() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte R = R();
                j |= ((long) (R & Byte.MAX_VALUE)) << i;
                if ((R & 128) == 0) {
                    return j;
                }
            }
            throw t05.e();
        }

        @Override // defpackage.w15
        public void e(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof r05) {
                r05 r05 = (r05) list;
                int i3 = this.e & 7;
                if (i3 == 2) {
                    int b0 = b0();
                    i0(b0);
                    int i4 = this.c + b0;
                    while (this.c < i4) {
                        r05.d(V());
                    }
                } else if (i3 == 5) {
                    do {
                        r05.d(D());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else {
                    throw t05.d();
                }
            } else {
                int i5 = this.e & 7;
                if (i5 == 2) {
                    int b02 = b0();
                    i0(b02);
                    int i6 = this.c + b02;
                    while (this.c < i6) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (i5 == 5) {
                    do {
                        list.add(Integer.valueOf(D()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else {
                    throw t05.d();
                }
            }
        }

        public final void e0(int i) throws IOException {
            if (i < 0 || i > this.d - this.c) {
                throw t05.h();
            }
        }

        @Override // defpackage.w15
        public void f(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof a15) {
                a15 a15 = (a15) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        a15.d(t());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        a15.d(b05.c(c0()));
                    }
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Long.valueOf(t()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Long.valueOf(b05.c(c0())));
                    }
                } else {
                    throw t05.d();
                }
            }
        }

        public final void f0(int i) throws IOException {
            if (this.c != i) {
                throw t05.h();
            }
        }

        @Override // defpackage.w15
        public void g(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof r05) {
                r05 r05 = (r05) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        r05.d(l());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        r05.d(b0());
                    }
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Integer.valueOf(l()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw t05.d();
                }
            }
        }

        public final void g0(int i) throws IOException {
            if ((this.e & 7) != i) {
                throw t05.d();
            }
        }

        @Override // defpackage.w15
        public int h() throws IOException {
            g0(5);
            return U();
        }

        public final void h0(int i) throws IOException {
            e0(i);
            this.c += i;
        }

        @Override // defpackage.w15
        public boolean i() throws IOException {
            g0(0);
            if (b0() != 0) {
                return true;
            }
            return false;
        }

        public final void i0(int i) throws IOException {
            e0(i);
            if ((i & 3) != 0) {
                throw t05.g();
            }
        }

        @Override // defpackage.w15
        public long j() throws IOException {
            g0(1);
            return W();
        }

        public final void j0(int i) throws IOException {
            e0(i);
            if ((i & 7) != 0) {
                throw t05.g();
            }
        }

        @Override // defpackage.w15
        public void k(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof a15) {
                a15 a15 = (a15) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        a15.d(c());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        a15.d(c0());
                    }
                    f0(b0);
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Long.valueOf(c()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(b02);
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public int l() throws IOException {
            g0(0);
            return b0();
        }

        @Override // defpackage.w15
        public void m(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof a15) {
                a15 a15 = (a15) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        a15.d(G());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        a15.d(c0());
                    }
                    f0(b0);
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Long.valueOf(G()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(b02);
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public void n(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof a15) {
                a15 a15 = (a15) list;
                int i3 = this.e & 7;
                if (i3 == 1) {
                    do {
                        a15.d(j());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = b0();
                    j0(b0);
                    int i4 = this.c + b0;
                    while (this.c < i4) {
                        a15.d(X());
                    }
                } else {
                    throw t05.d();
                }
            } else {
                int i5 = this.e & 7;
                if (i5 == 1) {
                    do {
                        list.add(Long.valueOf(j()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i5 == 2) {
                    int b02 = b0();
                    j0(b02);
                    int i6 = this.c + b02;
                    while (this.c < i6) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public void o(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof r05) {
                r05 r05 = (r05) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        r05.d(B());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        r05.d(b0());
                    }
                    f0(b0);
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Integer.valueOf(B()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Integer.valueOf(b0()));
                    }
                    f0(b02);
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public void p(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof r05) {
                r05 r05 = (r05) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        r05.d(q());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        r05.d(b0());
                    }
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Integer.valueOf(q()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public int q() throws IOException {
            g0(0);
            return b0();
        }

        @Override // defpackage.w15
        public void r(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof r05) {
                r05 r05 = (r05) list;
                int i3 = this.e & 7;
                if (i3 == 2) {
                    int b0 = b0();
                    i0(b0);
                    int i4 = this.c + b0;
                    while (this.c < i4) {
                        r05.d(V());
                    }
                } else if (i3 == 5) {
                    do {
                        r05.d(h());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else {
                    throw t05.d();
                }
            } else {
                int i5 = this.e & 7;
                if (i5 == 2) {
                    int b02 = b0();
                    i0(b02);
                    int i6 = this.c + b02;
                    while (this.c < i6) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (i5 == 5) {
                    do {
                        list.add(Integer.valueOf(h()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public double readDouble() throws IOException {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        @Override // defpackage.w15
        public float readFloat() throws IOException {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        @Override // defpackage.w15
        public int s() throws IOException {
            g0(0);
            return b05.b(b0());
        }

        @Override // defpackage.w15
        public long t() throws IOException {
            g0(0);
            return b05.c(c0());
        }

        @Override // defpackage.w15
        public void u(List<Boolean> list) throws IOException {
            int i;
            int i2;
            if (list instanceof xz4) {
                xz4 xz4 = (xz4) list;
                int i3 = this.e & 7;
                if (i3 == 0) {
                    do {
                        xz4.d(i());
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i2;
                } else if (i3 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        xz4.d(b0() != 0);
                    }
                    f0(b0);
                } else {
                    throw t05.d();
                }
            } else {
                int i4 = this.e & 7;
                if (i4 == 0) {
                    do {
                        list.add(Boolean.valueOf(i()));
                        if (!Q()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.e);
                    this.c = i;
                } else if (i4 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Boolean.valueOf(b0() != 0));
                    }
                    f0(b02);
                } else {
                    throw t05.d();
                }
            }
        }

        @Override // defpackage.w15
        public String v() throws IOException {
            return Z(false);
        }

        @Override // defpackage.w15
        public int w() throws IOException {
            if (Q()) {
                return Integer.MAX_VALUE;
            }
            int b0 = b0();
            this.e = b0;
            if (b0 == this.f) {
                return Integer.MAX_VALUE;
            }
            return b0 >>> 3;
        }

        @Override // defpackage.w15
        public void x(List<String> list) throws IOException {
            a0(list, false);
        }

        @Override // defpackage.w15
        public void y(List<String> list) throws IOException {
            a0(list, true);
        }

        @Override // defpackage.w15
        public a05 z() throws IOException {
            a05 a05;
            g0(2);
            int b0 = b0();
            if (b0 == 0) {
                return a05.g;
            }
            e0(b0);
            if (this.f3866a) {
                byte[] bArr = this.b;
                int i = this.c;
                a05 a052 = a05.g;
                a05 = new a05.c(bArr, i, b0);
            } else {
                a05 = a05.e(this.b, this.c, b0);
            }
            this.c += b0;
            return a05;
        }
    }

    public wz4(a aVar) {
    }
}
