package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ub6  reason: default package */
/* compiled from: Builders.common.kt */
public final class ub6<T> extends bg6<T> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(ub6.class, "_decision");
    private volatile /* synthetic */ int _decision = 0;

    public ub6(m66 m66, k66<? super T> k66) {
        super(m66, k66);
    }

    @Override // defpackage.bg6, defpackage.ka6
    public void c0(Object obj) {
        boolean z;
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 == 0) {
                if (i.compareAndSet(this, 0, 2)) {
                    z = true;
                    break;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("Already resumed".toString());
            }
        }
        if (!z) {
            rf6.b(hd3.B1(this.h), hd3.B2(obj, this.h), null, 2);
        }
    }

    public final Object f0() {
        boolean z;
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 == 0) {
                if (i.compareAndSet(this, 0, 1)) {
                    z = true;
                    break;
                }
            } else if (i2 != 2) {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z) {
            return p66.COROUTINE_SUSPENDED;
        }
        Object a2 = xc6.a(J());
        if (!(a2 instanceof eb6)) {
            return a2;
        }
        throw ((eb6) a2).f955a;
    }

    @Override // defpackage.bg6, defpackage.wc6
    public void u(Object obj) {
        c0(obj);
    }
}
