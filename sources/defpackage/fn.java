package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: fn  reason: default package */
/* compiled from: Fade */
public class fn extends eo {

    /* renamed from: fn$a */
    /* compiled from: Fade */
    public class a extends nn {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f1143a;

        public a(fn fnVar, View view) {
            this.f1143a = view;
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            View view = this.f1143a;
            co coVar = wn.f3805a;
            coVar.e(view, 1.0f);
            coVar.a(this.f1143a);
            knVar.w(this);
        }
    }

    /* renamed from: fn$b */
    /* compiled from: Fade */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final View f1144a;
        public boolean b = false;

        public b(View view) {
            this.f1144a = view;
        }

        public void onAnimationEnd(Animator animator) {
            wn.f3805a.e(this.f1144a, 1.0f);
            if (this.b) {
                this.f1144a.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            View view = this.f1144a;
            AtomicInteger atomicInteger = r8.f3055a;
            if (view.hasOverlappingRendering() && this.f1144a.getLayerType() == 0) {
                this.b = true;
                this.f1144a.setLayerType(2, null);
            }
        }
    }

    public fn(int i) {
        if ((i & -4) == 0) {
            this.C = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // defpackage.eo
    public Animator K(ViewGroup viewGroup, View view, sn snVar, sn snVar2) {
        wn.f3805a.c(view);
        Float f = (Float) snVar.f3229a.get("android:fade:transitionAlpha");
        return M(view, f != null ? f.floatValue() : 1.0f, 0.0f);
    }

    public final Animator M(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        wn.f3805a.e(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, wn.b, f2);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    @Override // defpackage.kn
    public void g(sn snVar) {
        I(snVar);
        snVar.f3229a.put("android:fade:transitionAlpha", Float.valueOf(wn.a(snVar.b)));
    }
}
