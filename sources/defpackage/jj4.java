package defpackage;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: jj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class jj4<TResult> implements sj4<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1937a;
    public final Object b = new Object();
    @GuardedBy("mLock")
    @Nullable
    public si4 c;

    public jj4(Executor executor, si4 si4) {
        this.f1937a = executor;
        this.c = si4;
    }

    @Override // defpackage.sj4
    public final void a(yi4<TResult> yi4) {
        if (yi4.o()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.f1937a.execute(new ij4(this));
                }
            }
        }
    }
}
