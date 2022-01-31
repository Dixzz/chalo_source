package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class ClockHandView extends View {
    public static final /* synthetic */ int u = 0;
    public ValueAnimator f;
    public float g;
    public float h;
    public boolean i;
    public int j;
    public final List<c> k = new ArrayList();
    public final int l;
    public final float m;
    public final Paint n;
    public final RectF o;
    public final int p;
    public float q;
    public boolean r;
    public double s;
    public int t;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClockHandView clockHandView = ClockHandView.this;
            int i = ClockHandView.u;
            clockHandView.c(floatValue, true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b(ClockHandView clockHandView) {
        }

        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f, boolean z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClockHandView(android.content.Context r5, android.util.AttributeSet r6) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.timepicker.ClockHandView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f3 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    public void b(float f2, boolean z) {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            c(f2, false);
            return;
        }
        float f3 = this.q;
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f3), Float.valueOf(f2));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.f = ofFloat;
        ofFloat.setDuration(200L);
        this.f.addUpdateListener(new a());
        this.f.addListener(new b(this));
        this.f.start();
    }

    public final void c(float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.q = f3;
        this.s = Math.toRadians((double) (f3 - 90.0f));
        float cos = (((float) this.t) * ((float) Math.cos(this.s))) + ((float) (getWidth() / 2));
        float sin = (((float) this.t) * ((float) Math.sin(this.s))) + ((float) (getHeight() / 2));
        RectF rectF = this.o;
        int i2 = this.l;
        rectF.set(cos - ((float) i2), sin - ((float) i2), cos + ((float) i2), sin + ((float) i2));
        for (c cVar : this.k) {
            cVar.a(f3, z);
        }
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = (float) width;
        float f3 = (float) height;
        this.n.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.t) * ((float) Math.cos(this.s))) + f2, (((float) this.t) * ((float) Math.sin(this.s))) + f3, (float) this.l, this.n);
        double sin = Math.sin(this.s);
        double cos = Math.cos(this.s);
        double d = (double) ((float) (this.t - this.l));
        this.n.setStrokeWidth((float) this.p);
        canvas.drawLine(f2, f3, (float) (width + ((int) (cos * d))), (float) (height + ((int) (d * sin))), this.n);
        canvas.drawCircle(f2, f3, this.m, this.n);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b(this.q, false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.g);
                int i3 = (int) (y - this.h);
                this.i = (i3 * i3) + (i2 * i2) > this.j;
                z2 = this.r;
                if (actionMasked == 1) {
                }
            } else {
                z2 = false;
            }
            z = false;
        } else {
            this.g = x;
            this.h = y;
            this.i = true;
            this.r = false;
            z2 = false;
            z = true;
        }
        boolean z4 = this.r;
        float a2 = (float) a(x, y);
        boolean z5 = this.q != a2;
        if (!z || !z5) {
            if (z5 || z2) {
                b(a2, false);
            }
            this.r = z4 | z3;
            return true;
        }
        z3 = true;
        this.r = z4 | z3;
        return true;
    }
}
