package defpackage;

/* renamed from: g35  reason: default package */
/* compiled from: ResultPoint */
public class g35 {

    /* renamed from: a  reason: collision with root package name */
    public final float f1210a;
    public final float b;

    public g35(float f, float f2) {
        this.f1210a = f;
        this.b = f2;
    }

    public static float a(g35 g35, g35 g352) {
        return hd3.G0(g35.f1210a, g35.b, g352.f1210a, g352.b);
    }

    public static void b(g35[] g35Arr) {
        g35 g35;
        g35 g352;
        g35 g353;
        float a2 = a(g35Arr[0], g35Arr[1]);
        float a3 = a(g35Arr[1], g35Arr[2]);
        float a4 = a(g35Arr[0], g35Arr[2]);
        if (a3 >= a2 && a3 >= a4) {
            g353 = g35Arr[0];
            g352 = g35Arr[1];
            g35 = g35Arr[2];
        } else if (a4 < a3 || a4 < a2) {
            g353 = g35Arr[2];
            g352 = g35Arr[0];
            g35 = g35Arr[1];
        } else {
            g353 = g35Arr[1];
            g352 = g35Arr[0];
            g35 = g35Arr[2];
        }
        float f = g353.f1210a;
        float f2 = g353.b;
        if (((g352.b - f2) * (g35.f1210a - f)) - ((g352.f1210a - f) * (g35.b - f2)) < 0.0f) {
            g35 = g352;
            g352 = g35;
        }
        g35Arr[0] = g352;
        g35Arr[1] = g353;
        g35Arr[2] = g35;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g35) {
            g35 g35 = (g35) obj;
            if (this.f1210a == g35.f1210a && this.b == g35.b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + (Float.floatToIntBits(this.f1210a) * 31);
    }

    public final String toString() {
        return "(" + this.f1210a + ',' + this.b + ')';
    }
}
