package defpackage;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;

/* renamed from: p55  reason: default package */
/* compiled from: MaxiCodeReader */
public final class p55 implements c35 {
    public static final g35[] b = new g35[0];

    /* renamed from: a  reason: collision with root package name */
    public final s55 f2769a = new s55();

    @Override // defpackage.c35
    public e35 a(q25 q25, Map<s25, ?> map) throws a35, r25, v25 {
        byte[] bArr;
        String str;
        if (map == null || !map.containsKey(s25.PURE_BARCODE)) {
            throw a35.h;
        }
        f45 a2 = q25.a();
        int i = a2.f;
        int i2 = a2.g;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < a2.g; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = a2.h;
                if (i6 >= i7) {
                    break;
                }
                int i8 = a2.i[(i7 * i5) + i6];
                if (i8 != 0) {
                    if (i5 < i2) {
                        i2 = i5;
                    }
                    if (i5 > i4) {
                        i4 = i5;
                    }
                    int i9 = i6 << 5;
                    if (i9 < i) {
                        int i10 = 0;
                        while ((i8 << (31 - i10)) == 0) {
                            i10++;
                        }
                        int i11 = i10 + i9;
                        if (i11 < i) {
                            i = i11;
                        }
                    }
                    if (i9 + 31 > i3) {
                        int i12 = 31;
                        while ((i8 >>> i12) == 0) {
                            i12--;
                        }
                        int i13 = i9 + i12;
                        if (i13 > i3) {
                            i3 = i13;
                        }
                    }
                }
                i6++;
            }
        }
        int[] iArr = (i3 < i || i4 < i2) ? null : new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
        if (iArr != null) {
            int i14 = iArr[0];
            int i15 = iArr[1];
            int i16 = iArr[2];
            int i17 = iArr[3];
            int i18 = (30 + 31) / 32;
            int[] iArr2 = new int[(i18 * 33)];
            for (int i19 = 0; i19 < 33; i19++) {
                int i20 = (((i17 / 2) + (i19 * i17)) / 33) + i15;
                for (int i21 = 0; i21 < 30; i21++) {
                    if (a2.b((((((i19 & 1) * i16) / 2) + ((i16 / 2) + (i21 * i16))) / 30) + i14, i20)) {
                        int i22 = (i21 / 32) + (i19 * i18);
                        iArr2[i22] = (1 << (i21 & 31)) | iArr2[i22];
                    }
                }
            }
            s55 s55 = this.f2769a;
            Objects.requireNonNull(s55);
            byte[] bArr2 = new byte[144];
            for (int i23 = 0; i23 < 33; i23++) {
                int[] iArr3 = q55.f2900a[i23];
                for (int i24 = 0; i24 < 30; i24++) {
                    int i25 = iArr3[i24];
                    if (i25 >= 0) {
                        if (((iArr2[(i24 / 32) + (i23 * i18)] >>> (i24 & 31)) & 1) != 0) {
                            int i26 = i25 / 6;
                            bArr2[i26] = (byte) (((byte) (1 << (5 - (i25 % 6)))) | bArr2[i26]);
                        }
                    }
                }
            }
            s55.a(bArr2, 0, 10, 10, 0);
            int i27 = bArr2[0] & 15;
            if (i27 == 2 || i27 == 3 || i27 == 4) {
                s55.a(bArr2, 20, 84, 40, 1);
                s55.a(bArr2, 20, 84, 40, 2);
                bArr = new byte[94];
            } else if (i27 == 5) {
                s55.a(bArr2, 20, 68, 56, 1);
                s55.a(bArr2, 20, 68, 56, 2);
                bArr = new byte[78];
            } else {
                throw v25.a();
            }
            System.arraycopy(bArr2, 0, bArr, 0, 10);
            System.arraycopy(bArr2, 20, bArr, 10, bArr.length - 10);
            StringBuilder sb = new StringBuilder(144);
            if (i27 == 2 || i27 == 3) {
                if (i27 == 2) {
                    str = new DecimalFormat("0000000000".substring(0, r55.a(bArr, new byte[]{39, 40, 41, 42, 31, 32}))).format((long) r55.a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2}));
                } else {
                    String[] strArr = r55.f3046a;
                    str = String.valueOf(new char[]{strArr[0].charAt(r55.a(bArr, new byte[]{39, 40, 41, 42, 31, 32})), strArr[0].charAt(r55.a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), strArr[0].charAt(r55.a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), strArr[0].charAt(r55.a(bArr, new byte[]{21, 22, 23, 24, 13, 14})), strArr[0].charAt(r55.a(bArr, new byte[]{15, 16, 17, 18, 7, 8})), strArr[0].charAt(r55.a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
                }
                DecimalFormat decimalFormat = new DecimalFormat("000");
                String format = decimalFormat.format((long) r55.a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38}));
                String format2 = decimalFormat.format((long) r55.a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52}));
                sb.append(r55.b(bArr, 10, 84));
                if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                    sb.insert(9, str + (char) 29 + format + (char) 29 + format2 + (char) 29);
                } else {
                    sb.insert(0, str + (char) 29 + format + (char) 29 + format2 + (char) 29);
                }
            } else if (i27 == 4) {
                sb.append(r55.b(bArr, 1, 93));
            } else if (i27 == 5) {
                sb.append(r55.b(bArr, 1, 77));
            }
            String sb2 = sb.toString();
            String valueOf = String.valueOf(i27);
            e35 e35 = new e35(sb2, bArr, b, o25.MAXICODE);
            if (valueOf != null) {
                e35.b(f35.ERROR_CORRECTION_LEVEL, valueOf);
            }
            return e35;
        }
        throw a35.h;
    }

    @Override // defpackage.c35
    public e35 b(q25 q25) throws a35, r25, v25 {
        return a(q25, null);
    }

    @Override // defpackage.c35
    public void c() {
    }
}
