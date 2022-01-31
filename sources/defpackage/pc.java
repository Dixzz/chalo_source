package defpackage;

import j$.util.Iterator;
import j$.util.Map;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* renamed from: pc  reason: default package */
/* compiled from: LazyField */
public class pc extends qc {

    /* renamed from: pc$b */
    /* compiled from: LazyField */
    public static class b<K> implements Map.Entry<K, Object>, Map.Entry {
        public Map.Entry<K, pc> f;

        public b(Map.Entry entry, a aVar) {
            this.f = entry;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public K getKey() {
            return this.f.getKey();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getValue() {
            pc value = this.f.getValue();
            if (value == null) {
                return null;
            }
            return value.c();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof dd) {
                pc value = this.f.getValue();
                dd ddVar = value.f2927a;
                value.b = null;
                value.f2927a = (dd) obj;
                return ddVar;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* renamed from: pc$c */
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
            return next.getValue() instanceof pc ? new b(next, null) : next;
        }

        @Override // j$.util.Iterator
        public void remove() {
            this.f.remove();
        }
    }

    public dd c() {
        return a(null);
    }

    @Override // defpackage.qc
    public boolean equals(Object obj) {
        return c().equals(obj);
    }

    @Override // defpackage.qc
    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
