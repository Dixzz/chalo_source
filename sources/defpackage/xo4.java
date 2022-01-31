package defpackage;

import android.animation.ValueAnimator;
import android.os.Handler;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: xo4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class xo4 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public int f3948a = 0;
    public final /* synthetic */ BaseTransientBottomBar b;

    public xo4(BaseTransientBottomBar baseTransientBottomBar) {
        this.b = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Handler handler = BaseTransientBottomBar.o;
        this.b.c.setTranslationY((float) intValue);
        this.f3948a = intValue;
    }
}
