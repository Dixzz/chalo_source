package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* renamed from: dk  reason: default package */
/* compiled from: DefaultItemAnimator */
public class dk extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.a0 f847a;
    public final /* synthetic */ ViewPropertyAnimator b;
    public final /* synthetic */ View c;
    public final /* synthetic */ ik d;

    public dk(ik ikVar, RecyclerView.a0 a0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = ikVar;
        this.f847a = a0Var;
        this.b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.setListener(null);
        this.c.setAlpha(1.0f);
        this.d.c(this.f847a);
        this.d.q.remove(this.f847a);
        this.d.k();
    }

    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.d);
    }
}
