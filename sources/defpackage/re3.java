package defpackage;

import java.util.HashMap;
import java.util.Map;

/* renamed from: re3  reason: default package */
public final class re3 extends iz1<re3> {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, Double> f3073a = new HashMap(4);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(re3 re3) {
        re3.f3073a.putAll(this.f3073a);
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, Double> entry : this.f3073a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(hj1.x(valueOf.length() + 6, "metric", valueOf), entry.getValue());
        }
        return iz1.a(hashMap);
    }
}
