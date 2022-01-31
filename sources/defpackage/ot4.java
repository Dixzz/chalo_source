package defpackage;

import java.util.Arrays;

/* renamed from: ot4  reason: default package */
public final class ot4 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f2728a = new byte[4096];
    public int b;
    public long c;
    public long d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public String i;

    public ot4() {
        c();
    }

    public final int a(byte[] bArr, int i2, int i3) {
        int d2 = d(30, bArr, i2, i3);
        if (d2 == -1) {
            return -1;
        }
        if (this.c == -1) {
            long b2 = mt4.b(this.f2728a, 0);
            this.c = b2;
            if (b2 == 67324752) {
                this.h = false;
                this.d = mt4.b(this.f2728a, 18);
                this.g = mt4.c(this.f2728a, 8);
                this.e = mt4.c(this.f2728a, 26);
                int c2 = this.e + 30 + mt4.c(this.f2728a, 28);
                this.f = c2;
                int length = this.f2728a.length;
                if (length < c2) {
                    do {
                        length += length;
                    } while (length < c2);
                    this.f2728a = Arrays.copyOf(this.f2728a, length);
                }
            } else {
                this.h = true;
            }
        }
        int d3 = d(this.f, bArr, i2 + d2, i3 - d2);
        if (d3 == -1) {
            return -1;
        }
        int i4 = d2 + d3;
        if (!this.h && this.i == null) {
            this.i = new String(this.f2728a, 30, this.e);
        }
        return i4;
    }

    public final gu4 b() {
        int i2 = this.b;
        int i3 = this.f;
        if (i2 < i3) {
            return new gu4(this.i, this.d, this.g, true, this.h, Arrays.copyOf(this.f2728a, i2));
        }
        gu4 gu4 = new gu4(this.i, this.d, this.g, false, this.h, Arrays.copyOf(this.f2728a, i3));
        c();
        return gu4;
    }

    public final void c() {
        this.b = 0;
        this.e = -1;
        this.c = -1;
        this.h = false;
        this.f = 30;
        this.d = -1;
        this.g = -1;
        this.i = null;
    }

    public final int d(int i2, byte[] bArr, int i3, int i4) {
        int i5 = this.b;
        if (i5 >= i2) {
            return 0;
        }
        int min = Math.min(i4, i2 - i5);
        System.arraycopy(bArr, i3, this.f2728a, this.b, min);
        int i6 = this.b + min;
        this.b = i6;
        if (i6 < i2) {
            return -1;
        }
        return min;
    }
}
