package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: mn  reason: default package */
/* compiled from: Transition */
public class mn extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kn f2409a;

    public mn(kn knVar) {
        this.f2409a = knVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2409a.m();
        animator.removeListener(this);
    }
}
