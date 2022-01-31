package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialCardView extends CardView implements Checkable, oo4 {
    public static final int[] k = {16842911};
    public static final int[] l = {16842912};
    public static final int[] m = {R.attr.state_dragged};
    public static final int n = R.style.Widget_MaterialComponents_CardView;
    public final jl4 f;
    public boolean g = true;
    public boolean h = false;
    public boolean i = false;
    public a j;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r9, android.util.AttributeSet r10) {
        /*
        // Method dump skipped, instructions count: 274
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f.c.getBounds());
        return rectF;
    }

    public final void c() {
        jl4 jl4;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (jl4 = this.f).n) != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            jl4.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            jl4.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    public boolean d() {
        jl4 jl4 = this.f;
        return jl4 != null && jl4.s;
    }

    public void e(int i2, int i3, int i4, int i5) {
        super.setContentPadding(i2, i3, i4, i5);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f.c.f.d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f.d.f.d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f.i;
    }

    public int getCheckedIconMargin() {
        return this.f.e;
    }

    public int getCheckedIconSize() {
        return this.f.f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f.k;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f.b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f.b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f.b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f.b.top;
    }

    public float getProgress() {
        return this.f.c.f.k;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f.c.l();
    }

    public ColorStateList getRippleColor() {
        return this.f.j;
    }

    public ko4 getShapeAppearanceModel() {
        return this.f.l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f.m;
    }

    public int getStrokeWidth() {
        return this.f.g;
    }

    public boolean isChecked() {
        return this.h;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hd3.N2(this, this.f.c);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (d()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, k);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, l);
        }
        if (this.i) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, m);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(d());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        jl4 jl4 = this.f;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (jl4.o != null) {
            int i6 = jl4.e;
            int i7 = jl4.f;
            int i8 = (measuredWidth - i6) - i7;
            int i9 = (measuredHeight - i6) - i7;
            if (jl4.f1952a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil((double) (jl4.d() * 2.0f));
                i8 -= (int) Math.ceil((double) (jl4.c() * 2.0f));
            }
            int i10 = jl4.e;
            MaterialCardView materialCardView = jl4.f1952a;
            AtomicInteger atomicInteger = r8.f3055a;
            if (materialCardView.getLayoutDirection() == 1) {
                i4 = i8;
                i5 = i10;
            } else {
                i5 = i8;
                i4 = i10;
            }
            jl4.o.setLayerInset(2, i5, jl4.e, i4, i9);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.g) {
            jl4 jl4 = this.f;
            if (!jl4.r) {
                jl4.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i2) {
        jl4 jl4 = this.f;
        jl4.c.q(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        jl4 jl4 = this.f;
        jl4.c.p(jl4.f1952a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        ho4 ho4 = this.f.d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        ho4.q(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f.s = z;
    }

    public void setChecked(boolean z) {
        if (this.h != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f.g(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f.e = i2;
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f.e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f.g(u0.b(getContext(), i2));
    }

    public void setCheckedIconSize(int i2) {
        this.f.f = i2;
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f.f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        jl4 jl4 = this.f;
        jl4.k = colorStateList;
        Drawable drawable = jl4.i;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        jl4 jl4 = this.f;
        if (jl4 != null) {
            Drawable drawable = jl4.h;
            Drawable e = jl4.f1952a.isClickable() ? jl4.e() : jl4.d;
            jl4.h = e;
            if (drawable == e) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23 || !(jl4.f1952a.getForeground() instanceof InsetDrawable)) {
                jl4.f1952a.setForeground(jl4.f(e));
            } else {
                ((InsetDrawable) jl4.f1952a.getForeground()).setDrawable(e);
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i2, int i3, int i4, int i5) {
        jl4 jl4 = this.f;
        jl4.b.set(i2, i3, i4, i5);
        jl4.k();
    }

    public void setDragged(boolean z) {
        if (this.i != z) {
            this.i = z;
            refreshDrawableState();
            c();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f.l();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.j = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f.l();
        this.f.k();
    }

    public void setProgress(float f2) {
        jl4 jl4 = this.f;
        jl4.c.r(f2);
        ho4 ho4 = jl4.d;
        if (ho4 != null) {
            ho4.r(f2);
        }
        ho4 ho42 = jl4.q;
        if (ho42 != null) {
            ho42.r(f2);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        jl4 jl4 = this.f;
        jl4.h(jl4.l.e(f2));
        jl4.h.invalidateSelf();
        if (jl4.j() || jl4.i()) {
            jl4.k();
        }
        if (jl4.j()) {
            jl4.l();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        jl4 jl4 = this.f;
        jl4.j = colorStateList;
        jl4.m();
    }

    public void setRippleColorResource(int i2) {
        jl4 jl4 = this.f;
        jl4.j = u0.a(getContext(), i2);
        jl4.m();
    }

    @Override // defpackage.oo4
    public void setShapeAppearanceModel(ko4 ko4) {
        setClipToOutline(ko4.d(getBoundsAsRectF()));
        this.f.h(ko4);
    }

    public void setStrokeColor(int i2) {
        jl4 jl4 = this.f;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (jl4.m != valueOf) {
            jl4.m = valueOf;
            jl4.n();
        }
    }

    public void setStrokeWidth(int i2) {
        jl4 jl4 = this.f;
        if (i2 != jl4.g) {
            jl4.g = i2;
            jl4.n();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f.l();
        this.f.k();
    }

    public void toggle() {
        if (d() && isEnabled()) {
            this.h = !this.h;
            refreshDrawableState();
            c();
            a aVar = this.j;
            if (aVar != null) {
                aVar.a(this, this.h);
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f.c.q(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        jl4 jl4 = this.f;
        if (jl4.m != colorStateList) {
            jl4.m = colorStateList;
            jl4.n();
        }
    }
}
