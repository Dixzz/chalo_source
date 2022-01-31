package j$.time.temporal;

import j$.time.Duration;

public enum i implements o {
    NANOS("Nanos", Duration.j(1)),
    MICROS("Micros", Duration.j(1000)),
    MILLIS("Millis", Duration.j(1000000)),
    SECONDS("Seconds", Duration.ofSeconds(1)),
    MINUTES("Minutes", Duration.ofSeconds(60)),
    HOURS("Hours", Duration.ofSeconds(3600)),
    HALF_DAYS("HalfDays", Duration.ofSeconds(43200)),
    DAYS("Days", Duration.ofSeconds(86400)),
    WEEKS("Weeks", Duration.ofSeconds(604800)),
    MONTHS("Months", Duration.ofSeconds(2629746)),
    YEARS("Years", Duration.ofSeconds(31556952)),
    DECADES("Decades", Duration.ofSeconds(315569520)),
    CENTURIES("Centuries", Duration.ofSeconds(3155695200L)),
    MILLENNIA("Millennia", Duration.ofSeconds(31556952000L)),
    ERAS("Eras", Duration.ofSeconds(31556952000000000L)),
    FOREVER("Forever", Duration.l(Long.MAX_VALUE, 999999999));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f1634a;

    private i(String str, Duration duration) {
        this.f1634a = str;
    }

    public String toString() {
        return this.f1634a;
    }
}
