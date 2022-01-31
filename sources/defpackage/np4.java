package defpackage;

import android.animation.ValueAnimator;

/* renamed from: np4  reason: default package */
/* compiled from: ClearTextEndIconDelegate */
public class np4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ jp4 f2590a;

    public np4(jp4 jp4) {
        this.f2590a = jp4;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f2590a.c.setScaleX(floatValue);
        this.f2590a.c.setScaleY(floatValue);
    }
}
