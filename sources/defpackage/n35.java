package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.ConnectionFactory;
import java.util.Arrays;

/* renamed from: n35  reason: default package */
/* compiled from: Decoder */
public final class n35 {
    public static final String[] b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", ConnectionFactory.DEFAULT_VHOST, ProductDiscountsObject.KEY_DELIMITER, ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    public static final String[] f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a  reason: collision with root package name */
    public k35 f2511a;

    /* renamed from: n35$a */
    /* compiled from: Decoder */
    public enum a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static int b(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    public i45 a(k35 k35) throws v25 {
        int i;
        p45 p45;
        String str;
        int i2;
        this.f2511a = k35;
        f45 f45 = k35.f2019a;
        boolean z = k35.c;
        int i3 = k35.e;
        int i4 = (z ? 11 : 14) + (i3 << 2);
        int[] iArr = new int[i4];
        int i5 = ((z ? 88 : 112) + (i3 << 4)) * i3;
        boolean[] zArr = new boolean[i5];
        int i6 = 2;
        if (z) {
            for (int i7 = 0; i7 < i4; i7++) {
                iArr[i7] = i7;
            }
        } else {
            int i8 = i4 / 2;
            int i9 = ((((i8 - 1) / 15) * 2) + (i4 + 1)) / 2;
            for (int i10 = 0; i10 < i8; i10++) {
                int i11 = (i10 / 15) + i10;
                iArr[(i8 - i10) - 1] = (i9 - i11) - 1;
                iArr[i8 + i10] = i11 + i9 + 1;
            }
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i = 12;
            if (i12 >= i3) {
                break;
            }
            int i14 = (i3 - i12) << i6;
            if (z) {
                i = 9;
            }
            int i15 = i14 + i;
            int i16 = i12 << 1;
            int i17 = (i4 - 1) - i16;
            int i18 = 0;
            while (i18 < i15) {
                int i19 = i18 << 1;
                int i20 = 0;
                while (i20 < i6) {
                    int i21 = i16 + i20;
                    int i22 = i16 + i18;
                    zArr[i13 + i19 + i20] = f45.b(iArr[i21], iArr[i22]);
                    int i23 = i17 - i20;
                    zArr[(i15 * 2) + i13 + i19 + i20] = f45.b(iArr[i22], iArr[i23]);
                    int i24 = i17 - i18;
                    zArr[(i15 * 4) + i13 + i19 + i20] = f45.b(iArr[i23], iArr[i24]);
                    zArr[(i15 * 6) + i13 + i19 + i20] = f45.b(iArr[i24], iArr[i21]);
                    i20++;
                    z = z;
                    i3 = i3;
                    i6 = 2;
                }
                i18++;
                i6 = 2;
            }
            i13 += i15 << 3;
            i12++;
            i3 = i3;
            i6 = 2;
        }
        k35 k352 = this.f2511a;
        int i25 = k352.e;
        int i26 = 8;
        if (i25 <= 2) {
            p45 = p45.j;
            i = 6;
        } else if (i25 <= 8) {
            p45 = p45.n;
            i = 8;
        } else if (i25 <= 22) {
            i = 10;
            p45 = p45.i;
        } else {
            p45 = p45.h;
        }
        int i27 = k352.d;
        int i28 = i5 / i;
        if (i28 >= i27) {
            int i29 = i5 % i;
            int[] iArr2 = new int[i28];
            int i30 = 0;
            while (i30 < i28) {
                iArr2[i30] = b(zArr, i29, i);
                i30++;
                i29 += i;
            }
            try {
                new r45(p45).a(iArr2, i28 - i27);
                int i31 = 1;
                int i32 = (1 << i) - 1;
                int i33 = 0;
                int i34 = 0;
                while (i33 < i27) {
                    int i35 = iArr2[i33];
                    if (i35 == 0 || i35 == i32) {
                        throw v25.a();
                    }
                    if (i35 == i31 || i35 == i32 - 1) {
                        i34++;
                    }
                    i33++;
                    i31 = 1;
                }
                int i36 = (i27 * i) - i34;
                boolean[] zArr2 = new boolean[i36];
                int i37 = 0;
                for (int i38 = 0; i38 < i27; i38++) {
                    int i39 = iArr2[i38];
                    int i40 = 1;
                    if (i39 == 1 || i39 == i32 - 1) {
                        Arrays.fill(zArr2, i37, (i37 + i) - 1, i39 > 1);
                        i37 = (i - 1) + i37;
                    } else {
                        int i41 = i - 1;
                        while (i41 >= 0) {
                            int i42 = i37 + 1;
                            zArr2[i37] = ((i40 << i41) & i39) != 0;
                            i41--;
                            i37 = i42;
                            i40 = 1;
                        }
                    }
                }
                int i43 = (i36 + 7) / 8;
                byte[] bArr = new byte[i43];
                for (int i44 = 0; i44 < i43; i44++) {
                    int i45 = i44 << 3;
                    int i46 = i36 - i45;
                    if (i46 >= 8) {
                        i2 = b(zArr2, i45, 8);
                    } else {
                        i2 = b(zArr2, i45, i46) << (8 - i46);
                    }
                    bArr[i44] = (byte) i2;
                }
                a aVar = a.UPPER;
                StringBuilder sb = new StringBuilder(20);
                a aVar2 = aVar;
                int i47 = 0;
                while (i47 < i36) {
                    a aVar3 = a.BINARY;
                    if (aVar == aVar3) {
                        if (i36 - i47 < 5) {
                            break;
                        }
                        int b2 = b(zArr2, i47, 5);
                        i47 += 5;
                        if (b2 == 0) {
                            if (i36 - i47 < 11) {
                                break;
                            }
                            b2 = b(zArr2, i47, 11) + 31;
                            i47 += 11;
                        }
                        int i48 = 0;
                        while (true) {
                            if (i48 >= b2) {
                                break;
                            } else if (i36 - i47 < i26) {
                                i47 = i36;
                                break;
                            } else {
                                sb.append((char) b(zArr2, i47, i26));
                                i47 += 8;
                                i48++;
                            }
                        }
                    } else {
                        a aVar4 = a.DIGIT;
                        int i49 = aVar == aVar4 ? 4 : 5;
                        if (i36 - i47 < i49) {
                            break;
                        }
                        int b3 = b(zArr2, i47, i49);
                        i47 += i49;
                        int ordinal = aVar.ordinal();
                        if (ordinal == 0) {
                            str = b[b3];
                        } else if (ordinal == 1) {
                            str = c[b3];
                        } else if (ordinal == 2) {
                            str = d[b3];
                        } else if (ordinal == 3) {
                            str = f[b3];
                        } else if (ordinal == 4) {
                            str = e[b3];
                        } else {
                            throw new IllegalStateException("Bad table");
                        }
                        if (str.startsWith("CTRL_")) {
                            char charAt = str.charAt(5);
                            if (charAt != 'B') {
                                aVar2 = charAt != 'D' ? charAt != 'P' ? charAt != 'L' ? charAt != 'M' ? a.UPPER : a.MIXED : a.LOWER : a.PUNCT : aVar4;
                            } else {
                                aVar2 = aVar3;
                            }
                            if (str.charAt(6) != 'L') {
                                i26 = 8;
                                aVar2 = aVar;
                                aVar = aVar2;
                            }
                        } else {
                            sb.append(str);
                        }
                    }
                    aVar = aVar2;
                    i26 = 8;
                }
                i45 i452 = new i45(bArr, sb.toString(), null, null);
                i452.b = i36;
                return i452;
            } catch (t45 e2) {
                if (d35.f) {
                    throw new v25(e2);
                }
                throw v25.h;
            }
        } else {
            throw v25.a();
        }
    }
}
