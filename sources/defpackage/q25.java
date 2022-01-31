package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Array;

/* renamed from: q25  reason: default package */
/* compiled from: BinaryBitmap */
public final class q25 {

    /* renamed from: a  reason: collision with root package name */
    public final p25 f2888a;
    public f45 b;

    public q25(p25 p25) {
        this.f2888a = p25;
    }

    public f45 a() throws a35 {
        int i;
        q25 q25 = this;
        if (q25.b == null) {
            l45 l45 = (l45) q25.f2888a;
            f45 f45 = l45.d;
            if (f45 == null) {
                x25 x25 = l45.f2760a;
                int i2 = x25.f3874a;
                int i3 = x25.b;
                if (i2 < 40 || i3 < 40) {
                    f45 f452 = new f45(i2, i3);
                    l45.b(i2);
                    int[] iArr = l45.c;
                    for (int i4 = 1; i4 < 5; i4++) {
                        byte[] b2 = x25.b((i3 * i4) / 5, l45.b);
                        int i5 = (i2 << 2) / 5;
                        for (int i6 = i2 / 5; i6 < i5; i6++) {
                            int i7 = (b2[i6] & 255) >> 3;
                            iArr[i7] = iArr[i7] + 1;
                        }
                    }
                    int a2 = l45.a(iArr);
                    byte[] a3 = x25.a();
                    for (int i8 = 0; i8 < i3; i8++) {
                        int i9 = i8 * i2;
                        for (int i10 = 0; i10 < i2; i10++) {
                            if ((a3[i9 + i10] & 255) < a2) {
                                f452.f(i10, i8);
                            }
                        }
                    }
                    l45.d = f452;
                } else {
                    byte[] a4 = x25.a();
                    int i11 = i2 >> 3;
                    if ((i2 & 7) != 0) {
                        i11++;
                    }
                    int i12 = i3 >> 3;
                    if ((i3 & 7) != 0) {
                        i12++;
                    }
                    int i13 = i3 - 8;
                    int i14 = i2 - 8;
                    int[] iArr2 = new int[2];
                    iArr2[1] = i11;
                    iArr2[0] = i12;
                    int[][] iArr3 = (int[][]) Array.newInstance(int.class, iArr2);
                    int i15 = 0;
                    while (true) {
                        int i16 = 8;
                        if (i15 >= i12) {
                            break;
                        }
                        int i17 = i15 << 3;
                        if (i17 > i13) {
                            i17 = i13;
                        }
                        int i18 = 0;
                        while (i18 < i11) {
                            int i19 = i18 << 3;
                            if (i19 > i14) {
                                i19 = i14;
                            }
                            int i20 = (i17 * i2) + i19;
                            int i21 = 0;
                            int i22 = 0;
                            int i23 = Constants.MAX_HOST_LENGTH;
                            int i24 = 0;
                            while (i21 < i16) {
                                int i25 = i23;
                                int i26 = i24;
                                int i27 = 0;
                                while (i27 < i16) {
                                    int i28 = a4[i20 + i27] & 255;
                                    i22 += i28;
                                    if (i28 < i25) {
                                        i25 = i28;
                                    }
                                    if (i28 > i26) {
                                        i26 = i28;
                                    }
                                    i27++;
                                    i16 = 8;
                                }
                                if (i26 - i25 > 24) {
                                    i = i21;
                                    while (true) {
                                        i++;
                                        i20 += i2;
                                        if (i >= 8) {
                                            break;
                                        }
                                        int i29 = 0;
                                        for (int i30 = 8; i29 < i30; i30 = 8) {
                                            i22 += a4[i20 + i29] & 255;
                                            i29++;
                                            i25 = i25;
                                        }
                                    }
                                    i23 = i25;
                                } else {
                                    i23 = i25;
                                    i = i21;
                                }
                                i21 = i + 1;
                                i20 += i2;
                                i16 = 8;
                                i24 = i26;
                                i17 = i17;
                            }
                            int i31 = i22 >> 6;
                            if (i24 - i23 <= 24) {
                                i31 = i23 / 2;
                                if (i15 > 0 && i18 > 0) {
                                    int i32 = i15 - 1;
                                    int i33 = i18 - 1;
                                    int i34 = (((iArr3[i15][i33] * 2) + iArr3[i32][i18]) + iArr3[i32][i33]) / 4;
                                    if (i23 < i34) {
                                        i31 = i34;
                                    }
                                }
                            }
                            iArr3[i15][i18] = i31;
                            i18++;
                            i17 = i17;
                            i16 = 8;
                        }
                        i15++;
                    }
                    f45 f453 = new f45(i2, i3);
                    for (int i35 = 0; i35 < i12; i35++) {
                        int i36 = i35 << 3;
                        if (i36 > i13) {
                            i36 = i13;
                        }
                        int i37 = i12 - 3;
                        if (i35 < 2) {
                            i37 = 2;
                        } else if (i35 <= i37) {
                            i37 = i35;
                        }
                        int i38 = 0;
                        while (i38 < i11) {
                            int i39 = i38 << 3;
                            if (i39 > i14) {
                                i39 = i14;
                            }
                            int i40 = i11 - 3;
                            if (i38 < 2) {
                                i40 = 2;
                            } else if (i38 <= i40) {
                                i40 = i38;
                            }
                            int i41 = -2;
                            int i42 = 0;
                            for (int i43 = 2; i41 <= i43; i43 = 2) {
                                int[] iArr4 = iArr3[i37 + i41];
                                i42 = iArr4[i40 - 2] + iArr4[i40 - 1] + iArr4[i40] + iArr4[i40 + 1] + iArr4[i40 + 2] + i42;
                                i41++;
                            }
                            int i44 = i42 / 25;
                            int i45 = (i36 * i2) + i39;
                            int i46 = 8;
                            int i47 = 0;
                            while (i47 < i46) {
                                int i48 = 0;
                                while (i48 < i46) {
                                    if ((a4[i45 + i48] & 255) <= i44) {
                                        f453.f(i39 + i48, i36 + i47);
                                    }
                                    i48++;
                                    a4 = a4;
                                    i46 = 8;
                                }
                                i47++;
                                i45 += i2;
                                i12 = i12;
                                i46 = 8;
                            }
                            i38++;
                            i37 = i37;
                            i11 = i11;
                        }
                    }
                    l45.d = f453;
                }
                f45 = l45.d;
            }
            q25 = this;
            q25.b = f45;
        }
        return q25.b;
    }

