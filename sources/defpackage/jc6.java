package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: jc6  reason: default package */
/* compiled from: Executors.kt */
public final class jc6 extends ic6 {
    public final Executor h;

    public jc6(Executor executor) {
        this.h = executor;
        Executor A = A();
        Method method = of6.f2686a;
        boolean z = false;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = A instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) A : null;
            if (scheduledThreadPoolExecutor != null) {
                Method method2 = of6.f2686a;
                if (method2 != null) {
                    method2.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
                    z = true;
                }
            }
        } catch (Throwable unused) {
        }
        this.g = z;
    }

    @Override // defpackage.hc6
    public Executor A() {
        return this.h;
    }
}
