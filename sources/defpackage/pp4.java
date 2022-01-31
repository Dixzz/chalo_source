package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: pp4  reason: default package */
/* compiled from: CutoutDrawable */
public class pp4 extends ho4 {
    public final Paint D;
    public final RectF E;
    public int F;

    public pp4() {
        this(null);
    }

    @Override // defpackage.ho4
    public void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.F = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.E, this.D);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.F);
        }
    }

    public void z(float f, float f2, float f3, float f4) {
        RectF rectF = this.E;
        if (f != rectF.left || f2 != rectF.top || f3 != rectF.right || f4 != rectF.bottom) {
            rectF.set(f, f2, f3, f4);
            invalidateSelf();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public pp4(ko4 ko4) {
        super(ko4 == null ? new ko4() : ko4);
        Paint paint = new Paint(1);
        this.D = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.E = new RectF();
    }
}
