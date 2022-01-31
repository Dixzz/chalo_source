package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* renamed from: p6  reason: default package */
/* compiled from: WrappedDrawableState */
public final class p6 extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f2770a;
    public Drawable.ConstantState b;
    public ColorStateList c = null;
    public PorterDuff.Mode d = n6.l;

    public p6(p6 p6Var) {
        if (p6Var != null) {
            this.f2770a = p6Var.f2770a;
            this.b = p6Var.b;
            this.c = p6Var.c;
            this.d = p6Var.d;
        }
    }

    public int getChangingConfigurations() {
        int i = this.f2770a;
        Drawable.ConstantState constantState = this.b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return new o6(this, null);
    }

    public Drawable newDrawable(Resources resources) {
        return new o6(this, resources);
    }
}
