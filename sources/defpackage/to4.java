package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: to4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class to4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3385a;

    public to4(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3385a = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f3385a.c.setScaleX(floatValue);
        this.f3385a.c.setScaleY(floatValue);
    }
}
