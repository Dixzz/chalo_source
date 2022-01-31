package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* renamed from: dl4  reason: default package */
/* compiled from: BottomSheetBehavior */
public class dl4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f854a;

    public dl4(BottomSheetBehavior bottomSheetBehavior) {
        this.f854a = bottomSheetBehavior;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ho4 ho4 = this.f854a.i;
        if (ho4 != null) {
            ho4.r(floatValue);
        }
    }
}
