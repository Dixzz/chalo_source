package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ax3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class ax3 extends AbstractSet<Map.Entry<K, V>> implements Set {
    public final /* synthetic */ rw3 f;

    public ax3(rw3 rw3, tw3 tw3) {
        this.f = rw3;
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    @Override // j$.util.Collection, j$.util.Set
    public void clear() {
        this.f.clear();
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new xw3(this.f, null);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection, j$.util.Set
    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f.remove(entry.getKey());
        return true;
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.Collection, j$.util.Set
    public int size() {
        return this.f.size();
    }

    @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Set.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }
}
