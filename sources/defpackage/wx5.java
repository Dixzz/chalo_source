package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import defpackage.by5;
import defpackage.ik5;
import defpackage.rt5;
import defpackage.sw5;
import defpackage.zt5;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import server.zophop.Constants;

/* renamed from: wx5  reason: default package */
/* compiled from: RemoteData */
public class wx5 extends oj5 {
    public final qt5 e;
    public final hk5 f;
    public Handler g;
    public final wl5 h;
    public final ku5 i;
    public final vv5 j;
    public final hy5 k;
    public final ay5 l;
    public final ik5 m;
    public volatile boolean n = false;
    public final lx5<Set<by5>> o;
    public final HandlerThread p;
    public final cy5 q;
    public final xl5 r = new a();
    public final ju5 s = new b();
    public final uv5 t = new c();
    public final ik5.a u = new d();

    /* renamed from: wx5$a */
    /* compiled from: RemoteData */
    public class a extends dm5 {
        public a() {
        }

        @Override // defpackage.xl5
        public void a(long j) {
            wx5.this.n = false;
            if (wx5.this.n()) {
                wx5.this.m();
            }
        }
    }

    /* renamed from: wx5$b */
    /* compiled from: RemoteData */
    public class b implements ju5 {
        public b() {
        }

        @Override // defpackage.ju5
        public void a(Locale locale) {
            if (wx5.this.n()) {
                wx5.this.m();
            }
        }
    }

    /* renamed from: wx5$c */
    /* compiled from: RemoteData */
    public class c implements uv5 {
        public c() {
        }

        @Override // defpackage.uv5
        public void a(PushMessage pushMessage, boolean z) {
            if (pushMessage.m()) {
                wx5.this.m();
            }
        }
    }

    /* renamed from: wx5$d */
    /* compiled from: RemoteData */
    public class d implements ik5.a {
        public d() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            if (wx5.this.n()) {
                wx5.this.m();
            }
        }
    }

    /* renamed from: wx5$e */
    /* compiled from: RemoteData */
    public class e implements qw5<Map<String, Collection<by5>>, Collection<by5>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Collection f3857a;

        public e(wx5 wx5, Collection collection) {
            this.f3857a = collection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.qw5
        public Collection<by5> apply(Map<String, Collection<by5>> map) {
            Map<String, Collection<by5>> map2 = map;
            HashSet hashSet = new HashSet();
            Iterator it = new HashSet(this.f3857a).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Collection<by5> collection = map2.get(str);
                if (collection != null) {
                    hashSet.addAll(collection);
                } else {
                    by5.b bVar = new by5.b();
                    bVar.f492a = str;
                    bVar.b = 0;
                    bVar.c = zt5.g;
                    hashSet.add(bVar.a());
                }
            }
            return hashSet;
        }
    }

    /* renamed from: wx5$f */
    /* compiled from: RemoteData */
    public class f implements qw5<Set<by5>, Map<String, Collection<by5>>> {
        public f(wx5 wx5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.qw5
        public Map<String, Collection<by5>> apply(Set<by5> set) {
            HashMap hashMap = new HashMap();
            for (by5 by5 : set) {
                Collection collection = (Collection) hashMap.get(by5.f491a);
                if (collection == null) {
                    collection = new HashSet();
                    hashMap.put(by5.f491a, collection);
                }
                collection.add(by5);
            }
            return hashMap;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wx5(Context context, hk5 hk5, kq5 kq5, ik5 ik5, vv5 vv5, ku5 ku5, jp5<jk5> jp5) {
        super(context, hk5);
        bm5 f2 = bm5.f(context);
        qt5 c2 = qt5.c(context);
        hy5 hy5 = hy5.f1445a;
        ay5 ay5 = new ay5(kq5, jp5);
        this.e = c2;
        this.q = new cy5(context, kq5.b.f711a, "ua_remotedata.db");
        this.f = hk5;
        this.m = ik5;
        this.p = new ey5("remote data store");
        this.o = new lx5<>();
        this.h = f2;
        this.i = ku5;
        this.j = vv5;
        this.k = hy5;
        this.l = ay5;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        this.p.start();
        this.g = new Handler(this.p.getLooper());
        this.h.a(this.r);
        vv5 vv5 = this.j;
        vv5.s.add(this.t);
        ku5 ku5 = this.i;
        ku5.c.add(this.s);
        ik5 ik5 = this.m;
        ik5.b.add(this.u);
        if (n()) {
            m();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0151 A[RETURN, SYNTHETIC] */
    @Override // defpackage.oj5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g(com.urbanairship.UAirship r19, defpackage.rt5 r20) {
        /*
        // Method dump skipped, instructions count: 353
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wx5.g(com.urbanairship.UAirship, rt5):int");
    }

    @Override // defpackage.oj5
    public void h() {
        m();
    }

    public final zt5 i(Uri uri) {
        String str;
        zt5.b s2 = zt5.s();
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        s2.i("url", str);
        return s2.a();
    }

    public boolean j(zt5 zt5) {
        return zt5.equals(i(this.l.b(this.i.a())));
    }

    public final void k() {
        this.n = true;
        PackageInfo e2 = UAirship.e();
        if (e2 != null) {
            this.f.f("com.urbanairship.remotedata.LAST_REFRESH_APP_VERSION").b(String.valueOf(h.O(e2)));
        }
        hk5 hk5 = this.f;
        Objects.requireNonNull(this.k);
        hk5.f("com.urbanairship.remotedata.LAST_REFRESH_TIME").b(String.valueOf(System.currentTimeMillis()));
    }

    public sw5<Collection<by5>> l(Collection<String> collection) {
        sw5 sw5 = new sw5(new yw5(new pw5(), new sw5(new zw5(new yx5(this, collection))), this.o));
        sw5 d2 = sw5.d(new dx5(sw5, new f(this)));
        sw5 d3 = d2.d(new dx5(d2, new e(this, collection)));
        fx5 fx5 = new fx5(d3, new sw5.f());
        return new sw5<>(new bx5(d3, new pw5(), new WeakReference(d3), fx5));
    }

    public void m() {
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_REFRESH";
        a2.c = true;
        a2.b(wx5.class);
        this.e.a(a2.a());
    }

    public final boolean n() {
        if (!this.m.c() || !this.h.d()) {
            return false;
        }
        if (!j(this.f.d("com.urbanairship.remotedata.LAST_REFRESH_METADATA").n())) {
            return true;
        }
        long e2 = this.f.e("com.urbanairship.remotedata.LAST_REFRESH_APP_VERSION", 0);
        PackageInfo e3 = UAirship.e();
        if (e3 != null && h.O(e3) != e2) {
            return true;
        }
        if (!this.n) {
            Objects.requireNonNull(this.k);
            if (this.f.e("com.urbanairship.remotedata.FOREGROUND_REFRESH_INTERVAL", Constants.THRESHOLD_TIMESTAMP) <= System.currentTimeMillis() - this.f.e("com.urbanairship.remotedata.LAST_REFRESH_TIME", -1)) {
                return true;
            }
        }
        return false;
    }
}
