package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import defpackage.ym4;

/* renamed from: xm4  reason: default package */
/* compiled from: FloatingActionButtonImpl */
public class xm4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3942a;
    public final /* synthetic */ ym4.f b;
    public final /* synthetic */ ym4 c;

    public xm4(ym4 ym4, boolean z, ym4.f fVar) {
        this.c = ym4;
        this.f3942a = z;
        this.b = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        ym4 ym4 = this.c;
        ym4.o = 0;
        ym4.j = null;
        ym4.f fVar = this.b;
        if (fVar != null) {
            vm4 vm4 = (vm4) fVar;
            vm4.f3664a.b(vm4.b);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.c.s.b(0, this.f3942a);
        ym4 ym4 = this.c;
        ym4.o = 2;
        ym4.j = animator;
    }
}
