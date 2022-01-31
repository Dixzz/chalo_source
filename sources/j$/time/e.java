package j$.time;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.appindexing.Indexable;
import j$.time.chrono.b;
import j$.time.temporal.a;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.f;
import j$.time.temporal.g;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.util.Objects;

public final class e implements Object, Object, Comparable<e> {
    public static final e e;
    public static final e f = new e(23, 59, 59, 999999999);
    private static final e[] g = new e[24];

    /* renamed from: a  reason: collision with root package name */
    private final byte f1598a;
    private final byte b;
    private final byte c;
    private final int d;

    static {
        int i = 0;
        while (true) {
            e[] eVarArr = g;
            if (i < eVarArr.length) {
                eVarArr[i] = new e(i, 0, 0, 0);
                i++;
            } else {
                e eVar = eVarArr[0];
                e eVar2 = eVarArr[12];
                e = eVarArr[0];
                return;
            }
        }
    }

    private e(int i, int i2, int i3, int i4) {
        this.f1598a = (byte) i;
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.d = i4;
    }

    public static e A(long j) {
        h.NANO_OF_DAY.x(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        int i4 = (int) (j3 - (((long) i3) * 1000000000));
        return ((i2 | i3) | i4) == 0 ? g[i] : new e(i, i2, i3, i4);
    }

    public static e v(k kVar) {
        Objects.requireNonNull(kVar, "temporal");
        int i = m.f1638a;
        e eVar = (e) kVar.n(f.f1631a);
        if (eVar != null) {
            return eVar;
        }
        throw new b("Unable to obtain LocalTime from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName());
    }

    private int w(l lVar) {
        switch (((h) lVar).ordinal()) {
            case 0:
                return this.d;
            case 1:
                throw new p("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 2:
                return this.d / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
            case 3:
                throw new p("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 4:
                return this.d / 1000000;
            case 5:
                return (int) (B() / 1000000);
            case 6:
                return this.c;
            case 7:
                return C();
            case 8:
                return this.b;
            case 9:
                return (this.f1598a * 60) + this.b;
            case 10:
                return this.f1598a % 12;
            case 11:
                int i = this.f1598a % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 12:
                return this.f1598a;
            case 13:
                byte b2 = this.f1598a;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 14:
                return this.f1598a / 12;
            default:
                throw new p("Unsupported field: " + lVar);
        }
    }

    public static e z(int i, int i2) {
        h.HOUR_OF_DAY.x((long) i);
        if (i2 == 0) {
            return g[i];
        }
        h.MINUTE_OF_HOUR.x((long) i2);
        return new e(i, i2, 0, 0);
    }

    public long B() {
        return (((long) this.c) * 1000000000) + (((long) this.b) * 60000000000L) + (((long) this.f1598a) * 3600000000000L) + ((long) this.d);
    }

    public int C() {
        return (this.b * 60) + (this.f1598a * 3600) + this.c;
    }

    public boolean d(l lVar) {
        return lVar instanceof h ? lVar.j() : lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f1598a == eVar.f1598a && this.b == eVar.b && this.c == eVar.c && this.d == eVar.d;
    }

    public int h(l lVar) {
        return lVar instanceof h ? w(lVar) : b.f(this, lVar);
    }

    public int hashCode() {
        long B = B();
        return (int) (B ^ (B >>> 32));
    }

    public q j(l lVar) {
        return b.k(this, lVar);
    }

    public long l(l lVar) {
        return lVar instanceof h ? lVar == h.NANO_OF_DAY ? B() : lVar == h.MICRO_OF_DAY ? B() / 1000 : (long) w(lVar) : lVar.l(this);
    }

    public Object n(n nVar) {
        int i = m.f1638a;
        if (nVar == j$.time.temporal.b.f1627a || nVar == d.f1629a || nVar == g.f1632a || nVar == c.f1628a) {
            return null;
        }
        if (nVar == f.f1631a) {
            return this;
        }
        if (nVar == a.f1626a) {
            return null;
        }
        return nVar == j$.time.temporal.e.f1630a ? i.NANOS : nVar.a(this);
    }

    /* renamed from: t */
    public int compareTo(e eVar) {
        int compare = Integer.compare(this.f1598a, eVar.f1598a);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Integer.compare(this.b, eVar.b);
        if (compare2 != 0) {
            return compare2;
        }
        int compare3 = Integer.compare(this.c, eVar.c);
        return compare3 == 0 ? Integer.compare(this.d, eVar.d) : compare3;
    }

    public String toString() {
        int i;
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.f1598a;
        byte b3 = this.b;
        byte b4 = this.c;
        int i2 = this.d;
        sb.append(b2 < 10 ? "0" : "");
        sb.append((int) b2);
        String str = ":0";
        sb.append(b3 < 10 ? str : ProductDiscountsObject.KEY_DELIMITER);
        sb.append((int) b3);
        if (b4 > 0 || i2 > 0) {
            if (b4 >= 10) {
                str = ProductDiscountsObject.KEY_DELIMITER;
            }
            sb.append(str);
            sb.append((int) b4);
            if (i2 > 0) {
                sb.append('.');
                int i3 = 1000000;
                if (i2 % 1000000 == 0) {
                    i = (i2 / 1000000) + Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
                } else {
                    if (i2 % Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL == 0) {
                        i2 /= Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
                    } else {
                        i3 = 1000000000;
                    }
                    i = i2 + i3;
                }
                sb.append(Integer.toString(i).substring(1));
            }
        }
        return sb.toString();
    }

    public int x() {
        return this.d;
    }

    public int y() {
        return this.c;
    }
}
