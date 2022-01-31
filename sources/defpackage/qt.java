package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: qt  reason: default package */
/* compiled from: WorkManagerTaskExecutor */
public class qt implements pt {

    /* renamed from: a  reason: collision with root package name */
    public final ft f2987a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final Executor c = new a();

    /* renamed from: qt$a */
    /* compiled from: WorkManagerTaskExecutor */
    public class a implements Executor {
        public a() {
        }

        public void execute(Runnable runnable) {
            qt.this.b.post(runnable);
        }
    }

    public qt(Executor executor) {
        this.f2987a = new ft(executor);
    }
}
