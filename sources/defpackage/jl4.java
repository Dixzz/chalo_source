package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.card.MaterialCardView;
import defpackage.ko4;
import java.util.Objects;

/* renamed from: jl4  reason: default package */
/* compiled from: MaterialCardViewHelper */
public class jl4 {
    public static final int[] t = {16842912};
    public static final double u = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f1952a;
    public final Rect b = new Rect();
    public final ho4 c;
    public final ho4 d;
    public int e;
    public int f;
    public int g;
    public Drawable h;
    public Drawable i;
    public ColorStateList j;
    public ColorStateList k;
    public ko4 l;
    public ColorStateList m;
    public Drawable n;
    public LayerDrawable o;
    public ho4 p;
    public ho4 q;
    public boolean r = false;
    public boolean s;

    /* renamed from: jl4$a */
    /* compiled from: MaterialCardViewHelper */
    public class a extends InsetDrawable {
        public a(jl4 jl4, Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        public int getMinimumHeight() {
            return -1;
        }

        public int getMinimumWidth() {
            return -1;
        }

        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public jl4(MaterialCardView materialCardView, AttributeSet attributeSet, int i2, int i3) {
        this.f1952a = materialCardView;
        ho4 ho4 = new ho4(ko4.b(materialCardView.getContext(), attributeSet, i2, i3).a());
        this.c = ho4;
        ho4.n(materialCardView.getContext());
        ho4.s(-12303292);
        ko4 ko4 = ho4.f.f1403a;
        Objects.requireNonNull(ko4);
        ko4.b bVar = new ko4.b(ko4);
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        int i4 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            bVar.c(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.d = new ho4();
        h(bVar.a());
        obtainStyledAttributes.recycle();
    }

    public final float a() {
        float b2 = b(this.l.f2092a, this.c.l());
        eo4 eo4 = this.l.b;
        ho4 ho4 = this.c;
        float max = Math.max(b2, b(eo4, ho4.f.f1403a.f.a(ho4.h())));
        eo4 eo42 = this.l.c;
        ho4 ho42 = this.c;
        float b3 = b(eo42, ho42.f.f1403a.g.a(ho42.h()));
        eo4 eo43 = this.l.d;
        ho4 ho43 = this.c;
        return Math.max(max, Math.max(b3, b(eo43, ho43.f.f1403a.h.a(ho43.h()))));
    }

    public final float b(eo4 eo4, float f2) {
        if (eo4 instanceof jo4) {
            return (float) ((1.0d - u) * ((double) f2));
        }
        if (eo4 instanceof fo4) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float c() {
        return this.f1952a.getMaxCardElevation() + (j() ? a() : 0.0f);
    }

    public final float d() {
        return (this.f1952a.getMaxCardElevation() * 1.5f) + (j() ? a() : 0.0f);
    }

    public final Drawable e() {
        if (this.n == null) {
            int[] iArr = yn4.f4071a;
            this.q = new ho4(this.l);
            this.n = new RippleDrawable(this.j, null, this.q);
        }
        if (this.o == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.i;
            if (drawable != null) {
                stateListDrawable.addState(t, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.d, stateListDrawable});
            this.o = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    public final Drawable f(Drawable drawable) {
        int i2;
        int i3;
        if (this.f1952a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((double) d());
            i3 = (int) Math.ceil((double) c());
            i2 = ceil;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new a(this, drawable, i3, i2, i3, i2);
    }

    public void g(Drawable drawable) {
        this.i = drawable;
        if (drawable != null) {
            Drawable H0 = h.H0(drawable.mutate());
            this.i = H0;
            H0.setTintList(this.k);
        }
        if (this.o != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.i;
            if (drawable2 != null) {
                stateListDrawable.addState(t, drawable2);
            }
            this.o.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public void h(ko4 ko4) {
        this.l = ko4;
        ho4 ho4 = this.c;
        ho4.f.f1403a = ko4;
        ho4.invalidateSelf();
        ho4 ho42 = this.c;
        ho42.A = !ho42.o();
        ho4 ho43 = this.d;
        if (ho43 != null) {
            ho43.f.f1403a = ko4;
            ho43.invalidateSelf();
        }
        ho4 ho44 = this.q;
        if (ho44 != null) {
            ho44.f.f1403a = ko4;
            ho44.invalidateSelf();
        }
        ho4 ho45 = this.p;
        if (ho45 != null) {
            ho45.f.f1403a = ko4;
            ho45.invalidateSelf();
        }
    }

    public final boolean i() {
        return this.f1952a.getPreventCornerOverlap() && !this.c.o();
    }

    public final boolean j() {
        return this.f1952a.getPreventCornerOverlap() && this.c.o() && this.f1952a.getUseCompatPadding();
    }

    public void k() {
        float f2 = 0.0f;
        float a2 = i() || j() ? a() : 0.0f;
        if (this.f1952a.getPreventCornerOverlap() && this.f1952a.getUseCompatPadding()) {
            f2 = (float) ((1.0d - u) * ((double) this.f1952a.getCardViewRadius()));
        }
        int i2 = (int) (a2 - f2);
        MaterialCardView materialCardView = this.f1952a;
        Rect rect = this.b;
        materialCardView.e(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
    }

    public void l() {
        if (!this.r) {
            this.f1952a.setBackgroundInternal(f(this.c));
        }
        this.f1952a.setForeground(f(this.h));
    }

    public final void m() {
        int[] iArr = yn4.f4071a;
        Drawable drawable = this.n;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.j);
            return;
        }
        ho4 ho4 = this.p;
        if (ho4 != null) {
            ho4.q(this.j);
        }
    }

    public void n() {
        this.d.u((float) this.g, this.m);
    }
}
