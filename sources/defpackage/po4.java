package defpackage;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.Objects;

/* renamed from: po4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class po4 implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar f;

    public po4(BaseTransientBottomBar baseTransientBottomBar) {
        this.f = baseTransientBottomBar;
    }

    public void run() {
        BaseTransientBottomBar.i iVar = this.f.c;
        if (iVar != null) {
            if (iVar.getParent() != null) {
                this.f.c.setVisibility(0);
            }
            if (this.f.c.getAnimationMode() == 1) {
                BaseTransientBottomBar baseTransientBottomBar = this.f;
                Objects.requireNonNull(baseTransientBottomBar);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setInterpolator(zj4.f4184a);
                ofFloat.addUpdateListener(new so4(baseTransientBottomBar));
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                ofFloat2.setInterpolator(zj4.d);
                ofFloat2.addUpdateListener(new to4(baseTransientBottomBar));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration(150L);
                animatorSet.addListener(new qo4(baseTransientBottomBar));
                animatorSet.start();
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar2 = this.f;
            int c = baseTransientBottomBar2.c();
            baseTransientBottomBar2.c.setTranslationY((float) c);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(c, 0);
            valueAnimator.setInterpolator(zj4.b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new uo4(baseTransientBottomBar2));
            valueAnimator.addUpdateListener(new vo4(baseTransientBottomBar2, c));
            valueAnimator.start();
        }
    }
}
