package defpackage;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: lj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class lj4<TResult> implements sj4<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2228a;
    public final Object b = new Object();
    @GuardedBy("mLock")
    @Nullable
    public ti4<TResult> c;

    public lj4(Executor executor, ti4<TResult> ti4) {
        this.f2228a = executor;
        this.c = ti4;
    }

    @Override // defpackage.sj4
    public final void a(yi4<TResult> yi4) {
        synchronized (this.b) {
            if (this.c != null) {
                this.f2228a.execute(new kj4(this, yi4));
            }
        }
    }
}
