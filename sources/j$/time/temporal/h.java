package j$.time.temporal;

/* JADX WARN: Init of enum NANO_OF_SECOND can be incorrect */
/* JADX WARN: Init of enum NANO_OF_DAY can be incorrect */
/* JADX WARN: Init of enum MICRO_OF_SECOND can be incorrect */
/* JADX WARN: Init of enum MICRO_OF_DAY can be incorrect */
/* JADX WARN: Init of enum MILLI_OF_SECOND can be incorrect */
/* JADX WARN: Init of enum MILLI_OF_DAY can be incorrect */
/* JADX WARN: Init of enum SECOND_OF_MINUTE can be incorrect */
/* JADX WARN: Init of enum SECOND_OF_DAY can be incorrect */
/* JADX WARN: Init of enum MINUTE_OF_HOUR can be incorrect */
/* JADX WARN: Init of enum MINUTE_OF_DAY can be incorrect */
/* JADX WARN: Init of enum HOUR_OF_AMPM can be incorrect */
/* JADX WARN: Init of enum CLOCK_HOUR_OF_AMPM can be incorrect */
/* JADX WARN: Init of enum HOUR_OF_DAY can be incorrect */
/* JADX WARN: Init of enum CLOCK_HOUR_OF_DAY can be incorrect */
/* JADX WARN: Init of enum AMPM_OF_DAY can be incorrect */
/* JADX WARN: Init of enum DAY_OF_WEEK can be incorrect */
/* JADX WARN: Init of enum ALIGNED_DAY_OF_WEEK_IN_MONTH can be incorrect */
/* JADX WARN: Init of enum ALIGNED_DAY_OF_WEEK_IN_YEAR can be incorrect */
/* JADX WARN: Init of enum DAY_OF_MONTH can be incorrect */
/* JADX WARN: Init of enum DAY_OF_YEAR can be incorrect */
/* JADX WARN: Init of enum EPOCH_DAY can be incorrect */
/* JADX WARN: Init of enum ALIGNED_WEEK_OF_MONTH can be incorrect */
/* JADX WARN: Init of enum ALIGNED_WEEK_OF_YEAR can be incorrect */
/* JADX WARN: Init of enum MONTH_OF_YEAR can be incorrect */
/* JADX WARN: Init of enum PROLEPTIC_MONTH can be incorrect */
/* JADX WARN: Init of enum YEAR_OF_ERA can be incorrect */
/* JADX WARN: Init of enum YEAR can be incorrect */
/* JADX WARN: Init of enum ERA can be incorrect */
/* JADX WARN: Init of enum INSTANT_SECONDS can be incorrect */
/* JADX WARN: Init of enum OFFSET_SECONDS can be incorrect */
public enum h implements l {
    NANO_OF_SECOND("NanoOfSecond", r8, r17, q.i(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", r8, r27, q.i(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", r9, r17, q.i(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", r9, r27, q.i(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", r9, r17, q.i(0, 999)),
    MILLI_OF_DAY("MilliOfDay", r9, r27, q.i(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", r17, r32, q.i(0, 59), "second"),
    SECOND_OF_DAY("SecondOfDay", r17, r27, q.i(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", r32, r13, q.i(0, 59), "minute"),
    MINUTE_OF_DAY("MinuteOfDay", r32, r27, q.i(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", r13, r16, q.i(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", r13, r16, q.i(1, 12)),
    HOUR_OF_DAY("HourOfDay", r13, r27, q.i(0, 23), "hour"),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", r13, r27, q.i(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", r16, r27, q.i(0, 1), "dayperiod"),
    DAY_OF_WEEK("DayOfWeek", r27, r38, q.i(1, 7), "weekday"),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", r27, r38, q.i(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", r27, r38, q.i(1, 7)),
    DAY_OF_MONTH("DayOfMonth", r27, r15, q.j(1, 28, 31), "day"),
    DAY_OF_YEAR("DayOfYear", r27, r42, q.j(1, 365, 366)),
    EPOCH_DAY("EpochDay", r27, r44, q.i(-365249999634L, 365249999634L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", r38, r15, q.j(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", r38, r42, q.i(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", r15, r42, q.i(1, 12), "month"),
    PROLEPTIC_MONTH("ProlepticMonth", r15, r44, q.i(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", r42, r44, q.j(1, 999999999, 1000000000)),
    YEAR("Year", r42, r44, q.i(-999999999, 999999999), "year"),
    ERA("Era", i.ERAS, r44, q.i(0, 1), "era"),
    INSTANT_SECONDS("InstantSeconds", r17, r44, q.i(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", r17, r44, q.i(-64800, 64800));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f1633a;
    private final o b;
    private final o c;
    private final q d;

    static {
        i iVar = i.NANOS;
        i iVar2 = i.SECONDS;
        i iVar3 = i.DAYS;
        i iVar4 = i.MICROS;
        i iVar5 = i.MILLIS;
        i iVar6 = i.MINUTES;
        i iVar7 = i.HOURS;
        i iVar8 = i.HALF_DAYS;
        i iVar9 = i.WEEKS;
        i iVar10 = i.MONTHS;
        i iVar11 = i.YEARS;
        i iVar12 = i.FOREVER;
    }

    private h(String str, o oVar, o oVar2, q qVar) {
        this.f1633a = str;
        this.b = oVar;
        this.c = oVar2;
        this.d = qVar;
    }

    private h(String str, o oVar, o oVar2, q qVar, String str2) {
        this.f1633a = str;
        this.b = oVar;
        this.c = oVar2;
        this.d = qVar;
    }

    @Override // j$.time.temporal.l
    public q h() {
        return this.d;
    }

    @Override // j$.time.temporal.l
    public boolean j() {
        return ordinal() < 15;
    }

    @Override // j$.time.temporal.l
    public long l(k kVar) {
        return kVar.l(this);
    }

    @Override // j$.time.temporal.l
    public boolean n(k kVar) {
        return kVar.d(this);
    }

    @Override // j$.time.temporal.l
    public q t(k kVar) {
        return kVar.j(this);
    }

    public String toString() {
        return this.f1633a;
    }

    @Override // j$.time.temporal.l
    public boolean v() {
        return ordinal() >= 15 && ordinal() <= 27;
    }

    public int w(long j) {
        return this.d.a(j, this);
    }

    public long x(long j) {
        this.d.b(j, this);
        return j;
    }
}
