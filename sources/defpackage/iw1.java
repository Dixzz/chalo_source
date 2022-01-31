package defpackage;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

/* renamed from: iw1  reason: default package */
/* compiled from: DefaultScheduler */
public class iw1 implements kw1 {
    public static final Logger f = Logger.getLogger(nv1.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final ex1 f1578a;
    public final Executor b;
    public final uv1 c;
    public final xx1 d;
    public final iy1 e;

    @Inject
    public iw1(Executor executor, uv1 uv1, ex1 ex1, xx1 xx1, iy1 iy1) {
        this.b = executor;
        this.c = uv1;
        this.f1578a = ex1;
        this.d = xx1;
        this.e = iy1;
    }

    @Override // defpackage.kw1
    public void a(jv1 jv1, gv1 gv1, fu1 fu1) {
        this.b.execute(new gw1(this, jv1, fu1, gv1));
    }
}
