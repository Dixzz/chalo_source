package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.sj;

/* renamed from: yk  reason: default package */
/* compiled from: RecyclerView */
public class yk implements sj.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f4061a;

    public yk(RecyclerView recyclerView) {
        this.f4061a = recyclerView;
    }

    public void a(sj.b bVar) {
        int i = bVar.f3219a;
        if (i == 1) {
            RecyclerView recyclerView = this.f4061a;
            recyclerView.r.A0(recyclerView, bVar.b, bVar.d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.f4061a;
            recyclerView2.r.D0(recyclerView2, bVar.b, bVar.d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.f4061a;
            recyclerView3.r.F0(recyclerView3, bVar.b, bVar.d, bVar.c);
        } else if (i == 8) {
            RecyclerView recyclerView4 = this.f4061a;
            recyclerView4.r.C0(recyclerView4, bVar.b, bVar.d, 1);
        }
    }

    public RecyclerView.a0 b(int i) {
        RecyclerView recyclerView = this.f4061a;
        int h = recyclerView.j.h();
        int i2 = 0;
        RecyclerView.a0 a0Var = null;
        while (true) {
            if (i2 >= h) {
                break;
            }
            RecyclerView.a0 K = RecyclerView.K(recyclerView.j.g(i2));
            if (K != null && !K.isRemoved() && K.mPosition == i) {
                if (!recyclerView.j.k(K.itemView)) {
                    a0Var = K;
                    break;
                }
                a0Var = K;
            }
            i2++;
        }
        if (a0Var != null && !this.f4061a.j.k(a0Var.itemView)) {
            return a0Var;
        }
        return null;
    }

    public void c(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.f4061a;
        int h = recyclerView.j.h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < h; i6++) {
            View g = recyclerView.j.g(i6);
            RecyclerView.a0 K = RecyclerView.K(g);
            if (K != null && !K.shouldIgnore() && (i4 = K.mPosition) >= i && i4 < i5) {
                K.addFlags(2);
                K.addChangePayload(obj);
                ((RecyclerView.n) g.getLayoutParams()).h = true;
            }
        }
        RecyclerView.t tVar = recyclerView.g;
        int size = tVar.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                RecyclerView.a0 a0Var = tVar.c.get(size);
                if (a0Var != null && (i3 = a0Var.mPosition) >= i && i3 < i5) {
                    a0Var.addFlags(2);
                    tVar.g(size);
                }
            } else {
                this.f4061a.r0 = true;
                return;
            }
        }
    }

    public void d(int i, int i2) {
        RecyclerView recyclerView = this.f4061a;
        int h = recyclerView.j.h();
        for (int i3 = 0; i3 < h; i3++) {
            RecyclerView.a0 K = RecyclerView.K(recyclerView.j.g(i3));
            if (K != null && !K.shouldIgnore() && K.mPosition >= i) {
                K.offsetPosition(i2, false);
                recyclerView.n0.f = true;
            }
        }
        RecyclerView.t tVar = recyclerView.g;
        int size = tVar.c.size();
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.a0 a0Var = tVar.c.get(i4);
            if (a0Var != null && a0Var.mPosition >= i) {
                a0Var.offsetPosition(i2, false);
            }
        }
        recyclerView.requestLayout();
        this.f4061a.q0 = true;
    }

    public void e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = this.f4061a;
        int h = recyclerView.j.h();
        int i10 = -1;
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i11 = 0; i11 < h; i11++) {
            RecyclerView.a0 K = RecyclerView.K(recyclerView.j.g(i11));
            if (K != null && (i9 = K.mPosition) >= i5 && i9 <= i4) {
                if (i9 == i) {
                    K.offsetPosition(i2 - i, false);
                } else {
                    K.offsetPosition(i3, false);
                }
                recyclerView.n0.f = true;
            }
        }
        RecyclerView.t tVar = recyclerView.g;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = tVar.c.size();
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.a0 a0Var = tVar.c.get(i12);
            if (a0Var != null && (i8 = a0Var.mPosition) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    a0Var.offsetPosition(i2 - i, false);
                } else {
                    a0Var.offsetPosition(i10, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.f4061a.q0 = true;
    }
}
