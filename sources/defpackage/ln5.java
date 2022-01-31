package defpackage;

import com.urbanairship.automation.ScheduleDelay;
import com.urbanairship.automation.Trigger;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonValue;
import defpackage.mn5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* renamed from: ln5  reason: default package */
/* compiled from: Schedule */
public final class ln5<T extends mn5> {

    /* renamed from: a  reason: collision with root package name */
    public final String f2243a;
    public final zt5 b;
    public final int c;
    public final long d;
    public final long e;
    public final List<Trigger> f;
    public final ScheduleDelay g;
    public final int h;
    public final long i;
    public final long j;
    public final String k;
    public final fm5 l;
    public final JsonValue m;
    public final List<String> n;
    public final String o;
    public final T p;

    /* renamed from: ln5$b */
    /* compiled from: Schedule */
    public static class b<T extends mn5> {

        /* renamed from: a  reason: collision with root package name */
        public int f2244a = 1;
        public long b = -1;
        public long c = -1;
        public final List<Trigger> d = new ArrayList();
        public ScheduleDelay e;
        public int f;
        public long g;
        public long h;
        public T i;
        public String j;
        public String k;
        public zt5 l;
        public String m;
        public fm5 n;
        public JsonValue o;
        public List<String> p;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: mn5 */
        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, mn5 mn5, a aVar) {
            this.j = str;
            this.i = mn5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public defpackage.ln5<T> a() {
            /*
                r9 = this;
                T extends mn5 r0 = r9.i
                java.lang.String r1 = "Missing data."
                defpackage.hd3.E(r0, r1)
                java.lang.String r0 = r9.j
                java.lang.String r1 = "Missing type."
                defpackage.hd3.E(r0, r1)
                long r0 = r9.b
                r2 = 0
                r4 = 0
                r5 = 1
                int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r6 < 0) goto L_0x0025
                long r6 = r9.c
                int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r8 < 0) goto L_0x0025
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 > 0) goto L_0x0023
                goto L_0x0025
            L_0x0023:
                r0 = 0
                goto L_0x0026
            L_0x0025:
                r0 = 1
            L_0x0026:
                java.lang.String r1 = "End must be on or after start."
                defpackage.hd3.D(r0, r1)
                java.util.List<com.urbanairship.automation.Trigger> r0 = r9.d
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x0035
                r0 = 1
                goto L_0x0036
            L_0x0035:
                r0 = 0
            L_0x0036:
                java.lang.String r1 = "Must contain at least 1 trigger."
                defpackage.hd3.D(r0, r1)
                java.util.List<com.urbanairship.automation.Trigger> r0 = r9.d
                int r0 = r0.size()
                long r0 = (long) r0
                r2 = 10
                int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r6 > 0) goto L_0x0049
                r4 = 1
            L_0x0049:
                java.lang.String r0 = "No more than 10 triggers allowed."
                defpackage.hd3.D(r4, r0)
                ln5 r0 = new ln5
                r1 = 0
                r0.<init>(r9, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ln5.b.a():ln5");
        }

        public b<T> b(long j2, TimeUnit timeUnit) {
            this.h = timeUnit.toMillis(j2);
            return this;
        }
    }

    public ln5(b bVar, a aVar) {
        String str = bVar.m;
        this.f2243a = str == null ? UUID.randomUUID().toString() : str;
        zt5 zt5 = bVar.l;
        this.b = zt5 == null ? zt5.g : zt5;
        this.c = bVar.f2244a;
        this.d = bVar.b;
        this.e = bVar.c;
        this.f = Collections.unmodifiableList(bVar.d);
        ScheduleDelay scheduleDelay = bVar.e;
        this.g = scheduleDelay == null ? new ScheduleDelay.b().a() : scheduleDelay;
        this.h = bVar.f;
        this.i = bVar.g;
        this.j = bVar.h;
        this.p = bVar.i;
        this.o = bVar.j;
        this.k = bVar.k;
        this.l = bVar.n;
        JsonValue jsonValue = bVar.o;
        this.m = jsonValue == null ? JsonValue.g : jsonValue;
        List<String> list = bVar.p;
        this.n = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public static b<vn5> b(vn5 vn5) {
        return new b<>("actions", vn5, null);
    }

    public static b<InAppMessage> c(InAppMessage inAppMessage) {
        return new b<>("in_app_message", inAppMessage, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [S extends mn5, T extends mn5] */
    public <S extends mn5> S a() {
        try {
            return this.p;
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException("Unexpected data", e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ln5.class != obj.getClass()) {
            return false;
        }
        ln5 ln5 = (ln5) obj;
        if (this.c != ln5.c || this.d != ln5.d || this.e != ln5.e || this.h != ln5.h || this.i != ln5.i || this.j != ln5.j || !this.f2243a.equals(ln5.f2243a)) {
            return false;
        }
        zt5 zt5 = this.b;
        if (zt5 == null ? ln5.b != null : !zt5.equals(ln5.b)) {
            return false;
        }
        if (!this.f.equals(ln5.f)) {
            return false;
        }
        ScheduleDelay scheduleDelay = this.g;
        if (scheduleDelay == null ? ln5.g != null : !scheduleDelay.equals(ln5.g)) {
            return false;
        }
        String str = this.k;
        if (str == null ? ln5.k != null : !str.equals(ln5.k)) {
            return false;
        }
        fm5 fm5 = this.l;
        if (fm5 == null ? ln5.l != null : !fm5.equals(ln5.l)) {
            return false;
        }
        JsonValue jsonValue = this.m;
        if (jsonValue == null ? ln5.m != null : !jsonValue.equals(ln5.m)) {
            return false;
        }
        List<String> list = this.n;
        if (list == null ? ln5.n != null : !list.equals(ln5.n)) {
            return false;
        }
        if (!this.o.equals(ln5.o)) {
            return false;
        }
        return this.p.equals(ln5.p);
    }

    public int hashCode() {
        int hashCode = this.f2243a.hashCode() * 31;
        zt5 zt5 = this.b;
        int i2 = 0;
        int hashCode2 = zt5 != null ? zt5.hashCode() : 0;
        long j2 = this.d;
        long j3 = this.e;
        int hashCode3 = (this.f.hashCode() + ((((((((hashCode + hashCode2) * 31) + this.c) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31;
        ScheduleDelay scheduleDelay = this.g;
        int hashCode4 = scheduleDelay != null ? scheduleDelay.hashCode() : 0;
        long j4 = this.i;
        long j5 = this.j;
        int i3 = (((((((hashCode3 + hashCode4) * 31) + this.h) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) ((j5 >>> 32) ^ j5))) * 31;
        String str = this.k;
        int hashCode5 = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        fm5 fm5 = this.l;
        int hashCode6 = (hashCode5 + (fm5 != null ? fm5.hashCode() : 0)) * 31;
        JsonValue jsonValue = this.m;
        int hashCode7 = (hashCode6 + (jsonValue != null ? jsonValue.hashCode() : 0)) * 31;
        List<String> list = this.n;
        if (list != null) {
            i2 = list.hashCode();
        }
        return this.p.hashCode() + hj1.r0(this.o, (hashCode7 + i2) * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Schedule{id='");
        hj1.U0(i0, this.f2243a, '\'', ", metadata=");
        i0.append(this.b);
        i0.append(", limit=");
        i0.append(this.c);
        i0.append(", start=");
        i0.append(this.d);
        i0.append(", end=");
        i0.append(this.e);
        i0.append(", triggers=");
        i0.append(this.f);
        i0.append(", delay=");
        i0.append(this.g);
        i0.append(", priority=");
        i0.append(this.h);
        i0.append(", editGracePeriod=");
        i0.append(this.i);
        i0.append(", interval=");
        i0.append(this.j);
        i0.append(", group='");
        hj1.U0(i0, this.k, '\'', ", audience=");
        i0.append(this.l);
        i0.append(", type='");
        hj1.U0(i0, this.o, '\'', ", data=");
        i0.append(this.p);
        i0.append(", campaigns=");
        i0.append(this.m);
        i0.append(", frequencyConstraintIds=");
        i0.append(this.n);
        i0.append('}');
        return i0.toString();
    }
}
