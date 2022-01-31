package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* renamed from: xt1  reason: default package */
/* compiled from: ShimmerDrawable */
public final class xt1 extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f3962a = new a();
    public final Paint b;
    public final Rect c;
    public final Matrix d;
    public ValueAnimator e;
    public wt1 f;

    /* renamed from: xt1$a */
    /* compiled from: ShimmerDrawable */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            xt1.this.invalidateSelf();
        }
    }

    public xt1() {
        Paint paint = new Paint();
        this.b = paint;
        this.c = new Rect();
        this.d = new Matrix();
        paint.setAntiAlias(true);
    }

    public void a() {
        wt1 wt1;
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null && !valueAnimator.isStarted() && (wt1 = this.f) != null && wt1.o && getCallback() != null) {
            this.e.start();
        }
    }

    public final float b(float f2, float f3, float f4) {
        return hj1.a(f3, f2, f4, f2);
    }

    public final void c() {
        wt1 wt1;
        Shader shader;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width != 0 && height != 0 && (wt1 = this.f) != null) {
            int i = wt1.g;
            if (i <= 0) {
                i = Math.round(wt1.i * ((float) width));
            }
            wt1 wt12 = this.f;
            int i2 = wt12.h;
            if (i2 <= 0) {
                i2 = Math.round(wt12.j * ((float) height));
            }
            wt1 wt13 = this.f;
            boolean z = true;
            if (wt13.f != 1) {
                int i3 = wt13.c;
                if (!(i3 == 1 || i3 == 3)) {
                    z = false;
                }
                if (z) {
                    i = 0;
                }
                if (!z) {
                    i2 = 0;
                }
                wt1 wt14 = this.f;
                shader = new LinearGradient(0.0f, 0.0f, (float) i, (float) i2, wt14.b, wt14.f3835a, Shader.TileMode.CLAMP);
            } else {
                wt1 wt15 = this.f;
                shader = new RadialGradient(((float) i) / 2.0f, ((float) i2) / 2.0f, (float) (((double) Math.max(i, i2)) / Math.sqrt(2.0d)), wt15.b, wt15.f3835a, Shader.TileMode.CLAMP);
            }
            this.b.setShader(shader);
        }
    }

    public void draw(Canvas canvas) {
        float f2;
        float b2;
        if (this.f != null && this.b.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians((double) this.f.m));
            float width = (((float) this.c.width()) * tan) + ((float) this.c.height());
            float height = (tan * ((float) this.c.height())) + ((float) this.c.width());
            ValueAnimator valueAnimator = this.e;
            float f3 = 0.0f;
            float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
            int i = this.f.c;
            if (i != 1) {
                if (i == 2) {
                    b2 = b(height, -height, animatedFraction);
                } else if (i != 3) {
                    b2 = b(-height, height, animatedFraction);
                } else {
                    f2 = b(width, -width, animatedFraction);
                }
                f3 = b2;
                f2 = 0.0f;
            } else {
                f2 = b(-width, width, animatedFraction);
            }
            this.d.reset();
            this.d.setRotate(this.f.m, ((float) this.c.width()) / 2.0f, ((float) this.c.height()) / 2.0f);
            this.d.postTranslate(f3, f2);
            this.b.getShader().setLocalMatrix(this.d);
            canvas.drawRect(this.c, this.b);
        }
    }

    public int getOpacity() {
        wt1 wt1 = this.f;
        return (wt1 == null || (!wt1.n && !wt1.p)) ? -1 : -3;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c.set(0, 0, rect.width(), rect.height());
        c();
        a();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
