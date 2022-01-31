package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* renamed from: gy4  reason: default package */
/* compiled from: ListenableFuture */
public interface gy4<V> extends Future<V> {
    void c(Runnable runnable, Executor executor);
}
