package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* renamed from: ys5  reason: default package */
/* compiled from: BorderRadius */
public final class ys5 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ WeakReference f;
    public final /* synthetic */ float g;
    public final /* synthetic */ int h;

    public ys5(WeakReference weakReference, float f2, int i) {
        this.f = weakReference;
        this.g = f2;
        this.h = i;
    }

    public boolean onPreDraw() {
        View view = (View) this.f.get();
        if (view == null) {
            return false;
        }
        hd3.n(view, this.g, this.h);
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
