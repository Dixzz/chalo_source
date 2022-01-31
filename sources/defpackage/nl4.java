package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: nl4  reason: default package */
/* compiled from: CircularRevealCompat */
public final class nl4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ pl4 f2574a;

    public nl4(pl4 pl4) {
        this.f2574a = pl4;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2574a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.f2574a.a();
    }
}
