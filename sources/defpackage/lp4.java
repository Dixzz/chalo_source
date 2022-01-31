package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: lp4  reason: default package */
/* compiled from: ClearTextEndIconDelegate */
public class lp4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ jp4 f2255a;

    public lp4(jp4 jp4) {
        this.f2255a = jp4;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2255a.f3673a.setEndIconVisible(false);
    }
}
