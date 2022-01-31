package defpackage;

import java.util.Map;

/* renamed from: v45  reason: default package */
/* compiled from: DataMatrixWriter */
public final class v45 implements i35 {
    @Override // defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) {
        t25 t25;
        int i3;
        int i4;
        f45 f45;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (o25 != o25.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(o25)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        } else {
            m55 m55 = m55.FORCE_NONE;
            t25 t252 = null;
            if (map != null) {
                m55 m552 = (m55) map.get(u25.DATA_MATRIX_SHAPE);
                if (m552 != null) {
                    m55 = m552;
                }
                t25 t253 = (t25) map.get(u25.MIN_SIZE);
                if (t253 == null) {
                    t253 = null;
                }
                t25 = (t25) map.get(u25.MAX_SIZE);
                if (t25 == null) {
                    t25 = null;
                }
                t252 = t253;
            } else {
                t25 = null;
            }
            i55[] i55Arr = {new c55(), new e55(), new n55(), new o55(), new h55(), new d55()};
            j55 j55 = new j55(str);
            j55.b = m55;
            j55.c = t252;
            j55.d = t25;
            if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
                j55.e.append((char) 236);
                j55.i = 2;
                j55.f += 7;
            } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
                j55.e.append((char) 237);
                j55.i = 2;
                j55.f += 7;
            }
            int i5 = 0;
            while (j55.d()) {
                i55Arr[i5].a(j55);
                int i6 = j55.g;
                if (i6 >= 0) {
                    j55.g = -1;
                    i5 = i6;
                }
            }
            int a2 = j55.a();
            j55.e();
            int i7 = j55.h.b;
            if (!(a2 >= i7 || i5 == 0 || i5 == 5 || i5 == 4)) {
                j55.e.append((char) 254);
            }
            StringBuilder sb = j55.e;
            if (sb.length() < i7) {
                sb.append((char) 129);
            }
            while (sb.length() < i7) {
                int length = (((sb.length() + 1) * 149) % 253) + 1 + 129;
                if (length > 254) {
                    length -= 254;
                }
                sb.append((char) length);
            }
            String sb2 = j55.e.toString();
            l55 i8 = l55.i(sb2.length(), m55, t252, t25, true);
            int[] iArr = k55.f2026a;
            int length2 = sb2.length();
            int i9 = i8.b;
            if (length2 == i9) {
                StringBuilder sb3 = new StringBuilder(i9 + i8.c);
                sb3.append(sb2);
                int c = i8.c();
                if (c == 1) {
                    sb3.append(k55.a(sb2, i8.c));
                } else {
                    sb3.setLength(sb3.capacity());
                    int[] iArr2 = new int[c];
                    int[] iArr3 = new int[c];
                    int[] iArr4 = new int[c];
                    int i10 = 0;
                    while (i10 < c) {
                        int i11 = i10 + 1;
                        iArr2[i10] = i8.a(i11);
                        iArr3[i10] = i8.h;
                        iArr4[i10] = 0;
                        if (i10 > 0) {
                            iArr4[i10] = iArr4[i10 - 1] + iArr2[i10];
                        }
                        i10 = i11;
                    }
                    for (int i12 = 0; i12 < c; i12++) {
                        StringBuilder sb4 = new StringBuilder(iArr2[i12]);
                        for (int i13 = i12; i13 < i8.b; i13 += c) {
                            sb4.append(sb2.charAt(i13));
                        }
                        String a3 = k55.a(sb4.toString(), iArr3[i12]);
                        int i14 = i12;
                        int i15 = 0;
                        while (i14 < iArr3[i12] * c) {
                            sb3.setCharAt(i8.b + i14, a3.charAt(i15));
                            i14 += c;
                            i15++;
                        }
                    }
                }
                g55 g55 = new g55(sb3.toString(), i8.e(), i8.d());
                int i16 = 4;
                int i17 = 0;
                int i18 = 0;
                while (true) {
                    int i19 = g55.b;
                    if (i16 == i19 && i17 == 0) {
                        g55.b(i19 - 1, 0, i18, 1);
                        g55.b(g55.b - 1, 1, i18, 2);
                        g55.b(g55.b - 1, 2, i18, 3);
                        g55.b(0, g55.c - 2, i18, 4);
                        g55.b(0, g55.c - 1, i18, 5);
                        g55.b(1, g55.c - 1, i18, 6);
                        g55.b(2, g55.c - 1, i18, 7);
                        g55.b(3, g55.c - 1, i18, 8);
                        i18++;
                    }
                    int i20 = g55.b;
                    if (i16 == i20 - 2 && i17 == 0 && g55.c % 4 != 0) {
                        g55.b(i20 - 3, 0, i18, 1);
                        g55.b(g55.b - 2, 0, i18, 2);
                        g55.b(g55.b - 1, 0, i18, 3);
                        g55.b(0, g55.c - 4, i18, 4);
                        g55.b(0, g55.c - 3, i18, 5);
                        g55.b(0, g55.c - 2, i18, 6);
                        g55.b(0, g55.c - 1, i18, 7);
                        g55.b(1, g55.c - 1, i18, 8);
                        i18++;
                    }
                    int i21 = g55.b;
                    if (i16 == i21 - 2 && i17 == 0 && g55.c % 8 == 4) {
                        g55.b(i21 - 3, 0, i18, 1);
                        g55.b(g55.b - 2, 0, i18, 2);
                        g55.b(g55.b - 1, 0, i18, 3);
                        g55.b(0, g55.c - 2, i18, 4);
                        g55.b(0, g55.c - 1, i18, 5);
                        g55.b(1, g55.c - 1, i18, 6);
                        g55.b(2, g55.c - 1, i18, 7);
                        g55.b(3, g55.c - 1, i18, 8);
                        i18++;
                    }
                    int i22 = g55.b;
                    if (i16 == i22 + 4 && i17 == 2 && g55.c % 8 == 0) {
                        g55.b(i22 - 1, 0, i18, 1);
                        g55.b(g55.b - 1, g55.c - 1, i18, 2);
                        g55.b(0, g55.c - 3, i18, 3);
                        g55.b(0, g55.c - 2, i18, 4);
                        g55.b(0, g55.c - 1, i18, 5);
                        g55.b(1, g55.c - 3, i18, 6);
                        g55.b(1, g55.c - 2, i18, 7);
                        g55.b(1, g55.c - 1, i18, 8);
                        i18++;
                    }
                    do {
                        if (i16 < g55.b && i17 >= 0 && !g55.a(i17, i16)) {
                            g55.d(i16, i17, i18);
                            i18++;
                        }
                        i16 -= 2;
                        i17 += 2;
                        if (i16 < 0) {
                            break;
                        }
                    } while (i17 < g55.c);
                    int i23 = i16 + 1;
                    int i24 = i17 + 3;
                    do {
                        if (i23 >= 0 && i24 < g55.c && !g55.a(i24, i23)) {
                            g55.d(i23, i24, i18);
                            i18++;
                        }
                        i23 += 2;
                        i24 -= 2;
                        i3 = g55.b;
                        if (i23 >= i3) {
                            break;
                        }
                    } while (i24 >= 0);
                    i16 = i23 + 3;
                    i17 = i24 + 1;
                    if (i16 >= i3 && i17 >= (i4 = g55.c)) {
                        break;
                    }
                }
                if (!g55.a(i4 - 1, i3 - 1)) {
                    g55.c(g55.c - 1, g55.b - 1, true);
                    g55.c(g55.c - 2, g55.b - 2, true);
                }
                int e = i8.e();
                int d = i8.d();
                o95 o95 = new o95(i8.g(), i8.f());
                int i25 = 0;
                for (int i26 = 0; i26 < d; i26++) {
                    if (i26 % i8.e == 0) {
                        int i27 = 0;
                        for (int i28 = 0; i28 < i8.g(); i28++) {
                            o95.c(i27, i25, i28 % 2 == 0);
                            i27++;
                        }
                        i25++;
                    }
                    int i29 = 0;
                    for (int i30 = 0; i30 < e; i30++) {
                        if (i30 % i8.d == 0) {
                            o95.c(i29, i25, true);
                            i29++;
                        }
                        o95.c(i29, i25, g55.d[(g55.c * i26) + i30] == 1);
                        i29++;
                        int i31 = i8.d;
                        if (i30 % i31 == i31 - 1) {
                            o95.c(i29, i25, i26 % 2 == 0);
                            i29++;
                        }
                    }
                    i25++;
                    int i32 = i8.e;
                    if (i26 % i32 == i32 - 1) {
                        int i33 = 0;
                        for (int i34 = 0; i34 < i8.g(); i34++) {
                            o95.c(i33, i25, true);
                            i33++;
                        }
                        i25++;
                    }
                }
                int i35 = o95.b;
                int i36 = o95.c;
                int max = Math.max(i, i35);
                int max2 = Math.max(i2, i36);
                int min = Math.min(max / i35, max2 / i36);
                int i37 = (max - (i35 * min)) / 2;
                int i38 = (max2 - (i36 * min)) / 2;
                if (i2 < i36 || i < i35) {
                    f45 = new f45(i35, i36);
                    i37 = 0;
                    i38 = 0;
                } else {
                    f45 = new f45(i, i2);
                }
                int length3 = f45.i.length;
                for (int i39 = 0; i39 < length3; i39++) {
                    f45.i[i39] = 0;
                }
                int i40 = 0;
                while (i40 < i36) {
                    int i41 = i37;
                    int i42 = 0;
                    while (i42 < i35) {
                        if (o95.a(i42, i40) == 1) {
                            f45.g(i41, i38, min, min);
                        }
                        i42++;
                        i41 += min;
                    }
                    i40++;
                    i38 += min;
                }
                return f45;
            }
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
    }
}
