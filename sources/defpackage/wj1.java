package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.rabbitmq.client.StringRpcServer;
import defpackage.ek1;
import defpackage.jj1;
import defpackage.lj1;
import defpackage.xj1;
import defpackage.yj1;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: wj1  reason: default package */
/* compiled from: Request */
public abstract class wj1<T> implements Comparable<wj1<T>> {
    public final ek1.a f;
    public final int g;
    public final String h;
    public final int i;
    public final Object j;
    public yj1.a k;
    public Integer l;
    public xj1 m;
    public boolean n;
    public boolean o;
    public boolean p;
    public ak1 q;
    public jj1.a r;
    public Object s;
    public b t;

    /* renamed from: wj1$a */
    /* compiled from: Request */
    public class a implements Runnable {
        public final /* synthetic */ String f;
        public final /* synthetic */ long g;

        public a(String str, long j) {
            this.f = str;
            this.g = j;
        }

        public void run() {
            wj1.this.f.a(this.f, this.g);
            wj1 wj1 = wj1.this;
            wj1.f.b(wj1.toString());
        }
    }

    /* renamed from: wj1$b */
    /* compiled from: Request */
    public interface b {
    }

    /* renamed from: wj1$c */
    /* compiled from: Request */
    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public wj1(int i2, String str, yj1.a aVar) {
        Uri parse;
        String host;
        this.f = ek1.a.c ? new ek1.a() : null;
        this.j = new Object();
        this.n = true;
        int i3 = 0;
        this.o = false;
        this.p = false;
        this.r = null;
        this.g = i2;
        this.h = str;
        this.k = aVar;
        this.q = new nj1(2500, 1, 1.0f);
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i3 = host.hashCode();
        }
        this.i = i3;
    }

    public abstract yj1<T> A(tj1 tj1);

    public void a(String str) {
        if (ek1.a.c) {
            this.f.a(str, Thread.currentThread().getId());
        }
    }

    public void c() {
        synchronized (this.j) {
            this.o = true;
            this.k = null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        wj1 wj1 = (wj1) obj;
        c q2 = q();
        c q3 = wj1.q();
        return q2 == q3 ? this.l.intValue() - wj1.l.intValue() : q3.ordinal() - q2.ordinal();
    }

    public void f(dk1 dk1) {
        yj1.a aVar;
        synchronized (this.j) {
            aVar = this.k;
        }
        if (aVar != null) {
            aVar.a(dk1);
        }
    }

    public abstract void g(T t2);

    public final byte[] h(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(hj1.S("Encoding not supported: ", str), e);
        }
    }

    public void i(String str) {
        xj1 xj1 = this.m;
        if (xj1 != null) {
            synchronized (xj1.b) {
                xj1.b.remove(this);
            }
            synchronized (xj1.j) {
                for (xj1.c cVar : xj1.j) {
                    cVar.a(this);
                }
            }
        }
        if (ek1.a.c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
                return;
            }
            this.f.a(str, id);
            this.f.b(toString());
        }
    }

    public byte[] j() throws ij1 {
        Map<String, String> o2 = o();
        if (o2 == null || o2.size() <= 0) {
            return null;
        }
        return h(o2, StringRpcServer.STRING_ENCODING);
    }

    public String k() {
        return hj1.S("application/x-www-form-urlencoded; charset=", StringRpcServer.STRING_ENCODING);
    }

    public String l() {
        String str = this.h;
        int i2 = this.g;
        if (i2 == 0 || i2 == -1) {
            return str;
        }
        return Integer.toString(i2) + '-' + str;
    }

    public Map<String, String> m() throws ij1 {
        return Collections.emptyMap();
    }

    public Map<String, String> o() throws ij1 {
        return null;
    }

    @Deprecated
    public byte[] p() throws ij1 {
        Map<String, String> o2 = o();
        if (o2 == null || o2.size() <= 0) {
            return null;
        }
        return h(o2, StringRpcServer.STRING_ENCODING);
    }

    public c q() {
        return c.NORMAL;
    }

    public final int r() {
        return this.q.b();
    }

    public boolean t() {
        boolean z;
        synchronized (this.j) {
            z = this.o;
        }
        return z;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("0x");
        i0.append(Integer.toHexString(this.i));
        String sb = i0.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t() ? "[X] " : "[ ] ");
        hj1.V0(sb2, this.h, " ", sb, " ");
        sb2.append(q());
        sb2.append(" ");
        sb2.append(this.l);
        return sb2.toString();
    }

    public void w() {
        b bVar;
        synchronized (this.j) {
            bVar = this.t;
        }
        if (bVar != null) {
            ((lj1.a) bVar).b(this);
        }
    }

    public void x(yj1<?> yj1) {
        b bVar;
        List<wj1<?>> remove;
        synchronized (this.j) {
            bVar = this.t;
        }
        if (bVar != null) {
            lj1.a aVar = (lj1.a) bVar;
            jj1.a aVar2 = yj1.b;
            if (aVar2 != null) {
                if (!(aVar2.e < System.currentTimeMillis())) {
                    String l2 = l();
                    synchronized (aVar) {
                        remove = aVar.f2226a.remove(l2);
                    }
                    if (remove != null) {
                        if (ek1.f981a) {
                            ek1.b("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), l2);
                        }
                        for (wj1<?> wj1 : remove) {
                            ((oj1) aVar.b.i).a(wj1, yj1, null);
                        }
                        return;
                    }
                    return;
                }
            }
            aVar.b(this);
        }
    }
}
