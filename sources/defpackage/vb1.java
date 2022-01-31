package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/* renamed from: vb1  reason: default package */
/* compiled from: TagSpan */
public class vb1 extends ReplacementSpan {
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public int j;
    public int k;

    public vb1(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
        this.j = i6;
        this.k = i7;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        RectF rectF = new RectF(f2, (float) (this.j + i4), paint.measureText(charSequence.subSequence(i2, i3).toString()) + f2 + ((float) this.h) + ((float) this.i), (float) (i6 + this.k));
        paint.setColor(this.f);
        canvas.drawRect(rectF, paint);
        paint.setColor(this.g);
        canvas.drawText(charSequence, i2, i3, f2 + ((float) this.h), (float) (((int) ((rectF.top + rectF.bottom) / 2.0f)) - ((paint.getFontMetricsInt().descent + paint.getFontMetricsInt().ascent) / 2)), paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        return (int) (paint.measureText(charSequence.subSequence(i2, i3).toString()) + ((float) this.h) + ((float) this.i));
    }
}
