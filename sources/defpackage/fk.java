package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* renamed from: fk  reason: default package */
/* compiled from: DefaultItemAnimator */
public class fk extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.a0 f1132a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ViewPropertyAnimator e;
    public final /* synthetic */ ik f;

    public fk(ik ikVar, RecyclerView.a0 a0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = ikVar;
        this.f1132a = a0Var;
        this.b = i;
        this.c = view;
        this.d = i2;
        this.e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.b != 0) {
            this.c.setTranslationX(0.0f);
        }
        if (this.d != 0) {
            this.c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.e.setListener(null);
        this.f.c(this.f1132a);
        this.f.p.remove(this.f1132a);
        this.f.k();
    }

    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f);
    }
}
