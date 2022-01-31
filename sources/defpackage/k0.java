package defpackage;

import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;

/* renamed from: k0  reason: default package */
/* compiled from: AppCompatDelegateImpl */
public class k0 implements ContentFrameLayout.OnAttachListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f2004a;

    public k0(i0 i0Var) {
        this.f2004a = i0Var;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public void onAttachedFromWindow() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public void onDetachedFromWindow() {
        i0 i0Var = this.f2004a;
        DecorContentParent decorContentParent = i0Var.p;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (i0Var.u != null) {
            i0Var.j.getDecorView().removeCallbacks(i0Var.v);
            if (i0Var.u.isShowing()) {
                try {
                    i0Var.u.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            i0Var.u = null;
        }
        i0Var.J();
        p1 p1Var = i0Var.P(0).h;
        if (p1Var != null) {
            p1Var.c(true);
        }
    }
}
