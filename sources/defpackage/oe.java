package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import defpackage.le;

/* renamed from: oe  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public class oe implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup f;
    public final /* synthetic */ View g;
    public final /* synthetic */ le.b h;

    /* renamed from: oe$a */
    /* compiled from: DefaultSpecialEffectsController */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            oe oeVar = oe.this;
            oeVar.f.endViewTransition(oeVar.g);
            oe.this.h.a();
        }
    }

    public oe(le leVar, ViewGroup viewGroup, View view, le.b bVar) {
        this.f = viewGroup;
        this.g = view;
        this.h = bVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
