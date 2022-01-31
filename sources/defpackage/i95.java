package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: i95  reason: default package */
/* compiled from: AlignmentPatternFinder */
public final class i95 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f1498a;
    public final List<h95> b = new ArrayList(5);
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final int[] h;
    public final h35 i;

    public i95(f45 f45, int i2, int i3, int i4, int i5, float f2, h35 h35) {
        this.f1498a = f45;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = f2;
        this.h = new int[3];
        this.i = h35;
    }

    public static float a(int[] iArr, int i2) {
        return ((float) (i2 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    public final boolean b(int[] iArr) {
        float f2 = this.g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - ((float) iArr[i2])) >= f3) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0100 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.h95 c(int[] r13, int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i95.c(int[], int, int):h95");
    }
}
