package defpackage;

import defpackage.mm5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: im5  reason: default package */
/* compiled from: AutomationEngine */
public class im5 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ mm5 h;

    public im5(mm5 mm5, String str, ck5 ck5) {
        this.h = mm5;
        this.f = str;
        this.g = ck5;
    }

    public void run() {
        List<so5> k = this.h.w.k(this.f);
        if (k.isEmpty()) {
            yj5.h("Failed to cancel schedule group: %s", this.f);
            this.g.d(Boolean.FALSE);
            return;
        }
        this.h.w.b(k);
        mm5 mm5 = this.h;
        List singletonList = Collections.singletonList(this.f);
        Objects.requireNonNull(mm5);
        Iterator it = new ArrayList(mm5.r).iterator();
        while (it.hasNext()) {
            mm5.t tVar = (mm5.t) it.next();
            if (singletonList.contains(tVar.n)) {
                tVar.cancel();
                mm5.r.remove(tVar);
            }
        }
        mm5.c(this.h, k);
    }
}
