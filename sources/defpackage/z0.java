package defpackage;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import defpackage.w0;

@SuppressLint({"RestrictedAPI"})
/* renamed from: z0  reason: default package */
/* compiled from: StateListDrawable */
public class z0 extends w0 {
    public a s;
    public boolean t;

    /* renamed from: z0$a */
    /* compiled from: StateListDrawable */
    public static class a extends w0.c {
        public int[][] J;

        public a(a aVar, z0 z0Var, Resources resources) {
            super(aVar, z0Var, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[this.g.length][];
            }
        }

        @Override // defpackage.w0.c
        public void e() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        public int g(int[] iArr) {
            int[][] iArr2 = this.J;
            int i = this.h;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new z0(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new z0(this, resources);
        }
    }

    public z0(a aVar, Resources resources) {
        e(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // defpackage.w0
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // defpackage.w0
    public void e(w0.c cVar) {
        this.f = cVar;
        int i = this.l;
        if (i >= 0) {
            Drawable d = cVar.d(i);
            this.h = d;
            if (d != null) {
                c(d);
            }
        }
        this.i = null;
        if (cVar instanceof a) {
            this.s = (a) cVar;
        }
    }

    /* renamed from: f */
    public a b() {
        return new a(this.s, this, null);
    }

    public boolean isStateful() {
        return true;
    }

    @Override // defpackage.w0
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.s.e();
                this.t = true;
            }
        }
        return this;
    }

    @Override // defpackage.w0
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int g = this.s.g(iArr);
        if (g < 0) {
            g = this.s.g(StateSet.WILD_CARD);
        }
        return d(g) || onStateChange;
    }

    public z0(a aVar) {
    }
}
