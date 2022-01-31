package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.chrono.c;
import j$.time.chrono.g;
import j$.time.e;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;

final class h<D extends c> implements g<D>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final transient e f1595a;
    private final transient j$.time.h b;
    private final transient ZoneId c;

    private h(e eVar, j$.time.h hVar, ZoneId zoneId) {
        Objects.requireNonNull(eVar, "dateTime");
        this.f1595a = eVar;
        this.b = hVar;
        this.c = zoneId;
    }

    static h t(i iVar, Instant instant, ZoneId zoneId) {
        j$.time.h c2 = zoneId.t().c(instant);
        Objects.requireNonNull(c2, "offset");
        return new h((e) iVar.o(LocalDateTime.z(instant.w(), instant.x(), c2)), c2, zoneId);
    }

    @Override // j$.time.chrono.g
    public i a() {
        c();
        throw null;
    }

    @Override // j$.time.chrono.g
    public e b() {
        return ((e) q()).b();
    }

    @Override // j$.time.chrono.g
    public c c() {
        return ((e) q()).c();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(g<?> gVar) {
        return f.a(this, gVar);
    }

    public boolean d(l lVar) {
        return (lVar instanceof j$.time.temporal.h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && f.a(this, (g) obj) == 0;
    }

    @Override // j$.time.chrono.g
    public j$.time.h f() {
        return this.b;
    }

    public /* synthetic */ int h(l lVar) {
        return f.b(this, lVar);
    }

    public int hashCode() {
        Objects.requireNonNull(this.f1595a);
        throw null;
    }

    public q j(l lVar) {
        if (lVar instanceof j$.time.temporal.h) {
            return (lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.OFFSET_SECONDS) ? lVar.h() : ((e) q()).j(lVar);
        }
        return lVar.t(this);
    }

    @Override // j$.time.chrono.g
    public ZoneId k() {
        return this.c;
    }

    public long l(l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int i = g.a.f1594a[((j$.time.temporal.h) lVar).ordinal()];
        if (i != 1) {
            return i != 2 ? ((e) q()).l(lVar) : (long) f().x();
        }
        return u();
    }

    public /* synthetic */ Object n(n nVar) {
        return f.c(this, nVar);
    }

    @Override // j$.time.chrono.g
    public d q() {
        return this.f1595a;
    }

    public String toString() {
        Objects.requireNonNull(this.f1595a);
        throw null;
    }

    @Override // j$.time.chrono.g
    public /* synthetic */ long u() {
        return f.d(this);
    }
}
