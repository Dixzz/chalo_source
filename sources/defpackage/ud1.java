package defpackage;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: ud1  reason: default package */
/* compiled from: CircularProgressDrawable */
public class ud1 extends Drawable implements Animatable {
    public static final Interpolator r = new LinearInterpolator();
    public static final Interpolator s = new DecelerateInterpolator();
    public final RectF f = new RectF();
    public ObjectAnimator g;
    public ObjectAnimator h;
    public boolean i;
    public Paint j;
    public float k;
    public float l;
    public float m;
    public float n;
    public boolean o;
    public Property<ud1, Float> p = new a(this, Float.class, "angle");
    public Property<ud1, Float> q = new b(this, Float.class, "arc");

    /* renamed from: ud1$a */
    /* compiled from: CircularProgressDrawable */
    public class a extends Property<ud1, Float> {
        public a(ud1 ud1, Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(ud1 ud1) {
            return Float.valueOf(ud1.l);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(ud1 ud1, Float f) {
            ud1 ud12 = ud1;
            ud12.l = f.floatValue();
            ud12.invalidateSelf();
        }
    }

    /* renamed from: ud1$b */
    /* compiled from: CircularProgressDrawable */
    public class b extends Property<ud1, Float> {
        public b(ud1 ud1, Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(ud1 ud1) {
            return Float.valueOf(ud1.m);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(ud1 ud1, Float f) {
            ud1 ud12 = ud1;
            ud12.m = f.floatValue();
            ud12.invalidateSelf();
        }
    }

    public ud1(int i2, float f2) {
        this.n = f2;
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(f2);
        this.j.setColor(i2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.p, 360.0f);
        this.h = ofFloat;
        ofFloat.setInterpolator(r);
        this.h.setDuration(6000L);
        this.h.setRepeatMode(1);
        this.h.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.q, 300.0f);
        this.g = ofFloat2;
        ofFloat2.setInterpolator(s);
        this.g.setDuration(600L);
        this.g.setRepeatMode(1);
        this.g.setRepeatCount(-1);
        this.g.addListener(new vd1(this));
    }

    public void draw(Canvas canvas) {
        float f2;
        float f3 = this.l - this.k;
        float f4 = this.m;
        if (!this.i) {
            f3 += f4;
            f2 = (360.0f - f4) - 30.0f;
        } else {
            f2 = f4 + 30.0f;
        }
        canvas.drawArc(this.f, f3, f2, false, this.j);
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.o;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.f;
        float f2 = this.n;
        rectF.left = (f2 / 2.0f) + ((float) rect.left) + 0.5f;
        rectF.right = (((float) rect.right) - (f2 / 2.0f)) - 0.5f;
        rectF.top = (f2 / 2.0f) + ((float) rect.top) + 0.5f;
        rectF.bottom = (((float) rect.bottom) - (f2 / 2.0f)) - 0.5f;
    }

    public void setAlpha(int i2) {
        this.j.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.j.setColorFilter(colorFilter);
    }

    public void start() {
        if (!this.o) {
            this.o = true;
            this.h.start();
            this.g.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.o) {
            this.o = false;
            this.h.cancel();
            this.g.cancel();
            invalidateSelf();
        }
    }
}
