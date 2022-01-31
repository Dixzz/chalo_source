package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: uw5  reason: default package */
/* compiled from: Observable */
public class uw5 implements hx5<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ hx5 f3563a;
    public final /* synthetic */ AtomicInteger b;

    public uw5(vw5 vw5, hx5 hx5, AtomicInteger atomicInteger, pw5 pw5) {
        this.f3563a = hx5;
        this.b = atomicInteger;
    }

    @Override // defpackage.hx5
    public void a() {
        synchronized (this.f3563a) {
            if (this.b.incrementAndGet() == 2) {
                this.f3563a.a();
            }
        }
    }

    @Override // defpackage.hx5
    public void b(T t) {
        synchronized (this.f3563a) {
            this.f3563a.b(t);
        }
    }
}
