package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.n3;
import java.util.ArrayList;

/* renamed from: x3  reason: default package */
/* compiled from: BasicMeasure */
public class x3 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<n3> f3876a = new ArrayList<>();
    public a b = new a();
    public o3 c;

    /* renamed from: x3$a */
    /* compiled from: BasicMeasure */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public n3.a f3877a;
        public n3.a b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public boolean j;
    }

    /* renamed from: x3$b */
    /* compiled from: BasicMeasure */
    public interface b {
    }

    public x3(o3 o3Var) {
        this.c = o3Var;
    }

    public final boolean a(b bVar, n3 n3Var, boolean z) {
        this.b.f3877a = n3Var.l();
        this.b.b = n3Var.p();
        this.b.c = n3Var.q();
        this.b.d = n3Var.k();
        a aVar = this.b;
        aVar.i = false;
        aVar.j = z;
        n3.a aVar2 = aVar.f3877a;
        n3.a aVar3 = n3.a.MATCH_CONSTRAINT;
        boolean z2 = aVar2 == aVar3;
        boolean z3 = aVar.b == aVar3;
        boolean z4 = z2 && n3Var.N > 0.0f;
        boolean z5 = z3 && n3Var.N > 0.0f;
        if (z4 && n3Var.l[0] == 4) {
            aVar.f3877a = n3.a.FIXED;
        }
        if (z5 && n3Var.l[1] == 4) {
            aVar.b = n3.a.FIXED;
        }
        ((ConstraintLayout.b) bVar).a(n3Var, aVar);
        n3Var.G(this.b.e);
        n3Var.B(this.b.f);
        a aVar4 = this.b;
        n3Var.w = aVar4.h;
        n3Var.A(aVar4.g);
        a aVar5 = this.b;
        aVar5.j = false;
        return aVar5.i;
    }

    public final void b(o3 o3Var, int i, int i2) {
        int i3 = o3Var.S;
        int i4 = o3Var.T;
        o3Var.E(0);
        o3Var.D(0);
        o3Var.L = i;
        int i5 = o3Var.S;
        if (i < i5) {
            o3Var.L = i5;
        }
        o3Var.M = i2;
        int i6 = o3Var.T;
        if (i2 < i6) {
            o3Var.M = i6;
        }
        o3Var.E(i3);
        o3Var.D(i4);
        this.c.J();
    }
}
