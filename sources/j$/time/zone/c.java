package j$.time.zone;

import a.C0081e;
import com.google.firebase.appindexing.Indexable;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.a;
import j$.time.chrono.b;
import j$.time.d;
import j$.time.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

public final class c implements Serializable {
    private static final long[] h = new long[0];
    private static final b[] i = new b[0];
    private static final LocalDateTime[] j = new LocalDateTime[0];
    private static final a[] k = new a[0];

    /* renamed from: a  reason: collision with root package name */
    private final long[] f1641a;
    private final h[] b;
    private final long[] c;
    private final h[] d;
    private final b[] e;
    private final TimeZone f;
    private final transient ConcurrentMap g = new ConcurrentHashMap();

    private c(h hVar) {
        h[] hVarArr = new h[1];
        this.b = hVarArr;
        hVarArr[0] = hVar;
        long[] jArr = h;
        this.f1641a = jArr;
        this.c = jArr;
        this.d = hVarArr;
        this.e = i;
        this.f = null;
    }

    c(TimeZone timeZone) {
        h[] hVarArr = new h[1];
        this.b = hVarArr;
        hVarArr[0] = f(timeZone.getRawOffset());
        long[] jArr = h;
        this.f1641a = jArr;
        this.c = jArr;
        this.d = hVarArr;
        this.e = i;
        this.f = timeZone;
    }

    private a[] a(int i2) {
        long j2;
        long j3;
        a[] aVarArr = k;
        Integer valueOf = Integer.valueOf(i2);
        a[] aVarArr2 = (a[]) this.g.get(valueOf);
        if (aVarArr2 != null) {
            return aVarArr2;
        }
        if (this.f == null) {
            b[] bVarArr = this.e;
            a[] aVarArr3 = new a[bVarArr.length];
            if (bVarArr.length <= 0) {
                if (i2 < 2100) {
                    this.g.putIfAbsent(valueOf, aVarArr3);
                }
                return aVarArr3;
            }
            b bVar = bVarArr[0];
            throw null;
        } else if (i2 < 1800) {
            return aVarArr;
        } else {
            long l = b.l(LocalDateTime.x(i2 - 1, 12, 31, 0, 0), this.b[0]);
            long j4 = 1000;
            int offset = this.f.getOffset(l * 1000);
            long j5 = 31968000 + l;
            while (l < j5) {
                long j6 = 7776000 + l;
                if (offset != this.f.getOffset(j6 * j4)) {
                    l = l;
                    while (j6 - l > 1) {
                        long a2 = C0081e.a(j6 + l, 2);
                        if (this.f.getOffset(a2 * 1000) == offset) {
                            l = a2;
                            j6 = j6;
                        } else {
                            j6 = a2;
                        }
                        j4 = 1000;
                        j5 = j5;
                    }
                    j2 = j5;
                    j3 = j4;
                    if (this.f.getOffset(l * j3) == offset) {
                        l = j6;
                    }
                    h f2 = f(offset);
                    int offset2 = this.f.getOffset(l * j3);
                    h f3 = f(offset2);
                    if (b(l, f3) == i2) {
                        aVarArr = (a[]) Arrays.copyOf(aVarArr, aVarArr.length + 1);
                        aVarArr[aVarArr.length - 1] = new a(l, f2, f3);
                    }
                    offset = offset2;
                } else {
                    j2 = j5;
                    j3 = j4;
                    l = j6;
                }
                j4 = j3;
                j5 = j2;
            }
            if (1916 <= i2 && i2 < 2100) {
                this.g.putIfAbsent(valueOf, aVarArr);
            }
            return aVarArr;
        }
    }

    private int b(long j2, h hVar) {
        return d.E(C0081e.a(j2 + ((long) hVar.x()), 86400)).B();
    }

    public static c e(h hVar) {
        return new c(hVar);
    }

