package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: mn6  reason: default package */
/* compiled from: SegmentPool.kt */
public final class mn6 {

    /* renamed from: a  reason: collision with root package name */
    public static final ln6 f2411a = new ln6(new byte[0], 0, 0, false, false);
    public static final int b;
    public static final AtomicReference<ln6>[] c;
    public static final mn6 d = new mn6();

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = highestOneBit;
        AtomicReference<ln6>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i = 0; i < highestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        c = atomicReferenceArr;
    }

    public static final void a(ln6 ln6) {
        n86.f(ln6, "segment");
        if (!(ln6.f == null && ln6.g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!ln6.d) {
            Thread currentThread = Thread.currentThread();
            n86.b(currentThread, "Thread.currentThread()");
            AtomicReference<ln6> atomicReference = c[(int) (currentThread.getId() & (((long) b) - 1))];
            ln6 ln62 = atomicReference.get();
            if (ln62 != f2411a) {
                int i = ln62 != null ? ln62.c : 0;
                if (i < 65536) {
                    ln6.f = ln62;
                    ln6.b = 0;
                    ln6.c = i + RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
                    if (!atomicReference.compareAndSet(ln62, ln6)) {
                        ln6.f = null;
                    }
                }
            }
        }
    }

    public static final ln6 b() {
        Thread currentThread = Thread.currentThread();
        n86.b(currentThread, "Thread.currentThread()");
        AtomicReference<ln6> atomicReference = c[(int) (currentThread.getId() & (((long) b) - 1))];
        ln6 ln6 = f2411a;
        ln6 andSet = atomicReference.getAndSet(ln6);
        if (andSet == ln6) {
            return new ln6();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new ln6();
        }
        atomicReference.set(andSet.f);
        andSet.f = null;
        andSet.c = 0;
        return andSet;
    }
}
