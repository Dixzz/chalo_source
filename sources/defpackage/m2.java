package defpackage;

import android.graphics.drawable.Drawable;

/* renamed from: m2  reason: default package */
/* compiled from: RoundRectDrawableWithShadow */
public class m2 extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public static final double f2310a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        return (float) (((1.0d - f2310a) * ((double) f2)) + ((double) f));
    }

    public static float b(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        return (float) (((1.0d - f2310a) * ((double) f2)) + ((double) (f * 1.5f)));
    }
}
