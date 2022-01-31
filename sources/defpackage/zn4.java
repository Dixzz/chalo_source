package defpackage;

import android.graphics.Paint;
import android.graphics.Path;

/* renamed from: zn4  reason: default package */
/* compiled from: ShadowRenderer */
public class zn4 {
    public static final int[] i = new int[3];
    public static final float[] j = {0.0f, 0.5f, 1.0f};
    public static final int[] k = new int[4];
    public static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f4191a = new Paint();
    public final Paint b;
    public final Paint c;
    public int d;
    public int e;
    public int f;
    public final Path g = new Path();
    public Paint h = new Paint();

    public zn4() {
        a(-16777216);
        this.h.setColor(0);
        Paint paint = new Paint(4);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint);
    }

    public void a(int i2) {
        this.d = a6.c(i2, 68);
        this.e = a6.c(i2, 20);
        this.f = a6.c(i2, 0);
        this.f4191a.setColor(this.d);
    }
}
