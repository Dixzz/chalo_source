package defpackage;

import android.animation.ValueAnimator;

/* renamed from: mp4  reason: default package */
/* compiled from: ClearTextEndIconDelegate */
public class mp4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ jp4 f2426a;

    public mp4(jp4 jp4) {
        this.f2426a = jp4;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2426a.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
