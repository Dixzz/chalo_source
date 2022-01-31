package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: tk  reason: default package */
/* compiled from: OrientationHelper */
public class tk extends uk {
    public tk(RecyclerView.m mVar) {
        super(mVar, null);
    }

    @Override // defpackage.uk
    public int b(View view) {
        return this.f3515a.N(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
    }

    @Override // defpackage.uk
    public int c(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f3515a.Q(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
    }

    @Override // defpackage.uk
    public int d(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return this.f3515a.R(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
    }

    @Override // defpackage.uk
    public int e(View view) {
        return this.f3515a.T(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
    }

    @Override // defpackage.uk
    public int f() {
        return this.f3515a.w;
    }

    @Override // defpackage.uk
    public int g() {
        RecyclerView.m mVar = this.f3515a;
        return mVar.w - mVar.getPaddingBottom();
    }

    @Override // defpackage.uk
    public int h() {
        return this.f3515a.getPaddingBottom();
    }

    @Override // defpackage.uk
    public int i() {
        return this.f3515a.u;
    }

    @Override // defpackage.uk
    public int j() {
        return this.f3515a.t;
    }

    @Override // defpackage.uk
    public int k() {
        return this.f3515a.getPaddingTop();
    }

    @Override // defpackage.uk
    public int l() {
        RecyclerView.m mVar = this.f3515a;
        return (mVar.w - mVar.getPaddingTop()) - this.f3515a.getPaddingBottom();
    }

    @Override // defpackage.uk
    public int n(View view) {
        this.f3515a.g0(view, true, this.c);
        return this.c.bottom;
    }

    @Override // defpackage.uk
    public int o(View view) {
        this.f3515a.g0(view, true, this.c);
        return this.c.top;
    }

    @Override // defpackage.uk
    public void p(int i) {
        this.f3515a.n0(i);
    }
}
