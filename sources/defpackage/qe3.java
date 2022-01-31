package defpackage;

import java.util.HashMap;
import java.util.Map;

/* renamed from: qe3  reason: default package */
public final class qe3 extends iz1<qe3> {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, String> f2935a = new HashMap(4);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(qe3 qe3) {
        qe3.f2935a.putAll(this.f2935a);
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, String> entry : this.f2935a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(hj1.x(valueOf.length() + 9, "dimension", valueOf), entry.getValue());
        }
        return iz1.a(hashMap);
    }
}
