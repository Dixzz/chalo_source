package defpackage;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: lo1  reason: default package */
/* compiled from: DiskCacheWriteLocker */
public final class lo1 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<dm1, a> f2246a = new HashMap();
    public final b b = new b();

    /* renamed from: lo1$a */
    /* compiled from: DiskCacheWriteLocker */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Lock f2247a = new ReentrantLock();
        public int b;
    }

    /* renamed from: lo1$b */
    /* compiled from: DiskCacheWriteLocker */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<a> f2248a = new ArrayDeque();
    }

    public void a(dm1 dm1) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.f2246a.get(dm1);
            Objects.requireNonNull(aVar2, "Argument must not be null");
            aVar = aVar2;
            int i = aVar.b;
            if (i >= 1) {
                int i2 = i - 1;
                aVar.b = i2;
                if (i2 == 0) {
                    a remove = this.f2246a.remove(dm1);
                    if (remove.equals(aVar)) {
                        b bVar = this.b;
                        synchronized (bVar.f2248a) {
                            if (bVar.f2248a.size() < 10) {
                                bVar.f2248a.offer(remove);
                            }
                        }
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", key: " + dm1);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, key: " + dm1 + ", interestedThreads: " + aVar.b);
            }
        }
        aVar.f2247a.unlock();
    }
}
