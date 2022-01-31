package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import defpackage.lo4;

public class ShapeableImageView extends AppCompatImageView implements oo4 {
    public static final int x = R.style.Widget_MaterialComponents_ShapeableImageView;
    public final lo4 f = lo4.a.f2250a;
    public final RectF g;
    public final RectF h;
    public final Paint i;
    public final Paint j;
    public final Path k = new Path();
    public ColorStateList l;
    public ho4 m;
    public ko4 n;
    public float o;
    public Path p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public boolean w = false;

    @TargetApi(21)
    public class a extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f629a = new Rect();

        public a() {
        }

        public void getOutline(View view, Outline outline) {
            ShapeableImageView shapeableImageView = ShapeableImageView.this;
            if (shapeableImageView.n != null) {
                if (shapeableImageView.m == null) {
                    shapeableImageView.m = new ho4(ShapeableImageView.this.n);
                }
                ShapeableImageView.this.g.round(this.f629a);
                ShapeableImageView.this.m.setBounds(this.f629a);
                ShapeableImageView.this.m.getOutline(outline);
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShapeableImageView(android.content.Context r7, android.util.AttributeSet r8) {
        /*
        // Method dump skipped, instructions count: 197
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final boolean a() {
        return (this.u == Integer.MIN_VALUE && this.v == Integer.MIN_VALUE) ? false : true;
    }

    public final boolean b() {
        return getLayoutDirection() == 1;
    }

    public final void c(int i2, int i3) {
        this.g.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        this.f.a(this.n, 1.0f, this.g, null, this.k);
        this.p.rewind();
        this.p.addPath(this.k);
        this.h.set(0.0f, 0.0f, (float) i2, (float) i3);
        this.p.addRect(this.h, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.t;
    }

    public final int getContentPaddingEnd() {
        int i2 = this.v;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return b() ? this.q : this.s;
    }

    public int getContentPaddingLeft() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.v) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.u) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.q;
    }

    public int getContentPaddingRight() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.u) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.v) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.s;
    }

    public final int getContentPaddingStart() {
        int i2 = this.u;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return b() ? this.s : this.q;
    }

    public int getContentPaddingTop() {
        return this.r;
    }

    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public ko4 getShapeAppearanceModel() {
        return this.n;
    }

    public ColorStateList getStrokeColor() {
        return this.l;
    }

    public float getStrokeWidth() {
        return this.o;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.p, this.j);
        if (this.l != null) {
            this.i.setStrokeWidth(this.o);
            int colorForState = this.l.getColorForState(getDrawableState(), this.l.getDefaultColor());
            if (this.o > 0.0f && colorForState != 0) {
                this.i.setColor(colorForState);
                canvas.drawPath(this.k, this.i);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!this.w && isLayoutDirectionResolved()) {
            this.w = true;
            if (isPaddingRelative() || a()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        c(i2, i3);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(getContentPaddingLeft() + i2, getContentPaddingTop() + i3, getContentPaddingRight() + i4, getContentPaddingBottom() + i5);
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(getContentPaddingStart() + i2, getContentPaddingTop() + i3, getContentPaddingEnd() + i4, getContentPaddingBottom() + i5);
    }

    @Override // defpackage.oo4
    public void setShapeAppearanceModel(ko4 ko4) {
        this.n = ko4;
        ho4 ho4 = this.m;
        if (ho4 != null) {
            ho4.f.f1403a = ko4;
            ho4.invalidateSelf();
        }
        c(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.l = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i2) {
        setStrokeColor(u0.a(getContext(), i2));
    }

    public void setStrokeWidth(float f2) {
        if (this.o != f2) {
            this.o = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i2) {
        setStrokeWidth((float) getResources().getDimensionPixelSize(i2));
    }
}
