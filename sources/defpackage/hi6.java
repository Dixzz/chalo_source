package defpackage;

import defpackage.ih6;
import defpackage.ri6;
import defpackage.xh6;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: hi6  reason: default package */
/* compiled from: OkHttpClient.kt */
public class hi6 implements Cloneable, ih6.a, ri6.a {
    public static final List<ii6> J = vi6.l(ii6.HTTP_2, ii6.HTTP_1_1);
    public static final List<qh6> K = vi6.l(qh6.g, qh6.h);
    public static final b L = new b(null);
    public final kh6 A;
    public final em6 B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final long H;
    public final uj6 I;
    public final uh6 f;
    public final ph6 g;
    public final List<ei6> h;
    public final List<ei6> i;
    public final xh6.b j;
    public final boolean k;
    public final fh6 l;
    public final boolean m;
    public final boolean n;
    public final th6 o;
    public final gh6 p;
    public final wh6 q;
    public final Proxy r;
    public final ProxySelector s;
    public final fh6 t;
    public final SocketFactory u;
    public final SSLSocketFactory v;
    public final X509TrustManager w;
    public final List<qh6> x;
    public final List<ii6> y;
    public final HostnameVerifier z;

    /* renamed from: hi6$a */
    /* compiled from: OkHttpClient.kt */
    public static final class a {
        public int A;
        public int B;
        public long C;
        public uj6 D;

        /* renamed from: a  reason: collision with root package name */
        public uh6 f1378a = new uh6();
        public ph6 b = new ph6();
        public final List<ei6> c = new ArrayList();
        public final List<ei6> d = new ArrayList();
        public xh6.b e;
        public boolean f;
        public fh6 g;
        public boolean h;
        public boolean i;
        public th6 j;
        public gh6 k;
        public wh6 l;
        public Proxy m;
        public ProxySelector n;
        public fh6 o;
        public SocketFactory p;
        public SSLSocketFactory q;
        public X509TrustManager r;
        public List<qh6> s;
        public List<? extends ii6> t;
        public HostnameVerifier u;
        public kh6 v;
        public em6 w;
        public int x;
        public int y;
        public int z;

        public a() {
            xh6 xh6 = xh6.f3929a;
            n86.f(xh6, "$this$asFactory");
            this.e = new ti6(xh6);
            this.f = true;
            fh6 fh6 = fh6.f1125a;
            this.g = fh6;
            this.h = true;
            this.i = true;
            this.j = th6.f3358a;
            this.l = wh6.f3784a;
            this.o = fh6;
            SocketFactory socketFactory = SocketFactory.getDefault();
            n86.b(socketFactory, "SocketFactory.getDefault()");
            this.p = socketFactory;
            b bVar = hi6.L;
            this.s = hi6.K;
            this.t = hi6.J;
            this.u = fm6.f1142a;
            this.v = kh6.c;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.C = 1024;
        }
    }

    /* renamed from: hi6$b */
    /* compiled from: OkHttpClient.kt */
    public static final class b {
        public b(j86 j86) {
        }
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: java.util.List<? extends ii6>, java.util.List<ii6> */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public hi6(defpackage.hi6.a r5) {
        /*
        // Method dump skipped, instructions count: 533
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hi6.<init>(hi6$a):void");
    }

    @Override // defpackage.ih6.a
    public ih6 a(ji6 ji6) {
        n86.f(ji6, "request");
        return new nj6(this, ji6, false);
    }

    public a b() {
        n86.f(this, "okHttpClient");
        a aVar = new a();
        aVar.f1378a = this.f;
        aVar.b = this.g;
        hd3.j(aVar.c, this.h);
        hd3.j(aVar.d, this.i);
        aVar.e = this.j;
        aVar.f = this.k;
        aVar.g = this.l;
        aVar.h = this.m;
        aVar.i = this.n;
        aVar.j = this.o;
        aVar.k = this.p;
        aVar.l = this.q;
        aVar.m = this.r;
        aVar.n = this.s;
        aVar.o = this.t;
        aVar.p = this.u;
        aVar.q = this.v;
        aVar.r = this.w;
        aVar.s = this.x;
        aVar.t = this.y;
        aVar.u = this.z;
        aVar.v = this.A;
        aVar.w = this.B;
        aVar.x = this.C;
        aVar.y = this.D;
        aVar.z = this.E;
        aVar.A = this.F;
        aVar.B = this.G;
        aVar.C = this.H;
        aVar.D = this.I;
        return aVar;
    }

    @Override // java.lang.Object
    public Object clone() {
        return super.clone();
    }

    public hi6() {
        this(new a());
    }
}
