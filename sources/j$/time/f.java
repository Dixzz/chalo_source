package j$.time;

import j$.time.chrono.b;
import j$.time.chrono.j;
import j$.time.temporal.e;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;

public enum f implements k {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    

    /* renamed from: a  reason: collision with root package name */
    private static final f[] f1599a = values();

    public static f w(int i) {
        if (i >= 1 && i <= 12) {
            return f1599a[i - 1];
        }
        throw new b("Invalid value for MonthOfYear: " + i);
    }

    @Override // j$.time.temporal.k
    public boolean d(l lVar) {
        return lVar instanceof h ? lVar == h.MONTH_OF_YEAR : lVar != null && lVar.n(this);
    }

    @Override // j$.time.temporal.k
    public int h(l lVar) {
        return lVar == h.MONTH_OF_YEAR ? v() : b.f(this, lVar);
    }

    @Override // j$.time.temporal.k
    public q j(l lVar) {
        return lVar == h.MONTH_OF_YEAR ? lVar.h() : b.k(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long l(l lVar) {
        if (lVar == h.MONTH_OF_YEAR) {
            return (long) v();
        }
        if (!(lVar instanceof h)) {
            return lVar.l(this);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i = m.f1638a;
        return nVar == j$.time.temporal.b.f1627a ? j.f1596a : nVar == e.f1630a ? i.MONTHS : b.j(this, nVar);
    }

    public int t(boolean z) {
        int i;
        switch (ordinal()) {
            case 0:
                return 1;
            case 1:
                return 32;
            case 2:
                i = 60;
                break;
            case 3:
                i = 91;
                break;
            case 4:
                i = 121;
                break;
            case 5:
                i = 152;
                break;
            case 6:
                i = 182;
                break;
            case 7:
                i = 213;
                break;
            case 8:
                i = 244;
                break;
            case 9:
                i = 274;
                break;
            case 10:
                i = 305;
                break;
            default:
                i = 335;
                break;
        }
        return (z ? 1 : 0) + i;
    }

    public int v() {
        return ordinal() + 1;
    }

    public f x(long j) {
        return f1599a[((((int) (j % 12)) + 12) + ordinal()) % 12];
    }
}
