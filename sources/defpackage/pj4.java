package defpackage;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: pj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class pj4<TResult> implements sj4<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2813a;
    public final Object b = new Object();
    @GuardedBy("mLock")
    @Nullable
    public vi4<? super TResult> c;

    public pj4(Executor executor, vi4<? super TResult> vi4) {
        this.f2813a = executor;
        this.c = vi4;
    }

    @Override // defpackage.sj4
    public final void a(yi4<TResult> yi4) {
        if (yi4.q()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.f2813a.execute(new oj4(this, yi4));
                }
            }
        }
    }
}
