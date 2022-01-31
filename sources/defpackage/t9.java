package defpackage;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* renamed from: t9  reason: default package */
/* compiled from: ScrollerCompat */
public final class t9 {

    /* renamed from: a  reason: collision with root package name */
    public OverScroller f3320a;

    public t9(Context context, Interpolator interpolator) {
        this.f3320a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public int a() {
        return this.f3320a.getCurrX();
    }

    @Deprecated
    public int b() {
        return this.f3320a.getCurrY();
    }
}
