package defpackage;

import java.lang.reflect.Array;

/* renamed from: i85  reason: default package */
/* compiled from: PDF417CodewordDecoder */
public final class i85 {

    /* renamed from: a  reason: collision with root package name */
    public static final float[][] f1491a;

    static {
        int i;
        int[] iArr = w75.b;
        int length = iArr.length;
        int[] iArr2 = new int[2];
        iArr2[1] = 8;
        iArr2[0] = length;
        f1491a = (float[][]) Array.newInstance(float.class, iArr2);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i != i4) {
                        break;
                    }
                    f += 1.0f;
                    i3 >>= 1;
                }
                f1491a[i2][(8 - i5) - 1] = f / 17.0f;
                i5++;
                i4 = i;
            }
        }
    }
}
