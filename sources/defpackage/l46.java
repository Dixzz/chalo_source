package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import defpackage.fi6;
import defpackage.i46;
import defpackage.ih6;
import defpackage.ji6;
import defpackage.m36;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: l46  reason: default package */
/* compiled from: PollingXHR */
public class l46 extends k46 {
    public static final Logger p;
    public static boolean q;

    /* renamed from: l46$a */
    /* compiled from: PollingXHR */
    public class a implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l46 f2162a;

        /* renamed from: l46$a$a  reason: collision with other inner class name */
        /* compiled from: PollingXHR */
        public class RunnableC0043a implements Runnable {
            public final /* synthetic */ Object[] f;

            public RunnableC0043a(Object[] objArr) {
                this.f = objArr;
            }

            public void run() {
                a.this.f2162a.a("responseHeaders", this.f[0]);
            }
        }

        public a(l46 l46, l46 l462) {
            this.f2162a = l462;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            c56.a(new RunnableC0043a(objArr));
        }
    }

    /* renamed from: l46$b */
    /* compiled from: PollingXHR */
    public class b implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l46 f2163a;

        public b(l46 l46, l46 l462) {
            this.f2163a = l462;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            this.f2163a.a("requestHeaders", objArr[0]);
        }
    }

    /* renamed from: l46$c */
    /* compiled from: PollingXHR */
    public class c implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f2164a;

        /* renamed from: l46$c$a */
        /* compiled from: PollingXHR */
        public class a implements Runnable {
            public a() {
            }

            public void run() {
                c.this.f2164a.run();
            }
        }

        public c(l46 l46, Runnable runnable) {
            this.f2164a = runnable;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            c56.a(new a());
        }
    }

    /* renamed from: l46$d */
    /* compiled from: PollingXHR */
    public class d implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l46 f2165a;

        /* renamed from: l46$d$a */
        /* compiled from: PollingXHR */
        public class a implements Runnable {
            public final /* synthetic */ Object[] f;

            public a(Object[] objArr) {
                this.f = objArr;
            }

            public void run() {
                Object[] objArr = this.f;
                Exception exc = (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0];
                l46 l46 = d.this.f2165a;
                Logger logger = l46.p;
                l46.i("xhr post error", exc);
            }
        }

        public d(l46 l46, l46 l462) {
            this.f2165a = l462;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            c56.a(new a(objArr));
        }
    }

    /* renamed from: l46$e */
    /* compiled from: PollingXHR */
    public class e implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l46 f2166a;

        /* renamed from: l46$e$a */
        /* compiled from: PollingXHR */
        public class a implements Runnable {
            public final /* synthetic */ Object[] f;

            public a(Object[] objArr) {
                this.f = objArr;
            }

            public void run() {
                Object[] objArr = this.f;
                String str = objArr.length > 0 ? objArr[0] : null;
                if (str instanceof String) {
                    e.this.f2166a.m(str);
                } else if (str instanceof byte[]) {
                    e.this.f2166a.m((byte[]) str);
                }
            }
        }

        public e(l46 l46, l46 l462) {
            this.f2166a = l462;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            c56.a(new a(objArr));
        }
    }

    /* renamed from: l46$f */
    /* compiled from: PollingXHR */
    public class f implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l46 f2167a;

        /* renamed from: l46$f$a */
        /* compiled from: PollingXHR */
        public class a implements Runnable {
            public final /* synthetic */ Object[] f;

            public a(Object[] objArr) {
                this.f = objArr;
            }

            public void run() {
                Object[] objArr = this.f;
                Exception exc = (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0];
                l46 l46 = f.this.f2167a;
                Logger logger = l46.p;
                l46.i("xhr poll error", exc);
            }
        }

        public f(l46 l46, l46 l462) {
            this.f2167a = l462;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            c56.a(new a(objArr));
        }
    }

    /* renamed from: l46$g */
    /* compiled from: PollingXHR */
    public static class g extends m36 {
        public static final fi6 h = fi6.a.b("application/octet-stream");
        public static final fi6 i = fi6.a.b("text/plain;charset=UTF-8");
        public String b;
        public String c;
        public Object d;
        public ih6.a e;
        public ni6 f;
        public ih6 g;

        /* renamed from: l46$g$a */
        /* compiled from: PollingXHR */
        public class a implements jh6 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f2168a;

            public a(g gVar, g gVar2) {
                this.f2168a = gVar2;
            }

            @Override // defpackage.jh6
            public void onFailure(ih6 ih6, IOException iOException) {
                g gVar = this.f2168a;
                Objects.requireNonNull(gVar);
                gVar.a("error", iOException);
            }

            @Override // defpackage.jh6
            public void onResponse(ih6 ih6, ni6 ni6) throws IOException {
                g gVar = this.f2168a;
                gVar.f = ni6;
                gVar.a("responseHeaders", ni6.l.k());
                try {
                    if (ni6.e()) {
                        g.e(this.f2168a);
                    } else {
                        g gVar2 = this.f2168a;
                        IOException iOException = new IOException(Integer.toString(ni6.j));
                        Objects.requireNonNull(gVar2);
                        gVar2.a("error", iOException);
                    }
                } finally {
                    ni6.close();
                }
            }
        }

        /* renamed from: l46$g$b */
        /* compiled from: PollingXHR */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public String f2169a;
            public String b;
            public Object c;
            public ih6.a d;
        }

        static {
            fi6.a aVar = fi6.f;
        }

        public g(b bVar) {
            String str = bVar.b;
            this.b = str == null ? FirebasePerformance.HttpMethod.GET : str;
            this.c = bVar.f2169a;
            this.d = bVar.c;
            ih6.a aVar = bVar.d;
            this.e = aVar == null ? new hi6() : aVar;
        }

        public static void e(g gVar) {
            oi6 oi6 = gVar.f.m;
            try {
                if ("application/octet-stream".equalsIgnoreCase(oi6.contentType().f1129a)) {
                    gVar.a("data", oi6.bytes());
                    gVar.a("success", new Object[0]);
                    return;
                }
                gVar.a("data", oi6.string());
                gVar.a("success", new Object[0]);
            } catch (IOException e2) {
                gVar.a("error", e2);
            }
        }

        public void f() {
            if (l46.q) {
                l46.p.fine(String.format("xhr open %s: %s", this.b, this.c));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            if (FirebasePerformance.HttpMethod.POST.equals(this.b)) {
                if (this.d instanceof byte[]) {
                    treeMap.put("Content-type", new LinkedList(Collections.singletonList("application/octet-stream")));
                } else {
                    treeMap.put("Content-type", new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
                }
            }
            treeMap.put("Accept", new LinkedList(Collections.singletonList("*/*")));
            a("requestHeaders", treeMap);
            if (l46.q) {
                Logger logger = l46.p;
                Object[] objArr = new Object[2];
                objArr[0] = this.c;
                Object obj = this.d;
                if (obj instanceof byte[]) {
                    obj = Arrays.toString((byte[]) obj);
                }
                objArr[1] = obj;
                logger.fine(String.format("sending xhr with url %s | data %s", objArr));
            }
            ji6.a aVar = new ji6.a();
            for (Map.Entry entry : treeMap.entrySet()) {
                for (String str : (List) entry.getValue()) {
                    aVar.a((String) entry.getKey(), str);
                }
            }
            mi6 mi6 = null;
            Object obj2 = this.d;
            if (obj2 instanceof byte[]) {
                mi6 = mi6.create(h, (byte[]) obj2);
            } else if (obj2 instanceof String) {
                mi6 = mi6.create(i, (String) obj2);
            }
            aVar.j(di6.h(this.c));
            aVar.f(this.b, mi6);
            ih6 a2 = this.e.a(aVar.b());
            this.g = a2;
            FirebasePerfOkHttpClient.enqueue(a2, new a(this, this));
        }
    }

    static {
        Logger logger = Logger.getLogger(l46.class.getName());
        p = logger;
        q = logger.isLoggable(Level.FINE);
    }

    public l46(i46.c cVar) {
        super(cVar);
    }

    @Override // defpackage.k46
    public void n() {
        p.fine("xhr poll");
        g s = s(null);
        s.d("data", new e(this, this));
        s.d("error", new f(this, this));
        s.f();
    }

    @Override // defpackage.k46
    public void o(String str, Runnable runnable) {
        r(str, runnable);
    }

    @Override // defpackage.k46
    public void p(byte[] bArr, Runnable runnable) {
        r(bArr, runnable);
    }

    public final void r(Object obj, Runnable runnable) {
        g.b bVar = new g.b();
        bVar.b = FirebasePerformance.HttpMethod.POST;
        bVar.c = obj;
        g s = s(bVar);
        s.d("success", new c(this, runnable));
        s.d("error", new d(this, this));
        s.f();
    }

    public g s(g.b bVar) {
        String str;
        if (bVar == null) {
            bVar = new g.b();
        }
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str2 = this.e ? "https" : "http";
        if (this.f) {
            map.put(this.j, f56.b());
        }
        String M0 = hd3.M0(map);
        if (this.g <= 0 || ((!"https".equals(str2) || this.g == 443) && (!"http".equals(str2) || this.g == 80))) {
            str = "";
        } else {
            StringBuilder i0 = hj1.i0(ProductDiscountsObject.KEY_DELIMITER);
            i0.append(this.g);
            str = i0.toString();
        }
        if (M0.length() > 0) {
            M0 = hj1.S("?", M0);
        }
        boolean contains = this.i.contains(ProductDiscountsObject.KEY_DELIMITER);
        StringBuilder k0 = hj1.k0(str2, "://");
        k0.append(contains ? hj1.a0(hj1.i0("["), this.i, "]") : this.i);
        k0.append(str);
        bVar.f2169a = hj1.a0(k0, this.h, M0);
        bVar.d = this.m;
        g gVar = new g(bVar);
        gVar.d("requestHeaders", new b(this, this));
        gVar.d("responseHeaders", new a(this, this));
        return gVar;
    }
}
