package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: kp4  reason: default package */
/* compiled from: ClearTextEndIconDelegate */
public class kp4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ jp4 f2100a;

    public kp4(jp4 jp4) {
        this.f2100a = jp4;
    }

    public void onAnimationStart(Animator animator) {
        this.f2100a.f3673a.setEndIconVisible(true);
    }
}
