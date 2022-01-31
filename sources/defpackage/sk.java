package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: sk  reason: default package */
/* compiled from: OrientationHelper */
public class sk extends uk {
    public sk(RecyclerView.m mVar) {
        super(mVar, null);
    }

    @Override // defpackage.uk
    public int b(View view) {
        return this.f3515a.S(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).rightMargin;
    }

    @Override // defpackage.uk
    public int c(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f3515a.R(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
    }

    @Override // defpackage.uk
    public int d(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f3515a.Q(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
    }

    @Override // defpackage.uk
    public int e(View view) {
        return this.f3515a.P(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).leftMargin;
    }

    @Override // defpackage.uk
    public int f() {
        return this.f3515a.v;
    }

    @Override // defpackage.uk
    public int g() {
        RecyclerView.m mVar = this.f3515a;
        return mVar.v - mVar.getPaddingRight();
    }

    @Override // defpackage.uk
    public int h() {
        return this.f3515a.getPaddingRight();
    }

    @Override // defpackage.uk
    public int i() {
        return this.f3515a.t;
    }

    @Override // defpackage.uk
    public int j() {
        return this.f3515a.u;
    }

    @Override // defpackage.uk
    public int k() {
        return this.f3515a.getPaddingLeft();
    }

    @Override // defpackage.uk
    public int l() {
        RecyclerView.m mVar = this.f3515a;
        return (mVar.v - mVar.getPaddingLeft()) - this.f3515a.getPaddingRight();
    }

    @Override // defpackage.uk
    public int n(View view) {
        this.f3515a.g0(view, true, this.c);
        return this.c.right;
    }

    @Override // defpackage.uk
    public int o(View view) {
        this.f3515a.g0(view, true, this.c);
        return this.c.left;
    }

    @Override // defpackage.uk
    public void p(int i) {
        this.f3515a.m0(i);
    }
}
