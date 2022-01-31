package defpackage;

import android.animation.Animator;
import defpackage.bn;

/* renamed from: an  reason: default package */
/* compiled from: CircularProgressDrawable */
public class an implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bn.a f181a;
    public final /* synthetic */ bn b;

    public an(bn bnVar, bn.a aVar) {
        this.b = bnVar;
        this.f181a = aVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.b.a(1.0f, this.f181a, true);
        bn.a aVar = this.f181a;
        aVar.k = aVar.e;
        aVar.l = aVar.f;
        aVar.m = aVar.g;
        aVar.a((aVar.j + 1) % aVar.i.length);
        bn bnVar = this.b;
        if (bnVar.k) {
            bnVar.k = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            this.f181a.b(false);
            return;
        }
        bnVar.j += 1.0f;
    }

    public void onAnimationStart(Animator animator) {
        this.b.j = 0.0f;
    }
}
