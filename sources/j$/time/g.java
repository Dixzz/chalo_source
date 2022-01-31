package j$.time;

import j$.time.chrono.b;
import j$.time.chrono.j;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.e;
import j$.time.temporal.f;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.util.Objects;

public final class g implements Object, Object, Comparable<g> {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f1620a;
    private final h b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1621a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                j$.time.temporal.h.values()
                r0 = 30
                int[] r0 = new int[r0]
                j$.time.g.a.f1621a = r0
                j$.time.temporal.h r1 = j$.time.temporal.h.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 28
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = j$.time.g.a.f1621a     // Catch:{ NoSuchFieldError -> 0x0019 }
                j$.time.temporal.h r1 = j$.time.temporal.h.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 29
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.g.a.<clinit>():void");
        }
    }

    static {
        LocalDateTime.c.t(h.g);
        LocalDateTime.d.t(h.f);
    }

    private g(LocalDateTime localDateTime, h hVar) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.f1620a = localDateTime;
        Objects.requireNonNull(hVar, "offset");
        this.b = hVar;
    }

    public static g t(LocalDateTime localDateTime, h hVar) {
        return new g(localDateTime, hVar);
    }

    public e b() {
        return this.f1620a.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(g gVar) {
        int i;
        g gVar2 = gVar;
        if (this.b.equals(gVar2.b)) {
            i = this.f1620a.compareTo(gVar2.f1620a);
        } else {
            i = Long.compare(u(), gVar2.u());
            if (i == 0) {
                i = b().x() - gVar2.b().x();
            }
        }
        return i == 0 ? this.f1620a.compareTo(gVar2.f1620a) : i;
    }

    public boolean d(l lVar) {
        return (lVar instanceof h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f1620a.equals(gVar.f1620a) && this.b.equals(gVar.b);
    }

    public int h(l lVar) {
        if (!(lVar instanceof h)) {
            return b.f(this, lVar);
        }
        int i = a.f1621a[((h) lVar).ordinal()];
        if (i == 1) {
            throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i != 2) {
            return this.f1620a.h(lVar);
        } else {
            return this.b.x();
        }
    }

    public int hashCode() {
        return this.f1620a.hashCode() ^ this.b.hashCode();
    }

    public q j(l lVar) {
        return lVar instanceof h ? (lVar == h.INSTANT_SECONDS || lVar == h.OFFSET_SECONDS) ? lVar.h() : this.f1620a.j(lVar) : lVar.t(this);
    }

    public long l(l lVar) {
        if (!(lVar instanceof h)) {
            return lVar.l(this);
        }
        int i = a.f1621a[((h) lVar).ordinal()];
        if (i == 1) {
            return u();
        }
        if (i != 2) {
            return this.f1620a.l(lVar);
        }
        return (long) this.b.x();
    }

    public Object n(n nVar) {
        int i = m.f1638a;
        if (nVar == c.f1628a || nVar == j$.time.temporal.g.f1632a) {
            return this.b;
        }
        if (nVar == d.f1629a) {
            return null;
        }
        if (nVar == j$.time.temporal.a.f1626a) {
            return this.f1620a.B();
        }
        if (nVar == f.f1631a) {
            return b();
        }
        if (nVar == j$.time.temporal.b.f1627a) {
            return j.f1596a;
        }
        return nVar == e.f1630a ? i.NANOS : nVar.a(this);
    }

    public String toString() {
        return this.f1620a.toString() + this.b.toString();
    }

    public long u() {
        LocalDateTime localDateTime = this.f1620a;
        h hVar = this.b;
        Objects.requireNonNull(localDateTime);
        return b.l(localDateTime, hVar);
    }

    public LocalDateTime v() {
        return this.f1620a;
    }
}