    private static h f(int i2) {
        return h.A(i2 / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
    }

    public h c(Instant instant) {
        TimeZone timeZone = this.f;
        if (timeZone != null) {
            return f(timeZone.getOffset(instant.z()));
        }
        if (this.c.length == 0) {
            return this.b[0];
        }
        long w = instant.w();
        if (this.e.length > 0) {
            long[] jArr = this.c;
            if (w > jArr[jArr.length - 1]) {
                h[] hVarArr = this.d;
                a[] a2 = a(b(w, hVarArr[hVarArr.length - 1]));
                a aVar = null;
                for (int i2 = 0; i2 < a2.length; i2++) {
                    aVar = a2[i2];
                    if (w < aVar.u()) {
                        return aVar.l();
                    }
                }
                return aVar.j();
            }
        }
        int binarySearch = Arrays.binarySearch(this.c, w);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.d[binarySearch + 1];
    }

    public boolean d() {
        TimeZone timeZone = this.f;
        if (timeZone != null) {
            if (timeZone.useDaylightTime() || this.f.getDSTSavings() != 0) {
                return false;
            }
            Instant instant = Instant.c;
            h hVar = h.e;
            Instant ofEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
            a aVar = null;
            if (this.f != null) {
                long w = ofEpochMilli.w();
                if (ofEpochMilli.x() > 0 && w < Long.MAX_VALUE) {
                    w++;
                }
                int b2 = b(w, c(ofEpochMilli));
                a[] a2 = a(b2);
                int length = a2.length - 1;
                while (true) {
                    if (length >= 0) {
                        if (w > a2[length].u()) {
                            aVar = a2[length];
                            break;
                        }
                        length--;
                    } else if (b2 > 1800) {
                        a[] a3 = a(b2 - 1);
                        int length2 = a3.length - 1;
                        while (true) {
                            if (length2 < 0) {
                                long min = Math.min(w - 31104000, (a.b().a() / 1000) + 31968000);
                                int offset = this.f.getOffset((w - 1) * 1000);
                                long m = d.D(1800, 1, 1).m() * 86400;
                                while (true) {
                                    if (m > min) {
                                        break;
                                    }
                                    int offset2 = this.f.getOffset(min * 1000);
                                    if (offset != offset2) {
                                        int b3 = b(min, f(offset2));
                                        a[] a4 = a(b3 + 1);
                                        int length3 = a4.length - 1;
                                        while (true) {
                                            if (length3 < 0) {
                                                a[] a5 = a(b3);
                                                aVar = a5[a5.length - 1];
                                                break;
                                            } else if (w > a4[length3].u()) {
                                                aVar = a4[length3];
                                                break;
                                            } else {
                                                length3--;
                                            }
                                        }
                                    } else {
                                        min -= 7776000;
                                    }
                                }
                            } else if (w > a3[length2].u()) {
                                aVar = a3[length2];
                                break;
                            } else {
                                length2--;
                            }
                        }
                    }
                }
            } else if (this.c.length != 0) {
                long w2 = ofEpochMilli.w();
                if (ofEpochMilli.x() > 0 && w2 < Long.MAX_VALUE) {
                    w2++;
                }
                long[] jArr = this.c;
                long j2 = jArr[jArr.length - 1];
                if (this.e.length > 0 && w2 > j2) {
                    h[] hVarArr = this.d;
                    h hVar2 = hVarArr[hVarArr.length - 1];
                    int b4 = b(w2, hVar2);
                    a[] a6 = a(b4);
                    int length4 = a6.length - 1;
                    while (true) {
                        if (length4 < 0) {
                            int i2 = b4 - 1;
                            if (i2 > b(j2, hVar2)) {
                                a[] a7 = a(i2);
                                aVar = a7[a7.length - 1];
                            }
                        } else if (w2 > a6[length4].u()) {
                            aVar = a6[length4];
                            break;
                        } else {
                            length4--;
                        }
                    }
                }
                int binarySearch = Arrays.binarySearch(this.c, w2);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                if (binarySearch > 0) {
                    int i3 = binarySearch - 1;
                    long j3 = this.c[i3];
                    h[] hVarArr2 = this.d;
                    aVar = new a(j3, hVarArr2[i3], hVarArr2[binarySearch]);
                }
            }
            if (aVar == null) {
                return true;
            }
            return false;
        } else if (this.c.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return b.x(this.f, cVar.f) && Arrays.equals(this.f1641a, cVar.f1641a) && Arrays.equals(this.b, cVar.b) && Arrays.equals(this.c, cVar.c) && Arrays.equals(this.d, cVar.d) && Arrays.equals(this.e, cVar.e);
    }

    public int hashCode() {
        TimeZone timeZone = this.f;
        return (((((timeZone != null ? timeZone.hashCode() : 0) ^ Arrays.hashCode(this.f1641a)) ^ Arrays.hashCode(this.b)) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.d)) ^ Arrays.hashCode(this.e);
    }

    public String toString() {
        StringBuilder sb;
        if (this.f != null) {
            sb = j$.com.android.tools.r8.a.a("ZoneRules[timeZone=");
            sb.append(this.f.getID());
        } else {
            sb = j$.com.android.tools.r8.a.a("ZoneRules[currentStandardOffset=");
            h[] hVarArr = this.b;
            sb.append(hVarArr[hVarArr.length - 1]);
        }
        sb.append("]");
        return sb.toString();
    }
}
