package defpackage;

import android.view.View;

/* renamed from: j0  reason: default package */
/* compiled from: AppCompatDelegateImpl */
public class j0 implements m8 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f1857a;

    public j0(i0 i0Var) {
        this.f1857a = i0Var;
    }

    @Override // defpackage.m8
    public c9 a(View view, c9 c9Var) {
        int e = c9Var.e();
        int Z = this.f1857a.Z(c9Var, null);
        if (e != Z) {
            c9Var = c9Var.h(c9Var.c(), Z, c9Var.d(), c9Var.b());
        }
        return r8.p(view, c9Var);
    }
}
