package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ue3  reason: default package */
public final class ue3 extends iz1<ue3> {

    /* renamed from: a  reason: collision with root package name */
    public final List<az1> f3493a = new ArrayList();
    public final List<bz1> b = new ArrayList();
    public final Map<String, List<az1>> c = new HashMap();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(ue3 ue3) {
        ue3 ue32 = ue3;
        ue32.f3493a.addAll(this.f3493a);
        ue32.b.addAll(this.b);
        for (Map.Entry<String, List<az1>> entry : this.c.entrySet()) {
            String key = entry.getKey();
            for (az1 az1 : entry.getValue()) {
                if (az1 != null) {
                    String str = key == null ? "" : key;
                    if (!ue32.c.containsKey(str)) {
                        ue32.c.put(str, new ArrayList());
                    }
                    ue32.c.get(str).add(az1);
                }
            }
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.f3493a.isEmpty()) {
            hashMap.put("products", this.f3493a);
        }
        if (!this.b.isEmpty()) {
            hashMap.put("promotions", this.b);
        }
        if (!this.c.isEmpty()) {
            hashMap.put("impressions", this.c);
        }
        hashMap.put("productAction", null);
        return iz1.a(hashMap);
    }
}
