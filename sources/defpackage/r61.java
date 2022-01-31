package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: r61  reason: default package */
/* compiled from: ScreenAnimationUtils.kt */
public final class r61 extends Animation {
    public final /* synthetic */ View f;
    public final /* synthetic */ int g;

    public r61(View view, int i) {
        this.f = view;
        this.g = i;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        if (f2 == 1.0f) {
            this.f.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        int i = this.g;
        layoutParams.height = i - ((int) (((float) i) * f2));
        this.f.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
