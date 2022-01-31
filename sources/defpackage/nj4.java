package defpackage;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: nj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class nj4<TResult> implements sj4<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2565a;
    public final Object b = new Object();
    @GuardedBy("mLock")
    @Nullable
    public ui4 c;

    public nj4(Executor executor, ui4 ui4) {
        this.f2565a = executor;
        this.c = ui4;
    }

    @Override // defpackage.sj4
    public final void a(yi4<TResult> yi4) {
        if (!yi4.q() && !yi4.o()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.f2565a.execute(new mj4(this, yi4));
                }
            }
        }
    }
}
