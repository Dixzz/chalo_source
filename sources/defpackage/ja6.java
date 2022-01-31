package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ja6  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ja6 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f1897a;

    public /* synthetic */ ja6(AtomicInteger atomicInteger) {
        this.f1897a = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, n86.j("CommonPool-worker-", Integer.valueOf(this.f1897a.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }
}
