package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: up4  reason: default package */
/* compiled from: DropdownMenuEndIconDelegate */
public class up4 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ qp4 f3537a;

    public up4(qp4 qp4) {
        this.f3537a = qp4;
    }

    public void onAnimationEnd(Animator animator) {
        qp4 qp4 = this.f3537a;
        qp4.c.setChecked(qp4.j);
        this.f3537a.p.start();
    }
}
