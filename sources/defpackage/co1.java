package defpackage;

import defpackage.ho1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: co1  reason: default package */
/* compiled from: GroupedLinkedMap */
public class co1<K extends ho1, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f587a = new a<>(null);
    public final Map<K, a<K, V>> b = new HashMap();

    /* renamed from: co1$a */
    /* compiled from: GroupedLinkedMap */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f588a;
        public List<V> b;
        public a<K, V> c;
        public a<K, V> d;

        public a() {
            this(null);
        }

        public V a() {
            List<V> list = this.b;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.b.remove(size - 1);
            }
            return null;
        }

        public a(K k) {
            this.d = this;
            this.c = this;
            this.f588a = k;
        }
    }

    public V a(K k) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        a<K, V> aVar2 = aVar.d;
        aVar2.c = aVar.c;
        aVar.c.d = aVar2;
        a<K, V> aVar3 = this.f587a;
        aVar.d = aVar3;
        a<K, V> aVar4 = aVar3.c;
        aVar.c = aVar4;
        aVar4.d = aVar;
        aVar.d.c = aVar;
        return aVar.a();
    }

    public void b(K k, V v) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            a<K, V> aVar2 = aVar.d;
            aVar2.c = aVar.c;
            aVar.c.d = aVar2;
            a<K, V> aVar3 = this.f587a;
            aVar.d = aVar3.d;
            aVar.c = aVar3;
            aVar3.d = aVar;
            aVar.d.c = aVar;
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        if (aVar.b == null) {
            aVar.b = new ArrayList();
        }
        aVar.b.add(v);
    }

    public V c() {
        for (a<K, V> aVar = this.f587a.d; !aVar.equals(this.f587a); aVar = aVar.d) {
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            a<K, V> aVar2 = aVar.d;
            aVar2.c = aVar.c;
            aVar.c.d = aVar2;
            this.b.remove(aVar.f588a);
            aVar.f588a.a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f587a.c; !aVar.equals(this.f587a); aVar = aVar.c) {
            z = true;
            sb.append('{');
            sb.append((Object) aVar.f588a);
            sb.append(':');
            List<V> list = aVar.b;
            sb.append(list != null ? list.size() : 0);
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
