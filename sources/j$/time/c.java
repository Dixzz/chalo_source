package j$.time;

import j$.time.chrono.b;
import j$.time.temporal.e;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;

public enum c implements k {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    

    /* renamed from: a  reason: collision with root package name */
    private static final c[] f1593a = values();

    public static c v(int i) {
        if (i >= 1 && i <= 7) {
            return f1593a[i - 1];
        }
        throw new b("Invalid value for DayOfWeek: " + i);
    }

    @Override // j$.time.temporal.k
    public boolean d(l lVar) {
        return lVar instanceof h ? lVar == h.DAY_OF_WEEK : lVar != null && lVar.n(this);
    }

    @Override // j$.time.temporal.k
    public int h(l lVar) {
        return lVar == h.DAY_OF_WEEK ? t() : b.f(this, lVar);
    }

    @Override // j$.time.temporal.k
    public q j(l lVar) {
        return lVar == h.DAY_OF_WEEK ? lVar.h() : b.k(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long l(l lVar) {
        if (lVar == h.DAY_OF_WEEK) {
            return (long) t();
        }
        if (!(lVar instanceof h)) {
            return lVar.l(this);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i = m.f1638a;
        return nVar == e.f1630a ? i.DAYS : b.j(this, nVar);
    }

    public int t() {
        return ordinal() + 1;
    }
}
