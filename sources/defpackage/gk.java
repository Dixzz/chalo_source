package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.ik;
import java.util.Objects;

/* renamed from: gk  reason: default package */
/* compiled from: DefaultItemAnimator */
public class gk extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ik.a f1271a;
    public final /* synthetic */ ViewPropertyAnimator b;
    public final /* synthetic */ View c;
    public final /* synthetic */ ik d;

    public gk(ik ikVar, ik.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = ikVar;
        this.f1271a = aVar;
        this.b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.b.setListener(null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.d.c(this.f1271a.f1525a);
        this.d.r.remove(this.f1271a.f1525a);
        this.d.k();
    }

    public void onAnimationStart(Animator animator) {
        ik ikVar = this.d;
        RecyclerView.a0 a0Var = this.f1271a.f1525a;
        Objects.requireNonNull(ikVar);
    }
}
