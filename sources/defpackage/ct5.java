package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* renamed from: ct5  reason: default package */
/* compiled from: InAppViewUtils */
public class ct5 extends ImageSpan {
    public ct5(Drawable drawable) {
        super(drawable);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        Drawable drawable = getDrawable();
        canvas.translate(f, (float) ((i5 - drawable.getBounds().bottom) - (paint.getFontMetricsInt().descent / 2)));
        drawable.draw(canvas);
        canvas.restore();
    }
}
