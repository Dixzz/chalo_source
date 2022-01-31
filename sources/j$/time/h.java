package j$.time;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import j$.time.chrono.b;
import j$.time.temporal.c;
import j$.time.temporal.g;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import server.zophop.models.HaltValidate;

public final class h extends ZoneId implements k, Object, Comparable<h> {
    private static final ConcurrentMap c = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap d = new ConcurrentHashMap(16, 0.75f, 4);
    public static final h e = A(0);
    public static final h f = A(-64800);
    public static final h g = A(64800);

    /* renamed from: a  reason: collision with root package name */
    private final int f1622a;
    private final transient String b;

    private h(int i) {
        String str;
        this.f1622a = i;
        if (i == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = abs / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
            int i3 = (abs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : "");
            sb.append(i2);
            String str2 = ":0";
            sb.append(i3 < 10 ? str2 : ProductDiscountsObject.KEY_DELIMITER);
            sb.append(i3);
            int i4 = abs % 60;
            if (i4 != 0) {
                sb.append(i4 >= 10 ? ProductDiscountsObject.KEY_DELIMITER : str2);
                sb.append(i4);
            }
            str = sb.toString();
        }
        this.b = str;
    }

    public static h A(int i) {
        if (i < -64800 || i > 64800) {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i % HaltValidate.HARD_HALT_THRESHOLD_TIME != 0) {
            return new h(i);
        } else {
            Integer valueOf = Integer.valueOf(i);
            ConcurrentMap concurrentMap = c;
            h hVar = (h) concurrentMap.get(valueOf);
            if (hVar != null) {
                return hVar;
            }
            concurrentMap.putIfAbsent(valueOf, new h(i));
            h hVar2 = (h) concurrentMap.get(valueOf);
            d.putIfAbsent(hVar2.b, hVar2);
            return hVar2;
        }
    }

    private static int B(CharSequence charSequence, int i, boolean z) {
        if (!z || charSequence.charAt(i - 1) == ':') {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence.charAt(i + 1);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
                throw new b("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
            }
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new b("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.h y(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.h.y(java.lang.String):j$.time.h");
    }

    public static h z(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new b("Zone offset hours not in valid range: value " + i + " is not in the range -18 to 18");
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new b("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new b("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new b("Zone offset minutes and seconds must have the same sign");
        }
        if (i2 < -59 || i2 > 59) {
            throw new b("Zone offset minutes not in valid range: value " + i2 + " is not in the range -59 to 59");
        } else if (i3 < -59 || i3 > 59) {
            throw new b("Zone offset seconds not in valid range: value " + i3 + " is not in the range -59 to 59");
        } else if (Math.abs(i) != 18 || (i2 | i3) == 0) {
            return A((i2 * 60) + (i * SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT) + i3);
        } else {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(h hVar) {
        return hVar.f1622a - this.f1622a;
    }

    @Override // j$.time.temporal.k
    public boolean d(l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.OFFSET_SECONDS : lVar != null && lVar.n(this);
    }

    @Override // j$.time.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f1622a == ((h) obj).f1622a;
    }

    @Override // j$.time.ZoneId
    public String g() {
        return this.b;
    }

    @Override // j$.time.temporal.k
    public int h(l lVar) {
        if (lVar == j$.time.temporal.h.OFFSET_SECONDS) {
            return this.f1622a;
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return b.k(this, lVar).a(l(lVar), lVar);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.ZoneId
    public int hashCode() {
        return this.f1622a;
    }

    @Override // j$.time.temporal.k
    public q j(l lVar) {
        return b.k(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long l(l lVar) {
        if (lVar == j$.time.temporal.h.OFFSET_SECONDS) {
            return (long) this.f1622a;
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i = m.f1638a;
        return (nVar == c.f1628a || nVar == g.f1632a) ? this : b.j(this, nVar);
    }

    @Override // j$.time.ZoneId
    public j$.time.zone.c t() {
        return j$.time.zone.c.e(this);
    }

    @Override // j$.time.ZoneId
    public String toString() {
        return this.b;
    }

    public int x() {
        return this.f1622a;
    }
}
