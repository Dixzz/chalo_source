package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: kk4  reason: default package */
/* compiled from: AppBarLayout */
public class kk4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ho4 f2074a;

    public kk4(AppBarLayout appBarLayout, ho4 ho4) {
        this.f2074a = ho4;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2074a.p(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
