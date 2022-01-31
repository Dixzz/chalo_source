package defpackage;

import java.util.concurrent.Executor;

/* renamed from: vx4  reason: default package */
public final class vx4<ResultT> implements yx4<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3690a;
    public final Object b = new Object();
    public final ox4 c;

    public vx4(Executor executor, ox4 ox4) {
        this.f3690a = executor;
        this.c = ox4;
    }

    @Override // defpackage.yx4
    public final void a(ey4<ResultT> ey4) {
        if (!ey4.f()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.f3690a.execute(new ux4(this, ey4));
                }
            }
        }
    }
}
