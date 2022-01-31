package defpackage;

import android.graphics.drawable.Drawable;

/* renamed from: qj  reason: default package */
/* compiled from: ActionBarOnDestinationChangedListener */
public class qj extends pj {
    public final f0 f;

    public qj(f0 f0Var, rj rjVar) {
        super(i0.this.N(), rjVar);
        this.f = f0Var;
    }

    @Override // defpackage.pj
    public void b(Drawable drawable, int i) {
        x supportActionBar = this.f.getSupportActionBar();
        if (drawable == null) {
            supportActionBar.o(false);
            return;
        }
        supportActionBar.o(true);
        i0 i0Var = i0.this;
        i0Var.R();
        x xVar = i0Var.m;
        if (xVar != null) {
            xVar.u(drawable);
            xVar.s(i);
        }
    }
}
