package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.k;

public interface i extends Comparable<i> {
    int e(i iVar);

    boolean equals(Object obj);

    String g();

    c i(k kVar);

    d o(k kVar);

    g r(Instant instant, ZoneId zoneId);
}
