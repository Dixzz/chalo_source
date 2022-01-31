package defpackage;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* renamed from: k65  reason: default package */
/* compiled from: OneDReader */
public abstract class k65 implements c35 {
    public static float f(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static void g(e45 e45, int i, int[] iArr) throws a35 {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i3 = e45.g;
        if (i < i3) {
            boolean z = !e45.e(i);
            while (i < i3) {
                if (e45.e(i) == z) {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    z = !z;
                } else {
                    iArr[i2] = iArr[i2] + 1;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != i3) {
                throw a35.h;
            }
            return;
        }
        throw a35.h;
    }

    public static void h(e45 e45, int i, int[] iArr) throws a35 {
        int length = iArr.length;
        boolean e = e45.e(i);
        while (i > 0 && length >= 0) {
            i--;
            if (e45.e(i) != e) {
                length--;
                e = !e;
            }
        }
        if (length < 0) {
            g(e45, i + 1, iArr);
            return;
        }
        throw a35.h;
    }

    @Override // defpackage.c35
    public e35 a(q25 q25, Map<s25, ?> map) throws a35, v25 {
        try {
            return e(q25, map);
        } catch (a35 e) {
            if (!(map != null && map.containsKey(s25.TRY_HARDER)) || !q25.f2888a.f2760a.d()) {
                throw e;
            }
            x25 e2 = q25.f2888a.f2760a.e();
            Objects.requireNonNull((l45) q25.f2888a);
            q25 q252 = new q25(new l45(e2));
            e35 e3 = e(q252, map);
            Map<f35, Object> map2 = e3.e;
            int i = 270;
            if (map2 != null) {
                f35 f35 = f35.ORIENTATION;
                if (map2.containsKey(f35)) {
                    i = (((Integer) map2.get(f35)).intValue() + 270) % 360;
                }
            }
            e3.b(f35.ORIENTATION, Integer.valueOf(i));
            g35[] g35Arr = e3.c;
            if (g35Arr != null) {
                int i2 = q252.f2888a.f2760a.b;
                for (int i3 = 0; i3 < g35Arr.length; i3++) {
                    g35Arr[i3] = new g35((((float) i2) - g35Arr[i3].b) - 1.0f, g35Arr[i3].f1210a);
                }
            }
            return e3;
        }
    }

    @Override // defpackage.c35
    public e35 b(q25 q25) throws a35, v25 {
        return a(q25, null);
    }

    @Override // defpackage.c35
    public void c() {
    }

    public abstract e35 d(int i, e45 e45, Map<s25, ?> map) throws a35, r25, v25;

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d A[Catch:{ d35 -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.e35 e(defpackage.q25 r20, java.util.Map<defpackage.s25, ?> r21) throws defpackage.a35 {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k65.e(q25, java.util.Map):e35");
    }
}
