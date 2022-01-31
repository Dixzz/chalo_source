package defpackage;

/* renamed from: l96  reason: default package */
/* compiled from: _Ranges.kt */
public class l96 {
    public static final float a(float f, float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
        } else if (f < f2) {
            return f2;
        } else {
            return f > f3 ? f3 : f;
        }
    }

    public static final int b(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        } else if (i < i2) {
            return i2;
        } else {
            return i > i3 ? i3 : i;
        }
    }

    public static final i96 c(int i, int i2) {
        return new i96(i, i2, -1);
    }

    public static final i96 d(i96 i96, int i) {
        n86.e(i96, "$this$step");
        boolean z = i > 0;
        Integer valueOf = Integer.valueOf(i);
        n86.e(valueOf, "step");
        if (z) {
            int i2 = i96.f;
            int i3 = i96.g;
            if (i96.h <= 0) {
                i = -i;
            }
            return new i96(i2, i3, i);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + valueOf + '.');
    }

    public static final k96 e(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new k96(i, i2 - 1);
        }
        k96 k96 = k96.j;
        return k96.i;
    }
}
