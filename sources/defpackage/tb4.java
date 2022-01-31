package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: tb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class tb4<V> extends FutureTask<V> implements Comparable<tb4<V>> {
    public final long f;
    public final boolean g;
    public final String h;
    public final /* synthetic */ sb4 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tb4(sb4 sb4, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.i = sb4;
        long andIncrement = sb4.k.getAndIncrement();
        this.f = andIncrement;
        this.h = str;
        this.g = z;
        if (andIncrement == Long.MAX_VALUE) {
            sb4.g().f.a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        tb4 tb4 = (tb4) obj;
        boolean z = this.g;
        if (z != tb4.g) {
            return z ? -1 : 1;
        }
        long j = this.f;
        long j2 = tb4.f;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.i.g().g.b("Two tasks share the same index. index", Long.valueOf(this.f));
        return 0;
    }

    public final void setException(Throwable th) {
        this.i.g().f.b(this.h, th);
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tb4(sb4 sb4, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.i = sb4;
        long andIncrement = sb4.k.getAndIncrement();
        this.f = andIncrement;
        this.h = str;
        this.g = z;
        if (andIncrement == Long.MAX_VALUE) {
            sb4.g().f.a("Tasks index overflow");
        }
    }
}
