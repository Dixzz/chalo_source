package defpackage;

import java.util.Arrays;
import java.util.Map;

/* renamed from: t55  reason: default package */
/* compiled from: CodaBarReader */
public final class t55 extends k65 {
    public static final char[] d = "0123456789-$:/.+ABCD".toCharArray();
    public static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    public static final char[] f = {'A', 'B', 'C', 'D'};

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f3311a = new StringBuilder(20);
    public int[] b = new int[80];
    public int c = 0;

    public static boolean i(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.k65
    public e35 d(int i, e45 e45, Map<s25, ?> map) throws a35 {
        Arrays.fill(this.b, 0);
        this.c = 0;
        int g = e45.g(0);
        int i2 = e45.g;
        if (g < i2) {
            int i3 = 0;
            boolean z = true;
            while (g < i2) {
                if (e45.e(g) != z) {
                    i3++;
                } else {
                    j(i3);
                    z = !z;
                    i3 = 1;
                }
                g++;
            }
            j(i3);
            int i4 = 1;
            while (i4 < this.c) {
                int k = k(i4);
                if (k != -1 && i(f, d[k])) {
                    int i5 = 0;
                    for (int i6 = i4; i6 < i4 + 7; i6++) {
                        i5 += this.b[i6];
                    }
                    if (i4 == 1 || this.b[i4 - 1] >= i5 / 2) {
                        this.f3311a.setLength(0);
                        int i7 = i4;
                        while (true) {
                            int k2 = k(i7);
                            if (k2 != -1) {
                                this.f3311a.append((char) k2);
                                i7 += 8;
                                if ((this.f3311a.length() <= 1 || !i(f, d[k2])) && i7 < this.c) {
                                }
                            } else {
                                throw a35.h;
                            }
                        }
                        int i8 = i7 - 1;
                        int i9 = this.b[i8];
                        int i10 = 0;
                        for (int i11 = -8; i11 < -1; i11++) {
                            i10 += this.b[i7 + i11];
                        }
                        if (i7 >= this.c || i9 >= i10 / 2) {
                            int[] iArr = {0, 0, 0, 0};
                            int[] iArr2 = {0, 0, 0, 0};
                            int length = this.f3311a.length() - 1;
                            int i12 = i4;
                            int i13 = 0;
                            while (true) {
                                int i14 = e[this.f3311a.charAt(i13)];
                                for (int i15 = 6; i15 >= 0; i15--) {
                                    int i16 = (i15 & 1) + ((i14 & 1) << 1);
                                    iArr[i16] = iArr[i16] + this.b[i12 + i15];
                                    iArr2[i16] = iArr2[i16] + 1;
                                    i14 >>= 1;
                                }
                                if (i13 >= length) {
                                    break;
                                }
                                i12 += 8;
                                i13++;
                            }
                            float[] fArr = new float[4];
                            float[] fArr2 = new float[4];
                            int i17 = 0;
                            for (int i18 = 2; i17 < i18; i18 = 2) {
                                fArr2[i17] = 0.0f;
                                int i19 = i17 + 2;
                                fArr2[i19] = ((((float) iArr[i19]) / ((float) iArr2[i19])) + (((float) iArr[i17]) / ((float) iArr2[i17]))) / 2.0f;
                                fArr[i17] = fArr2[i19];
                                fArr[i19] = ((((float) iArr[i19]) * 2.0f) + 1.5f) / ((float) iArr2[i19]);
                                i17++;
                            }
                            int i20 = i4;
                            int i21 = 0;
                            loop8:
                            while (true) {
                                int i22 = e[this.f3311a.charAt(i21)];
                                for (int i23 = 6; i23 >= 0; i23--) {
                                    int i24 = (i23 & 1) + ((i22 & 1) << 1);
                                    float f2 = (float) this.b[i20 + i23];
                                    if (f2 >= fArr2[i24] && f2 <= fArr[i24]) {
                                        i22 >>= 1;
                                    }
                                }
                                if (i21 < length) {
                                    i20 += 8;
                                    i21++;
                                } else {
                                    for (int i25 = 0; i25 < this.f3311a.length(); i25++) {
                                        StringBuilder sb = this.f3311a;
                                        sb.setCharAt(i25, d[sb.charAt(i25)]);
                                    }
                                    char charAt = this.f3311a.charAt(0);
                                    char[] cArr = f;
                                    if (i(cArr, charAt)) {
                                        StringBuilder sb2 = this.f3311a;
                                        if (!i(cArr, sb2.charAt(sb2.length() - 1))) {
                                            throw a35.h;
                                        } else if (this.f3311a.length() > 3) {
                                            if (map == null || !map.containsKey(s25.RETURN_CODABAR_START_END)) {
                                                StringBuilder sb3 = this.f3311a;
                                                sb3.deleteCharAt(sb3.length() - 1);
                                                this.f3311a.deleteCharAt(0);
                                            }
                                            int i26 = 0;
                                            for (int i27 = 0; i27 < i4; i27++) {
                                                i26 += this.b[i27];
                                            }
                                            float f3 = (float) i26;
                                            while (i4 < i8) {
                                                i26 += this.b[i4];
                                                i4++;
                                            }
                                            float f4 = (float) i;
                                            return new e35(this.f3311a.toString(), null, new g35[]{new g35(f3, f4), new g35((float) i26, f4)}, o25.CODABAR);
                                        } else {
                                            throw a35.h;
                                        }
                                    } else {
                                        throw a35.h;
                                    }
                                }
                            }
                            throw a35.h;
                        }
                        throw a35.h;
                    }
                }
                i4 += 2;
            }
            throw a35.h;
        }
        throw a35.h;
    }

    public final void j(int i) {
        int[] iArr = this.b;
        int i2 = this.c;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(i3 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.b = iArr2;
        }
    }

    public final int k(int i) {
        int i2 = i + 7;
        if (i2 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = e;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }
}
