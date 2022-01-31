package defpackage;

import java.util.concurrent.Executor;

/* renamed from: xx4  reason: default package */
public final class xx4<ResultT> implements yx4<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3976a;
    public final Object b = new Object();
    public final px4<? super ResultT> c;

    public xx4(Executor executor, px4<? super ResultT> px4) {
        this.f3976a = executor;
        this.c = px4;
    }

    @Override // defpackage.yx4
    public final void a(ey4<ResultT> ey4) {
        if (ey4.f()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.f3976a.execute(new wx4(this, ey4));
                }
            }
        }
    }
}
