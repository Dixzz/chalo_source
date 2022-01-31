package defpackage;

import android.graphics.RectF;

/* renamed from: yf5  reason: default package */
/* compiled from: CropWindowHandler */
public final class yf5 {

    /* renamed from: a  reason: collision with root package name */
    public final RectF f4044a = new RectF();
    public final RectF b = new RectF();
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k = 1.0f;
    public float l = 1.0f;

    public static boolean f(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 > f4 && f2 < f6 && f3 > f5 && f3 < f7;
    }

    public static boolean g(float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f2 - f4) <= f6 && Math.abs(f3 - f5) <= f6;
    }

    public static boolean h(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 > f4 && f2 < f5 && Math.abs(f3 - f6) <= f7;
    }

    public static boolean i(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Math.abs(f2 - f4) <= f7 && f3 > f5 && f3 < f6;
    }

    public float a() {
        return Math.min(this.f, this.j / this.l);
    }

    public float b() {
        return Math.min(this.e, this.i / this.k);
    }

    public float c() {
        return Math.max(this.d, this.h / this.l);
    }

    public float d() {
        return Math.max(this.c, this.g / this.k);
    }

    public RectF e() {
        this.b.set(this.f4044a);
        return this.b;
    }

    public boolean j() {
        return this.f4044a.width() >= 100.0f && this.f4044a.height() >= 100.0f;
    }
}
