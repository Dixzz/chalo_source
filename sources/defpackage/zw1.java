package defpackage;

import com.google.auto.value.AutoValue;
import defpackage.xw1;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AutoValue
/* renamed from: zw1  reason: default package */
/* compiled from: SchedulerConfig */
public abstract class zw1 {

    @AutoValue
    /* renamed from: zw1$a */
    /* compiled from: SchedulerConfig */
    public static abstract class a {

        @AutoValue.Builder
        /* renamed from: zw1$a$a  reason: collision with other inner class name */
        /* compiled from: SchedulerConfig */
        public static abstract class AbstractC0072a {
            public abstract a a();

            public abstract AbstractC0072a b(long j);

            public abstract AbstractC0072a c(long j);
        }

        public static AbstractC0072a a() {
            xw1.b bVar = new xw1.b();
            Set<b> emptySet = Collections.emptySet();
            Objects.requireNonNull(emptySet, "Null flags");
            bVar.c = emptySet;
            return bVar;
        }

        public abstract long b();

        public abstract Set<b> c();

        public abstract long d();
    }

    /* renamed from: zw1$b */
    /* compiled from: SchedulerConfig */
    public enum b {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public abstract jy1 a();

    public long b(bu1 bu1, long j, int i) {
        long a2 = j - a().a();
        a aVar = c().get(bu1);
        long b2 = aVar.b();
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, (double) i2) * ((double) b2) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((b2 > 1 ? b2 : 2) * ((long) i2))))), a2), aVar.d());
    }

    public abstract Map<bu1, a> c();
}
