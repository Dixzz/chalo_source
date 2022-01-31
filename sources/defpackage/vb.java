package defpackage;

import defpackage.ub;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: vb  reason: default package */
/* compiled from: CodedInputStream */
public abstract class vb {

    /* renamed from: a  reason: collision with root package name */
    public int f3626a;
    public int b = 100;
    public int c = Integer.MAX_VALUE;
    public wb d;

    /* renamed from: vb$b */
    /* compiled from: CodedInputStream */
    public static final class b extends vb {
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

        @Override // defpackage.vb
        public boolean A(int i2) throws IOException {
            int x;
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
                    throw nc.d();
                }
                while (i4 < 10) {
                    if (B() < 0) {
                        i4++;
                    }
                }
                throw nc.d();
                return true;
            } else if (i3 == 1) {
                I(8);
                return true;
            } else if (i3 == 2) {
                I(E());
                return true;
            } else if (i3 == 3) {
                do {
                    x = x();
                    if (x == 0) {
                        break;
                    }
                } while (A(x));
                a(((i2 >>> 3) << 3) | 4);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    I(4);
                    return true;
                }
                throw nc.c();
            }
        }

        public byte B() throws IOException {
            int i2 = this.i;
            if (i2 != this.g) {
                byte[] bArr = this.e;
                this.i = i2 + 1;
                return bArr[i2];
            }
            throw nc.g();
        }

        public int C() throws IOException {
            int i2 = this.i;
            if (this.g - i2 >= 4) {
                byte[] bArr = this.e;
                this.i = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw nc.g();
        }

        public long D() throws IOException {
            int i2 = this.i;
            if (this.g - i2 >= 8) {
                byte[] bArr = this.e;
                this.i = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw nc.g();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int E() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 115
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.b.E():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long F() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 192
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.b.F():long");
        }

        public long G() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte B = B();
                j2 |= ((long) (B & Byte.MAX_VALUE)) << i2;
                if ((B & 128) == 0) {
                    return j2;
                }
            }
            throw nc.d();
        }

        public final void H() {
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

        public void I(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.g;
                int i4 = this.i;
                if (i2 <= i3 - i4) {
                    this.i = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw nc.e();
            }
            throw nc.g();
        }

        @Override // defpackage.vb
        public void a(int i2) throws nc {
            if (this.k != i2) {
                throw nc.a();
            }
        }

        @Override // defpackage.vb
        public int d() {
            return this.i - this.j;
        }

        @Override // defpackage.vb
        public boolean e() throws IOException {
            return this.i == this.g;
        }

        @Override // defpackage.vb
        public void g(int i2) {
            this.l = i2;
            H();
        }

        @Override // defpackage.vb
        public int h(int i2) throws nc {
            if (i2 >= 0) {
                int d = d() + i2;
                int i3 = this.l;
                if (d <= i3) {
                    this.l = d;
                    H();
                    return i3;
                }
                throw nc.g();
            }
            throw nc.e();
        }

        @Override // defpackage.vb
        public boolean i() throws IOException {
            return F() != 0;
        }

        @Override // defpackage.vb
        public ub j() throws IOException {
            byte[] bArr;
            int E = E();
            if (E > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (E <= i2 - i3) {
                    ub e2 = ub.e(this.e, i3, E);
                    this.i += E;
                    return e2;
                }
            }
            if (E == 0) {
                return ub.g;
            }
            if (E > 0) {
                int i4 = this.g;
                int i5 = this.i;
                if (E <= i4 - i5) {
                    int i6 = E + i5;
                    this.i = i6;
                    bArr = Arrays.copyOfRange(this.e, i5, i6);
                    ub ubVar = ub.g;
                    return new ub.e(bArr);
                }
            }
            if (E > 0) {
                throw nc.g();
            } else if (E == 0) {
                bArr = mc.b;
                ub ubVar2 = ub.g;
                return new ub.e(bArr);
            } else {
                throw nc.e();
            }
        }

        @Override // defpackage.vb
        public double k() throws IOException {
            return Double.longBitsToDouble(D());
        }

        @Override // defpackage.vb
        public int l() throws IOException {
            return E();
        }

        @Override // defpackage.vb
        public int m() throws IOException {
            return C();
        }

        @Override // defpackage.vb
        public long n() throws IOException {
            return D();
        }

        @Override // defpackage.vb
        public float o() throws IOException {
            return Float.intBitsToFloat(C());
        }

        @Override // defpackage.vb
        public int p() throws IOException {
            return E();
        }

        @Override // defpackage.vb
        public long q() throws IOException {
            return F();
        }

        @Override // defpackage.vb
        public int r() throws IOException {
            return C();
        }

        @Override // defpackage.vb
        public long s() throws IOException {
            return D();
        }

        @Override // defpackage.vb
        public int t() throws IOException {
            return vb.b(E());
        }

        @Override // defpackage.vb
        public long u() throws IOException {
            return vb.c(F());
        }

        @Override // defpackage.vb
        public String v() throws IOException {
            int E = E();
            if (E > 0 && E <= this.g - this.i) {
                String str = new String(this.e, this.i, E, mc.f2352a);
                this.i += E;
                return str;
            } else if (E == 0) {
                return "";
            } else {
                if (E < 0) {
                    throw nc.e();
                }
                throw nc.g();
            }
        }

        @Override // defpackage.vb
        public String w() throws IOException {
            int E = E();
            if (E > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (E <= i2 - i3) {
                    String a2 = de.f823a.a(this.e, i3, E);
                    this.i += E;
                    return a2;
                }
            }
            if (E == 0) {
                return "";
            }
            if (E <= 0) {
                throw nc.e();
            }
            throw nc.g();
        }

        @Override // defpackage.vb
        public int x() throws IOException {
            if (e()) {
                this.k = 0;
                return 0;
            }
            int E = E();
            this.k = E;
            if ((E >>> 3) != 0) {
                return E;
            }
            throw new nc("Protocol message contained an invalid tag (zero).");
        }

        @Override // defpackage.vb
        public int y() throws IOException {
            return E();
        }

        @Override // defpackage.vb
        public long z() throws IOException {
            return F();
        }
    }

    /* renamed from: vb$c */
    /* compiled from: CodedInputStream */
    public static final class c extends vb {
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
            Charset charset = mc.f2352a;
            this.e = inputStream;
            this.f = new byte[i2];
            this.g = 0;
            this.i = 0;
            this.k = 0;
        }

        @Override // defpackage.vb
        public boolean A(int i2) throws IOException {
            int x;
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
                    throw nc.d();
                }
                while (i4 < 10) {
                    if (B() < 0) {
                        i4++;
                    }
                }
                throw nc.d();
                return true;
            } else if (i3 == 1) {
                M(8);
                return true;
            } else if (i3 == 2) {
                M(H());
                return true;
            } else if (i3 == 3) {
                do {
                    x = x();
                    if (x == 0) {
                        break;
                    }
                } while (A(x));
                a(((i2 >>> 3) << 3) | 4);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    M(4);
                    return true;
                }
                throw nc.c();
            }
        }

        public byte B() throws IOException {
            if (this.i == this.g) {
                L(1);
            }
            byte[] bArr = this.f;
            int i2 = this.i;
            this.i = i2 + 1;
            return bArr[i2];
        }

        public final byte[] C(int i2, boolean z) throws IOException {
            byte[] D = D(i2);
            if (D != null) {
                return z ? (byte[]) D.clone() : D;
            }
            int i3 = this.i;
            int i4 = this.g;
            int i5 = i4 - i3;
            this.k += i4;
            this.i = 0;
            this.g = 0;
            List<byte[]> E = E(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f, i3, bArr, 0, i5);
            Iterator it = ((ArrayList) E).iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        public final byte[] D(int i2) throws IOException {
            if (i2 == 0) {
                return mc.b;
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
                                throw nc.g();
                            }
                        }
                        return bArr;
                    }
                    M((i6 - i3) - i4);
                    throw nc.g();
                }
                throw new nc("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw nc.e();
        }

        public final List<byte[]> E(int i2) throws IOException {
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
                        throw nc.g();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int F() throws IOException {
            int i2 = this.i;
            if (this.g - i2 < 4) {
                L(4);
                i2 = this.i;
            }
            byte[] bArr = this.f;
            this.i = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long G() throws IOException {
            int i2 = this.i;
            if (this.g - i2 < 8) {
                L(8);
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
        public int H() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 115
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.c.H():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long I() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 192
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.c.I():long");
        }

        public long J() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte B = B();
                j2 |= ((long) (B & Byte.MAX_VALUE)) << i2;
                if ((B & 128) == 0) {
                    return j2;
                }
            }
            throw nc.d();
        }

        public final void K() {
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

        public final void L(int i2) throws IOException {
            if (N(i2)) {
                return;
            }
            if (i2 > (this.c - this.k) - this.i) {
                throw new nc("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw nc.g();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
            throw new java.lang.IllegalStateException(r8.e.getClass() + "#skip returned invalid result: " + r1 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void M(int r9) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 162
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.c.M(int):void");
        }

        public final boolean N(int i2) throws IOException {
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
                    K();
                    if (this.g >= i2) {
                        return true;
                    }
                    return N(i2);
                }
            } else {
                throw new IllegalStateException(hj1.J("refillBuffer() called when ", i2, " bytes were already available in buffer"));
            }
        }

        @Override // defpackage.vb
        public void a(int i2) throws nc {
            if (this.j != i2) {
                throw nc.a();
            }
        }

        @Override // defpackage.vb
        public int d() {
            return this.k + this.i;
        }

        @Override // defpackage.vb
        public boolean e() throws IOException {
            return this.i == this.g && !N(1);
        }

        @Override // defpackage.vb
        public void g(int i2) {
            this.l = i2;
            K();
        }

        @Override // defpackage.vb
        public int h(int i2) throws nc {
            if (i2 >= 0) {
                int i3 = this.k + this.i + i2;
                int i4 = this.l;
                if (i3 <= i4) {
                    this.l = i3;
                    K();
                    return i4;
                }
                throw nc.g();
            }
            throw nc.e();
        }

        @Override // defpackage.vb
        public boolean i() throws IOException {
            return I() != 0;
        }

        @Override // defpackage.vb
        public ub j() throws IOException {
            int H = H();
            int i2 = this.g;
            int i3 = this.i;
            if (H <= i2 - i3 && H > 0) {
                ub e2 = ub.e(this.f, i3, H);
                this.i += H;
                return e2;
            } else if (H == 0) {
                return ub.g;
            } else {
                byte[] D = D(H);
                if (D != null) {
                    ub ubVar = ub.g;
                    return ub.e(D, 0, D.length);
                }
                int i4 = this.i;
                int i5 = this.g;
                int i6 = i5 - i4;
                this.k += i5;
                this.i = 0;
                this.g = 0;
                List<byte[]> E = E(H - i6);
                byte[] bArr = new byte[H];
                System.arraycopy(this.f, i4, bArr, 0, i6);
                Iterator it = ((ArrayList) E).iterator();
                while (it.hasNext()) {
                    byte[] bArr2 = (byte[]) it.next();
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    i6 += bArr2.length;
                }
                ub ubVar2 = ub.g;
                return new ub.e(bArr);
            }
        }

        @Override // defpackage.vb
        public double k() throws IOException {
            return Double.longBitsToDouble(G());
        }

        @Override // defpackage.vb
        public int l() throws IOException {
            return H();
        }

        @Override // defpackage.vb
        public int m() throws IOException {
            return F();
        }

        @Override // defpackage.vb
        public long n() throws IOException {
            return G();
        }

        @Override // defpackage.vb
        public float o() throws IOException {
            return Float.intBitsToFloat(F());
        }

        @Override // defpackage.vb
        public int p() throws IOException {
            return H();
        }

        @Override // defpackage.vb
        public long q() throws IOException {
            return I();
        }

        @Override // defpackage.vb
        public int r() throws IOException {
            return F();
        }

        @Override // defpackage.vb
        public long s() throws IOException {
            return G();
        }

        @Override // defpackage.vb
        public int t() throws IOException {
            return vb.b(H());
        }

        @Override // defpackage.vb
        public long u() throws IOException {
            return vb.c(I());
        }

        @Override // defpackage.vb
        public String v() throws IOException {
            int H = H();
            if (H > 0 && H <= this.g - this.i) {
                String str = new String(this.f, this.i, H, mc.f2352a);
                this.i += H;
                return str;
            } else if (H == 0) {
                return "";
            } else {
                if (H > this.g) {
                    return new String(C(H, false), mc.f2352a);
                }
                L(H);
                String str2 = new String(this.f, this.i, H, mc.f2352a);
                this.i += H;
                return str2;
            }
        }

        @Override // defpackage.vb
        public String w() throws IOException {
            byte[] bArr;
            byte[] bArr2;
            int H = H();
            int i2 = this.i;
            int i3 = this.g;
            if (H <= i3 - i2 && H > 0) {
                bArr = this.f;
                this.i = i2 + H;
            } else if (H == 0) {
                return "";
            } else {
                if (H <= i3) {
                    L(H);
                    bArr2 = this.f;
                    this.i = H + 0;
                } else {
                    bArr2 = C(H, false);
                }
                bArr = bArr2;
                i2 = 0;
            }
            return de.f823a.a(bArr, i2, H);
        }

        @Override // defpackage.vb
        public int x() throws IOException {
            if (e()) {
                this.j = 0;
                return 0;
            }
            int H = H();
            this.j = H;
            if ((H >>> 3) != 0) {
                return H;
            }
            throw new nc("Protocol message contained an invalid tag (zero).");
        }

        @Override // defpackage.vb
        public int y() throws IOException {
            return H();
        }

        @Override // defpackage.vb
        public long z() throws IOException {
            return I();
        }
    }

    public vb(a aVar) {
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static vb f(byte[] bArr, int i, int i2, boolean z) {
        b bVar = new b(bArr, i, i2, z, null);
        try {
            bVar.h(i2);
            return bVar;
        } catch (nc e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract boolean A(int i) throws IOException;

    public abstract void a(int i) throws nc;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void g(int i);

    public abstract int h(int i) throws nc;

    public abstract boolean i() throws IOException;

    public abstract ub j() throws IOException;

    public abstract double k() throws IOException;

    public abstract int l() throws IOException;

    public abstract int m() throws IOException;

    public abstract long n() throws IOException;

    public abstract float o() throws IOException;

    public abstract int p() throws IOException;

    public abstract long q() throws IOException;

    public abstract int r() throws IOException;

    public abstract long s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract String v() throws IOException;

    public abstract String w() throws IOException;

    public abstract int x() throws IOException;

    public abstract int y() throws IOException;

    public abstract long z() throws IOException;
}
