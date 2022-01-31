package defpackage;

import com.google.firebase.perf.util.Constants;
import java.io.IOException;

/* renamed from: k93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class k93 extends n93 {
    public final byte[] d;
    public final int e;
    public int f;

    public k93(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) >= 0) {
            this.d = bArr;
            this.f = 0;
            this.e = i2;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
    }

    @Override // defpackage.n93
    public final void A(long j) throws IOException {
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
            throw new l93(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
        }
    }

    @Override // defpackage.y83
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.d, this.f, i2);
            this.f += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new l93(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e2);
        }
    }

    @Override // defpackage.n93
    public final void k(int i, int i2) throws IOException {
        x((i << 3) | i2);
    }

    @Override // defpackage.n93
    public final void l(int i, int i2) throws IOException {
        x(i << 3);
        if (i2 >= 0) {
            x(i2);
        } else {
            z((long) i2);
        }
    }

    @Override // defpackage.n93
    public final void m(int i, int i2) throws IOException {
        x(i << 3);
        x(i2);
    }

    @Override // defpackage.n93
    public final void n(int i, int i2) throws IOException {
        x((i << 3) | 5);
        y(i2);
    }

    @Override // defpackage.n93
    public final void o(int i, long j) throws IOException {
        x(i << 3);
        z(j);
    }

    @Override // defpackage.n93
    public final int p() {
        return this.e - this.f;
    }

    @Override // defpackage.n93
    public final void q(int i, long j) throws IOException {
        x((i << 3) | 1);
        A(j);
    }

    @Override // defpackage.n93
    public final void r(int i, boolean z) throws IOException {
        x(i << 3);
        v(z ? (byte) 1 : 0);
    }

    @Override // defpackage.n93
    public final void s(int i, String str) throws IOException {
        x((i << 3) | 2);
        int i2 = this.f;
        try {
            int b = n93.b(str.length() * 3);
            int b2 = n93.b(str.length());
            if (b2 == b) {
                int i3 = i2 + b2;
                this.f = i3;
                int c = qn2.c(str, this.d, i3, this.e - i3);
                this.f = i2;
                x((c - i2) - b2);
                this.f = c;
                return;
            }
            x(qn2.b(str));
            byte[] bArr = this.d;
            int i4 = this.f;
            this.f = qn2.c(str, bArr, i4, this.e - i4);
        } catch (on2 e2) {
            this.f = i2;
            i(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new l93(e3);
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
        try {
            byte[] bArr = this.d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e2) {
            throw new l93(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
        }
    }

    @Override // defpackage.n93
    public final void w(int i) throws IOException {
        if (i >= 0) {
            x(i);
        } else {
            z((long) i);
        }
    }

    @Override // defpackage.n93
    public final void x(int i) throws IOException {
        if (n93.c && !u83.a()) {
            int i2 = this.e;
            int i3 = this.f;
            if (i2 - i3 >= 5) {
                if ((i & -128) == 0) {
                    byte[] bArr = this.d;
                    this.f = i3 + 1;
                    ln2.w(bArr, (long) i3, (byte) i);
                    return;
                }
                byte[] bArr2 = this.d;
                this.f = i3 + 1;
                ln2.w(bArr2, (long) i3, (byte) (i | 128));
                int i4 = i >>> 7;
                if ((i4 & -128) == 0) {
                    byte[] bArr3 = this.d;
                    int i5 = this.f;
                    this.f = i5 + 1;
                    ln2.w(bArr3, (long) i5, (byte) i4);
                    return;
                }
                byte[] bArr4 = this.d;
                int i6 = this.f;
                this.f = i6 + 1;
                ln2.w(bArr4, (long) i6, (byte) (i4 | 128));
                int i7 = i4 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.d;
                    int i8 = this.f;
                    this.f = i8 + 1;
                    ln2.w(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.d;
                int i9 = this.f;
                this.f = i9 + 1;
                ln2.w(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.d;
                    int i11 = this.f;
                    this.f = i11 + 1;
                    ln2.w(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.d;
                int i12 = this.f;
                this.f = i12 + 1;
                ln2.w(bArr8, (long) i12, (byte) (i10 | 128));
                byte[] bArr9 = this.d;
                int i13 = this.f;
                this.f = i13 + 1;
                ln2.w(bArr9, (long) i13, (byte) (i10 >>> 7));
                return;
            }
        }
        while ((i & -128) != 0) {
            byte[] bArr10 = this.d;
            int i14 = this.f;
            this.f = i14 + 1;
            bArr10[i14] = (byte) ((i & 127) | 128);
            i >>>= 7;
        }
        try {
            byte[] bArr11 = this.d;
            int i15 = this.f;
            this.f = i15 + 1;
            bArr11[i15] = (byte) i;
        } catch (IndexOutOfBoundsException e2) {
            throw new l93(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
        }
    }

    @Override // defpackage.n93
    public final void y(int i) throws IOException {
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
            throw new l93(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
        }
    }

    @Override // defpackage.n93
    public final void z(long j) throws IOException {
        if (!n93.c || this.e - this.f < 10) {
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
                throw new l93(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        } else {
            while ((j & -128) != 0) {
                byte[] bArr3 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                ln2.w(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.d;
            int i4 = this.f;
            this.f = i4 + 1;
            ln2.w(bArr4, (long) i4, (byte) ((int) j));
        }
    }
}
