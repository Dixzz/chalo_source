package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: il4  reason: default package */
/* compiled from: MaterialButtonHelper */
public class il4 {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialButton f1533a;
    public ko4 b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;
    public int s;

    public il4(MaterialButton materialButton, ko4 ko4) {
        this.f1533a = materialButton;
        this.b = ko4;
    }

    public oo4 a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.r.getNumberOfLayers() > 2) {
            return (oo4) this.r.getDrawable(2);
        }
        return (oo4) this.r.getDrawable(1);
    }

    public ho4 b() {
        return c(false);
    }

    public final ho4 c(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (ho4) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final ho4 d() {
        return c(true);
    }

    public void e(ko4 ko4) {
        this.b = ko4;
        if (b() != null) {
            ho4 b2 = b();
            b2.f.f1403a = ko4;
            b2.invalidateSelf();
        }
        if (d() != null) {
            ho4 d2 = d();
            d2.f.f1403a = ko4;
            d2.invalidateSelf();
        }
        if (a() != null) {
            a().setShapeAppearanceModel(ko4);
        }
    }

    public final void f(int i2, int i3) {
        MaterialButton materialButton = this.f1533a;
        AtomicInteger atomicInteger = r8.f3055a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = this.f1533a.getPaddingTop();
        int paddingEnd = this.f1533a.getPaddingEnd();
        int paddingBottom = this.f1533a.getPaddingBottom();
        int i4 = this.e;
        int i5 = this.f;
        this.f = i3;
        this.e = i2;
        if (!this.o) {
            g();
        }
        this.f1533a.setPaddingRelative(paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    public final void g() {
        MaterialButton materialButton = this.f1533a;
        ho4 ho4 = new ho4(this.b);
        ho4.n(this.f1533a.getContext());
        ho4.setTintList(this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            ho4.setTintMode(mode);
        }
        ho4.u((float) this.h, this.k);
        ho4 ho42 = new ho4(this.b);
        ho42.setTint(0);
        ho42.t((float) this.h, this.n ? hd3.g1(this.f1533a, R.attr.colorSurface) : 0);
        ho4 ho43 = new ho4(this.b);
        this.m = ho43;
        ho43.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(yn4.b(this.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{ho42, ho4}), this.c, this.e, this.d, this.f), this.m);
        this.r = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        ho4 b2 = b();
        if (b2 != null) {
            b2.p((float) this.s);
        }
    }

    public final void h() {
        ho4 b2 = b();
        ho4 d2 = d();
        if (b2 != null) {
            b2.u((float) this.h, this.k);
            if (d2 != null) {
                d2.t((float) this.h, this.n ? hd3.g1(this.f1533a, R.attr.colorSurface) : 0);
            }
        }
    }
}
