package defpackage;

import android.animation.Animator;

/* renamed from: vd1  reason: default package */
/* compiled from: CircularProgressDrawable */
public class vd1 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ud1 f3633a;

    public vd1(ud1 ud1) {
        this.f3633a = ud1;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        ud1 ud1 = this.f3633a;
        boolean z = !ud1.i;
        ud1.i = z;
        if (z) {
            ud1.k = (ud1.k + 60.0f) % 360.0f;
        }
    }

    public void onAnimationStart(Animator animator) {
    }
}
