package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.b;
import j$.time.d;
import j$.time.e;
import j$.time.temporal.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

public abstract class a implements i {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    protected a() {
    }

    @Override // j$.time.chrono.i
    /* renamed from: e */
    public int compareTo(i iVar) {
        return "ISO".compareTo(iVar.g());
    }

    @Override // j$.time.chrono.i
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && compareTo((a) obj) == 0;
    }

    public int hashCode() {
        return getClass().hashCode() ^ 72805;
    }

    @Override // j$.time.chrono.i
    public d o(k kVar) {
        j jVar = (j) this;
        try {
            return LocalDateTime.y(d.v(kVar), e.v(kVar));
        } catch (b e) {
            StringBuilder a2 = j$.com.android.tools.r8.a.a("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            a2.append(kVar.getClass());
            throw new b(a2.toString(), e);
        }
    }

    @Override // j$.time.chrono.i
    public g r(Instant instant, ZoneId zoneId) {
        return h.t(this, instant, zoneId);
    }

    public String toString() {
        return "ISO";
    }
}
