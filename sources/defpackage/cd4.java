package defpackage;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/* renamed from: cd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class cd4 implements Runnable {
    public final dd4 f;
    public final Bundle g;

    public cd4(dd4 dd4, Bundle bundle) {
        this.f = dd4;
        this.g = bundle;
    }

    public final void run() {
        boolean z;
        dd4 dd4 = this.f;
        Bundle bundle = this.g;
        Objects.requireNonNull(dd4);
        if (f04.a() && dd4.f3331a.g.l(q64.z0)) {
            if (bundle == null) {
                dd4.i().C.b(new Bundle());
                return;
            }
            Bundle a2 = dd4.i().C.a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    dd4.h();
                    if (ug4.V(obj)) {
                        dd4.h().Q(dd4.p, 27, null, null, 0);
                    }
                    dd4.g().k.c("Invalid default event parameter type. Name, value", str, obj);
                } else if (ug4.q0(str)) {
                    dd4.g().k.b("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    a2.remove(str);
                } else if (dd4.h().a0("param", str, 100, obj)) {
                    dd4.h().H(a2, str, obj);
                }
            }
            dd4.h();
            int s = dd4.f3331a.g.s();
            if (a2.size() > s) {
                Iterator it = new TreeSet(a2.keySet()).iterator();
                int i = 0;
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    i++;
                    if (i > s) {
                        a2.remove(str2);
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                dd4.h().Q(dd4.p, 26, null, null, 0);
                dd4.g().k.a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            dd4.i().C.b(a2);
            re4 n = dd4.n();
            n.b();
            n.s();
            n.y(new bf4(n, a2, n.H(false)));
        }
    }
}
