package j$.time.temporal;

import j$.time.Duration;
import j$.time.chrono.i;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final l f1635a = b.QUARTER_OF_YEAR;
    public static final l b = b.WEEK_OF_WEEK_BASED_YEAR;
    public static final l c = b.WEEK_BASED_YEAR;

    /* access modifiers changed from: private */
    public enum b implements l {
        DAY_OF_QUARTER {
            @Override // j$.time.temporal.l
            public q h() {
                return q.j(1, 90, 92);
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (n(kVar)) {
                    return (long) (kVar.h(h.DAY_OF_YEAR) - b.f1636a[((kVar.h(h.MONTH_OF_YEAR) - 1) / 3) + (j$.time.chrono.j.f1596a.h(kVar.l(h.YEAR)) ? 4 : 0)]);
                }
                throw new p("Unsupported field: DayOfQuarter");
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.DAY_OF_YEAR) && kVar.d(h.MONTH_OF_YEAR) && kVar.d(h.YEAR) && b.w(kVar);
            }

            @Override // j$.time.temporal.j.b, j$.time.temporal.l
            public q t(k kVar) {
                if (n(kVar)) {
                    long l = kVar.l(b.QUARTER_OF_YEAR);
                    if (l != 1) {
                        return l == 2 ? q.i(1, 91) : (l == 3 || l == 4) ? q.i(1, 92) : h();
                    }
                    return j$.time.chrono.j.f1596a.h(kVar.l(h.YEAR)) ? q.i(1, 91) : q.i(1, 90);
                }
                throw new p("Unsupported field: DayOfQuarter");
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            @Override // j$.time.temporal.l
            public q h() {
                return q.i(1, 4);
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (n(kVar)) {
                    return (kVar.l(h.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new p("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.MONTH_OF_YEAR) && b.w(kVar);
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            @Override // j$.time.temporal.l
            public q h() {
                return q.j(1, 52, 53);
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (n(kVar)) {
                    return (long) b.z(j$.time.d.v(kVar));
                }
                throw new p("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.EPOCH_DAY) && b.w(kVar);
            }

            @Override // j$.time.temporal.j.b, j$.time.temporal.l
            public q t(k kVar) {
                if (n(kVar)) {
                    return b.C(j$.time.d.v(kVar));
                }
                throw new p("Unsupported field: WeekOfWeekBasedYear");
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            @Override // j$.time.temporal.l
            public q h() {
                return h.YEAR.h();
            }

            @Override // j$.time.temporal.l
            public long l(k kVar) {
                if (n(kVar)) {
                    return (long) b.B(j$.time.d.v(kVar));
                }
                throw new p("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.l
            public boolean n(k kVar) {
                return kVar.d(h.EPOCH_DAY) && b.w(kVar);
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f1636a = {0, 90, 181, 273, 0, 91, 182, 274};

        b(a aVar) {
        }

        /* access modifiers changed from: private */
        public static int B(j$.time.d dVar) {
            int B = dVar.B();
            int z = dVar.z();
            if (z <= 3) {
                return z - dVar.y().ordinal() < -2 ? B - 1 : B;
            }
            if (z < 363) {
                return B;
            }
            return ((z - 363) - (dVar.C() ? 1 : 0)) - dVar.y().ordinal() >= 0 ? B + 1 : B;
        }

        /* access modifiers changed from: private */
        public static q C(j$.time.d dVar) {
            j$.time.d D = j$.time.d.D(B(dVar), 1, 1);
            return q.i(1, (long) ((D.y() == j$.time.c.THURSDAY || (D.y() == j$.time.c.WEDNESDAY && D.C())) ? 53 : 52));
        }

        static boolean w(k kVar) {
            int i = m.f1638a;
            i iVar = (i) kVar.n(b.f1627a);
            if (iVar == null) {
                iVar = j$.time.chrono.j.f1596a;
            }
            return iVar.equals(j$.time.chrono.j.f1596a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
            if ((r0 == -3 || (r0 == -2 && r5.C())) == false) goto L_0x004f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static int z(j$.time.d r5) {
            /*
                j$.time.c r0 = r5.y()
                int r0 = r0.ordinal()
                int r1 = r5.z()
                r2 = 1
                int r1 = r1 - r2
                int r0 = 3 - r0
                int r0 = r0 + r1
                int r3 = r0 / 7
                int r3 = r3 * 7
                int r0 = r0 - r3
                r3 = -3
                int r0 = r0 + r3
                if (r0 >= r3) goto L_0x001c
                int r0 = r0 + 7
            L_0x001c:
                if (r1 >= r0) goto L_0x0034
                r0 = 180(0xb4, float:2.52E-43)
                j$.time.d r5 = r5.G(r0)
                r0 = -1
                j$.time.d r5 = r5.F(r0)
                j$.time.temporal.q r5 = C(r5)
                long r0 = r5.d()
                int r5 = (int) r0
                goto L_0x0050
            L_0x0034:
                int r1 = r1 - r0
                int r1 = r1 / 7
                int r1 = r1 + r2
                r4 = 53
                if (r1 != r4) goto L_0x004e
                if (r0 == r3) goto L_0x004a
                r3 = -2
                if (r0 != r3) goto L_0x0048
                boolean r5 = r5.C()
                if (r5 == 0) goto L_0x0048
                goto L_0x004a
            L_0x0048:
                r5 = 0
                goto L_0x004b
            L_0x004a:
                r5 = 1
            L_0x004b:
                if (r5 != 0) goto L_0x004e
                goto L_0x004f
            L_0x004e:
                r2 = r1
            L_0x004f:
                r5 = r2
            L_0x0050:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.temporal.j.b.z(j$.time.d):int");
        }

        @Override // j$.time.temporal.l
        public boolean j() {
            return false;
        }

        @Override // j$.time.temporal.l
        public q t(k kVar) {
            return h();
        }

        @Override // j$.time.temporal.l
        public boolean v() {
            return true;
        }
    }

    private enum c implements o {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1637a;

        private c(String str, Duration duration) {
            this.f1637a = str;
        }

        public String toString() {
            return this.f1637a;
        }
    }

    static {
        b bVar = b.DAY_OF_QUARTER;
        c cVar = c.WEEK_BASED_YEARS;
        c cVar2 = c.QUARTER_YEARS;
    }
}
