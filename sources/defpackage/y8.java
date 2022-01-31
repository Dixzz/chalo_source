package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: y8  reason: default package */
/* compiled from: ViewPropertyAnimatorCompat */
public final class y8 {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f4016a;
    public int b = -1;

    /* renamed from: y8$a */
    /* compiled from: ViewPropertyAnimatorCompat */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z8 f4017a;
        public final /* synthetic */ View b;

        public a(y8 y8Var, z8 z8Var, View view) {
            this.f4017a = z8Var;
            this.b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f4017a.onAnimationCancel(this.b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f4017a.onAnimationEnd(this.b);
        }

        public void onAnimationStart(Animator animator) {
            this.f4017a.onAnimationStart(this.b);
        }
    }

    /* renamed from: y8$b */
    /* compiled from: ViewPropertyAnimatorCompat */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b9 f4018a;
        public final /* synthetic */ View b;

        public b(y8 y8Var, b9 b9Var, View view) {
            this.f4018a = b9Var;
            this.b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) t0.this.d.getParent()).invalidate();
        }
    }

    public y8(View view) {
        this.f4016a = new WeakReference<>(view);
    }

    public y8 a(float f) {
        View view = this.f4016a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.f4016a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public y8 c(long j) {
        View view = this.f4016a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public y8 d(z8 z8Var) {
        View view = this.f4016a.get();
        if (view != null) {
            e(view, z8Var);
        }
        return this;
    }

    public final void e(View view, z8 z8Var) {
        if (z8Var != null) {
            view.animate().setListener(new a(this, z8Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public y8 f(b9 b9Var) {
        View view = this.f4016a.get();
        if (view != null) {
            b bVar = null;
            if (b9Var != null) {
                bVar = new b(this, b9Var, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public void g() {
        View view = this.f4016a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public y8 h(float f) {
        View view = this.f4016a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
