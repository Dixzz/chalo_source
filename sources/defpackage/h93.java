package defpackage;

import java.io.IOException;

/* renamed from: h93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class h93 {

    /* renamed from: a  reason: collision with root package name */
    public int f1350a;
    public i93 b;
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h = Integer.MAX_VALUE;

    public /* synthetic */ h93(byte[] bArr, int i) {
        this.c = bArr;
        this.d = i;
        this.f = 0;
    }

    public static int n(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long o(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public final int a() throws IOException {
        if (k()) {
            this.g = 0;
            return 0;
        }
        int e2 = e();
        this.g = e2;
        if ((e2 >>> 3) != 0) {
            return e2;
        }
        throw ma3.d();
    }

    public final void b(int i) throws ma3 {
        if (this.g != i) {
            throw ma3.e();
        }
    }

    public final boolean c(int i) throws IOException {
        int a2;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.d - this.f >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.c;
                    int i4 = this.f;
                    this.f = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw ma3.c();
            }
            while (i3 < 10) {
                if (l() < 0) {
                    i3++;
                }
            }
            throw ma3.c();
            return true;
        } else if (i2 == 1) {
            m(8);
            return true;
        } else if (i2 == 2) {
            m(e());
            return true;
        } else if (i2 == 3) {
            do {
                a2 = a();
                if (a2 == 0) {
                    break;
                }
            } while (c(a2));
            b(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                m(4);
                return true;
            }
            int i5 = ma3.f;
            throw new la3();
        }
    }

    public final boolean d() throws IOException {
        return f() != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] >= 0) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h93.e():int");
    }

    public final long f() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.f;
        int i3 = this.d;
        if (i3 != i2) {
            byte[] bArr = this.c;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f = i4;
                return (long) b2;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b2 ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ -128;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        j2 = (long) (i8 ^ 16256);
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ -2080896;
                        } else {
                            i7 = i5 + 1;
                            long j5 = (((long) bArr[i5]) << 28) ^ ((long) i9);
                            if (j5 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i10 = i7 + 1;
                                long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i10 + 1;
                                    j5 = j6 ^ (((long) bArr[i10]) << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i10 = i7 + 1;
                                        j6 = j5 ^ (((long) bArr[i7]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i10 + 1;
                                            j2 = (j6 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                i10 = i7 + 1;
                                                if (((long) bArr[i7]) >= 0) {
                                                    j = j2;
                                                    i5 = i10;
                                                    this.f = i5;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j3 ^ j6;
                                i5 = i10;
                                this.f = i5;
                                return j;
                            }
                            j2 = j5 ^ j4;
                        }
                    }
                    i5 = i7;
                    j = j2;
                    this.f = i5;
                    return j;
                }
                j = (long) i;
                this.f = i5;
                return j;
            }
        }
        return g();
    }

    public final long g() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte l = l();
            j |= ((long) (l & Byte.MAX_VALUE)) << i;
            if ((l & 128) == 0) {
                return j;
            }
        }
        throw ma3.c();
    }

    public final int h() throws IOException {
        int i = this.f;
        if (this.d - i >= 4) {
            byte[] bArr = this.c;
            this.f = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw ma3.a();
    }

    public final long i() throws IOException {
        int i = this.f;
        if (this.d - i >= 8) {
            byte[] bArr = this.c;
            this.f = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw ma3.a();
    }

    public final int j(int i) throws ma3 {
        if (i >= 0) {
            int i2 = i + this.f;
            int i3 = this.h;
            if (i2 <= i3) {
                this.h = i2;
                p();
                return i3;
            }
            throw ma3.a();
        }
        throw ma3.b();
    }

    public final boolean k() throws IOException {
        return this.f == this.d;
    }

    public final byte l() throws IOException {
        int i = this.f;
        if (i != this.d) {
            byte[] bArr = this.c;
            this.f = i + 1;
            return bArr[i];
        }
        throw ma3.a();
    }

    public final void m(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.d;
            int i3 = this.f;
            if (i <= i2 - i3) {
                this.f = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw ma3.b();
        }
        throw ma3.a();
    }

    public final void p() {
        int i = this.d + this.e;
        this.d = i;
        int i2 = this.h;
        if (i > i2) {
            int i3 = i - i2;
            this.e = i3;
            this.d = i - i3;
            return;
        }
        this.e = 0;
    }
}
