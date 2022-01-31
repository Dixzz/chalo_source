package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.ym4;

/* renamed from: wm4  reason: default package */
/* compiled from: FloatingActionButtonImpl */
public class wm4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3804a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ ym4.f c;
    public final /* synthetic */ ym4 d;

    public wm4(ym4 ym4, boolean z, ym4.f fVar) {
        this.d = ym4;
        this.b = z;
        this.c = fVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f3804a = true;
    }

    public void onAnimationEnd(Animator animator) {
        ym4 ym4 = this.d;
        ym4.o = 0;
        ym4.j = null;
        if (!this.f3804a) {
            FloatingActionButton floatingActionButton = ym4.s;
            boolean z = this.b;
            floatingActionButton.b(z ? 8 : 4, z);
            ym4.f fVar = this.c;
            if (fVar != null) {
                vm4 vm4 = (vm4) fVar;
                vm4.f3664a.a(vm4.b);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.d.s.b(0, this.b);
        ym4 ym4 = this.d;
        ym4.o = 1;
        ym4.j = animator;
        this.f3804a = false;
    }
}
