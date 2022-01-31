package defpackage;

import defpackage.f3;
import defpackage.i3;
import java.util.ArrayList;

/* renamed from: d3  reason: default package */
/* compiled from: ArrayRow */
public class d3 implements f3.a {

    /* renamed from: a  reason: collision with root package name */
    public i3 f781a = null;
    public float b = 0.0f;
    public ArrayList<i3> c = new ArrayList<>();
    public a d;
    public boolean e = false;

    /* renamed from: d3$a */
    /* compiled from: ArrayRow */
    public interface a {
        int a();

        i3 b(int i);

        void c();

        void clear();

        float d(int i);

        void e(i3 i3Var, float f, boolean z);

        float f(i3 i3Var);

        boolean g(i3 i3Var);

        float h(d3 d3Var, boolean z);

        void i(i3 i3Var, float f);

        float j(i3 i3Var, boolean z);

        void k(float f);
    }

    public d3() {
    }

    @Override // defpackage.f3.a
    public void a(i3 i3Var) {
        float f;
        int i = i3Var.d;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
            this.d.i(i3Var, f);
        }
        f = 1.0f;
        this.d.i(i3Var, f);
    }

    @Override // defpackage.f3.a
    public i3 b(f3 f3Var, boolean[] zArr) {
        return i(zArr, null);
    }

    public d3 c(f3 f3Var, int i) {
        this.d.i(f3Var.k(i, "ep"), 1.0f);
        this.d.i(f3Var.k(i, "em"), -1.0f);
        return this;
    }

    @Override // defpackage.f3.a
    public void clear() {
        this.d.clear();
        this.f781a = null;
        this.b = 0.0f;
    }

    public d3 d(i3 i3Var, i3 i3Var2, i3 i3Var3, i3 i3Var4, float f) {
        this.d.i(i3Var, -1.0f);
        this.d.i(i3Var2, 1.0f);
        this.d.i(i3Var3, f);
        this.d.i(i3Var4, -f);
        return this;
    }

    public d3 e(i3 i3Var, i3 i3Var2, i3 i3Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = (float) i;
        }
        if (!z) {
            this.d.i(i3Var, -1.0f);
            this.d.i(i3Var2, 1.0f);
            this.d.i(i3Var3, 1.0f);
        } else {
            this.d.i(i3Var, 1.0f);
            this.d.i(i3Var2, -1.0f);
            this.d.i(i3Var3, -1.0f);
        }
        return this;
    }

    public d3 f(i3 i3Var, i3 i3Var2, i3 i3Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = (float) i;
        }
        if (!z) {
            this.d.i(i3Var, -1.0f);
            this.d.i(i3Var2, 1.0f);
            this.d.i(i3Var3, -1.0f);
        } else {
            this.d.i(i3Var, 1.0f);
            this.d.i(i3Var2, -1.0f);
            this.d.i(i3Var3, 1.0f);
        }
        return this;
    }

    public d3 g(i3 i3Var, i3 i3Var2, i3 i3Var3, i3 i3Var4, float f) {
        this.d.i(i3Var3, 0.5f);
        this.d.i(i3Var4, 0.5f);
        this.d.i(i3Var, -0.5f);
        this.d.i(i3Var2, -0.5f);
        this.b = -f;
        return this;
    }

    public final boolean h(i3 i3Var) {
        return i3Var.l <= 1;
    }

    public final i3 i(boolean[] zArr, i3 i3Var) {
        i3.a aVar;
        int a2 = this.d.a();
        i3 i3Var2 = null;
        float f = 0.0f;
        for (int i = 0; i < a2; i++) {
            float d2 = this.d.d(i);
            if (d2 < 0.0f) {
                i3 b2 = this.d.b(i);
                if ((zArr == null || !zArr[b2.b]) && b2 != i3Var && (((aVar = b2.i) == i3.a.SLACK || aVar == i3.a.ERROR) && d2 < f)) {
                    f = d2;
                    i3Var2 = b2;
                }
            }
        }
        return i3Var2;
    }

    public void j(i3 i3Var) {
        i3 i3Var2 = this.f781a;
        if (i3Var2 != null) {
            this.d.i(i3Var2, -1.0f);
            this.f781a = null;
        }
        float j = this.d.j(i3Var, true) * -1.0f;
        this.f781a = i3Var;
        if (j != 1.0f) {
            this.b /= j;
            this.d.k(j);
        }
    }

    public void k(i3 i3Var, boolean z) {
        if (i3Var.f) {
            float f = this.d.f(i3Var);
            this.b = (i3Var.e * f) + this.b;
            this.d.j(i3Var, z);
            if (z) {
                i3Var.b(this);
            }
        }
    }

    public void l(d3 d3Var, boolean z) {
        float h = this.d.h(d3Var, z);
        this.b = (d3Var.b * h) + this.b;
        if (z) {
            d3Var.f781a.b(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d3.toString():java.lang.String");
    }

    public d3(e3 e3Var) {
        this.d = new c3(this, e3Var);
    }
}
