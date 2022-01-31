package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.b;
import j$.time.chrono.c;
import j$.time.chrono.i;
import j$.time.temporal.e;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.q;

/* access modifiers changed from: package-private */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1612a;
    final /* synthetic */ k b;
    final /* synthetic */ i c;
    final /* synthetic */ ZoneId d;

    d(c cVar, k kVar, i iVar, ZoneId zoneId) {
        this.f1612a = cVar;
        this.b = kVar;
        this.c = iVar;
        this.d = zoneId;
    }

    @Override // j$.time.temporal.k
    public boolean d(l lVar) {
        return (this.f1612a == null || !lVar.v()) ? this.b.d(lVar) : this.f1612a.d(lVar);
    }

    @Override // j$.time.temporal.k
    public /* synthetic */ int h(l lVar) {
        return b.f(this, lVar);
    }

    @Override // j$.time.temporal.k
    public q j(l lVar) {
        return ((this.f1612a == null || !lVar.v()) ? this.b : this.f1612a).j(lVar);
    }

    @Override // j$.time.temporal.k
    public long l(l lVar) {
        return ((this.f1612a == null || !lVar.v()) ? this.b : this.f1612a).l(lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i = m.f1638a;
        return nVar == j$.time.temporal.b.f1627a ? this.c : nVar == j$.time.temporal.d.f1629a ? this.d : nVar == e.f1630a ? this.b.n(nVar) : nVar.a(this);
    }
}
