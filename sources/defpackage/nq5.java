package defpackage;

import com.urbanairship.AirshipConfigOptions;
import defpackage.lq5;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: nq5  reason: default package */
/* compiled from: RemoteAirshipUrlConfigProvider */
public class nq5 implements mq5, tx5 {

    /* renamed from: a  reason: collision with root package name */
    public final hk5 f2596a;
    public final AirshipConfigOptions b;
    public final Object c = new Object();
    public final List<lq5.c> d = new CopyOnWriteArrayList();
    public lq5 e;

    public nq5(AirshipConfigOptions airshipConfigOptions, hk5 hk5) {
        this.b = airshipConfigOptions;
        this.f2596a = hk5;
    }

    public static String b(String... strArr) {
        for (String str : strArr) {
            if (!hd3.G1(str)) {
                return str;
            }
        }
        return null;
    }

    @Override // defpackage.tx5
    public void a(sx5 sx5) {
        c(sx5);
        this.f2596a.i("com.urbanairship.config.REMOTE_CONFIG_KEY", sx5);
    }

    public final void c(sx5 sx5) {
        boolean z;
        lq5.b bVar = new lq5.b();
        bVar.d = b(sx5.f, this.b.e);
        bVar.e = b(sx5.j, this.b.g);
        bVar.f = b(sx5.k, this.b.h);
        if (this.f2596a.b("com.urbanairship.config.DISABLE_URL_FALLBACK_KEY", this.b.C)) {
            bVar.c = sx5.h;
            bVar.b = sx5.i;
            bVar.f2258a = sx5.g;
        } else {
            bVar.c = b(sx5.h, this.b.f);
            bVar.b = b(sx5.i, this.b.d);
            bVar.f2258a = b(sx5.g, this.b.c);
        }
        lq5 lq5 = new lq5(bVar, null);
        synchronized (this.c) {
            z = !lq5.equals(this.e);
            this.e = lq5;
        }
        if (z) {
            for (lq5.c cVar : this.d) {
                cVar.a();
            }
        }
    }
}
