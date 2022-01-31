package defpackage;

import defpackage.a05;
import defpackage.j25;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: b05  reason: default package */
/* compiled from: CodedInputStream */
public abstract class b05 {

    /* renamed from: a  reason: collision with root package name */
    public int f362a;
    public int b = 100;
    public int c = Integer.MAX_VALUE;
    public c05 d;

    /* renamed from: b05$b */
    /* compiled from: CodedInputStream */
    public static final class b extends b05 {
        public final byte[] e;
        public final boolean f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l = Integer.MAX_VALUE;

        public b(byte[] bArr, int i2, int i3, boolean z, a aVar) {
            super(null);
            this.e = bArr;
            this.g = i3 + i2;
            this.i = i2;
            this.j = i2;
            this.f = z;
        }

        @Override // defpackage.b05
        public int A() throws IOException {
            if (e()) {
                this.k = 0;
                return 0;
            }
            int H = H();
            this.k = H;
            if ((H >>> 3) != 0) {
                return H;
            }
            throw t05.b();
        }

        @Override // defpackage.b05
        public int B() throws IOException {
            return H();
        }

        @Override // defpackage.b05
        public long C() throws IOException {
            return I();
        }

        @Override // defpackage.b05
        public boolean D(int i2) throws IOException {
            int A;
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 == 0) {
                if (this.g - this.i >= 10) {
                    while (i4 < 10) {
                        byte[] bArr = this.e;
                        int i5 = this.i;
                        this.i = i5 + 1;
                        if (bArr[i5] < 0) {
                            i4++;
                        }
                    }
                    throw t05.e();
                }
                while (i4 < 10) {
                    if (E() < 0) {
                        i4++;
                    }
                }
                throw t05.e();
                return true;
            } else if (i3 == 1) {
                L(8);
                return true;
            } else if (i3 == 2) {
                L(H());
                return true;
            } else if (i3 == 3) {
                do {
                    A = A();
                    if (A == 0) {
                        break;
                    }
                } while (D(A));
                a(((i2 >>> 3) << 3) | 4);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    L(4);
                    return true;
                }
                throw t05.d();
            }
        }

        public byte E() throws IOException {
            int i2 = this.i;
            if (i2 != this.g) {
                byte[] bArr = this.e;
                this.i = i2 + 1;
                return bArr[i2];
            }
            throw t05.h();
        }

        public int F() throws IOException {
            int i2 = this.i;
            if (this.g - i2 >= 4) {
                byte[] bArr = this.e;
                this.i = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw t05.h();
        }

        public long G() throws IOException {
            int i2 = this.i;
            if (this.g - i2 >= 8) {
                byte[] bArr = this.e;
                this.i = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw t05.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int H() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 115
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.b05.b.H():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long I() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 192
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.b05.b.I():long");
        }

        public long J() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte E = E();
                j2 |= ((long) (E & Byte.MAX_VALUE)) << i2;
                if ((E & 128) == 0) {
                    return j2;
                }
            }
            throw t05.e();
        }

        public final void K() {
            int i2 = this.g + this.h;
            this.g = i2;
            int i3 = i2 - this.j;
            int i4 = this.l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.h = i5;
                this.g = i2 - i5;
                return;
            }
            this.h = 0;
        }

        public void L(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.g;
                int i4 = this.i;
                if (i2 <= i3 - i4) {
                    this.i = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw t05.f();
            }
            throw t05.h();
        }

        @Override // defpackage.b05
        public void a(int i2) throws t05 {
            if (this.k != i2) {
                throw t05.a();
            }
        }

        @Override // defpackage.b05
        public int d() {
            return this.i - this.j;
        }

        @Override // defpackage.b05
        public boolean e() throws IOException {
            return this.i == this.g;
        }

        @Override // defpackage.b05
        public void i(int i2) {
            this.l = i2;
            K();
        }

        @Override // defpackage.b05
        public int j(int i2) throws t05 {
            if (i2 >= 0) {
                int d = d() + i2;
                int i3 = this.l;
                if (d <= i3) {
                    this.l = d;
                    K();
                    return i3;
                }
                throw t05.h();
            }
            throw t05.f();
        }

        @Override // defpackage.b05
        public boolean k() throws IOException {
            return I() != 0;
        }

        @Override // defpackage.b05
        public a05 l() throws IOException {
            byte[] bArr;
            int H = H();
            if (H > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (H <= i2 - i3) {
                    boolean z = this.f;
                    a05 e2 = a05.e(this.e, i3, H);
                    this.i += H;
                    return e2;
                }
            }
            if (H == 0) {
                return a05.g;
            }
            if (H > 0) {
                int i4 = this.g;
                int i5 = this.i;
                if (H <= i4 - i5) {
                    int i6 = H + i5;
                    this.i = i6;
                    bArr = Arrays.copyOfRange(this.e, i5, i6);
                    a05 a05 = a05.g;
                    return new a05.f(bArr);
                }
            }
            if (H > 0) {
                throw t05.h();
            } else if (H == 0) {
                bArr = s05.b;
                a05 a052 = a05.g;
                return new a05.f(bArr);
            } else {
                throw t05.f();
            }
        }

        @Override // defpackage.b05
        public double m() throws IOException {
            return Double.longBitsToDouble(G());
        }

        @Override // defpackage.b05
        public int n() throws IOException {
            return H();
        }

        @Override // defpackage.b05
        public int o() throws IOException {
            return F();
        }

        @Override // defpackage.b05
        public long p() throws IOException {
            return G();
        }

        @Override // defpackage.b05
        public float q() throws IOException {
            return Float.intBitsToFloat(F());
        }

        @Override // defpackage.b05
        public int r() throws IOException {
            return H();
        }

        @Override // defpackage.b05
        public long s() throws IOException {
            return I();
        }

        @Override // defpackage.b05
        public int u() throws IOException {
            return F();
        }

        @Override // defpackage.b05
        public long v() throws IOException {
            return G();
        }

        @Override // defpackage.b05
        public int w() throws IOException {
            return b05.b(H());
        }

        @Override // defpackage.b05
        public long x() throws IOException {
            return b05.c(I());
        }

        @Override // defpackage.b05
        public String y() throws IOException {
            int H = H();
            if (H > 0 && H <= this.g - this.i) {
                String str = new String(this.e, this.i, H, s05.f3160a);
                this.i += H;
                return str;
            } else if (H == 0) {
                return "";
            } else {
                if (H < 0) {
                    throw t05.f();
                }
                throw t05.h();
            }
        }

        @Override // defpackage.b05
        public String z() throws IOException {
            int H = H();
            if (H > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (H <= i2 - i3) {
                    String b = j25.b(this.e, i3, H);
                    this.i += H;
                    return b;
                }
            }
            if (H == 0) {
                return "";
            }
            if (H <= 0) {
                throw t05.f();
            }
            throw t05.h();
        }
    }

    /* renamed from: b05$c */
    /* compiled from: CodedInputStream */
    public static final class c extends b05 {
        public final InputStream e;
        public final byte[] f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l = Integer.MAX_VALUE;

        public c(InputStream inputStream, int i2, a aVar) {
            super(null);
            Charset charset = s05.f3160a;
            this.e = inputStream;
            this.f = new byte[i2];
            this.g = 0;
            this.i = 0;
            this.k = 0;
        }

        @Override // defpackage.b05
        public int A() throws IOException {
            if (e()) {
                this.j = 0;
                return 0;
            }
            int K = K();
            this.j = K;
            if ((K >>> 3) != 0) {
                return K;
            }
            throw t05.b();
        }

        @Override // defpackage.b05
        public int B() throws IOException {
            return K();
        }

        @Override // defpackage.b05
        public long C() throws IOException {
            return L();
        }

        @Override // defpackage.b05
        public boolean D(int i2) throws IOException {
            int A;
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 == 0) {
                if (this.g - this.i >= 10) {
                    while (i4 < 10) {
                        byte[] bArr = this.f;
                        int i5 = this.i;
                        this.i = i5 + 1;
                        if (bArr[i5] < 0) {
                            i4++;
                        }
                    }
                    throw t05.e();
                }
                while (i4 < 10) {
                    if (E() < 0) {
                        i4++;
                    }
                }
                throw t05.e();
                return true;
            } else if (i3 == 1) {
                P(8);
                return true;
            } else if (i3 == 2) {
                P(K());
                return true;
            } else if (i3 == 3) {
                do {
                    A = A();
                    if (A == 0) {
                        break;
                    }
                } while (D(A));
                a(((i2 >>> 3) << 3) | 4);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    P(4);
                    return true;
                }
                throw t05.d();
            }
        }

        public byte E() throws IOException {
            if (this.i == this.g) {
                O(1);
            }
            byte[] bArr = this.f;
            int i2 = this.i;
            this.i = i2 + 1;
            return bArr[i2];
        }

        public final byte[] F(int i2, boolean z) throws IOException {
            byte[] G = G(i2);
            if (G != null) {
                return z ? (byte[]) G.clone() : G;
            }
            int i3 = this.i;
            int i4 = this.g;
            int i5 = i4 - i3;
            this.k += i4;
            this.i = 0;
            this.g = 0;
            List<byte[]> H = H(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f, i3, bArr, 0, i5);
            Iterator it = ((ArrayList) H).iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        public final byte[] G(int i2) throws IOException {
            if (i2 == 0) {
                return s05.b;
            }
            if (i2 >= 0) {
                int i3 = this.k;
                int i4 = this.i;
                int i5 = i3 + i4 + i2;
                if (i5 - this.c <= 0) {
                    int i6 = this.l;
                    if (i5 <= i6) {
                        int i7 = this.g - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.e.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f, this.i, bArr, 0, i7);
                        this.k += this.g;
                        this.i = 0;
                        this.g = 0;
                        while (i7 < i2) {
                            int read = this.e.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.k += read;
                                i7 += read;
                            } else {
                                throw t05.h();
                            }
                        }
                        return bArr;
                    }
                    P((i6 - i3) - i4);
                    throw t05.h();
                }
                throw new t05("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw t05.f();
        }

        public final List<byte[]> H(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, 4096);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.e.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.k += read;
                        i3 += read;
                    } else {
                        throw t05.h();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int I() throws IOException {
            int i2 = this.i;
            if (this.g - i2 < 4) {
                O(4);
                i2 = this.i;
            }
            byte[] bArr = this.f;
            this.i = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long J() throws IOException {
            int i2 = this.i;
            if (this.g - i2 < 8) {
                O(8);
                i2 = this.i;
            }
            byte[] bArr = this.f;
            this.i = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int K() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 115
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.b05.c.K():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long L() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 192
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.b05.c.L():long");
        }

        public long M() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte E = E();
                j2 |= ((long) (E & Byte.MAX_VALUE)) << i2;
                if ((E & 128) == 0) {
                    return j2;
                }
            }
            throw t05.e();
        }

        public final void N() {
            int i2 = this.g + this.h;
            this.g = i2;
            int i3 = this.k + i2;
            int i4 = this.l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.h = i5;
                this.g = i2 - i5;
                return;
            }
            this.h = 0;
        }

        public final void O(int i2) throws IOException {
            if (Q(i2)) {
                return;
            }
            if (i2 > (this.c - this.k) - this.i) {
                throw new t05("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw t05.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
            throw new java.lang.IllegalStateException(r8.e.getClass() + "#skip returned invalid result: " + r1 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void P(int r9) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 162
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.b05.c.P(int):void");
        }

        public final boolean Q(int i2) throws IOException {
            int i3 = this.i;
            int i4 = i3 + i2;
            int i5 = this.g;
            if (i4 > i5) {
                int i6 = this.c;
                int i7 = this.k;
                if (i2 > (i6 - i7) - i3 || i7 + i3 + i2 > this.l) {
                    return false;
                }
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.f;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.k += i3;
                    this.g -= i3;
                    this.i = 0;
                }
                InputStream inputStream = this.e;
                byte[] bArr2 = this.f;
                int i8 = this.g;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.c - this.k) - i8));
                if (read == 0 || read < -1 || read > this.f.length) {
                    throw new IllegalStateException(this.e.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.g += read;
                    N();
                    if (this.g >= i2) {
                        return true;
                    }
                    return Q(i2);
                }
            } else {
                throw new IllegalStateException(hj1.J("refillBuffer() called when ", i2, " bytes were already available in buffer"));
            }
        }

        @Override // defpackage.b05
        public void a(int i2) throws t05 {
            if (this.j != i2) {
                throw t05.a();
            }
        }

        @Override // defpackage.b05
        public int d() {
            return this.k + this.i;
        }

        @Override // defpackage.b05
        public boolean e() throws IOException {
            return this.i == this.g && !Q(1);
        }

        @Override // defpackage.b05
        public void i(int i2) {
            this.l = i2;
            N();
        }

        @Override // defpackage.b05
        public int j(int i2) throws t05 {
            if (i2 >= 0) {
                int i3 = this.k + this.i + i2;
                int i4 = this.l;
                if (i3 <= i4) {
                    this.l = i3;
                    N();
                    return i4;
                }
                throw t05.h();
            }
            throw t05.f();
        }

        @Override // defpackage.b05
        public boolean k() throws IOException {
            return L() != 0;
        }

        @Override // defpackage.b05
        public a05 l() throws IOException {
            int K = K();
            int i2 = this.g;
            int i3 = this.i;
            if (K <= i2 - i3 && K > 0) {
                a05 e2 = a05.e(this.f, i3, K);
                this.i += K;
                return e2;
            } else if (K == 0) {
                return a05.g;
            } else {
                byte[] G = G(K);
                if (G != null) {
                    a05 a05 = a05.g;
                    return a05.e(G, 0, G.length);
                }
                int i4 = this.i;
                int i5 = this.g;
                int i6 = i5 - i4;
                this.k += i5;
                this.i = 0;
                this.g = 0;
                List<byte[]> H = H(K - i6);
                byte[] bArr = new byte[K];
                System.arraycopy(this.f, i4, bArr, 0, i6);
                Iterator it = ((ArrayList) H).iterator();
                while (it.hasNext()) {
                    byte[] bArr2 = (byte[]) it.next();
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    i6 += bArr2.length;
                }
                a05 a052 = a05.g;
                return new a05.f(bArr);
            }
        }

        @Override // defpackage.b05
        public double m() throws IOException {
            return Double.longBitsToDouble(J());
        }

        @Override // defpackage.b05
        public int n() throws IOException {
            return K();
        }

        @Override // defpackage.b05
        public int o() throws IOException {
            return I();
        }

        @Override // defpackage.b05
        public long p() throws IOException {
            return J();
        }

        @Override // defpackage.b05
        public float q() throws IOException {
            return Float.intBitsToFloat(I());
        }

        @Override // defpackage.b05
        public int r() throws IOException {
            return K();
        }

        @Override // defpackage.b05
        public long s() throws IOException {
            return L();
        }

        @Override // defpackage.b05
        public int u() throws IOException {
            return I();
        }

        @Override // defpackage.b05
        public long v() throws IOException {
            return J();
        }

        @Override // defpackage.b05
        public int w() throws IOException {
            return b05.b(K());
        }

        @Override // defpackage.b05
        public long x() throws IOException {
            return b05.c(L());
        }

        @Override // defpackage.b05
        public String y() throws IOException {
            int K = K();
            if (K > 0 && K <= this.g - this.i) {
                String str = new String(this.f, this.i, K, s05.f3160a);
                this.i += K;
                return str;
            } else if (K == 0) {
                return "";
            } else {
                if (K > this.g) {
                    return new String(F(K, false), s05.f3160a);
                }
                O(K);
                String str2 = new String(this.f, this.i, K, s05.f3160a);
                this.i += K;
                return str2;
            }
        }

        @Override // defpackage.b05
        public String z() throws IOException {
            byte[] bArr;
            int K = K();
            int i2 = this.i;
            int i3 = this.g;
            if (K <= i3 - i2 && K > 0) {
                bArr = this.f;
                this.i = i2 + K;
            } else if (K == 0) {
                return "";
            } else {
                if (K <= i3) {
                    O(K);
                    bArr = this.f;
                    this.i = K + 0;
                } else {
                    bArr = F(K, false);
                }
                i2 = 0;
            }
            return j25.b(bArr, i2, K);
        }
    }

    /* renamed from: b05$d */
    /* compiled from: CodedInputStream */
    public static final class d extends b05 {
        public final ByteBuffer e;
        public final boolean f;
        public final long g;
        public long h;
        public long i;
        public long j;
        public int k;
        public int l;
        public int m = Integer.MAX_VALUE;

        public d(ByteBuffer byteBuffer, boolean z, a aVar) {
            super(null);
            this.e = byteBuffer;
            long a2 = i25.a(byteBuffer);
            this.g = a2;
            this.h = ((long) byteBuffer.limit()) + a2;
            long position = a2 + ((long) byteBuffer.position());
            this.i = position;
            this.j = position;
            this.f = z;
        }

        @Override // defpackage.b05
        public int A() throws IOException {
            if (e()) {
                this.l = 0;
                return 0;
            }
            int I = I();
            this.l = I;
            if ((I >>> 3) != 0) {
                return I;
            }
            throw t05.b();
        }

        @Override // defpackage.b05
        public int B() throws IOException {
            return I();
        }

        @Override // defpackage.b05
        public long C() throws IOException {
            return J();
        }

        @Override // defpackage.b05
        public boolean D(int i2) throws IOException {
            int A;
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 == 0) {
                if (M() >= 10) {
                    while (i4 < 10) {
                        long j2 = this.i;
                        this.i = 1 + j2;
                        if (i25.h(j2) < 0) {
                            i4++;
                        }
                    }
                    throw t05.e();
                }
                while (i4 < 10) {
                    if (F() < 0) {
                        i4++;
                    }
                }
                throw t05.e();
                return true;
            } else if (i3 == 1) {
                N(8);
                return true;
            } else if (i3 == 2) {
                N(I());
                return true;
            } else if (i3 == 3) {
                do {
                    A = A();
                    if (A == 0) {
                        break;
                    }
                } while (D(A));
                a(((i2 >>> 3) << 3) | 4);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    N(4);
                    return true;
                }
                throw t05.d();
            }
        }

        public final int E(long j2) {
            return (int) (j2 - this.g);
        }

        public byte F() throws IOException {
            long j2 = this.i;
            if (j2 != this.h) {
                this.i = 1 + j2;
                return i25.h(j2);
            }
            throw t05.h();
        }

        public int G() throws IOException {
            long j2 = this.i;
            if (this.h - j2 >= 4) {
                this.i = 4 + j2;
                return ((i25.h(j2 + 3) & 255) << 24) | (i25.h(j2) & 255) | ((i25.h(1 + j2) & 255) << 8) | ((i25.h(2 + j2) & 255) << 16);
            }
            throw t05.h();
        }

        public long H() throws IOException {
            long j2 = this.i;
            if (this.h - j2 >= 8) {
                this.i = 8 + j2;
                return ((((long) i25.h(j2 + 7)) & 255) << 56) | (((long) i25.h(j2)) & 255) | ((((long) i25.h(1 + j2)) & 255) << 8) | ((((long) i25.h(2 + j2)) & 255) << 16) | ((((long) i25.h(3 + j2)) & 255) << 24) | ((((long) i25.h(4 + j2)) & 255) << 32) | ((((long) i25.h(5 + j2)) & 255) << 40) | ((((long) i25.h(6 + j2)) & 255) << 48);
            }
            throw t05.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (defpackage.i25.h(r4) < 0) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int I() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 142
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.b05.d.I():int");
        }

        public long J() throws IOException {
            long j2;
            long j3;
            long j4;
            int i2;
            long j5 = this.i;
            if (this.h != j5) {
                long j6 = j5 + 1;
                byte h2 = i25.h(j5);
                if (h2 >= 0) {
                    this.i = j6;
                    return (long) h2;
                } else if (this.h - j6 >= 9) {
                    long j7 = j6 + 1;
                    int h3 = h2 ^ (i25.h(j6) << 7);
                    if (h3 < 0) {
                        i2 = h3 ^ -128;
                    } else {
                        long j8 = j7 + 1;
                        int h4 = h3 ^ (i25.h(j7) << 14);
                        if (h4 >= 0) {
                            j2 = (long) (h4 ^ 16256);
                        } else {
                            j7 = j8 + 1;
                            int h5 = h4 ^ (i25.h(j8) << 21);
                            if (h5 < 0) {
                                i2 = h5 ^ -2080896;
                            } else {
                                j8 = j7 + 1;
                                long h6 = ((long) h5) ^ (((long) i25.h(j7)) << 28);
                                if (h6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = j8 + 1;
                                    long h7 = h6 ^ (((long) i25.h(j8)) << 35);
                                    if (h7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j8 = j9 + 1;
                                        h6 = h7 ^ (((long) i25.h(j9)) << 42);
                                        if (h6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = j8 + 1;
                                            h7 = h6 ^ (((long) i25.h(j8)) << 49);
                                            if (h7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j8 = j9 + 1;
                                                j2 = (h7 ^ (((long) i25.h(j9)) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    long j10 = 1 + j8;
                                                    if (((long) i25.h(j8)) >= 0) {
                                                        j7 = j10;
                                                        this.i = j7;
                                                        return j2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = h7 ^ j3;
                                    j7 = j9;
                                    this.i = j7;
                                    return j2;
                                }
                                j2 = h6 ^ j4;
                            }
                        }
                        j7 = j8;
                        this.i = j7;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.i = j7;
                    return j2;
                }
            }
            return K();
        }

        public long K() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte F = F();
                j2 |= ((long) (F & Byte.MAX_VALUE)) << i2;
                if ((F & 128) == 0) {
                    return j2;
                }
            }
            throw t05.e();
        }

        public final void L() {
            long j2 = this.h + ((long) this.k);
            this.h = j2;
            int i2 = (int) (j2 - this.j);
            int i3 = this.m;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.k = i4;
                this.h = j2 - ((long) i4);
                return;
            }
            this.k = 0;
        }

        public final int M() {
            return (int) (this.h - this.i);
        }

        public void N(int i2) throws IOException {
            if (i2 >= 0 && i2 <= M()) {
                this.i += (long) i2;
            } else if (i2 < 0) {
                throw t05.f();
            } else {
                throw t05.h();
            }
        }

        @Override // defpackage.b05
        public void a(int i2) throws t05 {
            if (this.l != i2) {
                throw t05.a();
            }
        }

        @Override // defpackage.b05
        public int d() {
            return (int) (this.i - this.j);
        }

        @Override // defpackage.b05
        public boolean e() throws IOException {
            return this.i == this.h;
        }

        @Override // defpackage.b05
        public void i(int i2) {
            this.m = i2;
            L();
        }

        @Override // defpackage.b05
        public int j(int i2) throws t05 {
            if (i2 >= 0) {
                int d = d() + i2;
                int i3 = this.m;
                if (d <= i3) {
                    this.m = d;
                    L();
                    return i3;
                }
                throw t05.h();
            }
            throw t05.f();
        }

        @Override // defpackage.b05
        public boolean k() throws IOException {
            return J() != 0;
        }

        @Override // defpackage.b05
        public a05 l() throws IOException {
            int I = I();
            if (I > 0 && I <= M()) {
                byte[] bArr = new byte[I];
                long j2 = (long) I;
                i25.f.c(this.i, bArr, 0, j2);
                this.i += j2;
                a05 a05 = a05.g;
                return new a05.f(bArr);
            } else if (I == 0) {
                return a05.g;
            } else {
                if (I < 0) {
                    throw t05.f();
                }
                throw t05.h();
            }
        }

        @Override // defpackage.b05
        public double m() throws IOException {
            return Double.longBitsToDouble(H());
        }

        @Override // defpackage.b05
        public int n() throws IOException {
            return I();
        }

        @Override // defpackage.b05
        public int o() throws IOException {
            return G();
        }

        @Override // defpackage.b05
        public long p() throws IOException {
            return H();
        }

        @Override // defpackage.b05
        public float q() throws IOException {
            return Float.intBitsToFloat(G());
        }

        @Override // defpackage.b05
        public int r() throws IOException {
            return I();
        }

        @Override // defpackage.b05
        public long s() throws IOException {
            return J();
        }

        @Override // defpackage.b05
        public int u() throws IOException {
            return G();
        }

        @Override // defpackage.b05
        public long v() throws IOException {
            return H();
        }

        @Override // defpackage.b05
        public int w() throws IOException {
            return b05.b(I());
        }

        @Override // defpackage.b05
        public long x() throws IOException {
            return b05.c(J());
        }

        @Override // defpackage.b05
        public String y() throws IOException {
            int I = I();
            if (I > 0 && I <= M()) {
                byte[] bArr = new byte[I];
                long j2 = (long) I;
                i25.f.c(this.i, bArr, 0, j2);
                String str = new String(bArr, s05.f3160a);
                this.i += j2;
                return str;
            } else if (I == 0) {
                return "";
            } else {
                if (I < 0) {
                    throw t05.f();
                }
                throw t05.h();
            }
        }

        @Override // defpackage.b05
        public String z() throws IOException {
            String str;
            int I = I();
            if (I > 0 && I <= M()) {
                int E = E(this.i);
                ByteBuffer byteBuffer = this.e;
                j25.a aVar = j25.f1865a;
                Objects.requireNonNull(aVar);
                if (byteBuffer.hasArray()) {
                    str = aVar.a(byteBuffer.array(), byteBuffer.arrayOffset() + E, I);
                } else if (byteBuffer.isDirect()) {
                    str = aVar.c(byteBuffer, E, I);
                } else {
                    str = aVar.b(byteBuffer, E, I);
                }
                this.i += (long) I;
                return str;
            } else if (I == 0) {
                return "";
            } else {
                if (I <= 0) {
                    throw t05.f();
                }
                throw t05.h();
            }
        }
    }

    public b05(a aVar) {
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static b05 f(InputStream inputStream) {
        if (inputStream != null) {
            return new c(inputStream, 4096, null);
        }
        byte[] bArr = s05.b;
        return h(bArr, 0, bArr.length, false);
    }

    public static b05 g(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return h(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), z);
        } else if (byteBuffer.isDirect() && i25.g) {
            return new d(byteBuffer, z, null);
        } else {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            return h(bArr, 0, remaining, true);
        }
    }

    public static b05 h(byte[] bArr, int i, int i2, boolean z) {
        b bVar = new b(bArr, i, i2, z, null);
        try {
            bVar.j(i2);
            return bVar;
        } catch (t05 e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int t(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i2 |= (read & 127) << i3;
                if ((read & 128) == 0) {
                    return i2;
                }
                i3 += 7;
            } else {
                throw t05.h();
            }
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw t05.h();
            } else if ((read2 & 128) == 0) {
                return i2;
            } else {
                i3 += 7;
            }
        }
        throw t05.e();
    }

    public abstract int A() throws IOException;

    public abstract int B() throws IOException;

    public abstract long C() throws IOException;

    public abstract boolean D(int i) throws IOException;

    public abstract void a(int i) throws t05;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void i(int i);

    public abstract int j(int i) throws t05;

    public abstract boolean k() throws IOException;

    public abstract a05 l() throws IOException;

    public abstract double m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract float q() throws IOException;

    public abstract int r() throws IOException;

    public abstract long s() throws IOException;

    public abstract int u() throws IOException;

    public abstract long v() throws IOException;

    public abstract int w() throws IOException;

    public abstract long x() throws IOException;

    public abstract String y() throws IOException;

    public abstract String z() throws IOException;
}
