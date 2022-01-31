package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: ln  reason: default package */
/* compiled from: Transition */
public class ln extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n2 f2241a;
    public final /* synthetic */ kn b;

    public ln(kn knVar, n2 n2Var) {
        this.b = knVar;
        this.f2241a = n2Var;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2241a.remove(animator);
        this.b.r.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.b.r.add(animator);
    }
}
