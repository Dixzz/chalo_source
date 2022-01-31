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

/* renamed from: vm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class vm2 extends AbstractSet<Map.Entry> implements Set {
    public final /* synthetic */ wm2 f;

    public /* synthetic */ vm2(wm2 wm2) {
        this.f = wm2;
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    @Override // j$.util.Collection, j$.util.Set
    public final void clear() {
        this.f.clear();
    }

    @Override // j$.util.Collection, j$.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value || (obj2 != null && obj2.equals(value))) {
            return true;
        }
        return false;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
    public final Iterator<Map.Entry> iterator() {
        return new um2(this.f);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection, j$.util.Set
    public final boolean remove(Object obj) {
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
    public final int size() {
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
