package defpackage;

import java.util.Arrays;

/* renamed from: g55  reason: default package */
/* compiled from: DefaultPlacement */
public class g55 {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f1218a;
    public final int b;
    public final int c;
    public final byte[] d;

    public g55(CharSequence charSequence, int i, int i2) {
        this.f1218a = charSequence;
        this.c = i;
        this.b = i2;
        byte[] bArr = new byte[(i * i2)];
        this.d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public final boolean a(int i, int i2) {
        return this.d[(i2 * this.c) + i] >= 0;
    }

    public final void b(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.b;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.c;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        boolean z = true;
        if ((this.f1218a.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        c(i2, i, z);
    }

    public final void c(int i, int i2, boolean z) {
        this.d[(i2 * this.c) + i] = z ? (byte) 1 : 0;
    }

    public final void d(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        b(i4, i5, i3, 1);
        int i6 = i2 - 1;
        b(i4, i6, i3, 2);
        int i7 = i - 1;
        b(i7, i5, i3, 3);
        b(i7, i6, i3, 4);
        b(i7, i2, i3, 5);
        b(i, i5, i3, 6);
        b(i, i6, i3, 7);
        b(i, i2, i3, 8);
    }
}
