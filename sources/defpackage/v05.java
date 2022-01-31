package defpackage;

import j$.util.Iterator;
import j$.util.Map;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* renamed from: v05  reason: default package */
/* compiled from: LazyField */
public class v05 extends w05 {

    /* renamed from: v05$b */
    /* compiled from: LazyField */
    public static class b<K> implements Map.Entry<K, Object>, Map.Entry {
        public Map.Entry<K, v05> f;

        public b(Map.Entry entry, a aVar) {
            this.f = entry;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public K getKey() {
            return this.f.getKey();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getValue() {
            v05 value = this.f.getValue();
            if (value == null) {
                return null;
            }
            return value.c();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof j15) {
                v05 value = this.f.getValue();
                j15 j15 = value.f3703a;
                value.b = null;
                value.f3703a = (j15) obj;
                return j15;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* renamed from: v05$c */
    /* compiled from: LazyField */
    public static class c<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {
        public Iterator<Map.Entry<K, Object>> f;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f = it;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext();
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            Map.Entry<K, Object> next = this.f.next();
            return next.getValue() instanceof v05 ? new b(next, null) : next;
        }

        @Override // j$.util.Iterator
        public void remove() {
            this.f.remove();
        }
    }

    public j15 c() {
        return a(null);
    }

    @Override // defpackage.w05
    public boolean equals(Object obj) {
        return c().equals(obj);
    }

    @Override // defpackage.w05
    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
