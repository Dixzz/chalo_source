package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: m06  reason: default package */
/* compiled from: ExecutorUtils */
public final class m06 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2305a;
    public final /* synthetic */ AtomicLong b;

    /* renamed from: m06$a */
    /* compiled from: ExecutorUtils */
    public class a extends i06 {
        public final /* synthetic */ Runnable f;

        public a(m06 m06, Runnable runnable) {
            this.f = runnable;
        }

        @Override // defpackage.i06
        public void onRun() {
            this.f.run();
        }
    }

    public m06(String str, AtomicLong atomicLong) {
        this.f2305a = str;
        this.b = atomicLong;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(new a(this, runnable));
        newThread.setName(this.f2305a + this.b.getAndIncrement());
        return newThread;
    }
}
