package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: wk  reason: default package */
/* compiled from: PagerSnapHelper */
public class wk extends bl {
    public uk c;
    public uk d;

    @Override // defpackage.bl
    public int[] b(RecyclerView.m mVar, View view) {
        int[] iArr = new int[2];
        if (mVar.p()) {
            iArr[0] = e(view, g(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.q()) {
            iArr[1] = e(view, h(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // defpackage.bl
    public View c(RecyclerView.m mVar) {
        if (mVar.q()) {
            return f(mVar, h(mVar));
        }
        if (mVar.p()) {
            return f(mVar, g(mVar));
        }
        return null;
    }

    public final int e(View view, uk ukVar) {
        return ((ukVar.c(view) / 2) + ukVar.e(view)) - ((ukVar.l() / 2) + ukVar.k());
    }

    public final View f(RecyclerView.m mVar, uk ukVar) {
        int K = mVar.K();
        View view = null;
        if (K == 0) {
            return null;
        }
        int l = (ukVar.l() / 2) + ukVar.k();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < K; i2++) {
            View J = mVar.J(i2);
            int abs = Math.abs(((ukVar.c(J) / 2) + ukVar.e(J)) - l);
            if (abs < i) {
                view = J;
                i = abs;
            }
        }
        return view;
    }

    public final uk g(RecyclerView.m mVar) {
        uk ukVar = this.d;
        if (ukVar == null || ukVar.f3515a != mVar) {
            this.d = new sk(mVar);
        }
        return this.d;
    }

    public final uk h(RecyclerView.m mVar) {
        uk ukVar = this.c;
        if (ukVar == null || ukVar.f3515a != mVar) {
            this.c = new tk(mVar);
        }
        return this.c;
    }
}
