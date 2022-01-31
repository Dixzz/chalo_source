package defpackage;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: lk4  reason: default package */
/* compiled from: AppBarLayout */
public class lk4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f2232a;
    public final /* synthetic */ AppBarLayout b;
    public final /* synthetic */ AppBarLayout.BaseBehavior c;

    public lk4(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c = baseBehavior;
        this.f2232a = coordinatorLayout;
        this.b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.F(this.f2232a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
