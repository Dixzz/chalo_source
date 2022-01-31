package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: so4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class so4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3237a;

    public so4(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3237a = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3237a.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
