package j$.time.format;

import a.C0077c;
import a.C0081e;
import a.C0083f;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.razorpay.AnalyticsConstants;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.format.f;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import server.zophop.Constants;

public final class c {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a  reason: collision with root package name */
    private c f1602a;
    private final c b;
    private final List c;
    private final boolean d;
    private int e;

    /* access modifiers changed from: package-private */
    public class a extends f {
        final /* synthetic */ f.b c;

        a(c cVar, f.b bVar) {
            this.c = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1603a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0017 */
        static {
            /*
                j$.time.format.i.values()
                r0 = 5
                int[] r0 = new int[r0]
                j$.time.format.c.b.f1603a = r0
                r1 = 1
                r2 = 4
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000c }
            L_0x000c:
                int[] r0 = j$.time.format.c.b.f1603a     // Catch:{ NoSuchFieldError -> 0x0011 }
                r3 = 2
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                r0 = 3
                int[] r1 = j$.time.format.c.b.f1603a     // Catch:{ NoSuchFieldError -> 0x0017 }
                r3 = 0
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r1 = j$.time.format.c.b.f1603a     // Catch:{ NoSuchFieldError -> 0x001b }
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001b }
            L_0x001b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.c.b.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.time.format.c$c  reason: collision with other inner class name */
    public static final class C0030c implements e {

        /* renamed from: a  reason: collision with root package name */
        private final char f1604a;

        C0030c(char c) {
            this.f1604a = c;
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            sb.append(this.f1604a);
            return true;
        }

        public String toString() {
            if (this.f1604a == '\'') {
                return "''";
            }
            StringBuilder a2 = j$.com.android.tools.r8.a.a("'");
            a2.append(this.f1604a);
            a2.append("'");
            return a2.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        private final e[] f1605a;
        private final boolean b;

        d(List list, boolean z) {
            this.f1605a = (e[]) list.toArray(new e[list.size()]);
            this.b = z;
        }

        d(e[] eVarArr, boolean z) {
            this.f1605a = eVarArr;
            this.b = z;
        }

        public d a(boolean z) {
            return z == this.b ? this : new d(this.f1605a, z);
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            int length = sb.length();
            if (this.b) {
                eVar.g();
            }
            try {
                for (e eVar2 : this.f1605a) {
                    if (!eVar2.h(eVar, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.b) {
                    eVar.a();
                }
                return true;
            } finally {
                if (this.b) {
                    eVar.a();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f1605a != null) {
                sb.append(this.b ? "[" : "(");
                for (e eVar : this.f1605a) {
                    sb.append(eVar);
                }
                sb.append(this.b ? "]" : ")");
            }
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public interface e {
        boolean h(e eVar, StringBuilder sb);
    }

    /* access modifiers changed from: package-private */
    public static final class f implements e {

        /* renamed from: a  reason: collision with root package name */
        private final j$.time.temporal.l f1606a;
        private final int b;
        private final int c;
        private final boolean d;

        f(j$.time.temporal.l lVar, int i, int i2, boolean z) {
            Objects.requireNonNull(lVar, "field");
            if (!lVar.h().f()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + lVar);
            } else if (i < 0 || i > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i);
            } else if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i2);
            } else if (i2 >= i) {
                this.f1606a = lVar;
                this.b = i;
                this.c = i2;
                this.d = z;
            } else {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
            }
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            Long e = eVar.e(this.f1606a);
            if (e == null) {
                return false;
            }
            g b2 = eVar.b();
            long longValue = e.longValue();
            q h = this.f1606a.h();
            h.b(longValue, this.f1606a);
            BigDecimal valueOf = BigDecimal.valueOf(h.e());
            BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(h.d()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
            if (stripTrailingZeros.scale() != 0) {
                String a2 = b2.a(stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.b), this.c), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.d) {
                    sb.append(b2.b());
                }
                sb.append(a2);
                return true;
            } else if (this.b <= 0) {
                return true;
            } else {
                if (this.d) {
                    sb.append(b2.b());
                }
                for (int i = 0; i < this.b; i++) {
                    sb.append(b2.e());
                }
                return true;
            }
        }

        public String toString() {
            String str = this.d ? ",DecimalPoint" : "";
            StringBuilder a2 = j$.com.android.tools.r8.a.a("Fraction(");
            a2.append(this.f1606a);
            a2.append(",");
            a2.append(this.b);
            a2.append(",");
            a2.append(this.c);
            a2.append(str);
            a2.append(")");
            return a2.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g implements e {
        g(int i) {
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            Long e = eVar.e(j$.time.temporal.h.INSTANT_SECONDS);
            j$.time.temporal.k d = eVar.d();
            j$.time.temporal.h hVar = j$.time.temporal.h.NANO_OF_SECOND;
            Long valueOf = d.d(hVar) ? Long.valueOf(eVar.d().l(hVar)) : null;
            int i = 0;
            if (e == null) {
                return false;
            }
            long longValue = e.longValue();
            int w = hVar.w(valueOf != null ? valueOf.longValue() : 0);
            if (longValue >= -62167219200L) {
                long j = (longValue - 315569520000L) + 62167219200L;
                long a2 = C0081e.a(j, 315569520000L) + 1;
                LocalDateTime z = LocalDateTime.z(C0083f.a(j, 315569520000L) - 62167219200L, 0, j$.time.h.e);
                if (a2 > 0) {
                    sb.append('+');
                    sb.append(a2);
                }
                sb.append(z);
                if (z.w() == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = longValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                LocalDateTime z2 = LocalDateTime.z(j4 - 62167219200L, 0, j$.time.h.e);
                int length = sb.length();
                sb.append(z2);
                if (z2.w() == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (z2.getYear() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb.insert(length, j3);
                    } else {
                        sb.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            if (w > 0) {
                sb.append('.');
                int i2 = 100000000;
                while (true) {
                    if (w <= 0 && i % 3 == 0 && i >= -2) {
                        break;
                    }
                    int i3 = w / i2;
                    sb.append((char) (i3 + 48));
                    w -= i3 * i2;
                    i2 /= 10;
                    i++;
                }
            }
            sb.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    /* access modifiers changed from: package-private */
    public static class h implements e {
        static final long[] f = {0, 10, 100, 1000, Constants.THRESHOLD_TIMESTAMP, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

        /* renamed from: a  reason: collision with root package name */
        final j$.time.temporal.l f1607a;
        final int b;
        final int c;
        private final i d;
        final int e;

        h(j$.time.temporal.l lVar, int i, int i2, i iVar) {
            this.f1607a = lVar;
            this.b = i;
            this.c = i2;
            this.d = iVar;
            this.e = 0;
        }

        protected h(j$.time.temporal.l lVar, int i, int i2, i iVar, int i3) {
            this.f1607a = lVar;
            this.b = i;
            this.c = i2;
            this.d = iVar;
            this.e = i3;
        }

        /* access modifiers changed from: package-private */
        public h b() {
            return this.e == -1 ? this : new h(this.f1607a, this.b, this.c, this.d, -1);
        }

        /* access modifiers changed from: package-private */
        public h c(int i) {
            return new h(this.f1607a, this.b, this.c, this.d, this.e + i);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
            if (r4 != 4) goto L_0x0093;
         */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x009c A[LOOP:0: B:31:0x0093->B:33:0x009c, LOOP_END] */
        @Override // j$.time.format.c.e
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean h(j$.time.format.e r11, java.lang.StringBuilder r12) {
            /*
            // Method dump skipped, instructions count: 205
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.c.h.h(j$.time.format.e, java.lang.StringBuilder):boolean");
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            int i = this.b;
            if (i == 1 && this.c == 19 && this.d == i.NORMAL) {
                sb = j$.com.android.tools.r8.a.a("Value(");
                obj = this.f1607a;
            } else if (i == this.c && this.d == i.NOT_NEGATIVE) {
                sb = j$.com.android.tools.r8.a.a("Value(");
                sb.append(this.f1607a);
                sb.append(",");
                sb.append(this.b);
                sb.append(")");
                return sb.toString();
            } else {
                sb = j$.com.android.tools.r8.a.a("Value(");
                sb.append(this.f1607a);
                sb.append(",");
                sb.append(this.b);
                sb.append(",");
                sb.append(this.c);
                sb.append(",");
                obj = this.d;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class i implements e {
        static final String[] c = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final i d = new i("+HH:MM:ss", "Z");

        /* renamed from: a  reason: collision with root package name */
        private final String f1608a;
        private final int b;

        static {
            new i("+HH:MM:ss", "0");
        }

        i(String str, String str2) {
            Objects.requireNonNull(str, "pattern");
            Objects.requireNonNull(str2, "noOffsetText");
            int i = 0;
            while (true) {
                String[] strArr = c;
                if (i >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                } else if (strArr[i].equals(str)) {
                    this.b = i;
                    this.f1608a = str2;
                    return;
                } else {
                    i++;
                }
            }
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            Long e = eVar.e(j$.time.temporal.h.OFFSET_SECONDS);
            if (e == null) {
                return false;
            }
            int a2 = C0077c.a(e.longValue());
            if (a2 != 0) {
                int abs = Math.abs((a2 / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT) % 100);
                int abs2 = Math.abs((a2 / 60) % 60);
                int abs3 = Math.abs(a2 % 60);
                int length = sb.length();
                sb.append(a2 < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i = this.b;
                if (i >= 3 || (i >= 1 && abs2 > 0)) {
                    int i2 = i % 2;
                    String str = ProductDiscountsObject.KEY_DELIMITER;
                    sb.append(i2 == 0 ? str : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i3 = this.b;
                    if (i3 >= 7 || (i3 >= 5 && abs3 > 0)) {
                        if (i3 % 2 != 0) {
                            str = "";
                        }
                        sb.append(str);
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                }
                return true;
            }
            sb.append(this.f1608a);
            return true;
        }

        public String toString() {
            String replace = this.f1608a.replace("'", "''");
            StringBuilder a2 = j$.com.android.tools.r8.a.a("Offset(");
            a2.append(c[this.b]);
            a2.append(",'");
            a2.append(replace);
            a2.append("')");
            return a2.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public enum j implements e {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            return true;
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class k implements e {

        /* renamed from: a  reason: collision with root package name */
        private final String f1610a;

        k(String str) {
            this.f1610a = str;
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            sb.append(this.f1610a);
            return true;
        }

        public String toString() {
            String replace = this.f1610a.replace("'", "''");
            return "'" + replace + "'";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class l implements e {

        /* renamed from: a  reason: collision with root package name */
        private final j$.time.temporal.l f1611a;
        private final j b;
        private final f c;
        private volatile h d;

        l(j$.time.temporal.l lVar, j jVar, f fVar) {
            this.f1611a = lVar;
            this.b = jVar;
            this.c = fVar;
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            String str;
            j$.time.chrono.j jVar;
            Long e = eVar.e(this.f1611a);
            if (e == null) {
                return false;
            }
            j$.time.temporal.k d2 = eVar.d();
            int i = j$.time.temporal.m.f1638a;
            j$.time.chrono.i iVar = (j$.time.chrono.i) d2.n(j$.time.temporal.b.f1627a);
            if (iVar == null || iVar == (jVar = j$.time.chrono.j.f1596a)) {
                f fVar = this.c;
                long longValue = e.longValue();
                j jVar2 = this.b;
                eVar.c();
                str = ((a) fVar).c.a(longValue, jVar2);
            } else {
                f fVar2 = this.c;
                j$.time.temporal.l lVar = this.f1611a;
                long longValue2 = e.longValue();
                j jVar3 = this.b;
                eVar.c();
                Objects.requireNonNull(fVar2);
                if (iVar == jVar || !(lVar instanceof j$.time.temporal.h)) {
                    str = ((a) fVar2).c.a(longValue2, jVar3);
                } else {
                    str = null;
                }
            }
            if (str == null) {
                if (this.d == null) {
                    this.d = new h(this.f1611a, 1, 19, i.NORMAL);
                }
                return this.d.h(eVar, sb);
            }
            sb.append(str);
            return true;
        }

        public String toString() {
            Object obj;
            StringBuilder sb;
            if (this.b == j.FULL) {
                sb = j$.com.android.tools.r8.a.a("Text(");
                obj = this.f1611a;
            } else {
                sb = j$.com.android.tools.r8.a.a("Text(");
                sb.append(this.f1611a);
                sb.append(",");
                obj = this.b;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class m implements e {
        m(n nVar, String str) {
        }

        @Override // j$.time.format.c.e
        public boolean h(e eVar, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) eVar.f(a.f1600a);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.g());
            return true;
        }

        public String toString() {
            return "ZoneRegionId()";
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', j$.time.temporal.h.ERA);
        hashMap.put('y', j$.time.temporal.h.YEAR_OF_ERA);
        hashMap.put('u', j$.time.temporal.h.YEAR);
        j$.time.temporal.l lVar = j$.time.temporal.j.f1635a;
        hashMap.put('Q', lVar);
        hashMap.put('q', lVar);
        j$.time.temporal.h hVar = j$.time.temporal.h.MONTH_OF_YEAR;
        hashMap.put('M', hVar);
        hashMap.put('L', hVar);
        hashMap.put('D', j$.time.temporal.h.DAY_OF_YEAR);
        hashMap.put('d', j$.time.temporal.h.DAY_OF_MONTH);
        hashMap.put('F', j$.time.temporal.h.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.h hVar2 = j$.time.temporal.h.DAY_OF_WEEK;
        hashMap.put('E', hVar2);
        hashMap.put('c', hVar2);
        hashMap.put('e', hVar2);
        hashMap.put('a', j$.time.temporal.h.AMPM_OF_DAY);
        hashMap.put('H', j$.time.temporal.h.HOUR_OF_DAY);
        hashMap.put('k', j$.time.temporal.h.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', j$.time.temporal.h.HOUR_OF_AMPM);
        hashMap.put('h', j$.time.temporal.h.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', j$.time.temporal.h.MINUTE_OF_HOUR);
        hashMap.put('s', j$.time.temporal.h.SECOND_OF_MINUTE);
        j$.time.temporal.h hVar3 = j$.time.temporal.h.NANO_OF_SECOND;
        hashMap.put('S', hVar3);
        hashMap.put('A', j$.time.temporal.h.MILLI_OF_DAY);
        hashMap.put('n', hVar3);
        hashMap.put('N', j$.time.temporal.h.NANO_OF_DAY);
    }

    public c() {
        this.f1602a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = null;
        this.d = false;
    }

    private c(c cVar, boolean z) {
        this.f1602a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = cVar;
        this.d = z;
    }

    private int d(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        c cVar = this.f1602a;
        Objects.requireNonNull(cVar);
        cVar.c.add(eVar);
        c cVar2 = this.f1602a;
        cVar2.e = -1;
        return cVar2.c.size() - 1;
    }

    private c j(h hVar) {
        h hVar2;
        c cVar = this.f1602a;
        int i2 = cVar.e;
        if (i2 >= 0) {
            h hVar3 = (h) cVar.c.get(i2);
            if (hVar.b == hVar.c && hVar.d == i.NOT_NEGATIVE) {
                hVar2 = hVar3.c(hVar.c);
                d(hVar.b());
                this.f1602a.e = i2;
            } else {
                hVar2 = hVar3.b();
                this.f1602a.e = d(hVar);
            }
            this.f1602a.c.set(i2, hVar2);
        } else {
            cVar.e = d(hVar);
        }
        return this;
    }

    public c a(b bVar) {
        d(bVar.f(false));
        return this;
    }

    public c b(j$.time.temporal.l lVar, int i2, int i3, boolean z) {
        d(new f(lVar, i2, i3, z));
        return this;
    }

    public c c() {
        d(new g(-2));
        return this;
    }

    public c e(char c2) {
        d(new C0030c(c2));
        return this;
    }

    public c f(String str) {
        if (str.length() > 0) {
            d(str.length() == 1 ? new C0030c(str.charAt(0)) : new k(str));
        }
        return this;
    }

    public c g(String str, String str2) {
        d(new i(str, str2));
        return this;
    }

    public c h() {
        d(i.d);
        return this;
    }

    public c i(j$.time.temporal.l lVar, Map map) {
        Objects.requireNonNull(lVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        j jVar = j.FULL;
        d(new l(lVar, jVar, new a(this, new f.b(Collections.singletonMap(jVar, linkedHashMap)))));
        return this;
    }

    public c k(j$.time.temporal.l lVar, int i2) {
        Objects.requireNonNull(lVar, "field");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i2);
        }
        j(new h(lVar, i2, i2, i.NOT_NEGATIVE));
        return this;
    }

    public c l(j$.time.temporal.l lVar, int i2, int i3, i iVar) {
        if (i2 == i3 && iVar == i.NOT_NEGATIVE) {
            k(lVar, i3);
            return this;
        }
        Objects.requireNonNull(lVar, "field");
        Objects.requireNonNull(iVar, "signStyle");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i2);
        } else if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i3);
        } else if (i3 >= i2) {
            j(new h(lVar, i2, i3, iVar));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
        }
    }

    public c m() {
        d(new m(a.f1600a, "ZoneRegionId()"));
        return this;
    }

    public c n() {
        c cVar = this.f1602a;
        if (cVar.b != null) {
            if (cVar.c.size() > 0) {
                c cVar2 = this.f1602a;
                d dVar = new d(cVar2.c, cVar2.d);
                this.f1602a = this.f1602a.b;
                d(dVar);
            } else {
                this.f1602a = this.f1602a.b;
            }
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public c o() {
        c cVar = this.f1602a;
        cVar.e = -1;
        this.f1602a = new c(cVar, true);
        return this;
    }

    public c p() {
        d(j.INSENSITIVE);
        return this;
    }

    public c q() {
        d(j.SENSITIVE);
        return this;
    }

    public c r() {
        d(j.LENIENT);
        return this;
    }

    /* access modifiers changed from: package-private */
    public b s(h hVar, j$.time.chrono.i iVar) {
        Locale locale = Locale.getDefault();
        Objects.requireNonNull(locale, AnalyticsConstants.LOCALE);
        while (this.f1602a.b != null) {
            n();
        }
        return new b(new d(this.c, false), locale, g.e, hVar, null, iVar, null);
    }
}
