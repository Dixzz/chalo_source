package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.i3;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: m3  reason: default package */
/* compiled from: ConstraintAnchor */
public class m3 {

    /* renamed from: a  reason: collision with root package name */
    public HashSet<m3> f2314a = null;
    public final n3 b;
    public final a c;
    public m3 d;
    public int e = 0;
    public int f = -1;
    public i3 g;

    /* renamed from: m3$a */
    /* compiled from: ConstraintAnchor */
    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public m3(n3 n3Var, a aVar) {
        this.b = n3Var;
        this.c = aVar;
    }

    public boolean a(m3 m3Var, int i) {
        return b(m3Var, i, -1, false);
    }

    public boolean b(m3 m3Var, int i, int i2, boolean z) {
        if (m3Var == null) {
            h();
            return true;
        } else if (!z && !g(m3Var)) {
            return false;
        } else {
            this.d = m3Var;
            if (m3Var.f2314a == null) {
                m3Var.f2314a = new HashSet<>();
            }
            this.d.f2314a.add(this);
            if (i > 0) {
                this.e = i;
            } else {
                this.e = 0;
            }
            this.f = i2;
            return true;
        }
    }

    public int c() {
        m3 m3Var;
        if (this.b.X == 8) {
            return 0;
        }
        int i = this.f;
        if (i <= -1 || (m3Var = this.d) == null || m3Var.b.X != 8) {
            return this.e;
        }
        return i;
    }

    public final m3 d() {
        switch (this.c.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return this.b.A;
            case 2:
                return this.b.B;
            case 3:
                return this.b.y;
            case 4:
                return this.b.z;
            default:
                throw new AssertionError(this.c.name());
        }
    }

    public boolean e() {
        HashSet<m3> hashSet = this.f2314a;
        if (hashSet == null) {
            return false;
        }
        Iterator<m3> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().d().f()) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g(m3 m3Var) {
        boolean z = false;
        if (m3Var == null) {
            return false;
        }
        a aVar = m3Var.c;
        a aVar2 = this.c;
        if (aVar != aVar2) {
            switch (aVar2.ordinal()) {
                case 0:
                case 5:
                case 7:
                case 8:
                    return false;
                case 1:
                case 3:
                    boolean z2 = aVar == a.LEFT || aVar == a.RIGHT;
                    if (!(m3Var.b instanceof q3)) {
                        return z2;
                    }
                    if (z2 || aVar == a.CENTER_X) {
                        z = true;
                    }
                    return z;
                case 2:
                case 4:
                    boolean z3 = aVar == a.TOP || aVar == a.BOTTOM;
                    if (!(m3Var.b instanceof q3)) {
                        return z3;
                    }
                    if (z3 || aVar == a.CENTER_Y) {
                        z = true;
                    }
                    return z;
                case 6:
                    if (aVar == a.BASELINE || aVar == a.CENTER_X || aVar == a.CENTER_Y) {
                        return false;
                    }
                    return true;
                default:
                    throw new AssertionError(this.c.name());
            }
        } else if (aVar2 != a.BASELINE || (m3Var.b.w && this.b.w)) {
            return true;
        } else {
            return false;
        }
    }

    public void h() {
        HashSet<m3> hashSet;
        m3 m3Var = this.d;
        if (!(m3Var == null || (hashSet = m3Var.f2314a) == null)) {
            hashSet.remove(this);
        }
        this.d = null;
        this.e = 0;
        this.f = -1;
    }

    public void i() {
        i3 i3Var = this.g;
        if (i3Var == null) {
            this.g = new i3(i3.a.UNRESTRICTED);
        } else {
            i3Var.c();
        }
    }

    public void j(int i) {
        if (f()) {
            this.f = i;
        }
    }

    public String toString() {
        return this.b.Y + ProductDiscountsObject.KEY_DELIMITER + this.c.toString();
    }
}
