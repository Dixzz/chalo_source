package defpackage;

import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: m93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class m93 extends n93 {
    public final byte[] d;
    public final int e;
    public int f;
    public int g;
    public final OutputStream h;

    public m93(OutputStream outputStream, int i) {
        super(null);
        if (i >= 0) {
            int max = Math.max(i, 20);
            this.d = new byte[max];
            this.e = max;
            this.h = outputStream;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    @Override // defpackage.n93
    public final void A(long j) throws IOException {
        D(8);
        I(j);
    }

    public final void D(int i) throws IOException {
        if (this.e - this.f < i) {
            E();
        }
    }

    public final void E() throws IOException {
        this.h.write(this.d, 0, this.f);
        this.f = 0;
    }

    public final void F(int i) {
        if (n93.c) {
            long j = (long) this.f;
            while ((i & -128) != 0) {
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                ln2.w(bArr, (long) i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            ln2.w(bArr2, (long) i3, (byte) i);
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

    public final void G(long j) {
        if (n93.c) {
            long j2 = (long) this.f;
            while ((j & -128) != 0) {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                ln2.w(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            ln2.w(bArr2, (long) i2, (byte) ((int) j));
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

    public final void H(int i) {
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

    public final void I(long j) {
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

    public final void J(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, 0, this.d, i4, i2);
            this.f += i2;
            this.g += i2;
            return;
        }
        System.arraycopy(bArr, 0, this.d, i4, i5);
        int i6 = i2 - i5;
        this.f = this.e;
        this.g += i5;
        E();
        if (i6 <= this.e) {
            System.arraycopy(bArr, i5, this.d, 0, i6);
            this.f = i6;
        } else {
            this.h.write(bArr, i5, i6);
        }
        this.g += i6;
    }

    @Override // defpackage.y83
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        J(bArr, 0, i2);
    }

    @Override // defpackage.n93
    public final void k(int i, int i2) throws IOException {
        x((i << 3) | i2);
    }

    @Override // defpackage.n93
    public final void l(int i, int i2) throws IOException {
        D(20);
        F(i << 3);
        if (i2 >= 0) {
            F(i2);
        } else {
            G((long) i2);
        }
    }

    @Override // defpackage.n93
    public final void m(int i, int i2) throws IOException {
        D(20);
        F(i << 3);
        F(i2);
    }

    @Override // defpackage.n93
    public final void n(int i, int i2) throws IOException {
        D(14);
        F((i << 3) | 5);
        H(i2);
    }

    @Override // defpackage.n93
    public final void o(int i, long j) throws IOException {
        D(20);
        F(i << 3);
        G(j);
    }

    @Override // defpackage.n93
    public final int p() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    @Override // defpackage.n93
    public final void q(int i, long j) throws IOException {
        D(18);
        F((i << 3) | 1);
        I(j);
    }

    @Override // defpackage.n93
    public final void r(int i, boolean z) throws IOException {
        D(11);
        F(i << 3);
        byte[] bArr = this.d;
        int i2 = this.f;
        this.f = i2 + 1;
        bArr[i2] = z ? (byte) 1 : 0;
        this.g++;
    }

    @Override // defpackage.n93
    public final void s(int i, String str) throws IOException {
        int i2;
        x((i << 3) | 2);
        try {
            int length = str.length() * 3;
            int b = n93.b(length);
            int i3 = b + length;
            int i4 = this.e;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int c = qn2.c(str, bArr, 0, length);
                x(c);
                J(bArr, 0, c);
                return;
            }
            if (i3 > i4 - this.f) {
                E();
            }
            int b2 = n93.b(str.length());
            int i5 = this.f;
            if (b2 == b) {
                int i6 = i5 + b2;
                try {
                    this.f = i6;
                    int c2 = qn2.c(str, this.d, i6, this.e - i6);
                    this.f = i5;
                    i2 = (c2 - i5) - b2;
                    F(i2);
                    this.f = c2;
                } catch (on2 e2) {
                    this.g -= this.f - i5;
                    this.f = i5;
                    throw e2;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    throw new l93(e3);
                }
            } else {
                i2 = qn2.b(str);
                F(i2);
                this.f = qn2.c(str, this.d, this.f, i2);
            }
            this.g += i2;
        } catch (on2 e4) {
            i(str, e4);
        }
    }

    @Override // defpackage.n93
    public final void t(int i, g93 g93) throws IOException {
        x((i << 3) | 2);
        x(g93.e());
        g93.s(this);
    }

    @Override // defpackage.n93
    public final void u(int i, bm2 bm2, mm2 mm2) throws IOException {
        x((i << 3) | 2);
        s83 s83 = (s83) bm2;
        int b = s83.b();
        if (b == -1) {
            b = mm2.f(s83);
            s83.c(b);
        }
        x(b);
        mm2.i(bm2, this.f2524a);
    }

    @Override // defpackage.n93
    public final void v(byte b) throws IOException {
        if (this.f == this.e) {
            E();
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        bArr[i] = b;
        this.g++;
    }

    @Override // defpackage.n93
    public final void w(int i) throws IOException {
        if (i >= 0) {
            D(5);
            F(i);
            return;
        }
        z((long) i);
    }

    @Override // defpackage.n93
    public final void x(int i) throws IOException {
        D(5);
        F(i);
    }

    @Override // defpackage.n93
    public final void y(int i) throws IOException {
        D(4);
        H(i);
    }

    @Override // defpackage.n93
    public final void z(long j) throws IOException {
        D(10);
        G(j);
    }
}
