package defpackage;

/* renamed from: o35  reason: default package */
/* compiled from: Detector */
public final class o35 {
    public static final int[] g = {3808, 476, 2107, 1799};

    /* renamed from: a  reason: collision with root package name */
    public final f45 f2646a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;

    /* renamed from: o35$a */
    /* compiled from: Detector */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f2647a;
        public final int b;

        public a(int i, int i2) {
            this.f2647a = i;
            this.b = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.f2647a);
            sb.append(' ');
            return hj1.W(sb, this.b, '>');
        }
    }

    public o35(f45 f45) {
        this.f2646a = f45;
    }

    public static g35[] b(g35[] g35Arr, int i, int i2) {
        float f2 = ((float) i2) / (((float) i) * 2.0f);
        float f3 = g35Arr[0].f1210a - g35Arr[2].f1210a;
        float f4 = g35Arr[0].b - g35Arr[2].b;
        float f5 = (g35Arr[0].f1210a + g35Arr[2].f1210a) / 2.0f;
        float f6 = (g35Arr[0].b + g35Arr[2].b) / 2.0f;
        float f7 = f3 * f2;
        float f8 = f4 * f2;
        g35 g35 = new g35(f5 + f7, f6 + f8);
        g35 g352 = new g35(f5 - f7, f6 - f8);
        float f9 = g35Arr[1].f1210a - g35Arr[3].f1210a;
        float f10 = g35Arr[1].b - g35Arr[3].b;
        float f11 = (g35Arr[1].f1210a + g35Arr[3].f1210a) / 2.0f;
        float f12 = (g35Arr[1].b + g35Arr[3].b) / 2.0f;
        float f13 = f9 * f2;
        float f14 = f2 * f10;
        return new g35[]{g35, new g35(f11 + f13, f12 + f14), g352, new g35(f11 - f13, f12 - f14)};
    }

    public k35 a(boolean z) throws a35 {
        g35 g35;
        g35 g352;
        g35 g353;
        g35 g354;
        g35 g355;
        g35 g356;
        g35 g357;
        g35 g358;
        int i;
        int i2;
        long j;
        a aVar;
        int i3 = 2;
        int i4 = -1;
        int i5 = 1;
        try {
            f45 f45 = this.f2646a;
            g35[] b2 = new o45(f45, 10, f45.f / 2, f45.g / 2).b();
            g353 = b2[0];
            g352 = b2[1];
            g35 = b2[2];
            g354 = b2[3];
        } catch (a35 unused) {
            f45 f452 = this.f2646a;
            int i6 = f452.f / 2;
            int i7 = f452.g / 2;
            int i8 = i7 - 7;
            int i9 = i6 + 7 + 1;
            int i10 = i9;
            int i11 = i8;
            while (true) {
                i11--;
                if (!f(i10, i11) || this.f2646a.b(i10, i11)) {
                    int i12 = i10 - 1;
                    int i13 = i11 + 1;
                } else {
                    i10++;
                }
            }
            int i122 = i10 - 1;
            int i132 = i11 + 1;
            while (f(i122, i132) && !this.f2646a.b(i122, i132)) {
                i122++;
            }
            int i14 = i122 - 1;
            while (f(i14, i132) && !this.f2646a.b(i14, i132)) {
                i132--;
            }
            g35 g359 = new g35((float) i14, (float) (i132 + 1));
            int i15 = i7 + 7;
            int i16 = i15;
            while (true) {
                i16++;
                if (!f(i9, i16) || this.f2646a.b(i9, i16)) {
                    int i17 = i9 - 1;
                    int i18 = i16 - 1;
                } else {
                    i9++;
                }
            }
            int i172 = i9 - 1;
            int i182 = i16 - 1;
            while (f(i172, i182) && !this.f2646a.b(i172, i182)) {
                i172++;
            }
            int i19 = i172 - 1;
            while (f(i19, i182) && !this.f2646a.b(i19, i182)) {
                i182++;
            }
            g35 g3510 = new g35((float) i19, (float) (i182 - 1));
            int i20 = i6 - 7;
            int i21 = i20 - 1;
            while (true) {
                i15++;
                if (!f(i21, i15) || this.f2646a.b(i21, i15)) {
                    int i22 = i21 + 1;
                    int i23 = i15 - 1;
                } else {
                    i21--;
                }
            }
            int i222 = i21 + 1;
            int i232 = i15 - 1;
            while (f(i222, i232) && !this.f2646a.b(i222, i232)) {
                i222--;
            }
            int i24 = i222 + 1;
            while (f(i24, i232) && !this.f2646a.b(i24, i232)) {
                i232++;
            }
            g35 g3511 = new g35((float) i24, (float) (i232 - 1));
            do {
                i20--;
                i8--;
                if (!f(i20, i8)) {
                    break;
                }
            } while (!this.f2646a.b(i20, i8));
            int i25 = i20 + 1;
            int i26 = i8 + 1;
            while (f(i25, i26) && !this.f2646a.b(i25, i26)) {
                i25--;
            }
            int i27 = i25 + 1;
            while (f(i27, i26) && !this.f2646a.b(i27, i26)) {
                i26--;
            }
            g354 = new g35((float) i27, (float) (i26 + 1));
            g35 = g3511;
            g352 = g3510;
            g353 = g359;
        }
        int I2 = hd3.I2((((g353.f1210a + g354.f1210a) + g352.f1210a) + g35.f1210a) / 4.0f);
        int I22 = hd3.I2((((g353.b + g354.b) + g352.b) + g35.b) / 4.0f);
        try {
            g35[] b3 = new o45(this.f2646a, 15, I2, I22).b();
            g357 = b3[0];
            g356 = b3[1];
            g355 = b3[2];
            g358 = b3[3];
        } catch (a35 unused2) {
            int i28 = I22 - 7;
            int i29 = I2 + 7 + 1;
            int i30 = i29;
            int i31 = i28;
            while (true) {
                i31--;
                if (!f(i30, i31) || this.f2646a.b(i30, i31)) {
                    int i32 = i30 - 1;
                    int i33 = i31 + 1;
                } else {
                    i30++;
                }
            }
            int i322 = i30 - 1;
            int i332 = i31 + 1;
            while (f(i322, i332) && !this.f2646a.b(i322, i332)) {
                i322++;
            }
            int i34 = i322 - 1;
            while (f(i34, i332) && !this.f2646a.b(i34, i332)) {
                i332--;
            }
            g35 g3512 = new g35((float) i34, (float) (i332 + 1));
            int i35 = I22 + 7;
            int i36 = i35;
            while (true) {
                i36++;
                if (!f(i29, i36) || this.f2646a.b(i29, i36)) {
                    int i37 = i29 - 1;
                    int i38 = i36 - 1;
                } else {
                    i29++;
                }
            }
            int i372 = i29 - 1;
            int i382 = i36 - 1;
            while (f(i372, i382) && !this.f2646a.b(i372, i382)) {
                i372++;
            }
            int i39 = i372 - 1;
            while (f(i39, i382) && !this.f2646a.b(i39, i382)) {
                i382++;
            }
            g35 g3513 = new g35((float) i39, (float) (i382 - 1));
            int i40 = I2 - 7;
            int i41 = i40 - 1;
            while (true) {
                i35++;
                if (!f(i41, i35) || this.f2646a.b(i41, i35)) {
                    int i42 = i41 + 1;
                    int i43 = i35 - 1;
                } else {
                    i41--;
                }
            }
            int i422 = i41 + 1;
            int i432 = i35 - 1;
            while (f(i422, i432) && !this.f2646a.b(i422, i432)) {
                i422--;
            }
            int i44 = i422 + 1;
            while (f(i44, i432) && !this.f2646a.b(i44, i432)) {
                i432++;
            }
            g35 g3514 = new g35((float) i44, (float) (i432 - 1));
            do {
                i40--;
                i28--;
                if (!f(i40, i28)) {
                    break;
                }
            } while (!this.f2646a.b(i40, i28));
            int i45 = i40 + 1;
            int i46 = i28 + 1;
            while (f(i45, i46) && !this.f2646a.b(i45, i46)) {
                i45--;
            }
            int i47 = i45 + 1;
            while (f(i47, i46) && !this.f2646a.b(i47, i46)) {
                i46--;
            }
            g358 = new g35((float) i47, (float) (i46 + 1));
            g357 = g3512;
            g355 = g3514;
            g356 = g3513;
        }
        a aVar2 = new a(hd3.I2((((g357.f1210a + g358.f1210a) + g356.f1210a) + g355.f1210a) / 4.0f), hd3.I2((((g357.b + g358.b) + g356.b) + g355.b) / 4.0f));
        this.e = 1;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z2 = true;
        while (this.e < 9) {
            a e2 = e(aVar2, z2, i5, i4);
            a e3 = e(aVar3, z2, i5, i5);
            a e4 = e(aVar4, z2, i4, i5);
            a e5 = e(aVar5, z2, i4, i4);
            if (this.e > i3) {
                double H0 = (double) ((hd3.H0(e5.f2647a, e5.b, e2.f2647a, e2.b) * ((float) this.e)) / (hd3.H0(aVar5.f2647a, aVar5.b, aVar2.f2647a, aVar2.b) * ((float) (this.e + i3))));
                if (H0 < 0.75d || H0 > 1.25d) {
                    break;
                }
                a aVar6 = new a(e2.f2647a - 3, e2.b + 3);
                a aVar7 = new a(e3.f2647a - 3, e3.b - 3);
                a aVar8 = new a(e4.f2647a + 3, e4.b - 3);
                aVar = e2;
                a aVar9 = new a(e5.f2647a + 3, e5.b + 3);
                int c2 = c(aVar9, aVar6);
                if (!(c2 != 0 && c(aVar6, aVar7) == c2 && c(aVar7, aVar8) == c2 && c(aVar8, aVar9) == c2)) {
                    break;
                }
            } else {
                aVar = e2;
            }
            z2 = !z2;
            this.e++;
            aVar5 = e5;
            aVar3 = e3;
            aVar4 = e4;
            aVar2 = aVar;
            i3 = 2;
            i4 = -1;
            i5 = 1;
        }
        int i48 = this.e;
        if (i48 == 5 || i48 == 7) {
            this.b = i48 == 5;
            int i49 = i48 * 2;
            g35[] b4 = b(new g35[]{new g35(((float) aVar2.f2647a) + 0.5f, ((float) aVar2.b) - 0.5f), new g35(((float) aVar3.f2647a) + 0.5f, ((float) aVar3.b) + 0.5f), new g35(((float) aVar4.f2647a) - 0.5f, ((float) aVar4.b) + 0.5f), new g35(((float) aVar5.f2647a) - 0.5f, ((float) aVar5.b) - 0.5f)}, i49 - 3, i49);
            if (z) {
                g35 g3515 = b4[0];
                b4[0] = b4[2];
                b4[2] = g3515;
            }
            if (!g(b4[0]) || !g(b4[1]) || !g(b4[2]) || !g(b4[3])) {
                throw a35.h;
            }
            int i50 = this.e * 2;
            int[] iArr = {h(b4[0], b4[1], i50), h(b4[1], b4[2], i50), h(b4[2], b4[3], i50), h(b4[3], b4[0], i50)};
            int i51 = 0;
            for (int i52 = 0; i52 < 4; i52++) {
                int i53 = iArr[i52];
                i51 = (i51 << 3) + ((i53 >> (i50 - 2)) << 1) + (i53 & 1);
            }
            int i54 = ((i51 & 1) << 11) + (i51 >> 1);
            for (int i55 = 0; i55 < 4; i55++) {
                if (Integer.bitCount(g[i55] ^ i54) <= 2) {
                    this.f = i55;
                    long j2 = 0;
                    for (int i56 = 0; i56 < 4; i56++) {
                        int i57 = iArr[(this.f + i56) % 4];
                        if (this.b) {
                            j = j2 << 7;
                            i2 = (i57 >> 1) & 127;
                        } else {
                            j = j2 << 10;
                            i2 = ((i57 >> 1) & 31) + ((i57 >> 2) & 992);
                        }
                        j2 = j + ((long) i2);
                    }
                    int i58 = 7;
                    if (this.b) {
                        i = 2;
                    } else {
                        i = 4;
                        i58 = 10;
                    }
                    int i59 = i58 - i;
                    int[] iArr2 = new int[i58];
                    while (true) {
                        i58--;
                        if (i58 >= 0) {
                            iArr2[i58] = ((int) j2) & 15;
                            j2 >>= 4;
                        } else {
                            try {
                                break;
                            } catch (t45 unused3) {
                                throw a35.h;
                            }
                        }
                    }
                    new r45(p45.k).a(iArr2, i59);
                    int i60 = 0;
                    for (int i61 = 0; i61 < i; i61++) {
                        i60 = (i60 << 4) + iArr2[i61];
                    }
                    if (this.b) {
                        this.c = (i60 >> 6) + 1;
                        this.d = (i60 & 63) + 1;
                    } else {
                        this.c = (i60 >> 11) + 1;
                        this.d = (i60 & 2047) + 1;
                    }
                    f45 f453 = this.f2646a;
                    int i62 = this.f;
                    g35 g3516 = b4[i62 % 4];
                    g35 g3517 = b4[(i62 + 1) % 4];
                    g35 g3518 = b4[(i62 + 2) % 4];
                    g35 g3519 = b4[(i62 + 3) % 4];
                    j45 j45 = j45.f1875a;
                    int d2 = d();
                    float f2 = ((float) d2) / 2.0f;
                    float f3 = (float) this.e;
                    float f4 = f2 - f3;
                    float f5 = f2 + f3;
                    return new k35(j45.a(f453, d2, d2, m45.a(f4, f4, f5, f4, f5, f5, f4, f5, g3516.f1210a, g3516.b, g3517.f1210a, g3517.b, g3518.f1210a, g3518.b, g3519.f1210a, g3519.b)), b(b4, this.e * 2, d()), this.b, this.d, this.c);
                }
            }
            throw a35.h;
        }
        throw a35.h;
    }

    public final int c(a aVar, a aVar2) {
        float H0 = hd3.H0(aVar.f2647a, aVar.b, aVar2.f2647a, aVar2.b);
        int i = aVar2.f2647a;
        int i2 = aVar.f2647a;
        float f2 = ((float) (i - i2)) / H0;
        int i3 = aVar2.b;
        int i4 = aVar.b;
        float f3 = ((float) (i3 - i4)) / H0;
        float f4 = (float) i2;
        float f5 = (float) i4;
        boolean b2 = this.f2646a.b(i2, i4);
        int ceil = (int) Math.ceil((double) H0);
        boolean z = false;
        int i5 = 0;
        for (int i6 = 0; i6 < ceil; i6++) {
            f4 += f2;
            f5 += f3;
            if (this.f2646a.b(hd3.I2(f4), hd3.I2(f5)) != b2) {
                i5++;
            }
        }
        float f6 = ((float) i5) / H0;
        if (f6 > 0.1f && f6 < 0.9f) {
            return 0;
        }
        if (f6 <= 0.1f) {
            z = true;
        }
        return z == b2 ? 1 : -1;
    }

    public final int d() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i = this.c;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return ((((i - 4) / 8) + 1) * 2) + (i * 4) + 15;
    }

    public final a e(a aVar, boolean z, int i, int i2) {
        int i3 = aVar.f2647a + i;
        int i4 = aVar.b;
        while (true) {
            i4 += i2;
            if (!f(i3, i4) || this.f2646a.b(i3, i4) != z) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
            } else {
                i3 += i;
            }
        }
        int i52 = i3 - i;
        int i62 = i4 - i2;
        while (f(i52, i62) && this.f2646a.b(i52, i62) == z) {
            i52 += i;
        }
        int i7 = i52 - i;
        while (f(i7, i62) && this.f2646a.b(i7, i62) == z) {
            i62 += i2;
        }
        return new a(i7, i62 - i2);
    }

    public final boolean f(int i, int i2) {
        if (i < 0) {
            return false;
        }
        f45 f45 = this.f2646a;
        return i < f45.f && i2 > 0 && i2 < f45.g;
    }

    public final boolean g(g35 g35) {
        return f(hd3.I2(g35.f1210a), hd3.I2(g35.b));
    }

    public final int h(g35 g35, g35 g352, int i) {
        float G0 = hd3.G0(g35.f1210a, g35.b, g352.f1210a, g352.b);
        float f2 = G0 / ((float) i);
        float f3 = g35.f1210a;
        float f4 = g35.b;
        float f5 = ((g352.f1210a - f3) * f2) / G0;
        float f6 = ((g352.b - f4) * f2) / G0;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f7 = (float) i3;
            if (this.f2646a.b(hd3.I2((f7 * f5) + f3), hd3.I2((f7 * f6) + f4))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
