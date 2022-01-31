package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* renamed from: ek  reason: default package */
/* compiled from: DefaultItemAnimator */
public class ek extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.a0 f980a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewPropertyAnimator c;
    public final /* synthetic */ ik d;

    public ek(ik ikVar, RecyclerView.a0 a0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.d = ikVar;
        this.f980a = a0Var;
        this.b = view;
        this.c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.c.setListener(null);
        this.d.c(this.f980a);
        this.d.o.remove(this.f980a);
        this.d.k();
    }

    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.d);
    }
}
