package defpackage;

import defpackage.m36;
import defpackage.u36;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: e46  reason: default package */
/* compiled from: Socket */
public class e46 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean[] f925a;
    public final /* synthetic */ String b;
    public final /* synthetic */ i46[] c;
    public final /* synthetic */ u36 d;
    public final /* synthetic */ Runnable[] e;

    /* renamed from: e46$a */
    /* compiled from: Socket */
    public class a implements m36.a {

        /* renamed from: e46$a$a  reason: collision with other inner class name */
        /* compiled from: Socket */
        public class RunnableC0020a implements Runnable {
            public RunnableC0020a() {
            }

            public void run() {
                e46 e46 = e46.this;
                if (!e46.f925a[0] && u36.e.CLOSED != e46.d.y) {
                    u36.B.fine("changing transport and sending upgrade packet");
                    e46.this.e[0].run();
                    e46 e462 = e46.this;
                    u36.f(e462.d, e462.c[0]);
                    s46 s46 = new s46("upgrade");
                    e46.this.c[0].k(new s46[]{s46});
                    e46 e463 = e46.this;
                    e463.d.a("upgrade", e463.c[0]);
                    e46 e464 = e46.this;
                    e464.c[0] = null;
                    u36 u36 = e464.d;
                    u36.e = false;
                    u36.h();
                }
            }
        }

        public a() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            if (!e46.this.f925a[0]) {
                s46 s46 = (s46) objArr[0];
                if (!"pong".equals(s46.f3185a) || !"probe".equals(s46.b)) {
                    Logger logger = u36.B;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(String.format("probe transport '%s' failed", e46.this.b));
                    }
                    n36 n36 = new n36("probe error");
                    e46 e46 = e46.this;
                    String str = e46.c[0].c;
                    e46.d.a("upgradeError", n36);
                    return;
                }
                Logger logger2 = u36.B;
                Level level = Level.FINE;
                if (logger2.isLoggable(level)) {
                    logger2.fine(String.format("probe transport '%s' pong", e46.this.b));
                }
                e46 e462 = e46.this;
                u36 u36 = e462.d;
                u36.e = true;
                u36.a("upgrading", e462.c[0]);
                i46[] i46Arr = e46.this.c;
                if (i46Arr[0] != null) {
                    u36.C = "websocket".equals(i46Arr[0].c);
                    if (logger2.isLoggable(level)) {
                        logger2.fine(String.format("pausing current transport '%s'", e46.this.d.t.c));
                    }
                    k46 k46 = (k46) e46.this.d.t;
                    RunnableC0020a aVar = new RunnableC0020a();
                    Objects.requireNonNull(k46);
                    c56.a(new j46(k46, aVar));
                }
            }
        }
    }

    public e46(u36 u36, boolean[] zArr, String str, i46[] i46Arr, u36 u362, Runnable[] runnableArr) {
        this.f925a = zArr;
        this.b = str;
        this.c = i46Arr;
        this.d = u362;
        this.e = runnableArr;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        if (!this.f925a[0]) {
            Logger logger = u36.B;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("probe transport '%s' opened", this.b));
            }
            s46 s46 = new s46("ping", "probe");
            this.c[0].k(new s46[]{s46});
            i46 i46 = this.c[0];
            i46.d("packet", new m36.b("packet", new a()));
        }
    }
}
