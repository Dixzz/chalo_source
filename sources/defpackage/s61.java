package defpackage;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: s61  reason: default package */
/* compiled from: ScreenAnimationUtils.kt */
public final class s61 extends Animation {
    public final /* synthetic */ View f;
    public final /* synthetic */ int g;

    public s61(View view, int i) {
        this.f = view;
        this.g = i;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        this.f.getLayoutParams().height = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1)) == 0 ? -2 : (int) (((float) this.g) * f2);
        this.f.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
