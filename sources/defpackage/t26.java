package defpackage;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.b56;
import defpackage.u36;
import defpackage.z46;
import j$.util.concurrent.ConcurrentHashMap;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: t26  reason: default package */
/* compiled from: Manager */
public class t26 extends m36 {
    public static final Logger w = Logger.getLogger(t26.class.getName());
    public g b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public long h;
    public long i;
    public double j;
    public p26 k;
    public long l;
    public Set<e36> m;
    public Date n;
    public URI o;
    public List<a56> p;
    public Queue<d36> q;
    public f r;
    public u36 s;
    public b56.b t;
    public b56.a u;
    public ConcurrentHashMap<String, e36> v;

    /* renamed from: t26$a */
    /* compiled from: Manager */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t26 f3299a;

        public a(t26 t26, t26 t262) {
            this.f3299a = t262;
        }

        public void a(Object[] objArr) {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    u36 u36 = this.f3299a.s;
                    Objects.requireNonNull(u36);
                    c56.a(new w36(u36, (String) obj, null));
                } else if (obj instanceof byte[]) {
                    u36 u362 = this.f3299a.s;
                    Objects.requireNonNull(u362);
                    c56.a(new x36(u362, (byte[]) obj, null));
                }
            }
            t26 t26 = this.f3299a;
            t26.f = false;
            if (!(t26.p.isEmpty() || t26.f)) {
                t26.h(t26.p.remove(0));
            }
        }
    }

    /* renamed from: t26$b */
    /* compiled from: Manager */
    public class b extends TimerTask {
        public final /* synthetic */ t26 f;

        /* renamed from: t26$b$a */
        /* compiled from: Manager */
        public class a implements Runnable {

            /* renamed from: t26$b$a$a  reason: collision with other inner class name */
            /* compiled from: Manager */
            public class C0053a implements e {
                public C0053a() {
                }

                public void a(Exception exc) {
                    if (exc != null) {
                        t26.w.fine("reconnect attempt error");
                        t26 t26 = b.this.f;
                        t26.e = false;
                        t26.i();
                        b.this.f.f("reconnect_error", exc);
                        return;
                    }
                    t26.w.fine("reconnect success");
                    t26 t262 = b.this.f;
                    p26 p26 = t262.k;
                    int i = p26.d;
                    t262.e = false;
                    p26.d = 0;
                    for (Map.Entry entry : t262.v.entrySet()) {
                        t262.g((String) entry.getKey());
                        Objects.requireNonNull((e36) entry.getValue());
                    }
                    t262.f("reconnect", Integer.valueOf(i));
                }
            }

            public a() {
            }

            public void run() {
                if (!b.this.f.d) {
                    t26.w.fine("attempting reconnect");
                    t26 t26 = b.this.f;
                    int i = t26.k.d;
                    t26.f("reconnect_attempt", Integer.valueOf(i));
                    b.this.f.f("reconnecting", Integer.valueOf(i));
                    t26 t262 = b.this.f;
                    if (!t262.d) {
                        c56.a(new s26(t262, new C0053a()));
                    }
                }
            }
        }

        public b(t26 t26, t26 t262) {
            this.f = t262;
        }

        public void run() {
            c56.a(new a());
        }
    }

    /* renamed from: t26$c */
    /* compiled from: Manager */
    public class c implements d36 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Timer f3301a;

        public c(t26 t26, Timer timer) {
            this.f3301a = timer;
        }

        @Override // defpackage.d36
        public void a() {
            this.f3301a.cancel();
        }
    }

    /* renamed from: t26$d */
    /* compiled from: Manager */
    public static class d extends u36 {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(java.net.URI r3, defpackage.u36.d r4) {
            /*
                r2 = this;
                if (r3 != 0) goto L_0x0003
                goto L_0x003c
            L_0x0003:
                if (r4 != 0) goto L_0x000a
                u36$d r4 = new u36$d
                r4.<init>()
            L_0x000a:
                java.lang.String r0 = r3.getHost()
                r4.m = r0
                java.lang.String r0 = r3.getScheme()
                java.lang.String r1 = "https"
                boolean r0 = r1.equals(r0)
                if (r0 != 0) goto L_0x002b
                java.lang.String r0 = r3.getScheme()
                java.lang.String r1 = "wss"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x0029
                goto L_0x002b
            L_0x0029:
                r0 = 0
                goto L_0x002c
            L_0x002b:
                r0 = 1
            L_0x002c:
                r4.d = r0
                int r0 = r3.getPort()
                r4.f = r0
                java.lang.String r3 = r3.getRawQuery()
                if (r3 == 0) goto L_0x003c
                r4.n = r3
            L_0x003c:
                r2.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.t26.d.<init>(java.net.URI, u36$d):void");
        }
    }

    /* renamed from: t26$e */
    /* compiled from: Manager */
    public interface e {
    }

    /* renamed from: t26$f */
    /* compiled from: Manager */
    public static class f extends u36.d {
        public long o;
        public long p;
        public double q;
        public long r = DefaultRefreshIntervals.ACTIVE_CONV_MIN_FETCH_INTERVAL;
    }

    /* renamed from: t26$g */
    /* compiled from: Manager */
    public enum g {
        CLOSED,
        OPENING,
        OPEN
    }

    public t26() {
        this(null, null);
    }

    public final void e() {
        w.fine("cleanup");
        while (true) {
            d36 poll = this.q.poll();
            if (poll == null) {
                break;
            }
            poll.a();
        }
        ((z46.b) this.u).b = null;
        this.p.clear();
        this.f = false;
        this.n = null;
        z46.b bVar = (z46.b) this.u;
        z46.a aVar = bVar.f4127a;
        if (aVar != null) {
            aVar.f4126a = null;
            aVar.b = new ArrayList();
        }
        bVar.b = null;
    }

    public final void f(String str, Object... objArr) {
        a(str, objArr);
        for (e36 e36 : this.v.values()) {
            e36.a(str, objArr);
        }
    }

    public final String g(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(ConnectionFactory.DEFAULT_VHOST.equals(str) ? "" : hj1.S(str, "#"));
        sb.append(this.s.k);
        return sb.toString();
    }

    public void h(a56 a56) {
        Logger logger = w;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("writing packet %s", a56));
        }
        String str = a56.f;
        if (str != null && !str.isEmpty() && a56.f123a == 0) {
            a56.c += "?" + a56.f;
        }
        if (!this.f) {
            this.f = true;
            b56.b bVar = this.t;
            a aVar = new a(this, this);
            z46.c cVar = (z46.c) bVar;
            Objects.requireNonNull(cVar);
            int i2 = a56.f123a;
            if ((i2 == 2 || i2 == 3) && x46.a(a56.d)) {
                a56.f123a = a56.f123a == 2 ? 5 : 6;
            }
            Logger logger2 = z46.b;
            if (logger2.isLoggable(level)) {
                logger2.fine(String.format("encoding packet %s", a56));
            }
            int i3 = a56.f123a;
            if (5 == i3 || 6 == i3) {
                Logger logger3 = y46.f3998a;
                ArrayList arrayList = new ArrayList();
                a56.d = (T) y46.a(a56.d, arrayList);
                a56.e = arrayList.size();
                String a2 = cVar.a(a56);
                ArrayList arrayList2 = new ArrayList(Arrays.asList((byte[][]) arrayList.toArray(new byte[arrayList.size()][])));
                arrayList2.add(0, a2);
                aVar.a(arrayList2.toArray());
                return;
            }
            aVar.a(new String[]{cVar.a(a56)});
            return;
        }
        this.p.add(a56);
    }

    public final void i() {
        if (!this.e && !this.d) {
            p26 p26 = this.k;
            if (p26.d >= this.g) {
                w.fine("reconnect failed");
                this.k.d = 0;
                f("reconnect_failed", new Object[0]);
                this.e = false;
                return;
            }
            BigInteger valueOf = BigInteger.valueOf(p26.f2761a);
            BigInteger valueOf2 = BigInteger.valueOf((long) 2);
            int i2 = p26.d;
            p26.d = i2 + 1;
            BigInteger multiply = valueOf.multiply(valueOf2.pow(i2));
            if (p26.c != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double random = Math.random();
                BigInteger bigInteger = BigDecimal.valueOf(random).multiply(BigDecimal.valueOf(p26.c)).multiply(new BigDecimal(multiply)).toBigInteger();
                multiply = (((int) Math.floor(random * 10.0d)) & 1) == 0 ? multiply.subtract(bigInteger) : multiply.add(bigInteger);
            }
            long longValue = multiply.min(BigInteger.valueOf(p26.b)).longValue();
            w.fine(String.format("will wait %dms before reconnect attempt", Long.valueOf(longValue)));
            this.e = true;
            Timer timer = new Timer();
            timer.schedule(new b(this, this), longValue);
            this.q.add(new c(this, timer));
        }
    }

    public t26(URI uri, f fVar) {
        this.m = new HashSet();
        fVar = fVar == null ? new f() : fVar;
        if (fVar.b == null) {
            fVar.b = "/socket.io";
        }
        if (fVar.j == null) {
            fVar.j = null;
        }
        if (fVar.k == null) {
            fVar.k = null;
        }
        this.r = fVar;
        this.v = new ConcurrentHashMap<>();
        this.q = new LinkedList();
        this.c = true;
        this.g = Integer.MAX_VALUE;
        long j2 = fVar.o;
        j2 = j2 == 0 ? 1000 : j2;
        this.h = j2;
        p26 p26 = this.k;
        if (p26 != null) {
            p26.f2761a = j2;
        }
        long j3 = fVar.p;
        j3 = j3 == 0 ? 5000 : j3;
        this.i = j3;
        if (p26 != null) {
            p26.b = j3;
        }
        double d2 = fVar.q;
        d2 = d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0.5d : d2;
        this.j = d2;
        if (p26 != null) {
            p26.c = d2;
        }
        p26 p262 = new p26();
        p262.f2761a = j2;
        p262.b = j3;
        p262.c = d2;
        this.k = p262;
        this.l = fVar.r;
        this.b = g.CLOSED;
        this.o = uri;
        this.f = false;
        this.p = new ArrayList();
        this.t = new z46.c();
        this.u = new z46.b();
    }
}
