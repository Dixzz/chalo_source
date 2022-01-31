package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: wk4  reason: default package */
/* compiled from: BottomAppBar */
public class wk4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3795a;

    public wk4(BottomAppBar bottomAppBar) {
        this.f3795a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.a(this.f3795a);
        this.f3795a.f = null;
    }

    public void onAnimationStart(Animator animator) {
        this.f3795a.k++;
    }
}
