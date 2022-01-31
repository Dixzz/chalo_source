package defpackage;

import com.google.android.gms.common.ConnectionResult;
import defpackage.x22;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: p42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class p42 extends u42 {
    public final Map<x22.f, m42> g;
    public final /* synthetic */ v42 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p42(v42 v42, Map<x22.f, m42> map) {
        super(v42);
        this.h = v42;
        this.g = map;
    }

    @Override // defpackage.u42
    @GuardedBy("mLock")
    public final void a() {
        ni4 ni4;
        m92 m92 = new m92(this.h.d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (x22.f fVar : this.g.keySet()) {
            if (!fVar.requiresGooglePlayServices() || this.g.get(fVar).c) {
                arrayList2.add(fVar);
            } else {
                arrayList.add(fVar);
            }
        }
        int i = -1;
        int i2 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i2 < size) {
                i = m92.a(this.h.c, (x22.f) arrayList2.get(i2));
                i2++;
                if (i == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i2 < size2) {
                i = m92.a(this.h.c, (x22.f) arrayList.get(i2));
                i2++;
                if (i != 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i, null);
            v42 v42 = this.h;
            h52 h52 = v42.f3596a;
            h52.j.sendMessage(h52.j.obtainMessage(1, new n42(this, v42, connectionResult)));
            return;
        }
        v42 v422 = this.h;
        if (v422.m && (ni4 = v422.k) != null) {
            ni4.c();
        }
        for (x22.f fVar2 : this.g.keySet()) {
            m42 m42 = this.g.get(fVar2);
            if (!fVar2.requiresGooglePlayServices() || m92.a(this.h.c, fVar2) == 0) {
                fVar2.connect(m42);
            } else {
                v42 v423 = this.h;
                h52 h522 = v423.f3596a;
                h522.j.sendMessage(h522.j.obtainMessage(1, new o42(v423, m42)));
            }
        }
    }
}
