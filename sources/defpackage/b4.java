package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b4  reason: default package */
/* compiled from: DependencyNode */
public class b4 implements z3 {

    /* renamed from: a  reason: collision with root package name */
    public z3 f374a = null;
    public boolean b = false;
    public boolean c = false;
    public i4 d;
    public a e = a.UNKNOWN;
    public int f;
    public int g;
    public int h = 1;
    public c4 i = null;
    public boolean j = false;
    public List<z3> k = new ArrayList();
    public List<b4> l = new ArrayList();

    /* renamed from: b4$a */
    /* compiled from: DependencyNode */
    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public b4(i4 i4Var) {
        this.d = i4Var;
    }

    @Override // defpackage.z3
    public void a(z3 z3Var) {
        for (b4 b4Var : this.l) {
            if (!b4Var.j) {
                return;
            }
        }
        this.c = true;
        z3 z3Var2 = this.f374a;
        if (z3Var2 != null) {
            z3Var2.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        b4 b4Var2 = null;
        int i2 = 0;
        for (b4 b4Var3 : this.l) {
            if (!(b4Var3 instanceof c4)) {
                i2++;
                b4Var2 = b4Var3;
            }
        }
        if (b4Var2 != null && i2 == 1 && b4Var2.j) {
            c4 c4Var = this.i;
            if (c4Var != null) {
                if (c4Var.j) {
                    this.f = this.h * c4Var.g;
                } else {
                    return;
                }
            }
            c(b4Var2.g + this.f);
        }
        z3 z3Var3 = this.f374a;
        if (z3Var3 != null) {
            z3Var3.a(this);
        }
    }

    public void b() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void c(int i2) {
        if (!this.j) {
            this.j = true;
            this.g = i2;
            for (z3 z3Var : this.k) {
                z3Var.a(z3Var);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.Y);
        sb.append(ProductDiscountsObject.KEY_DELIMITER);
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
