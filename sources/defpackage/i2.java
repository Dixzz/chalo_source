package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.cardview.widget.CardView;

/* renamed from: i2  reason: default package */
/* compiled from: CardViewApi21Impl */
public class i2 implements k2 {
    @Override // defpackage.k2
    public void a(j2 j2Var, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        l2 l2Var = new l2(colorStateList, f);
        CardView.a aVar = (CardView.a) j2Var;
        aVar.f196a = l2Var;
        CardView.this.setBackgroundDrawable(l2Var);
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(f2);
        n(j2Var, f3);
    }

    @Override // defpackage.k2
    public void b(j2 j2Var, float f) {
        l2 o = o(j2Var);
        if (f != o.f2154a) {
            o.f2154a = f;
            o.c(null);
            o.invalidateSelf();
        }
    }

    @Override // defpackage.k2
    public float c(j2 j2Var) {
        return CardView.this.getElevation();
    }

    @Override // defpackage.k2
    public float d(j2 j2Var) {
        return o(j2Var).f2154a;
    }

    @Override // defpackage.k2
    public void e(j2 j2Var) {
        n(j2Var, o(j2Var).e);
    }

    @Override // defpackage.k2
    public void f(j2 j2Var, float f) {
        CardView.this.setElevation(f);
    }

    @Override // defpackage.k2
    public float g(j2 j2Var) {
        return o(j2Var).e;
    }

    @Override // defpackage.k2
    public ColorStateList h(j2 j2Var) {
        return o(j2Var).h;
    }

    @Override // defpackage.k2
    public void i(j2 j2Var) {
        CardView.a aVar = (CardView.a) j2Var;
        if (!CardView.this.getUseCompatPadding()) {
            aVar.b(0, 0, 0, 0);
            return;
        }
        float f = o(j2Var).e;
        float f2 = o(j2Var).f2154a;
        int ceil = (int) Math.ceil((double) m2.a(f, f2, aVar.a()));
        int ceil2 = (int) Math.ceil((double) m2.b(f, f2, aVar.a()));
        aVar.b(ceil, ceil2, ceil, ceil2);
    }

    @Override // defpackage.k2
    public float j(j2 j2Var) {
        return o(j2Var).f2154a * 2.0f;
    }

    @Override // defpackage.k2
    public float k(j2 j2Var) {
        return o(j2Var).f2154a * 2.0f;
    }

    @Override // defpackage.k2
    public void l(j2 j2Var) {
        n(j2Var, o(j2Var).e);
    }

    @Override // defpackage.k2
    public void m(j2 j2Var, ColorStateList colorStateList) {
        l2 o = o(j2Var);
        o.b(colorStateList);
        o.invalidateSelf();
    }

    @Override // defpackage.k2
    public void n(j2 j2Var, float f) {
        l2 o = o(j2Var);
        CardView.a aVar = (CardView.a) j2Var;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean a2 = aVar.a();
        if (!(f == o.e && o.f == useCompatPadding && o.g == a2)) {
            o.e = f;
            o.f = useCompatPadding;
            o.g = a2;
            o.c(null);
            o.invalidateSelf();
        }
        i(j2Var);
    }

    public final l2 o(j2 j2Var) {
        return (l2) ((CardView.a) j2Var).f196a;
    }
}
