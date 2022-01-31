package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* renamed from: pk4  reason: default package */
/* compiled from: CollapsingToolbarLayout */
public class pk4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollapsingToolbarLayout f2816a;

    public pk4(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f2816a = collapsingToolbarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2816a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
