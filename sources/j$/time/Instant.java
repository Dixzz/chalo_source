package j$.time;

import a.C0079d;
import a.C0081e;
import a.C0083f;
import a.C0085g;
import com.google.firebase.appindexing.Indexable;
import j$.time.chrono.b;
import j$.time.temporal.a;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.e;
import j$.time.temporal.f;
import j$.time.temporal.g;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;

public final class Instant implements Object, Object, Comparable<Instant> {
    public static final Instant c = new Instant(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f1590a;
    private final int b;

    static {
        y(-31557014167219200L, 0);
        y(31556889864403199L, 999999999);
    }

    private Instant(long j, int i) {
        this.f1590a = j;
        this.b = i;
    }

    public static Instant ofEpochMilli(long j) {
        return v(C0081e.a(j, 1000), ((int) C0083f.a(j, 1000)) * 1000000);
    }

    private static Instant v(long j, int i) {
        if ((((long) i) | j) == 0) {
            return c;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new Instant(j, i);
        }
        throw new b("Instant exceeds minimum or maximum instant");
    }

    public static Instant y(long j, long j2) {
        return v(C0079d.a(j, C0081e.a(j2, 1000000000)), (int) C0083f.a(j2, 1000000000));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        Instant instant2 = instant;
        int compare = Long.compare(this.f1590a, instant2.f1590a);
        return compare != 0 ? compare : this.b - instant2.b;
    }

    public boolean d(l lVar) {
        return lVar instanceof h ? lVar == h.INSTANT_SECONDS || lVar == h.NANO_OF_SECOND || lVar == h.MICRO_OF_SECOND || lVar == h.MILLI_OF_SECOND : lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f1590a == instant.f1590a && this.b == instant.b;
    }

    public int h(l lVar) {
        if (!(lVar instanceof h)) {
            return b.k(this, lVar).a(lVar.l(this), lVar);
        }
        int ordinal = ((h) lVar).ordinal();
        if (ordinal == 0) {
            return this.b;
        }
        if (ordinal == 2) {
            return this.b / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        }
        if (ordinal == 4) {
            return this.b / 1000000;
        }
        if (ordinal == 28) {
            h.INSTANT_SECONDS.w(this.f1590a);
        }
        throw new p("Unsupported field: " + lVar);
    }

    public int hashCode() {
        long j = this.f1590a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public q j(l lVar) {
        return b.k(this, lVar);
    }

    public long l(l lVar) {
        int i;
        if (!(lVar instanceof h)) {
            return lVar.l(this);
        }
        int ordinal = ((h) lVar).ordinal();
        if (ordinal == 0) {
            i = this.b;
        } else if (ordinal == 2) {
            i = this.b / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        } else if (ordinal == 4) {
            i = this.b / 1000000;
        } else if (ordinal == 28) {
            return this.f1590a;
        } else {
            throw new p("Unsupported field: " + lVar);
        }
        return (long) i;
    }

    public Object n(n nVar) {
        int i = m.f1638a;
        if (nVar == e.f1630a) {
            return i.NANOS;
        }
        if (nVar == j$.time.temporal.b.f1627a || nVar == d.f1629a || nVar == g.f1632a || nVar == c.f1628a || nVar == a.f1626a || nVar == f.f1631a) {
            return null;
        }
        return nVar.a(this);
    }

    public int t(Instant instant) {
        int compare = Long.compare(this.f1590a, instant.f1590a);
        return compare != 0 ? compare : this.b - instant.b;
    }

    public String toString() {
        return j$.time.format.b.f.a(this);
    }

    public long w() {
        return this.f1590a;
    }

    public int x() {
        return this.b;
    }

    public long z() {
        long a2;
        int i;
        long j = this.f1590a;
        if (j >= 0 || this.b <= 0) {
            a2 = C0085g.a(j, 1000);
            i = this.b / 1000000;
        } else {
            a2 = C0085g.a(j + 1, 1000);
            i = (this.b / 1000000) - 1000;
        }
        return C0079d.a(a2, (long) i);
    }
}
