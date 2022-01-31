package defpackage;

import java.util.Arrays;
import java.util.Map;

/* renamed from: x55  reason: default package */
/* compiled from: Code39Reader */
public final class x55 extends k65 {
    public static final int[] d = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3889a;
    public final StringBuilder b = new StringBuilder(20);
    public final int[] c = new int[9];

    public x55(boolean z) {
        this.f3889a = z;
    }

    public static int i(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    @Override // defpackage.k65
    public e35 d(int i, e45 e45, Map<s25, ?> map) throws a35, r25, v25 {
        char c2;
        int[] iArr = this.c;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.b;
        sb.setLength(0);
        int i2 = e45.g;
        int f = e45.f(0);
        int length = iArr.length;
        int i3 = f;
        boolean z = false;
        int i4 = 0;
        while (f < i2) {
            if (e45.e(f) != z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (i(iArr) != 148 || !e45.i(Math.max(0, i3 - ((f - i3) / 2)), i3, false)) {
                    i3 += iArr[0] + iArr[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
                    i4 = i5;
                } else {
                    int[] iArr2 = {i3, f};
                    int f2 = e45.f(iArr2[1]);
                    int i6 = e45.g;
                    while (true) {
                        k65.g(e45, f2, iArr);
                        int i7 = i(iArr);
                        if (i7 >= 0) {
                            int i8 = 0;
                            while (true) {
                                int[] iArr3 = d;
                                if (i8 < iArr3.length) {
                                    if (iArr3[i8] == i7) {
                                        c2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i8);
                                        break;
                                    }
                                    i8++;
                                } else if (i7 == 148) {
                                    c2 = '*';
                                } else {
                                    throw a35.h;
                                }
                            }
                            sb.append(c2);
                            int i9 = f2;
                            for (int i10 : iArr) {
                                i9 += i10;
                            }
                            int f3 = e45.f(i9);
                            if (c2 == '*') {
                                sb.setLength(sb.length() - 1);
                                int i11 = 0;
                                for (int i12 : iArr) {
                                    i11 += i12;
                                }
                                int i13 = (f3 - f2) - i11;
                                if (f3 == i6 || (i13 << 1) >= i11) {
                                    if (this.f3889a) {
                                        int length2 = sb.length() - 1;
                                        int i14 = 0;
                                        for (int i15 = 0; i15 < length2; i15++) {
                                            i14 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.b.charAt(i15));
                                        }
                                        if (sb.charAt(length2) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i14 % 43)) {
                                            sb.setLength(length2);
                                        } else {
                                            throw r25.a();
                                        }
                                    }
                                    if (sb.length() != 0) {
                                        float f4 = (float) i;
                                        return new e35(sb.toString(), null, new g35[]{new g35(((float) (iArr2[1] + iArr2[0])) / 2.0f, f4), new g35((((float) i11) / 2.0f) + ((float) f2), f4)}, o25.CODE_39);
                                    }
                                    throw a35.h;
                                }
                                throw a35.h;
                            }
                            f2 = f3;
                        } else {
                            throw a35.h;
                        }
                    }
                }
                iArr[i4] = 1;
                z = !z;
            }
            f++;
        }
        throw a35.h;
    }
}
