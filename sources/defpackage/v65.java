package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: v65  reason: default package */
/* compiled from: AbstractRSSReader */
public abstract class v65 extends k65 {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3611a = new int[4];
    public final int[] b;
    public final float[] c;
    public final float[] d;
    public final int[] e;
    public final int[] f;

    public v65() {
        int[] iArr = new int[8];
        this.b = iArr;
        this.c = new float[4];
        this.d = new float[4];
        this.e = new int[(iArr.length / 2)];
        this.f = new int[(iArr.length / 2)];
    }

    public static void i(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    public static void j(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    public static boolean k(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f2 = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i2 = Integer.MAX_VALUE;
            int i3 = RtlSpacingHelper.UNDEFINED;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int l(int[] iArr, int[][] iArr2) throws a35 {
        for (int i = 0; i < iArr2.length; i++) {
            if (k65.f(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw a35.h;
    }
}
