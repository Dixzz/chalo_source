package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.rabbitmq.client.LongString;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import server.zophop.Constants;

/* renamed from: vm6  reason: default package */
/* compiled from: Buffer.kt */
public final class vm6 implements ym6, xm6, Cloneable, ByteChannel {
    public ln6 f;
    public long g;

    /* renamed from: vm6$a */
    /* compiled from: Buffer.kt */
    public static final class a implements Closeable {
        public vm6 f;
        public boolean g;
        public ln6 h;
        public long i = -1;
        public byte[] j;
        public int k = -1;
        public int l = -1;

        public final long a(long j2) {
            vm6 vm6 = this.f;
            if (vm6 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.g) {
                long j3 = vm6.g;
                int i2 = 1;
                int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i3 <= 0) {
                    if (j2 >= 0) {
                        long j4 = j3 - j2;
                        while (true) {
                            if (j4 <= 0) {
                                break;
                            }
                            ln6 ln6 = vm6.f;
                            if (ln6 != null) {
                                ln6 ln62 = ln6.g;
                                if (ln62 != null) {
                                    int i4 = ln62.c;
                                    long j5 = (long) (i4 - ln62.b);
                                    if (j5 > j4) {
                                        ln62.c = i4 - ((int) j4);
                                        break;
                                    }
                                    vm6.f = ln62.a();
                                    mn6.a(ln62);
                                    j4 -= j5;
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                        }
                        this.h = null;
                        this.i = j2;
                        this.j = null;
                        this.k = -1;
                        this.l = -1;
                    } else {
                        throw new IllegalArgumentException(hj1.M("newSize < 0: ", j2).toString());
                    }
                } else if (i3 > 0) {
                    long j6 = j2 - j3;
                    boolean z = true;
                    while (j6 > 0) {
                        ln6 r = vm6.r(i2);
                        int min = (int) Math.min(j6, (long) (8192 - r.c));
                        int i5 = r.c + min;
                        r.c = i5;
                        j6 -= (long) min;
                        if (z) {
                            this.h = r;
                            this.i = j3;
                            this.j = r.f2245a;
                            this.k = i5 - min;
                            this.l = i5;
                            z = false;
                        }
                        i2 = 1;
                    }
                }
                vm6.g = j2;
                return j3;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final int c(long j2) {
            vm6 vm6 = this.f;
            if (vm6 != null) {
                if (j2 >= ((long) -1)) {
                    long j3 = vm6.g;
                    if (j2 <= j3) {
                        if (j2 == -1 || j2 == j3) {
                            this.h = null;
                            this.i = j2;
                            this.j = null;
                            this.k = -1;
                            this.l = -1;
                            return -1;
                        }
                        long j4 = 0;
                        ln6 ln6 = vm6.f;
                        ln6 ln62 = this.h;
                        if (ln62 != null) {
                            long j5 = this.i;
                            int i2 = this.k;
                            if (ln62 != null) {
                                long j6 = j5 - ((long) (i2 - ln62.b));
                                if (j6 > j2) {
                                    j3 = j6;
                                    ln62 = ln6;
                                    ln6 = ln62;
                                } else {
                                    j4 = j6;
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                        } else {
                            ln62 = ln6;
                        }
                        if (j3 - j2 > j2 - j4) {
                            while (ln62 != null) {
                                int i3 = ln62.c;
                                int i4 = ln62.b;
                                if (j2 >= ((long) (i3 - i4)) + j4) {
                                    j4 += (long) (i3 - i4);
                                    ln62 = ln62.f;
                                }
                            }
                            n86.k();
                            throw null;
                        }
                        while (j3 > j2) {
                            if (ln6 != null) {
                                ln6 = ln6.g;
                                if (ln6 != null) {
                                    j3 -= (long) (ln6.c - ln6.b);
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                        }
                        ln62 = ln6;
                        j4 = j3;
                        if (this.g) {
                            if (ln62 == null) {
                                n86.k();
                                throw null;
                            } else if (ln62.d) {
                                byte[] bArr = ln62.f2245a;
                                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                                n86.b(copyOf, "java.util.Arrays.copyOf(this, size)");
                                ln6 ln63 = new ln6(copyOf, ln62.b, ln62.c, false, true);
                                if (vm6.f == ln62) {
                                    vm6.f = ln63;
                                }
                                ln62.b(ln63);
                                ln6 ln64 = ln63.g;
                                if (ln64 != null) {
                                    ln64.a();
                                    ln62 = ln63;
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            }
                        }
                        this.h = ln62;
                        this.i = j2;
                        if (ln62 != null) {
                            this.j = ln62.f2245a;
                            int i5 = ln62.b + ((int) (j2 - j4));
                            this.k = i5;
                            int i6 = ln62.c;
                            this.l = i6;
                            return i6 - i5;
                        }
                        n86.k();
                        throw null;
                    }
                }
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j2), Long.valueOf(vm6.g)}, 2));
                n86.b(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f != null) {
                this.f = null;
                this.h = null;
                this.i = -1;
                this.j = null;
                this.k = -1;
                this.l = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public vm6 A(int i) {
        ln6 r = r(1);
        byte[] bArr = r.f2245a;
        int i2 = r.c;
        r.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.g++;
        return this;
    }

    @Override // defpackage.xm6
    public xm6 B() {
        return this;
    }

    @Override // defpackage.xm6
    public /* bridge */ /* synthetic */ xm6 C(int i) {
        K(i);
        return this;
    }

    /* renamed from: D */
    public vm6 f1(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            A(48);
        } else {
            boolean z = false;
            int i2 = 1;
            if (i < 0) {
                j = -j;
                if (j < 0) {
                    P("-9223372036854775808");
                } else {
                    z = true;
                }
            }
            if (j >= 100000000) {
                i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
            } else if (j >= Constants.THRESHOLD_TIMESTAMP) {
                i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
            } else if (j >= 100) {
                i2 = j < 1000 ? 3 : 4;
            } else if (j >= 10) {
                i2 = 2;
            }
            if (z) {
                i2++;
            }
            ln6 r = r(i2);
            byte[] bArr = r.f2245a;
            int i3 = r.c + i2;
            while (j != 0) {
                long j2 = (long) 10;
                i3--;
                bArr[i3] = sn6.f3231a[(int) (j % j2)];
                j /= j2;
            }
            if (z) {
                bArr[i3 - 1] = (byte) 45;
            }
            r.c += i2;
            this.g += (long) i2;
        }
        return this;
    }

    /* renamed from: E */
    public vm6 u0(long j) {
        if (j == 0) {
            A(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 | (j5 >>> 16);
            long j7 = j6 | (j6 >>> 32);
            long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
            long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
            long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
            long j11 = j10 + (j10 >>> 8);
            long j12 = j11 + (j11 >>> 16);
            int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
            ln6 r = r(i);
            byte[] bArr = r.f2245a;
            int i2 = r.c;
            for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
                bArr[i3] = sn6.f3231a[(int) (15 & j)];
                j >>>= 4;
            }
            r.c += i;
            this.g += (long) i;
        }
        return this;
    }

    @Override // defpackage.ym6
    public String G0() throws EOFException {
        return c0(Long.MAX_VALUE);
    }

    @Override // defpackage.xm6
    public /* bridge */ /* synthetic */ xm6 H(int i) {
        J(i);
        return this;
    }

    @Override // defpackage.ym6
    public byte[] I0(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(hj1.M("byteCount: ", j).toString());
        } else if (this.g >= j) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public vm6 J(int i) {
        ln6 r = r(4);
        byte[] bArr = r.f2245a;
        int i2 = r.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH);
        bArr[i5] = (byte) (i & com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH);
        r.c = i5 + 1;
        this.g += 4;
        return this;
    }

    public vm6 K(int i) {
        ln6 r = r(2);
        byte[] bArr = r.f2245a;
        int i2 = r.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH);
        bArr[i3] = (byte) (i & com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH);
        r.c = i3 + 1;
        this.g += 2;
        return this;
    }

    public vm6 M(String str, int i, int i2, Charset charset) {
        n86.f(str, "string");
        n86.f(charset, "charset");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (!z) {
                    StringBuilder j0 = hj1.j0("endIndex > string.length: ", i2, " > ");
                    j0.append(str.length());
                    throw new IllegalArgumentException(j0.toString().toString());
                } else if (n86.a(charset, aa6.f144a)) {
                    T(str, i, i2);
                    return this;
                } else {
                    String substring = str.substring(i, i2);
                    n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    byte[] bytes = substring.getBytes(charset);
                    n86.b(bytes, "(this as java.lang.String).getBytes(charset)");
                    x(bytes, 0, bytes.length);
                    return this;
                }
            } else {
                throw new IllegalArgumentException(hj1.L("endIndex < beginIndex: ", i2, " < ", i).toString());
            }
        } else {
            throw new IllegalArgumentException(hj1.I("beginIndex < 0: ", i).toString());
        }
    }

    @Override // defpackage.xm6
    public /* bridge */ /* synthetic */ xm6 N0(byte[] bArr) {
        w(bArr);
        return this;
    }

    @Override // defpackage.ym6
    public byte[] O() {
        return I0(this.g);
    }

    public vm6 P(String str) {
        n86.f(str, "string");
        T(str, 0, str.length());
        return this;
    }

    @Override // defpackage.xm6
    public /* bridge */ /* synthetic */ xm6 P0(zm6 zm6) {
        t(zm6);
        return this;
    }

    @Override // defpackage.ym6
    public boolean R() {
        return this.g == 0;
    }

    @Override // defpackage.xm6
    public /* bridge */ /* synthetic */ xm6 S(int i) {
        A(i);
        return this;
    }

    public vm6 T(String str, int i, int i2) {
        char charAt;
        n86.f(str, "string");
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt2 = str.charAt(i);
                        if (charAt2 < 128) {
                            ln6 r = r(1);
                            byte[] bArr = r.f2245a;
                            int i3 = r.c - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt2;
                            while (true) {
                                i = i4;
                                if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                    int i5 = r.c;
                                    int i6 = (i3 + i) - i5;
                                    r.c = i5 + i6;
                                    this.g += (long) i6;
                                } else {
                                    i4 = i + 1;
                                    bArr[i + i3] = (byte) charAt;
                                }
                            }
                            int i52 = r.c;
                            int i62 = (i3 + i) - i52;
                            r.c = i52 + i62;
                            this.g += (long) i62;
                        } else {
                            if (charAt2 < 2048) {
                                ln6 r2 = r(2);
                                byte[] bArr2 = r2.f2245a;
                                int i7 = r2.c;
                                bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                                r2.c = i7 + 2;
                                this.g += 2;
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                ln6 r3 = r(3);
                                byte[] bArr3 = r3.f2245a;
                                int i8 = r3.c;
                                bArr3[i8] = (byte) ((charAt2 >> '\f') | 224);
                                bArr3[i8 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i8 + 2] = (byte) ((charAt2 & '?') | 128);
                                r3.c = i8 + 3;
                                this.g += 3;
                            } else {
                                int i9 = i + 1;
                                char charAt3 = i9 < i2 ? str.charAt(i9) : 0;
                                if (charAt2 > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                                    A(63);
                                    i = i9;
                                } else {
                                    int i10 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                    ln6 r4 = r(4);
                                    byte[] bArr4 = r4.f2245a;
                                    int i11 = r4.c;
                                    bArr4[i11] = (byte) ((i10 >> 18) | 240);
                                    bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                                    bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                                    bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                                    r4.c = i11 + 4;
                                    this.g += 4;
                                    i += 2;
                                }
                            }
                            i++;
                        }
                    }
                    return this;
                }
                StringBuilder j0 = hj1.j0("endIndex > string.length: ", i2, " > ");
                j0.append(str.length());
                throw new IllegalArgumentException(j0.toString().toString());
            }
            throw new IllegalArgumentException(hj1.L("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        throw new IllegalArgumentException(hj1.I("beginIndex < 0: ", i).toString());
    }

    public vm6 V(int i) {
        String str;
        if (i < 128) {
            A(i);
        } else if (i < 2048) {
            ln6 r = r(2);
            byte[] bArr = r.f2245a;
            int i2 = r.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            r.c = i2 + 2;
            this.g += 2;
        } else if (55296 <= i && 57343 >= i) {
            A(63);
        } else if (i < 65536) {
            ln6 r2 = r(3);
            byte[] bArr2 = r2.f2245a;
            int i3 = r2.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            r2.c = i3 + 3;
            this.g += 3;
        } else if (i <= 1114111) {
            ln6 r3 = r(4);
            byte[] bArr3 = r3.f2245a;
            int i4 = r3.c;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            r3.c = i4 + 4;
            this.g += 4;
        } else {
            StringBuilder i0 = hj1.i0("Unexpected code point: 0x");
            if (i != 0) {
                char[] cArr = tn6.f3381a;
                int i5 = 0;
                char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
                while (i5 < 8 && cArr2[i5] == '0') {
                    i5++;
                }
                str = new String(cArr2, i5, 8 - i5);
            } else {
                str = "0";
            }
            i0.append(str);
            throw new IllegalArgumentException(i0.toString());
        }
        return this;
    }

    @Override // defpackage.ym6
    public long X0(on6 on6) throws IOException {
        n86.f(on6, "sink");
        long j = this.g;
        if (j > 0) {
            ((vm6) on6).s0(this, j);
        }
        return j;
    }

    @Override // defpackage.ym6
    public void Y(vm6 vm6, long j) throws EOFException {
        n86.f(vm6, "sink");
        long j2 = this.g;
        if (j2 >= j) {
            vm6.s0(this, j);
        } else {
            vm6.s0(this, j2);
            throw new EOFException();
        }
    }

    public final long a() {
        long j = this.g;
        if (j == 0) {
            return 0;
        }
        ln6 ln6 = this.f;
        if (ln6 != null) {
            ln6 ln62 = ln6.g;
            if (ln62 != null) {
                int i = ln62.c;
                if (i < 8192 && ln62.e) {
                    j -= (long) (i - ln62.b);
                }
                return j;
            }
            n86.k();
            throw null;
        }
        n86.k();
        throw null;
    }

    @Override // defpackage.xm6, defpackage.ym6
    public vm6 b() {
        return this;
    }

    @Override // defpackage.xm6
    public xm6 b0() {
        return this;
    }

    public final vm6 c(vm6 vm6, long j, long j2) {
        n86.f(vm6, "out");
        ec6.l(this.g, j, j2);
        if (j2 != 0) {
            vm6.g += j2;
            ln6 ln6 = this.f;
            while (ln6 != null) {
                int i = ln6.c;
                int i2 = ln6.b;
                if (j >= ((long) (i - i2))) {
                    j -= (long) (i - i2);
                    ln6 = ln6.f;
                } else {
                    while (j2 > 0) {
                        if (ln6 != null) {
                            ln6 c = ln6.c();
                            int i3 = c.b + ((int) j);
                            c.b = i3;
                            c.c = Math.min(i3 + ((int) j2), c.c);
                            ln6 ln62 = vm6.f;
                            if (ln62 == null) {
                                c.g = c;
                                c.f = c;
                                vm6.f = c;
                            } else if (ln62 != null) {
                                ln6 ln63 = ln62.g;
                                if (ln63 != null) {
                                    ln63.b(c);
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                            j2 -= (long) (c.c - c.b);
                            ln6 = ln6.f;
                            j = 0;
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                }
            }
            n86.k();
            throw null;
        }
        return this;
    }

    @Override // defpackage.ym6
    public String c0(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b2 = (byte) 10;
            long f2 = f(b2, 0, j2);
            if (f2 != -1) {
                return sn6.a(this, f2);
            }
            if (j2 < this.g && e(j2 - 1) == ((byte) 13) && e(j2) == b2) {
                return sn6.a(this, j2);
            }
            vm6 vm6 = new vm6();
            c(vm6, 0, Math.min((long) 32, this.g));
            throw new EOFException("\\n not found: limit=" + Math.min(this.g, j) + " content=" + vm6.v0().h() + (char) 8230);
        }
        throw new IllegalArgumentException(hj1.M("limit < 0: ", j).toString());
    }

    @Override // java.lang.Object
    public Object clone() {
        vm6 vm6 = new vm6();
        if (this.g != 0) {
            ln6 ln6 = this.f;
            if (ln6 != null) {
                ln6 c = ln6.c();
                vm6.f = c;
                c.g = c;
                c.f = c;
                for (ln6 ln62 = ln6.f; ln62 != ln6; ln62 = ln62.f) {
                    ln6 ln63 = c.g;
                    if (ln63 == null) {
                        n86.k();
                        throw null;
                    } else if (ln62 != null) {
                        ln63.b(ln62.c());
                    } else {
                        n86.k();
                        throw null;
                    }
                }
                vm6.g = this.g;
            } else {
                n86.k();
                throw null;
            }
        }
        return vm6;
    }

    @Override // java.lang.AutoCloseable, defpackage.on6, java.io.Closeable, defpackage.qn6, java.nio.channels.Channel
    public void close() {
    }

    @Override // defpackage.ym6
    public void d(long j) throws EOFException {
        while (j > 0) {
            ln6 ln6 = this.f;
            if (ln6 != null) {
                int min = (int) Math.min(j, (long) (ln6.c - ln6.b));
                long j2 = (long) min;
                this.g -= j2;
                j -= j2;
                int i = ln6.b + min;
                ln6.b = i;
                if (i == ln6.c) {
                    this.f = ln6.a();
                    mn6.a(ln6);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final byte e(long j) {
        ec6.l(this.g, j, 1);
        ln6 ln6 = this.f;
        if (ln6 != null) {
            long j2 = this.g;
            if (j2 - j < j) {
                while (j2 > j) {
                    ln6 = ln6.g;
                    if (ln6 != null) {
                        j2 -= (long) (ln6.c - ln6.b);
                    } else {
                        n86.k();
                        throw null;
                    }
                }
                return ln6.f2245a[(int) ((((long) ln6.b) + j) - j2)];
            }
            long j3 = 0;
            while (true) {
                int i = ln6.c;
                int i2 = ln6.b;
                long j4 = ((long) (i - i2)) + j3;
                if (j4 > j) {
                    return ln6.f2245a[(int) ((((long) i2) + j) - j3)];
                }
                ln6 = ln6.f;
                if (ln6 != null) {
                    j3 = j4;
                } else {
                    n86.k();
                    throw null;
                }
            }
        } else {
            n86.k();
            throw null;
        }
    }

    @Override // defpackage.ym6
    public void e1(long j) throws EOFException {
        if (this.g < j) {
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof vm6) {
                long j = this.g;
                vm6 vm6 = (vm6) obj;
                if (j == vm6.g) {
                    if (j != 0) {
                        ln6 ln6 = this.f;
                        if (ln6 != null) {
                            ln6 ln62 = vm6.f;
                            if (ln62 != null) {
                                int i = ln6.b;
                                int i2 = ln62.b;
                                long j2 = 0;
                                while (j2 < this.g) {
                                    long min = (long) Math.min(ln6.c - i, ln62.c - i2);
                                    long j3 = 0;
                                    while (j3 < min) {
                                        int i3 = i + 1;
                                        int i4 = i2 + 1;
                                        if (ln6.f2245a[i] == ln62.f2245a[i2]) {
                                            j3++;
                                            i = i3;
                                            i2 = i4;
                                        }
                                    }
                                    if (i == ln6.c) {
                                        ln6 ln63 = ln6.f;
                                        if (ln63 != null) {
                                            i = ln63.b;
                                            ln6 = ln63;
                                        } else {
                                            n86.k();
                                            throw null;
                                        }
                                    }
                                    if (i2 == ln62.c) {
                                        ln62 = ln62.f;
                                        if (ln62 != null) {
                                            i2 = ln62.b;
                                        } else {
                                            n86.k();
                                            throw null;
                                        }
                                    }
                                    j2 += min;
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public long f(byte b2, long j, long j2) {
        ln6 ln6;
        long j3 = 0;
        if (0 <= j && j2 >= j) {
            long j4 = this.g;
            if (j2 > j4) {
                j2 = j4;
            }
            if (!(j == j2 || (ln6 = this.f) == null)) {
                if (j4 - j < j) {
                    while (j4 > j) {
                        ln6 = ln6.g;
                        if (ln6 != null) {
                            j4 -= (long) (ln6.c - ln6.b);
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                    while (j4 < j2) {
                        byte[] bArr = ln6.f2245a;
                        int min = (int) Math.min((long) ln6.c, (((long) ln6.b) + j2) - j4);
                        for (int i = (int) ((((long) ln6.b) + j) - j4); i < min; i++) {
                            if (bArr[i] == b2) {
                                return ((long) (i - ln6.b)) + j4;
                            }
                        }
                        j4 += (long) (ln6.c - ln6.b);
                        ln6 = ln6.f;
                        if (ln6 != null) {
                            j = j4;
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                } else {
                    while (true) {
                        long j5 = ((long) (ln6.c - ln6.b)) + j3;
                        if (j5 > j) {
                            while (j3 < j2) {
                                byte[] bArr2 = ln6.f2245a;
                                int min2 = (int) Math.min((long) ln6.c, (((long) ln6.b) + j2) - j3);
                                for (int i2 = (int) ((((long) ln6.b) + j) - j3); i2 < min2; i2++) {
                                    if (bArr2[i2] == b2) {
                                        return ((long) (i2 - ln6.b)) + j3;
                                    }
                                }
                                j3 += (long) (ln6.c - ln6.b);
                                ln6 = ln6.f;
                                if (ln6 != null) {
                                    j = j3;
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            }
                        } else {
                            ln6 = ln6.f;
                            if (ln6 != null) {
                                j3 = j5;
                            } else {
                                n86.k();
                                throw null;
                            }
                        }
                    }
                }
            }
            return -1;
        }
        StringBuilder i0 = hj1.i0("size=");
        i0.append(this.g);
        i0.append(" fromIndex=");
        i0.append(j);
        i0.append(" toIndex=");
        i0.append(j2);
        throw new IllegalArgumentException(i0.toString().toString());
    }

    @Override // defpackage.xm6, defpackage.on6, java.io.Flushable
    public void flush() {
    }

    public long g(zm6 zm6) {
        int i;
        int i2;
        n86.f(zm6, "targetBytes");
        n86.f(zm6, "targetBytes");
        ln6 ln6 = this.f;
        if (ln6 == null) {
            return -1;
        }
        long j = this.g;
        long j2 = 0;
        if (j - 0 < 0) {
            while (j > 0) {
                ln6 = ln6.g;
                if (ln6 != null) {
                    j -= (long) (ln6.c - ln6.b);
                } else {
                    n86.k();
                    throw null;
                }
            }
            if (zm6.g() == 2) {
                byte j3 = zm6.j(0);
                byte j4 = zm6.j(1);
                while (j < this.g) {
                    byte[] bArr = ln6.f2245a;
                    i = (int) ((((long) ln6.b) + j2) - j);
                    int i3 = ln6.c;
                    while (i < i3) {
                        byte b2 = bArr[i];
                        if (!(b2 == j3 || b2 == j4)) {
                            i++;
                        }
                    }
                    j2 = ((long) (ln6.c - ln6.b)) + j;
                    ln6 = ln6.f;
                    if (ln6 != null) {
                        j = j2;
                    } else {
                        n86.k();
                        throw null;
                    }
                }
                return -1;
            }
            byte[] i4 = zm6.i();
            while (j < this.g) {
                byte[] bArr2 = ln6.f2245a;
                i = (int) ((((long) ln6.b) + j2) - j);
                int i5 = ln6.c;
                while (i < i5) {
                    byte b3 = bArr2[i];
                    for (byte b4 : i4) {
                        if (b3 == b4) {
                            i2 = ln6.b;
                            return ((long) (i - i2)) + j;
                        }
                    }
                    i++;
                }
                j2 = ((long) (ln6.c - ln6.b)) + j;
                ln6 = ln6.f;
                if (ln6 != null) {
                    j = j2;
                } else {
                    n86.k();
                    throw null;
                }
            }
            return -1;
        }
        j = 0;
        while (true) {
            long j5 = ((long) (ln6.c - ln6.b)) + j;
            if (j5 <= 0) {
                ln6 = ln6.f;
                if (ln6 != null) {
                    j = j5;
                } else {
                    n86.k();
                    throw null;
                }
            } else if (zm6.g() == 2) {
                byte j6 = zm6.j(0);
                byte j7 = zm6.j(1);
                while (j < this.g) {
                    byte[] bArr3 = ln6.f2245a;
                    i = (int) ((((long) ln6.b) + j2) - j);
                    int i6 = ln6.c;
                    while (i < i6) {
                        byte b5 = bArr3[i];
                        if (!(b5 == j6 || b5 == j7)) {
                            i++;
                        }
                    }
                    j2 = ((long) (ln6.c - ln6.b)) + j;
                    ln6 = ln6.f;
                    if (ln6 != null) {
                        j = j2;
                    } else {
                        n86.k();
                        throw null;
                    }
                }
                return -1;
            } else {
                byte[] i7 = zm6.i();
                while (j < this.g) {
                    byte[] bArr4 = ln6.f2245a;
                    i = (int) ((((long) ln6.b) + j2) - j);
                    int i8 = ln6.c;
                    while (i < i8) {
                        byte b6 = bArr4[i];
                        for (byte b7 : i7) {
                            if (b6 != b7) {
                            }
                        }
                        i++;
                    }
                    j2 = ((long) (ln6.c - ln6.b)) + j;
                    ln6 = ln6.f;
                    if (ln6 != null) {
                        j = j2;
                    } else {
                        n86.k();
                        throw null;
                    }
                }
                return -1;
            }
        }
        i2 = ln6.b;
        return ((long) (i - i2)) + j;
        i2 = ln6.b;
        return ((long) (i - i2)) + j;
    }

    public boolean h(long j, zm6 zm6) {
        n86.f(zm6, "bytes");
        int g2 = zm6.g();
        n86.f(zm6, "bytes");
        if (j < 0 || g2 < 0 || this.g - j < ((long) g2) || zm6.g() - 0 < g2) {
            return false;
        }
        for (int i = 0; i < g2; i++) {
            if (e(((long) i) + j) != zm6.j(0 + i)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        r15.f = r6.a();
        defpackage.mn6.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r6.b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        if (r1 != false) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0075 A[SYNTHETIC] */
    @Override // defpackage.ym6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long h1() throws java.io.EOFException {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vm6.h1():long");
    }

    public int hashCode() {
        ln6 ln6 = this.f;
        if (ln6 == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = ln6.c;
            for (int i3 = ln6.b; i3 < i2; i3++) {
                i = (i * 31) + ln6.f2245a[i3];
            }
            ln6 = ln6.f;
            if (ln6 == null) {
                n86.k();
                throw null;
            }
        } while (ln6 != this.f);
        return i;
    }

    public int i(byte[] bArr, int i, int i2) {
        n86.f(bArr, "sink");
        ec6.l((long) bArr.length, (long) i, (long) i2);
        ln6 ln6 = this.f;
        if (ln6 == null) {
            return -1;
        }
        int min = Math.min(i2, ln6.c - ln6.b);
        byte[] bArr2 = ln6.f2245a;
        int i3 = ln6.b;
        y56.b(bArr2, bArr, i, i3, i3 + min);
        int i4 = ln6.b + min;
        ln6.b = i4;
        this.g -= (long) min;
        if (i4 != ln6.c) {
            return min;
        }
        this.f = ln6.a();
        mn6.a(ln6);
        return min;
    }

    public boolean isOpen() {
        return true;
    }

    public final a j(a aVar) {
        n86.f(aVar, "unsafeCursor");
        if (aVar.f == null) {
            aVar.f = this;
            aVar.g = true;
            return aVar;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // defpackage.ym6
    public InputStream j1() {
        return new b(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r6 != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r3 = defpackage.hj1.i0("Number too large: ");
        r3.append(r1.o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        throw new java.lang.NumberFormatException(r3.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long k() throws java.io.EOFException {
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vm6.k():long");
    }

    @Override // defpackage.xm6
    public /* bridge */ /* synthetic */ xm6 k0(String str) {
        P(str);
        return this;
    }

    @Override // defpackage.ym6
    public int k1(hn6 hn6) {
        n86.f(hn6, "options");
        int b2 = sn6.b(this, hn6, false);
        if (b2 == -1) {
            return -1;
        }
        d((long) hn6.f[b2].g());
        return b2;
    }

    public short l() throws EOFException {
        int readShort = readShort() & 65535;
        return (short) (((readShort & com.google.firebase.perf.util.Constants.MAX_HOST_LENGTH) << 8) | ((65280 & readShort) >>> 8));
    }

    public String m(long j, Charset charset) throws EOFException {
        n86.f(charset, "charset");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(hj1.M("byteCount: ", j).toString());
        } else if (this.g < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            ln6 ln6 = this.f;
            if (ln6 != null) {
                int i2 = ln6.b;
                if (((long) i2) + j > ((long) ln6.c)) {
                    return new String(I0(j), charset);
                }
                int i3 = (int) j;
                String str = new String(ln6.f2245a, i2, i3, charset);
                int i4 = ln6.b + i3;
                ln6.b = i4;
                this.g -= j;
                if (i4 == ln6.c) {
                    this.f = ln6.a();
                    mn6.a(ln6);
                }
                return str;
            }
            n86.k();
            throw null;
        }
    }

    public String o() {
        return m(this.g, aa6.f144a);
    }

    public String p(long j) throws EOFException {
        return m(j, aa6.f144a);
    }

    @Override // defpackage.ym6
    public String p0(Charset charset) {
        n86.f(charset, "charset");
        return m(this.g, charset);
    }

    public final zm6 q(int i) {
        if (i == 0) {
            return zm6.i;
        }
        ec6.l(this.g, 0, (long) i);
        ln6 ln6 = this.f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (ln6 != null) {
                int i5 = ln6.c;
                int i6 = ln6.b;
                if (i5 != i6) {
                    i3 += i5 - i6;
                    i4++;
                    ln6 = ln6.f;
                } else {
                    throw new AssertionError("s.limit == s.pos");
                }
            } else {
                n86.k();
                throw null;
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        ln6 ln62 = this.f;
        int i7 = 0;
        while (i2 < i) {
            if (ln62 != null) {
                bArr[i7] = ln62.f2245a;
                i2 += ln62.c - ln62.b;
                iArr[i7] = Math.min(i2, i);
                iArr[i7 + i4] = ln62.b;
                ln62.d = true;
                i7++;
                ln62 = ln62.f;
            } else {
                n86.k();
                throw null;
            }
        }
        return new nn6(bArr, iArr);
    }

    public final ln6 r(int i) {
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            ln6 ln6 = this.f;
            if (ln6 == null) {
                ln6 b2 = mn6.b();
                this.f = b2;
                b2.g = b2;
                b2.f = b2;
                return b2;
            } else if (ln6 != null) {
                ln6 ln62 = ln6.g;
                if (ln62 == null) {
                    n86.k();
                    throw null;
                } else if (ln62.c + i <= 8192 && ln62.e) {
                    return ln62;
                } else {
                    ln6 b3 = mn6.b();
                    ln62.b(b3);
                    return b3;
                }
            } else {
                n86.k();
                throw null;
            }
        } else {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
    }

    @Override // defpackage.xm6
    public /* bridge */ /* synthetic */ xm6 r0(byte[] bArr, int i, int i2) {
        x(bArr, i, i2);
        return this;
    }

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j) {
        n86.f(vm6, "sink");
        if (j >= 0) {
            long j2 = this.g;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            vm6.s0(this, j);
            return j;
        }
        throw new IllegalArgumentException(hj1.M("byteCount < 0: ", j).toString());
    }

    @Override // defpackage.ym6
    public byte readByte() throws EOFException {
        long j = this.g;
        if (j != 0) {
            ln6 ln6 = this.f;
            if (ln6 != null) {
                int i = ln6.b;
                int i2 = ln6.c;
                int i3 = i + 1;
                byte b2 = ln6.f2245a[i];
                this.g = j - 1;
                if (i3 == i2) {
                    this.f = ln6.a();
                    mn6.a(ln6);
                } else {
                    ln6.b = i3;
                }
                return b2;
            }
            n86.k();
            throw null;
        }
        throw new EOFException();
    }

    @Override // defpackage.ym6
    public void readFully(byte[] bArr) throws EOFException {
        n86.f(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = i(bArr, i, bArr.length - i);
            if (i2 != -1) {
                i += i2;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // defpackage.ym6
    public int readInt() throws EOFException {
        long j = this.g;
        if (j >= 4) {
            ln6 ln6 = this.f;
            if (ln6 != null) {
                int i = ln6.b;
                int i2 = ln6.c;
                if (((long) (i2 - i)) < 4) {
                    return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
                }
                byte[] bArr = ln6.f2245a;
                int i3 = i + 1;
                int i4 = i3 + 1;
                int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
                int i6 = i4 + 1;
                int i7 = i5 | ((bArr[i4] & 255) << 8);
                int i8 = i6 + 1;
                int i9 = i7 | (bArr[i6] & 255);
                this.g = j - 4;
                if (i8 == i2) {
                    this.f = ln6.a();
                    mn6.a(ln6);
                } else {
                    ln6.b = i8;
                }
                return i9;
            }
            n86.k();
            throw null;
        }
        throw new EOFException();
    }

    @Override // defpackage.ym6
    public long readLong() throws EOFException {
        long j = this.g;
        if (j >= 8) {
            ln6 ln6 = this.f;
            if (ln6 != null) {
                int i = ln6.b;
                int i2 = ln6.c;
                if (((long) (i2 - i)) < 8) {
                    return ((((long) readInt()) & LongString.MAX_LENGTH) << 32) | (LongString.MAX_LENGTH & ((long) readInt()));
                }
                byte[] bArr = ln6.f2245a;
                int i3 = i + 1;
                int i4 = i3 + 1;
                long j2 = (((long) bArr[i3]) & 255) << 48;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                long j3 = j2 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32);
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                long j4 = j3 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                long j5 = j4 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
                this.g = j - 8;
                if (i10 == i2) {
                    this.f = ln6.a();
                    mn6.a(ln6);
                } else {
                    ln6.b = i10;
                }
                return j5;
            }
            n86.k();
            throw null;
        }
        throw new EOFException();
    }

    @Override // defpackage.ym6
    public short readShort() throws EOFException {
        long j = this.g;
        if (j >= 2) {
            ln6 ln6 = this.f;
            if (ln6 != null) {
                int i = ln6.b;
                int i2 = ln6.c;
                if (i2 - i < 2) {
                    return (short) (((readByte() & 255) << 8) | (readByte() & 255));
                }
                byte[] bArr = ln6.f2245a;
                int i3 = i + 1;
                int i4 = i3 + 1;
                int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
                this.g = j - 2;
                if (i4 == i2) {
                    this.f = ln6.a();
                    mn6.a(ln6);
                } else {
                    ln6.b = i4;
                }
                return (short) i5;
            }
            n86.k();
            throw null;
        }
        throw new EOFException();
    }

    @Override // defpackage.on6
    public void s0(vm6 vm6, long j) {
        ln6 ln6;
        ln6 ln62;
        n86.f(vm6, "source");
        if (vm6 != this) {
            ec6.l(vm6.g, 0, j);
            long j2 = j;
            while (j2 > 0) {
                ln6 ln63 = vm6.f;
                if (ln63 != null) {
                    int i = ln63.c;
                    if (ln63 != null) {
                        if (j2 < ((long) (i - ln63.b))) {
                            ln6 ln64 = this.f;
                            if (ln64 == null) {
                                ln6 = null;
                            } else if (ln64 != null) {
                                ln6 = ln64.g;
                            } else {
                                n86.k();
                                throw null;
                            }
                            if (ln6 != null && ln6.e) {
                                if ((((long) ln6.c) + j2) - ((long) (ln6.d ? 0 : ln6.b)) <= ((long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST)) {
                                    if (ln63 != null) {
                                        ln63.d(ln6, (int) j2);
                                        vm6.g -= j2;
                                        this.g += j2;
                                        return;
                                    }
                                    n86.k();
                                    throw null;
                                }
                            }
                            if (ln63 != null) {
                                int i2 = (int) j2;
                                Objects.requireNonNull(ln63);
                                if (i2 > 0 && i2 <= ln63.c - ln63.b) {
                                    if (i2 >= 1024) {
                                        ln62 = ln63.c();
                                    } else {
                                        ln62 = mn6.b();
                                        byte[] bArr = ln63.f2245a;
                                        byte[] bArr2 = ln62.f2245a;
                                        int i3 = ln63.b;
                                        y56.c(bArr, bArr2, 0, i3, i3 + i2, 2);
                                    }
                                    ln62.c = ln62.b + i2;
                                    ln63.b += i2;
                                    ln6 ln65 = ln63.g;
                                    if (ln65 != null) {
                                        ln65.b(ln62);
                                        vm6.f = ln62;
                                    } else {
                                        n86.k();
                                        throw null;
                                    }
                                } else {
                                    throw new IllegalArgumentException("byteCount out of range".toString());
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                        }
                        ln6 ln66 = vm6.f;
                        if (ln66 != null) {
                            long j3 = (long) (ln66.c - ln66.b);
                            vm6.f = ln66.a();
                            ln6 ln67 = this.f;
                            if (ln67 == null) {
                                this.f = ln66;
                                ln66.g = ln66;
                                ln66.f = ln66;
                            } else if (ln67 != null) {
                                ln6 ln68 = ln67.g;
                                if (ln68 != null) {
                                    ln68.b(ln66);
                                    ln6 ln69 = ln66.g;
                                    if (!(ln69 != ln66)) {
                                        throw new IllegalStateException("cannot compact".toString());
                                    } else if (ln69 == null) {
                                        n86.k();
                                        throw null;
                                    } else if (ln69.e) {
                                        int i4 = ln66.c - ln66.b;
                                        if (i4 <= (RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST - ln69.c) + (ln69.d ? 0 : ln69.b)) {
                                            ln66.d(ln69, i4);
                                            ln66.a();
                                            mn6.a(ln66);
                                        }
                                    }
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                            vm6.g -= j3;
                            this.g += j3;
                            j2 -= j3;
                        } else {
                            n86.k();
                            throw null;
                        }
                    } else {
                        n86.k();
                        throw null;
                    }
                } else {
                    n86.k();
                    throw null;
                }
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public vm6 t(zm6 zm6) {
        n86.f(zm6, "byteString");
        zm6.q(this, 0, zm6.g());
        return this;
    }

    @Override // defpackage.xm6
    public long t0(qn6 qn6) throws IOException {
        n86.f(qn6, "source");
        long j = 0;
        while (true) {
            long read = qn6.read(this, (long) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // defpackage.on6, defpackage.qn6
    public rn6 timeout() {
        return rn6.d;
    }

    public String toString() {
        long j = this.g;
        if (j <= ((long) Integer.MAX_VALUE)) {
            return q((int) j).toString();
        }
        StringBuilder i0 = hj1.i0("size > Int.MAX_VALUE: ");
        i0.append(this.g);
        throw new IllegalStateException(i0.toString().toString());
    }

    @Override // defpackage.ym6
    public zm6 v(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(hj1.M("byteCount: ", j).toString());
        } else if (this.g < j) {
            throw new EOFException();
        } else if (j < ((long) 4096)) {
            return new zm6(I0(j));
        } else {
            zm6 q = q((int) j);
            d(j);
            return q;
        }
    }

    @Override // defpackage.ym6
    public zm6 v0() {
        return v(this.g);
    }

    public vm6 w(byte[] bArr) {
        n86.f(bArr, "source");
        x(bArr, 0, bArr.length);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        n86.f(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            ln6 r = r(1);
            int min = Math.min(i, 8192 - r.c);
            byteBuffer.get(r.f2245a, r.c, min);
            i -= min;
            r.c += min;
        }
        this.g += (long) remaining;
        return remaining;
    }

    public vm6 x(byte[] bArr, int i, int i2) {
        n86.f(bArr, "source");
        long j = (long) i2;
        ec6.l((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            ln6 r = r(1);
            int min = Math.min(i3 - i, 8192 - r.c);
            int i4 = i + min;
            y56.b(bArr, r.f2245a, r.c, i, i4);
            r.c += min;
            i = i4;
        }
        this.g += j;
        return this;
    }

    /* renamed from: vm6$b */
    /* compiled from: Buffer.kt */
    public static final class b extends InputStream {
        public final /* synthetic */ vm6 f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(vm6 vm6) {
            this.f = vm6;
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(this.f.g, (long) Integer.MAX_VALUE);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            vm6 vm6 = this.f;
            if (vm6.g > 0) {
                return vm6.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return this.f + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            n86.f(bArr, "sink");
            return this.f.i(bArr, i, i2);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        n86.f(byteBuffer, "sink");
        ln6 ln6 = this.f;
        if (ln6 == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), ln6.c - ln6.b);
        byteBuffer.put(ln6.f2245a, ln6.b, min);
        int i = ln6.b + min;
        ln6.b = i;
        this.g -= (long) min;
        if (i == ln6.c) {
            this.f = ln6.a();
            mn6.a(ln6);
        }
        return min;
    }
}
