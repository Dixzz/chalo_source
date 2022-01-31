package j$.time.chrono;

import j$.time.chrono.c;
import j$.time.temporal.h;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.q;

/* access modifiers changed from: package-private */
public final class e<D extends c> implements d<D>, Object, Object {
    @Override // j$.time.chrono.d
    public i a() {
        throw null;
    }

    @Override // j$.time.chrono.d
    public j$.time.e b() {
        return null;
    }

    @Override // j$.time.chrono.d
    public c c() {
        return null;
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
        return (obj instanceof d) && b.d(this, (d) obj) == 0;
    }

    public int h(l lVar) {
        if (!(lVar instanceof h)) {
            return j(lVar).a(l(lVar), lVar);
        }
        ((h) lVar).j();
        throw null;
    }

    public int hashCode() {
        throw null;
    }

    public q j(l lVar) {
        if (!(lVar instanceof h)) {
            return lVar.t(this);
        }
        ((h) lVar).j();
        throw null;
    }

    public long l(l lVar) {
        if (!(lVar instanceof h)) {
            return lVar.l(this);
        }
        ((h) lVar).j();
        throw null;
    }

    public /* synthetic */ Object n(n nVar) {
        return b.i(this, nVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: p */
    public /* synthetic */ int compareTo(d dVar) {
        return b.d(this, dVar);
    }

    public String toString() {
        throw null;
    }
}
