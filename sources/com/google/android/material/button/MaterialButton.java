package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import defpackage.ho4;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialButton extends AppCompatButton implements Checkable, oo4 {
    public static final int[] s = {16842911};
    public static final int[] t = {16842912};
    public static final int u = R.style.Widget_MaterialComponents_Button;
    public final il4 f;
    public final LinkedHashSet<a> g = new LinkedHashSet<>();
    public b h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public Drawable k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public int r;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean f;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                SavedState.class.getClassLoader();
            }
            this.f = parcel.readInt() != 1 ? false : true;
        }
    }

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(android.content.Context r10, android.util.AttributeSet r11) {
        /*
        // Method dump skipped, instructions count: 344
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public boolean a() {
        il4 il4 = this.f;
        return il4 != null && il4.q;
    }

    public final boolean b() {
        int i2 = this.r;
        return i2 == 3 || i2 == 4;
    }

    public final boolean c() {
        int i2 = this.r;
        return i2 == 1 || i2 == 2;
    }

    public final boolean d() {
        int i2 = this.r;
        return i2 == 16 || i2 == 32;
    }

    public final boolean e() {
        il4 il4 = this.f;
        return il4 != null && !il4.o;
    }

    public final void f() {
        if (c()) {
            setCompoundDrawablesRelative(this.k, null, null, null);
        } else if (b()) {
            setCompoundDrawablesRelative(null, null, this.k, null);
        } else if (d()) {
            setCompoundDrawablesRelative(null, this.k, null, null);
        }
    }

    public final void g(boolean z) {
        Drawable drawable = this.k;
        if (drawable != null) {
            Drawable mutate = h.H0(drawable).mutate();
            this.k = mutate;
            mutate.setTintList(this.j);
            PorterDuff.Mode mode = this.i;
            if (mode != null) {
                this.k.setTintMode(mode);
            }
            int i2 = this.l;
            if (i2 == 0) {
                i2 = this.k.getIntrinsicWidth();
            }
            int i3 = this.l;
            if (i3 == 0) {
                i3 = this.k.getIntrinsicHeight();
            }
            Drawable drawable2 = this.k;
            int i4 = this.m;
            int i5 = this.n;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
        }
        if (z) {
            f();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((c() && drawable3 != this.k) || ((b() && drawable5 != this.k) || (d() && drawable4 != this.k))) {
            z2 = true;
        }
        if (z2) {
            f();
        }
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (e()) {
            return this.f.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.k;
    }

    public int getIconGravity() {
        return this.r;
    }

    public int getIconPadding() {
        return this.o;
    }

    public int getIconSize() {
        return this.l;
    }

    public ColorStateList getIconTint() {
        return this.j;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.i;
    }

    public int getInsetBottom() {
        return this.f.f;
    }

    public int getInsetTop() {
        return this.f.e;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f.l;
        }
        return null;
    }

    public ko4 getShapeAppearanceModel() {
        if (e()) {
            return this.f.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f.h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        if (e()) {
            return this.f.j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (e()) {
            return this.f.i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public final void h(int i2, int i3) {
        if (this.k != null && getLayout() != null) {
            if (c() || b()) {
                this.n = 0;
                int i4 = this.r;
                boolean z = true;
                if (i4 == 1 || i4 == 3) {
                    this.m = 0;
                    g(false);
                    return;
                }
                int i5 = this.l;
                if (i5 == 0) {
                    i5 = this.k.getIntrinsicWidth();
                }
                int textWidth = i2 - getTextWidth();
                AtomicInteger atomicInteger = r8.f3055a;
                int paddingEnd = ((((textWidth - getPaddingEnd()) - i5) - this.o) - getPaddingStart()) / 2;
                boolean z2 = getLayoutDirection() == 1;
                if (this.r != 4) {
                    z = false;
                }
                if (z2 != z) {
                    paddingEnd = -paddingEnd;
                }
                if (this.m != paddingEnd) {
                    this.m = paddingEnd;
                    g(false);
                }
            } else if (d()) {
                this.m = 0;
                if (this.r == 16) {
                    this.n = 0;
                    g(false);
                    return;
                }
                int i6 = this.l;
                if (i6 == 0) {
                    i6 = this.k.getIntrinsicHeight();
                }
                int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i6) - this.o) - getPaddingBottom()) / 2;
                if (this.n != textHeight) {
                    this.n = textHeight;
                    g(false);
                }
            }
        }
    }

    public boolean isChecked() {
        return this.p;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            hd3.N2(this, this.f.b());
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, s);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, t);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        il4 il4;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (il4 = this.f) != null) {
            int i6 = i5 - i3;
            int i7 = i4 - i2;
            Drawable drawable = il4.m;
            if (drawable != null) {
                drawable.setBounds(il4.c, il4.e, i7 - il4.d, i6 - il4.f);
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f = this.p;
        return savedState;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        h(i2, i3);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (e()) {
            il4 il4 = this.f;
            if (il4.b() != null) {
                il4.b().setTint(i2);
                return;
            }
            return;
        }
        super.setBackgroundColor(i2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundDrawable(Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            il4 il4 = this.f;
            il4.o = true;
            il4.f1533a.setSupportBackgroundTintList(il4.j);
            il4.f1533a.setSupportBackgroundTintMode(il4.i);
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? u0.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.f.q = z;
        }
    }

    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.p != z) {
            this.p = z;
            refreshDrawableState();
            if (!this.q) {
                this.q = true;
                Iterator<a> it = this.g.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.p);
                }
                this.q = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (e()) {
            il4 il4 = this.f;
            if (!il4.p || il4.g != i2) {
                il4.g = i2;
                il4.p = true;
                il4.e(il4.b.e((float) i2));
            }
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (e()) {
            ho4 b2 = this.f.b();
            ho4.b bVar = b2.f;
            if (bVar.o != f2) {
                bVar.o = f2;
                b2.y();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.k != drawable) {
            this.k = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.r != i2) {
            this.r = i2;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i2) {
        if (this.o != i2) {
            this.o = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? u0.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.l != i2) {
            this.l = i2;
            g(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(u0.a(getContext(), i2));
    }

    public void setInsetBottom(int i2) {
        il4 il4 = this.f;
        il4.f(il4.e, i2);
    }

    public void setInsetTop(int i2) {
        il4 il4 = this.f;
        il4.f(i2, il4.f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.h = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.h;
        if (bVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            il4 il4 = this.f;
            if (il4.l != colorStateList) {
                il4.l = colorStateList;
                if (il4.f1533a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) il4.f1533a.getBackground()).setColor(yn4.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i2) {
        if (e()) {
            setRippleColor(u0.a(getContext(), i2));
        }
    }

    @Override // defpackage.oo4
    public void setShapeAppearanceModel(ko4 ko4) {
        if (e()) {
            this.f.e(ko4);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            il4 il4 = this.f;
            il4.n = z;
            il4.h();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            il4 il4 = this.f;
            if (il4.k != colorStateList) {
                il4.k = colorStateList;
                il4.h();
            }
        }
    }

    public void setStrokeColorResource(int i2) {
        if (e()) {
            setStrokeColor(u0.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (e()) {
            il4 il4 = this.f;
            if (il4.h != i2) {
                il4.h = i2;
                il4.h();
            }
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (e()) {
            il4 il4 = this.f;
            if (il4.j != colorStateList) {
                il4.j = colorStateList;
                if (il4.b() != null) {
                    il4.b().setTintList(il4.j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (e()) {
            il4 il4 = this.f;
            if (il4.i != mode) {
                il4.i = mode;
                if (il4.b() != null && il4.i != null) {
                    il4.b().setTintMode(il4.i);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    public void toggle() {
        setChecked(!this.p);
    }
}
