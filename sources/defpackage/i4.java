package defpackage;

import defpackage.n3;

/* renamed from: i4  reason: default package */
/* compiled from: WidgetRun */
public abstract class i4 implements z3 {

    /* renamed from: a  reason: collision with root package name */
    public int f1472a;
    public n3 b;
    public g4 c;
    public n3.a d;
    public c4 e = new c4(this);
    public int f = 0;
    public boolean g = false;
    public b4 h = new b4(this);
    public b4 i = new b4(this);
    public a j = a.NONE;

    /* renamed from: i4$a */
    /* compiled from: WidgetRun */
    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public i4(n3 n3Var) {
        this.b = n3Var;
    }

    @Override // defpackage.z3
    public void a(z3 z3Var) {
    }

    public final void b(b4 b4Var, b4 b4Var2, int i2) {
        b4Var.l.add(b4Var2);
        b4Var.f = i2;
        b4Var2.k.add(b4Var);
    }

    public final void c(b4 b4Var, b4 b4Var2, int i2, c4 c4Var) {
        b4Var.l.add(b4Var2);
        b4Var.l.add(this.e);
        b4Var.h = i2;
        b4Var.i = c4Var;
        b4Var2.k.add(b4Var);
        c4Var.k.add(b4Var);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            n3 n3Var = this.b;
            int i5 = n3Var.n;
            i4 = Math.max(n3Var.m, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            n3 n3Var2 = this.b;
            int i6 = n3Var2.q;
            i4 = Math.max(n3Var2.p, i2);
            if (i6 > 0) {
                i4 = Math.min(i6, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        }
        return i4;
    }

    public final b4 h(m3 m3Var) {
        m3 m3Var2 = m3Var.d;
        if (m3Var2 == null) {
            return null;
        }
        n3 n3Var = m3Var2.b;
        int ordinal = m3Var2.c.ordinal();
        if (ordinal == 1) {
            return n3Var.d.h;
        }
        if (ordinal == 2) {
            return n3Var.e.h;
        }
        if (ordinal == 3) {
            return n3Var.d.i;
        }
        if (ordinal == 4) {
            return n3Var.e.i;
        }
        if (ordinal != 5) {
            return null;
        }
        return n3Var.e.k;
    }

    public final b4 i(m3 m3Var, int i2) {
        m3 m3Var2 = m3Var.d;
        if (m3Var2 == null) {
            return null;
        }
        n3 n3Var = m3Var2.b;
        i4 i4Var = i2 == 0 ? n3Var.d : n3Var.e;
        int ordinal = m3Var2.c.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return i4Var.h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return i4Var.i;
        }
        return null;
    }

    public long j() {
        c4 c4Var = this.e;
        if (c4Var.j) {
            return (long) c4Var.g;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r10.f1472a == 3) goto L_0x00b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(defpackage.m3 r13, defpackage.m3 r14, int r15) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i4.l(m3, m3, int):void");
    }
}
