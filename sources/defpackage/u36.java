package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.StringRpcServer;
import defpackage.i46;
import defpackage.ih6;
import defpackage.m36;
import defpackage.ri6;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: u36  reason: default package */
/* compiled from: Socket */
public class u36 extends m36 {
    public static final Logger B = Logger.getLogger(u36.class.getName());
    public static boolean C = false;
    public static hi6 D;
    public final m36.a A;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public long i;
    public long j;
    public String k;
    public String l;
    public String m;
    public String n;
    public List<String> o;
    public Map<String, i46.c> p;
    public List<String> q;
    public Map<String, String> r;
    public LinkedList<s46> s;
    public i46 t;
    public Future u;
    public Future v;
    public ri6.a w;
    public ih6.a x;
    public e y;
    public ScheduledExecutorService z;

    /* renamed from: u36$a */
    /* compiled from: Socket */
    public class a implements Runnable {
        public final /* synthetic */ u36 f;

        /* renamed from: u36$a$a  reason: collision with other inner class name */
        /* compiled from: Socket */
        public class RunnableC0056a implements Runnable {
            public RunnableC0056a() {
            }

            public void run() {
                Logger logger = u36.B;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format("writing ping packet - expecting pong within %sms", Long.valueOf(a.this.f.j)));
                }
                u36 u36 = a.this.f;
                Objects.requireNonNull(u36);
                c56.a(new v36(u36));
                u36 u362 = a.this.f;
                u36.e(u362, u362.j);
            }
        }

        public a(u36 u36, u36 u362) {
            this.f = u362;
        }

        public void run() {
            c56.a(new RunnableC0056a());
        }
    }

    /* renamed from: u36$b */
    /* compiled from: Socket */
    public class b implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f3447a;

        public b(u36 u36, Runnable runnable) {
            this.f3447a = runnable;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            this.f3447a.run();
        }
    }

    /* renamed from: u36$c */
    /* compiled from: Socket */
    public class c implements m36.a {
        public c() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            u36.e(u36.this, objArr.length > 0 ? ((Long) objArr[0]).longValue() : 0);
        }
    }

    /* renamed from: u36$d */
    /* compiled from: Socket */
    public static class d extends i46.c {
        public String[] l;
        public String m;
        public String n;
    }

    /* renamed from: u36$e */
    /* compiled from: Socket */
    public enum e {
        OPENING,
        OPEN,
        CLOSING,
        CLOSED;

        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public u36() {
        this(new d());
    }

    public static void e(u36 u36, long j2) {
        Future future = u36.u;
        if (future != null) {
            future.cancel(false);
        }
        if (j2 <= 0) {
            j2 = u36.i + u36.j;
        }
        ScheduledExecutorService scheduledExecutorService = u36.z;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            u36.z = Executors.newSingleThreadScheduledExecutor();
        }
        u36.u = u36.z.schedule(new t36(u36, u36), j2, TimeUnit.MILLISECONDS);
    }

    public static void f(u36 u36, i46 i46) {
        Objects.requireNonNull(u36);
        Logger logger = B;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("setting transport %s", i46.c));
        }
        if (u36.t != null) {
            if (logger.isLoggable(level)) {
                logger.fine(String.format("clearing existing transport %s", u36.t.c));
            }
            u36.t.f2318a.clear();
        }
        u36.t = i46;
        i46.d("drain", new d46(u36, u36));
        i46.d("packet", new c46(u36, u36));
        i46.d("error", new b46(u36, u36));
        i46.d("close", new a46(u36, u36));
    }

    public final i46 g(String str) {
        i46 i46;
        Logger logger = B;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("creating transport '%s'", str));
        }
        HashMap hashMap = new HashMap(this.r);
        hashMap.put("EIO", String.valueOf(3));
        hashMap.put("transport", str);
        String str2 = this.k;
        if (str2 != null) {
            hashMap.put("sid", str2);
        }
        i46.c cVar = this.p.get(str);
        i46.c cVar2 = new i46.c();
        cVar2.h = hashMap;
        cVar2.i = this;
        cVar2.f1476a = cVar != null ? cVar.f1476a : this.l;
        cVar2.f = cVar != null ? cVar.f : this.f;
        cVar2.d = cVar != null ? cVar.d : this.b;
        cVar2.b = cVar != null ? cVar.b : this.m;
        cVar2.e = cVar != null ? cVar.e : this.d;
        cVar2.c = cVar != null ? cVar.c : this.n;
        cVar2.g = cVar != null ? cVar.g : this.g;
        cVar2.k = cVar != null ? cVar.k : this.x;
        cVar2.j = cVar != null ? cVar.j : this.w;
        if ("websocket".equals(str)) {
            i46 = new r46(cVar2);
        } else if ("polling".equals(str)) {
            i46 = new l46(cVar2);
        } else {
            throw new RuntimeException();
        }
        a("transport", i46);
        return i46;
    }

    public final void h() {
        if (this.y != e.CLOSED && this.t.b && !this.e && this.s.size() != 0) {
            Logger logger = B;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("flushing %d packets in socket", Integer.valueOf(this.s.size())));
            }
            this.h = this.s.size();
            i46 i46 = this.t;
            LinkedList<s46> linkedList = this.s;
            i46.k((s46[]) linkedList.toArray(new s46[linkedList.size()]));
            a("flush", new Object[0]);
        }
    }

    public final void i(String str, Exception exc) {
        e eVar = e.OPENING;
        e eVar2 = this.y;
        if (eVar == eVar2 || e.OPEN == eVar2 || e.CLOSING == eVar2) {
            Logger logger = B;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("socket close with reason: %s", str));
            }
            Future future = this.v;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.u;
            if (future2 != null) {
                future2.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.z;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.t.f2318a.remove("close");
            this.t.e();
            this.t.f2318a.clear();
            this.y = e.CLOSED;
            this.k = null;
            a("close", str, exc);
            this.s.clear();
            this.h = 0;
        }
    }

    public final void j(Exception exc) {
        Logger logger = B;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("socket error %s", exc));
        }
        C = false;
        a("error", exc);
        i("transport error", exc);
    }

    public final void k(o36 o36) {
        int i2 = 1;
        a("handshake", o36);
        String str = o36.f2648a;
        this.k = str;
        this.t.d.put("sid", str);
        List<String> asList = Arrays.asList(o36.b);
        ArrayList arrayList = new ArrayList();
        for (String str2 : asList) {
            if (this.o.contains(str2)) {
                arrayList.add(str2);
            }
        }
        this.q = arrayList;
        this.i = o36.c;
        this.j = o36.d;
        Logger logger = B;
        logger.fine("socket open");
        e eVar = e.OPEN;
        this.y = eVar;
        C = "websocket".equals(this.t.c);
        a("open", new Object[0]);
        h();
        if (this.y == eVar && this.c && (this.t instanceof k46)) {
            logger.fine("starting upgrade probes");
            for (String str3 : this.q) {
                Logger logger2 = B;
                if (logger2.isLoggable(Level.FINE)) {
                    Object[] objArr = new Object[i2];
                    objArr[0] = str3;
                    logger2.fine(String.format("probing transport '%s'", objArr));
                }
                i46[] i46Arr = new i46[i2];
                i46Arr[0] = g(str3);
                boolean[] zArr = new boolean[i2];
                zArr[0] = false;
                C = false;
                Runnable[] runnableArr = new Runnable[i2];
                e46 e46 = new e46(this, zArr, str3, i46Arr, this, runnableArr);
                f46 f46 = new f46(this, zArr, runnableArr, i46Arr);
                g46 g46 = new g46(this, i46Arr, f46, str3, this);
                p36 p36 = new p36(this, g46);
                q36 q36 = new q36(this, g46);
                r36 r36 = new r36(this, i46Arr, f46);
                runnableArr[0] = new s36(this, i46Arr, e46, g46, p36, this, q36, r36);
                i46 i46 = i46Arr[0];
                i46.d("open", new m36.b("open", e46));
                i46 i462 = i46Arr[0];
                i462.d("error", new m36.b("error", g46));
                i46 i463 = i46Arr[0];
                i463.d("close", new m36.b("close", p36));
                d("close", new m36.b("close", q36));
                d("upgrading", new m36.b("upgrading", r36));
                i46 i464 = i46Arr[0];
                Objects.requireNonNull(i464);
                c56.a(new h46(i464));
                i2 = 1;
            }
        }
        if (e.CLOSED != this.y) {
            m();
            c("heartbeat", this.A);
            d("heartbeat", this.A);
        }
    }

    public final void l(s46 s46, Runnable runnable) {
        e eVar = e.CLOSING;
        e eVar2 = this.y;
        if (eVar != eVar2 && e.CLOSED != eVar2) {
            a("packetCreate", s46);
            this.s.offer(s46);
            if (runnable != null) {
                d("flush", new m36.b("flush", new b(this, runnable)));
            }
            h();
        }
    }

    public final void m() {
        Future future = this.v;
        if (future != null) {
            future.cancel(false);
        }
        ScheduledExecutorService scheduledExecutorService = this.z;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.z = Executors.newSingleThreadScheduledExecutor();
        }
        this.v = this.z.schedule(new a(this, this), this.i, TimeUnit.MILLISECONDS);
    }

    public u36(d dVar) {
        HashMap hashMap;
        String str;
        this.s = new LinkedList<>();
        this.A = new c();
        String str2 = dVar.m;
        if (str2 != null) {
            if (str2.split(ProductDiscountsObject.KEY_DELIMITER).length > 2) {
                int indexOf = str2.indexOf(91);
                str2 = indexOf != -1 ? str2.substring(indexOf + 1) : str2;
                int lastIndexOf = str2.lastIndexOf(93);
                if (lastIndexOf != -1) {
                    str2 = str2.substring(0, lastIndexOf);
                }
            }
            dVar.f1476a = str2;
        }
        boolean z2 = dVar.d;
        this.b = z2;
        if (dVar.f == -1) {
            dVar.f = z2 ? 443 : 80;
        }
        String str3 = dVar.f1476a;
        this.l = str3 == null ? ConnectionFactory.DEFAULT_HOST : str3;
        this.f = dVar.f;
        String str4 = dVar.n;
        if (str4 != null) {
            hashMap = new HashMap();
            for (String str5 : str4.split("&")) {
                String[] split = str5.split("=");
                try {
                    String decode = URLDecoder.decode(split[0], StringRpcServer.STRING_ENCODING);
                    if (split.length > 1) {
                        try {
                            str = URLDecoder.decode(split[1], StringRpcServer.STRING_ENCODING);
                        } catch (UnsupportedEncodingException e2) {
                            throw new RuntimeException(e2);
                        }
                    } else {
                        str = "";
                    }
                    hashMap.put(decode, str);
                } catch (UnsupportedEncodingException e3) {
                    throw new RuntimeException(e3);
                }
            }
        } else {
            hashMap = new HashMap();
        }
        this.r = hashMap;
        this.c = true;
        StringBuilder sb = new StringBuilder();
        String str6 = dVar.b;
        sb.append((str6 == null ? "/engine.io" : str6).replaceAll("/$", ""));
        sb.append(ConnectionFactory.DEFAULT_VHOST);
        this.m = sb.toString();
        String str7 = dVar.c;
        this.n = str7 == null ? "t" : str7;
        this.d = dVar.e;
        String[] strArr = dVar.l;
        this.o = new ArrayList(Arrays.asList(strArr == null ? new String[]{"polling", "websocket"} : strArr));
        this.p = new HashMap();
        int i2 = dVar.g;
        this.g = i2 == 0 ? 843 : i2;
        ih6.a aVar = dVar.k;
        ri6.a aVar2 = null;
        aVar = aVar == null ? null : aVar;
        this.x = aVar;
        ri6.a aVar3 = dVar.j;
        this.w = aVar3 != null ? aVar3 : aVar2;
        if (aVar == null) {
            if (D == null) {
                D = new hi6();
            }
            this.x = D;
        }
        if (this.w == null) {
            if (D == null) {
                D = new hi6();
            }
            this.w = D;
        }
    }
}
