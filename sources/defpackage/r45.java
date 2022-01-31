package defpackage;

import java.util.Objects;

/* renamed from: r45  reason: default package */
/* compiled from: ReedSolomonDecoder */
public final class r45 {

    /* renamed from: a  reason: collision with root package name */
    public final p45 f3040a;

    public r45(p45 p45) {
        this.f3040a = p45;
    }

    public void a(int[] iArr, int i) throws t45 {
        int[] iArr2;
        q45 q45 = new q45(this.f3040a, iArr);
        int[] iArr3 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            p45 p45 = this.f3040a;
            int b = q45.b(p45.f2767a[p45.g + i2]);
            iArr3[(i - 1) - i2] = b;
            if (b != 0) {
                z = false;
            }
        }
        if (!z) {
            q45 q452 = new q45(this.f3040a, iArr3);
            q45 a2 = this.f3040a.a(i, 1);
            if (a2.d() < q452.d()) {
                a2 = q452;
                q452 = a2;
            }
            p45 p452 = this.f3040a;
            q45 q453 = p452.c;
            q45 q454 = p452.d;
            q45 q455 = q453;
            while (q452.d() >= i / 2) {
                if (!q452.e()) {
                    q45 q456 = this.f3040a.c;
                    int b2 = this.f3040a.b(q452.c(q452.d()));
                    while (a2.d() >= q452.d() && !a2.e()) {
                        int d = a2.d() - q452.d();
                        int c = this.f3040a.c(a2.c(a2.d()), b2);
                        q456 = q456.a(this.f3040a.a(d, c));
                        a2 = a2.a(q452.h(d, c));
                    }
                    q45 a3 = q456.g(q454).a(q455);
                    if (a2.d() < q452.d()) {
                        a2 = q452;
                        q452 = a2;
                        q454 = a3;
                        q455 = q454;
                    } else {
                        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                    }
                } else {
                    throw new t45("r_{i-1} was zero");
                }
            }
            int c2 = q454.c(0);
            if (c2 != 0) {
                int b3 = this.f3040a.b(c2);
                q45[] q45Arr = {q454.f(b3), q452.f(b3)};
                q45 q457 = q45Arr[0];
                q45 q458 = q45Arr[1];
                int d2 = q457.d();
                if (d2 == 1) {
                    iArr2 = new int[]{q457.c(1)};
                } else {
                    int[] iArr4 = new int[d2];
                    int i3 = 0;
                    for (int i4 = 1; i4 < this.f3040a.e && i3 < d2; i4++) {
                        if (q457.b(i4) == 0) {
                            iArr4[i3] = this.f3040a.b(i4);
                            i3++;
                        }
                    }
                    if (i3 == d2) {
                        iArr2 = iArr4;
                    } else {
                        throw new t45("Error locator degree does not match number of roots");
                    }
                }
                int length = iArr2.length;
                int[] iArr5 = new int[length];
                for (int i5 = 0; i5 < length; i5++) {
                    int b4 = this.f3040a.b(iArr2[i5]);
                    int i6 = 1;
                    for (int i7 = 0; i7 < length; i7++) {
                        if (i5 != i7) {
                            int c3 = this.f3040a.c(iArr2[i7], b4);
                            i6 = this.f3040a.c(i6, (c3 & 1) == 0 ? c3 | 1 : c3 & -2);
                        }
                    }
                    iArr5[i5] = this.f3040a.c(q458.b(b4), this.f3040a.b(i6));
                    p45 p453 = this.f3040a;
                    if (p453.g != 0) {
                        iArr5[i5] = p453.c(iArr5[i5], b4);
                    }
                }
                for (int i8 = 0; i8 < iArr2.length; i8++) {
                    int length2 = iArr.length - 1;
                    p45 p454 = this.f3040a;
                    int i9 = iArr2[i8];
                    Objects.requireNonNull(p454);
                    if (i9 != 0) {
                        int i10 = length2 - p454.b[i9];
                        if (i10 >= 0) {
                            iArr[i10] = iArr[i10] ^ iArr5[i8];
                        } else {
                            throw new t45("Bad error location");
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                return;
            }
            throw new t45("sigmaTilde(0) was zero");
        }
    }
}
