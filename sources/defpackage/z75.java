package defpackage;

import java.lang.reflect.Array;

/* renamed from: z75  reason: default package */
/* compiled from: PDF417Writer */
public final class z75 implements i35 {
    public static f45 b(byte[][] bArr, int i) {
        int i2 = i * 2;
        f45 f45 = new f45(bArr[0].length + i2, bArr.length + i2);
        int length = f45.i.length;
        for (int i3 = 0; i3 < length; i3++) {
            f45.i[i3] = 0;
        }
        int i4 = (f45.g - i) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            byte[] bArr2 = bArr[i5];
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr2[i6] == 1) {
                    f45.f(i6 + i, i4);
                }
            }
            i5++;
            i4--;
        }
        return f45;
    }

    public static byte[][] c(byte[][] bArr) {
        int length = bArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = bArr.length;
        iArr[0] = length;
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i = 0; i < bArr.length; i++) {
            int length2 = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length2] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:197:0x042a A[LOOP:13: B:196:0x0428->B:197:0x042a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x044c  */
    @Override // defpackage.i35
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.f45 a(java.lang.String r22, defpackage.o25 r23, int r24, int r25, java.util.Map<defpackage.u25, ?> r26) throws defpackage.j35 {
        /*
        // Method dump skipped, instructions count: 1252
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z75.a(java.lang.String, o25, int, int, java.util.Map):f45");
    }
}
