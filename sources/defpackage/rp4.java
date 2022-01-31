package defpackage;

import android.animation.ValueAnimator;

/* renamed from: rp4  reason: default package */
/* compiled from: DropdownMenuEndIconDelegate */
public class rp4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ qp4 f3112a;

    public rp4(qp4 qp4) {
        this.f3112a = qp4;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3112a.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
