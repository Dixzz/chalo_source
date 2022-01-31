package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.d;
import j$.time.temporal.k;
import java.io.Serializable;

public final class j extends a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final j f1596a = new j();

    private j() {
    }

    @Override // j$.time.chrono.i
    public String g() {
        return "ISO";
    }

    public boolean h(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    @Override // j$.time.chrono.i
    public c i(k kVar) {
        return d.v(kVar);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.i
    public d o(k kVar) {
        return LocalDateTime.v(kVar);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.i
    public g r(Instant instant, ZoneId zoneId) {
        return j$.time.j.t(instant, zoneId);
    }
}
