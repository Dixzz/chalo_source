package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: vf6  reason: default package */
/* compiled from: LockFreeTaskQueue.kt */
public class vf6<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3644a = AtomicReferenceFieldUpdater.newUpdater(vf6.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public vf6(boolean z) {
        this._cur = new wf6(8, z);
    }

    public final boolean a(E e) {
        while (true) {
            wf6 wf6 = (wf6) this._cur;
            int a2 = wf6.a(e);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                f3644a.compareAndSet(this, wf6, wf6.e());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            wf6 wf6 = (wf6) this._cur;
            if (!wf6.b()) {
                f3644a.compareAndSet(this, wf6, wf6.e());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((wf6) this._cur).c();
    }

    public final E d() {
        while (true) {
            wf6 wf6 = (wf6) this._cur;
            E e = (E) wf6.f();
            if (e != wf6.h) {
                return e;
            }
            f3644a.compareAndSet(this, wf6, wf6.e());
        }
    }
}
