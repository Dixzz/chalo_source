package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* renamed from: dl1  reason: default package */
/* compiled from: ViewFinderView */
public final class dl1 extends View {
    public final Paint f;
    public final Paint g;
    public final Path h;
    public yk1 i;
    public int j = 0;
    public int k = 0;
    public float l = 1.0f;
    public float m = 1.0f;
    public float n = 0.75f;

    public dl1(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.f = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        this.h = path;
    }

    public final void a() {
        b(getWidth(), getHeight());
    }

    public final void b(int i2, int i3) {
        int i4;
        int i5;
        if (i2 > 0 && i3 > 0) {
            float f2 = (float) i2;
            float f3 = (float) i3;
            float f4 = this.l / this.m;
            if (f2 / f3 <= f4) {
                i5 = Math.round(f2 * this.n);
                i4 = Math.round(((float) i5) / f4);
            } else {
                i4 = Math.round(f3 * this.n);
                i5 = Math.round(((float) i4) * f4);
            }
            int i6 = (i2 - i5) / 2;
            int i7 = (i3 - i4) / 2;
            this.i = new yk1(i6, i7, i5 + i6, i4 + i7);
        }
    }

    public void onDraw(Canvas canvas) {
        yk1 yk1 = this.i;
        if (yk1 != null) {
            int width = getWidth();
            int height = getHeight();
            float f2 = (float) yk1.b;
            float f3 = (float) yk1.f4062a;
            float f4 = (float) yk1.c;
            float f5 = (float) yk1.d;
            float f6 = (float) this.j;
            float f7 = (float) this.k;
            Path path = this.h;
            if (f7 > 0.0f) {
                float min = Math.min(f7, Math.max(f6 - 1.0f, 0.0f));
                path.reset();
                float f8 = f2 + min;
                path.moveTo(f3, f8);
                float f9 = f3 + min;
                path.quadTo(f3, f2, f9, f2);
                float f10 = f4 - min;
                path.lineTo(f10, f2);
                path.quadTo(f4, f2, f4, f8);
                float f11 = f5 - min;
                path.lineTo(f4, f11);
                path.quadTo(f4, f5, f10, f5);
                path.lineTo(f9, f5);
                path.quadTo(f3, f5, f3, f11);
                path.lineTo(f3, f8);
                path.moveTo(0.0f, 0.0f);
                float f12 = (float) width;
                path.lineTo(f12, 0.0f);
                float f13 = (float) height;
                path.lineTo(f12, f13);
                path.lineTo(0.0f, f13);
                path.lineTo(0.0f, 0.0f);
                canvas.drawPath(path, this.f);
                path.reset();
                float f14 = f2 + f6;
                path.moveTo(f3, f14);
                path.lineTo(f3, f8);
                path.quadTo(f3, f2, f9, f2);
                float f15 = f3 + f6;
                path.lineTo(f15, f2);
                float f16 = f4 - f6;
                path.moveTo(f16, f2);
                path.lineTo(f10, f2);
                path.quadTo(f4, f2, f4, f8);
                path.lineTo(f4, f14);
                float f17 = f5 - f6;
                path.moveTo(f4, f17);
                path.lineTo(f4, f11);
                path.quadTo(f4, f5, f10, f5);
                path.lineTo(f16, f5);
                path.moveTo(f15, f5);
                path.lineTo(f9, f5);
                path.quadTo(f3, f5, f3, f11);
                path.lineTo(f3, f17);
                canvas.drawPath(path, this.g);
                return;
            }
            path.reset();
            path.moveTo(f3, f2);
            path.lineTo(f4, f2);
            path.lineTo(f4, f5);
            path.lineTo(f3, f5);
            path.lineTo(f3, f2);
            path.moveTo(0.0f, 0.0f);
            float f18 = (float) width;
            path.lineTo(f18, 0.0f);
            float f19 = (float) height;
            path.lineTo(f18, f19);
            path.lineTo(0.0f, f19);
            path.lineTo(0.0f, 0.0f);
            canvas.drawPath(path, this.f);
            path.reset();
            float f20 = f2 + f6;
            path.moveTo(f3, f20);
            path.lineTo(f3, f2);
            float f21 = f3 + f6;
            path.lineTo(f21, f2);
            float f22 = f4 - f6;
            path.moveTo(f22, f2);
            path.lineTo(f4, f2);
            path.lineTo(f4, f20);
            float f23 = f5 - f6;
            path.moveTo(f4, f23);
            path.lineTo(f4, f5);
            path.lineTo(f22, f5);
            path.moveTo(f21, f5);
            path.lineTo(f3, f5);
            path.lineTo(f3, f23);
            canvas.drawPath(path, this.g);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b(i4 - i2, i5 - i3);
    }
}
