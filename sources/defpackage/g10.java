package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* renamed from: g10  reason: default package */
/* compiled from: DialogFeature */
public class g10 implements i20 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, PriorityQueue<rn0>> f1202a = new HashMap();
    public final Map<String, rn0> b = new HashMap();

    @Override // defpackage.i20
    public void a(String str, boolean z) {
        Map<String, rn0> map = this.b;
        if (map != null && map.containsKey(str)) {
            this.b.remove(str);
            if (z) {
                c(str);
            }
        }
    }

    @Override // defpackage.i20
    public void b(String str, rn0 rn0) {
        Map<String, PriorityQueue<rn0>> map = this.f1202a;
        if (map != null) {
            if (!map.containsKey(str) || this.f1202a.get(str) == null) {
                this.f1202a.put(str, new PriorityQueue<>());
            }
            this.f1202a.get(str).add(rn0);
            c(str);
        }
    }

    public void c(String str) {
        PriorityQueue<rn0> priorityQueue;
        Map<String, rn0> map = this.b;
        if (map != null && this.f1202a != null && !map.containsKey(str) && (priorityQueue = this.f1202a.get(str)) != null && priorityQueue.size() > 0) {
            this.b.put(str, priorityQueue.poll());
            try {
                om0 om0 = this.b.get(str).g;
                if (om0 != null) {
                    om0.a();
                }
            } catch (IllegalStateException e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
                this.b.remove(str);
                c(str);
            }
        }
    }
}
