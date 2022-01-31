package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;

/* renamed from: wa1  reason: default package */
/* compiled from: GifTopImageSpan.kt */
public final class wa1 extends ImageSpan implements Drawable.Callback {
    public final View f;
    public final float g;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public wa1(android.content.Context r4, android.view.View r5, int r6, float r7) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            defpackage.n86.e(r4, r0)
            android.content.res.Resources r1 = r4.getResources()
            int r2 = defpackage.wn6.x
            wn6 r2 = new wn6     // Catch:{ IOException -> 0x0011 }
            r2.<init>(r1, r6)     // Catch:{ IOException -> 0x0011 }
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            defpackage.n86.c(r2)
            java.lang.String r6 = "createFromResource(conte….resources, resourceId)!!"
            defpackage.n86.d(r2, r6)
            defpackage.n86.e(r4, r0)
            java.lang.String r4 = "gifDrawable"
            defpackage.n86.e(r2, r4)
            r3.<init>(r2)
            r3.f = r5
            r3.g = r7
            int r4 = r2.v
            int r5 = r2.w
            r6 = 0
            r2.setBounds(r6, r6, r4, r5)
            r2.setCallback(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wa1.<init>(android.content.Context, android.view.View, int, float):void");
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        n86.e(canvas, "canvas");
        n86.e(charSequence, "text");
        n86.e(paint, "paint");
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f2, (float) ((i5 - drawable.getBounds().bottom) - ((int) (this.g * ((float) paint.getFontMetricsInt().descent)))));
        drawable.draw(canvas);
        canvas.restore();
    }

    public void invalidateDrawable(Drawable drawable) {
        n86.e(drawable, "who");
        View view = this.f;
        if (view != null) {
            view.invalidate();
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        n86.e(drawable, "who");
        n86.e(runnable, "what");
        View view = this.f;
        if (view != null) {
            view.postDelayed(runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        n86.e(drawable, "who");
        n86.e(runnable, "what");
        View view = this.f;
        if (view != null) {
            view.removeCallbacks(runnable);
        }
    }
}
