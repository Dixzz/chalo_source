package defpackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: c26  reason: default package */
/* compiled from: Settings */
public class c26 {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d26> f509a = new AtomicReference<>();
    public final CountDownLatch b = new CountDownLatch(1);

    /* renamed from: c26$b */
    /* compiled from: Settings */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c26 f510a = new c26(null);
    }

    /* renamed from: c26$c */
    /* compiled from: Settings */
    public interface c<T> {
        T usingSettings(d26 d26);
    }

    public c26(a aVar) {
    }

    public d26 a() {
        try {
            this.b.await();
            return this.f509a.get();
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
