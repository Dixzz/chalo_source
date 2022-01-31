package j$.time;

import j$.time.chrono.c;
import j$.time.chrono.d;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.chrono.i;
import j$.time.temporal.h;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;

public final class j implements Object, g<d>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f1624a;
    private final h b;
    private final ZoneId c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1625a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                j$.time.temporal.h.values()
                r0 = 30
                int[] r0 = new int[r0]
                j$.time.j.a.f1625a = r0
                j$.time.temporal.h r1 = j$.time.temporal.h.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 28
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = j$.time.j.a.f1625a     // Catch:{ NoSuchFieldError -> 0x0019 }
                j$.time.temporal.h r1 = j$.time.temporal.h.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 29
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.j.a.<clinit>():void");
        }
    }

    private j(LocalDateTime localDateTime, h hVar, ZoneId zoneId) {
        this.f1624a = localDateTime;
        this.b = hVar;
        this.c = zoneId;
    }

    public static j t(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        long w = instant.w();
        int x = instant.x();
        h c2 = zoneId.t().c(Instant.y(w, (long) x));
        return new j(LocalDateTime.z(w, x, c2), c2, zoneId);
    }

    @Override // j$.time.chrono.g
    public i a() {
        Objects.requireNonNull((d) c());
        return j$.time.chrono.j.f1596a;
    }

    @Override // j$.time.chrono.g
    public e b() {
        return this.f1624a.b();
    }

    @Override // j$.time.chrono.g
    public c c() {
        return this.f1624a.B();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(g<?> gVar) {
        return f.a(this, gVar);
    }

    public boolean d(l lVar) {
        return (lVar instanceof h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f1624a.equals(jVar.f1624a) && this.b.equals(jVar.b) && this.c.equals(jVar.c);
    }

    @Override // j$.time.chrono.g
    public h f() {
        return this.b;
    }

    public int h(l lVar) {
        if (!(lVar instanceof h)) {
            return f.b(this, lVar);
        }
        int i = a.f1625a[((h) lVar).ordinal()];
        if (i == 1) {
            throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i != 2) {
            return this.f1624a.h(lVar);
        } else {
            return this.b.x();
        }
    }

    public int hashCode() {
        return (this.f1624a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    public q j(l lVar) {
        return lVar instanceof h ? (lVar == h.INSTANT_SECONDS || lVar == h.OFFSET_SECONDS) ? lVar.h() : this.f1624a.j(lVar) : lVar.t(this);
    }

    @Override // j$.time.chrono.g
    public ZoneId k() {
        return this.c;
    }

    public long l(l lVar) {
        if (!(lVar instanceof h)) {
            return lVar.l(this);
        }
        int i = a.f1625a[((h) lVar).ordinal()];
        if (i == 1) {
            return f.d(this);
        }
        if (i != 2) {
            return this.f1624a.l(lVar);
        }
        return (long) this.b.x();
    }

    public Object n(n nVar) {
        int i = m.f1638a;
        if (nVar == j$.time.temporal.a.f1626a) {
            return this.f1624a.B();
        }
        return f.c(this, nVar);
    }

    @Override // j$.time.chrono.g
    public d q() {
        return this.f1624a;
    }

    public String toString() {
        String str = this.f1624a.toString() + this.b.toString();
        if (this.b == this.c) {
            return str;
        }
        return str + '[' + this.c.toString() + ']';
    }

    @Override // j$.time.chrono.g
    public /* synthetic */ long u() {
        return f.d(this);
    }

    public LocalDateTime v() {
        return this.f1624a;
    }
}
