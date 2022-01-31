package defpackage;

import defpackage.m36;
import defpackage.t26;
import defpackage.z46;
import java.util.Objects;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: s26  reason: default package */
/* compiled from: Manager */
public class s26 implements Runnable {
    public final /* synthetic */ t26.e f;
    public final /* synthetic */ t26 g;

    /* renamed from: s26$a */
    /* compiled from: Manager */
    public class a implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t26 f3172a;

        public a(s26 s26, t26 t26) {
            this.f3172a = t26;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            this.f3172a.a("transport", objArr);
        }
    }

    /* renamed from: s26$b */
    /* compiled from: Manager */
    public class b implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t26 f3173a;

        public b(t26 t26) {
            this.f3173a = t26;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            t26 t26 = this.f3173a;
            Logger logger = t26.w;
            Objects.requireNonNull(t26);
            t26.w.fine("open");
            t26.e();
            t26.b = t26.g.OPEN;
            t26.a("open", new Object[0]);
            u36 u36 = t26.s;
            t26.q.add(hd3.m2(u36, "data", new u26(t26)));
            Queue<d36> queue = t26.q;
            v26 v26 = new v26(t26);
            u36.d("ping", v26);
            queue.add(new c36(u36, "ping", v26));
            Queue<d36> queue2 = t26.q;
            w26 w26 = new w26(t26);
            u36.d("pong", w26);
            queue2.add(new c36(u36, "pong", w26));
            Queue<d36> queue3 = t26.q;
            x26 x26 = new x26(t26);
            u36.d("error", x26);
            queue3.add(new c36(u36, "error", x26));
            Queue<d36> queue4 = t26.q;
            y26 y26 = new y26(t26);
            u36.d("close", y26);
            queue4.add(new c36(u36, "close", y26));
            ((z46.b) t26.u).b = new z26(t26);
            t26.e eVar = s26.this.f;
            if (eVar != null) {
                ((t26.b.a.C0053a) eVar).a(null);
            }
        }
    }

    /* renamed from: s26$c */
    /* compiled from: Manager */
    public class c implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t26 f3174a;

        public c(t26 t26) {
            this.f3174a = t26;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            Exception exc = null;
            Exception exc2 = objArr.length > 0 ? objArr[0] : null;
            t26.w.fine("connect_error");
            this.f3174a.e();
            t26 t26 = this.f3174a;
            t26.b = t26.g.CLOSED;
            t26.f("connect_error", exc2);
            if (s26.this.f != null) {
                if (exc2 instanceof Exception) {
                    exc = exc2;
                }
                ((t26.b.a.C0053a) s26.this.f).a(new k36("Connection error", exc));
                return;
            }
            t26 t262 = this.f3174a;
            if (!t262.e && t262.c && t262.k.d == 0) {
                t262.i();
            }
        }
    }

    /* renamed from: s26$d */
    /* compiled from: Manager */
    public class d extends TimerTask {
        public final /* synthetic */ long f;
        public final /* synthetic */ d36 g;
        public final /* synthetic */ u36 h;
        public final /* synthetic */ t26 i;

        /* renamed from: s26$d$a */
        /* compiled from: Manager */
        public class a implements Runnable {
            public a() {
            }

            public void run() {
                t26.w.fine(String.format("connect attempt timed out after %d", Long.valueOf(d.this.f)));
                d.this.g.a();
                u36 u36 = d.this.h;
                Objects.requireNonNull(u36);
                c56.a(new z36(u36));
                d.this.h.a("error", new k36("timeout"));
                d dVar = d.this;
                dVar.i.f("connect_timeout", Long.valueOf(dVar.f));
            }
        }

        public d(s26 s26, long j, d36 d36, u36 u36, t26 t26) {
            this.f = j;
            this.g = d36;
            this.h = u36;
            this.i = t26;
        }

        public void run() {
            c56.a(new a());
        }
    }

    /* renamed from: s26$e */
    /* compiled from: Manager */
    public class e implements d36 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Timer f3175a;

        public e(s26 s26, Timer timer) {
            this.f3175a = timer;
        }

        @Override // defpackage.d36
        public void a() {
            this.f3175a.cancel();
        }
    }

    public s26(t26 t26, t26.e eVar) {
        this.g = t26;
        this.f = eVar;
    }

    public void run() {
        t26.g gVar;
        Logger logger = t26.w;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("readyState %s", this.g.b));
        }
        t26.g gVar2 = this.g.b;
        if (gVar2 != t26.g.OPEN && gVar2 != (gVar = t26.g.OPENING)) {
            if (logger.isLoggable(level)) {
                logger.fine(String.format("opening %s", this.g.o));
            }
            t26 t26 = this.g;
            t26 t262 = this.g;
            t26.s = new t26.d(t262.o, t262.r);
            t26 t263 = this.g;
            u36 u36 = t263.s;
            t263.b = gVar;
            t263.d = false;
            u36.d("transport", new a(this, t263));
            b bVar = new b(t263);
            u36.d("open", bVar);
            c36 c36 = new c36(u36, "open", bVar);
            c cVar = new c(t263);
            u36.d("error", cVar);
            c36 c362 = new c36(u36, "error", cVar);
            long j = this.g.l;
            if (j >= 0) {
                logger.fine(String.format("connection attempt will timeout after %d", Long.valueOf(j)));
                Timer timer = new Timer();
                timer.schedule(new d(this, j, c36, u36, t263), j);
                this.g.q.add(new e(this, timer));
            }
            this.g.q.add(c36);
            this.g.q.add(c362);
            u36 u362 = this.g.s;
            Objects.requireNonNull(u362);
            c56.a(new y36(u362));
        }
    }
}
