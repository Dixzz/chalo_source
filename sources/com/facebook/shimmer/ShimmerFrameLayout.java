package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.wt1;

public class ShimmerFrameLayout extends FrameLayout {
    public final Paint f = new Paint();
    public final xt1 g;
    public boolean h;

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        xt1 xt1 = new xt1();
        this.g = xt1;
        this.h = true;
        setWillNotDraw(false);
        xt1.setCallback(this);
        if (attributeSet == null) {
            a(new wt1.a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            int i = R.styleable.ShimmerFrameLayout_shimmer_colored;
            a(((!obtainStyledAttributes.hasValue(i) || !obtainStyledAttributes.getBoolean(i, false)) ? new wt1.a() : new wt1.c()).b(obtainStyledAttributes).a());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ShimmerFrameLayout a(wt1 wt1) {
        boolean z;
        xt1 xt1 = this.g;
        xt1.f = wt1;
        if (wt1 != null) {
            xt1.b.setXfermode(new PorterDuffXfermode(xt1.f.p ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        xt1.c();
        if (xt1.f != null) {
            ValueAnimator valueAnimator = xt1.e;
            if (valueAnimator != null) {
                z = valueAnimator.isStarted();
                xt1.e.cancel();
                xt1.e.removeAllUpdateListeners();
            } else {
                z = false;
            }
            wt1 wt12 = xt1.f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (wt12.t / wt12.s)) + 1.0f);
            xt1.e = ofFloat;
            ofFloat.setRepeatMode(xt1.f.r);
            xt1.e.setRepeatCount(xt1.f.q);
            ValueAnimator valueAnimator2 = xt1.e;
            wt1 wt13 = xt1.f;
            valueAnimator2.setDuration(wt13.s + wt13.t);
            xt1.e.addUpdateListener(xt1.f3962a);
            if (z) {
                xt1.e.start();
            }
        }
        xt1.invalidateSelf();
        if (wt1 == null || !wt1.n) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.f);
        }
        return this;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.h) {
            this.g.draw(canvas);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g.a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xt1 xt1 = this.g;
        ValueAnimator valueAnimator = xt1.e;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            xt1.e.cancel();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.g.setBounds(0, 0, getWidth(), getHeight());
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.g;
    }
}
