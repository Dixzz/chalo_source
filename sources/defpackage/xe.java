package defpackage;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.tf;

/* renamed from: xe  reason: default package */
/* compiled from: FragmentAnim */
public class xe implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup f;
    public final /* synthetic */ Fragment g;
    public final /* synthetic */ tf.a h;
    public final /* synthetic */ t6 i;

    /* renamed from: xe$a */
    /* compiled from: FragmentAnim */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (xe.this.g.getAnimatingAway() != null) {
                xe.this.g.setAnimatingAway(null);
                xe xeVar = xe.this;
                ((FragmentManager.d) xeVar.h).a(xeVar.g, xeVar.i);
            }
        }
    }

    public xe(ViewGroup viewGroup, Fragment fragment, tf.a aVar, t6 t6Var) {
        this.f = viewGroup;
        this.g = fragment;
        this.h = aVar;
        this.i = t6Var;
    }

    public void onAnimationEnd(Animation animation) {
        this.f.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
