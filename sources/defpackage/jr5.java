package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import defpackage.ar5;
import defpackage.gm5;
import defpackage.gr5;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: jr5  reason: default package */
/* compiled from: InAppMessageManager */
public class jr5 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, wq5> f1974a = DesugarCollections.synchronizedMap(new HashMap());
    public final bz5 b;
    public final vk5 c;
    public final fl5 d;
    public final Map<String, gr5.a> e;
    public final List<ir5> f;
    public final yq5 g;
    public final dr5 h;
    public final bs5 i;
    public final Context j;
    public final hk5 k;
    public final b l;
    public final ar5.a m;
    public final Map<String, gm5.a> n;

    /* renamed from: jr5$a */
    /* compiled from: InAppMessageManager */
    public class a implements ar5.a {
        public a() {
        }
    }

    /* renamed from: jr5$b */
    /* compiled from: InAppMessageManager */
    public interface b {
    }

    public jr5(Context context, hk5 hk5, fl5 fl5, b bVar) {
        bz5 bz5 = new bz5(new Handler(Looper.getMainLooper()), pj5.a());
        vk5 vk5 = new vk5();
        bs5 bs5 = new bs5(context);
        HashMap hashMap = new HashMap();
        this.e = hashMap;
        this.f = new ArrayList();
        this.m = new a();
        this.n = new HashMap();
        this.j = context;
        this.k = hk5;
        this.d = fl5;
        this.b = bz5;
        this.i = bs5;
        this.l = bVar;
        this.c = vk5;
        this.g = new yq5(hk5.e("com.urbanairship.iam.displayinterval", 30000));
        this.h = new dr5();
        bz5.a(true);
        hashMap.put("banner", new gs5());
        hashMap.put("fullscreen", new ms5());
        hashMap.put("modal", new vs5());
        hashMap.put("html", new qs5());
    }

    public final void a(String str) {
        synchronized (this.n) {
            gm5.a remove = this.n.remove(str);
            if (remove != null) {
                remove.a();
            }
        }
    }
}
