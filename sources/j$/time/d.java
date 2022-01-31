package j$.time;

import a.C0083f;
import j$.com.android.tools.r8.a;
import j$.time.chrono.b;
import j$.time.chrono.c;
import j$.time.chrono.i;
import j$.time.chrono.j;
import j$.time.temporal.e;
import j$.time.temporal.f;
import j$.time.temporal.g;
import j$.time.temporal.h;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;

public final class d implements k, c, Serializable {
    public static final d d = D(-999999999, 1, 1);
    public static final d e = D(999999999, 12, 31);

    /* renamed from: a  reason: collision with root package name */
    private final int f1597a;
    private final short b;
    private final short c;

    private d(int i, int i2, int i3) {
        this.f1597a = i;
        this.b = (short) i2;
        this.c = (short) i3;
    }

    public static d D(int i, int i2, int i3) {
        long j = (long) i;
        h.YEAR.x(j);
        h.MONTH_OF_YEAR.x((long) i2);
        h.DAY_OF_MONTH.x((long) i3);
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (j.f1596a.h(j)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    throw new b("Invalid date 'February 29' as '" + i + "' is not a leap year");
                }
                StringBuilder a2 = a.a("Invalid date '");
                a2.append(f.w(i2).name());
                a2.append(" ");
                a2.append(i3);
                a2.append("'");
                throw new b(a2.toString());
            }
        }
        return new d(i, i2, i3);
    }

    public static d E(long j) {
        long j2;
        long j3 = (j + 719528) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        return new d(h.YEAR.w(j5 + j2 + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static d v(k kVar) {
        Objects.requireNonNull(kVar, "temporal");
        int i = m.f1638a;
        d dVar = (d) kVar.n(j$.time.temporal.a.f1626a);
        if (dVar != null) {
            return dVar;
        }
        throw new b("Unable to obtain LocalDate from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName());
    }

    private int w(l lVar) {
        switch (((h) lVar).ordinal()) {
            case 15:
                return y().t();
            case 16:
                return ((this.c - 1) % 7) + 1;
            case 17:
                return ((z() - 1) % 7) + 1;
            case 18:
                return this.c;
            case 19:
                return z();
            case 20:
                throw new p("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 21:
                return ((this.c - 1) / 7) + 1;
            case 22:
                return ((z() - 1) / 7) + 1;
            case 23:
                return this.b;
            case 24:
                throw new p("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 25:
                int i = this.f1597a;
                return i >= 1 ? i : 1 - i;
            case 26:
                return this.f1597a;
            case 27:
                return this.f1597a >= 1 ? 1 : 0;
            default:
                throw new p("Unsupported field: " + lVar);
        }
    }

    public int A() {
        return this.b;
    }

    public int B() {
        return this.f1597a;
    }

    public boolean C() {
        return j.f1596a.h((long) this.f1597a);
    }

    public d F(long j) {
        int i;
        if (j == 0) {
            return this;
        }
        int w = h.YEAR.w(((long) this.f1597a) + j);
        short s = this.b;
        int i2 = this.c;
        if (s != 2) {
            if (s == 4 || s == 6 || s == 9 || s == 11) {
                i = 30;
            }
            return new d(w, s, i2);
        }
        i = j.f1596a.h((long) w) ? 29 : 28;
        i2 = Math.min(i2, i);
        return new d(w, s, i2);
    }

    public d G(int i) {
        if (z() == i) {
            return this;
        }
        int i2 = this.f1597a;
        long j = (long) i2;
        h.YEAR.x(j);
        h.DAY_OF_YEAR.x((long) i);
        boolean h = j.f1596a.h(j);
        if (i != 366 || h) {
            int i3 = 31;
            f w = f.w(((i - 1) / 31) + 1);
            int t = w.t(h);
            int ordinal = w.ordinal();
            if (ordinal == 1) {
                i3 = h ? 29 : 28;
            } else if (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) {
                i3 = 30;
            }
            if (i > (t + i3) - 1) {
                w = w.x(1);
            }
            return new d(i2, w.v(), (i - w.t(h)) + 1);
        }
        throw new b("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
    }

    @Override // j$.time.chrono.c
    public i a() {
        return j.f1596a;
    }

    @Override // j$.time.chrono.c, j$.time.temporal.k
    public boolean d(l lVar) {
        if (lVar instanceof h) {
            return lVar.v();
        }
        return lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && t((d) obj) == 0;
    }

    @Override // j$.time.temporal.k
    public int h(l lVar) {
        return lVar instanceof h ? w(lVar) : b.f(this, lVar);
    }

    public int hashCode() {
        int i = this.f1597a;
        return (((i << 11) + (this.b << 6)) + this.c) ^ (i & -2048);
    }

    @Override // j$.time.temporal.k
    public q j(l lVar) {
        int i;
        if (!(lVar instanceof h)) {
            return lVar.t(this);
        }
        h hVar = (h) lVar;
        if (hVar.v()) {
            int ordinal = hVar.ordinal();
            if (ordinal == 18) {
                short s = this.b;
                i = s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : C() ? 29 : 28;
            } else if (ordinal == 19) {
                i = C() ? 366 : 365;
            } else if (ordinal == 21) {
                return q.i(1, (f.w(this.b) != f.FEBRUARY || C()) ? 5 : 4);
            } else if (ordinal != 25) {
                return lVar.h();
            } else {
                return q.i(1, this.f1597a <= 0 ? 1000000000 : 999999999);
            }
            return q.i(1, (long) i);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public long l(l lVar) {
        if (!(lVar instanceof h)) {
            return lVar.l(this);
        }
        if (lVar == h.EPOCH_DAY) {
            return m();
        }
        if (lVar == h.PROLEPTIC_MONTH) {
            return ((((long) this.f1597a) * 12) + ((long) this.b)) - 1;
        }
        return (long) w(lVar);
    }

    @Override // j$.time.chrono.c
    public long m() {
        long j;
        long j2 = (long) this.f1597a;
        long j3 = (long) this.b;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / -400) + ((j2 / -4) - (j2 / -100)));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + ((long) (this.c - 1));
        if (j3 > 2) {
            j5--;
            if (!C()) {
                j5--;
            }
        }
        return j5 - 719528;
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i = m.f1638a;
        if (nVar == j$.time.temporal.a.f1626a) {
            return this;
        }
        if (nVar == j$.time.temporal.d.f1629a || nVar == g.f1632a || nVar == j$.time.temporal.c.f1628a || nVar == f.f1631a) {
            return null;
        }
        if (nVar != j$.time.temporal.b.f1627a) {
            return nVar == e.f1630a ? j$.time.temporal.i.DAYS : nVar.a(this);
        }
        a();
        return j.f1596a;
    }

    @Override // j$.time.chrono.c
    /* renamed from: s */
    public int compareTo(c cVar) {
        if (cVar instanceof d) {
            return t((d) cVar);
        }
        int compare = Long.compare(m(), cVar.m());
        if (compare != 0) {
            return compare;
        }
        a();
        return j.f1596a.compareTo(cVar.a());
    }

    /* access modifiers changed from: package-private */
    public int t(d dVar) {
        int i = this.f1597a - dVar.f1597a;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - dVar.b;
        return i2 == 0 ? this.c - dVar.c : i2;
    }

    public String toString() {
        int i;
        int i2 = this.f1597a;
        short s = this.b;
        short s2 = this.c;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        }
        String str = "-0";
        sb.append(s < 10 ? str : "-");
        sb.append((int) s);
        if (s2 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append((int) s2);
        return sb.toString();
    }

    public int x() {
        return this.c;
    }

    public c y() {
        return c.v(((int) C0083f.a(m() + 3, 7)) + 1);
    }

    public int z() {
        return (f.w(this.b).t(C()) + this.c) - 1;
    }
}
