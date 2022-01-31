package j$.time.chrono;

import j$.time.chrono.g;
import j$.time.temporal.b;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.e;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;

public final /* synthetic */ class f {
    public static int a(g gVar, g gVar2) {
        int compare = Long.compare(gVar.u(), gVar2.u());
        if (compare != 0) {
            return compare;
        }
        int x = gVar.b().x() - gVar2.b().x();
        if (x != 0) {
            return x;
        }
        int p = gVar.q().p(gVar2.q());
        if (p != 0) {
            return p;
        }
        int compareTo = gVar.k().g().compareTo(gVar2.k().g());
        return compareTo == 0 ? gVar.a().e(gVar2.a()) : compareTo;
    }

    public static int b(g gVar, l lVar) {
        if (!(lVar instanceof h)) {
            return b.f(gVar, lVar);
        }
        int i = g.a.f1594a[((h) lVar).ordinal()];
        if (i != 1) {
            return i != 2 ? gVar.q().h(lVar) : gVar.f().x();
        }
        throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public static Object c(g gVar, n nVar) {
        int i = m.f1638a;
        return (nVar == j$.time.temporal.g.f1632a || nVar == d.f1629a) ? gVar.k() : nVar == c.f1628a ? gVar.f() : nVar == j$.time.temporal.f.f1631a ? gVar.b() : nVar == b.f1627a ? gVar.a() : nVar == e.f1630a ? i.NANOS : nVar.a(gVar);
    }

    public static long d(g gVar) {
        return ((gVar.c().m() * 86400) + ((long) gVar.b().C())) - ((long) gVar.f().x());
    }
}
