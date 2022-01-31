package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: y3  reason: default package */
/* compiled from: ChainRun */
public class y3 extends i4 {
    public ArrayList<i4> k = new ArrayList<>();
    public int l;

    public y3(n3 n3Var, int i) {
        super(n3Var);
        i4 i4Var;
        int i2;
        i4 i4Var2;
        this.f = i;
        n3 n3Var2 = this.b;
        n3 n = n3Var2.n(i);
        while (true) {
            n3Var2 = n;
            if (n3Var2 == null) {
                break;
            }
            n = n3Var2.n(this.f);
        }
        this.b = n3Var2;
        ArrayList<i4> arrayList = this.k;
        int i3 = this.f;
        if (i3 == 0) {
            i4Var = n3Var2.d;
        } else {
            i4Var = i3 == 1 ? n3Var2.e : null;
        }
        arrayList.add(i4Var);
        n3 m = n3Var2.m(this.f);
        while (m != null) {
            ArrayList<i4> arrayList2 = this.k;
            int i4 = this.f;
            if (i4 == 0) {
                i4Var2 = m.d;
            } else {
                i4Var2 = i4 == 1 ? m.e : null;
            }
            arrayList2.add(i4Var2);
            m = m.m(this.f);
        }
        Iterator<i4> it = this.k.iterator();
        while (it.hasNext()) {
            i4 next = it.next();
            int i5 = this.f;
            if (i5 == 0) {
                next.b.b = this;
            } else if (i5 == 1) {
                next.b.c = this;
            }
        }
        if ((this.f == 0 && ((o3) this.b.K).i0) && this.k.size() > 1) {
            ArrayList<i4> arrayList3 = this.k;
            this.b = arrayList3.get(arrayList3.size() - 1).b;
        }
        if (this.f == 0) {
            i2 = this.b.Z;
        } else {
            i2 = this.b.a0;
        }
        this.l = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00da  */
    @Override // defpackage.z3, defpackage.i4
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(defpackage.z3 r26) {
        /*
        // Method dump skipped, instructions count: 1051
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y3.a(z3):void");
    }

    @Override // defpackage.i4
    public void d() {
        Iterator<i4> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.k.size();
        if (size >= 1) {
            n3 n3Var = this.k.get(0).b;
            n3 n3Var2 = this.k.get(size - 1).b;
            if (this.f == 0) {
                m3 m3Var = n3Var.y;
                m3 m3Var2 = n3Var2.A;
                b4 i = i(m3Var, 0);
                int c = m3Var.c();
                n3 m = m();
                if (m != null) {
                    c = m.y.c();
                }
                if (i != null) {
                    b4 b4Var = this.h;
                    b4Var.l.add(i);
                    b4Var.f = c;
                    i.k.add(b4Var);
                }
                b4 i2 = i(m3Var2, 0);
                int c2 = m3Var2.c();
                n3 n = n();
                if (n != null) {
                    c2 = n.A.c();
                }
                if (i2 != null) {
                    b4 b4Var2 = this.i;
                    b4Var2.l.add(i2);
                    b4Var2.f = -c2;
                    i2.k.add(b4Var2);
                }
            } else {
                m3 m3Var3 = n3Var.z;
                m3 m3Var4 = n3Var2.B;
                b4 i3 = i(m3Var3, 1);
                int c3 = m3Var3.c();
                n3 m2 = m();
                if (m2 != null) {
                    c3 = m2.z.c();
                }
                if (i3 != null) {
                    b4 b4Var3 = this.h;
                    b4Var3.l.add(i3);
                    b4Var3.f = c3;
                    i3.k.add(b4Var3);
                }
                b4 i4 = i(m3Var4, 1);
                int c4 = m3Var4.c();
                n3 n2 = n();
                if (n2 != null) {
                    c4 = n2.B.c();
                }
                if (i4 != null) {
                    b4 b4Var4 = this.i;
                    b4Var4.l.add(i4);
                    b4Var4.f = -c4;
                    i4.k.add(b4Var4);
                }
            }
            this.h.f374a = this;
            this.i.f374a = this;
        }
    }

    @Override // defpackage.i4
    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            this.k.get(i).e();
        }
    }

    @Override // defpackage.i4
    public void f() {
        this.c = null;
        Iterator<i4> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // defpackage.i4
    public long j() {
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i4 i4Var = this.k.get(i);
            j = ((long) i4Var.i.f) + i4Var.j() + j + ((long) i4Var.h.f);
        }
        return j;
    }

    @Override // defpackage.i4
    public boolean k() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            if (!this.k.get(i).k()) {
                return false;
            }
        }
        return true;
    }

    public final n3 m() {
        for (int i = 0; i < this.k.size(); i++) {
            n3 n3Var = this.k.get(i).b;
            if (n3Var.X != 8) {
                return n3Var;
            }
        }
        return null;
    }

    public final n3 n() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            n3 n3Var = this.k.get(size).b;
            if (n3Var.X != 8) {
                return n3Var;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ChainRun ");
        i0.append(this.f == 0 ? "horizontal : " : "vertical : ");
        String sb = i0.toString();
        Iterator<i4> it = this.k.iterator();
        while (it.hasNext()) {
            String S = hj1.S(sb, "<");
            sb = hj1.S(S + it.next(), "> ");
        }
        return sb;
    }
}
