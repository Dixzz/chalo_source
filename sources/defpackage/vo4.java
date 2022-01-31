package defpackage;

import android.animation.ValueAnimator;
import android.os.Handler;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: vo4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class vo4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public int f3668a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BaseTransientBottomBar c;

    public vo4(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.c = baseTransientBottomBar;
        this.b = i;
        this.f3668a = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.o;
        this.c.c.setTranslationY((float) intValue);
        this.f3668a = intValue;
    }
}
