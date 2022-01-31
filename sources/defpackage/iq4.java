package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

/* renamed from: iq4  reason: default package */
/* compiled from: FabTransformationBehavior */
public class iq4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1560a;

    public iq4(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f1560a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1560a.invalidate();
    }
}
