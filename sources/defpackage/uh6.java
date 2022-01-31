package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.nj6;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;

/* renamed from: uh6  reason: default package */
/* compiled from: Dispatcher.kt */
public final class uh6 {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f3506a;
    public final ArrayDeque<nj6.a> b = new ArrayDeque<>();
    public final ArrayDeque<nj6.a> c = new ArrayDeque<>();
    public final ArrayDeque<nj6> d = new ArrayDeque<>();

    public final <T> void a(Deque<T> deque, T t) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        c();
    }

    public final void b(nj6.a aVar) {
        n86.f(aVar, AnalyticsConstants.CALL);
        aVar.f.decrementAndGet();
        a(this.c, aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uh6.c():boolean");
    }
}
