package defpackage;

import java.util.concurrent.Executor;

/* renamed from: c2  reason: default package */
/* compiled from: ArchTaskExecutor */
public class c2 extends e2 {
    public static volatile c2 c;
    public static final Executor d = new a();

    /* renamed from: a  reason: collision with root package name */
    public e2 f505a;
    public e2 b;

    /* renamed from: c2$a */
    /* compiled from: ArchTaskExecutor */
    public static class a implements Executor {
        public void execute(Runnable runnable) {
            c2.d().f505a.a(runnable);
        }
    }

    public c2() {
        d2 d2Var = new d2();
        this.b = d2Var;
        this.f505a = d2Var;
    }

    public static c2 d() {
        if (c != null) {
            return c;
        }
        synchronized (c2.class) {
            if (c == null) {
                c = new c2();
            }
        }
        return c;
    }

    @Override // defpackage.e2
    public void a(Runnable runnable) {
        this.f505a.a(runnable);
    }

    @Override // defpackage.e2
    public boolean b() {
        return this.f505a.b();
    }

    @Override // defpackage.e2
    public void c(Runnable runnable) {
        this.f505a.c(runnable);
    }
}
