package j$.time;

import a.C0081e;
import a.C0083f;
import j$.time.chrono.b;
import j$.time.chrono.c;
import j$.time.chrono.d;
import j$.time.chrono.i;
import j$.time.chrono.j;
import j$.time.temporal.a;
import j$.time.temporal.h;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.util.Objects;

public final class LocalDateTime implements Object, Object, d<d> {
    public static final LocalDateTime c = y(d.d, e.e);
    public static final LocalDateTime d = y(d.e, e.f);

    /* renamed from: a  reason: collision with root package name */
    private final d f1591a;
    private final e b;

    private LocalDateTime(d dVar, e eVar) {
        this.f1591a = dVar;
        this.b = eVar;
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return z(instant.w(), instant.x(), zoneId.t().c(instant));
    }

    public static LocalDateTime v(k kVar) {
        if (kVar instanceof LocalDateTime) {
            return (LocalDateTime) kVar;
        }
        if (kVar instanceof j) {
            return ((j) kVar).v();
        }
        if (kVar instanceof g) {
            return ((g) kVar).v();
        }
        try {
            return new LocalDateTime(d.v(kVar), e.v(kVar));
        } catch (b e) {
            throw new b("Unable to obtain LocalDateTime from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName(), e);
        }
    }

    public static LocalDateTime x(int i, int i2, int i3, int i4, int i5) {
        return new LocalDateTime(d.D(i, i2, i3), e.z(i4, i5));
    }

    public static LocalDateTime y(d dVar, e eVar) {
        Objects.requireNonNull(dVar, "date");
        Objects.requireNonNull(eVar, "time");
        return new LocalDateTime(dVar, eVar);
    }

    public static LocalDateTime z(long j, int i, h hVar) {
        Objects.requireNonNull(hVar, "offset");
        long j2 = (long) i;
        h.NANO_OF_SECOND.x(j2);
        long x = j + ((long) hVar.x());
        return new LocalDateTime(d.E(C0081e.a(x, 86400)), e.A((((long) ((int) C0083f.a(x, 86400))) * 1000000000) + j2));
    }

    public /* synthetic */ long A(h hVar) {
        return b.l(this, hVar);
    }

    public d B() {
        return this.f1591a;
    }

    @Override // j$.time.chrono.d
    public i a() {
        Objects.requireNonNull(this.f1591a);
        return j.f1596a;
    }

    @Override // j$.time.chrono.d
    public e b() {
        return this.b;
    }

    @Override // j$.time.chrono.d
    public c c() {
        return this.f1591a;
    }

    public boolean d(l lVar) {
        if (!(lVar instanceof h)) {
            return lVar != null && lVar.n(this);
        }
        h hVar = (h) lVar;
        return hVar.v() || hVar.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.f1591a.equals(localDateTime.f1591a) && this.b.equals(localDateTime.b);
    }

    public int getDayOfMonth() {
        return this.f1591a.x();
    }

    public int getMonthValue() {
        return this.f1591a.A();
    }

    public int getYear() {
        return this.f1591a.B();
    }

    public int h(l lVar) {
        return lVar instanceof h ? ((h) lVar).j() ? this.b.h(lVar) : this.f1591a.h(lVar) : b.f(this, lVar);
    }

    public int hashCode() {
        return this.f1591a.hashCode() ^ this.b.hashCode();
    }

    public q j(l lVar) {
        if (!(lVar instanceof h)) {
            return lVar.t(this);
        }
        if (!((h) lVar).j()) {
            return this.f1591a.j(lVar);
        }
        e eVar = this.b;
        Objects.requireNonNull(eVar);
        return b.k(eVar, lVar);
    }

    public long l(l lVar) {
        return lVar instanceof h ? ((h) lVar).j() ? this.b.l(lVar) : this.f1591a.l(lVar) : lVar.l(this);
    }

    public Object n(n nVar) {
        int i = m.f1638a;
        return nVar == a.f1626a ? this.f1591a : b.i(this, nVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: p */
    public int compareTo(d dVar) {
        if (!(dVar instanceof LocalDateTime)) {
            return b.d(this, dVar);
        }
        LocalDateTime localDateTime = (LocalDateTime) dVar;
        int t = this.f1591a.t(localDateTime.f1591a);
        return t == 0 ? this.b.compareTo(localDateTime.b) : t;
    }

    public g t(h hVar) {
        return g.t(this, hVar);
    }

    public String toString() {
        return this.f1591a.toString() + 'T' + this.b.toString();
    }

    public int w() {
        return this.b.y();
    }
}
