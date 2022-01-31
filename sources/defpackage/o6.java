package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.Method;

/* renamed from: o6  reason: default package */
/* compiled from: WrappedDrawableApi21 */
public class o6 extends n6 {
    public static Method m;

    public o6(Drawable drawable) {
        super(drawable);
        if (m == null) {
            try {
                m = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // defpackage.n6
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.k;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public Rect getDirtyBounds() {
        return this.k.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.k.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.k;
        if (!(drawable == null || (method = m) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void setHotspot(float f, float f2) {
        this.k.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.k.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.n6
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // defpackage.n6
    public void setTint(int i) {
        if (c()) {
            super.setTint(i);
        } else {
            this.k.setTint(i);
        }
    }

    @Override // defpackage.n6
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            this.i.c = colorStateList;
            d(getState());
            return;
        }
        this.k.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.i.d = mode;
            d(getState());
            return;
        }
        this.k.setTintMode(mode);
    }

    public o6(p6 p6Var, Resources resources) {
        super(p6Var, resources);
        if (m == null) {
            try {
                m = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }
}
