package defpackage;

import com.google.android.gms.common.api.Scope;
import defpackage.x22;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: q42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class q42 extends u42 {
    public final ArrayList<x22.f> g;
    public final /* synthetic */ v42 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q42(v42 v42, ArrayList<x22.f> arrayList) {
        super(v42);
        this.h = v42;
        this.g = arrayList;
    }

    @Override // defpackage.u42
    public final void a() {
        Set<Scope> set;
        v42 v42 = this.h;
        d52 d52 = v42.f3596a.s;
        x72 x72 = v42.r;
        if (x72 == null) {
            set = Collections.emptySet();
        } else {
            HashSet hashSet = new HashSet(x72.b);
            Map<x22<?>, c92> map = v42.r.d;
            for (x22<?> x22 : map.keySet()) {
                if (!v42.f3596a.l.containsKey(x22.b)) {
                    Objects.requireNonNull(map.get(x22));
                    hashSet.addAll(null);
                }
            }
            set = hashSet;
        }
        d52.p = set;
        ArrayList<x22.f> arrayList = this.g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v42 v422 = this.h;
            arrayList.get(i).getRemoteService(v422.o, v422.f3596a.s.p);
        }
    }
}
