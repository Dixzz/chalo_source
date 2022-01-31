package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* renamed from: wn5  reason: default package */
/* compiled from: AlarmOperationScheduler */
public class wn5 implements xn5 {
    @SuppressLint({"StaticFieldLeak"})
    public static wn5 f;

    /* renamed from: a  reason: collision with root package name */
    public final Comparator<d> f3808a = new a(this);
    public final List<d> b = new ArrayList();
    public final hy5 c;
    public final c d;
    public final Context e;

    /* renamed from: wn5$a */
    /* compiled from: AlarmOperationScheduler */
    public class a implements Comparator<d>, j$.util.Comparator {
        public a(wn5 wn5) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return Long.valueOf(dVar.b).compareTo(Long.valueOf(dVar2.b));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<d> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<d> thenComparing(java.util.Comparator<? super d> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: wn5$b */
    /* compiled from: AlarmOperationScheduler */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3809a;

        public b(Context context) {
            this.f3809a = context;
        }
    }

    /* renamed from: wn5$c */
    /* compiled from: AlarmOperationScheduler */
    public interface c {
    }

    /* renamed from: wn5$d */
    /* compiled from: AlarmOperationScheduler */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f3810a;
        public final long b;

        public d(long j, Runnable runnable) {
            this.f3810a = runnable;
            this.b = j;
        }
    }

    public wn5(Context context) {
        hy5 hy5 = hy5.f1445a;
        b bVar = new b(context);
        this.e = context;
        this.c = hy5;
        this.d = bVar;
    }

    public static wn5 c(Context context) {
        synchronized (wn5.class) {
            if (f == null) {
                f = new wn5(context.getApplicationContext());
            }
        }
        return f;
    }

    public void a(long j, Runnable runnable) {
        Objects.requireNonNull(this.c);
        d dVar = new d(SystemClock.elapsedRealtime() + j, runnable);
        yj5.h("Operation scheduled with %d delay", Long.valueOf(j));
        synchronized (this.b) {
            this.b.add(dVar);
            Collections.sort(this.b, this.f3808a);
            b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1 = (android.app.AlarmManager) ((defpackage.wn5.b) r7.d).f3809a.getSystemService("alarm");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r1 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r1.set(3, r3, r0);
        java.util.Objects.requireNonNull(r7.c);
        defpackage.yj5.h("Next alarm set %d", java.lang.Long.valueOf(r3 - android.os.SystemClock.elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        throw new java.lang.IllegalStateException("AlarmManager unavailable");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        defpackage.yj5.e(r0, "AlarmOperationScheduler - Failed to schedule alarm.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r0 = defpackage.hd3.b1(r7.e, 0, new android.content.Intent(r7.e, com.urbanairship.automation.alarms.AlarmOperationReceiver.class).setAction("com.urbanairship.automation.alarms.ALARM_FIRED"), 134217728);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wn5.b():void");
    }
}
