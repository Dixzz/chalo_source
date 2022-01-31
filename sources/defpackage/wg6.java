package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: wg6  reason: default package */
/* compiled from: WorkQueue.kt */
public final class wg6 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(wg6.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(wg6.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(wg6.class, "consumerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(wg6.class, "blockingTasksInBuffer");

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReferenceArray<sg6> f3778a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;

    public final sg6 a(sg6 sg6, boolean z) {
        if (z) {
            return b(sg6);
        }
        sg6 sg62 = (sg6) b.getAndSet(this, sg6);
        if (sg62 == null) {
            return null;
        }
        return b(sg62);
    }

    public final sg6 b(sg6 sg6) {
        boolean z = true;
        if (sg6.g.l() != 1) {
            z = false;
        }
        if (z) {
            e.incrementAndGet(this);
        }
        if (c() == 127) {
            return sg6;
        }
        int i = this.producerIndex & 127;
        while (this.f3778a.get(i) != null) {
            Thread.yield();
        }
        this.f3778a.lazySet(i, sg6);
        c.incrementAndGet(this);
        return null;
    }

    public final int c() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int d() {
        return this.lastScheduledTask != null ? c() + 1 : c();
    }

    public final sg6 e() {
        sg6 sg6 = (sg6) b.getAndSet(this, null);
        return sg6 == null ? f() : sg6;
    }

    public final sg6 f() {
        sg6 andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.f3778a.getAndSet(i2, null)) != null) {
                boolean z = true;
                if (andSet.g.l() != 1) {
                    z = false;
                }
                if (z) {
                    e.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final long g(wg6 wg6) {
        int i = wg6.consumerIndex;
        int i2 = wg6.producerIndex;
        AtomicReferenceArray<sg6> atomicReferenceArray = wg6.f3778a;
        while (true) {
            boolean z = true;
            if (i == i2) {
                break;
            }
            int i3 = i & 127;
            if (wg6.blockingTasksInBuffer == 0) {
                break;
            }
            sg6 sg6 = atomicReferenceArray.get(i3);
            if (sg6 != null) {
                if (sg6.g.l() != 1) {
                    z = false;
                }
                if (z && atomicReferenceArray.compareAndSet(i3, sg6, null)) {
                    e.decrementAndGet(wg6);
                    a(sg6, false);
                    return -1;
                }
            }
            i++;
        }
        return h(wg6, true);
    }

    public final long h(wg6 wg6, boolean z) {
        sg6 sg6;
        do {
            sg6 = (sg6) wg6.lastScheduledTask;
            if (sg6 == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (sg6.g.l() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            long a2 = vg6.e.a() - sg6.f;
            long j = vg6.f3647a;
            if (a2 < j) {
                return j - a2;
            }
        } while (!b.compareAndSet(wg6, sg6, null));
        a(sg6, false);
        return -1;
    }
}
