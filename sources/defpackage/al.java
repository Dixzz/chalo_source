package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import defpackage.ik;

/* renamed from: al  reason: default package */
/* compiled from: SimpleItemAnimator */
public abstract class al extends RecyclerView.j {
    public boolean g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean a(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, RecyclerView.j.c cVar, RecyclerView.j.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f233a;
        int i4 = cVar.b;
        if (a0Var2.shouldIgnore()) {
            int i5 = cVar.f233a;
            i = cVar.b;
            i2 = i5;
        } else {
            i2 = cVar2.f233a;
            i = cVar2.b;
        }
        ik ikVar = (ik) this;
        if (a0Var == a0Var2) {
            return ikVar.i(a0Var, i3, i4, i2, i);
        }
        float translationX = a0Var.itemView.getTranslationX();
        float translationY = a0Var.itemView.getTranslationY();
        float alpha = a0Var.itemView.getAlpha();
        ikVar.n(a0Var);
        a0Var.itemView.setTranslationX(translationX);
        a0Var.itemView.setTranslationY(translationY);
        a0Var.itemView.setAlpha(alpha);
        ikVar.n(a0Var2);
        a0Var2.itemView.setTranslationX((float) (-((int) (((float) (i2 - i3)) - translationX))));
        a0Var2.itemView.setTranslationY((float) (-((int) (((float) (i - i4)) - translationY))));
        a0Var2.itemView.setAlpha(0.0f);
        ikVar.k.add(new ik.a(a0Var, a0Var2, i3, i4, i2, i));
        return true;
    }

    public abstract boolean i(RecyclerView.a0 a0Var, int i, int i2, int i3, int i4);
}
