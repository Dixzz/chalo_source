package defpackage;

import android.view.View;

/* renamed from: l0  reason: default package */
/* compiled from: AppCompatDelegateImpl */
public class l0 implements Runnable {
    public final /* synthetic */ i0 f;

    /* renamed from: l0$a */
    /* compiled from: AppCompatDelegateImpl */
    public class a extends a9 {
        public a() {
        }

        @Override // defpackage.a9, defpackage.z8
        public void onAnimationEnd(View view) {
            l0.this.f.t.setAlpha(1.0f);
            l0.this.f.w.d(null);
            l0.this.f.w = null;
        }

        @Override // defpackage.a9, defpackage.z8
        public void onAnimationStart(View view) {
            l0.this.f.t.setVisibility(0);
        }
    }

    public l0(i0 i0Var) {
        this.f = i0Var;
    }

    public void run() {
        i0 i0Var = this.f;
        i0Var.u.showAtLocation(i0Var.t, 55, 0, 0);
        this.f.J();
        if (this.f.X()) {
            this.f.t.setAlpha(0.0f);
            i0 i0Var2 = this.f;
            y8 b = r8.b(i0Var2.t);
            b.a(1.0f);
            i0Var2.w = b;
            y8 y8Var = this.f.w;
            a aVar = new a();
            View view = y8Var.f4016a.get();
            if (view != null) {
                y8Var.e(view, aVar);
                return;
            }
            return;
        }
        this.f.t.setAlpha(1.0f);
        this.f.t.setVisibility(0);
    }
}
