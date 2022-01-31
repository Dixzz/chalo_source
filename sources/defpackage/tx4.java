package defpackage;

import java.util.concurrent.Executor;

/* renamed from: tx4  reason: default package */
public final class tx4<ResultT> implements yx4<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3418a;
    public final Object b = new Object();
    public final nx4<ResultT> c;

    public tx4(Executor executor, nx4<ResultT> nx4) {
        this.f3418a = executor;
        this.c = nx4;
    }

    @Override // defpackage.yx4
    public final void a(ey4<ResultT> ey4) {
        synchronized (this.b) {
            if (this.c != null) {
                this.f3418a.execute(new sx4(this, ey4));
            }
        }
    }
}
