package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.tf;

/* renamed from: ye  reason: default package */
/* compiled from: FragmentAnim */
public class ye extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f4033a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ tf.a d;
    public final /* synthetic */ t6 e;

    public ye(ViewGroup viewGroup, View view, Fragment fragment, tf.a aVar, t6 t6Var) {
        this.f4033a = viewGroup;
        this.b = view;
        this.c = fragment;
        this.d = aVar;
        this.e = t6Var;
    }

    public void onAnimationEnd(Animator animator) {
        this.f4033a.endViewTransition(this.b);
        Animator animator2 = this.c.getAnimator();
        this.c.setAnimator(null);
        if (animator2 != null && this.f4033a.indexOfChild(this.b) < 0) {
            ((FragmentManager.d) this.d).a(this.c, this.e);
        }
    }
}
