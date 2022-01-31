package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.i;
import j$.time.chrono.j;
import j$.time.format.c;
import j$.time.temporal.h;
import j$.time.temporal.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public final class b {
    public static final b f;

    /* renamed from: a  reason: collision with root package name */
    private final c.d f1601a;
    private final Locale b;
    private final g c;
    private final i d;
    private final ZoneId e = null;

    static {
        c cVar = new c();
        h hVar = h.YEAR;
        i iVar = i.EXCEEDS_PAD;
        c l = cVar.l(hVar, 4, 10, iVar);
        l.e('-');
        h hVar2 = h.MONTH_OF_YEAR;
        l.k(hVar2, 2);
        l.e('-');
        h hVar3 = h.DAY_OF_MONTH;
        l.k(hVar3, 2);
        h hVar4 = h.STRICT;
        j jVar = j.f1596a;
        b s = l.s(hVar4, jVar);
        c cVar2 = new c();
        cVar2.p();
        cVar2.a(s);
        cVar2.h();
        cVar2.s(hVar4, jVar);
        c cVar3 = new c();
        cVar3.p();
        cVar3.a(s);
        cVar3.o();
        cVar3.h();
        cVar3.s(hVar4, jVar);
        c cVar4 = new c();
        h hVar5 = h.HOUR_OF_DAY;
        cVar4.k(hVar5, 2);
        cVar4.e(':');
        h hVar6 = h.MINUTE_OF_HOUR;
        cVar4.k(hVar6, 2);
        cVar4.o();
        cVar4.e(':');
        h hVar7 = h.SECOND_OF_MINUTE;
        cVar4.k(hVar7, 2);
        cVar4.o();
        cVar4.b(h.NANO_OF_SECOND, 0, 9, true);
        b s2 = cVar4.s(hVar4, null);
        c cVar5 = new c();
        cVar5.p();
        cVar5.a(s2);
        cVar5.h();
        cVar5.s(hVar4, null);
        c cVar6 = new c();
        cVar6.p();
        cVar6.a(s2);
        cVar6.o();
        cVar6.h();
        cVar6.s(hVar4, null);
        c cVar7 = new c();
        cVar7.p();
        cVar7.a(s);
        cVar7.e('T');
        cVar7.a(s2);
        b s3 = cVar7.s(hVar4, jVar);
        c cVar8 = new c();
        cVar8.p();
        cVar8.a(s3);
        cVar8.h();
        b s4 = cVar8.s(hVar4, jVar);
        c cVar9 = new c();
        cVar9.a(s4);
        cVar9.o();
        cVar9.e('[');
        cVar9.q();
        cVar9.m();
        cVar9.e(']');
        cVar9.s(hVar4, jVar);
        c cVar10 = new c();
        cVar10.a(s3);
        cVar10.o();
        cVar10.h();
        cVar10.o();
        cVar10.e('[');
        cVar10.q();
        cVar10.m();
        cVar10.e(']');
        cVar10.s(hVar4, jVar);
        c cVar11 = new c();
        cVar11.p();
        c l2 = cVar11.l(hVar, 4, 10, iVar);
        l2.e('-');
        l2.k(h.DAY_OF_YEAR, 3);
        l2.o();
        l2.h();
        l2.s(hVar4, jVar);
        c cVar12 = new c();
        cVar12.p();
        c l3 = cVar12.l(j$.time.temporal.j.c, 4, 10, iVar);
        l3.f("-W");
        l3.k(j$.time.temporal.j.b, 2);
        l3.e('-');
        h hVar8 = h.DAY_OF_WEEK;
        l3.k(hVar8, 1);
        l3.o();
        l3.h();
        l3.s(hVar4, jVar);
        c cVar13 = new c();
        cVar13.p();
        cVar13.c();
        f = cVar13.s(hVar4, null);
        c cVar14 = new c();
        cVar14.p();
        cVar14.k(hVar, 4);
        cVar14.k(hVar2, 2);
        cVar14.k(hVar3, 2);
        cVar14.o();
        cVar14.g("+HHMMss", "Z");
        cVar14.s(hVar4, jVar);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        c cVar15 = new c();
        cVar15.p();
        cVar15.r();
        cVar15.o();
        cVar15.i(hVar8, hashMap);
        cVar15.f(", ");
        cVar15.n();
        c l4 = cVar15.l(hVar3, 1, 2, i.NOT_NEGATIVE);
        l4.e(' ');
        l4.i(hVar2, hashMap2);
        l4.e(' ');
        l4.k(hVar, 4);
        l4.e(' ');
        l4.k(hVar5, 2);
        l4.e(':');
        l4.k(hVar6, 2);
        l4.o();
        l4.e(':');
        l4.k(hVar7, 2);
        l4.n();
        l4.e(' ');
        l4.g("+HHMM", "GMT");
        l4.s(h.SMART, jVar);
    }

    b(c.d dVar, Locale locale, g gVar, h hVar, Set set, i iVar, ZoneId zoneId) {
        this.f1601a = dVar;
        this.b = locale;
        this.c = gVar;
        Objects.requireNonNull(hVar, "resolverStyle");
        this.d = iVar;
    }

    public String a(k kVar) {
        StringBuilder sb = new StringBuilder(32);
        try {
            this.f1601a.h(new e(kVar, this), sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new j$.time.b(e2.getMessage(), e2);
        }
    }

    public i b() {
        return this.d;
    }

    public g c() {
        return this.c;
    }

    public Locale d() {
        return this.b;
    }

    public ZoneId e() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public c.d f(boolean z) {
        return this.f1601a.a(z);
    }

    public String toString() {
        String dVar = this.f1601a.toString();
        return dVar.startsWith("[") ? dVar : dVar.substring(1, dVar.length() - 1);
    }
}
