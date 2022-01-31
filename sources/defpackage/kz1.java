package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* renamed from: kz1  reason: default package */
public final class kz1 implements Runnable {
    public final /* synthetic */ gz1 f;
    public final /* synthetic */ jz1 g;

    public kz1(jz1 jz1, gz1 gz1) {
        this.g = jz1;
        this.f = gz1;
    }

    public final void run() {
        gz1 gz1 = this.f;
        cz1 cz1 = gz1.f1319a;
        Objects.requireNonNull(cz1);
        xe3 xe3 = (xe3) gz1.b(xe3.class);
        if (TextUtils.isEmpty(xe3.b)) {
            xe3.b = cz1.d.g().j0();
        }
        if (cz1.e && TextUtils.isEmpty(xe3.d)) {
            ac3 ac3 = cz1.d;
            ac3.a(ac3.m);
            rb3 rb3 = ac3.m;
            xe3.d = rb3.m0();
            xe3.e = rb3.j0();
        }
        for (mz1 mz1 : this.g.b) {
            mz1.a(this.f);
        }
        gz1 gz12 = this.f;
        gj1.k("deliver should be called from worker thread");
        gj1.c(gz12.c, "Measurement must be submitted");
        List<nz1> list = gz12.k;
        if (!list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (nz1 nz1 : list) {
                Uri l = nz1.l();
                if (!hashSet.contains(l)) {
                    hashSet.add(l);
                    nz1.m(gz12);
                }
            }
        }
    }
}
