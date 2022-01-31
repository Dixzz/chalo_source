package defpackage;

import defpackage.l95;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: v85  reason: default package */
/* compiled from: QRCodeReader */
public class v85 implements c35 {
    public static final g35[] b = new g35[0];

    /* renamed from: a  reason: collision with root package name */
    public final b95 f3618a = new b95();

    @Override // defpackage.c35
    public final e35 a(q25 q25, Map<s25, ?> map) throws a35, r25, v25 {
        g35[] g35Arr;
        i45 i45;
        h35 h35;
        int i;
        h95 h95;
        float f;
        float f2;
        float f3;
        int i2;
        int i3;
        if (map == null || !map.containsKey(s25.PURE_BARCODE)) {
            j95 j95 = new j95(q25.a());
            if (map == null) {
                h35 = null;
            } else {
                h35 = (h35) map.get(s25.NEED_RESULT_POINT_CALLBACK);
            }
            j95.b = h35;
            l95 l95 = new l95(j95.f1895a, h35);
            boolean z = map != null && map.containsKey(s25.TRY_HARDER);
            f45 f45 = l95.f2192a;
            int i4 = f45.g;
            int i5 = f45.f;
            int i6 = (i4 * 3) / 388;
            if (i6 < 3 || z) {
                i6 = 3;
            }
            int[] iArr = new int[5];
            int i7 = i6 - 1;
            boolean z2 = false;
            while (true) {
                int i8 = 4;
                if (i7 >= i4 || z2) {
                    int size = l95.b.size();
                } else {
                    l95.b(iArr);
                    int i9 = 0;
                    int i10 = 0;
                    while (i9 < i5) {
                        if (l95.f2192a.b(i9, i7)) {
                            if ((i10 & 1) == 1) {
                                i10++;
                            }
                            iArr[i10] = iArr[i10] + 1;
                        } else if ((i10 & 1) != 0) {
                            iArr[i10] = iArr[i10] + 1;
                        } else if (i10 == i8) {
                            if (!l95.c(iArr)) {
                                l95.g(iArr);
                            } else if (l95.e(iArr, i7, i9)) {
                                if (l95.c) {
                                    z2 = l95.f();
                                } else {
                                    if (l95.b.size() > 1) {
                                        Iterator<k95> it = l95.b.iterator();
                                        k95 k95 = null;
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            k95 next = it.next();
                                            if (next.d >= 2) {
                                                if (k95 != null) {
                                                    l95.c = true;
                                                    i2 = 2;
                                                    i3 = ((int) (Math.abs(k95.f1210a - next.f1210a) - Math.abs(k95.b - next.b))) / 2;
                                                    break;
                                                }
                                                k95 = next;
                                            }
                                        }
                                    }
                                    i2 = 2;
                                    i3 = 0;
                                    if (i3 > iArr[i2]) {
                                        i7 += (i3 - iArr[i2]) - i2;
                                        i9 = i5 - 1;
                                    }
                                }
                                l95.b(iArr);
                                i6 = 2;
                                i10 = 0;
                            } else {
                                l95.g(iArr);
                            }
                            i10 = 3;
                        } else {
                            i10++;
                            iArr[i10] = iArr[i10] + 1;
                        }
                        i9++;
                        i8 = 4;
                    }
                    if (l95.c(iArr) && l95.e(iArr, i7, i5)) {
                        i6 = iArr[0];
                        if (l95.c) {
                            z2 = l95.f();
                        }
                    }
                    i7 += i6;
                }
            }
            int size2 = l95.b.size();
            if (size2 >= 3) {
                float f4 = 0.0f;
                if (size2 > 3) {
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    for (k95 k952 : l95.b) {
                        float f7 = k952.c;
                        f5 += f7;
                        f6 += f7 * f7;
                    }
                    float f8 = (float) size2;
                    float f9 = f5 / f8;
                    Collections.sort(l95.b, new l95.c(f9, null));
                    float max = Math.max(0.2f * f9, (float) Math.sqrt((double) ((f6 / f8) - (f9 * f9))));
                    int i11 = 0;
                    while (i11 < l95.b.size() && l95.b.size() > 3) {
                        if (Math.abs(l95.b.get(i11).c - f9) > max) {
                            l95.b.remove(i11);
                            i11--;
                        }
                        i11++;
                    }
                }
                if (l95.b.size() > 3) {
                    for (k95 k953 : l95.b) {
                        f4 += k953.c;
                    }
                    Collections.sort(l95.b, new l95.b(f4 / ((float) l95.b.size()), null));
                    List<k95> list = l95.b;
                    i = 3;
                    list.subList(3, list.size()).clear();
                } else {
                    i = 3;
                }
                k95[] k95Arr = new k95[i];
                k95Arr[0] = l95.b.get(0);
                k95Arr[1] = l95.b.get(1);
                k95Arr[2] = l95.b.get(2);
                g35.b(k95Arr);
                m95 m95 = new m95(k95Arr);
                k95 k954 = m95.b;
                k95 k955 = m95.c;
                k95 k956 = m95.f2343a;
                float a2 = (j95.a(k954, k956) + j95.a(k954, k955)) / 2.0f;
                if (a2 >= 1.0f) {
                    int I2 = ((hd3.I2(hd3.G0(k954.f1210a, k954.b, k956.f1210a, k956.b) / a2) + hd3.I2(hd3.G0(k954.f1210a, k954.b, k955.f1210a, k955.b) / a2)) / 2) + 7;
                    int i12 = I2 & 3;
                    if (i12 == 0) {
                        I2++;
                    } else if (i12 == 2) {
                        I2--;
                    } else if (i12 == 3) {
                        throw a35.h;
                    }
                    int[] iArr2 = g95.e;
                    if (I2 % 4 == 1) {
                        try {
                            g95 d = g95.d((I2 - 17) / 4);
                            int c = d.c() - 7;
                            if (d.b.length > 0) {
                                float f10 = k955.f1210a;
                                float f11 = k954.f1210a;
                                float f12 = (f10 - f11) + k956.f1210a;
                                float f13 = k955.b;
                                float f14 = k954.b;
                                float f15 = 1.0f - (3.0f / ((float) c));
                                int a3 = (int) hj1.a(f12, f11, f15, f11);
                                int a4 = (int) hj1.a((f13 - f14) + k956.b, f14, f15, f14);
                                int i13 = 4;
                                while (true) {
                                    if (i13 > 16) {
                                        break;
                                    }
                                    try {
                                        h95 = j95.b(a2, a3, a4, (float) i13);
                                        break;
                                    } catch (a35 unused) {
                                        i13 <<= 1;
                                    }
                                }
                            }
                            h95 = null;
                            float f16 = ((float) I2) - 3.5f;
                            if (h95 != null) {
                                f2 = h95.f1210a;
                                f = h95.b;
                                f3 = f16 - 3.0f;
                            } else {
                                f2 = (k955.f1210a - k954.f1210a) + k956.f1210a;
                                f = (k955.b - k954.b) + k956.b;
                                f3 = f16;
                            }
                            f45 a5 = j45.f1875a.a(j95.f1895a, I2, I2, m45.a(3.5f, 3.5f, f16, 3.5f, f3, f3, 3.5f, f16, k954.f1210a, k954.b, k955.f1210a, k955.b, f2, f, k956.f1210a, k956.b));
                            g35[] g35Arr2 = h95 == null ? new g35[]{k956, k954, k955} : new g35[]{k956, k954, k955, h95};
                            i45 = this.f3618a.a(a5, map);
                            g35Arr = g35Arr2;
                        } catch (IllegalArgumentException unused2) {
                            throw v25.a();
                        }
                    } else {
                        throw v25.a();
                    }
                } else {
                    throw a35.h;
                }
            } else {
                throw a35.h;
            }
        } else {
            f45 a6 = q25.a();
            int[] e = a6.e();
            int[] c2 = a6.c();
            if (e == null || c2 == null) {
                throw a35.h;
            }
            int i14 = a6.g;
            int i15 = a6.f;
            int i16 = e[0];
            int i17 = e[1];
            boolean z3 = true;
            int i18 = 0;
            while (i16 < i15 && i17 < i14) {
                if (z3 != a6.b(i16, i17)) {
                    i18++;
                    if (i18 == 5) {
                        break;
                    }
                    z3 = !z3;
                }
                i16++;
                i17++;
            }
            if (i16 == i15 || i17 == i14) {
                throw a35.h;
            }
            float f17 = ((float) (i16 - e[0])) / 7.0f;
            int i19 = e[1];
            int i20 = c2[1];
            int i21 = e[0];
            int i22 = c2[0];
            if (i21 >= i22 || i19 >= i20) {
                throw a35.h;
            }
            int i23 = i20 - i19;
            if (i23 == i22 - i21 || (i22 = i21 + i23) < a6.f) {
                int round = Math.round(((float) ((i22 - i21) + 1)) / f17);
                int round2 = Math.round(((float) (i23 + 1)) / f17);
                if (round <= 0 || round2 <= 0) {
                    throw a35.h;
                } else if (round2 == round) {
                    int i24 = (int) (f17 / 2.0f);
                    int i25 = i19 + i24;
                    int i26 = i21 + i24;
                    int i27 = (((int) (((float) (round - 1)) * f17)) + i26) - i22;
                    if (i27 > 0) {
                        if (i27 <= i24) {
                            i26 -= i27;
                        } else {
                            throw a35.h;
                        }
                    }
                    int i28 = (((int) (((float) (round2 - 1)) * f17)) + i25) - i20;
                    if (i28 > 0) {
                        if (i28 <= i24) {
                            i25 -= i28;
                        } else {
                            throw a35.h;
                        }
                    }
                    f45 f452 = new f45(round, round2);
                    for (int i29 = 0; i29 < round2; i29++) {
                        int i30 = ((int) (((float) i29) * f17)) + i25;
                        for (int i31 = 0; i31 < round; i31++) {
                            if (a6.b(((int) (((float) i31) * f17)) + i26, i30)) {
                                f452.f(i31, i29);
                            }
                        }
                    }
                    i45 = this.f3618a.a(f452, map);
                    g35Arr = b;
                } else {
                    throw a35.h;
                }
            } else {
                throw a35.h;
            }
        }
        Object obj = i45.f;
        if ((obj instanceof f95) && ((f95) obj).f1106a && g35Arr.length >= 3) {
            g35 g35 = g35Arr[0];
            g35Arr[0] = g35Arr[2];
            g35Arr[2] = g35;
        }
        e35 e35 = new e35(i45.c, i45.f1475a, g35Arr, o25.QR_CODE);
        List<byte[]> list2 = i45.d;
        if (list2 != null) {
            e35.b(f35.BYTE_SEGMENTS, list2);
        }
        String str = i45.e;
        if (str != null) {
            e35.b(f35.ERROR_CORRECTION_LEVEL, str);
        }
        if (i45.g >= 0 && i45.h >= 0) {
            e35.b(f35.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(i45.h));
            e35.b(f35.STRUCTURED_APPEND_PARITY, Integer.valueOf(i45.g));
        }
        return e35;
    }

    @Override // defpackage.c35
    public e35 b(q25 q25) throws a35, r25, v25 {
        return a(q25, null);
    }

    @Override // defpackage.c35
    public void c() {
    }
}
