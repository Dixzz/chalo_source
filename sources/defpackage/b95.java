package defpackage;

import defpackage.g95;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: b95  reason: default package */
/* compiled from: Decoder */
public final class b95 {

    /* renamed from: a  reason: collision with root package name */
    public final r45 f400a = new r45(p45.l);

    public i45 a(f45 f45, Map<s25, ?> map) throws v25, r25 {
        r25 r25;
        v25 e;
        x85 x85 = new x85(f45);
        try {
            return b(x85, map);
        } catch (v25 e2) {
            e = e2;
            r25 = null;
            try {
                x85.e();
                x85.b = null;
                x85.c = null;
                x85.d = true;
                x85.d();
                x85.c();
                x85.b();
                i45 b = b(x85, map);
                b.f = new f95(true);
                return b;
            } catch (r25 | v25 unused) {
                if (e != null) {
                    throw e;
                }
                throw r25;
            }
        } catch (r25 e3) {
            r25 = e3;
            e = null;
            x85.e();
            x85.b = null;
            x85.c = null;
            x85.d = true;
            x85.d();
            x85.c();
            x85.b();
            i45 b2 = b(x85, map);
            b2.f = new f95(true);
            return b2;
        }
    }

    public final i45 b(x85 x85, Map<s25, ?> map) throws v25, r25 {
        e95 e95;
        int i;
        int i2;
        int i3;
        f45 f45;
        g95 d = x85.d();
        c95 c95 = x85.c().f812a;
        d95 c = x85.c();
        g95 d2 = x85.d();
        z85 z85 = z85.values()[c.b];
        f45 f452 = x85.f3902a;
        int i4 = f452.g;
        z85.unmaskBitMatrix(f452, i4);
        int c2 = d2.c();
        f45 f453 = new f45(c2, c2);
        int i5 = 0;
        f453.g(0, 0, 9, 9);
        int i6 = c2 - 8;
        f453.g(i6, 0, 8, 9);
        f453.g(0, i6, 9, 8);
        int length = d2.b.length;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = d2.b[i7] - 2;
            for (int i9 = 0; i9 < length; i9++) {
                if (!((i7 == 0 && (i9 == 0 || i9 == length - 1)) || (i7 == length - 1 && i9 == 0))) {
                    f453.g(d2.b[i9] - 2, i8, 5, 5);
                }
            }
        }
        int i10 = c2 - 17;
        int i11 = 6;
        f453.g(6, 9, 1, i10);
        f453.g(9, 6, i10, 1);
        if (d2.f1228a > 6) {
            int i12 = c2 - 11;
            f453.g(i12, 0, 3, 6);
            f453.g(0, i12, 6, 3);
        }
        int i13 = d2.d;
        byte[] bArr = new byte[i13];
        int i14 = i4 - 1;
        int i15 = i14;
        int i16 = 0;
        boolean z = true;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = 2;
            if (i15 <= 0) {
                break;
            }
            if (i15 == i11) {
                i15--;
            }
            int i20 = 0;
            while (i20 < i4) {
                int i21 = z ? i14 - i20 : i20;
                while (i5 < i19) {
                    int i22 = i15 - i5;
                    if (!f453.b(i22, i21)) {
                        int i23 = i17 + 1;
                        int i24 = i18 << 1;
                        f45 = f453;
                        int i25 = x85.f3902a.b(i22, i21) ? i24 | 1 : i24;
                        if (i23 == 8) {
                            bArr[i16] = (byte) i25;
                            i16++;
                            i17 = 0;
                            i18 = 0;
                        } else {
                            i18 = i25;
                            i17 = i23;
                        }
                    } else {
                        f45 = f453;
                    }
                    i5++;
                    f453 = f45;
                    i19 = 2;
                }
                i20++;
                i5 = 0;
                i19 = 2;
            }
            z = !z;
            i15 -= 2;
            i5 = 0;
            i11 = 6;
        }
        if (i16 != d2.d) {
            throw v25.a();
        } else if (i13 == d.d) {
            g95.b bVar = d.c[c95.ordinal()];
            g95.a[] aVarArr = bVar.b;
            int i26 = 0;
            for (g95.a aVar : aVarArr) {
                i26 += aVar.f1229a;
            }
            y85[] y85Arr = new y85[i26];
            int i27 = 0;
            for (g95.a aVar2 : aVarArr) {
                int i28 = 0;
                while (i28 < aVar2.f1229a) {
                    int i29 = aVar2.b;
                    y85Arr[i27] = new y85(i29, new byte[(bVar.f1230a + i29)]);
                    i28++;
                    i27++;
                }
            }
            int length2 = y85Arr[0].b.length;
            int i30 = i26 - 1;
            while (i30 >= 0 && y85Arr[i30].b.length != length2) {
                i30--;
            }
            int i31 = i30 + 1;
            int i32 = length2 - bVar.f1230a;
            int i33 = 0;
            for (int i34 = 0; i34 < i32; i34++) {
                int i35 = 0;
                while (i35 < i27) {
                    y85Arr[i35].b[i34] = bArr[i33];
                    i35++;
                    i33++;
                }
            }
            int i36 = i31;
            while (i36 < i27) {
                y85Arr[i36].b[i32] = bArr[i33];
                i36++;
                i33++;
            }
            int length3 = y85Arr[0].b.length;
            while (i32 < length3) {
                int i37 = 0;
                while (i37 < i27) {
                    y85Arr[i37].b[i37 < i31 ? i32 : i32 + 1] = bArr[i33];
                    i37++;
                    i33++;
                }
                i32++;
            }
            int i38 = 0;
            for (int i39 = 0; i39 < i26; i39++) {
                i38 += y85Arr[i39].f4021a;
            }
            byte[] bArr2 = new byte[i38];
            int i40 = 0;
            for (int i41 = 0; i41 < i26; i41++) {
                y85 y85 = y85Arr[i41];
                byte[] bArr3 = y85.b;
                int i42 = y85.f4021a;
                int length4 = bArr3.length;
                int[] iArr = new int[length4];
                for (int i43 = 0; i43 < length4; i43++) {
                    iArr[i43] = bArr3[i43] & 255;
                }
                try {
                    this.f400a.a(iArr, bArr3.length - i42);
                    for (int i44 = 0; i44 < i42; i44++) {
                        bArr3[i44] = (byte) iArr[i44];
                    }
                    int i45 = 0;
                    while (i45 < i42) {
                        bArr2[i40] = bArr3[i45];
                        i45++;
                        i40++;
                    }
                } catch (t45 unused) {
                    throw r25.a();
                }
            }
            char[] cArr = a95.f136a;
            g45 g45 = new g45(bArr2);
            StringBuilder sb = new StringBuilder(50);
            ArrayList arrayList = new ArrayList(1);
            int i46 = -1;
            int i47 = -1;
            boolean z2 = false;
            h45 h45 = null;
            do {
                try {
                    if (g45.a() < 4) {
                        e95 = e95.TERMINATOR;
                    } else {
                        e95 = e95.forBits(g45.b(4));
                    }
                    int ordinal = e95.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 3) {
                            if (ordinal == 5) {
                                int b = g45.b(8);
                                if ((b & 128) == 0) {
                                    i = b & 127;
                                } else {
                                    if ((b & 192) == 128) {
                                        i2 = g45.b(8);
                                        i3 = (b & 63) << 8;
                                    } else if ((b & 224) == 192) {
                                        i2 = g45.b(16);
                                        i3 = (b & 31) << 16;
                                    } else {
                                        throw v25.a();
                                    }
                                    i = i3 | i2;
                                }
                                h45 = h45.getCharacterSetECIByValue(i);
                                if (h45 == null) {
                                    throw v25.a();
                                }
                            } else if (ordinal == 7 || ordinal == 8) {
                                z2 = true;
                            } else if (ordinal != 9) {
                                int b2 = g45.b(e95.getCharacterCountBits(d));
                                int ordinal2 = e95.ordinal();
                                if (ordinal2 == 1) {
                                    a95.e(g45, sb, b2);
                                } else if (ordinal2 == 2) {
                                    a95.a(g45, sb, b2, z2);
                                } else if (ordinal2 == 4) {
                                    a95.b(g45, sb, b2, h45, arrayList, map);
                                } else if (ordinal2 == 6) {
                                    a95.d(g45, sb, b2);
                                } else {
                                    throw v25.a();
                                }
                            } else {
                                int b3 = g45.b(4);
                                int b4 = g45.b(e95.getCharacterCountBits(d));
                                if (b3 == 1) {
                                    a95.c(g45, sb, b4);
                                }
                            }
                        } else if (g45.a() >= 16) {
                            i46 = g45.b(8);
                            i47 = g45.b(8);
                        } else {
                            throw v25.a();
                        }
                    }
                } catch (IllegalArgumentException unused2) {
                    throw v25.a();
                }
            } while (e95 != e95.TERMINATOR);
            return new i45(bArr2, sb.toString(), arrayList.isEmpty() ? null : arrayList, c95.toString(), i46, i47);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