    public e45 b(int i, e45 e45) throws a35 {
        int i2;
        l45 l45 = (l45) this.f2888a;
        x25 x25 = l45.f2760a;
        int i3 = x25.f3874a;
        if (e45.g < i3) {
            e45 = new e45(i3);
        } else {
            int length = e45.f.length;
            for (int i4 = 0; i4 < length; i4++) {
                e45.f[i4] = 0;
            }
        }
        l45.b(i3);
        byte[] b2 = x25.b(i, l45.b);
        int[] iArr = l45.c;
        int i5 = 0;
        while (true) {
            i2 = 1;
            if (i5 >= i3) {
                break;
            }
            int i6 = (b2[i5] & 255) >> 3;
            iArr[i6] = iArr[i6] + 1;
            i5++;
        }
        int a2 = l45.a(iArr);
        if (i3 < 3) {
            for (int i7 = 0; i7 < i3; i7++) {
                if ((b2[i7] & 255) < a2) {
                    e45.k(i7);
                }
            }
        } else {
            int i8 = b2[1] & 255;
            int i9 = b2[0] & 255;
            int i10 = i8;
            while (i2 < i3 - 1) {
                int i11 = i2 + 1;
                int i12 = b2[i11] & 255;
                if ((((i10 << 2) - i9) - i12) / 2 < a2) {
                    e45.k(i2);
                }
                i9 = i10;
                i2 = i11;
                i10 = i12;
            }
        }
        return e45;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (a35 unused) {
            return "";
        }
    }
}
