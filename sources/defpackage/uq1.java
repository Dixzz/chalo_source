package defpackage;

import android.graphics.drawable.Drawable;
import java.util.Objects;

/* renamed from: uq1  reason: default package */
/* compiled from: DrawableResource */
public abstract class uq1<T extends Drawable> implements rn1<T>, on1 {
    public final T f;

    public uq1(T t) {
        Objects.requireNonNull(t, "Argument must not be null");
        this.f = t;
    }

    @Override // defpackage.rn1
    public Object get() {
        return this.f.getConstantState().newDrawable();
    }
}
