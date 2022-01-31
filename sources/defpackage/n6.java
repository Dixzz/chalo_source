package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* renamed from: n6  reason: default package */
/* compiled from: WrappedDrawableApi14 */
public class n6 extends Drawable implements Drawable.Callback, m6, l6 {
    public static final PorterDuff.Mode l = PorterDuff.Mode.SRC_IN;
    public int f;
    public PorterDuff.Mode g;
    public boolean h;
    public p6 i;
    public boolean j;
    public Drawable k;

    public n6(p6 p6Var, Resources resources) {
        Drawable.ConstantState constantState;
        this.i = p6Var;
        if (p6Var != null && (constantState = p6Var.b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    @Override // defpackage.m6
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            p6 p6Var = this.i;
            if (p6Var != null) {
                p6Var.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // defpackage.m6
    public final Drawable b() {
        return this.k;
    }

    public boolean c() {
        throw null;
    }

    public final boolean d(int[] iArr) {
        if (!c()) {
            return false;
        }
        p6 p6Var = this.i;
        ColorStateList colorStateList = p6Var.c;
        PorterDuff.Mode mode = p6Var.d;
        if (colorStateList == null || mode == null) {
            this.h = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.h && colorForState == this.f && mode == this.g)) {
                setColorFilter(colorForState, mode);
                this.f = colorForState;
                this.g = mode;
                this.h = true;
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        this.k.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        p6 p6Var = this.i;
        return changingConfigurations | (p6Var != null ? p6Var.getChangingConfigurations() : 0) | this.k.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        p6 p6Var = this.i;
        if (p6Var == null) {
            return null;
        }
        if (!(p6Var.b != null)) {
            return null;
        }
        p6Var.f2770a = getChangingConfigurations();
        return this.i;
    }

    public Drawable getCurrent() {
        return this.k.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.k.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.k.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return h.M(this.k);
    }

    public int getMinimumHeight() {
        return this.k.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.k.getMinimumWidth();
    }

    public int getOpacity() {
        return this.k.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.k.getPadding(rect);
    }

    public int[] getState() {
        return this.k.getState();
    }

    public Region getTransparentRegion() {
        return this.k.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.k.isAutoMirrored();
    }

    public boolean isStateful() {
        p6 p6Var;
        ColorStateList colorStateList = (!c() || (p6Var = this.i) == null) ? null : p6Var.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.k.isStateful();
    }

    public void jumpToCurrentState() {
        this.k.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.j && super.mutate() == this) {
            this.i = new p6(this.i);
            Drawable drawable = this.k;
            if (drawable != null) {
                drawable.mutate();
            }
            p6 p6Var = this.i;
            if (p6Var != null) {
                Drawable drawable2 = this.k;
                p6Var.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.j = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return h.s0(this.k, i2);
    }

    public boolean onLevelChange(int i2) {
        return this.k.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.k.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        this.k.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i2) {
        this.k.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.k.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.k.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.k.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return d(iArr) || this.k.setState(iArr);
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        throw null;
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.k.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public n6(Drawable drawable) {
        this.i = new p6(this.i);
        a(drawable);
    }
}
